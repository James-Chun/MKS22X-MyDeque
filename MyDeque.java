import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int size, start, end;

//--------------------------------------------------------------------------------------------------------------------------
//start and end may be negative meaning they're relative to the end of data.
// start = -1 means start value is at the end of data, start = -2 means start value is at 2 to last position of data.
// the same applies for end, its just end will always be ahead of start.



    @SuppressWarnings("unchecked")
    public MyDeque(){     //default constuctor that makes new data of size 10 and sets start, end, and size to 0;
        data = (E[])new Object[10];
        start=0;end=-1;size=0;
    }
    //end is -1 because if start == end then that would indicate data is not empty
    //once you start adding or removing then start and end will align properly (remember exceptions are there to catch bad scenarios)

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){    //custom constuctor that makes data of specified size and sets start, end, and size to 0 (cause technically there are no values in it yet)
        data = (E[])new Object[initialCapacity];
        start=0;end=-1;size=0;
    }


    public int size(){    //simply return size
      return size;
    }

    public int sizeDebug(){   //return the length of the entire data
      return data.length;
    }


    public String toString(){   //print data as it should be viewed
        String visual = "{";
        for (int i=start; i<=end; i++){
          if (i<0){                           //start and end may be less than 0 so check for that
              visual = visual + data[i+data.length];
          }
          else{
              visual = visual + data[i];
          }
          if (start<end){
            visual+=" ";
          }
        }
        return visual + "}";
    }

    public String toStringDebug(){    //print the raw state of data
        String visual = "{";
        for (int i=0; i<data.length; i++){
          if (i<0){
              visual = visual + data[data.length+start];
          }
          else{
              visual = visual + data[i];
          }
          if (start<data.length-1){
              visual+=" ";
          }
        }
        return visual + "}";
    }


//--------------------------------------------------------------------------------------------------------------------------


    public void addFirst(E element) throws NullPointerException{
        if (element == null){
            throw new NullPointerException("Specified Element Cannot Be Null");
        }
        if (start-1<0){
            if (start*-1==data.length-1 || size==data.length){//either start goes back so much it reaches index 0 again or data is filled
                resize();
            }
            start--;
            data[data.length+start]=element;
            size++;
        }
        else{ //if start is not going to be negative then you have some space in the front of data to fill in (hence no resize)
            start--;
            data[start]=element;
            size++;
        }
    }

    public void addLast(E element) throws NullPointerException{
        if (element == null){
            throw new NullPointerException("Specified Element Cannot Be Null");
        }
        if (end ==data.length-1 || size==data.length){ //end could still reach the last index of data with size < data.length because of where start and end are positioned
          resize();
        }
        end++;
        if (end<0){
          data[data.length+end]=element;    //end could be less than 0 if you constantly removeLast()
        }
        else{
          data[end] = element;
        }
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(){        //resize data (relies on the current positions of start and end before you indent to add)
        E[] d = (E[])new Object[data.length*2];
        for (int i=start;i<=end; i++){
            if (i<0){             //just like toString the start and end may be both less than 0 so check
                d[d.length+i]=data[data.length+i];
            }
            else{
                d[i]=data[i];
            }
        }
        data = d;
    }


//--------------------------------------------------------------------------------------------------------------------------
//all the methods from now on have to account for when start or end are going to be negative

    public E removeFirst() throws NoSuchElementException{
        if (start<0){
            if (data[start+data.length]==null){
                throw new NoSuchElementException("List Is Empty");
            }
            E removed = data[data.length+start];
            data[data.length+start]=null;
            start++;
            size--;
            return removed;
        }
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
        if (end <0){
            if (data[end+data.length]==null){
                throw new NoSuchElementException("List Is Empty");
            }
            E removed = data[end+data.length];
            data[end+data.length]=null;
            end--;
            size--;
            return removed;
        }


        if (data[end]==null){
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
        if (start<0){
            if (data[start+data.length]==null){
                throw new NoSuchElementException("List Is Empty : 1");
            }
            return data[start+data.length];
        }
        if (data[start]==null){
            throw new NoSuchElementException("List Is Empty: 1");
        }
        return data[start];
    }

    public E getLast() throws NoSuchElementException{
        if (end <0){
            if (data[data.length+end]==null){
                throw new NoSuchElementException("List Is Empty : 2");
            }
            return data[end+data.length];
        }
        if (data[end]==null ){
            throw new NoSuchElementException("List Is Empty : 2");
        }
        return data[end];
    }


//--------------------------------------------------------------------------------------------------------------------------




    public static void main(String[] args){
      MyDeque<Integer> test = new MyDeque<Integer>();

      String words = "abcdefghijk";
      //test.getFirst();
      /*
      for (int i=0;i<words.length();i++){
          test.addLast(words.charAt(i));
      }
      for (int i=0;i<words.length();i++){
          test.addLast(words.charAt(i));
      }*/
      for (int i =0;i<499;i++){
          //test.addFirst(i);
          test.addLast(i);
          test.removeFirst();
          //System.out.println(test.toStringDebug());
      }
      /*
      for (int i=500;i<550;i++){
        test.addLast(i);
      }*/

      //test.removeLast();
      //System.out.println(test);
      System.out.println(test.toStringDebug());
      System.out.println(test.size());
      System.out.println(test.getFirst());
      System.out.println(test.getLast());
      //System.out.println(test.sizeDebug());
    }
}
