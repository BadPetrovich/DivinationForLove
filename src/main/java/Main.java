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
    public static void shuffleLovers(List<Lover> lovers){
        Random random = new Random();
        int randomLover = 0;
        int boundOfLovers = 4;
        for(int i =0;i<4;i++){
            randomLover = random.nextInt(boundOfLovers);
            String s = String.valueOf(lovers.get(randomLover));
            lovers.remove(randomLover);
            boundOfLovers--;
            System.out.println(s);
        }

    }

    public static void main(String[] args){

        //think about shuffling lovers
        Lover firstLover = new Lover();
        Lover secondLover = new Lover();
        Lover thirdLover = new Lover();
        Lover fourthLover = new Lover();

//        firstLover.ConfigureLover();
//        System.out.println(firstLover.getName());
//        secondLover.ConfigureLover();
//        thirdLover.ConfigureLover();
//        fourthLover.ConfigureLover();

        Scanner scannerName = new Scanner(System.in);
        System.out.println("Choose name for first lover");
        String FirstName = scannerName.next();
        System.out.println("Choose name for second lover");
        String SecondName = scannerName.next();
        System.out.println("Choose name for third lover");
        String ThirdName = scannerName.next();
        System.out.println("Choose name for fourth lover");
        String FourthName = scannerName.next();
        firstLover.setName(FirstName);
        secondLover.setName(SecondName);
        thirdLover.setName(ThirdName);
        fourthLover.setName(FourthName);



        List<Lover> lovers = new ArrayList<>();

        lovers.add(firstLover);
        lovers.add(secondLover);
        lovers.add(thirdLover);
        lovers.add(fourthLover);

        shuffleLovers(lovers);

        List<String> numbers = new ArrayList<>(); //36 cards - 4 cards after lover_gender_using
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

        firstLover.getCardToBuffer(random, randomCard, boundOfRandom, cards);
        System.out.println(cards);
        System.out.println(cards.size());
        boundOfRandom-=8;
        secondLover.getCardToBuffer(random, randomCard, boundOfRandom, cards);
        System.out.println(cards);
        System.out.println(cards.size());
        boundOfRandom-=8;
        thirdLover.getCardToBuffer(random, randomCard, boundOfRandom, cards);
        System.out.println(cards);
        System.out.println(cards.size());
        boundOfRandom-=7;
        fourthLover.getCardToBuffer(random, randomCard, boundOfRandom, cards);
        System.out.println(cards);
        System.out.println(cards.size());

        System.out.println("1 Lover Deck" + firstLover.getMyDeck());
        System.out.println("2 Lover Deck" + secondLover.getMyDeck());
        System.out.println("3 Lover Deck" + thirdLover.getMyDeck());
        System.out.println("4 Lover Deck" + fourthLover.getMyDeck());

//        System.out.println();
//        System.out.println(numbers);
//        System.out.println(suit);
//        System.out.println(randomCard);

//        System.out.println(firstLover.getName());

    }

}