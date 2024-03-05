package clase;

import clase.Persoana;

import java.util.ArrayList;
import java.util.List;

public class Medic extends Persoana{
    String specializare;
    String facultate;

    List<Persoana> pacienti;


    public Medic(String prenume, String nume, int anNastere, String specializare, String facultate, List<Persoana> pacienti) {
        super(prenume, nume, anNastere);
        this.specializare = specializare;
        this.facultate = facultate;
        this.pacienti = pacienti;
    }

    public Medic( String specializare, String facultate, List<Persoana> pacienti) {
        super();
        specializare = "";
        facultate = "";
        pacienti = new ArrayList<>();
    }

    public String getSpecializare() {
        return specializare;
    }

    public String getFacultate() {
        return facultate;
    }

    public List<Persoana> getPacienti() {
        return pacienti;
    }

    @Override
    public String toString() {
        String rez="{" +
                "Prenume='" + prenume + '\'' +
                ", Nume='" + nume + '\'' +
                ", An Nastere=" + anNastere +
                ", Specializare='" + specializare + '\'' +
                ", Facultate='" + facultate + '\'' +
                "\n"+"Pacienti:"+"\n" ;



          for(Persoana i:pacienti)
              rez+=i.toString();

          rez+='}'+"\n";

          return rez;

    }
}

