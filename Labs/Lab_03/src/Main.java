
public class Main {
    public static void main(String[] args) {

        NavaCroaziera navaSuceava = new NavaCroaziera("Suceava", "RO", 1000) {
            @Override
            public void utilizare() {
                super.utilizare();
            }
        };



        NavaCroaziera navaVictoria = new NavaCroaziera("Victoria", "RO", 5000) {
            @Override
            public void utilizare() {
                super.utilizare();
            }
        };

        System.out.println(navaSuceava + "\nUtilizare: ");
        navaSuceava.utilizare();
        System.out.println(navaVictoria);
    }


}



