package edu.uva;

import edu.uva.app.linkedlist.doubly.doubly.LinkedList;
import edu.uva.model.iterator.Iterator;
public class Punto1<E> {


    public LinkedList<E> interseccion(LinkedList<E> conjunto1, LinkedList<E> conjunto2){
        LinkedList<E> interseccion=new LinkedList<>();
        interseccion.add(conjunto1);
        interseccion.retain(conjunto2);

        return interseccion;

    }

    public LinkedList<E> diferencia(LinkedList<E> conjunto1, LinkedList<E> conjunto2){
        LinkedList<E> diferencia=new LinkedList<>();
        Iterator<E> iterator=conjunto1.iterator();
        while(iterator.hasNext()){
            E valor=iterator.next();
            if(!conjunto2.contains(valor)){
                diferencia.add(valor);
            }
        }
        return diferencia;
    }
}
