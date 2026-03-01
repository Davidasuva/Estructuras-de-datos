package edu.uva;


import edu.uva.app.linkedlist.doubly.doubly.LinkedList;
import edu.uva.model.iterator.Iterator;

import java.util.function.ToIntFunction;


public class Punto2 {

    public int promedio(LinkedList<Integer> lista){
        if(lista==null||lista.isEmpty()){
            return -1;
        }
        Iterator<Integer> iterator=lista.iterator();
        int suma=0;
        while(iterator.hasNext()){
            suma+=iterator.next();
        }
        return suma/lista.size();
    }


    public int mediana(LinkedList<Integer> lista){
        ToIntFunction<Integer> IntegerToInt = x -> x;
        Iterator<Integer> iterator=lista.iterator();
        lista.sort(IntegerToInt);

        int mediana;
        int value=0;
        for(int i=0;i<(lista.size()/2);i++){
            value=iterator.next();
        }
        if(lista.size()%2==0){
            int b= iterator.next();
            return(value+b)/2;
        }else{
            return iterator.next();
        }
    }

    public int frecuencia(int numero, LinkedList<Integer> lista){
        int frecuencia=0;
        int value;
        Iterator<Integer> iterator=lista.iterator();
        while(iterator.hasNext()){
            value=iterator.next();
            if(value==numero){
                frecuencia++;
            }
        }
        return frecuencia;
    }

    public int moda(LinkedList<Integer> lista){
        int moda=0;
        int numMayor=0;
        int value;
        Iterator<Integer> iterator=lista.iterator();
        numMayor=lista.peek();
        while(iterator.hasNext()){
            value=iterator.next();
            if(frecuencia(numMayor,lista)<frecuencia(value,lista)){
                numMayor=value;
            }
        }

        return numMayor;
    }
}
