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
import rocket4j.json.user.InquiryUser;
import rocket4j.json.user.LiveChatUser;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableLiveChatRoom.class)
@JsonDeserialize(as = ImmutableLiveChatRoom.class)
@SuppressWarnings("immutables:subtype")
public interface LiveChatRoom extends Room {

    //TODO: Figure out what the h*ck "v" stands for
    InquiryUser v();

    LiveChatUser servedBy();

    //TODO: Figure out what "cl" stands for. Closed?? Doesn't make sense when there's an open field.
    boolean cl();

    boolean open();

    boolean waitingResponse();

    String departmentId();

    Metrics metrics();

    @JsonProperty("livechatData")
    Optional<JsonNode> liveChatData();

    List<String> tags();


    @Value.Immutable
    @JsonSerialize(as = ImmutableLiveChatRoom.Metrics.class)
    @JsonDeserialize(as = ImmutableLiveChatRoom.Metrics.class)
    interface Metrics {

        //TODO: Figure out what the heck "lq" stands for
        V v();

        @Value.Immutable
        @JsonSerialize(as = ImmutableLiveChatRoom.V.class)
        @JsonDeserialize(as = ImmutableLiveChatRoom.V.class)
        interface V {

            //TODO: Figure out  what the heck "lq" stands for
            ZonedDateTime lq();
        }
    }
}
