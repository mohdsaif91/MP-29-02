/*
 * 
 * CopyRight cosmos
 */
package Modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author saif
 */
@Data
@Entity
@Table(name = "cartpojo")
public class Cartpojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String productid;
    String brandname;
    String productprice;
    String genericname;
    String medeidescription;
    String packagig;
    String imagename;
    String tablename;
    String quantity;

    public static List<Cartpojo> getCart(ResultSet rs) {
        List<Cartpojo> clist = new ArrayList<>();
        try {
            clist.clear();
            while (rs.next()) {
                Cartpojo cp = new Cartpojo();
                cp.id = rs.getInt("id");
                cp.imagename = rs.getString("image");
                cp.brandname = rs.getString("productname");
                cp.productprice = rs.getString("price");
                cp.quantity = rs.getString("quantity");
                cp.productid = rs.getString("productid");
                cp.tablename = rs.getString("companyname");
                clist.add(cp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cartpojo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clist;
    }
}
