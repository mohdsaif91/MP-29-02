package Modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/*
 * 
 * CopyRight cosmos
 */
/**
 * @author saif
 */
@Entity
@Table(name = "MainCompany")
@Data
public class MainCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String companyname;
    String companyImageName;

    public static List<MainCompany> getCate(ResultSet rs) throws SQLException {
        List<MainCompany> li = new ArrayList<>();
        li.clear();
        while (rs.next()) {
            MainCompany mc = new MainCompany();
            mc.id = rs.getInt("id");
            mc.companyname = rs.getString("companyname");
            mc.companyImageName = rs.getString("companyimageName");
            li.add(mc);
        }
        return li;
    }

    public static List<MainCompany> getCate2(ResultSet rs) throws SQLException {
        List<MainCompany> li = new ArrayList<>();
        li.clear();
        while (rs.next()) {
            MainCompany mc = new MainCompany();
            mc.companyname = rs.getString("companyname");
            li.add(mc);
        }
        return li;
    }
}
