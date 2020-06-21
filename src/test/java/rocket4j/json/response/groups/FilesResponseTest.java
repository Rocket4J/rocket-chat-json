/*
 * This file is part of rocket-chat-json.
 *
 * rocket-chat-json is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * rocket-chat-json is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with rocket-chat-json.  If not, see <https://www.gnu.org/licenses/>.
 */
package rocket4j.json.response.groups;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import rocket4j.json.JsonFile;
import rocket4j.json.JsonTests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@JsonTests
public final class FilesResponseTest {

    private final ObjectMapper objectMapper;

    public FilesResponseTest(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    void deserializeInfoResponseTest(@JsonFile("files-example-result.json") final String json) {
        assertDoesNotThrow(() -> this.objectMapper.readValue(json, FilesResponse.class));
    }
}