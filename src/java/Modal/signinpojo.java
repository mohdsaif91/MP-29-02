package Modal;


import javax.persistence.Entity;
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
@Data
@Entity
@Table(name = "usernameandpassword")
public class signinpojo {

    @Id
    int id;
    String username;
    String password;
}
