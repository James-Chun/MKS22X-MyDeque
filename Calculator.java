import java.util.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    //private static String[] stuff;
    public static double eval(String s){

      MyDeque<Double> valuesBeingEvaluated = new MyDeque<>();

      String[] valuesToBeEvaluated = s.split(" ");


      for (int i=0;i<valuesToBeEvaluated.length;i++){//if int add to deque if not take last two ints and do operations and then remove add accordingly

          try{
            valuesBeingEvaluated.addLast( Double.parseDouble( valuesToBeEvaluated[i]) );
          }catch(Exception NumberFormatException){}


          if (valuesToBeEvaluated[i].equals("+")){
              double secondValue = valuesBeingEvaluated.removeLast();
              double firstValue = valuesBeingEvaluated.removeLast();
              valuesBeingEvaluated.addLast( firstValue + secondValue );
          }
          else if (valuesToBeEvaluated[i].equals("-")){
              double secondValue = valuesBeingEvaluated.removeLast();
              double firstValue = valuesBeingEvaluated.removeLast();
              valuesBeingEvaluated.addLast( firstValue - secondValue );
          }
          else if (valuesToBeEvaluated[i].equals("*")){
              double secondValue = valuesBeingEvaluated.removeLast();
              double firstValue = valuesBeingEvaluated.removeLast();
              valuesBeingEvaluated.addLast( firstValue * secondValue );
          }
          else if (valuesToBeEvaluated[i].equals("/")){
              double secondValue = valuesBeingEvaluated.removeLast();
              double firstValue = valuesBeingEvaluated.removeLast();
              valuesBeingEvaluated.addLast( firstValue / secondValue );
          }
          else if (valuesToBeEvaluated[i].equals("%")){
              double secondValue = valuesBeingEvaluated.removeLast();
              double firstValue = valuesBeingEvaluated.removeLast();
              valuesBeingEvaluated.addLast( firstValue % secondValue );
          }


      }
      return valuesBeingEvaluated.getFirst();
    }

/*
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
*/

    public static void main(String[] args){
      //eval("10 2 3 4 5 + * - -");
      //System.out.println(visual());
      //eval("10 2.0 +") is 12.0
    //  eval("11 3 - 4 + 2.5 *") is 30.0
    //  eval("8 2 + 99 9 - * 2 + 9 -") is 893.0
    //  eval("1 2 3 4 5 + * - -") is 26.0
      System.out.println( eval("8 2 + 99 9 - * 2 + 9 -") );
      //System.out.println( "" + 1.0 + 2.0 );

      /*MyDeque<Double> v = new MyDeque<>();
      v.addLast(1.0);
      v.addLast(2.0);
      double temp = v.removeFirst() + v.removeFirst();
      v.addLast(temp);
      System.out.println(v.getFirst());*/
    }

}
