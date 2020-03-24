package CardDeck;

import org.junit.Test;

import static CardDeck.EuchreCardTrumpLogic.*;
import static org.junit.Assert.*;

public class EuchreCardTrumpLogic_Test {

    @Test
    public void testCardLogic_isBower(){
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
    public void testCardLogic_getEuchreCardSuit(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.JACK, Card.Suit.HEARTS);
        Card card1 = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        Card card2 = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        assertEquals( Card.Suit.HEARTS , getEuchreCardSuit( card , trump ) );
        assertEquals( Card.Suit.SPADES , getEuchreCardSuit( card1 , trump ) );
        assertEquals( Card.Suit.SPADES , getEuchreCardSuit( card2 , trump ) );
    }
    @Test
    public void testCardLogic_isTrump(){
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
    public void testCardLogic_isSameSuitAs(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card1 = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Card card2 = new Card(Card.Rank.KING, Card.Suit.CLUBS);
        Card right = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        Card left = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        assertFalse(cardsAreSameSuit( card, card1 , trump ) );
        assertTrue(cardsAreSameSuit( card1 , card2 , trump ) );
        assertTrue(cardsAreSameSuit( card , right , trump ) );
        assertTrue(cardsAreSameSuit( left , right , trump ) );
        assertFalse(cardsAreSameSuit( card2 , left , trump ) );
    }
    @Test
    public void testCardLogic_isRightBower(){
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
    public void testCardLogic_isLeftBower(){
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
    public void testCardLogic_removeLeftBower(){
        Cards hand = new Cards();
        Card left = new Card( Card.Rank.JACK , Card.Suit.CLUBS );
        hand.add( new Card( Card.Rank.QUEEN , Card.Suit.SPADES ) );
        hand.add( new Card( Card.Rank.ACE , Card.Suit.SPADES ) );
        hand.add( new Card( Card.Rank.ACE , Card.Suit.DIAMONDS ));
        hand.add( left );
        hand.add( new Card( Card.Rank.KING , Card.Suit.HEARTS ) );
        hand.sort();
        assertNull( removeLeftBower( hand , Card.Suit.CLUBS ) );
        assertEquals( left , removeLeftBower( hand , Card.Suit.SPADES ) );
        assertEquals( 4 , hand.getNumberOfCards() );
    }
    @Test
    public void testCardLogic_removeRightBower(){
        Cards hand = new Cards();
        Card right = new Card( Card.Rank.JACK , Card.Suit.CLUBS );
        hand.add( new Card( Card.Rank.QUEEN , Card.Suit.SPADES ) );
        hand.add( new Card( Card.Rank.ACE , Card.Suit.SPADES ) );
        hand.add( new Card( Card.Rank.ACE , Card.Suit.DIAMONDS ));
        hand.add( right );
        hand.add( new Card( Card.Rank.KING , Card.Suit.HEARTS ) );
        hand.sort();
        assertNull( removeRightBower( hand , Card.Suit.SPADES ) );
        assertEquals( right , removeRightBower( hand , Card.Suit.CLUBS ) );
        assertEquals( 4 , hand.getNumberOfCards() );
    }
    @Test
    public void testCardLogic_findBowerInsertionIndex(){
        Cards hand = new Cards();
        hand.add( new Card( Card.Rank.JACK , Card.Suit.DIAMONDS ) );
        hand.add( new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS ) );
        hand.add( new Card( Card.Rank.JACK , Card.Suit.CLUBS ) );
        hand.add( new Card( Card.Rank.ACE , Card.Suit.CLUBS ) );
        hand.add( new Card( Card.Rank.KING , Card.Suit.HEARTS ) );
        hand.sort();
        assertEquals( 0 , findBowerInsertionIndex( hand , Card.Suit.SPADES ) );
        assertEquals( 2 , findBowerInsertionIndex( hand , Card.Suit.DIAMONDS ) );
        assertEquals( 4 , findBowerInsertionIndex( hand , Card.Suit.CLUBS ) );
        assertEquals( 5 , findBowerInsertionIndex( hand , Card.Suit.HEARTS ) );
    }
    @Test
    public void testCardLogic_sortCardsWithTrump(){
        Cards hand = new Cards();
        hand.add( new Card( Card.Rank.JACK , Card.Suit.DIAMONDS ) );
        hand.add( new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS ) );
        hand.add( new Card( Card.Rank.JACK , Card.Suit.CLUBS ) );
        hand.add( new Card( Card.Rank.ACE , Card.Suit.CLUBS ) );
        hand.add( new Card( Card.Rank.JACK , Card.Suit.HEARTS ) );
        hand.sort();
        assertEquals("J\u2666 | Q\u2666 | J\u2663 | A\u2663 | J\u2665 ", hand.toString());
        sortCardsWithTrump( hand , Card.Suit.SPADES );
        assertEquals("J\u2663 | J\u2666 | Q\u2666 | A\u2663 | J\u2665 ", hand.toString());
        sortCardsWithTrump( hand , Card.Suit.DIAMONDS );
        assertEquals("Q\u2666 | J\u2665 | J\u2666 | J\u2663 | A\u2663 ", hand.toString());
        sortCardsWithTrump( hand , Card.Suit.CLUBS );
        assertEquals("J\u2666 | Q\u2666 | A\u2663 | J\u2663 | J\u2665 ", hand.toString());
        sortCardsWithTrump( hand , Card.Suit.HEARTS );
        assertEquals("Q\u2666 | J\u2663 | A\u2663 | J\u2666 | J\u2665 ", hand.toString());
    }
}
