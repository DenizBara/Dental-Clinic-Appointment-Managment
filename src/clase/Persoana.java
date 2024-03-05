package clase;

public class Persoana {
    public String prenume;
    public String nume;
    public int anNastere;

    public Persoana(String prenume, String nume, int anNastere) {
        this.prenume = prenume;
        this.nume = nume;
        this.anNastere = anNastere;
    }

    public Persoana(){
        prenume="";
        nume="";
        anNastere=0;

    }

    @Override
    public String toString() {
        return "clase.Persoana{" +
                "prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                ", anNastere=" + anNastere +
                '}';
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public int getAnNastere() {
        return anNastere;
    }
}
