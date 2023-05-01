import java.util.*;

public class Main {

    public static void getLoversFromList(List<Lover> shuffeledLovers){
        for(int i =0;i<shuffeledLovers.size();i++){

            //getMyDeck instead of get
            // ---! Change if YOU wanna see names !---
//            String loversDeck = String.valueOf(shuffeledLovers.get(i));
            String loversDeck = String.valueOf(shuffeledLovers.get(i).getMyDeck());
            System.out.println(i+1 + " " + loversDeck);
        }
    }

    public static void InitializeLover(List<Lover> shuffledLovers, List<String> cards){

        for(int i = 0; i<shuffledLovers.size();i++){
            int boundOfRandom=cards.size();
            shuffledLovers.get(i).getCardToBuffer(boundOfRandom, cards);
        }
    }


    public static void main(String[] args){

        List<String> numbers = new ArrayList<>(); //36 cards - 4 cards after lover_gender_using
        List<String> suit = new ArrayList<>();
        List<String> cards = new ArrayList<>();

        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");
        numbers.add("10");
        numbers.add("V");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        suit.add("clubs");
        suit.add("diamonds");
        suit.add("hearts");
        suit.add("spades");

        IO.chooseLoverGender(numbers);

        for(int i=0;i<numbers.size();i++){
            for(int j=0;j<suit.size();j++){
                cards.add(numbers.get(i) + " " + suit.get(j));
            }
        }

        Lover firstLover = new Lover();
        Lover secondLover = new Lover();
        Lover thirdLover = new Lover();
        Lover fourthLover = new Lover();

        List<Lover> lovers = new ArrayList<>();

        lovers.add(firstLover);
        lovers.add(secondLover);
        lovers.add(thirdLover);
        lovers.add(fourthLover);

        int loverNumber=0;
        for(Lover l: lovers){
            l.setName(IO.chooseLoverName(loverNumber));
            loverNumber++;
        }

        Collections.shuffle(lovers);

        List<String> deletedLovers = new ArrayList<>();

        InitializeLover(lovers,cards);
        getLoversFromList(lovers);
        deletedLovers.add(IO.removeLover(cards, lovers));
        InitializeLover(lovers,cards);
        getLoversFromList(lovers);
        deletedLovers.add(IO.removeLover(cards, lovers));
        InitializeLover(lovers,cards);
        getLoversFromList(lovers);
        IO.findYourLover(lovers, deletedLovers);

        IO.sc.close();
    }
}