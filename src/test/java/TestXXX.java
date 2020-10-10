import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestXXX {

    @Test
    void publisherCanNotHaveBlankName() {

        final RuntimeException error = assertThrows(
                RuntimeException.class,
                () -> Publisher.named(" ", "password", "about")
        );

        assertEquals(Publisher.INVALID_NAME, error.getMessage());
    }
}
