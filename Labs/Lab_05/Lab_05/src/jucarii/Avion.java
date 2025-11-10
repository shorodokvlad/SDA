package jucarii;

import cutii.TipCutie;

public class Avion extends Jucarie{
    private int pret = 100;
    TipCutie tipCutie = TipCutie.PARALELIPIPED;

    @Override
    public TipCutie getTipCutie() {
        return TipCutie.PARALELIPIPED;
    }

    @Override
    public double getPret() {
        return 100;
    }

    public Avion(double l1, double l2, double l3) {
        super(l1, l2, l3);
    }

    @Override
    public String toString() {
        return String.format("{Avion,cutie recomandata:%s, l1=%.1f, l2=%.1f, l3=%.1f",getTipCutie(),super.getDimensiuni()[0],super.getDimensiuni()[1],super.getDimensiuni()[2]);
    }

}
