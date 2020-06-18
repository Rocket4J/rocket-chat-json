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
package rocket4j.json.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import org.immutables.value.Value;
import rocket4j.json.user.BaseUserData;

@Value.Immutable
@JsonSerialize(as = ImmutableAppData.class)
@JsonDeserialize(as = ImmutableAppData.class)
public interface AppData {

    @JsonProperty("_id")
    String id();

    String name();

    boolean active();

    String clientId();

    String clientSecret();

    String redirectUri();

    @JsonProperty("_createdAt")
    ZonedDateTime createdAt();

    @JsonProperty("_updatedAt")
    ZonedDateTime updatedAt();

    @JsonProperty("_createdBy")
    BaseUserData createdBy();
}
