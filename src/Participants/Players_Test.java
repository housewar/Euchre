package Participants;

import CardDeck.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class Players_Test {
    @Test
    public void test_Players_isEmpty(){
        Players players = new Players();
        assertTrue( players.isEmpty() );
    }
    @Test
    public void test_Players_add(){
        Players players = new Players();
        Player player = new Player();
        players.add(player);
        assertFalse( players.isEmpty() );
    }
    @Test
    public void test_Players_getNumberOfPlayers(){
        Players players = new Players();
        Player player = new Player();
        Player another = new Player();
        assertEquals( 0 , players.getNumberOfPlayers() );
        players.add(player);
        assertEquals( 1 , players.getNumberOfPlayers() );
        players.add(another);
        assertEquals( 2 , players.getNumberOfPlayers() );
    }
    @Test
    public void test_Players_testLinks(){
        Players players = new Players();
        Player player = new Player();
        Player another = new Player();
        Player aThird = new Player();
        players.add(player);
        players.add(another);
        players.add(aThird);
        assertEquals( another , players.getNextPlayer( player ) );
        assertEquals( aThird , players.getNextPlayer( another ) );
        assertEquals( player , players.getNextPlayer( aThird ) );
    }
}
