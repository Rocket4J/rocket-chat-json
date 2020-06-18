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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import org.immutables.value.Value;
import rocket4j.json.room.RoomData;
import rocket4j.json.user.IntegrationUserData;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableIntegrationHistoryData.class)
@JsonDeserialize(as = ImmutableIntegrationHistoryData.class)
public interface IntegrationHistoryData {

    @JsonProperty("_id")
    String id();

    String type();

    String step();

    IntegrationData integration();

    String event();

    @JsonProperty("_createdAt")
    ZonedDateTime createdAt();

    @JsonProperty("_updatedAt")
    ZonedDateTime updatedAt();

    Data data();

    String url();


    @Value.Immutable
    @JsonSerialize(as = ImmutableIntegrationHistoryData.Data.class)
    @JsonDeserialize(as = ImmutableIntegrationHistoryData.Data.class)
    interface Data {

        String token();

        boolean bot();

        ZonedDateTime timestamp();

        @JsonProperty("channel_id")
        String channelId();

        @JsonProperty("channel_name")
        String channelName();

        @JsonProperty("user_id")
        String userId();

        @JsonProperty("user_name")
        String userName();

        IntegrationUserData user();

        RoomData room();
    }
}
