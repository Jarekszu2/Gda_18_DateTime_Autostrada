package packAutostrada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAutostradaParser {
    public static void main(String[] args) {
        System.out.println();

        List<VehicleInfo> vehicleInfoList = new ArrayList<>();
        Highway highway = new Highway(vehicleInfoList);

        System.out.println("Aplikacja autostradowa:");
        Scanner scanner = new Scanner(System.in);

        char komenda = 'a';
        do {
            System.out.println();
            System.out.println("Podaj komendę:\na: wjazd na autostradę\nb: sprawdzenie pojazdu\nc: wyjazd z autostrady\nw: wyjście");
            komenda = scanner.next().charAt(0);

            switch (komenda) {
                case 'a':
                    System.out.println("Wjazd na autostradę. Podaj nr rejestracyjny pojazdu:");
                    String nrRejestracyjny = scanner.next();

                    System.out.println("Wybierz typ pojazdu:\na: CAR\nb: TRUCK\nc: MOTORCYCLE");
                    char warunekTyp = 'a';
                    CarType carType = CarType.CAR;
                    do {
                        System.out.println();
                        System.out.println("Podaj a, b lub c.");
                        warunekTyp = scanner.next().charAt(0);
                        switch (warunekTyp) {
                            case 'a':
                                carType = CarType.CAR;
                                try {
                                    highway.vehicleEntry(nrRejestracyjny, carType);
                                } catch (VehicleAlreadyOnHighwayException e) {
                                    System.out.println(e.getMessage());
                                }
                                warunekTyp = 'w';
                                break;
                            case 'b':
                                carType = CarType.TRUCk;
                                try {
                                    highway.vehicleEntry(nrRejestracyjny, carType);
                                } catch (VehicleAlreadyOnHighwayException e) {
                                    System.out.println(e.getMessage());
                                }
                                warunekTyp = 'w';
                                break;
                            case 'c':
                                carType = CarType.MOTORCYCLE;
                                try {
                                    highway.vehicleEntry(nrRejestracyjny, carType);
                                } catch (VehicleAlreadyOnHighwayException e) {
                                    System.out.println(e.getMessage());
                                }
                                warunekTyp = 'w';
                                break;
                            default:
                                if (warunekTyp != 'w') {
                                    System.out.println("Wybierz: a, b lub c!");
                                }
                                break;
                        }
                    } while (warunekTyp != 'w');
                    break;
                case 'b':
                    System.out.println("Sprawdzanie samochodu. Podaj nr rejestracyjny:");
                    String nrRejestracyjnySprawdzanie = scanner.next();
                    highway.serchVehicle(nrRejestracyjnySprawdzanie);
                    break;
                case 'c':
                    System.out.println("Wyjazd z autostrady. Podaj nr Rejestracyjny:");
                    String nrRejestracyjnyWyjazd = scanner.next();
                    highway.vehicleLeave(nrRejestracyjnyWyjazd);
                default:
                    if (komenda != 'w') {
                        System.out.println("Wybierz: a, b, c lub w!");
                    }
            }
        } while (komenda != 'w');
    }
}
