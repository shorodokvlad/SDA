package listadiamant;

import listadiamant.ListaGenerica;
import listadiamant.ListaGenerica2;

public class AplicatieLista{
    public static void main(String[] args) {
        ListaGenerica<String> lst =
                new ListaGenerica<>();
        System.out.println(lst);
        lst.insertLaUrma("Bucuresti");
        lst.insertInFata("Suceava");
        lst.insertLaUrma("Iasi");
        System.out.println(lst);
        lst.eliminaToateElementele();
        for(int i=0;i<21;i++) {
            String o = Integer.toString(i); // o=""+i
            if ( i%2 != 0 )
                lst.insertInFata( o );
            else lst.insertLaUrma( o );
        }
        System.out.println("Numerele din lista:"+lst);
        System.out.print("Intregii din lista x10: ");
        for(String el:lst){
            System.out.print( Integer.valueOf(el)*10 + ", " );
        }

        int size = lst.size();
        System.out.println("\nLungimea listei este " + size);
    }
} // safrsit class AplicatieLista