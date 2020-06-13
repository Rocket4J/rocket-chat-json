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
package rocket4j.json.response.autotranslate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableTranslateMessageResponse.class)
@JsonDeserialize(as = ImmutableTranslateMessageResponse.class)
public interface TranslateMessageResponse {

    @JsonProperty("success")
    boolean successful();

    Message message();

    @Value.Immutable
    @JsonSerialize(as = ImmutableTranslateMessageResponse.Message.class)
    @JsonDeserialize(as = ImmutableTranslateMessageResponse.Message.class)
    interface Message {

        @JsonProperty("_id")
        String id();

        String rid();

        @JsonProperty("msg")
        String message();

        @JsonProperty("ts")
        ZonedDateTime timestamp();

        @JsonProperty("u")
        User user();

        @JsonProperty("_updatedAt")
        ZonedDateTime updatedAt();

        List<Mention> mentions();

        List<Channel> channels();

        JsonNode translations();

        @Value.Immutable
        @JsonSerialize(as = ImmutableTranslateMessageResponse.User.class)
        @JsonDeserialize(as = ImmutableTranslateMessageResponse.User.class)
        interface User {

            @JsonProperty("_id")
            String id();

            String username();

            String name();
        }

        @Value.Immutable
        @JsonSerialize(as = ImmutableTranslateMessageResponse.Mention.class)
        @JsonDeserialize(as = ImmutableTranslateMessageResponse.Mention.class)
        interface Mention {
            //TODO: mention
        }

        @Value.Immutable
        @JsonSerialize(as = ImmutableTranslateMessageResponse.Channel.class)
        @JsonDeserialize(as = ImmutableTranslateMessageResponse.Channel.class)
        interface Channel {
            //TODO: Channel
        }
    }
}
