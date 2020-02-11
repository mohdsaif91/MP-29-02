package Modal;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author saif
 */
@Data
public class AllDataPojo {

    List<adminordertable> adminlist = new ArrayList<>();
    List<PaymentPojo> paylist = new ArrayList<>();

}
