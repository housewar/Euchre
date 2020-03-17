package Game;

import CardDeck.*;

import static CardDeck.EuchreCardTrumpLogic.getEuchreCardSuit;

public class Trick {
    private PlayerCards playerCards;
    private Card.Suit trump;
    private Card.Suit lead;

    public Trick(Card.Suit trump){
        playerCards = new PlayerCards();
        this.trump = trump;
    }
    public void setTrump( Card.Suit trump ){
        this.trump = trump;
    }
    public boolean addCard( Card card ) {
        if ( trump == null ) { return false; }
        setLead( getEuchreCardSuit( card , trump ) );
        return addCard( card );
    }
    private boolean setLead( Card.Suit lead ){
        if ( this.lead == null ){
            this.lead = lead;
            return true;
        } else {
            return false;
        }
    }
    public Card.Suit getTrump(){
        return trump;
    }
    public Card.Suit getLead(){
        return lead;
    }
}