public class Publisher {

    public static final String INVALID_NAME = "Name cannot be blank";

    private final String name;

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
        return true;
    }
}
