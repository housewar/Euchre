package CardDeck;

/*Once trump is determined, the JACK of the TRUMP suit becomes the RIGHT BOWER, which
* is the strongest card. The JACK of the non-TRUMP same-COLOR suit becomes the LEFT BOWER;
* the LEFT BOWER is considered TRUMP SUIT, and is the second strongest card, after the RIGHT BOWER.
* */
public class EuchreCardTrumpLogic {

    /*To avoid redundancy, null-check is done only once here for many functions*/
    public static boolean cardIsBower(Card card , Card.Suit trump ) {
        return  card.getRank() == Card.Rank.JACK
                && trump.getColor() == card.getColor();
    }
    public static boolean cardIsRightBower(Card card , Card.Suit trump ) {

        return cardIsBower( card , trump ) && trump == card.getSuit();
    }
    public static boolean cardIsLeftBower(Card card , Card.Suit trump ) {

        return cardIsBower( card , trump ) && trump != card.getSuit();
    }
    /*Example: Trump is SPADES. All SPADES are SPADES plus the left bower, the JACK of CLUBS.*/
    public static Card.Suit getEuchreCardSuit(Card card , Card.Suit trump ) {

        if ( cardIsLeftBower( card , trump ) ){
            return trump;
        } else {
            return card.getSuit();
        }
    }
    public static boolean cardIsTrump(Card card , Card.Suit trump ) {

        return  getEuchreCardSuit( card , trump ) == trump;
    }
    public static boolean cardsAreSameSuit(Card card , Card another , Card.Suit trump ) {

        return getEuchreCardSuit( card , trump ) == getEuchreCardSuit( another , trump );
    }
}
