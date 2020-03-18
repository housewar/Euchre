package Participants;

import CardDeck.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class Player_Test {
    @Test
    public void test_PlayerConstructor(){
        Player player = new Player();
        assertTrue( player instanceof Player );
    }
    @Test
    public void test_PlayerHand(){
        Player player = new Player();
        assertTrue( player.handIsEmpty() );
        Card aceSpades = new Card ( Card.Rank.ACE , Card.Suit.SPADES );
        player.addToHand( aceSpades );
        assertEquals( aceSpades , player.getCard( 0 ));
    }
}
