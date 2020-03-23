package Game;

import CardDeck.Card;
import CardDeck.Cards;
import org.junit.Test;

import static Game.TrickLogic.*;
import static org.junit.Assert.*;

public class TrickLogic_Test {

    @Test
    public void testCard_greaterCardRank(){
        Card.Suit lead = Card.Suit.HEARTS;
        Card card = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
        Card card1 = new Card(Card.Rank.KING, Card.Suit.HEARTS);
        assertEquals( card , TrickLogic.getGreaterCardRank( card , card1 ) );
    }
    @Test
    public void testCard_greaterTrumpCard(){
        Card.Suit trump = Card.Suit.SPADES;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card1 = new Card(Card.Rank.KING, Card.Suit.SPADES);
        Card right = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        Card left = new Card(Card.Rank.JACK, Card.Suit.CLUBS);
        /*Basic rank over rank*/
        assertEquals( card , TrickLogic.getGreaterTrumpCard( card , card1 , trump ) );
        assertEquals( card , TrickLogic.getGreaterTrumpCard( card1 , card , trump ) );
        /*Right Bower over Ace*/
        assertEquals( right , TrickLogic.getGreaterTrumpCard( card , right , trump ) );
        assertEquals( right , TrickLogic.getGreaterTrumpCard( right , card , trump ) );
        /*Left Bower over Ace*/
        assertEquals( left , TrickLogic.getGreaterTrumpCard( left , card , trump ) );
        assertEquals( left , TrickLogic.getGreaterTrumpCard( card , left , trump ) );
        /*Right over Left*/
        assertEquals( right , TrickLogic.getGreaterTrumpCard( left , right , trump ) );
        assertEquals( right , TrickLogic.getGreaterTrumpCard( right , left , trump ) );
        /*Same card*/
        assertEquals( card , TrickLogic.getGreaterTrumpCard( card , card , trump ) );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testCard_greaterTrumpCard_invalidSuit(){
        Card.Suit trump = Card.Suit.HEARTS;
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card1 = new Card(Card.Rank.KING, Card.Suit.SPADES);
        TrickLogic.getGreaterTrumpCard( card , card1 , trump );
    }
    @Test
    public void testCard_cardIsLead(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.CLUBS );
        Card nineCLUBS = new Card ( Card.Rank.NINE , Card.Suit.CLUBS );
        Card left = new Card ( Card.Rank.JACK , Card.Suit.CLUBS);
        Card aceSPADES = new Card ( Card.Rank.ACE , Card.Suit.SPADES );
        assertTrue( cardIsLead( nineCLUBS , trick ) );
        assertFalse( cardIsLead( left , trick ) );
        assertFalse( cardIsLead( aceSPADES , trick ) );
    }
    @Test
    public void test_getPlayableHand_BothBowers(){
        Trick trick = new Trick ( Card.Suit.SPADES );
        trick.setLead( Card.Suit.SPADES );
        Cards hand = new Cards();
        hand.add( new Card(Card.Rank.ACE , Card.Suit.SPADES ));
        hand.add( new Card(Card.Rank.KING , Card.Suit.DIAMONDS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.TEN , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.SPADES ));
        Cards expected = new Cards();
        expected.add(hand.get(0));
        expected.add(hand.get(2));
        expected.add(hand.get(4));
        assertEquals( expected.toString() , getPlayableEuchreHand( hand , trick ).toString() );
    }
    @Test
    public void test_getPlayableHand_NeitherBower(){
        Trick trick = new Trick ( Card.Suit.SPADES );
        trick.setLead( Card.Suit.CLUBS );
        Cards hand = new Cards();
        hand.add( new Card(Card.Rank.ACE , Card.Suit.SPADES ));
        hand.add( new Card(Card.Rank.KING , Card.Suit.DIAMONDS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.TEN , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.SPADES ));
        Cards expected = new Cards();
        expected.add(hand.get(3));
        assertEquals( expected.toString() , getPlayableEuchreHand( hand , trick ).toString() );
    }
    @Test
    public void test_getPlayableHand_void(){
        Trick trick = new Trick ( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Cards hand = new Cards();
        hand.add( new Card(Card.Rank.ACE , Card.Suit.SPADES ));
        hand.add( new Card(Card.Rank.KING , Card.Suit.DIAMONDS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.TEN , Card.Suit.CLUBS ));
        hand.add( new Card(Card.Rank.JACK , Card.Suit.SPADES ));
        Cards expected = new Cards();
        expected.addAll(hand);
        assertEquals( expected.toString() , getPlayableEuchreHand( hand , trick ).toString() );
    }
    @Test
    public void testCard_greaterCard_LeadOverLead(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card aceLead = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
        Card kingLead = new Card(Card.Rank.KING, Card.Suit.HEARTS);
        assertEquals( aceLead , getGreaterCard( aceLead , kingLead , trick ) );
        assertEquals( aceLead , getGreaterCard( kingLead , aceLead , trick ) );
    }
    @Test
    public void testCard_greaterCard_LeadOverNonLead(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card kingLead = new Card(Card.Rank.KING, Card.Suit.HEARTS);
        Card nonLead = new Card( Card.Rank.ACE , Card.Suit.CLUBS );
        assertEquals( kingLead , getGreaterCard( kingLead , nonLead , trick ) );
        assertEquals( kingLead , getGreaterCard( nonLead , kingLead , trick ) );
    }
    @Test
    public void testCard_greaterCard_TrumpOverLead(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card aceLead = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
        Card nineTrump = new Card( Card.Rank.NINE , Card.Suit.SPADES );
        /*Trump over Lead*/
        assertEquals( nineTrump , getGreaterCard( aceLead , nineTrump , trick ) );
        assertEquals( nineTrump , getGreaterCard( nineTrump , aceLead , trick ) );
    }
    @Test
    public void testCard_greaterCard_LeftOverLead(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card nineTrump = new Card( Card.Rank.NINE , Card.Suit.SPADES );
        Card left = new Card( Card.Rank.JACK , Card.Suit.CLUBS );
        assertEquals( left , getGreaterCard( left , nineTrump , trick ) );
        assertEquals( left , getGreaterCard( nineTrump , left , trick ) );
    }
    @Test
    public void testCard_greaterCard_TrumpOverNonLead(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card nineTrump = new Card( Card.Rank.NINE , Card.Suit.SPADES );
        Card nonLead = new Card( Card.Rank.ACE , Card.Suit.CLUBS );
        assertEquals( nineTrump , getGreaterCard( nonLead , nineTrump , trick ) );
        assertEquals( nineTrump , getGreaterCard( nineTrump , nonLead , trick ) );
    }
    @Test
    public void testCard_greaterCard_LeftOverNonLead(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card nonLead = new Card( Card.Rank.ACE , Card.Suit.CLUBS );
        Card left = new Card( Card.Rank.JACK , Card.Suit.CLUBS );
        assertEquals( left , getGreaterCard( nonLead , left , trick ) );
        assertEquals( left , getGreaterCard( left , nonLead , trick ) );
    }
    @Test
    public void testCard_greaterCard_TrumpOverTrump(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card nineTrump = new Card( Card.Rank.NINE , Card.Suit.SPADES );
        Card aceTrump = new Card( Card.Rank.ACE , Card.Suit.SPADES );
        assertEquals( aceTrump , getGreaterCard( nineTrump , aceTrump , trick ) );
        assertEquals( aceTrump , getGreaterCard( aceTrump , nineTrump , trick ) );
    }
    @Test
    public void testCard_greaterCard_RightOverAceTrump(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card aceTrump = new Card( Card.Rank.ACE , Card.Suit.SPADES );
        Card right = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        assertEquals( right , getGreaterCard( right , aceTrump , trick ) );
        assertEquals( right , getGreaterCard( aceTrump , right , trick ) );
    }
    @Test
    public void testCard_greaterCard_LeftOverAceTrump(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card aceTrump = new Card( Card.Rank.ACE , Card.Suit.SPADES );
        Card right = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        assertEquals( right , getGreaterCard( right , aceTrump , trick ) );
        assertEquals( right , getGreaterCard( aceTrump , right , trick ) );
    }
    @Test
    public void testCard_greaterCard_RightOverLeft(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card left = new Card( Card.Rank.JACK , Card.Suit.CLUBS );
        Card right = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        assertEquals( right , getGreaterCard( right , left , trick ) );
        assertEquals( right , getGreaterCard( left , right , trick ) );
    }
}
