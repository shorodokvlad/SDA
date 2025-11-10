public class CalculSalarii {
    public static void main(String[] args) {
        Mecanic mecanic1 = new Mecanic("Ionescu", "Ion", 101, 200);
        Mecanic mecanic2 = new Mecanic("Georgescu", "George", 23, 100);
        Vopsitor vopsitor1 = new Vopsitor("Repede", "Relu", 150, 250, 1000);
        Mecanic mecanic3 = new Mecanic("Georgescu", "Bartolomeu", 73, 100);

        System.out.println(mecanic1);
        System.out.println(mecanic2);
        System.out.println(vopsitor1);
        System.out.println(mecanic3);

        double totalSalarii = mecanic1.salariu() + mecanic2.salariu() + mecanic3.salariu() + vopsitor1.salariu();
        System.out.println("Total salarii= " + totalSalarii);


        System.out.println();
        System.out.println("---- PARTEA A DOUA -----");
        System.out.println();

        Firma firma = new Firma();

        firma.adaugaAngajat(mecanic1);
        firma.adaugaAngajat(mecanic2);
        firma.adaugaAngajat(mecanic3);
        firma.adaugaAngajat(vopsitor1);

        System.out.println("TEST CAUTA DUPA ID");
        System.out.println("Mecanic: " + firma.getAngajatDupaID(101));
        System.out.println("Vopsitor: " + firma.getAngajatDupaID(150));
        System.out.println("Inexistent: " + firma.getAngajatDupaID(222) + "\n");


        firma.citestePontaj("pontaj.txt");
        firma.afisareAngajat();

        System.out.println("\nTotal salarii: " + firma.getTotalSalarii());

        System.out.println("\nOrdine alfabetica: ");
        firma.afisareAngajati(1);
        System.out.println("\nDupa ID: ");
        firma.afisareAngajati(2);

    }
}
