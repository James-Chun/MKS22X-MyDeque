import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int size, start, end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[])new Object[10];
        start=0;end=0;size=0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
        start=0;end=0;size=0;
    }


    public int size(){
      return size;
    }


    public String toString(){
        String visual = "{";
        for (int i=start; i<=end; i++){
          visual = visual + data[i] + " ";
        }
        return visual + "}";
    }

    //public void addFirst(E element){size++;}

    public void addLast(E element){     //move start back?!?!?!?!?!!???!?!?!?!?!?!?!?!?!?!!?!?!?!?
        if (end==data.length-1){        //In Nathan We Trust
          resize();
        }
        end++;
        data[end] = element;
        size++;
    }


    public E removeFirst() throws NoSuchElementException{
        if (data[start]==null){
            throw new NoSuchElementException("List Is Empty");
        }
        E removed = data[start];
        data[start]=null;
        start++;
        size--;
        return removed;
    }
    public E removeLast() throws NoSuchElementException{
        if (data[end]==null){
            throw new NoSuchElementException("List Is Empty");
        }
        E removed = data[end];
        data[end]=null;
        end--;                      // REMOVE STILL REMOVES THE NULL AND MESSES UP THE START AND END ORDER
        size--;                     // ASDHHASUBETUBASOBCOUEBHTUOABOSFBUEBIWHEBVUDBVHIJBSYEBIAEB
        return removed;
    }


    public E getFirst() throws NoSuchElementException{
        if (data[start]==null){
            throw new NoSuchElementException("List Is Empty");
        }
        return data[start];
    }
    public E getLast() throws NoSuchElementException{
        if (data[end]==null){
            throw new NoSuchElementException("List Is Empty");
        }
        return data[end];
    }


    @SuppressWarnings("unchecked")
    private void resize(){
      E[] d = (E[])new Object[data.length*2];
      data = d;
    }


    public static void main(String[] args){
      MyDeque<String> test = new MyDeque<String>();

      
      test.removeFirst();
      test.removeLast();
      System.out.println(test);
    }
}
