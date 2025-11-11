package jucarii;

import cutii.TipCutie;

public class Avion extends Jucarie {

    public Avion(double l1, double l2, double l3) {
        super(l1, l2, l3);
    }

    @Override
    public TipCutie getTipCutie() {
        return TipCutie.PARALELIPIPED;
    }

    @Override
    public double getPret() {
        return 100.0;
    }

    @Override
    public String toString() {
        double l1 = getDimensiuni()[0];
        double l2 = getDimensiuni()[1];
        double l3 = getDimensiuni()[2];
        return "{Avion, cutie recomandata:" + getTipCutie() + ", l1=" + l1 + ", l2=" + l2 + ", l3=" + l3 + "}";
    }
}
