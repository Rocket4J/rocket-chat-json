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
package rocket4j.json.livechat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;
import rocket4j.json.user.BaseUserData;

@Value.Immutable
@JsonSerialize(as = ImmutableInquiryData.class)
@JsonDeserialize(as = ImmutableInquiryData.class)
public interface InquiryData {

    @JsonProperty("_id")
    String id();

    @JsonProperty("rid")
    String roomId();

    String name();

    @JsonProperty("ts")
    ZonedDateTime timestamp();

    String status();

    Optional<String> department();

    Optional<String> message();

    Optional<List<String>> agents();

    //TODO: Figure out what the h*ck "v" stands for
    Optional<BaseUserData> v();

    //TODO: Figure out what the h*ck "t" stands for
    Optional<String> t();

    @JsonProperty("_updatedAt")
    Optional<ZonedDateTime> updatedAt();
}
