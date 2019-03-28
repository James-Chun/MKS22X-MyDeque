import java.util.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    //private static String[] stuff;
    public static double eval(String s){

      MyDeque<Double> valuesBeingEvaluated = new MyDeque<>();

      String[] valuesToBeEvaluated = s.split(" ");

      double temp = 0.0;
      for (int i=0;i<valuesToBeEvaluated.length;i++){//if int add to deque if not take last two ints and do operations and then remove add accordingly

          try{
            valuesBeingEvaluated.addLast( Double.parseDouble( valuesToBeEvaluated[i]) );
          }catch(Exception NumberFormatException){}


          if (valuesToBeEvaluated[i] == "+"){
              temp = valuesBeingEvaluated.removeFirst() + valuesBeingEvaluated.removeFirst();
              valuesBeingEvaluated.addLast( temp );

                        System.out.println(valuesToBeEvaluated[i]);
          }
          else if (valuesToBeEvaluated[i] == "-"){
              valuesBeingEvaluated.addLast( valuesBeingEvaluated.removeFirst() - valuesBeingEvaluated.removeFirst() );

                        System.out.println(valuesToBeEvaluated[i]);
          }
          else if (valuesToBeEvaluated[i] == "*"){
              valuesBeingEvaluated.addLast( valuesBeingEvaluated.removeFirst() * valuesBeingEvaluated.removeFirst() );
                        System.out.println(valuesToBeEvaluated[i]);
          }
          else if (valuesToBeEvaluated[i] == "/"){
            temp = valuesBeingEvaluated.removeFirst() / valuesBeingEvaluated.removeFirst();
            valuesBeingEvaluated.addLast( temp );
                      System.out.println(valuesToBeEvaluated[i]);
          }
          else if (valuesToBeEvaluated[i] == "%"){
              valuesBeingEvaluated.addLast( valuesBeingEvaluated.removeFirst() % valuesBeingEvaluated.removeFirst() );
                        System.out.println(valuesToBeEvaluated[i]);
          }


      }
      return valuesBeingEvaluated.getLast();
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
      System.out.println( eval("1 2 +") );
      //System.out.println( "" + 1.0 + 2.0 );

      /*MyDeque<Double> v = new MyDeque<>();
      v.addLast(1.0);
      v.addLast(2.0);
      double temp = v.removeFirst() + v.removeFirst();
      v.addLast(temp);
      System.out.println(v.getFirst());*/
    }

}
