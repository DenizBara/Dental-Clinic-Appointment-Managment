package clase;

import java.time.LocalDate;

public class Programare implements Comparable<Programare>{
    public String pacientProgramagre;
    public String doctorProgramare;
    public int ora;
    public LocalDate data;

    public Programare(String pacientProgramagre, String doctorProgramare, int ora, LocalDate data) {
        this.pacientProgramagre = pacientProgramagre;
        this.doctorProgramare = doctorProgramare;
        this.ora = ora;
        this.data = data;
    }

    public String getPacientProgramagre() {
        return pacientProgramagre;
    }

    public String getDoctorProgramare() {
        return doctorProgramare;
    }

    public int getOra() {
        return ora;
    }

    public LocalDate getData() {
        return data;
    }



    @Override
    public String toString() {
        return "{" +
                "Numele Pacientului=" + pacientProgramagre +
                ", Medic=" + doctorProgramare +
                ", ora=" + ora +
                ", data=" + data +
                '}' + "\n";
    }




        @Override
        public int compareTo(Programare other) {
            return this.data.compareTo(other.getData());
        }
    }





