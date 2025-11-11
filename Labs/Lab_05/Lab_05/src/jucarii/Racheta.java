package jucarii;

import cutii.TipCutie;

public class Racheta extends Jucarie {

    public Racheta(double l1, double l2) {
        super(l1, l2, 0.0);
    }

    @Override
    public TipCutie getTipCutie() {
        return TipCutie.CILINDRU;
    }

    @Override
    public double getPret() {
        return 120.0;
    }

    @Override
    public String toString() {
        double l1 = getDimensiuni()[0];
        double l2 = getDimensiuni()[1];
        return "{Racheta, cutie recomandata:" + getTipCutie() + ", l1=" + l1 + ", l2=" + l2 + "}";
    }
}
