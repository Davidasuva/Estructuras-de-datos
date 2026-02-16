package edu.uva.app.array;

import java.util.function.Function;
import java.util.function.Predicate;

import edu.uva.model.array.AbstractArray;
import edu.uva.model.collection.Collection;
import edu.uva.model.iterator.Iterator;

public class Array<E> extends AbstractArray<E> {

    private E[] array; //Se crea el array
    private int size; //se crea el tamaño del array(Osea el número de elementos que hay sin contar nulls)



    @SuppressWarnings("unchecked")
    public Array(int size){
        this.array= (E[]) new Object[size]; 
        this.size=0; //Se inicializa el constructor de la clase y se da valores
    }

    //La parte de collection
    @Override
    public int size(){
        return(size); //es un getter, para poder saber cual es el tamaño
    }

    @Override
    public boolean isEmpty(){ //Para saber si esta vacio el array
        return(size()==0); //Se llama al método size() y se iguala a 0 retorna el resultado de esta igualdad
    }

    @Override
    public boolean clear(){ //Limpia todo el array
        for(int ii=0; ii<size;ii++){
            array[ii]=null; //Pasa por cada posición DONDE hay elementos por eso es el <Size para asi no recorrer los nulls
        }
        size=0; //Se pone que el tamaño es 0
        return true;
    }

    @Override
    public boolean reverse(){//Se da la vuelta al array
        for(int i=0; i < size/2; i++){ //Se llega hasta size/2 porque seria la mitad del array ya que a la otra ya se le abra dado la vuelta asi que no tendria sentido volver a recorrerla
            E temporal=array[i]; //Se guarda el valor temporal 
            array[i]= array[size-1-i];//Se agarra y se pone el valor del lado contrario
            array[size-1-i]=temporal; //Se coloca al lado contrario el valor que se tenia
        }
        return true;
    }

    @Override
    public boolean contains(Collection<E> collection){ //Se usa para saber si los elementos de la collecion esta dentro del array
        if(collection==null){ //si la collecion es nula devuelve false de una vez
            return false;
        }
        Iterator<E> iterator = collection.iterator(); //se instancia un iterador 
        while(iterator.hasNext()){ //se ejecuta el while mientras que haya un siguiente número
            if(!contains(iterator.next())){ //Si UN solo elemento de la collecion no esta dentro del array devuelve false(DEBEN ESTAR TODOS) el iterator.next() retorna un valor E y ese es el que se valida si está
                return false;
            }
        }
        return true;
    }

    @Override
    public void forEach(Function<E,Void> action ){ //Sinceramente esto fue IA no se como funciona el function y el predicate
        if(action==null){
            return;
        }

        Iterator<E> iterator= iterator();
        while(iterator.hasNext()){
            action.apply(iterator.next());
        }
    }

    //La parte de Iterator
    @Override
    public Iterator<E> iterator(){ //Aca es el método que nos permite retornar un iterador
        return new Iterator<E>(){ //Aca se retorna el iterador, la cosa es que dentro de este se esta definiendo los métodos que este posee. es una clase anonima segun busqué
            private int index=0; //Se empieza con un indice 0

            @Override
            public boolean hasNext(){
                return index<size; //Si el indice es menor que size, devuelve true ya que significa que hay otro elemento ya si es igual significa que no hay más elementos adelante
            }

            @Override
            public E next(){
                if(!hasNext()){
                    throw new IllegalStateException("No more elements");
                }
                return array[index++]; //Aca se va avanzando dentro del array y se van retornando (el index va aumentando por cada vez que se llama a este método) 
            }
        };
    }

    //Para el array
    @Override
    public boolean add(E element){// aca simplemente se agrega un elemento a la parte final del array
        if(size==array.length){//si es igual significa que no se puede agregar más y devuelve false
            return false;
        }
        array[size++]=element; //al tener el ++ significa  que tambien se  aumenta a size 1 y pues se coloca al final del array, es como decir lo coloco en el lugar 3 y guardamos el 3 como último lugar
        return true;
    }

