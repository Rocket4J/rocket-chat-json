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

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;
import rocket4j.json.message.MessageData;
import rocket4j.json.user.BaseUserData;

@Value.Immutable
@JsonSerialize(as = ImmutableBaseRoomData.class)
@JsonDeserialize(as = ImmutableBaseRoomData.class)
public interface BaseRoomData {

    @JsonAlias({"_id", "rid"})
    String id();

    //TODO: Make this an enum once I figure out how to do that with jackson
    @JsonProperty("t")
    Optional<String> type(); //No idea why this is optional, it really shouldn't be... Thank R.C for that

    Optional<String> name();

    Optional<String> fname();

    @JsonProperty("u")
    Optional<BaseUserData> user();

    Optional<String> username();

    Optional<List<String>> usernames();

    @JsonProperty("msgs")
    Optional<Integer> messageCount();

    @JsonProperty("usersCount")
    Optional<Integer> userCount();

    @JsonProperty("default")
    Optional<Boolean> defaultRoom();

    @JsonProperty("_updatedAt")
    Optional<ZonedDateTime> updatedAt();

    Optional<MessageData> lastMessage();

    @JsonProperty("lm")
    Optional<ZonedDateTime> lastMessageTimestamp();
}
