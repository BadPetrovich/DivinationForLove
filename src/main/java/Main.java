import java.util.*;

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

    public static void getLoversFromList(List<Lover> shuffeledLovers){
        for(int i =0;i<shuffeledLovers.size();i++){

            //getMyDeck instead of get
            // ---! Change if YOU wanna see names !---
//            String s = String.valueOf(shuffeledLovers.get(i));
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

    public static String removeLover(List<String> cards, List<Lover> lovers){

        System.out.println("Now you should choose what lover is bad for you!");
        System.out.println("Print his number");
        Scanner scRemover = new Scanner(System.in);
        int removeIndex = scRemover.nextInt()-1;
        String deletedLover = lovers.get(removeIndex).getName();
        lovers.remove(removeIndex);
        for(int i =0;i<lovers.size();i++){
            cards.addAll(lovers.get(i).getMyDeck());
            lovers.get(i).clearMyDeck();
        }
        return deletedLover;
    }

    public static void findYourLover(List<Lover> lovers, List<String> deletedLovers){

        System.out.println("Now you should choose last person you'll remove! It's epic moment!!!");
        System.out.println("Print his number");
        Scanner scRemover = new Scanner(System.in);
        int removeIndex = scRemover.nextInt()-1;
        deletedLovers.add(lovers.get(removeIndex).getName());
        lovers.remove(removeIndex);
        System.out.println("Yeees!!! Finally! Name of your lover is... " + lovers.get(0).getName());
        System.out.println("Happy love to both of you!");
        System.out.println("Do you want to know what lover you deleted each step?");
        System.out.println("Print 1 if you want to display this");
        if(scRemover.nextInt()==1){
            int i = 0;
            for (String s: deletedLovers){
                i++;
                System.out.println(i + " was removed - " + s);
            }
        }
        System.out.println("Thank you for playing and goodbye))");

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

        chooseLoverGender(numbers);

        for(int i=0;i<numbers.size();i++){
            for(int j=0;j<suit.size();j++){
                cards.add(numbers.get(i) + " " + suit.get(j));
            }
        }

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

        Collections.shuffle(lovers);

        List<String> deletedLovers = new ArrayList<>();

        InitializeLover(lovers,cards);
        getLoversFromList(lovers);
        deletedLovers.add(removeLover(cards, lovers));
        InitializeLover(lovers,cards);
        getLoversFromList(lovers);
        deletedLovers.add(removeLover(cards, lovers));
        InitializeLover(lovers,cards);
        getLoversFromList(lovers);
        findYourLover(lovers, deletedLovers);

    }
}