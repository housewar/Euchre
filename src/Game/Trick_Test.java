package Game;

import CardDeck.Card;
import Participants.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class Trick_Test {

    @Test
    public void test_Trick_Constructor(){
        Trick trick = new Trick( Card.Suit.SPADES );
        assertEquals( Card.Suit.SPADES , trick.getTrump() );
    }
    @Test
    public void test_addPlayerCard(){
        Trick trick = new Trick( Card.Suit.SPADES );
        Player player = new Player();
        Card aceSpades = new Card ( Card.Rank.ACE , Card.Suit.SPADES );
        Card nineHearts = new Card ( Card.Rank.NINE , Card.Suit.HEARTS );
        PlayerCard playerAceSpades = new PlayerCard( player , aceSpades );
        assertTrue( trick.addPlayerCard( player , nineHearts ) );
        assertTrue( trick.addPlayerCard( playerAceSpades ) );
    }
    @Test
    public void test_getTrump_getLead(){
        Trick trick = new Trick( Card.Suit.SPADES );
        Player player = new Player();
        Card aceSpades = new Card ( Card.Rank.ACE , Card.Suit.SPADES );
        Card nineHearts = new Card ( Card.Rank.NINE , Card.Suit.HEARTS );
        PlayerCard playerAceSpades = new PlayerCard( player , aceSpades );
        trick.addPlayerCard( player , nineHearts );
        trick.addPlayerCard( playerAceSpades );
        assertEquals( Card.Suit.HEARTS , trick.getLead() );
        assertEquals( Card.Suit.SPADES , trick.getTrump() );
    }
    @Test
    public void test_getHighPlayerCard_HighestLead_NoTrump(){
        Trick trick = new Trick( Card.Suit.SPADES );
        Player player1 = new Player();
        Player player2 = new Player();
        Card nineHearts = new Card ( Card.Rank.NINE , Card.Suit.HEARTS );
        Card aceHearts = new Card ( Card.Rank.ACE , Card.Suit.HEARTS );
        trick.addPlayerCard( player1 , nineHearts );
        trick.addPlayerCard( player2 , aceHearts );
        PlayerCard highPlayerCard = trick.getHighPlayerCard();
        assertEquals( aceHearts , highPlayerCard.getCard() );
        assertEquals( player2 , highPlayerCard.getPlayer() );
    }
}
