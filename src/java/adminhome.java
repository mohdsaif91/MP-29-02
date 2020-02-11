/*
 * 
 * CopyRight cosmos
 */

import Modal.MainCompany;
import java.io.IOException;
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
public class adminhome extends HttpServlet {
//

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MainCompany.class);
        ServiceRegistry sreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sfac = conf.buildSessionFactory(sreg);
        Session hsession = sfac.openSession();
        Query q = hsession.createQuery("from MainCompany");
        List<MainCompany> li = q.list();
        hsession.close();
        request.setAttribute("companyname", li);
        request.getRequestDispatcher("adminhome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
