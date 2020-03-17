package Game;

import CardDeck.Card;
import CardDeck.Cards;
import Participants.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerCard_Test {
    @Test
    public void test_PlayerCard_Constructor(){
        Player player = new Player();
        Card aceSpades = new Card( Card.Rank.ACE , Card.Suit.SPADES );
        PlayerCard playerCard = new PlayerCard( player , aceSpades );
        assertTrue( playerCard instanceof PlayerCard );
    }
    @Test
    public void test_PlayerCard_Getters(){
        Player player = new Player();
        Card aceSpades = new Card( Card.Rank.ACE , Card.Suit.SPADES );
        PlayerCard playerCard = new PlayerCard( player , aceSpades );
        assertEquals( player , playerCard.getPlayer() );
        assertEquals( aceSpades , playerCard.getCard() );
    }
}
