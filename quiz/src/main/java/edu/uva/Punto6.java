package edu.uva;
import edu.uva.model.iterator.Iterator;
import edu.uva.app.array.Array;
import java.lang.Math;

public class Punto6 {

    public double evaluar(Array<Integer> polinomio, int x){
        double resultado=0;
        int indice=0;
        Iterator<Integer> iterator=polinomio.iterator();
        while(iterator.hasNext()){
            resultado+=iterator.next()*Math.pow(x,indice);
            indice++;
        }

        return resultado;
    }

    public Array<Double> integrar(Array<Integer> polinomio){
        Array<Double> resultado=new Array<>(polinomio.size()+1);
        resultado.add(0.0);
        for(int i=0;i<polinomio.size();i++){
            resultado.add((double)polinomio.get(i)/(i+1));
        }

        return resultado;
    }

    public Array<Integer> sumaPolinomios(Array<Integer> polinomio1, Array<Integer> polinomio2){
        int max=Math.max(polinomio1.size(),polinomio2.size());
        Array<Integer> resultado= new Array<>(max);
        int x;
        int y;
        for(int i=0;i<max;i++){
            if(i<polinomio1.size()){
                x=polinomio1.get(i);
            }else{
                x=0;
            }
            if(i<polinomio2.size()){
                y=polinomio2.get(i);
            }else{
                y=0;
            }
            resultado.add(x+y);
        }
        return resultado;
    }
}
