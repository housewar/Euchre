package Game;

import CardDeck.Card;
import Participants.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Trick_Test {

    @Test
    public void test_Trick_Constructor(){
        Trick trick = new Trick( Card.Suit.SPADES );
        assertEquals( Card.Suit.SPADES , trick.getTrump() );
    }

}
