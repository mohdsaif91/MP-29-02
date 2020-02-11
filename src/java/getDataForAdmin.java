/*
 * 
 * CopyRight cosmos
 */

import Modal.PackagePojo;
import Modal.adminordertable;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author saif
 */
public class getDataForAdmin extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PackagePojo> adminList = new ArrayList<>();
        String searchBy = request.getParameter("searchby");
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(PackagePojo.class);
        ServiceRegistry sreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sfac = conf.buildSessionFactory(sreg);
        Session hses = sfac.openSession();
        switch (searchBy) {
            case "orderid": {
                String orderid = request.getParameter("data");
                Query query = hses.createQuery("from PackagePojo where id='" + orderid + "'");
                adminList = query.list();
                hses.close();
                break;
            }
            case "brandname": {
                String orderid = request.getParameter("data");
                Query query = hses.createQuery("from PackagePojo where brandname='" + orderid + "'");
                adminList = query.list();
                hses.close();
                break;
            }
            case "companyname": {
                String orderid = request.getParameter("data");
                Query query = hses.createQuery("from PackagePojo where companyname='" + orderid + "'");
                System.out.println(query);
                adminList = query.list();
                hses.close();
                break;
            }
            default: {
                String orderid = request.getParameter("data");
                Query query = hses.createQuery("from PackagePojo where firstname='" + orderid + "'");
                adminList = query.list();
                hses.close();
                break;
            }
        }
        Gson gs = new Gson();
        JsonElement je = gs.toJsonTree(adminList, new TypeToken<List<PackagePojo>>() {
        }.getType());
        JsonArray ja = je.getAsJsonArray();
        hses.close();
        System.out.println(searchBy);
        response.setContentType("application/json");
        response.getWriter().print(ja);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
