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
package rocket4j.json.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.Optional;
import org.immutables.value.Value;
import rocket4j.json.user.BaseUserData;

@Value.Immutable
@JsonSerialize(as = ImmutableBaseMessageData.class)
@JsonDeserialize(as = ImmutableBaseMessageData.class)
public interface BaseMessageData {

    @JsonProperty("_id")
    String id();

    @JsonProperty("rid")
    String roomId();

    @JsonProperty("msg")
    String content();

    @JsonProperty("ts")
    ZonedDateTime timestamp();

    @JsonProperty("_updatedAt")
    ZonedDateTime updatedAt();

    @JsonProperty("u")
    BaseUserData author();

    @JsonProperty("alias")
    Optional<String> authorAlias(); // Legit no idea what this is freaking for.

    //TODO: Convert to enum once I learn how to do it with jackson
    @JsonProperty("t")
    Optional<String> type();

    // Edit related data
    Optional<ZonedDateTime> editedAt();

    Optional<BaseUserData> editedBy();
}
