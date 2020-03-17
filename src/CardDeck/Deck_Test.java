package CardDeck;

import org.junit.Test;

import static org.junit.Assert.*;

public class Deck_Test {

    @Test
    public void testDeck_get(){
        Deck deck = DeckFactory.getEuchreDeck();
        assertEquals( 24 , deck.getNumberOfCardsLeft() );
        assertEquals( true , (deck.get(0)).equals( new Card( Card.Rank.NINE , Card.Suit.SPADES ) ) );
        assertEquals( true , (deck.get(1)).equals( new Card( Card.Rank.TEN , Card.Suit.SPADES ) ) );
        assertEquals( true , (deck.get(22)).equals( new Card( Card.Rank.KING , Card.Suit.HEARTS ) ) );
        assertEquals( true , (deck.get(23)).equals( new Card( Card.Rank.ACE , Card.Suit.HEARTS ) ) );
    }

    @Test
    public void testDeck_DealNext(){
        Deck deck = DeckFactory.getEuchreDeck();
        assertEquals( 24 , deck.getNumberOfCardsLeft() );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.ACE , Card.Suit.HEARTS ) ) );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.KING , Card.Suit.HEARTS ) ) );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.QUEEN , Card.Suit.HEARTS ) ) );
        assertEquals( 21 , deck.getNumberOfCardsLeft() );
    }

    @Test
    public void testDeck_reset(){
        Deck deck = DeckFactory.getEuchreDeck();
        assertEquals( 24 , deck.getNumberOfCardsLeft() );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.ACE , Card.Suit.HEARTS ) ) );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.KING , Card.Suit.HEARTS ) ) );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.QUEEN , Card.Suit.HEARTS ) ) );
        assertEquals( 21 , deck.getNumberOfCardsLeft() );
        deck.reset();
        assertEquals( 24 , deck.getNumberOfCardsLeft() );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.ACE , Card.Suit.HEARTS ) ) );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.KING , Card.Suit.HEARTS ) ) );
        assertEquals( true , (deck.removeNext()).equals( new Card( Card.Rank.QUEEN , Card.Suit.HEARTS ) ) );
    }

    @Test
    public void testDeck_shuffle_sort(){
        Deck deck = DeckFactory.getEuchreDeck();
        Deck another = DeckFactory.getEuchreDeck();
        another.shuffle();
        int difference = 0;
        int absDifference = 0;
        for ( int i = 0 ; i < deck.getNumberOfCardsLeft() ; ++i ){
            difference += deck.get(i).calculateSortValue() - another.get(i).calculateSortValue();
            absDifference += Math.abs(deck.get(i).calculateSortValue() - another.get(i).calculateSortValue());
        }
        assertEquals( 0 , difference );
        assertNotEquals( 0 , absDifference );
        another.sort();
        difference = 0;
        absDifference = 0;
        for ( int i = 0 ; i < deck.getNumberOfCardsLeft() ; ++i ){
            difference += deck.get(i).calculateSortValue() - another.get(i).calculateSortValue();
            absDifference += Math.abs(deck.get(i).calculateSortValue() - another.get(i).calculateSortValue());
        }
        assertEquals( 0 , difference );
        assertEquals( 0 , absDifference );
    }
}
