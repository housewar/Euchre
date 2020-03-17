package CardDeck;

import org.junit.Test;

import static CardDeck.EuchreCardTrumpLogic.*;
import static org.junit.Assert.*;

public class EuchreCardTrumpLogic_Test {

    @Test
    public void testCard_getEuchreCardSuit(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.JACK, Card.Suit.HEARTS);
        Card card1 = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        Card card2 = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        assertEquals( Card.Suit.HEARTS , getEuchreCardSuit( card , trump ) );
        assertEquals( Card.Suit.SPADES , getEuchreCardSuit( card1 , trump ) );
        assertEquals( Card.Suit.SPADES , getEuchreCardSuit( card2 , trump ) );
    }
    @Test
    public void testCard_isTrump(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertTrue(cardIsTrump( card , trump ) );
        Card card1 = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
        assertFalse(cardIsTrump( card1 , trump ) );
        Card right = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        assertTrue(cardIsTrump( right , trump ) );
        Card left = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        assertTrue(cardIsTrump( left , trump ) );
    }

    @Test
    public void testCard_isSameSuitAs(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card1 = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Card card2 = new Card(Card.Rank.KING, Card.Suit.CLUBS);
        Card right = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        Card left = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        assertFalse( cardsAreSameSuit( card, card1 , trump ) );
        assertTrue(cardsAreSameSuit( card1 , card2 , trump ) );
        assertTrue(cardsAreSameSuit( card , right , trump ) );
        assertTrue(cardsAreSameSuit( left , right , trump ) );
        assertFalse( cardsAreSameSuit( card2 , left , trump ) );
    }

    @Test
    public void testCard_isBower(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card1 = new Card(Card.Rank.JACK, Card.Suit.DIAMONDS);
        Card right = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        Card left = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        assertFalse( cardIsBower( card , trump ) );
        assertFalse( cardIsBower( card1 , trump ) );
        assertTrue( cardIsBower( right , trump ) );
        assertTrue( cardIsBower( left , trump ) );
    }

    @Test
    public void testCard_isRightBower(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card1 = new Card(Card.Rank.JACK, Card.Suit.DIAMONDS);
        Card right = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        Card left = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        assertFalse(cardIsRightBower( card , trump ) );
        assertFalse( cardIsRightBower( card1 , trump ) );
        assertTrue( cardIsRightBower( right , trump ) );
        assertFalse( cardIsRightBower( left , trump ) );
    }

    @Test
    public void testCard_isLeftBower(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card1 = new Card(Card.Rank.JACK, Card.Suit.DIAMONDS);
        Card right = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        Card left = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        assertFalse( cardIsLeftBower( card , trump ) );
        assertFalse( cardIsLeftBower( card1 , trump ) );
        assertFalse( cardIsLeftBower( right , trump ) );
        assertTrue( cardIsLeftBower( left ,  trump ) );
    }

    @Test
    public void testCard_greaterTrumpCard(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card1 = new Card(Card.Rank.KING, Card.Suit.SPADES);
        Card right = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        Card left = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        assertEquals( card , getGreaterTrumpCard( card , card1 , trump ) );
        assertEquals( right , getGreaterTrumpCard( card , right , trump ) );
        assertEquals( left , getGreaterTrumpCard( left , card , trump ) );
        assertEquals( right , getGreaterTrumpCard( left , right , trump ) );
        assertEquals( card , getGreaterTrumpCard( card , card , trump ) );
    }
}