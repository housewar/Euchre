package Game;

import CardDeck.Card;
import Participants.Player;

public class PlayerCard {
    Player player;
    Card card;

    public PlayerCard( Player player , Card card ){
        this.player = player;
        this.card = card;
    }
    public Player getPlayer(){
        return player;
    }
    public Card getCard(){
        return card;
    }
    public String toString(){
        return player.toString() + "-" + card.toString();
    }
}