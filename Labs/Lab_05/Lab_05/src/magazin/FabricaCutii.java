package magazin;

import jucarii.Jucarie;
import jucarii.Minge;
import jucarii.Racheta;
import jucarii.Avion;
import cutii.*;

public class FabricaCutii {
    public static ICutie getCutie(Jucarie j) {
        switch (j.getTipCutie()) {
            case CUB:
                // Minge (cub) folosește doar l1
                return new Cub(j.getDimensiuni()[0]);
            case CILINDRU:
                // Racheta: l1=r, l2=h
                return new Cilindru(j.getDimensiuni()[0], j.getDimensiuni()[1]);
            case PARALELIPIPED:
                // Avion: l1,l2,l3
                return new Paralelipiped(j.getDimensiuni()[0], j.getDimensiuni()[1], j.getDimensiuni()[2]);
            default:
                return null;
        }
    }
}

