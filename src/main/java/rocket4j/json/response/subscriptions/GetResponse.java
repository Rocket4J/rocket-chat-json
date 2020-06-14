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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;
import rocket4j.json.user.MinimalUser;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableGetResponse.class)
@JsonDeserialize(as = ImmutableGetResponse.class)
public interface GetResponse {

    List<Subscription> update();

    List<Subscription> remove();

    @JsonProperty("success")
    boolean successful();

    @Value.Immutable
    @JsonSerialize(as = ImmutableGetResponse.Subscription.class)
    @JsonDeserialize(as = ImmutableGetResponse.Subscription.class)
    interface Subscription {

        //TODO: Figure out what the h*ck "t" is short for...
        String t();

        @JsonProperty("ts")
        ZonedDateTime timestamp();

        String name();

        // TODO: Figure out what the h*ck "f" is short for...
        @JsonProperty("fname")
        Optional<String> fName();

        String rid();

        @JsonProperty("u")
        MinimalUser user();

        boolean open();

        boolean alert();

        int unread();

        int userMentions();

        int groupMentions();

        @JsonProperty("_updatedAt")
        ZonedDateTime updatedAt();

        @JsonProperty("_id")
        String id();
    }
}
