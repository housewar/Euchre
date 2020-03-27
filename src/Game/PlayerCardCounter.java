package Game;

import CardDeck.Card;
import CardDeck.Cards;
import CardDeck.Deck;
import Participants.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerCardCounter {

    private HashMap<Player, Cards> playerCardCounter;

    public PlayerCardCounter() {
        playerCardCounter = new HashMap<>();
    }

    public void add( Player player , Deck deck ) {
        playerCardCounter.put( player , new Cards( deck ) );
    }
    public void removePlayerCard( Player player , Card card ){
        playerCardCounter.get( player ).remove( card );
    }
    public void removePlayerCard( PlayerCard playerCard ){
        playerCardCounter.get( playerCard.getPlayer() ).remove( playerCard.getCard() );
    }
    public void removeCardFromAllPlayers( Card card ){
        for ( Player player : playerCardCounter.keySet() ){
            playerCardCounter.get( player ).remove( card );
        }
    }
    public Cards getCards(Player player ){
        return playerCardCounter.get( player );
    }
}