package kata.jcase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class JcaseApplicationTests {

    @Test
    void canReturnJcase() {
        var result = JadenCase.toJadenCase(null);
        assertNull(result);
        result = JadenCase.toJadenCase("");
        assertNull(result);
        result = JadenCase.toJadenCase("most trees are blue");
        assertEquals("Most Trees Are Blue", result);
    }

    @Test
    void canReturnJcaseWithWireMock() {
        var result = JadenCase.toJaden2(null);
        assertNull(result);
        result = JadenCase.toJaden2("");
        assertNull(result);
        result = JadenCase.toJaden2("most trees are blue");
        assertEquals("Most Trees Are Blue", result);

    }
}
