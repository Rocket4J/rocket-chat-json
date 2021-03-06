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
package rocket4j.json.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableBaseUserData.class)
@JsonDeserialize(as = ImmutableBaseUserData.class)
public interface BaseUserData {

    @JsonProperty("_id")
    String id();

    String username();

    Optional<String> type();

    Optional<String> name();

    //TODO: Convert this to enum once I figure out how to make jackson support that lol
    Optional<String> status();

    Optional<Boolean> active();

    Optional<ZonedDateTime> createdAt();

    @JsonProperty("_updatedAt")
    Optional<ZonedDateTime> updatedAt();

    Optional<List<Email>> emails();

    Optional<Boolean> requirePasswordChange();

    Optional<JsonNode> settings();

    Optional<String> token();

    @Value.Immutable
    @JsonSerialize(as = ImmutableBaseUserData.Email.class)
    @JsonDeserialize(as = ImmutableBaseUserData.Email.class)
    interface Email {

        String address();

        boolean verified();
    }
}
