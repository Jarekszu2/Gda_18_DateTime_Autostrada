package packAutostrada;

public class VehicleAlreadyOnHighwayException extends Exception {
    public VehicleAlreadyOnHighwayException() {
        super("Ten pojazd już jest na autostradzie!");
    }
}
