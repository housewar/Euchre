package CardDeck;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Cards_Test {

    @Test
    public void testHand_Constructor(){
        Cards hand = new Cards();
        assertTrue( hand.getCards() instanceof ArrayList);
    }
    @Test
    public void testHand_isEmpty_size(){
        Cards hand = new Cards();
        assertTrue( hand.getCards() instanceof ArrayList);
        assertTrue( hand.isEmpty() );
        assertEquals( 0 , hand.getCards().size() );
        assertEquals( 0 , hand.getNumberOfCards() );
    }
    @Test
    public void testHand_add_get_size(){
        Cards hand = new Cards();
        Card[] cards = new Card[4];
        cards[0] = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.CLUBS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.HEARTS );
        hand.add( cards[0] );
        hand.add( cards[1] );
        hand.add( cards[2] );
        hand.add( cards[3] );
        assertEquals( cards[0] , hand.get(0) );
        assertEquals( cards[1] , hand.get(1) );
        assertEquals( cards[2] , hand.get(2) );
        assertEquals( cards[3] , hand.get(3) );
        assertFalse( hand.isEmpty() );
        assertEquals( 4 , hand.getNumberOfCards() );
    }
    @Test
    public void testHand_remove(){
        Cards hand = new Cards();
        Card[] cards = new Card[4];
        cards[0] = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.CLUBS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.HEARTS );
        hand.add( cards[0] );
        hand.add( cards[1] );
        hand.add( cards[2] );
        hand.add( cards[3] );
        hand.remove( 2 );
        assertEquals( cards[0] , hand.get(0) );
        assertEquals( cards[1] , hand.get(1) );
        assertEquals( cards[3] , hand.get(2) );
    }
    @Test
    public void testHand_clear(){
        Cards hand = new Cards();
        Card[] cards = new Card[4];
        cards[0] = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.CLUBS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.HEARTS );
        hand.add( cards[0] );
        hand.add( cards[1] );
        hand.add( cards[2] );
        hand.add( cards[3] );
        assertEquals( 4 , hand.getNumberOfCards() );
        hand.clear();
        assertTrue( hand.isEmpty() );
    }
    @Test
    public void testHand_addAll(){
        Cards hand = new Cards();
        Cards another = new Cards();
        Card[] cards = new Card[4];
        cards[0] = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.DIAMONDS );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.CLUBS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.HEARTS );
        hand.add( cards[0] );
        hand.add( cards[1] );
        hand.add( cards[2] );
        hand.add( cards[3] );
        another.addAll(hand);
        assertEquals( hand.get(0) , another.get(0) );
        assertEquals( hand.get(1) , another.get(1) );
        assertEquals( hand.get(2) , another.get(2) );
        assertEquals( hand.get(3) , another.get(3) );
    }
    @Test
    public void testHand_sort(){
        Cards hand = new Cards();
        Card[] cards = new Card[5];
        cards[0] = new Card( Card.Rank.ACE , Card.Suit.SPADES );
        cards[1] = new Card( Card.Rank.QUEEN , Card.Suit.SPADES );
        cards[2] = new Card( Card.Rank.KING , Card.Suit.HEARTS );
        cards[3] = new Card( Card.Rank.ACE , Card.Suit.DIAMONDS );
        cards[4] = new Card( Card.Rank.JACK , Card.Suit.CLUBS );
        hand.add( cards[0] );
        hand.add( cards[1] );
        hand.add( cards[2] );
        hand.add( cards[3] );
        hand.add( cards[4] );
        hand.sort();
        assertEquals( cards[1] , hand.get(0) );
        assertEquals( cards[0] , hand.get(1) );
        assertEquals( cards[3] , hand.get(2) );
        assertEquals( cards[4] , hand.get(3) );
        assertEquals( cards[2] , hand.get(4) );
    }
}