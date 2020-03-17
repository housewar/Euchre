package CardDeck;

import static CardDeck.EuchreCardTrumpLogic.*;

public class PlayableHand {

    public static Cards getPlayableEuchreHand(Cards hand, Card.Suit lead , Card.Suit trump ){
        Cards playable = new Cards();
        if ( lead != null ){
            for ( Card card : hand.getCards() ){
                if ( getEuchreCardSuit( card , trump ) == lead ) {
                    playable.add(card);
                }
            }
        }
        if ( playable.isEmpty() ){
            playable.addAll(hand);
        }
        return playable;
    }

}
