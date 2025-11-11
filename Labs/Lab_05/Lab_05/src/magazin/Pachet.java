package magazin;

import jucarii.Jucarie;
import cutii.ICutie;
import magazin.FabricaCutii;
import magazin.RolaPanglica;

public class Pachet {
    private Jucarie jucarie;
    private boolean impachetat;
    private boolean panglica;
    private ICutie cutie; // null daca nu e impachetat
    private double lungPanglica; // 0 daca nu se foloseste panglica

    public Pachet(Jucarie j, boolean impachetat, boolean panglica) {
        this.jucarie = j;
        this.impachetat = impachetat;
        this.panglica = panglica;
        if (impachetat) {
            this.cutie = FabricaCutii.getCutie(j);
        } else {
            this.cutie = null;
        }
        if (this.cutie != null && panglica) {
            double necesar = cutie.getLungimePanglica();
            // cumparam din rola daca se poate
            if (RolaPanglica.getRola().cumpara(necesar)) {
                this.lungPanglica = necesar;
            } else {
                // daca nu e disponibil, nu se acorda panglica (cerința: nu se poate cumpăra o lungime mai mică -> deci nu acordăm)
                this.lungPanglica = 0.0;
                this.panglica = false;
            }
        } else {
            this.lungPanglica = 0.0;
        }
    }

    public double pretPachet() {
        double total = jucarie.getPret();
        if (impachetat && cutie != null) {
            total += cutie.pret();
        }
        if (panglica && lungPanglica > 0) {
            total += RolaPanglica.getRola().getCostUnitateLungime() * lungPanglica;
        }
        return total;
    }

    public Jucarie getJucarie() { return jucarie; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pachet{jucarie=");
        sb.append(jucarie.toString());
        if (impachetat && cutie != null) {
            sb.append(", impachetat in ");
            sb.append(cutie.toString());
            if (panglica && lungPanglica > 0) {
                sb.append(", lungPanglica=" + lungPanglica);
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
