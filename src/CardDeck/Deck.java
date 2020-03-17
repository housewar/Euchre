package CardDeck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private int NUMBER_OF_CARDS;
    private Card[] cards;
    private ArrayList<Card> deck;

    public Deck(){
        this( Card.Rank.TWO , Card.Rank.ACE );
    }
    public Deck( Card.Rank min , Card.Rank max ){
        NUMBER_OF_CARDS = 4 * (1 + max.getRankValue() - min.getRankValue());
        cards = new Card[NUMBER_OF_CARDS];
        deck = new ArrayList<Card>(NUMBER_OF_CARDS);
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
    public Card removeNext(){
        return deck.remove(deck.size() - 1 );
    }
    public Card get( int i ){
        return deck.get( i );
    }
    public void reset(){
        deck.clear();
        for ( Card c : cards){
            deck.add( c );
        }
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public void sort(){
        Collections.sort(deck);
    }
}
