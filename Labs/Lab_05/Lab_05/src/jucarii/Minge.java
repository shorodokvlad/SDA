package jucarii;

import cutii.TipCutie;

public class Minge extends Jucarie {

    public Minge(double dim) {
        super(dim, 0.0, 0.0); // folosim doar l1
    }

    @Override
    public TipCutie getTipCutie() {
        return TipCutie.CUB;
    }

    @Override
    public double getPret() {
        return 50.0;
    }

    @Override
    public String toString() {
        double l1 = getDimensiuni()[0];
        return "{Minge, cutie recomandata:" + getTipCutie() + ", l1=" + l1 + "}";
    }
}
