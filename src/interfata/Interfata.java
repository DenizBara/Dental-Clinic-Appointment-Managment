package interfata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import clase.Medic;
import clase.Pacient;
import clase.Persoana;
import clase.Programare;



public class Interfata extends JFrame {
         JTextArea textArea1;
         JLabel numeP;
         JLabel prenumeP;
         JLabel numeM;
         JLabel prenumeM;
         JLabel anNastere;
         JLabel ora;
         JLabel zi;
         JLabel luna;
         JLabel an;
         JTextField numePacient;
         JTextField prenumePacient;
         JTextField numeMedic;
         JTextField prenumeMedic;
         JSpinner spinnerAn;
         JSpinner spinnerOra;
         JSpinner spinnerZi;
         JSpinner spinnerLuna;
         JSpinner spinnerAnData;
         JTextArea textDescriere;
         JButton buttonAdd;
         JButton buttonDelete;
         JButton buttonUpdate;
         JButton listaMedici;
         JButton listaProgramari;
    List<Programare> Programari= new ArrayList<>();

    List<Pacient> listaPacienti= new ArrayList<>();

         public Interfata(){
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             File fisier=new File("C:\\Users\\HP\\IdeaProjects\\ProiectP3\\src\\fisiere\\fisierMedici.txt");

             List<Medic> medici=new ArrayList<>();
             List<Programare> Programari= new ArrayList<>();
             List<Pacient> listaPacienti= new ArrayList<>();

             try {
                 Scanner sc=new Scanner(fisier);
                 while(sc.hasNextLine()) {
                     String linie=sc.nextLine();
                     Scanner sc2=new Scanner(linie);
                     sc2.useDelimiter(";");
                     if (sc2.hasNext()) {
                         String Nume = sc2.next();
                         String Prenume = sc2.next();

                         String nr = sc2.next();
                         int an = Integer.parseInt(nr);
                         String specializare = sc2.next();
                         String facultate = sc2.next();
                         List<Persoana> pacienti = new ArrayList<>();

                         medici.add(new Medic(Prenume,Nume, an, specializare, facultate, pacienti));
                     }
                     sc2.close();
                 }
                 sc.close();
             }catch(IOException e) {
                 e.printStackTrace();
             }

             File fisier2=new File("C:\\Users\\HP\\IdeaProjects\\ProiectP3\\src\\fisiere\\fisierProgramari.txt");
             try {
                 Scanner sc3=new Scanner(fisier2);
                 while(sc3.hasNextLine()) {
                     String linie=sc3.nextLine();
                     Scanner sc4=new Scanner(linie);
                     sc4.useDelimiter(";");
                     if (sc4.hasNext()) {
                         String NumePacient=sc4.next();
                         String NumeMedic=sc4.next();

                         int Ora=Integer.parseInt(sc4.next());
                         int Zi=Integer.parseInt(sc4.next());
                         int Luna=Integer.parseInt(sc4.next());
                         int An=Integer.parseInt(sc4.next());

                         //Pacient P=new Pacient(PrenumePacient,NumePacient,AnNastere,Descriere,m);
                         LocalDate data=LocalDate.of(An,Luna,Zi);

                         Programari.add(new Programare(NumePacient,NumeMedic,Ora,data));
                     }
                     sc4.close();
                 }
                 sc3.close();
             }catch(IOException e) {
                 e.printStackTrace();
             }

             File fisier3=new File("C:\\Users\\HP\\IdeaProjects\\ProiectP3\\src\\fisiere\\fisierPacienti");

             try {
                 Scanner sc5=new Scanner(fisier3);
                 while(sc5.hasNextLine()) {
                     String linie=sc5.nextLine();
                     Scanner sc6=new Scanner(linie);

                     sc6.useDelimiter(";");
                     if (sc6.hasNext()) {
                         String NumePacient=sc6.next();
                         String PrenumePacient=sc6.next();

                         int An=Integer.parseInt(sc6.next());
                         String medic=sc6.next();
                         String descriere= sc6.next();

                         Pacient P=new Pacient(PrenumePacient,NumePacient,An,descriere,medic);

                         listaPacienti.add(P);

                         for(Medic i:medici) {
                             String t=i.getNume()+" "+i.getPrenume();

                             if (t.equals(medic)) {
                                 i.getPacienti().add(P);
                                 System.out.println(i);
                           }
                        }
                     }
                     sc6.close();
                 }
                 sc5.close();
             }catch(IOException e) {
                 e.printStackTrace();
             }

             this.setTitle("GESTIUNE PROGRAMARI");
             this.setSize(500, 700);
             this.setLayout(new FlowLayout(FlowLayout.LEFT));

              numeP= new JLabel("Nume Pacient");
             prenumeP= new JLabel("Prenume Pacient");
              numeM= new JLabel("Nume Medic");
              prenumeM= new JLabel("Prenume Medic");
              anNastere= new JLabel("An Nastere");
              ora= new JLabel("ora");
              zi=new JLabel("Zi:");
              luna=new JLabel("Luna:");
              an=new JLabel("An:");
              textArea1 = new JTextArea(10, 45);
             numePacient = new JTextField(12);
             prenumePacient = new JTextField(12);
             numeMedic = new JTextField(12);
             prenumeMedic = new JTextField(12);
             spinnerAn = new JSpinner(new SpinnerNumberModel(2000, 1900, 2024, 1));
             spinnerOra = new JSpinner(new SpinnerNumberModel(12, 9, 17, 1));
             spinnerZi = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
             spinnerLuna = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
             spinnerAnData = new JSpinner(new SpinnerNumberModel(2024, 2022, 2030, 1));
             textDescriere = new JTextArea(5, 45);
             buttonAdd = new JButton("Adauga");
             buttonDelete = new JButton("Sterge");
             buttonUpdate = new JButton("Actualizeaza");
             listaMedici= new JButton("Lista Medici");
             listaProgramari= new JButton("Lista Programari");

             this.add(numeP);

             this.add(numePacient);
             numeP.setHorizontalAlignment(SwingUtilities.RIGHT);
             this.add(prenumeP);
             this.add(prenumePacient);
             prenumeP.setHorizontalAlignment(SwingUtilities.RIGHT);

             this.add(numeM);
             this.add(numeMedic);
             numeM.setHorizontalAlignment(SwingUtilities.RIGHT);
             this.add(prenumeM);
             this.add(prenumeMedic);
             prenumeM.setHorizontalAlignment(SwingUtilities.RIGHT);

             JPanel panelSpinnerStanga= new JPanel(new FlowLayout(FlowLayout.LEFT));
             JPanel panelSpinnerDreapta= new JPanel(new FlowLayout(FlowLayout.RIGHT));
             panelSpinnerStanga.setPreferredSize(new Dimension(210,40));
             panelSpinnerDreapta.setPreferredSize(new Dimension(210,40));

             panelSpinnerStanga.add(anNastere);
             panelSpinnerStanga.add(spinnerAn);
             panelSpinnerDreapta.add(ora);
             panelSpinnerDreapta.add(spinnerOra);

             this.add(panelSpinnerStanga);
             this.add(panelSpinnerDreapta);

             JPanel panelSpinnere= new JPanel(new FlowLayout(FlowLayout.CENTER));
             panelSpinnere.setPreferredSize(new Dimension(450,40));

             panelSpinnere.add(zi);
             panelSpinnere.add(spinnerZi);
             panelSpinnere.add(luna);
             panelSpinnere.add(spinnerLuna);
             panelSpinnere.add(an);
             panelSpinnere.add(spinnerAnData);
             this.add(panelSpinnere);

             JPanel panelDescriere= new JPanel(new FlowLayout(FlowLayout.CENTER));
             panelDescriere.setPreferredSize(new Dimension(450,40));
             panelDescriere.add(new JLabel("Descriere:"));
             this.add(panelDescriere);
             this.add(new JScrollPane(textDescriere));

             JPanel panelButton= new JPanel(new FlowLayout(FlowLayout.CENTER));
             panelButton.setPreferredSize(new Dimension(450,40));

             panelButton.add(buttonAdd);
             panelButton.add(buttonDelete);
             panelButton.add(buttonUpdate);

             this.add(panelButton);

             this.add(new JScrollPane(textArea1));
             textArea1.setEditable(false);

             JPanel panelLista= new JPanel(new FlowLayout(FlowLayout.CENTER));
             panelLista.setPreferredSize(new Dimension(450,40));
             panelLista.add(listaMedici);
             panelLista.add(listaProgramari);
             this.add(panelLista);

             /**
              * Este implementata metoda de adaugare
              * pentru a insera o programare in
              * lista noastra personalizata de programari
              * Dupa ce se adauga programarea in lista se
              * va adauga si pacientul in lista medicului respectiv
              * de pacienti
              * @param PrenumePacient= Prenumele pacientului care are programare
              * @param NumePacient= Numele pacientului care are programare
              * @param NumeMedic= Numele medicului la care acesta are programare
              * @param  PrenumeMedic= Prenumele medicului la care acesta are programarea
              * @param  Zi= ziua in care are programarea
              * @param  Luna= luna in care are programarea
              * @param   An= anul in care are programarea
              * @param   Ora= ora la care este programarea
              * @param   AnNastere= anul in care este nascut pacientul
              * @param   Descriere= Descrierea ppacientului sau a cazului acestuia
              */
             ActionListener adaugare= new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     String PrenumePacient=prenumePacient.getText();
                     String NumePacient=numePacient.getText();
                     String NumeMedic= numeMedic.getText();
                     String PrenumeMedic=prenumeMedic.getText();

                     int AnNastere=(int)spinnerAn.getValue();
                     int Ora=(int)spinnerOra.getValue();
                     int Zi=(int)spinnerZi.getValue();
                     int Luna=(int)spinnerLuna.getValue();
                     int An=(int)spinnerAnData.getValue();

                     String Descriere=textDescriere.getText();
                     String t=NumePacient+" "+PrenumePacient;
                     String m=NumeMedic+" "+PrenumeMedic;

                     Pacient P=new Pacient(PrenumePacient,NumePacient,AnNastere,Descriere,m);

                     LocalDate data=LocalDate.of(An,Luna,Zi);
                     int ok=0;

                     for(Programare k:Programari)
                         if (k.getData().equals(data) && k.getOra() == Ora && k.getDoctorProgramare().equals(m)) {
                             ok=1;
                             textDescriere.setText("Medicul la care se vrea programarea este deja ocupat la ora si data ceruta \n Va rog incercati alta optiune!");
                         }

                         if(ok==0)
                         {
                         Programari.add(new Programare(t, m, Ora, data));

                         prenumePacient.setText("");
                         numePacient.setText("");
                         numeMedic.setText("");
                         prenumeMedic.setText("");
                         textDescriere.setText("");

                         for (Medic i : medici) {
                             if (i.getNume().equals(NumeMedic) && i.getPrenume().equals(PrenumeMedic)) {
                                 i.getPacienti().add(P);
                                 System.out.println(i);
                             }
                         }

                         try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\ProiectP3\\src\\fisiere\\fisierProgramari.txt", true))) {
                             writer.println(t + ";" + m + ";" + Ora + ";" + Zi + ";" + Luna + ";" + An);
                         } catch (IOException e2) {
                             e2.printStackTrace();
                         }

                         Collections.sort(Programari);

                         try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\ProiectP3\\src\\fisiere\\fisierPacienti", true))) {
                             writer.println(NumePacient + ";" + PrenumePacient + ";" + AnNastere + ";" + m + ";" + Descriere);
                         } catch (IOException e2) {
                             e2.printStackTrace();
                         }
                     }



                 }
             };
             buttonAdd.addActionListener(adaugare);

             /**
              * Este implementata metoda de stergere
              * pentru a elimina o programare din
              * lista noastra personalizata de programari
              *
              * @param PrenumePacient= Prenumele pacientului care are programare
              * @param NumePacient= Numele pacientului care are programare
              * @param NumeMedic= Numele medicului la care acesta are programare
              * @param  PrenumeMedic= Prenumele medicului la care acesta are programarea
              * @param  Zi= ziua in care are programarea
              * @param  Luna= luna in care are programarea
              * @param   An= anul in care are programarea
              * @param   Ora= ora la care este programarea
              * @param   AnNastere= anul in care este nascut pacientul
              * @param   Descriere= Descrierea ppacientului sau a cazului acestuia
              */

             ActionListener stergere= new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     String PrenumePacient=prenumePacient.getText();
                     String NumePacient=numePacient.getText();
                     String NumeMedic= numeMedic.getText();
                     String PrenumeMedic=prenumeMedic.getText();
                     String t=NumePacient+" "+PrenumePacient;
                     String m=NumeMedic+" "+PrenumeMedic;
                     int Zi=(int)spinnerZi.getValue();
                     int Luna=(int)spinnerLuna.getValue();
                     int An=(int)spinnerAnData.getValue();
                     LocalDate data=LocalDate.of(An,Luna,Zi);


                     Iterator<Programare> iterator = Programari.iterator();
                     while (iterator.hasNext()) {
                         Programare i = iterator.next();
                         if (i.getPacientProgramagre().equals(t) && i.getDoctorProgramare().equals(m) && i.getData().equals(data)) {
                             iterator.remove();
                             break;
                         }
                     }



                     for(Medic i:medici){
                         Iterator<Persoana> iterator2 = i.getPacienti().iterator();
                         while(iterator2.hasNext()){
                             Persoana j=iterator2.next();

                             if (j.getNume().equals(NumePacient) && j.getPrenume().equals(PrenumePacient)){
                                 iterator2.remove();
                             break;}

                         }
                     }

                     Iterator<Pacient> iterator3 = listaPacienti.iterator();
                     while (iterator3.hasNext()) {
                         Pacient i = iterator3.next();
                         if (i.getNume().equals(NumePacient) && i.getPrenume().equals(PrenumePacient)) {
                             iterator3.remove();
                             break;
                         }
                     }

                         try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\ProiectP3\\src\\fisiere\\fisierProgramari.txt"))) {
                             for (Programare i : Programari) {
                                 writer.println(i.getPacientProgramagre()+";"+i.getDoctorProgramare()+";"+i.getOra()+";"+i.getData().getDayOfMonth()+";"+i.getData().getMonthValue()+";"+i.getData().getYear());
                             }
                         } catch (IOException e4) {
                             e4.printStackTrace();
                         }

                     try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\ProiectP3\\src\\fisiere\\fisierPacienti"))) {
                        for(Pacient i:listaPacienti)
                         writer.println(i.getNume()+";"+i.getPrenume()+";"+i.getAnNastere()+";"+i.getDoctor()+";"+i.getDescriere());
                     } catch (IOException e2) {
                         e2.printStackTrace();
                     }

                     for(Programare i:Programari)
                         System.out.println(i);

                     prenumePacient.setText("");
                     numePacient.setText("");
                     numeMedic.setText("");
                     prenumeMedic.setText("");
                     textDescriere.setText("");
                 }
             };

             buttonDelete.addActionListener(stergere);

             /**
              * Este implementata metoda de actualizare
              * pentru a modifica o programare din
              * lista noastra personalizata de programari
              *
              * @param PrenumePacient= Prenumele pacientului care are programare
              * @param NumePacient= Numele pacientului care are programare
              * @param NumeMedic= Numele medicului la care acesta are programare
              * @param  PrenumeMedic= Prenumele medicului la care acesta are programarea
              * @param  Zi= ziua in care are programarea
              * @param  Luna= luna in care are programarea
              * @param   An= anul in care are programarea
              * @param   Ora= ora la care este programarea
              * @param   AnNastere= anul in care este nascut pacientul
              * @param   Descriere= Descrierea ppacientului sau a cazului acestuia
              */


             ActionListener update= new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     String PrenumePacient=prenumePacient.getText();
                     String NumePacient=numePacient.getText();
                     String NumeMedic= numeMedic.getText();
                     String PrenumeMedic=prenumeMedic.getText();
                     int AnNastere=(int)spinnerAn.getValue();
                     int Ora=(int)spinnerOra.getValue();
                     int Zi=(int)spinnerZi.getValue();
                     int Luna=(int)spinnerLuna.getValue();
                     int An=(int)spinnerAnData.getValue();
                     String Descriere=textDescriere.getText();
                     String t=PrenumePacient+" "+NumePacient;
                     String m=PrenumeMedic+" "+NumeMedic;
                     LocalDate data=LocalDate.of(An,Luna,Zi);


                     prenumePacient.setText("");
                     numePacient.setText("");
                     numeMedic.setText("");
                     prenumeMedic.setText("");
                     textDescriere.setText("");




                     for(Programare i:Programari)
                         if(i.getPacientProgramagre().equals(t) && i.getDoctorProgramare().equals(m)){
                             i.pacientProgramagre=t;
                             i.doctorProgramare=m;
                             i.ora=Ora;
                             i.data=data;

                         }

                     try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\HP\\IdeaProjects\\ProiectP3\\src\\fisiere\\fisierProgramari.txt"))) {
                         for (Programare i : Programari) {
                             writer.println(i.getPacientProgramagre()+";"+i.getDoctorProgramare()+";"+i.getOra()+";"+i.getData().getDayOfMonth()+";"+i.getData().getMonthValue()+";"+i.getData().getYear());
                         }
                     } catch (IOException e4) {
                         e4.printStackTrace();
                     }

                     for(Programare i:Programari)
                         System.out.println(i);




                 }


             };
             buttonUpdate.addActionListener(update);

             /**
               Este implementata o metoda pentru a
               putea vizualiza toate programarile
              din lista noastra
              */

             ActionListener VeziProgramari= new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     textArea1.setText("");
                     StringBuilder text = new StringBuilder();
                     for (Programare i : Programari) {
                         text.append(i.toString()).append("\n");
                     }

                     textArea1.setText(text.toString());



                 }
             };
             listaProgramari.addActionListener(VeziProgramari);

             /**
              Este implementata o metoda pentru a
              putea vizualiza toti medicii
              din lista noastra
              */

             ActionListener VeziMedici= new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     textArea1.setText("");
                     StringBuilder text = new StringBuilder();
                     for (Medic i : medici) {
                         text.append(i.toString()).append("\n");
                     }

                     textArea1.setText(text.toString());



                 }
             };
             listaMedici.addActionListener(VeziMedici);
         }

}
