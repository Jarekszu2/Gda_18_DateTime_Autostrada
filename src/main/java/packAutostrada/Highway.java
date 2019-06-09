package packAutostrada;

/*
Stwórz aplikację Autodstrada. Celem zadania będzie implementacja systemu autostrady. Do tej implementacji będzie nam potrzebny klasa Highway która reprezentuje autostradę, oraz klasa VehicleInfo która reprezentuje zbiór informacji o pojeździe - tam będziemy przechowywać takie dane jak jego rejestracja, jego typ(ciezarowka czy osobowy) i datę i godzinę wjazdu - po której będziemy rozliczać pojazdy wyjezdzające z autostrady.
1. Stwórz enum CarType, który posiada typy TRUCK, CAR, MOTORCYCLE.
2. Stwórz klasę VehicleInfo, która powinna posiadać numer rejestracyjny pojazdu (String), typ pojazdu (CarType), oraz datę WJAZDU na autostradę.
3. Stwórz klasę Highway która będzie posiadać :
    - kolekcję wszystkich pojazdów
    - metodę vehicleEntry(String numer_rejestracyjny, oraz CarType type) - która dodaje do kolekcji nową instancję VehicleInfo oraz wypisuje do konsoli komunikat. Metoda nic nie zwraca.
    - metodę searchVehicle(String numer_rejestracyjny) - która szuka pojazdu i wypisuje jego informacje jeśli wciąż znajduje się na autostradzie
    - metodę wyjazdu - vehicleLeave(String numer_rejestracyjny) - która usuwa samochód z kolekcji, wypisuje komunikat, oraz na podstawie czasu jaki samochód znajdował się na autostradzie oblicza jej kwotę do zapłaty i wypisuje ją do konsoli.
Przyjmij pewną stałą kwotę do zapłaty za czas spędzony na autostradzie. Jest to zabawna autostrada, bo zachęca do szybkiej jazdy. Im szybciej wyjedziemy tym mniej zapłacimy.
4. Stwórz main który przyjmuje komendy
- wjazd NR_REJESTRACYJNY TYP
- wyjazd NR_REJESTRACYJNY
- sprawdz NR_REJESTRACYJNY
i wykonuje odpowiednie akcje na instancji klasy highway.
UWAGI:
- kwota naliczania powinna być od każdej sekundy spędzonej na autostradzie.
- zwróć uwagę że czas wjazdu powinien być ustawiany w momencie wjazdu
- NA AUTOSTRADZIE NIE POWINIEN SIĘ ZNAJDOWAĆ DRUGI SAMOCHÓD O TEJ SAMEJ REJESTRACJI. Jeśli samochód o pewnej rejestracji wjechał już na autostradę rzuć Exception. Stwórz własny exception, nazwij go "VehicleAlreadyOnHighwayException". Niech jest to wyjątek niejawny.
- kwota naliczania dla samochodów osobowych i ciężarówek powinna być inna.
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data

public class Highway {

    List<VehicleInfo> vehicleInfoList;

    public void vehicleEntry(String nrRejestracyjny, CarType typPojazdu) throws VehicleAlreadyOnHighwayException {
        // boolean jestNaAutostradzie = false;
        for (VehicleInfo element : vehicleInfoList) {
            if (element.getNrRejestracyjny().equals(nrRejestracyjny)) {
                // jestNaAutostradzie = true;
                throw new VehicleAlreadyOnHighwayException();
            }
        }
        LocalDateTime localDateTimeWjazd = LocalDateTime.now();
        vehicleInfoList.add(new VehicleInfo(nrRejestracyjny, typPojazdu, localDateTimeWjazd));
        System.out.println("Na autostradę wjechał pojazd:\nnr rejestracyjny: " + nrRejestracyjny +
                "\ntyp pojazdu: " + typPojazdu + "\nczas wjazdu: " + localDateTimeWjazd.getMinute() + ":" + localDateTimeWjazd.getSecond());
    }

    public void serchVehicle(String nrRejestracyjny) {
        boolean jestNaAutostradzie = false;
        for (VehicleInfo element : vehicleInfoList) {
            if (element.getNrRejestracyjny().equals(nrRejestracyjny)) {
                System.out.println("Pojazd: " + nrRejestracyjny + " jest na autostradzie");
                jestNaAutostradzie = true;
            }
        }
        if (!jestNaAutostradzie) {
            System.out.println("Pojazdu o nr rejestracyjnym: " + nrRejestracyjny + " nie ma na autostradzie!");
        }
    }

    public void vehicleLeave(String nrRejestracyjny) {
        boolean bylNaAutostradzie = false;
        for (int i = 0; i < vehicleInfoList.size(); i++) {
            if (vehicleInfoList.get(i).getNrRejestracyjny().equals(nrRejestracyjny)) {
                long wjazdMinuty = vehicleInfoList.get(i).getDataICzasWjazdu().getMinute();
                // System.out.println("wjazd minuty: " + wjazdMinuty);
                long wjazdSekundy = vehicleInfoList.get(i).getDataICzasWjazdu().getSecond();
                // System.out.println("wjazd sekundy: " + wjazdSekundy);
                int oplata = vehicleInfoList.get(i).getTypPojazdu().getOplata();
                vehicleInfoList.remove(i);
                i--;
                bylNaAutostradzie = true;

                System.out.println();
                LocalDateTime localDateTimeWyjazd = LocalDateTime.now();
                System.out.println("Pojazd opuścił autostradę: \nnr rejestracyjny: " + nrRejestracyjny +
                        "\nczas wyjazdu: " + localDateTimeWyjazd.getMinute() + ":" + localDateTimeWyjazd.getSecond());
                long wyjazdMinuty = localDateTimeWyjazd.getMinute();
                long wyjazdSekundy = localDateTimeWyjazd.getSecond();
                long kosztPrzejazdu = ((wyjazdMinuty - wjazdMinuty) * 60 + wyjazdSekundy - wjazdSekundy) * oplata;
                System.out.println();
                System.out.println("koszt przejazdu autostradą: " + kosztPrzejazdu);
            }
        }
        if (!bylNaAutostradzie) {
            System.out.println("Takiego pojazdu nie było na autostradzie!");
        }
    }
}
