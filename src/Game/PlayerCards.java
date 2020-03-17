package Game;

import CardDeck.Card;
import Participants.Player;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerCards {
    private ArrayList<PlayerCard> playerCards;

    public PlayerCards(){
        playerCards = new ArrayList<PlayerCard>();
    }
    public ArrayList<PlayerCard> getPlayerCards(){
        return playerCards;
    }
    public boolean isEmpty(){
        return playerCards.isEmpty();
    }
    public int getNumberOfCards(){
        return playerCards.size();
    }
    public boolean add(PlayerCard pc){
        return playerCards.add(pc);
    }
    public PlayerCard get(int i){
        return playerCards.get(i);
    }
    public PlayerCard remove(int i){
        return playerCards.remove(i);
    }
    public boolean addAll( PlayerCards playerCards){
        return this.playerCards.addAll( playerCards.playerCards );
    }
    public void clear(){
        playerCards.clear();
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for ( PlayerCard pc : playerCards){
            str.append(pc.toString());
            str.append(" | ");
        }
        str.delete(str.length()-3,str.length()-1);
        return str.toString();
    }
    public void print(){
        System.out.println(playerCards.toString());
    }
}
