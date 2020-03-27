package CardDeck;

import org.junit.Test;

import static org.junit.Assert.*;

public class Card_Test {

    @Test
    public void testCard_getters(){
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertEquals(Card.Suit.SPADES , card.getSuit() );
        assertEquals( Card.Suit.Color.BLACK , card.getColor() );
        assertEquals(Card.Rank.ACE , card.getRank() );
        Card another = new Card(Card.Rank.NINE, Card.Suit.HEARTS);
        assertEquals(Card.Suit.HEARTS , another.getSuit() );
        assertEquals( Card.Suit.Color.RED , another.getColor() );
        assertEquals(Card.Rank.NINE , another.getRank() );
        assertEquals(9 , another.getRankValue() );
    }
    @Test
    public void testCard_calculateSortValue(){
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertEquals(14, card.calculateSortValue());
        Card another = new Card(Card.Rank.NINE, Card.Suit.HEARTS);
        assertEquals(48, another.calculateSortValue());
    }
    @Test
    public void testCard_toString(){
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertEquals( "A\u2660" , card.toString() );
        Card another = new Card(Card.Rank.NINE, Card.Suit.HEARTS);
        assertEquals( "9\u2665" , another.toString() );
    }
    @Test
    public void testCard_compareTo(){
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card another = new Card(Card.Rank.NINE, Card.Suit.HEARTS);
        Card anotherAce = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertEquals(-1 , card.compareTo(another));
        assertEquals(1 , another.compareTo(card));
        assertEquals(0 , card.compareTo(anotherAce));
    }

    @Test
    public void testCard_equals(){
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card another = new Card(Card.Rank.NINE, Card.Suit.HEARTS);
        Card anotherAce = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertNotEquals(card , another );
        assertEquals( card , card );
        assertNotEquals( card ,  null );
        assertEquals( card , anotherAce );
    }
}
