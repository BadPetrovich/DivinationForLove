import java.util.*;

public class Lover {
    private String name;

    private List<String> myDeck = new ArrayList<>();

    public Lover() {
    }

//    public Lover(String name) {
//        this.name = name;
//    }


    public void getCardToBuffer(Random random, int randomCard, int boundOfRandom, List<String> cards){

        for(int i = 0; i<8; i++){
            randomCard = random.nextInt(boundOfRandom);
            myDeck.add(cards.get(randomCard));
            cards.remove(randomCard);
//            cards.set(randomCard, "*********");
            System.out.print(randomCard + " ");
            boundOfRandom--;
        }
        System.out.println();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMyDeck() {
        return myDeck;
    }

    @Override
    public String toString() {
        return "Lover{" +
                "name='" + name + '\'' +
                ", myDeck=" + myDeck +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lover lover = (Lover) o;
        return Objects.equals(name, lover.name) && Objects.equals(myDeck, lover.myDeck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, myDeck);
    }
}
