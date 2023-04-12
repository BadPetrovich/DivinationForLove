import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Lover {
    private String name;

    private List<String> myDeck = new ArrayList<>();

    public Lover(String name) {
        this.name = name;
    }


    public void getDeck(List<String> buffer){

        myDeck.addAll(buffer);

    }

    public String getName() {
        return name;
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
