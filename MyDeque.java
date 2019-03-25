import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int size, start, end;

//--------------------------------------------------------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    public MyDeque(){     //default constuctor that makes new data of size 10 and sets start, end, and size to 0;
        data = (E[])new Object[10];
        start=0;end=-1;size=0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){    //custom constuctor that makes data of specified size and sets start, end, and size to 0 (cause technically there are no values in it yet)
        data = (E[])new Object[initialCapacity];
        start=0;end=-1;size=0;
    }


    public int size(){    //simply return size
      return size;
    }

    public int sizeDebug(){
      return data.length;
    }


    public String toString(){
        String visual = "{";
        for (int i=start; i<=end; i++){
          visual = visual + data[i];
          if (start<end){
            visual+=" ";
          }
        }
        return visual + "}";
    }

    public String toStringDebug(){
        String visual = "{";
        for (int i=start; i<data.length; i++){
          visual = visual + data[i];
          if (start<data.length-1){
            visual+=" ";
          }
        }
        return visual + "}";
    }


//--------------------------------------------------------------------------------------------------------------------------

  @SuppressWarnings("unchecked")
    public void addFirst(E element) throws NullPointerException{
        if (element == null){
            throw new NullPointerException("Specified Element Cannot Be Null");
        }
        E[] d = (E[])new Object[data.length*2];
        d[start]=element;
        for (int i=start;i<=end;i++){
            d[i+1]=data[i];
        }
        data = d;
    }

    public void addLast(E element) throws NullPointerException{
        if (element == null){
            throw new NullPointerException("Specified Element Cannot Be Null");
        }
        if (end==data.length-1){
          resize();
        }
        end++;
        data[end] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        E[] d = (E[])new Object[data.length*2];
        for (int i=start;i<=end; i++){
            d[i]=data[i];
        }
        data = d;
    }


//--------------------------------------------------------------------------------------------------------------------------


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
        if (end == -1 || data[end]==null){
            throw new NoSuchElementException("List Is Empty");
        }
        E removed = data[end];
        data[end]=null;
        end--;
        size--;
        return removed;
    }


//--------------------------------------------------------------------------------------------------------------------------


    public E getFirst() throws NoSuchElementException{
        if (data[start]==null){
            throw new NoSuchElementException("List Is Empty");
        }
        return data[start];
    }
    public E getLast() throws NoSuchElementException{
        if (end == -1 || data[end]==null ){
            throw new NoSuchElementException("List Is Empty");
        }
        return data[end];
    }


//--------------------------------------------------------------------------------------------------------------------------




    public static void main(String[] args){
      MyDeque<Character> test = new MyDeque<Character>();

      String words = "abcdefghijk";
      //test.getFirst();
      for (int i=0;i<words.length();i++){
          test.addLast(words.charAt(i));
      }
      test.addFirst('p');
      test.addLast('j');
      //test.removeFirst();
      //test.removeLast();
      System.out.println(test);
      //System.out.println(test.size());
      //System.out.println(test.toStringDebug());
      //System.out.println(test.sizeDebug());
    }
}
