/*
 * 
 * CopyRight cosmos
 */

import Modal.Cartpojo;
import Modal.orderpojo;
import Modal.signuppojo;
import Modal.signuppojo2;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class BuyNow extends HttpServlet {

    String username;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        username = request.getParameter("username");
        session = request.getSession();
        session.setAttribute("username", username);
        String password = request.getParameter("passsword");
        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(signuppojo.class);
        conf.addAnnotatedClass(signuppojo2.class);
        conf.addAnnotatedClass(orderpojo.class);
        conf.addAnnotatedClass(Cartpojo.class);
        ServiceRegistry sreg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sfac = conf.buildSessionFactory(sreg);
        Session hsession = sfac.openSession();
        signuppojo sp = new signuppojo();
        sp.setFirstname(firstname);
        sp.setLastname(lastname);
        Transaction tran = hsession.beginTransaction();
        hsession.save(sp);
        tran.commit();
        hsession.close();
        //second table username and password
        Session sess2 = sfac.openSession();
        signuppojo2 s2 = new signuppojo2();
        s2.setUseraname(username);
        s2.setPassword(password);
        sess2.save(s2);
        Transaction tran2 = sess2.beginTransaction();
        tran2.commit();
        sess2.close();
        //ordertabe
        createOrdertable(username);
        response.sendRedirect("homeController");

    }

    private void createOrdertable(String tbname) {
        try {
            String query = "create table " + tbname + "(id serial,productid text,companyname text,price text,packaging text,"
                    + "quantity integer,productname text,show text,image text)";
            System.out.println(query);
            con = ConnectionClass.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuyNow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
