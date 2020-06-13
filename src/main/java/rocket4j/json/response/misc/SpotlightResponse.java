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
package rocket4j.json.response.misc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableSpotlightResponse.class)
@JsonDeserialize(as = ImmutableSpotlightResponse.class)
public interface SpotlightResponse {

    List<User> users();

    List<Room> rooms();

    @JsonProperty("success")
    boolean successful();

    @Value.Immutable
    @JsonSerialize(as = ImmutableSpotlightResponse.User.class)
    @JsonDeserialize(as = ImmutableSpotlightResponse.User.class)
    interface User {

        @JsonProperty("_id")
        String id();

        String name();

        String username();

        String status();
    }

    @Value.Immutable
    @JsonSerialize(as = ImmutableSpotlightResponse.Room.class)
    @JsonDeserialize(as = ImmutableSpotlightResponse.Room.class)
    interface Room {

        // TODO
    }
}
