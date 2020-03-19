package Participants;

import java.util.ArrayList;

public class Players {

    private ArrayList<Player> players;

    public Players(){
        players = new ArrayList<>();
    }
    public boolean isEmpty(){
        return players.size() == 0;
    }
    /*A Player is instantiated with a self-referential link, so it's already
    * setup to be the root node in the event Players is empty.*/
    public boolean add(Player player){
        if ( !players.isEmpty() ){
            player.setPlayerToLeft( getFirstPlayer() );
            getLastPlayer().setPlayerToLeft( player );
        }
        return players.add(player);
    }
    public Player getFirstPlayer(){
        return players.get( 0 );
    }
    public Player getLastPlayer(){
        return players.get( players.size() - 1 );
    }
    public int getNumberOfPlayers(){
        return players.size();
    }
    public Player getNextPlayer( Player current ){
        return current.getPlayerToLeft();
    }
}