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
package rocket4j.json.response.customsounds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import org.immutables.value.Value;
import rocket4j.json.pagination.PageData;
import rocket4j.json.response.Response;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableListResponse.class)
@JsonDeserialize(as = ImmutableListResponse.class)
@SuppressWarnings("immutables:subtype")
public interface ListResponse extends Response, PageData {

    List<Sound> sounds();

    @Value.Immutable
    @JsonSerialize(as = ImmutableListResponse.Sound.class)
    @JsonDeserialize(as = ImmutableListResponse.Sound.class)
    interface Sound {

        @JsonProperty("_id")
        String id();

        String name();

        String extension();

        @JsonProperty("_updatedAt")
        ZonedDateTime updatedAt();
    }
}
