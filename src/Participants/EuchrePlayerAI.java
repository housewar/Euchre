package Participants;

import CardDeck.Card;
import CardDeck.Cards;
import CardDeck.DeckFactory;
import Game.PlayerCard;
import Game.PlayerCardCounter;
import Game.Trick;

import java.util.ArrayList;

public class EuchrePlayerAI {

    private Player player;
    private PlayerCardCounter playerCardCounter;

    public EuchrePlayerAI(Player player ){
        this.player = player;
        Player nextPlayer = player.getPlayerToLeft();
        while ( nextPlayer != this.player ){
            playerCardCounter.add( nextPlayer , DeckFactory.getEuchreDeck() );
            nextPlayer = nextPlayer.getPlayerToLeft();
        }
    }
    public void updateCardCounterFromHand( Cards hand ){
        for ( int i = 0 ; i < hand.getNumberOfCards() ; ++i ){
            playerCardCounter.removeCardFromAllPlayers( hand.get(i) );
        }
    }
    public void updateCardCounterFromTrick( Trick trick ){
        ArrayList<PlayerCard> trickPlayerCards = trick.getCopyOfPlayerCards();
        for ( PlayerCard pc : trickPlayerCards ){
            if ( pc.getPlayer() != this.player ){
                playerCardCounter.removePlayerCard( pc );
            }
        }
    }
}