package Game;

import CardDeck.Card;
import CardDeck.Cards;
import CardDeck.Deck;
import CardDeck.DeckFactory;
import Participants.Player;
import Participants.Players;

import java.util.Map;
import java.util.Set;

public class PlayerCardCounter {

    private Map<Player, Cards> playerCardCounter;

    public PlayerCardCounter() {
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
}