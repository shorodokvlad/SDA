package magazin;

import cutii.ICutie;
import jucarii.Jucarie;

public class Pachet {
    public Jucarie jucarie;
    boolean cereCutie;
    boolean cerePanglica;
    ICutie cutie;
    double lungPaglica;
    double pretPachet;
    FabricaCutii fabricaCutii = new FabricaCutii();
    RolaPanglica rolaPanglica = RolaPanglica.getInstance();

    public Pachet(Jucarie jucarie, boolean cereCutie, boolean cerePanglica) {
        this.jucarie = jucarie;
        this.cereCutie = cereCutie;
        this.cerePanglica = cerePanglica;
    }

    @Override
    public String toString() {
        String descriere = "Pachet{jucarie={" + jucarie.toString() + "}";

        if (this.cutie != null) {
            descriere += ", impachetat=" + cutie.toString();

            if (this.lungPaglica > 0) {
                descriere += ", lungPanglica=" + this.lungPaglica;
            }
        } else {
            descriere += ", neimpachetat";
        }

        descriere += "}";
        return descriere;
    }

    public Double pretPachet() {
        return pretPachet;
    }

    public double PretPachete() {
        double pret = jucarie.getPret();
        if (cutie != null) {
            pret = pret + cutie.pret();
        }

        if (lungPaglica > 0) {
            pret = lungPaglica * rolaPanglica.getCostUnitateLungime();
        }

        return pret;
    }

}
