package Participants;

import CardDeck.*;
import Game.*;

public class Player {

    private Cards hand;

    public Player(){
        hand = new Cards();
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
}