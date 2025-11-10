package jucarii;

import cutii.TipCutie;

public class Minge extends Jucarie{
    private int pret = 50;
    TipCutie tipCutie = TipCutie.CUB;

    public Minge(double l1) {
        super(l1, l1, l1);
    }

    @Override
    public TipCutie getTipCutie() {
        return TipCutie.CUB;
    }

    @Override
    public double getPret() {
        return 50;
    }

    @Override
    public String toString() {
        return String.format("Minge, cutie recomandata: %s, l1 = %.1f", getTipCutie(), super.getDimensiuni()[0]);
    }
}
