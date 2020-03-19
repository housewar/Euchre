package Participants;

import CardDeck.*;

public class Player {

    private Cards hand;
    private Player left;

    public Player(){
        hand = new Cards();
        left = this;
    }
    public boolean handIsEmpty(){
        return hand.isEmpty();
    }
    public boolean addToHand( Card card ){
        return hand.add( card );
    }
    public Card getCard(int i ){
        return hand.get(i);
    }
    public int getNumberOfCardsInHand(){
        return hand.getNumberOfCards();
    }
    public Player getPlayerToLeft(){
        return left;
    }
    public void setPlayerToLeft( Player player ){
        left = player;
    }
    public String getHandToString(){
        return hand.toString();
    }

}