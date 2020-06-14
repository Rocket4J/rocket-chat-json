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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.Optional;
import org.immutables.value.Value;
import rocket4j.json.message.Message;
import rocket4j.json.user.MinimalUser;

@Value.Immutable
@JsonSerialize(as = ImmutableDiscussion.class)
@JsonDeserialize(as = ImmutableDiscussion.class)
public interface Discussion {

    @JsonProperty("rid")
    Optional<String> roomId();

    String name();

    //TODO: Figure out what the h*ck "f" stands for
    @JsonProperty("fname")
    String fName();

    //TODO: Figure out what the h*ck "t" stands for
    String t();

    @JsonProperty("msgs")
    int messages();

    int usersCount();

    @JsonProperty("u")
    MinimalUser user();

    String topic();

    @JsonProperty("prid")
    String parentRoomId();

    @JsonProperty("ts")
    ZonedDateTime timestamp();

    @JsonProperty("ro")
    boolean readOnly();

    @JsonProperty("sysMes")
    boolean systemMessage();

    @JsonProperty("default")
    boolean defaultRoom();

    @JsonProperty("_updatedAt")
    ZonedDateTime updatedAt();

    @JsonProperty("_id")
    String id();

    Optional<Message> lastMessage();

    @JsonProperty("lm")
    Optional<ZonedDateTime> lastMessageTimestamp();
}
