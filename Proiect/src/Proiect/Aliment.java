package Proiect;

public class Aliment {
    String nume;
    double valoare_energetica, grasimi, glucide, fibre, proteine, sare;

    public Aliment(String nume, double valoare_energetica, double grasimi, double glucide, double fibre, double proteine, double sare) {
        this.nume = nume;
        this.valoare_energetica = valoare_energetica;
        this.grasimi = grasimi;
        this.glucide = glucide;
        this.fibre = fibre;
        this.proteine = proteine;
        this.sare = sare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getValoare_energetica() {
        return valoare_energetica;
    }

    public void setValoare_energetica(double valoare_energetica) {
        this.valoare_energetica = valoare_energetica;
    }

    public double getGrasimi() {
        return grasimi;
    }

    public void setGrasimi(double grasimi) {
        this.grasimi = grasimi;
    }

    public double getGlucide() {
        return glucide;
    }

    public void setGlucide(double glucide) {
        this.glucide = glucide;
    }

    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }

    public double getProteine() {
        return proteine;
    }

    public void setProteine(double proteine) {
        this.proteine = proteine;
    }

    public double getSare() {
        return sare;
    }

    public void setSare(double sare) {
        this.sare = sare;
    }


    @Override
    public String toString() {
        return "Aliment{" +
                "nume='" + nume + '\'' +
                ", valoare_energetica=" + valoare_energetica +
                ", grasimi=" + grasimi +
                ", glucide=" + glucide +
                ", fibre=" + fibre +
                ", proteine=" + proteine +
                ", sare=" + sare +
                '}';
    }
}
