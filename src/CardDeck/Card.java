package CardDeck;

public class Card implements Comparable<Card> {

    public enum Suit {

        // suitChar is the unicode character for the playing card suit
        SPADES(0, Color.BLACK, "\u2660"),
        DIAMONDS(1, Color.RED, "\u2666"),
        CLUBS(2, Color.BLACK, "\u2663"),
        HEARTS(3, Color.RED, "\u2665");

        public enum Color {
            RED,
            BLACK
        }

        private final int value;
        private final Suit.Color color;
        private final String suitChar;

        Suit(int value, Color color, String suitChar) {
            this.value = value;
            this.color = color;
            this.suitChar = suitChar;
        }

        public int getSuitValue() {
            return this.value;
        }
        public Color getColor() {
            return this.color;
        }
        public String getSuitChar() {
            return this.suitChar;
        }
        // returns the other suit of the same color
        public Suit getOtherSameColorSuit() {
            return Suit.values()[(this.value + 2) % 4];
        }

    }

    public enum Rank {

        TWO(2, '2'),
        THREE(3, '3'),
        FOUR(4, '4'),
        FIVE(5, '5'),
        SIX(6, '6'),
        SEVEN(7, '7'),
        EIGHT(8, '8'),
        NINE(9, '9'),
        TEN(10, 'T'),
        JACK(11, 'J'),
        QUEEN(12, 'Q'),
        KING(13, 'K'),
        ACE(14, 'A');

        private final int value;
        private final char rankChar;

        Rank(int value, char rankChar) {
            this.value = value;
            this.rankChar = rankChar;
        }
        public int getRankValue() {
            return this.value;
        }
        public char getRankChar() {
            return rankChar;
        }

    }

    private final int CARDS_PER_SUIT = 13;
    private final Rank rank;
    private final Suit suit;

    public Card(Rank r, Suit s) {
        this.rank = r;
        this.suit = s;
    }
    public Rank getRank() {
        return rank;
    }
    public int getRankValue() {
        return rank.getRankValue();
    }
    public Suit getSuit() {
        return suit;
    }
    public int getSuitValue() {
        return suit.getSuitValue();
    }
    public Suit.Color getColor() {
        return suit.getColor();
    }
    @Override
    public String toString() {
        return rank.getRankChar() + suit.getSuitChar();
    }
    @Override
    public boolean equals(Object o) {
        if ( o instanceof Card ){
            Card another = (Card)o;
            return this.rank == another.rank && this.suit == another.suit;
        } else {
            return false;
        }
    }
    /* To sort a deck or a hand by suit and then rank, a value is assigned to each card.
     * The rank value is added to the suit value multiplied by the cards per suit (13).
     *          | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | J  | Q  | K  | A
     * Spades   : 2    3    4    5    6    7    8    9    10   11   12   13   14
     * Diamonds : 15   16   17   18   19   20   21   22   23   24   25   26   27
     * Clubs    : 28   29   30   31   32   33   34   35   36   37   38   39   40
     * Hearts   : 41   42   43   44   45   46   47   48   49   50   51   52   53
     * */
    protected int calculateSortValue() {
        return (this.suit.getSuitValue() * CARDS_PER_SUIT) + this.rank.getRankValue();
    }
    @Override
    public int compareTo(Card another) {
        return Integer.compare(this.calculateSortValue(), another.calculateSortValue());
    }
}