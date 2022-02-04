import java.util.EnumMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import poker.Hand;
import poker.Card;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GradingTest 
{
    // list of hands from wikipedia, https://en.wikipedia.org/wiki/List_of_poker_hands, no jokers in the deck
    private enum RankedHands
    {
        HIGH_CARD,ONE_PAIR,TWO_PAIR,THREE_OF_A_KIND,STRAIGHT,FLUSH,FULL_HOUSE,FOUR_OF_A_KIND,STRAIGHT_FLUSH;
    }



    private final String four_5s = "{'cards':[{'suite':'SPADES','value':'FIVE'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";
    private final String three_5s = "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";

    
    private final String straight_flush = "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";

    private static final Logger LOGGER = LogManager.getLogger(GradingTest.class);

    
    @Test
    void compare_each_ranked_hand() 
    {
        // This test will check for the basics, higher ranked hands win over lower ranked hands.
        //
        // An array of the ranked hands is built. Then the array is checked 
        // For a given Ranked hand,LowRanked is always beat by HighRanked

        EnumMap<RankedHands,String> LowRanked = new EnumMap<RankedHands,String>(RankedHands.class);

        LowRanked.put(RankedHands.HIGH_CARD,        "{'cards':[{'suite':'SPADES','value':'TWO'},{'suite':'CLUBS','value':'FOUR'},{'suite':'CLUBS','value':'SIX'},{'suite':'HEARTS','value':'EIGHT'},{'suite':'SPADES','value':'NINE'}]}");
        LowRanked.put(RankedHands.ONE_PAIR,         "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'SIX'},{'suite':'SPADES','value':'ACE'}]}");
        LowRanked.put(RankedHands.TWO_PAIR,         "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FOUR'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}");
        LowRanked.put(RankedHands.THREE_OF_A_KIND,  "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FOUR'},{'suite':'CLUBS','value':'FOUR'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}");
        LowRanked.put(RankedHands.STRAIGHT,         "{'cards':[{'suite':'SPADES','value':'TWO'},{'suite':'DIAMONDS','value':'THREE'},{'suite':'CLUBS','value':'FOUR'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'SIX'}]}");
        LowRanked.put(RankedHands.FLUSH,            "{'cards':[{'suite':'DIAMONDS','value':'TWO'},{'suite':'DIAMONDS','value':'THREE'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'DIAMONDS','value':'SEVEN'},{'suite':'DIAMONDS','value':'NINE'}]}");
        LowRanked.put(RankedHands.FULL_HOUSE,       "{'cards':[{'suite':'SPADES','value':'SIX'},{'suite':'DIAMONDS','value':'SIX'},{'suite':'CLUBS','value':'SIX'},{'suite':'HEARTS','value':'TEN'},{'suite':'SPADES','value':'TEN'}]}");
        LowRanked.put(RankedHands.FOUR_OF_A_KIND,   "{'cards':[{'suite':'SPADES','value':'THREE'},{'suite':'DIAMONDS','value':'THREE'},{'suite':'CLUBS','value':'THREE'},{'suite':'HEARTS','value':'THREE'},{'suite':'SPADES','value':'ACE'}]}");
        LowRanked.put(RankedHands.STRAIGHT_FLUSH,   "{'cards':[{'suite':'CLUBS','value':'TEN'},{'suite':'CLUBS','value':'NINE'},{'suite':'CLUBS','value':'EIGHT'},{'suite':'CLUBS','value':'SEVEN'},{'suite':'CLUBS','value':'SIX'}]}");


        EnumMap<RankedHands,String> HighRanked = new EnumMap<RankedHands,String>(RankedHands.class);

        HighRanked.put(RankedHands.HIGH_CARD,        "{'cards':[{'suite':'DIAMONDS','value':'TWO'},{'suite':'DIAMONDS','value':'FOUR'},{'suite':'SPADES','value':'SIX'},{'suite':'DIAMONDS','value':'EIGHT'},{'suite':'SPADES','value':'TEN'}]}");
        HighRanked.put(RankedHands.ONE_PAIR,         "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'SIX'},{'suite':'CLUBS','value':'SIX'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}");
        HighRanked.put(RankedHands.TWO_PAIR,         "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FOUR'},{'suite':'CLUBS','value':'SIX'},{'suite':'HEARTS','value':'SIX'},{'suite':'SPADES','value':'ACE'}]}");
        HighRanked.put(RankedHands.THREE_OF_A_KIND,  "{'cards':[{'suite':'SPADES','value':'SIX'},{'suite':'DIAMONDS','value':'SIX'},{'suite':'CLUBS','value':'SIX'},{'suite':'HEARTS','value':'TWO'},{'suite':'SPADES','value':'ACE'}]}");
        HighRanked.put(RankedHands.STRAIGHT,         "{'cards':[{'suite':'SPADES','value':'THREE'},{'suite':'DIAMONDS','value':'FOUR'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'SIX'},{'suite':'SPADES','value':'SEVEN'}]}");
        HighRanked.put(RankedHands.FLUSH,            "{'cards':[{'suite':'SPADES','value':'KING'},{'suite':'SPADES','value':'SIX'},{'suite':'SPADES','value':'FIVE'},{'suite':'SPADES','value':'TEN'},{'suite':'SPADES','value':'ACE'}]}");
        HighRanked.put(RankedHands.FULL_HOUSE,       "{'cards':[{'suite':'SPADES','value':'SEVEN'},{'suite':'DIAMONDS','value':'SEVEN'},{'suite':'CLUBS','value':'SEVEN'},{'suite':'HEARTS','value':'KING'},{'suite':'SPADES','value':'KING'}]}");
        HighRanked.put(RankedHands.FOUR_OF_A_KIND,   "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FOUR'},{'suite':'CLUBS','value':'FOUR'},{'suite':'HEARTS','value':'FOUR'},{'suite':'SPADES','value':'ACE'}]}");
        HighRanked.put(RankedHands.STRAIGHT_FLUSH,   "{'cards':[{'suite':'CLUBS','value':'TEN'},{'suite':'CLUBS','value':'NINE'},{'suite':'CLUBS','value':'EIGHT'},{'suite':'CLUBS','value':'SEVEN'},{'suite':'CLUBS','value':'SIX'}]}");
        HighRanked.put(RankedHands.STRAIGHT_FLUSH,   "{'cards':[{'suite':'SPADES','value':'QUEEN'},{'suite':'SPADES','value':'JACK'},{'suite':'SPADES','value':'TEN'},{'suite':'SPADES','value':'NINE'},{'suite':'SPADES','value':'EIGHT'}]}");

        LOGGER.debug("Test Each Type of Hand against each other"); 

        int num_tests=0;
        int passCount=0;

        // the fortran in me is deep, i have to use i,j for an index
        for (RankedHands i : RankedHands.values())
        {
            boolean expectedResult = true;
            for (RankedHands j : RankedHands.values())
            {
              // loop goes low to high
              LOGGER.debug(i+" :  "+j);

              // turn it into json
              Gson gson = new Gson();

              Hand Hand1 = new Hand();
              Hand1 = gson.fromJson( LowRanked.get(i),Hand.class );

              Hand Hand2 = new Hand();
              Hand2 = gson.fromJson( HighRanked.get(j),Hand.class );
              
              LOGGER.debug("comparing "+i+" with "+j);
              LOGGER.debug("  hand1 "+i+" "+HighRanked.get(j));
              LOGGER.debug("  hand2 "+j+" "+LowRanked.get(i));
              num_tests=num_tests+1;
              boolean result = Hand1.is_better_than(Hand2);
              LOGGER.debug("  is hand1 better than hand2? "+result);
              LOGGER.debug("                     expected "+expectedResult);
              if (expectedResult != result)
              {
                 LOGGER.debug("                    FAIL");
              }
              else
              {
                 LOGGER.debug("                    PASS");
                 passCount = passCount + 1;
              }
              //assertTrue(Hand1.is_better_than(Hand2));
              //assertTrue(!Hand2.is_better_than(Hand1));

              if (j.equals(i)) 
              {
                  expectedResult = false;
              }

            }

        }
        LOGGER.debug("num tests "+num_tests);
        LOGGER.debug("passed "+passCount);

        assertTrue(num_tests==passCount);
    }

}
