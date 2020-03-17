package CardDeck;

import org.junit.Test;

import static CardDeck.PlayableHand.*;
import static org.junit.Assert.*;

public class PlayableHand_Test {
    @Test
    public void test_getPlayableHand_null(){
        Card.Suit trump = Card.Suit.SPADES;
        Cards hand = new Cards();
        hand.add( new Card(Card.Rank.ACE , Card.Suit.SPADES ));
        hand.add( new Card(Card.Rank.KING , Card.Suit.DIAMONDS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.TEN , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.SPADES ));
        Cards expected = new Cards();
        Card.Suit lead = null;
        expected.addAll( hand );
        assertEquals( expected.toString() , getPlayableEuchreHand( hand , lead , trump).toString() );
    }
    @Test
    public void test_getPlayableHand_BothBowers(){
        Card.Suit trump = Card.Suit.SPADES;
        Cards hand = new Cards();
        hand.add( new Card(Card.Rank.ACE , Card.Suit.SPADES ));
        hand.add( new Card(Card.Rank.KING , Card.Suit.DIAMONDS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.TEN , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.SPADES ));
        Cards expected = new Cards();
        Card.Suit lead = Card.Suit.SPADES;
        expected.add(hand.get(0));
        expected.add(hand.get(2));
        expected.add(hand.get(4));
        assertEquals( expected.toString() , getPlayableEuchreHand( hand , lead , trump).toString() );
    }
    @Test
    public void test_getPlayableHand_NeitherBower(){
        Card.Suit trump = Card.Suit.SPADES;
        Cards hand = new Cards();
        hand.add( new Card(Card.Rank.ACE , Card.Suit.SPADES ));
        hand.add( new Card(Card.Rank.KING , Card.Suit.DIAMONDS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.TEN , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.SPADES ));
        Cards expected = new Cards();
        Card.Suit lead = Card.Suit.CLUBS;
        expected.add(hand.get(3));
        assertEquals( expected.toString() , getPlayableEuchreHand( hand , lead , trump).toString() );
    }
    @Test
    public void test_getPlayableHand_void(){
        Card.Suit trump = Card.Suit.SPADES;
        Cards hand = new Cards();
        hand.add( new Card(Card.Rank.ACE , Card.Suit.SPADES ));
        hand.add( new Card(Card.Rank.KING , Card.Suit.DIAMONDS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.TEN , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.SPADES ));
        Cards expected = new Cards();
        Card.Suit lead = Card.Suit.HEARTS;
        expected.addAll(hand);
        assertEquals( expected.toString() , getPlayableEuchreHand( hand , lead , trump).toString() );
    }
}
