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
}
