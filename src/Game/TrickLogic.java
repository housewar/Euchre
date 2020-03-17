package Game;

import CardDeck.Card;

import static CardDeck.EuchreCardTrumpLogic.*;

/*Comparisons involving LEAD cards must involve a Trick*/
public class TrickLogic {

    public static boolean cardIsLead(Card card , Trick trick )
            throws IllegalArgumentException {
        if ( trick == null ){ throw new IllegalArgumentException("Trick trick is NULL"); }
        else if ( trick.getLead() == null ){ throw new IllegalArgumentException("trick.getLead() is NULL"); }

        return  getEuchreCardSuit( card , trick.getTrump() ) == trick.getLead();

    }
    public static Card getGreaterCard( Card card , Card another , Trick trick ) {
        // Two non-Trump, non-Lead cards cannot be compared
        if (       !cardIsLead( card , trick )
                && !cardIsLead( another , trick )
                && !cardIsTrump( card , trick.getTrump() )
                && !cardIsTrump( another , trick.getTrump() ) ){
            throw new IllegalArgumentException("Cannot compare two cards that are both non-Trump and non-Lead.");
        }

        Card.Suit trump = trick.getTrump();

        // Cards are the same suit, compare them as trump, or lead as appropriate
        if ( cardsAreSameSuit( card , another , trump ) ){
            if ( cardIsTrump( card , trump ) ) {
                return getGreaterTrumpCard( card , another , trump );
            } else {
                return getGreaterCardRank( card , another );
            }
        } else if ( cardIsTrump( card , trump ) ||
                    ( cardIsLead( card , trick) && !cardIsTrump( another , trump ) ) ) {
            /* One card must be TRUMP or LEAD.
             * Cards cannot be the same suit.
             * Card(TRUMP) over Another(NON-TRUMP);
             * OR Card(LEAD) over Another(OFF-SUIT)*/
            return card;
        } else {
            /* One card must be TRUMP or LEAD.
             * Cards cannot be the same suit.
             * NOT Card(TRUMP) over Another(NON-TRUMP);
             * AND NOT Card(LEAD) over Another(OFF-SUIT)
             * Another must be TRUMP or LEAD over NON-TRUMP / OFF-SUIT*/
            return another;
        }

    }
}