    @Override
    public boolean add(int index, E[] array){//Aca se agrega un array desde un elemento
        if(array==null || index<0 || index>=size){ //aca simplemente valora, si el array es nulo, no hace nada o si el indice es menor que 0 o mayor que el tamaño no hace nada.
            return false;
        }
        if((size + array.length)>this.array.length){// aca ve si size más el valor de la longitud del arreglo que se quiere agregar es mayor a la longitud del que tenemos simplemente no lo hace y devuelve false
            return false;
        }
        for(int i=size-1; i>=index;i--){ //Aca lo desplaza, eliminando espacios null
            this.array[i+array.length]=this.array[i]; //Osea empieza a recorrer el array desde el ultimo y va pasando los elementos que estaban despues del indice que dimos hacia adelante osea [0,1,2,3] y queremos agregar [0,1] en el indice 1 entonces seria [0,1,2,3,2,3] ya que solo los estamos pasando hacia adelante
        }
        for(int i=0; i<array.length;i++){ //Aca simplemente ponemos los elementos del array que queremos agregar desde donde queremos es decir el anterior arreglo que estaba [0,1,2,3,2,3] quedaria [0,1,0,1,2,3]
            this.array[index+i]=array[i]; //En el [index+1] es porque empezamos a agregar desde ahí
        }
        size+= array.length; //aca simplemente se le suma al size el tamaño del array que agregamos
        return true;
    }

    @Override 
    public boolean add(int index, Collection<E> collection){ //Se le agrega una colleción
        if(collection==null || index<0 || index>=size){
            return false;
        }
        if((collection.size()+size)>array.length){//Misma valoración que en el anterior , aca simplemente se llama al metodo de collection.size para saber cuanto es su longitud
            return false;
        }
        for(int i=size-1; i>=index;i--){//Aca hace lo mismo,desplaza los elementos hacia adelante
            array[i+collection.size()]=array[i];
        }
        
        Iterator<E> iterator=collection.iterator();
        int i=0;//este es un indice que va empezando desde 0
        while(iterator.hasNext()){//si hay elementos más adelante en la collecion se ejecuta el while
            array[index + i++]=iterator.next();//aca simplemente va agregando esos elementos desde el indice dado
        }
        size +=collection.size(); //y se le suma al size los elementos que se le agregaron
        return true;
    }

    @Override
    public E get(int index){
        if(index<0||index>=size){//Se valora que el indice este dentro del array
            return null;
        }
        return (array[index]);//simplemente se agarra el elemento que estaba en ese indice
    }

    @Override
    public int indexOf(E element){ //Se quiere hallar el indice de ese elemento(Agarraria el primero)
        for(int i=0; i<size;i++){
            if(array[i].equals(element)){//Empieza desde el inicio del array buscando y lo retorna apenas empieza
                return i;
            }
        }
        return -1; //si no encuentra el elemento dentro del array, retorna un -1 diciendo que no esta dentro del array
    }
    @Override
    public int lastIndexOf(E element){//Encuentra el último indice que contiene ese elemento
        for(int i=size-1; i>=0;i--){//Lo mismo que el anterior pero empezando desde el final del array(Final de elementos que tienen valor, osea ignora los nulls)
            if(array[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(int index){
        return remove(index,index);
    }

    @Override
    public boolean remove(int from, int to){
        if(from<0 || to>=size || from>to){ //Valora si se puede hacer la busqueda  y retorna false si no se puede
            return false;
        }
        int cambio= to-from+1;// dice cuantos elementos de van a eleminar, osea desde el incie 2-4 contando los elementos en el indice 2 y 4  ( 2,3,4) 4-2+1=3 
        for(int i=from; i<size-cambio;i++){//aca hace que solo recorra los indices que se van a eliminar
            array[i]=array[i+cambio]; //y los remplaza con los que estaban más adelante [0,2,3,5] (1-2) -> [0,5,null,nul] quedaria así
        }
        size-=cambio; //simplemente se le resta al size el número de elementos que se quitaron el ejemplo de arriba pasaria de 4 a 2
        return true;
    }

    @Override
    public boolean remove(Predicate<E> filter){ //Lo mismo, pura IA no se como chutas funciona
        if(filter ==null){
            return false;
        }
        int i=0;
        while(i<size){
            if(filter.test(array[i])){
                remove(i);
            }else{
                i++;
            }
        }
        return true;
    }

    @Override
    public boolean set(int index, E element){// aca simplemente se coloca el elemento en la posición del indice dada :)
        if(index <0 || index >= size){//se valora si el indice esta dentro del array 
            return false;
        }
        array[index]=element;
        return true;
    }

    @Override //Ya esta compacto, como se han estado cerrando espacios, el array se compacta :)
    public void defragment(){
    }

    @Override //ni pta idea como funciona esto :v
    public boolean dimension(int newDimension){
        return true;
    }
}
