package Game;

import CardDeck.*;
import static CardDeck.EuchreCardTrumpLogic.*;
import static Game.TrickLogic.*;
import Participants.*;

public class Trick {
    private PlayerCards playerCards;
    private Card.Suit trump;
    private Card.Suit lead;

    public Trick(Card.Suit trump){
        playerCards = new PlayerCards();
        this.trump = trump;
    }
    public boolean addPlayerCard(Player player , Card card ) {
        if ( player == null || card == null || trump == null ){ return false; }
        return addPlayerCard( new PlayerCard( player , card ) );
    }
    public boolean addPlayerCard(PlayerCard playerCard ) {
        if ( playerCard == null || trump == null ) { return false; }
        /*Use getEuchreCardSuit instead of getSuit(), in case of Left Bower*/
        setLead(getEuchreCardSuit( playerCard.getCard(), trump ));
        return playerCards.add(playerCard);
    }
    public boolean setLead( Card.Suit lead ){
        if ( this.lead != null ){ return false; }
        this.lead = lead;
        return true;
    }
    public Card.Suit getTrump(){
        return trump;
    }
    public Card.Suit getLead(){
        return lead;
    }
    public boolean isEmpty(){
        return playerCards.getNumberOfCards() == 0;
    }
    public PlayerCard getHighPlayerCard() throws IllegalStateException {
        if ( isEmpty() ) { throw new IllegalStateException(); }
        PlayerCard high = playerCards.get(0);
        for( int i = 1  ; i < playerCards.getNumberOfCards() ; ++i ){
            high = getGreaterPlayerCard( high , playerCards.get(i) , this );
        }
        return high;
    }
}