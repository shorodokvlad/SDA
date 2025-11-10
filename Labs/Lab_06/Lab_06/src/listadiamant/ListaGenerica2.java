package listadiamant;

import javax.lang.model.element.Element;

public class ListaGenerica2<T> extends ListaGenerica {
    private static class Element<T>{
        public T info;
        protected ListaGenerica2.Element<T> urm;
        Element(T info, ListaGenerica2.Element<T> urm) {
            this.info = info;
            this.urm = urm;
        }
    } // sfarsit static class Element<T>
    protected ListaGenerica2.Element<T> primul=null;
    protected ListaGenerica2.Element<T> ultimul=null;
    private int size = 0;

    public T eliminaPrimul() {
        if (size == 0) {
            return null;
        }

        T info = primul.info;

        if (size == 1) {
            primul = ultimul = null;
        } else {
            primul = primul.urm;
        }

        size--;

        return info;

    }

    public T eliminaUltimul() {
        if (ultimul == null) {
            return null;
        }

        T elementEliminat = ultimul.info;

        if (size == 1) {
            primul = ultimul = null;
        } else {
            Element<T> crt = primul;
            while (crt.urm != ultimul) {
                crt = crt.urm;
            }
            crt.urm = null;
            ultimul = crt;
            size--;
        }

        return elementEliminat;
    }
}
