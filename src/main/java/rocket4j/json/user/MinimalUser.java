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
package rocket4j.json.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableMinimalUser.class)
@JsonDeserialize(as = ImmutableMinimalUser.class)
public interface MinimalUser {

    @JsonProperty("_id")
    String id();

    String username();

    Optional<String> name();

    Optional<String> status();

    Optional<List<Email>> emails();

    @Value.Immutable
    @JsonSerialize(as = ImmutableMinimalUser.Email.class)
    @JsonDeserialize(as = ImmutableMinimalUser.Email.class)
    interface Email {

        String address();

        boolean verified();
    }
}
