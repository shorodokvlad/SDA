package jucarii;

import cutii.TipCutie;

public class Racheta extends Jucarie {
    private int pret = 120;
    TipCutie tipCutie = TipCutie.PARALELIPIPED;

    public Racheta(double l1, double l2) {
        super(l1, l2, l1);
    }

    @Override
    public TipCutie getTipCutie() {
        return TipCutie.CILINDRU;
    }

    @Override
    public double getPret() {
        return 120;
    }

    @Override
    public String toString() {
        return String.format("{Racheta,cutie recomandata:%s, l1=%.1f, l2=%.1f",getTipCutie(),super.getDimensiuni()[0],super.getDimensiuni()[1]);
    }
}
