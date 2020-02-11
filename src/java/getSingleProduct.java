/*
 * 
 * CopyRight cosmos
 */

import Modal.AllProduct;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
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
import org.json.JSONArray;

/**
 *
 * @author saif
 */
public class getSingleProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AllProduct> alllist = new ArrayList<>();
        String onchangetext = request.getParameter("text");
        String ogstring = onchangetext.replaceAll(" ", "");
        String ogtext = ogstring.toUpperCase();
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(AllProduct.class);
        ServiceRegistry sreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sfac = conf.buildSessionFactory(sreg);
        Session hses = sfac.openSession();
        Query query = hses.createQuery("from AllProduct where brandname='" + ogtext + "'");
        System.out.println(query);
        alllist = query.list();
        hses.close();
        if (alllist.isEmpty()) {
            response.getWriter().write("No Product Found !");
        } else {
            Gson gson = new Gson();
            JsonElement jelement = gson.toJsonTree(alllist, (Type) new TypeToken<List<AllProduct>>() {
            }.getType());
            JsonArray ja = jelement.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(ja);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
