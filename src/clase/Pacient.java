package clase;

import clase.Persoana;

public class Pacient extends Persoana {
    String descriere;
    String doctor;

    public Pacient(String prenume, String nume, int anNastere, String descriere, String doctor) {
        super(prenume, nume, anNastere);
        this.descriere = descriere;
        this.doctor = doctor;
    }

    public Pacient( String descriere, String doctor) {
        super();
        descriere ="";
        doctor ="";
    }

    public String getDescriere() {
        return descriere;
    }

    public String getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return
                "Prenume='" + prenume + '\'' +
                ", Nume='" + nume + '\'' +
                ", An Nastere=" + anNastere +
                " Descriere='" + descriere + '\'' +
                ", Doctor='" + doctor + '\''

                +"\n";
    }
}
