
public class MyDeque<E>{
    private E[] data;
    private int size, start, end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[])new Object[10];
        start = 0;
        end = 9;
        size = 10;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
        start = 0;
        end = initialCapacity - 1;
        size = 0;
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

    public void addLast(E element){
        if (end==data.length-1){
          resize();
        }
        data[end+1] = element;
        size++;
    }

    public E removeFirst(){
        E removed = data[start];
        data[start]=null;
        start++;
        size--;
        return removed;
    }
    public E removeLast(){
        E removed = data[end];
        data[end]=null;
        end--;
        size--;
        return removed;
    }


    public E getFirst(){
        return data[start];
    }
    public E getLast(){
        return data[end];
    }


    @SuppressWarnings("unchecked")
    private void resize(){
      E[] d = (E[])new Object[size*2];
      data = d;
    }


    public static void main(String[] args){
      MyDeque<String> test = new MyDeque<String>();

      test.removeFirst();
      test.removeLast();
      System.out.println(test);
    }
}
