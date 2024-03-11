import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EX10 {

        @ParameterizedTest
        @ValueSource(strings = {"123456789012345", "1234567890123456", "12345678901234567"})
        public void StringNameLength(String name){

            int nameforcheck = name.length();

            assertTrue(nameforcheck>15, "Unexpected variable length");


        }
}
