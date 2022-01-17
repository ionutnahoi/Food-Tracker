package Proiect;

public class User {
    private String username;
    private String nume;
    private String email;
    private String activitate;
    private String scop;
    private String sex;
    private String tara;
    private int varsta;
    private int slabit_saptamanal;
    private int ingrasat_saptamanal;

    private int inaltime, greutate, greutate_dorita;

    public String getSex() {
        return sex;
    }


    public enum BMI {
        under,
        normal,
        over,
        obese,
        obese_extreme
    }

    public User(String nume, String email, String activitate, String scop, String sex, String tara, int varsta, int slabit_saptamanal, int ingrasat_saptamanal, int inaltime, int greutate, int greutate_dorita) {
        this.nume = nume;
        this.email = email;
        this.activitate = activitate;
        this.scop = scop;
        this.sex = sex;
        this.tara = tara;
        this.varsta = varsta;
        this.slabit_saptamanal = slabit_saptamanal;
        this.ingrasat_saptamanal = ingrasat_saptamanal;
        this.inaltime = inaltime;
        this.greutate = greutate;
        this.greutate_dorita = greutate_dorita;
    }

    public User() {
        this.nume = null;
        this.email = null;
        this.varsta = 0;
        this.inaltime = 0;
        this.greutate = 0;
        this.greutate_dorita = 0;
        this.activitate = null;
        this.scop = null;
        this.sex = null;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivitate() {
        return activitate;
    }

    public void setActivitate(String activitate) {
        this.activitate = activitate;
    }

    public String getScop() {
        return scop;
    }

    public void setScop(String scop) {
        this.scop = scop;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getSlabit_saptamanal() {
        return slabit_saptamanal;
    }

    public void setSlabit_saptamanal(int slabit_saptamanal) {
        this.slabit_saptamanal = slabit_saptamanal;
    }

    public int getIngrasat_saptamanal() {
        return ingrasat_saptamanal;
    }

    public void setIngrasat_saptamanal(int ingrasat_saptamanal) {
        this.ingrasat_saptamanal = ingrasat_saptamanal;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public int getGreutate_dorita() {
        return greutate_dorita;
    }

    public void setGreutate_dorita(int greutate_dorita) {
        this.greutate_dorita = greutate_dorita;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", varsta=" + varsta +
                ", inaltime=" + inaltime +
                ", greutate=" + greutate +
                ", greutate_dorita=" + greutate_dorita +
                '}';
    }
}
