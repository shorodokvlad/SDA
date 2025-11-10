public class DemoLab2 {
    public static void main(String[] args) {
        /*
        Dreptunghi dr = new Dreptunghi(10, 5);
        Dreptunghi dr2 = null;

        System.out.println("Dreptunghi " + dr);
        System.out.println("Aria: " + dr.getAria());

        Patrat pt2 = new Patrat(5);
        //System.out.println(pt1 + "aria = " + pt1.getAria());
        System.out.println(pt2 + "Aria patrat = " + pt2.getAria());

        Gresie gr = new Gresie(dr, 5, 6);
        System.out.println(gr);
        System.out.println("Volum gresie: " + gr.getVolum());


        System.out.println();
        PachetGresii pachetGresii = new PachetGresii(dr, 5, 6, 222, gr, 599, 5 );
        System.out.println(pachetGresii);

        System.out.println("Volum pachet gresii: " + pachetGresii.getVolum() + " m3");
        System.out.println("Valoare pachet gresii: " + pachetGresii.getValoarePachet() + " RON");
        System.out.println("Inaltime pachet gresii: " + pachetGresii.getInaltimeTotalaPachet() + " cm");

        System.out.println();

         */

        /*
        Magazin magazin = new Magazin(5);

        Dreptunghi d = new Dreptunghi(30, 20);
        Gresie g = new Gresie(d, 1, 2);
        PachetGresii p1 = new PachetGresii(d, 1, 2, 1, g, 50, 10);
        PachetGresii p2 = new PachetGresii(d, 1, 2, 1, g, 60, 8); // același id

        magazin.adaugaPachetGresii(p1); //  se adaugă
        magazin.adaugaPachetGresii(p2); //  refuzat, id duplicat

        System.out.println(magazin);
         */

        Magazin magazin = new Magazin(10);

        Dreptunghi baza = new Dreptunghi(30, 20);
        Gresie g = new Gresie(baza, 1, 2);
        PachetGresii p = new PachetGresii(baza, 1, 2, 1, g, 50, 10);
        magazin.adaugaPachetGresii(p);

        // Adăugare din fișier
        magazin.adaugaDinFisier("gresii.txt");

        // Afișare
        System.out.println(magazin);



        System.out.println("Valoare totală a gresiei: " + magazin.getValoareTotala());
        System.out.println("Înălțime totală pachete: " + magazin.getInaltimeTotalaPachete());

        /*

        Magazin magazin = new Magazin(5);

        Dreptunghi d1 = new Dreptunghi(30, 20);
        Gresie g1 = new Gresie(d1, 1, 2);
        PachetGresii p1 = new PachetGresii(d1, 1, 2, 1, g1, 50, 10);

        Dreptunghi d2 = new Dreptunghi(25, 15);
        Gresie g2 = new Gresie(d2, 0.8, 3);
        PachetGresii p2 = new PachetGresii(d2, 0.8, 3, 2, g2, 45, 12);

        magazin.adaugaPachetGresii(p1);
        magazin.adaugaPachetGresii(p2);

        System.out.println("\n📦 Situația inițială:");
        System.out.println(magazin);
        System.out.println("Valoare totală: " + magazin.getValoareTotala() + " lei");

        // Vindem un pachet
        magazin.vindePachet(1);

        System.out.println("\n📦 Situația după vânzare:");
        System.out.println(magazin);

         */
    }
}