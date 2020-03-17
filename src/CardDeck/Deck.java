package CardDeck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private int NUMBER_OF_CARDS;
    /*Why two data structures for the same cards?
    * The array keeps the cards in a single location to be re-used with every round.
    * The array list can be sorted and shuffled and cards can be given away without worrying about
    * keeping track of them.*/
    private Card[] cards;
    private ArrayList<Card> deck;

    /*Full deck*/
    public Deck(){
        this( Card.Rank.TWO , Card.Rank.ACE );
    }
    /*Partial deck construction, used for games like Euchre that don't use the full deck*/
    public Deck( Card.Rank min , Card.Rank max ){
        NUMBER_OF_CARDS = 4 * (1 + max.getRankValue() - min.getRankValue());
        cards = new Card[NUMBER_OF_CARDS];
        deck = new ArrayList<>(NUMBER_OF_CARDS);
        int i = 0;
        for ( Card.Suit s : Card.Suit.values() ){
            for ( Card.Rank r : Card.Rank.values() ){
                if (       r.getRankValue() >= min.getRankValue()
                        && r.getRankValue() <= max.getRankValue() ){
                    cards[i] = new Card( r , s );
                    deck.add(cards[i]);
                    ++i;
                }
            }
        }
    }
    public int getNumberOfCardsLeft(){
        return deck.size();
    }
    /*Removing from the back to avoid shifting elements*/
    public Card removeNext(){
        return deck.remove(deck.size() - 1 );
    }
    public Card get( int i ){
        return deck.get( i );
    }
    public void reset(){
        deck.clear();
        Collections.addAll(deck, cards);
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public void sort(){
        Collections.sort(deck);
    }
}
