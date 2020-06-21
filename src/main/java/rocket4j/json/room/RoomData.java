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

@Value.Immutable
@JsonSerialize(as = ImmutableRoomData.class)
@JsonDeserialize(as = ImmutableRoomData.class)
@SuppressWarnings("immutables:subtype")
public interface RoomData extends BaseRoomData {

    Optional<String> topic();

    @JsonProperty("muted")
    Optional<List<String>> mutedUsers();

    Optional<ZonedDateTime> jitsiTimeout();

    @JsonProperty("ts")
    Optional<ZonedDateTime> timestamp();

    @JsonProperty("ro")
    Optional<Boolean> readOnly();

    //TODO: Figure out what this is
    Optional<String> prid();

    @JsonProperty("sysMes")
    Optional<Boolean> systemMessage();

    Optional<Boolean> broadcast();

    Optional<Boolean> encrypted();

    Optional<JsonNode> customFields();

    Optional<Boolean> joinCodeRequired();
}
