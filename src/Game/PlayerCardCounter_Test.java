package Game;

import CardDeck.*;
import Participants.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerCardCounter_Test {
    @Test
    public void test_PlayerCard_add_getCards(){
        PlayerCardCounter pcc = new PlayerCardCounter();
        Player p = new Player();
        Deck d = new Deck ( Card.Rank.KING , Card.Rank.ACE );
        Cards c = new Cards( d );
        pcc.add( p , d );
        assertEquals( c.getNumberOfCards() , pcc.getCards( p ).getNumberOfCards() );
    }
    @Test
    public void test_PlayerCard_add_getCards_string(){
        PlayerCardCounter pcc = new PlayerCardCounter();
        Player p = new Player();
        Deck d = new Deck ( Card.Rank.KING , Card.Rank.ACE );
        Cards c = new Cards( d );
        pcc.add( p , d );
        assertEquals( c.toString() , pcc.getCards( p ).toString() );
    }
    @Test
    public void test_PlayerCard_removePlayerCard(){
        PlayerCardCounter pcc = new PlayerCardCounter();
        Player p = new Player();
        pcc.add( p , new Deck ( Card.Rank.KING , Card.Rank.ACE ) );
        pcc.removePlayerCard( p , new Card( Card.Rank.KING , Card.Suit.DIAMONDS ));
        assertEquals( 7 , pcc.getCards( p ).getNumberOfCards() );
    }
}
