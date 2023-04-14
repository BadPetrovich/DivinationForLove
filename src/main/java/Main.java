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
        }
//        finally {
//            sc.close();
//        }
    }

    //Shuffle like cards
    public static void shuffleLovers(List<Lover> lovers, List<Lover> shuffeledLovers){
        Random random = new Random();
        int randomLover = 0;
        int boundOfLovers = 4;
        for(int i =0;i<4;i++){
            randomLover = random.nextInt(boundOfLovers);
            shuffeledLovers.add(lovers.get(randomLover));
//            String s = String.valueOf(lovers.get(randomLover));
            lovers.remove(randomLover);
            boundOfLovers--;
//            System.out.println(s);
        }

    }

    public static void getLoversFromList(List<Lover> shuffeledLovers){
        for(int i =0;i<shuffeledLovers.size();i++){

            //getMyDeck instead of get
            String s = String.valueOf(shuffeledLovers.get(i));
            System.out.println(s);
        }
    }

    public static void InitializeLover(List<Lover> shuffledLovers, List<String> cards,
                                       int boundOfRandom, Random random, int randomCard){
        for(int i = 0; i<shuffledLovers.size();i++){
            if(i==shuffledLovers.size()-1){
                boundOfRandom-=7;
            }
            else {
                boundOfRandom-=8;
            }
            shuffledLovers.get(i).getCardToBuffer(random, randomCard, boundOfRandom, cards);
//            System.out.println(cards);
//            System.out.println(cards.size());
        }
    }

    public static void removeLover(List<String> cards, List<Lover> shuffeledLovers){

        System.out.println("Now you should choose what lover is bad for you!");
        System.out.println("Print his number");
        Scanner scRemover = new Scanner(System.in);
        shuffeledLovers.remove(scRemover.nextInt()-1);
        for(int i =0;i<shuffeledLovers.size();i++){
            cards.addAll(shuffeledLovers.get(i).getMyDeck());
            shuffeledLovers.get(i).clearMyDeck();
        }

    }

    public static void findYourLover(List<Lover> shuffeledLovers){

        System.out.println("Now you should choose last person you'll remove! It's epic moment!!!");
        System.out.println("Print his number");
        Scanner scRemover = new Scanner(System.in);
        System.out.println(shuffeledLovers.remove(scRemover.nextInt()-1));
        System.out.println("Yeees!!! Finally! Name of your lover is... " + shuffeledLovers.get(0).getName());
        System.out.println("Happy love to both of you!");
        System.out.println("Thank you for playing and goodbye))");

    }



    public static void main(String[] args){

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

        //think about shuffling lovers
        Lover firstLover = new Lover();
        Lover secondLover = new Lover();
        Lover thirdLover = new Lover();
        Lover fourthLover = new Lover();

        //Ask Anton about Scanners? 1 Scanner for application or few?
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
        System.out.println(lovers);

        List<Lover> shuffledLovers = new ArrayList<>();

        shuffleLovers(lovers, shuffledLovers);
//        System.out.println(lovers);
        System.out.println(shuffledLovers);



//        creating a random int in bound of 0-35
        //after removing gender u need to create bound of 0-31
        Random random = new Random();
        int randomCard = 0;
//        int boundOfRandom = 35;
        int boundOfRandom = 39;


        System.out.println(cards);
//        for(int i = 0; i<shuffledLovers.size();i++){
//            if(i==shuffledLovers.size()-1){
//                boundOfRandom-=7;
//            }
//            else {
//                boundOfRandom-=8;
//            }
//            shuffledLovers.get(i).getCardToBuffer(random, randomCard, boundOfRandom, cards);
//            System.out.println(cards);
//            System.out.println(cards.size());
//        }

        System.out.println(boundOfRandom);
        InitializeLover(shuffledLovers,cards,boundOfRandom,random,randomCard);
        getLoversFromList(shuffledLovers);
        removeLover(cards, shuffledLovers);
        System.out.println(shuffledLovers);
        System.out.println(cards);
        boundOfRandom-=8;
        System.out.println(boundOfRandom);
        InitializeLover(shuffledLovers,cards,boundOfRandom,random,randomCard);
        getLoversFromList(shuffledLovers);
        removeLover(cards, shuffledLovers);
        System.out.println(shuffledLovers);
        System.out.println(cards);
        boundOfRandom-=8;
        System.out.println(boundOfRandom);
        InitializeLover(shuffledLovers,cards,boundOfRandom,random,randomCard);
        getLoversFromList(shuffledLovers);
        findYourLover(shuffledLovers);
//        System.out.println(shuffledLovers);
//        System.out.println(cards);

//        boundOfRandom-=8;
//        System.out.println(boundOfRandom);
//        InitializeLover(shuffledLovers,cards,boundOfRandom,random,randomCard);
//        getLoversFromList(shuffledLovers);
//        removeLover(cards, shuffledLovers);
//        System.out.println(shuffledLovers);
//        System.out.println(cards);



        //need to sort Lover Deck
//        System.out.println("1 Lover Deck" + firstLover.getMyDeck());
//        System.out.println("2 Lover Deck" + secondLover.getMyDeck());
//        System.out.println("3 Lover Deck" + thirdLover.getMyDeck());
//        System.out.println("4 Lover Deck" + fourthLover.getMyDeck());

//        System.out.println();
//        System.out.println(numbers);
//        System.out.println(suit);
//        System.out.println(randomCard);

//        System.out.println(firstLover.getName());

    }

}