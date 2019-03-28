public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
     private static String[] stuff;
    public static double eval(String s){
      MyDeque<Integer> instructions = new MyDeque<>();

      stuff = s.split(" ");
      for (int i=0;i<s.length();i++){
          //if ()   //need way to check for spaces (probably some parse or whatever Scanner thing)
                  //if int add to deque if not take last two ints and do operations and then remove add accordingly

      }
      return 0.0;
    }


    public static String visual(){
      String visual = "";
      for (int i=0;i<stuff.length;i++){
        visual += stuff[i];
        if (i<stuff.length-1){
          visual += " ";
        }
      }
      return visual;
    }

    public static void main(String[] args){
      eval("10 2 3 4 5 + * - -");
      System.out.println(visual());
    }

}
