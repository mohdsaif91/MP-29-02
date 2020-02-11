/*
 * 
 * CopyRight cosmos
 */

import Modal.contactPojo;
import Modal.signuppojo2;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author saif
 */
public class Contact extends HttpServlet {

    String ans = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(signuppojo2.class);
        ServiceRegistry sreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sfac = conf.buildSessionFactory(sreg);
        Session hsession = sfac.openSession();
        Query qu = hsession.createQuery("select useraname from signuppojo2 where useraname='" + uname + "'");
        List<String> namelist = qu.list();
        namelist.forEach(s -> {
            System.out.println(s);
            if (s.equals(uname)) {
                ans = "yes";
            } else if (s == null) {
                ans = "no";
            } else {
                ans = "no";
            }
        });
        hsession.close();
        response.setContentType("text/plain");
        response.getWriter().write(ans);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("c_fname");
        String lastname = request.getParameter("c_lname");
        String email = request.getParameter("c_email");
        String subject = request.getParameter("c_subject");
        String username = request.getParameter("c_username");
        String message = request.getParameter("c_message");
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(contactPojo.class);
        ServiceRegistry sreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sfac = conf.buildSessionFactory(sreg);
        Session hsession = sfac.openSession();
        Transaction tran = hsession.beginTransaction();
        contactPojo cp = new contactPojo();
        cp.setFirstname(fname);
        cp.setLastname(lastname);
        cp.setEmail(email);
        cp.setUsername(username);
        cp.setSubject(subject);
        cp.setMessage(message);
        cp.setRead("no");

        hsession.save(cp);
        tran.commit();
        hsession.close();
        response.sendRedirect("contact.jsp");
    }

}
