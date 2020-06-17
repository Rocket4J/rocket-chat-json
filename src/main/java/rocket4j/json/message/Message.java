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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.immutables.value.Value;
import rocket4j.json.attachment.Attachment;
import rocket4j.json.file.MinimalFile;
import rocket4j.json.user.MinimalUser;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableMessage.class)
@JsonDeserialize(as = ImmutableMessage.class)
public interface Message {

    String msg();

    @JsonProperty("ts")
    ZonedDateTime timestamp();

    @JsonProperty("u")
    MinimalUser user();


    @JsonProperty("rid")
    String roomId();

    @JsonProperty("_id")
    String id();

    @JsonProperty("_updatedAt")
    ZonedDateTime updatedAt();

    List<String> mentions();

    List<String> channels();

    //TODO: Find out what t stands for
    Optional<String> t();

    Optional<Boolean> groupable();

    Optional<MinimalFile> file();

    Optional<List<Attachment>> attachments();

    Optional<JsonNode> translations();

    //Other stuff that I don't know where it really fits in...
    Optional<Boolean> parseUrls();

    Optional<List<String>> urls();

    //Literally no idea what this is for or if there is actually a mappable object for it
    Optional<JsonNode> bot();

    Optional<Map<String, Reaction>> reactions();

    Optional<Star> starred();

    Optional<String> alias();

    Optional<String> emoji();

    Optional<String> avatar();

    //Edit data
    Optional<MinimalUser> editedBy();

    Optional<ZonedDateTime> editedAt();

    //Live chat specific Message data
    Optional<String> token();

    Optional<Boolean> newRoom();

    Optional<Boolean> showConnecting();

    @Value.Immutable
    @JsonSerialize(as = ImmutableMessage.Reaction.class)
    @JsonDeserialize(as = ImmutableMessage.Reaction.class)
    interface Reaction {

        List<String> usernames();
    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableMessage.Star.class)
    @JsonDeserialize(as = ImmutableMessage.Star.class)
    interface Star {

        @JsonProperty("_id")
        String id();
    }
}
