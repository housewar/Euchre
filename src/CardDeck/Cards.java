package CardDeck;

import java.util.ArrayList;
import java.util.Collections;

public class Cards {
    private ArrayList<Card> cards;

    public Cards(){
        cards = new ArrayList<Card>();
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
    public Card get(int i){
        return cards.get(i);
    }
    public Card remove(int i){
        return cards.remove(i);
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
