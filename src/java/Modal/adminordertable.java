package Modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "adminordertable")
public class adminordertable {

    @Id
    public String id;
    String productid;
    String productprice;
    String quantity;
    String imagename;
    String companyname;
    String packaging;
    String brandname;
//    public String userid;
    String genericname;
    public String firstname;
    public String lastname;
    public String username;
    public String address1;
    public String address2;
    public String mobilenum;
    public Date yyyy_mm_dd;
    public String city;
    public String state;
    public String country;
    String paymentdoen;
    Date paymade;
    String zipcode;

//    int 
    public static List<adminordertable> getAllColumn(ResultSet rs) {
        List<adminordertable> admiList = new ArrayList<>();
        admiList.clear();
        try {
            while (rs.next()) {
                adminordertable ad = new adminordertable();
                ad.id = rs.getString("id");
                ad.address1 = rs.getString("address1");
                ad.address2 = rs.getString("address2");
                ad.brandname = rs.getString("brandname");
                ad.city = rs.getString("city");
                ad.companyname = rs.getString("companyname");
                ad.country = rs.getString("country");
                ad.firstname = rs.getString("firstname");
                ad.genericname = rs.getString("genericname");
                ad.imagename = rs.getString("imagename");
                ad.lastname = rs.getString("lastname");
                ad.mobilenum = rs.getString("mobilenum");
                ad.packaging = rs.getString("packaging");
                ad.paymade = rs.getDate("paymade");
                ad.paymentdoen = rs.getString("paymentdoen");
                ad.productid = rs.getString("productid");
                ad.productprice = rs.getString("productprice");
                ad.quantity = rs.getString("quantity");
                ad.state = rs.getString("state");
                ad.username = rs.getString("username");
                ad.yyyy_mm_dd = rs.getDate("yyyy_mm_dd");
                ad.zipcode = rs.getString("zipcode");
                admiList.add(ad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminordertable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admiList;
    }
}
