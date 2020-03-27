package CardDeck;

import org.junit.Test;

import static org.junit.Assert.*;

public class Deck_Test {

    @Test
    public void testDeck_get(){
        Deck deck = DeckFactory.getEuchreDeck();
        assertEquals( 24 , deck.getNumberOfCards() );
        assertEquals((deck.get(0)), new Card(Card.Rank.NINE, Card.Suit.SPADES));
        assertEquals((deck.get(1)), new Card(Card.Rank.TEN, Card.Suit.SPADES));
        assertEquals((deck.get(22)), new Card(Card.Rank.KING, Card.Suit.HEARTS));
        assertEquals((deck.get(23)), new Card(Card.Rank.ACE, Card.Suit.HEARTS));
    }

    @Test
    public void testDeck_DealNext(){
        Deck deck = DeckFactory.getEuchreDeck();
        assertEquals( 24 , deck.getNumberOfCards() );
        assertEquals((deck.removeNext()), new Card(Card.Rank.ACE, Card.Suit.HEARTS));
        assertEquals((deck.removeNext()), new Card(Card.Rank.KING, Card.Suit.HEARTS));
        assertEquals((deck.removeNext()), new Card(Card.Rank.QUEEN, Card.Suit.HEARTS));
        assertEquals( 21 , deck.getNumberOfCards() );
    }

    @Test
    public void testDeck_reset(){
        Deck deck = DeckFactory.getEuchreDeck();
        assertEquals( 24 , deck.getNumberOfCards() );
        assertEquals((deck.removeNext()), new Card(Card.Rank.ACE, Card.Suit.HEARTS));
        assertEquals((deck.removeNext()), new Card(Card.Rank.KING, Card.Suit.HEARTS));
        assertEquals((deck.removeNext()), new Card(Card.Rank.QUEEN, Card.Suit.HEARTS));
        assertEquals( 21 , deck.getNumberOfCards() );
        deck.reset();
        assertEquals( 24 , deck.getNumberOfCards() );
        assertEquals((deck.removeNext()), new Card(Card.Rank.ACE, Card.Suit.HEARTS));
        assertEquals((deck.removeNext()), new Card(Card.Rank.KING, Card.Suit.HEARTS));
        assertEquals((deck.removeNext()), new Card(Card.Rank.QUEEN, Card.Suit.HEARTS));
    }

    @Test
    public void testDeck_shuffle_sort(){
        Deck deck = DeckFactory.getEuchreDeck();
        Deck another = DeckFactory.getEuchreDeck();
        another.shuffle();
        int difference = 0;
        int absDifference = 0;
        for (int i = 0; i < deck.getNumberOfCards() ; ++i ){
            difference += deck.get(i).calculateSortValue() - another.get(i).calculateSortValue();
            absDifference += Math.abs(deck.get(i).calculateSortValue() - another.get(i).calculateSortValue());
        }
        assertEquals( 0 , difference );
        assertNotEquals( 0 , absDifference );
        another.sort();
        difference = 0;
        absDifference = 0;
        for (int i = 0; i < deck.getNumberOfCards() ; ++i ){
            difference += deck.get(i).calculateSortValue() - another.get(i).calculateSortValue();
            absDifference += Math.abs(deck.get(i).calculateSortValue() - another.get(i).calculateSortValue());
        }
        assertEquals( 0 , difference );
        assertEquals( 0 , absDifference );
    }
}
