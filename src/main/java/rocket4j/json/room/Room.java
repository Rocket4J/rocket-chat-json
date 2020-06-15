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
package rocket4j.json.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;
import rocket4j.json.user.MinimalUser;

@Value.Immutable
@JsonSerialize(as = ImmutableRoom.class)
@JsonDeserialize(as = ImmutableRoom.class)
public interface Room {

    @JsonProperty("_id")
    String id();

    //TODO: Figure out what the h*ck "t" stands for
    String t();

    Optional<String> name();

    //TODO: Figure out what the h*ck "f" stands for.
    @JsonProperty("fname")
    Optional<String> fName();

    @JsonProperty("_updatedAt")
    Optional<ZonedDateTime> updatedAt();

    Optional<List<String>> usernames();

    @JsonProperty("msgs")
    Optional<Integer> messages();

    Optional<Integer> usersCount();

    @JsonProperty("default")
    Optional<Boolean> defaultRoom();

    @JsonProperty("u")
    Optional<MinimalUser> user();

    Optional<JsonNode> customFields();

    @JsonProperty("ro")
    Optional<Boolean> readOnly();

    Optional<Boolean> broadcast();

    Optional<Boolean> encrypted();

    @JsonProperty("sysMes")
    Optional<Boolean> systemMessage();

    @JsonProperty("ts")
    Optional<ZonedDateTime> timestamp();

    @JsonProperty("lm")
    Optional<ZonedDateTime> lastMessageTimestamp();
}
