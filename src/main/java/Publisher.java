public class Publisher {

    public static final String INVALID_NAME = "Name cannot be blank";

    public static void named(String name, String password, String about) {
        throw new RuntimeException(INVALID_NAME);
    }
}
