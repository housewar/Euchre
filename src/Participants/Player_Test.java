package Participants;

import CardDeck.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class Player_Test {
    @Test
    public void test_PlayerHand_isEmpty(){
        Player player = new Player();
        assertTrue( player.handIsEmpty() );
    }
    @Test
    public void test_PlayerHand_addCard(){
        Player player = new Player();
        player.addToHand( new Card ( Card.Rank.ACE , Card.Suit.SPADES ) );
        assertFalse( player.handIsEmpty() );
    }
    @Test
    public void test_PlayerHand_getCard(){
        Player player = new Player();
        Card aceSpades = new Card ( Card.Rank.ACE , Card.Suit.SPADES );
        player.addToHand( aceSpades );
        assertEquals( aceSpades , player.getCard( 0 ));
    }
    @Test
    public void test_PlayerHand_getNumberOfCards(){
        Player player = new Player();
        Card aceSpades = new Card ( Card.Rank.ACE , Card.Suit.SPADES );
        Card aceClubs = new Card ( Card.Rank.ACE , Card.Suit.CLUBS );
        player.addToHand( aceSpades );
        assertEquals( 1 , player.getNumberOfCardsInHand() );
        player.addToHand( aceClubs );
        assertEquals( 2 , player.getNumberOfCardsInHand() );
    }
    @Test
    public void test_PlayerHand_playerInitiatedSelfReferential(){
        Player player = new Player();
        assertEquals( player , player.getPlayerToLeft() );
    }
    @Test
    public void test_PlayerHand_setPlayerToLeft(){
        Player player = new Player();
        Player another = new Player();
        player.setPlayerToLeft( another );
        assertEquals( another , player.getPlayerToLeft() );
    }
}
