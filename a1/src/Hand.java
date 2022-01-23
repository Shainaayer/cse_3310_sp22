package poker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Hand
{
    public enum Suite
    {
       HEARTS,CLUBS,DIAMONS,SPADES
    }

    public enum Value
    {
       ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,
       TEN,JACK,QUEEN,KING 
    }

    private class Card
    {
       Suite suite;
       Value value;
    }
  
    Card[] cards;
    
    public Hand(String s)
    {
        System.out.println("in the Hand constructor");
    }

    public boolean is_better_than(Hand H)
    {
        return false;
    }
}
