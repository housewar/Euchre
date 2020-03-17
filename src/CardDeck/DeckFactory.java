package CardDeck;

public class DeckFactory {
    public static Deck getEuchreDeck(){
        return new Deck( Card.Rank.NINE , Card.Rank.ACE );
    }
}
