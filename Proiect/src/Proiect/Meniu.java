package Proiect;

import java.util.ArrayList;
import java.util.List;

public class Meniu {
    List<Aliment> aliemnte_consumate = new ArrayList<>();
    List<Aliment> aliemnte_recomandate;
    Masa masa;

    public enum Masa {
        MicDejun,
        Pranz,
        Cina
    }

    public Meniu(List<Aliment> aliemnte_recomandate, Masa masa) {
        this.aliemnte_recomandate = aliemnte_recomandate;
        this.masa = masa;
    }


    @Override
    public String toString() {
        return "Meniu{" +
                "aliemnte_recomandate=" + aliemnte_recomandate +
                '}';
    }
}
