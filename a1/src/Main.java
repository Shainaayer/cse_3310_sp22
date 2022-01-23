import com.google.gson.Gson; 
import com.google.gson.GsonBuilder; 
import poker.Hand;
import poker.Card;


public class Main 
{

  public static void main(String[] args) 
  {
     // this function is provided as a convenient way to
     // run the code from the command line.
     //
     // it will not be graded, but it needs to compile and
     // execute without a failure.

     System.out.println("Start");

     // Demonstrate converting json in and out of a 'Hand'
     //
     Hand H1 = new Hand();

     // allocate space for 5 card references
     H1.cards = new Card[5];
     H1.cards[0] = new Card();
     H1.cards[0].suite = Card.Suite.valueOf("SPADES");
     H1.cards[0].value = Card.Value.valueOf("FIVE");
     H1.cards[1] = new Card();
     H1.cards[1].suite = Card.Suite.valueOf("SPADES");
     H1.cards[1].value = Card.Value.valueOf("FOUR");
     H1.cards[2] = new Card();
     H1.cards[2].suite = Card.Suite.valueOf("SPADES");
     H1.cards[2].value = Card.Value.valueOf("THREE");
     H1.cards[3] = new Card();
     H1.cards[3].suite = Card.Suite.valueOf("SPADES");
     H1.cards[3].value = Card.Value.valueOf("TWO");
     H1.cards[4] = new Card();
     H1.cards[4].suite = Card.Suite.valueOf("SPADES");
     H1.cards[4].value = Card.Value.valueOf("ACE");

     // turn it into json
     Gson gson = new Gson();
     String jsonString = gson.toJson(H1);
     System.out.println(jsonString);

     // and back into a "hand"
     Hand H3 = new Hand();
     H3 = gson.fromJson(jsonString,Hand.class);

     // change something
     H3.cards[4].suite = Card.Suite.valueOf("DIAMONDS");
     H3.cards[4].value = Card.Value.valueOf("FIVE");

     // show that it works
     System.out.println(gson.toJson(H3));

     // show the comparison function
     Hand H2 = new Hand();
     H2 = H1;


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
