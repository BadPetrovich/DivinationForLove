import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        String o1 = "9 hearts";
        String o2 = "V diamonds";
        CardComparatorTest cardComparatorTest = new CardComparatorTest();

        int res = cardComparatorTest.compare(o1,o2);
        System.out.println(res);
    }

    public static void removeLoverTest(List<String> cards, List<Lover> shuffeledLovers, List<Lover> lovers){

        System.out.println("Now you should choose what lover is bad for you!");
        System.out.println("Print his number");
        Scanner scRemover = new Scanner(System.in);
        int removeIndex = scRemover.nextInt()-1;
        lovers.add(shuffeledLovers.get(removeIndex));
        shuffeledLovers.remove(removeIndex);
        for(int i =0;i<shuffeledLovers.size();i++){
            cards.addAll(shuffeledLovers.get(i).getMyDeck());
            shuffeledLovers.get(i).clearMyDeck();
        }

    }

    public static void findYourLoverTest(List<Lover> shuffeledLovers, List<Lover> lovers){

        System.out.println("Now you should choose last person you'll remove! It's epic moment!!!");
        System.out.println("Print his number");
        Scanner scRemover = new Scanner(System.in);
        shuffeledLovers.remove(scRemover.nextInt()-1);
        System.out.println("Yeees!!! Finally! Name of your lover is... " + shuffeledLovers.get(0).getName());
        System.out.println("Happy love to both of you!");
        System.out.println("Do you want to know what lover you deleted each step?");
        System.out.println("Print 1 if you want to display this");
        if(scRemover.nextInt()==1){
            System.out.println("First was removed - " + lovers.get(0).getName());
            System.out.println("Second was removed - " + lovers.get(1).getName());
            System.out.println("And last was removed - " + lovers.get(2).getName());
        }
        System.out.println("Thank you for playing and goodbye))");

    }
}
class CardComparatorTest implements Comparator<String> {

    String[] suit = {"clubs", "diamonds", "hearts", "spades"};

    @Override
    public int compare(String o1, String o2) {
        String[] suit1 = o1.split(" ");
        String[] suit2 = o2.split(" ");

        System.out.println(suit1[1]);
        System.out.println(suit2[1]);

        int result=0;
        for (String s : suit) {
            if(suit1[1].matches(s) && suit2[1].matches(s)){
                break;
            }
            else if(suit1[1].matches(s) && !suit2[1].matches(s)){
                result=1;
                break;
            }
            else if(!suit1[1].matches(s) && suit2[1].matches(s)){
                result=-1;
                break;
            }
        }
        return result;
    }
}