package edu.uva;
import edu.uva.app.linkedlist.singly.singly.LinkedList;
import edu.uva.model.iterator.Iterator;

public class Punto3 {

    public long octalADecimal(LinkedList<Integer> lista){
        if(lista.isEmpty()){
            return 0;
        }
        Iterator<Integer> iterator=lista.iterator();
        long resultado=0;
        while(iterator.hasNext()){
            resultado=resultado*8+ iterator.next();
        }

        return resultado;
    }

    public LinkedList<Integer> decimalAOctal(long numero){
        LinkedList<Integer> lista=new LinkedList<>();
        if(numero==0){
            return lista;
        }
        if(numero==0){
            lista.add(0);
            return lista;
        }
        while(numero>0){
            int residuo=(int)(numero%8);
            lista.addFirst(residuo);
            numero/=8;
        }

        return lista;

    }
}
