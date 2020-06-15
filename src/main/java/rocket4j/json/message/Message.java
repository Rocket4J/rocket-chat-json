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
import java.util.Optional;
import org.immutables.value.Value;
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

    Optional<File> file();

    Optional<List<Attachment>> attachments();

    Optional<JsonNode> translations();

    //Live chat specific Message data
    Optional<String> token();

    Optional<String> alias();

    Optional<Boolean> newRoom();

    Optional<Boolean> showConnecting();

    @Value.Immutable
    @JsonSerialize(as = ImmutableMessage.File.class)
    @JsonDeserialize(as = ImmutableMessage.File.class)
    interface File {

        @JsonProperty("_id")
        String id();

        String name();

        String type();
    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableMessage.Attachment.class)
    @JsonDeserialize(as = ImmutableMessage.Attachment.class)
    interface Attachment {

        @JsonProperty("ts")
        ZonedDateTime timestamp();

        String title();

        @JsonProperty("title_link")
        String titleLink();

        @JsonProperty("title_link_download")
        boolean titleLinkDownload();

        String type();

        String description();
    }
}
