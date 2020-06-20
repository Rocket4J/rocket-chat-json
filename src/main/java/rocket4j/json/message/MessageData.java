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
import rocket4j.json.attachment.AttachmentData;
import rocket4j.json.file.BaseFileData;
import rocket4j.json.user.BaseUserData;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableMessageData.class)
@JsonDeserialize(as = ImmutableMessageData.class)
@SuppressWarnings("immutables:subtype")
public interface MessageData extends BaseMessageData {

    Optional<Boolean> groupable();

    Optional<Boolean> unread();

    Optional<List<String>> urls();

    Optional<String> avatar();

    //TODO: Figure out why this is being sent.
    Optional<String> emoji();

    Optional<Boolean> parseUrls();

    Optional<Map<String, String>> translations();

    Optional<List<Star>> starred();

    Optional<List<AttachmentData>> attachments();

    Optional<Map<String, Reaction>> reactions();

    //TODO: Figure out what this is and if it can be modelled. Right now, I haven't found any info at all
    Optional<JsonNode> bot();

    Optional<String> token();

    Optional<Boolean> newRoom();

    Optional<Boolean> showConnecting();

    Optional<BaseFileData> file();

    // Pin-related fields
    Optional<Boolean> pinned();

    Optional<ZonedDateTime> pinnedAt();

    Optional<BaseUserData> pinnedBy();

    //Snippet-related fields
    Optional<String> snippetName();

    Optional<Boolean> snippeted();

    Optional<BaseUserData> snippetedBy();


    @Value.Immutable
    @JsonSerialize(as = ImmutableMessageData.Reaction.class)
    @JsonDeserialize(as = ImmutableMessageData.Reaction.class)
    interface Reaction {

        List<String> usernames();
    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableMessageData.Star.class)
    @JsonDeserialize(as = ImmutableMessageData.Star.class)
    interface Star {

        @JsonProperty("_id")
        String id();
    }
}
