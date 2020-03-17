package Game;

import CardDeck.Card;
import CardDeck.Cards;
import Participants.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerCards_Test {

    @Test
    public void test_playerCards_Constructor(){
        PlayerCards playerCards = new PlayerCards();
        assertTrue( playerCards.getPlayerCards() instanceof ArrayList);
    }
    @Test
    public void test_playerCards_isEmpty_size(){
        PlayerCards playerCards = new PlayerCards();
        assertTrue( playerCards.getPlayerCards() instanceof ArrayList);
        assertTrue( playerCards.isEmpty() );
        assertEquals( 0 , playerCards.getPlayerCards().size() );
        assertEquals( 0 , playerCards.getNumberOfCards() );
    }
    @Test
    public void test_playerCards_add_get_size(){
        PlayerCards playerCards = new PlayerCards();
        Player player = new Player();
        Card[] cards = new Card[4];
        cards[0] = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.CLUBS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.HEARTS );
        PlayerCard[] playerCardArr = new PlayerCard[4];
        playerCardArr[0] = new PlayerCard( player , cards[0] );
        playerCardArr[1] = new PlayerCard( player , cards[1] );
        playerCardArr[2] = new PlayerCard( player , cards[2] );
        playerCardArr[3] = new PlayerCard( player , cards[3] );
        playerCards.add( playerCardArr[0] );
        playerCards.add( playerCardArr[1] );
        playerCards.add( playerCardArr[2] );
        playerCards.add( playerCardArr[3] );
        assertEquals( playerCardArr[0] , playerCards.get(0) );
        assertEquals( playerCardArr[1] , playerCards.get(1) );
        assertEquals( playerCardArr[2] , playerCards.get(2) );
        assertEquals( playerCardArr[3] , playerCards.get(3) );
        assertFalse( playerCards.isEmpty() );
        assertEquals( 4 , playerCards.getNumberOfCards() );
    }
    @Test
    public void test_playerCards_remove(){
        PlayerCards playerCards = new PlayerCards();
        Player player = new Player();
        Card[] cards = new Card[4];
        cards[0] = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.CLUBS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.HEARTS );
        PlayerCard[] playerCardArr = new PlayerCard[4];
        playerCardArr[0] = new PlayerCard( player , cards[0] );
        playerCardArr[1] = new PlayerCard( player , cards[1] );
        playerCardArr[2] = new PlayerCard( player , cards[2] );
        playerCardArr[3] = new PlayerCard( player , cards[3] );
        playerCards.add( playerCardArr[0] );
        playerCards.add( playerCardArr[1] );
        playerCards.add( playerCardArr[2] );
        playerCards.add( playerCardArr[3] );
        playerCards.remove( 2 );
        assertEquals( playerCardArr[0] , playerCards.get(0) );
        assertEquals( playerCardArr[1] , playerCards.get(1) );
        assertEquals( playerCardArr[3] , playerCards.get(2) );
    }
    @Test
    public void test_playerCards_clear(){
        PlayerCards playerCards = new PlayerCards();
        Player player = new Player();
        Card[] cards = new Card[4];
        cards[0] = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.CLUBS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.HEARTS );
        PlayerCard[] playerCardArr = new PlayerCard[4];
        playerCardArr[0] = new PlayerCard( player , cards[0] );
        playerCardArr[1] = new PlayerCard( player , cards[1] );
        playerCardArr[2] = new PlayerCard( player , cards[2] );
        playerCardArr[3] = new PlayerCard( player , cards[3] );
        playerCards.add( playerCardArr[0] );
        playerCards.add( playerCardArr[1] );
        playerCards.add( playerCardArr[2] );
        playerCards.add( playerCardArr[3] );
        assertEquals( 4 , playerCards.getNumberOfCards() );
        playerCards.clear();
        assertTrue( playerCards.isEmpty() );
    }
    @Test
    public void test_playerCards_addAll(){
        PlayerCards playerCards = new PlayerCards();
        PlayerCards another = new PlayerCards();
        Player player = new Player();
        Card[] cards = new Card[4];
        cards[0] = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.CLUBS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.HEARTS );
        PlayerCard[] playerCardArr = new PlayerCard[4];
        playerCardArr[0] = new PlayerCard( player , cards[0] );
        playerCardArr[1] = new PlayerCard( player , cards[1] );
        playerCardArr[2] = new PlayerCard( player , cards[2] );
        playerCardArr[3] = new PlayerCard( player , cards[3] );
        playerCards.add( playerCardArr[0] );
        playerCards.add( playerCardArr[1] );
        playerCards.add( playerCardArr[2] );
        playerCards.add( playerCardArr[3] );
        another.addAll(playerCards);
        assertEquals( playerCards.get(0) , another.get(0) );
        assertEquals( playerCards.get(1) , another.get(1) );
        assertEquals( playerCards.get(2) , another.get(2) );
        assertEquals( playerCards.get(3) , another.get(3) );
    }
}
