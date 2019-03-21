

public class MyDeque<E>{
    private E[] data;
    private int size, start, end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
        data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
    }
    public int size(){
      return data.length;
    }
    public String toString(){
        String visual = "{";
        for (int i=0; i<data.length; i++){
          visual = visual + data[i] + " ";
        }
        return visual + "}";
    }

    public static void main(String[] args){
      MyDeque<String> test = new MyDeque<String>();
      System.out.println(test);
    }
}
