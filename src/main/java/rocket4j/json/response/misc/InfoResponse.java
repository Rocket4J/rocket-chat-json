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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import org.immutables.value.Value;
import rocket4j.json.response.Response;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableInfoResponse.class)
@JsonDeserialize(as = ImmutableInfoResponse.class)
@SuppressWarnings("immutables:subtype")
public interface InfoResponse extends Response {

    Info info();

    @Value.Immutable
    @JsonSerialize(as = ImmutableInfoResponse.Info.class)
    @JsonDeserialize(as = ImmutableInfoResponse.Info.class)
    interface Info {

        String version();

        Build build();

        Commit commit();

        @Value.Immutable
        @JsonSerialize(as = ImmutableInfoResponse.Build.class)
        @JsonDeserialize(as = ImmutableInfoResponse.Build.class)
        interface Build {

            String nodeVersion();

            @JsonProperty("arch")
            String architecture();

            String platform();

            @JsonProperty("cpus")
            int cpuCount();
        }

        @Value.Immutable
        @JsonSerialize(as = ImmutableInfoResponse.Commit.class)
        @JsonDeserialize(as = ImmutableInfoResponse.Commit.class)
        interface Commit {

            String hash();

            @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "EEE MMM d HH:mm:ss yyyy Z"
            )
            ZonedDateTime date();

            String author();

            String subject();

            String tag();

            String branch();
        }
    }
}
