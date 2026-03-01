package edu.uva;
import edu.uva.app.linkedlist.singly.singly.LinkedList;
import edu.uva.model.iterator.Iterator;


public class Punto4 {

    private char digitoHexadecimal(int n){
        if(n < 10)
            return (char)('0' + n);
        return (char)('A' + (n - 10));
    }

    public LinkedList<Character> binarioAHexadecimal(LinkedList<Character> binario){
        LinkedList<Character> hexadecimal= new LinkedList<>();
        LinkedList<Character> binarioReversed= new LinkedList<>();
        binarioReversed.add(binario);
        int valor=0;
        int potencia=1;
        int contador=0;
        binarioReversed.reverse();
        Iterator<Character> iterator=binarioReversed.iterator();

        while(iterator.hasNext()){
            valor+=(iterator.next()-'0')*potencia;
            potencia*=2;
            contador++;

            if(contador==4){
                hexadecimal.addFirst(digitoHexadecimal(valor));
                valor=0;
                potencia=1;
                contador=0;
            }
        }

        if(contador>0){
            hexadecimal.addFirst(digitoHexadecimal(valor));
        }

        return hexadecimal;
    }

    private int valorHexadecimal(char c){
        c=Character.toUpperCase(c);
        if(Character.isDigit(c))
            return c-'0';
        return 10 + (c-'A');
    }

    public LinkedList<Integer> hexadecimalABinario(LinkedList<Character> hexadecimal){
        LinkedList<Integer> binario= new LinkedList<>();
        Iterator<Character> iterator=hexadecimal.iterator();
        while(iterator.hasNext()){
            int valor=valorHexadecimal(iterator.next());

            for(int i=3;i>=0;i--){
                binario.add((valor>>i)&1);
            }
        }

        return binario;
    }
}


