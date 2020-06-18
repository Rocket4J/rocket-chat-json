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
package rocket4j.json.response.subscriptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import org.immutables.value.Value;
import rocket4j.json.meta.MetaData;
import rocket4j.json.response.Response;
import rocket4j.json.user.BaseUserData;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableGetOneResponse.class)
@JsonDeserialize(as = ImmutableGetOneResponse.class)
@SuppressWarnings("immutables:subtype")
public interface GetOneResponse extends Response {

    Subscription subscription();

    @Value.Immutable
    @JsonSerialize(as = ImmutableGetOneResponse.Subscription.class)
    @JsonDeserialize(as = ImmutableGetOneResponse.Subscription.class)
    interface Subscription {

        @JsonProperty("_id")
        String id();

        boolean open();

        boolean alert();

        int unread();

        int userMentions();

        int groupMentions();

        @JsonProperty("ts")
        ZonedDateTime timestamp();

        String rid();

        String name();

        // TODO: Figure out what the h*ck "f" is short for...
        @JsonProperty("fname")
        String fName();

        JsonNode customFields();

        // TODO: Figure out what the h*ck "f" is short for...
        String t();

        @JsonProperty("u")
        BaseUserData user();

        @JsonProperty("ls")
        ZonedDateTime lastSeen();

        @JsonProperty("_updatedAt")
        ZonedDateTime updatedAt();

        List<String> roles();

        boolean disableNotifications();

        String emailNotifications();

        String audioNotificationValue();

        int desktopNotificationDuration();

        String audioNotifications();

        String mobilePushNotifications();

        // TODO: Figure out what the h*ck "f" is short for...
        boolean f();

        MetaData meta();
    }
}
