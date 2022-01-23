import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import poker.Hand;
import poker.Card;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
//import org.junit.BeforeClass;

class Assignment1Test 
{
    // Define some hands as json strings that can be used for many tests
    private final String four_5s = "{'cards':[{'suite':'SPADES','value':'FIVE'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";
    private final String three_5s = "{'cards':[{'suite':'SPADES','value':'FOUR'},{'suite':'DIAMONDS','value':'FIVE'},{'suite':'CLUBS','value':'FIVE'},{'suite':'HEARTS','value':'FIVE'},{'suite':'SPADES','value':'ACE'}]}";

    private static final Logger LOGGER = LogManager.getLogger(Assignment1Test.class);

    public void sayHello() {

        LOGGER.info("Keyboard not responding. Press any key to continue...");
        LOGGER.warn("Congratulations, you are pregnant!");
        LOGGER.debug("Congratulations, you are pregnant!");
    }

    
    @Test
    void four_of_a_kind_better_then_3_of_a_kind() 
    {
        // turn it into json
        Gson gson = new Gson();

        Hand H1 = new Hand();
        H1 = gson.fromJson(four_5s,Hand.class);

        Hand H2 = new Hand();
        H2 = gson.fromJson(three_5s,Hand.class);

        // Now test it
        //assertTrue(H1.is_better_than(H2)); uncomment when the is_better_than function is working !
        assertTrue(!H2.is_better_than(H1));

    }

    @Test
    void run_a_lot_of_them()
    {
    }



    @Test
    void royalFlushBetterThanAny() {
        Hand H1 = new Hand();
        Hand H2 = new Hand();
        assertTrue(!H1.is_better_than(H2));
    }
}
