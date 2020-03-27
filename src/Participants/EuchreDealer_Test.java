package Participants;

import org.junit.Test;

import static org.junit.Assert.*;

public class EuchreDealer_Test {

    @Test
    public void test_EuchreDealer_Deal(){
        Players players = new Players();
        for ( int i = 0 ; i < 4 ; ++i ){
            players.add( new Player() );
        }
        EuchreDealer dealer = new EuchreDealer();
        dealer.dealNewRoundToPlayers( players , players.getFirstPlayer() );
        assertEquals( "J\u2665 | K\u2663 | 9\u2663 | J\u2666 | K\u2660 " , players.getFirstPlayer().getHandToString() );
    }
}
