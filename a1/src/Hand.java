package poker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import poker.Card;

public class Hand
{
    //private transient int i=10;
    // marked transient they will not serialized / deserialized

    public Card[] cards;

    public Hand()
    {
    }

    public boolean is_better_than(Hand H)
    {
        return false;
    }
   
   public boolean is_equal(Hand H)
   {
       return false;
   }
}
