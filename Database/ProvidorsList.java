package Database;

import java.util.ArrayList;
import java.util.List;

import API.BillProvidor.ElectricityProvidor;
import API.BillProvidor.GasProvidor;
import API.BillProvidor.ProvidorAPI;
import API.BillProvidor.WaterProvidor;

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
