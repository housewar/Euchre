package CardDeck;

public class EuchreCardTrumpLogic {

    public static boolean cardIsBower(Card card , Card.Suit trump ){
        return  card != null && trump != null
                && card.getRank() == Card.Rank.JACK
                && trump.getColor() == card.getColor();
    }
    public static boolean cardIsRightBower(Card card , Card.Suit trump ){
        return cardIsBower( card , trump ) && trump == card.getSuit();
    }
    public static boolean cardIsLeftBower(Card card , Card.Suit trump ){
        return cardIsBower( card , trump ) && trump != card.getSuit();
    }
    /*Example: Trump is SPADES. All SPADES are SPADES plus the left bower, the JACK of CLUBS*/
    public static Card.Suit getEuchreCardSuit(Card card , Card.Suit trump ){
        if ( cardIsLeftBower( card , trump ) ){
            return trump;
        } else {
            return card.getSuit();
        }
    }
    public static boolean cardIsTrump(Card card , Card.Suit trump ){
        return  card != null && trump != null
                &&getEuchreCardSuit( card , trump ) == trump;
    }
    public static boolean cardsAreSameSuit(Card card , Card another , Card.Suit trump ) {
        return  trump != null && card != null && another != null
                && getEuchreCardSuit( card , trump ) == getEuchreCardSuit( another , trump );
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
            throw new IllegalArgumentException();
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
