import com.google.gson.Gson; 
//import com.google.gson.GsonBuilder; 
import poker.Hand;

public class Main 
{

  public static void main(String[] args) 
  {
     System.out.println("Start");
     Gson gson = new Gson();
     Hand H1 = new Hand("{'cards':[{'CARD':'FIVE','SUITE':'HEARTS'},{'CARD':'FIVE','SUITE':'CLUBS'},{'CARD':'FIVE','SUITE':'DIAMONDS'},{'CARD':'FIVE','SUITE':'SPADES'},{'CARD':'ACE','SUITE':'HEARTS'}]}"); 
     Hand H2 = new Hand("{'cards':[{'CARD':'FIVE','SUITE':'HEARTS'},{'CARD':'FIVE','SUITE':'CLUBS'},{'CARD':'FIVE','SUITE':'DIAMONDS'},{'CARD':'FIVE','SUITE':'SPADES'},{'CARD':'ACE','SUITE':'SPADES'}]}"); 

     if (H1.is_better_than(H2)) 
     {
        System.out.println("hand1 is better than hand2");
     }

     if (H2.is_better_than(H1))
     {
        System.out.println("hand2 is better than hand1");
     }
     System.out.println("End");

  }

}
