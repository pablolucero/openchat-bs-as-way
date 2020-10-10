import java.util.ArrayList;
import java.util.List;

public class Publisher {

    public static final String INVALID_NAME = "Name cannot be blank";
    public static final String CAN_NOT_FOLLOW_SELF = "Can not follow self";

    private final String name;
    private final List<Publisher> followees = new ArrayList<>();

    public Publisher(String name) {
        this.name = name;
    }

    public static Publisher named(String name, String password, String about) {
        assertNameIsNotBlank(name);
        return new Publisher(name);
    }

    private static void assertNameIsNotBlank(String name) {
        if (name.isBlank()) throw new RuntimeException(INVALID_NAME);
    }

    public boolean isNamed(String potentialName) {
        return name.equals(potentialName);
    }

    public boolean hasNoFollowees() {
        return followees.isEmpty();
    }

    public void follow(Publisher followee) {
        if (this.equals(followee)) throw new RuntimeException(CAN_NOT_FOLLOW_SELF);
        followees.add(followee);
    }

    public boolean doesFollow(Publisher potentialFollowee) {
        return followees.contains(potentialFollowee);
    }

    public int numberOfFollowees() {
        return followees.size();
    }
}
