package rocket4j.json.response.groups;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import rocket4j.json.JsonFile;
import rocket4j.json.JsonTests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@JsonTests
public final class CreateResponseTest {

    private final ObjectMapper objectMapper;

    public CreateResponseTest(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    void deserializeInfoResponseTest(@JsonFile("create-example-result.json") final String json) {
        assertDoesNotThrow(() -> this.objectMapper.readValue(json, CreateResponse.class));
    }
}

