package packAutostrada;

import lombok.Data;


public enum CarType {

    TRUCk(5),
    CAR(2),
    MOTORCYCLE(1);

    private int oplata;

    CarType(int oplata) {
        this.oplata = oplata;
    }

    public int getOplata() {
        return oplata;
    }
}
