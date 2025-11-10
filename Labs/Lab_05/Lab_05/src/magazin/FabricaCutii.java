package magazin;

import cutii.*;
import jucarii.Avion;
import jucarii.Jucarie;
import jucarii.Minge;
import jucarii.Racheta;

public class FabricaCutii {
    public ICutie getCutie (Jucarie jucarie) {
        double[] dim = jucarie.getDimensiuni();
        if (jucarie instanceof Minge) {
            return new Cub(dim[0]);
        } else if(jucarie instanceof Racheta) {
            return new Cilindru(dim[0], dim[1]);
        } else if (jucarie instanceof Avion) {
            return new Paralelipiped(dim[0], dim[1], dim[2]);
        }

        return null;
    }

}
