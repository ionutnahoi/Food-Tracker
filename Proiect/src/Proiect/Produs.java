package Proiect;

public class Produs extends Aliment {
    int cantitate, portie;

    public Produs(String nume, double valoare_energetica, double grasimi, double glucide, double fibre, double proteine, double sare, int cantitate1, int portie) {
        super(nume, valoare_energetica, grasimi, glucide, fibre, proteine, sare);
        this.cantitate = cantitate1;
        this.portie = portie;
    }


    @Override
    public String toString() {
        return "Produs{" +
                "nume='" + nume + '\'' +
                ", valoare_energetica=" + valoare_energetica +
                ", grasimi=" + grasimi +
                ", glucide=" + glucide +
                ", fibre=" + fibre +
                ", proteine=" + proteine +
                ", sare=" + sare +
                ", cantitate=" + cantitate +
                ", cantitate=" + cantitate +
                ", portie=" + portie +
                '}';
    }
}
