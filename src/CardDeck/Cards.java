package CardDeck;

import java.util.ArrayList;
import java.util.Collections;

public class Cards {
    private ArrayList<Card> cards;

    public Cards(){
        cards = new ArrayList<>();
    }
    public Cards( Deck deck ){
        cards.addAll(deck.toArrayList());
    }
    public ArrayList<Card> getCards(){
        return cards;
    }
    public boolean isEmpty(){
        return cards.isEmpty();
    }
    public int getNumberOfCards(){
        return cards.size();
    }
    public boolean add(Card c){
        return cards.add(c);
    }
    public void add(int i , Card c){
        cards.add( i, c );
    }
    public Card get(int i){
        return cards.get(i);
    }
    public Card remove(int i){
        return cards.remove(i);
    }
    public boolean remove(Card card){
        return cards.remove(card);
    }
    public boolean addAll( Cards cards){
        return this.cards.addAll( cards.cards );
    }
    public void clear(){
        cards.clear();
    }
    public void sort(){
        Collections.sort(cards);
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for ( Card c : cards ){
            str.append(c.toString());
            str.append(" | ");
        }
        str.delete(str.length()-3,str.length()-1);
        return str.toString();
    }
    public void print(){
        System.out.println(cards.toString());
    }
}
