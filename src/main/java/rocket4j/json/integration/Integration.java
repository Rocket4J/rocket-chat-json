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
package rocket4j.json.integration;

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
@JsonSerialize(as = ImmutableIntegration.class)
@JsonDeserialize(as = ImmutableIntegration.class)
public interface Integration {

    String name();

    boolean enabled();

    String username();

    List<String> urls();

    @JsonProperty("channel")
    List<String> channels();

    Optional<String> event();

    Optional<String> alias();

    Optional<String> avatar();

    Optional<String> type();

    Optional<String> userId();

    @JsonProperty("_createdAt")
    Optional<ZonedDateTime> createdAt();

    @JsonProperty("_createdBy")
    Optional<MinimalUser> createdBy();

    @JsonProperty("_updatedAt")
    Optional<ZonedDateTime> updatedAt();

    @JsonProperty("_id")
    Optional<String> id();

    Optional<List<String>> triggerWords();

    Optional<String> token();

    Optional<JsonNode> script();

    Optional<Boolean> scriptEnabled();

    Optional<Boolean> impersonateUser();

    Optional<JsonNode> scriptCompiled();

    Optional<JsonNode> scriptError();
}
