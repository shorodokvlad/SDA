import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.util.Comparator;
import java.util.Scanner;

public class Flota {
    private Nava[] nave;
    private int nrNave;

    public Flota( ) {
        this.nave = new Nava[10];
        this.nrNave = nrNave;
    }

    public Flota(String numeFisier) {
        this.nave = new Nava[10];
        this.nrNave = 0;


        try(Scanner sc = new Scanner(new File(numeFisier))) {
            while (sc.hasNextLine()) {
                String linie = sc.nextLine().trim();
                if (linie.isEmpty()) continue;

                try {
                    String parts[] = linie.split(",");
                    if (parts.length < 4) {
                        continue;
                    }

                    // curatenie spatii
                    for (int i = 0; i < parts.length; i++) {
                        parts[i] = parts[i].trim();
                    }
                    String nume = parts[0];
                    String pavilion = parts[1];
                    String tip = parts[2];

                    Nava nava = null;


                    try {
                        switch (tip) {
                            case "NavaCroaziera": {
                                if (parts.length != 4) break;
                                int nrPasageri = Integer.parseInt(parts[3]);
                                if (nrPasageri <= 0) break;
                                adaugaNava(new NavaCroaziera(nume, pavilion, nrPasageri));
                                break;
                            }
                            case "Cargou": {
                                if (parts.length != 4) break;
                                int capacitateMax = Integer.parseInt(parts[3]);
                                if (capacitateMax <= 0) break;
                                adaugaNava(new Cargou(nume, pavilion, capacitateMax));
                                break;
                            }
                            case "Feribot" : {
                                if (parts.length != 5) break;
                                int nrPasageri = Integer.parseInt(parts[3]);
                                int nrAuto = Integer.parseInt(parts[4]);
                                if (nrAuto <= 0 || nrPasageri <= 0) break;
                                adaugaNava(new Feribot(nume, pavilion, nrPasageri, nrAuto));
                                break;
                            }

                            default:
                                break;
                        }
                    } catch (NumberFormatException e) {
                        continue;
                    }

                    adaugaNava(nava);

                } catch (NumberFormatException e) {
                    System.out.println("eroare la conversia datelor" + linie);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("file " + numeFisier + "not found");
        }
    }

    public boolean adaugaNava(Nava x) {
        if (x == null) {
            return false;
        }

        // verificam daca exista deja aceasi nava in flota
        for (int i = 0; i < nrNave; i++) {
            Nava n = nave[i];
            if (n.getNume().equals(x.getNume()) &&
                    n.getPavilion().equals(x.getPavilion())) {

                // deja exista → nu adaugam
                return false;
            }
        }

        if (nrNave >= nave.length) {
            this.nave = Arrays.copyOf(this.nave, this.nrNave + 5);
        }
        this.nave[this.nrNave++] = x;
        return true;
    }

    public String toStringFlota(boolean dupaNume) {

        // creăm o copie a navelor existente
        Nava[] copie = Arrays.copyOf(this.nave, this.nrNave);

        // alegem comparatorul
        Comparator<Nava> comp;

        if (dupaNume) {
            comp = Comparator.comparing(Nava::getNume);
        } else {
            comp = Comparator.comparing(Nava::getPavilion)
                    .thenComparing(Nava::getNume);
        }

        // sortăm copia
        Arrays.sort(copie, comp);

        // construim rezultatul
        StringBuilder sb = new StringBuilder("Flota:");
        for (int i = 0; i < copie.length; i++) {
            sb.append("\n")
                    .append(i + 1)
                    .append(". ")
                    .append(copie[i].toString());
        }

        return sb.toString();
    }



    @Override
    public String toString() {
        String s = "Flota: ";
        for (int i = 0; i < this.nrNave; i++) {
            s += "\n" + (i + 1) + ". " + this.nave[i].toString();
        }
        return s;
    }


    private void utilizare() {
        System.out.println("\nUtilizare flota: ");
        for(int i = 0; i < nrNave; i++) {
            nave[i].utilizare();
        }
    }

    public static void main(String[] args) {
        Flota flota1= new Flota();
        NavaCroaziera sv = new NavaCroaziera("Suceava", "RO", 1000);
        System.out.print(sv + "Utilizare: ");
        sv.utilizare();
        System.out.println();
        flota1.adaugaNava( sv);
        flota1.adaugaNava(new NavaCroaziera("Victoria", "RO", 5000));
        flota1.utilizare();

        flota1.adaugaNava(new Cargou("Carpati", "RO", 1000));
        flota1.adaugaNava(new Feribot("Dunarea", "BG", 100, 20));
        System.out.println(flota1);
        flota1.utilizare();

        System.out.println();
        Flota flota2 = new Flota("flota.txt");
        System.out.println(flota2);
        flota2.utilizare();

        Flota f = new Flota();
        System.out.println(f.adaugaNava(new NavaCroaziera("Suceava", "RO", 1000))); // true
        System.out.println(f.adaugaNava(new NavaCroaziera("Suceava", "RO", 2000))); // false

        System.out.println(flota2.toStringFlota(true));  // sortare după nume
        System.out.println(flota2.toStringFlota(false)); // sortare după pavilion
    }
}


