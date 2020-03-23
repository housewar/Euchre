package Game;

import CardDeck.Card;
import CardDeck.Cards;

import static CardDeck.EuchreCardTrumpLogic.*;

/*Static functions involving LEAD and TRUMP necessitate a TRICK*/
public class TrickLogic {

    public static Cards getPlayableEuchreHand(Cards hand, Trick trick ) {

        Card.Suit lead = trick.getLead();
        Card.Suit trump = trick.getTrump();
        Cards playable = new Cards();
        for ( Card card : hand.getCards() ){
            if ( getEuchreCardSuit( card , trump ) == lead ) {
                playable.add(card);
            }
        }
        if ( playable.isEmpty() ){
            playable.addAll(hand);
        }
        return playable;
    }


    public static boolean cardIsLead(Card card , Trick trick ) {

        return  getEuchreCardSuit( card , trick.getTrump() ) == trick.getLead();

    }
    public static PlayerCard getGreaterPlayerCard( PlayerCard playerCard , PlayerCard another , Trick trick ) {
        if ( playerCard.getCard() == getGreaterCard(playerCard.getCard() , another.getCard() , trick ) ){
            return playerCard;
        } else {
            return another;
        }
    }

    public static Card getGreaterCard( Card card , Card another , Trick trick ) {

        Card.Suit trump = trick.getTrump();

        if (    cardsAreSameSuit( card , another , trump )
                && cardIsTrump( card , trump ) ) {

            return getGreaterTrumpCard(card, another, trump);

        } else if ( cardsAreSameSuit( card , another , trump )
                    && cardIsLead( card , trick ) ) {

            return getGreaterCardRank(card, another);

        } else if ( !cardsAreSameSuit( card , another , trump )
                    && !cardIsTrump( another , trump )
                    && ( cardIsTrump( card , trump ) || ( cardIsLead( card , trick) ) ) ) {

            return card;

        } else if ( !cardsAreSameSuit( card , another , trump )
                && !cardIsTrump( card , trump )
                && ( cardIsTrump( another , trump ) || ( cardIsLead( another , trick) ) ) ) {

            return another;

        } else {

            throw new IllegalArgumentException("Cannot compare two cards that are both non-Trump and non-Lead.");

        }

    }
    public static Card getGreaterCardRank( Card card , Card another ) {

        if ( card.getRankValue() >= another.getRankValue() ){
            return card;
        } else {
            return another;
        }
    }
    /*The bowers make comparing two trump cards slightly more difficult.
    * This method compares two cards that are known to be trump.
    * This program should never submit a non-Trump card to this method, so an IllegalArgumentException
    * has been added to assist in debugging.
    * Reminder of the ranking rules in Euchre:
    * 1. The Right Bower is the Jack of the trump suit, nothing beats that
    * 2. The Left Bower is the Jack of the non-trump same-color suit, second to the Right Bower
    * 3. All other trump values compare as they normally would.*/
    public static Card getGreaterTrumpCard(Card card , Card another , Card.Suit trump ) throws IllegalArgumentException {
        if ( !cardIsTrump( card , trump ) || !cardIsTrump( another , trump ) ){
            throw new IllegalArgumentException("Cannot compare non-Trump cards using getGreaterTrumpCard.");
        }

        if (       ( cardIsRightBower( card , trump ) && !cardIsRightBower( another , trump) )
                || ( cardIsLeftBower( card , trump) && !cardIsBower( another , trump) )
                || ( !cardIsBower( card , trump) && !cardIsBower( another , trump) ) && card.compareTo(another) == 1 ) {
            return card;
        } else if ( card.getRank() == another.getRank() && card.getSuit() == another.getSuit() ){
            return card;
        } else {
            return another;
        }
    }
}
