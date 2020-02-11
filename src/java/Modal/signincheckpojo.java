package Modal;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usernameandpassword")
public class signincheckpojo implements Serializable {

    @Id
    int fkey_id;
    String useraname;
    String password;

}
