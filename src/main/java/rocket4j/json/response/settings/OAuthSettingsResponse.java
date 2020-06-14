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
package rocket4j.json.response.settings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableOAuthSettingsResponse.class)
@JsonDeserialize(as = ImmutableOAuthSettingsResponse.class)
public interface OAuthSettingsResponse {

    List<OAuthService> services();

    @JsonProperty("success")
    boolean successful();


    @Value.Immutable
    @JsonSerialize(as = ImmutableOAuthSettingsResponse.OAuthService.class)
    @JsonDeserialize(as = ImmutableOAuthSettingsResponse.OAuthService.class)
    interface OAuthService {

        @JsonProperty("_id")
        String id();

        Optional<String> name();

        Optional<String> service();

        String clientId();

        boolean custom();

        String buttonLabelText();

        String buttonColor();

        String buttonLabelColor();

        Optional<String> loginStyle();

        Optional<String> serverURL();

        Optional<String> tokenPath();

        Optional<String> identityPath();

        Optional<String> authorizePath();

        Optional<String> scope();

        Optional<String> tokenSentVia();

        Optional<String> identityTokenSentVia();

        Optional<String> usernameField();

        Optional<Boolean> mergeUsers();
    }
}
