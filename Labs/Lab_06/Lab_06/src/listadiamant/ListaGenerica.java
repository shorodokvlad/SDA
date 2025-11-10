package listadiamant;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class ListaGenerica<T> implements Iterable<T> {
    private static class Element<T>{
        public T info;
        protected Element<T> urm;
        Element(T info, Element<T> urm) {
            this.info = info;
            this.urm = urm;
        }
    } // sfarsit static class Element<T>
    protected Element<T> primul=null;
    protected Element<T> ultimul=null;

    private int dimensiune = 0;
    public ListaGenerica() {
    }
    @Override
    public Iterator<T> iterator() {
        return new IteratorLst(primul);
    }
    public void insertInFata (T x){
        primul = new Element (x, primul);
        if ( ultimul == null) {
            ultimul = primul;
        }
        dimensiune++;
    }
    public void insertLaUrma ( T x ) {
        Element<T> elem = new Element(x, null);
        if(ultimul == null) {
            primul = ultimul = elem;
        } else {
            ultimul.urm = elem;
            ultimul = elem;
        }
        dimensiune++;
    }
    public void eliminaToateElementele ( ) {
        primul = ultimul = null;

        dimensiune = 0;
    }
    @Override
    public String toString() {
        StringBuilder rez=new StringBuilder("[");
        for (Element<T> elemCrt = primul; elemCrt != null;
             elemCrt = elemCrt.urm) {

            rez.append(elemCrt.info);
            if ( elemCrt.urm != null) rez.append(", ");
        }
        return rez.append("]").toString();
    }
    private class IteratorLst<T> implements Iterator<T> {
        private Element<T> pcrt;
        public IteratorLst(Element<T> prim) {
            this.pcrt = prim;
        }
        @Override
        public boolean hasNext(){
            return pcrt != null;
        }
        @Override
        public T next() throws NoSuchElementException {
            Element<T> el = pcrt;
            if(el==null) throw new NoSuchElementException();
            pcrt = pcrt.urm;
            return el.info;
        }
    } // sfarsit private class IteratorLst<T> implements Iterator<T>

    public int size() {
        return dimensiune; // O(1) - timp constant
    }
} // sfarsit class ListaGenerica<T> implements Iterable<T>