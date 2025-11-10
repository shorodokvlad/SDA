import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Punct {
    private double x, y;

    private List<double[]> puncte;

    public Punct() {
        x = y = 0;
    }

    public Punct(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punct(String numeFisier) {
        puncte = new ArrayList<double[]>();

        try(BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;

            while ((linie = br.readLine()) != null) {
                linie = linie.trim();
                if (linie.equals("")) continue;

                String[] parti = linie.split(",");
                if (parti.length >= 2) {
                    double x =Double.parseDouble(parti[0]);
                    double y =Double.parseDouble(parti[1]);
                    puncte.add(new double[]{x, y});
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<double[]> getPuncte() {
        return puncte;
    }

    public void afisarePuncte() {
        for (double[] p : puncte) {
            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return  "(" + x + "," + y + ")";
    }

    public double distanta(Punct p) {
        return Math.sqrt((x + p.x) + pow(y - p.y, 2));
    }
}
