package Game;

import CardDeck.Card;
import org.junit.Test;

import static Game.TrickLogic.*;
import static org.junit.Assert.*;

public class TrickLogic_Test {

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
    public void testCard_greaterCard(){
        Trick trick = new Trick( Card.Suit.SPADES );
        trick.setLead( Card.Suit.HEARTS );
        Card aceLead = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
        Card kingLead = new Card(Card.Rank.KING, Card.Suit.HEARTS);
        Card nineTrump = new Card( Card.Rank.NINE , Card.Suit.SPADES );
        Card aceTrump = new Card( Card.Rank.ACE , Card.Suit.SPADES );
        Card nonLead = new Card( Card.Rank.ACE , Card.Suit.CLUBS );
        Card left = new Card( Card.Rank.JACK , Card.Suit.CLUBS );
        Card right = new Card( Card.Rank.JACK , Card.Suit.SPADES );
        /*Lead over Lead*/
        assertEquals( aceLead , getGreaterCard( aceLead , kingLead , trick ) );
        assertEquals( aceLead , getGreaterCard( kingLead , aceLead , trick ) );
        /*Lead over non-Lead / non-Trump*/
        assertEquals( kingLead , getGreaterCard( kingLead , nonLead , trick ) );
        assertEquals( kingLead , getGreaterCard( nonLead , kingLead , trick ) );
        /*Trump over Lead*/
        assertEquals( nineTrump , getGreaterCard( aceLead , nineTrump , trick ) );
        assertEquals( nineTrump , getGreaterCard( nineTrump , aceLead , trick ) );
        /*Left over Lead*/
        assertEquals( left , getGreaterCard( left , nineTrump , trick ) );
        assertEquals( left , getGreaterCard( nineTrump , left , trick ) );
        /*Trump over non-Lead / non-Trump*/
        assertEquals( nineTrump , getGreaterCard( nonLead , nineTrump , trick ) );
        assertEquals( nineTrump , getGreaterCard( nineTrump , nonLead , trick ) );
        /*Left over non-Lead / non-Trump*/
        assertEquals( left , getGreaterCard( nonLead , left , trick ) );
        assertEquals( left , getGreaterCard( left , nonLead , trick ) );
        /*Trump over Trump*/
        assertEquals( aceTrump , getGreaterCard( nineTrump , aceTrump , trick ) );
        assertEquals( aceTrump , getGreaterCard( aceTrump , nineTrump , trick ) );
        /*Right over Ace Trump*/
        assertEquals( right , getGreaterCard( right , aceTrump , trick ) );
        assertEquals( right , getGreaterCard( aceTrump , right , trick ) );
        /*Left over Ace Trump*/
        assertEquals( right , getGreaterCard( right , aceTrump , trick ) );
        assertEquals( right , getGreaterCard( aceTrump , right , trick ) );
        /*Right over Left*/
        assertEquals( right , getGreaterCard( right , left , trick ) );
        assertEquals( right , getGreaterCard( left , right , trick ) );
    }
}
