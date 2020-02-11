/*
 * 
 * CopyRight cosmos
 */
package Modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author saif
 */
@Data
@Entity
@Table(name = "usernameandpassword")
public class signuppojo2 {

    @Id
    @GeneratedValue
    @JoinColumn(name = "pkey_id")
    int fkey_id;
    String useraname;
    String password;

}
