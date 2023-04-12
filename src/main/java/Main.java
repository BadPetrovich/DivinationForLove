import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //removes kings or queens from deck
    public static void chooseLoverGender(List<String> numbers){

        Scanner sc = new Scanner(System.in);

        System.out.println("BadPetrovich welcomes you in Divination For Love.");
        System.out.println("At first, please choose your gender.");
        //Can I do nextChar???
        System.out.println("Print 1 for Male or 2 for Female.");
        System.out.println();

        try {
            int gender = sc.nextInt();
            //== or equals?
            //likbez for deleting Q/K or QV/KV
            if(gender==1){
                numbers.remove("Q");
            }
            else if (gender==2){
                numbers.remove("K");
            }
            else {
                throw new Exception("Incorrect input!!! Try again.");
            }
            System.out.println();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sc.close();
        }
    }

    //Shuffle like cards
    public static void shuffleLovers(){

    }

    public static void getCardToBuffer(Random random, int randomCard, int boundOfRandom, List<String> cards){

        for(int i = 0; i<8; i++){
            randomCard = random.nextInt(boundOfRandom);
            cards.get(randomCard);
            cards.remove(randomCard);
//            cards.set(randomCard, "*********");
            System.out.print(randomCard + " ");
            boundOfRandom--;
        }
        System.out.println();
    }

    public static void main(String[] args){

        //think about shuffling lovers
        Lover firstLover = new Lover("Ivan");
        Lover secondLover = new Lover("Misha");
        Lover thirdLover = new Lover("Nikita");
        Lover fourthLover = new Lover("Oleg");

        List<String> numbers = new ArrayList<>(); //36 cards
        List<String> suit = new ArrayList<>();
        List<String> cards = new ArrayList<>();
        List<String> buffer = new ArrayList<>();


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

        chooseLoverGender(numbers);
        System.out.println(numbers);


        for(int i=0;i<numbers.size();i++){
            for(int j=0;j<suit.size();j++){
                cards.add(numbers.get(i) + " " + suit.get(j));
            }
        }

        System.out.println(cards);
        System.out.println(cards.size());

//        creating a random int in bound of 0-35
        //after removing gender u need to create bound of 0-31
        Random random = new Random();
        int randomCard = 0;
//        int boundOfRandom = 35;
        int boundOfRandom = 31;

        getCardToBuffer(random, randomCard, boundOfRandom, cards);
        System.out.println(cards);
        System.out.println(cards.size());
        boundOfRandom-=8;
        getCardToBuffer(random, randomCard, boundOfRandom, cards);
        System.out.println(cards);
        System.out.println(cards.size());
        boundOfRandom-=8;
        getCardToBuffer(random, randomCard, boundOfRandom, cards);
        System.out.println(cards);
        System.out.println(cards.size());

//        System.out.println();
//        System.out.println(numbers);
//        System.out.println(suit);
//        System.out.println(randomCard);

//        System.out.println(firstLover.getName());

    }

}