package packAutostrada;

import java.util.ArrayList;
import java.util.List;

public class MainAutostrada {
    public static void main(String[] args) {
        System.out.println();

        List<VehicleInfo> vehicleInfoList = new ArrayList<>();

        Highway highway = new Highway(vehicleInfoList);
        try {
            highway.vehicleEntry("1", CarType.CAR);
        } catch (VehicleAlreadyOnHighwayException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            highway.vehicleEntry("1", CarType.CAR);
        } catch (VehicleAlreadyOnHighwayException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        highway.serchVehicle("1");

        System.out.println();
        highway.serchVehicle("2");

        System.out.println();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        highway.vehicleLeave("1");

        System.out.println();
        highway.vehicleLeave("2");

        System.out.println();
        System.out.println();
        try {
            highway.vehicleEntry("2", CarType.TRUCk);
        } catch (VehicleAlreadyOnHighwayException e) {
            System.out.println(e.getMessage());
        }

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        highway.vehicleLeave("2");
    }
}
