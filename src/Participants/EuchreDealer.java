package Participants;

import CardDeck.*;

public class EuchreDealer {

    private Deck deck;

    public EuchreDealer(){
        deck = DeckFactory.getEuchreDeck();
    }
    public void gatherCardsAndShuffle(){
        deck.reset();
        deck.shuffle();
    }
    public void sortDeck(){
        deck.sort();
    }
    public void dealNewRoundToPlayers( Players players , Player dealingPlayer ){
        for (   Player current = players.getNextPlayer( dealingPlayer )
                ; dealingPlayer.getNumberOfCardsInHand() < 5
                ; current = players.getNextPlayer( current ) ){
            current.addToHand( deck.removeNext() );
        }
    }
}
