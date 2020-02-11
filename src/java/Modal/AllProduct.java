/*
 * 
 * CopyRight cosmos
 */
package Modal;

import javax.persistence.Column;
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
@Table(name = "producttable")
public class AllProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String imagename;
    @Column(name = "productdescription", length = 1024)
    String productdescription;
    String productprice;
    String brandname;
    String genericname;
    String packaging;
    String company;
}
