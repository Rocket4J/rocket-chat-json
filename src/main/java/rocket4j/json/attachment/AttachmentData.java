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
package rocket4j.json.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableAttachmentData.class)
@JsonDeserialize(as = ImmutableAttachmentData.class)
public interface AttachmentData {

    @JsonProperty("ts")
    ZonedDateTime timestamp();

    //Optionals
    Optional<String> type();

    Optional<String> description();

    Optional<Boolean> collapsed();

    Optional<String> color();

    Optional<String> text();

    @JsonProperty("message_link")
    Optional<String> messageLink();

    //Title stuffs
    String title();

    @JsonProperty("title_link")
    String titleLink();

    @JsonProperty("title_link_download")
    boolean titleLinkDownload();

    //Thumbnail stuffs
    @JsonProperty("thumb_url")
    Optional<String> thumbUrl();

    //Author stuffs
    @JsonProperty("author_name")
    Optional<String> authorName();

    @JsonProperty("author_link")
    Optional<String> authorLink();

    @JsonProperty("author_icon")
    Optional<String> authorIcon();

    //Media stuffs
    @JsonProperty("image_url")
    Optional<String> imageUrl();

    @JsonProperty("audio_url")
    Optional<String> audioUrl();

    @JsonProperty("video_url")
    Optional<String> videoUrl();

    Optional<List<Field>> fields();


    @Value.Immutable
    @JsonSerialize(as = ImmutableAttachmentData.Field.class)
    @JsonDeserialize(as = ImmutableAttachmentData.Field.class)
    interface Field {

        @JsonProperty("short")
        boolean shortField();

        String title();

        String value();
    }
}
