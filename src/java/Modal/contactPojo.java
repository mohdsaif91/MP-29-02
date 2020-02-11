/*
 * 
 * CopyRight cosmos
 */
package Modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author saif
 */
@Data
@Entity
@Table(name = "contactpojo")
public class contactPojo {

    @Id
    @GeneratedValue
    int id;
    String firstname;
    String lastname;
    String email;
    String subject;
    String message;
    String username;
    String read;

    public static List<contactPojo> getList(ResultSet rs) throws SQLException {
        List<contactPojo> clist = new ArrayList<>();
        clist.clear();
        while (rs.next()) {
            contactPojo cp = new contactPojo();
            cp.username = rs.getString("username");
            cp.subject = rs.getString("subject");
            cp.id = rs.getInt("id");
            cp.firstname = rs.getString("firstname");
            cp.lastname = rs.getString("lastname");
            cp.message = rs.getString("message");
            cp.read = rs.getString("read");
            cp.email = rs.getString("email");
            clist.add(cp);
        }
        return clist;
    }
}
