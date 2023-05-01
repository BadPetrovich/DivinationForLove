import java.util.List;
import java.util.Scanner;

public class IO {
    static Scanner sc = new Scanner(System.in);
    public static void chooseLoverGender(List<String> numbers){

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
    }

    public static String removeLover(List<String> cards, List<Lover> lovers){

        System.out.println("Now you should choose what lover is bad for you!");
        System.out.println("Print his number");
        try {
            int removeIndex = sc.nextInt()-1;
            String deletedLover = lovers.get(removeIndex).getName();
            lovers.remove(removeIndex);
            for(int i =0;i<lovers.size();i++){
                cards.addAll(lovers.get(i).getMyDeck());
                lovers.get(i).clearMyDeck();
            }
            return deletedLover;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void findYourLover(List<Lover> lovers, List<String> deletedLovers){

        System.out.println("Now you should choose last person you'll remove! It's epic moment!!!");
        System.out.println("Print his number");
        try {
            int removeIndex = sc.nextInt()-1;
            deletedLovers.add(lovers.get(removeIndex).getName());
            lovers.remove(removeIndex);
            System.out.println("Yeees!!! Finally! Name of your lover is... " + lovers.get(0).getName());
            System.out.println("Happy love to both of you!");
            System.out.println("Do you want to know what lover you deleted each step?");
            System.out.println("Print 1 if you want to display this");
            try {
                if(sc.nextInt()==1){
                    int i = 0;
                    for (String s: deletedLovers){
                        i++;
                        System.out.println(i + " was removed - " + s);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thank you for playing and goodbye))");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String chooseLoverName(int loverNumber){
        loverNumber++;
        System.out.println("Choose name for "+ loverNumber + " lover");
        try {
            return sc.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
