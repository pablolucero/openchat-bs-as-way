import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestXXX {

    public static final String PEPE_SANCHEZ_NAME = "Pepe Sanchez";
    public static final String PEPE_SANCHEZ_PASSWORD = "password";

    @Test
    void publisherCanNotHaveBlankName() {
        final RuntimeException error = assertThrows(
                RuntimeException.class,
                () -> Publisher.named(" ", "password", "about")
        );

        assertEquals(Publisher.INVALID_NAME, error.getMessage());
    }

    @Test
    void canCreatePublisherWithNoBlankName() {
        Publisher createdPublisher = createPepeSanchez();

        assertTrue(createdPublisher.isNamed(PEPE_SANCHEZ_NAME));
    }

    @Test
    void isNamedReturnsFalseWhenAskedWithOtherName() {
        Publisher createdPublisher = createPepeSanchez();

        assertFalse(createdPublisher.isNamed("Juan"));
    }

    @Test
    void createdPublisherHasNoFollowees() {
        Publisher createdPublisher = createPepeSanchez();

        assertTrue(createdPublisher.hasNoFollowees());
    }

    @Test
    void createdPublisherCanFollowOtherPublishers() {
        Publisher follower = createPepeSanchez();
        Publisher followee = Publisher.named("Juan Perez", "", "");

        follower.follow(followee);

        assertFalse(follower.hasNoFollowees());
        assertTrue(follower.doesFollow(followee));
        assertEquals(1, follower.numberOfFollowees());
    }

    @Test
    void publisherCanNotFollowSelf() {
        Publisher follower = createPepeSanchez();

        final RuntimeException error = assertThrows(
                RuntimeException.class,
                () -> follower.follow(follower)
        );

        assertEquals(Publisher.CAN_NOT_FOLLOW_SELF, error.getMessage());
        assertTrue(follower.hasNoFollowees());
    }

    private Publisher createPepeSanchez() {
        return Publisher.named(PEPE_SANCHEZ_NAME, PEPE_SANCHEZ_PASSWORD, "about");
    }
}
