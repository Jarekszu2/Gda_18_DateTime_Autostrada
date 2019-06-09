package packAutostrada;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class VehicleInfo {

    private String nrRejestracyjny;
    private CarType typPojazdu;
    private LocalDateTime dataICzasWjazdu;

    // public VehicleInfo(String nrRejestracyjny, CarType typPojazdu) {
    //     this.nrRejestracyjny = nrRejestracyjny;
    //     this.typPojazdu = typPojazdu;
    //     this.dataICzasWjazdu = null;
    // }
}
