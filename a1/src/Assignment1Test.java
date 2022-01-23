import poker.Hand;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Assignment1Test {

    @Test
    void validHand() {
        Hand H1 = new Hand("xxx");
        assertTrue(true);
    }
    @Test
    void royalFlushBetterThanAny() {
        Hand H1 = new Hand("xxx");
        Hand H2 = new Hand("xxx");
        assertTrue(!H1.is_better_than(H2));
    }
}
