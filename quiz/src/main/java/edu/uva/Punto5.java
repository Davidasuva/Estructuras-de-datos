package edu.uva;
import edu.uva.app.linkedlist.doubly.doubly.LinkedList;
import edu.uva.model.iterator.Iterator;
public class Punto5 {


    public LinkedList<Integer> sumar(LinkedList<Integer> a, LinkedList<Integer> b){
        LinkedList<Integer> resultado = new LinkedList<>();
        LinkedList<Integer> aReversed = new LinkedList<>();
        LinkedList<Integer> bReversed = new LinkedList<>();
        aReversed.add(a);
        bReversed.add(b);
        aReversed.reverse();
        bReversed.reverse();
        Iterator<Integer> iteratorA = aReversed.iterator();
        Iterator<Integer> iteratorB = bReversed.iterator();

        int carry = 0;

        while(iteratorA.hasNext() || iteratorB.hasNext() || carry>0){
            int x;
            int y;
            if(iteratorA.hasNext()){
                x = iteratorA.next();
            }else{
                x = 0;
            }
            if(iteratorB.hasNext()){
                y = iteratorB.next();
            }else{
                y = 0;
            }

            int suma = x + y + carry;
            resultado.addFirst(suma%10);
            carry = suma/10;
        }

        return resultado;
    }

    public LinkedList<Integer> division(LinkedList<Integer> a, int division){
        LinkedList<Integer> resultado = new LinkedList<>();
        if(division==0){
            return resultado;
        }
        Iterator<Integer> iterator=a.iterator();
        int acumulado=0;

        while(iterator.hasNext()){
            acumulado=acumulado*10+iterator.next();

            int digito=acumulado/division;
            resultado.add(digito);

            acumulado=acumulado % division;
        }
        return resultado;
    }
}
