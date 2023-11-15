package API.BillProvidor;

import java.util.ArrayList;
import java.util.List;

public class ProvidorsList {
    public final static List<ProvidorAPI> BILL_PROVIDORS = new ArrayList<>() {
        {
            add(new GasProvidor());
        }
        {
            add(new WaterProvidor());
        }
        {
            add(new ElectricityProvidor());
        }
    };

}
