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
import java.time.ZonedDateTime;
import java.util.List;
import org.immutables.value.Value;
import rocket4j.json.response.Response;

@Value.Immutable
@Value.Enclosing
@JsonSerialize(as = ImmutableStatisticsResponse.class)
@JsonDeserialize(as = ImmutableStatisticsResponse.class)
@SuppressWarnings("immutables:subtype")
public interface StatisticsResponse extends Response {

    Statistics statistics();

    @Value.Immutable
    @JsonSerialize(as = ImmutableStatisticsResponse.Statistics.class)
    @JsonDeserialize(as = ImmutableStatisticsResponse.Statistics.class)
    interface Statistics {

        @JsonProperty("_id")
        String id();

        String uniqueId();

        ZonedDateTime installedAt();

        String version();

        int totalUsers();

        int activeUsers();

        int nonActiveUsers();

        int onlineUsers();

        int awayUsers();

        int offlineUsers();

        int totalRooms();

        int totalChannels();

        int totalPrivateGroups();

        int totalDirect();

        @JsonProperty("totalLivechat")
        int totalLiveChat();

        int totalMessages();

        int totalChannelMessages();

        int totalPrivateGroupMessages();

        int totalDirectMessages();

        @JsonProperty("totalLivechatMessages")
        int totalLiveChatMessages();

        ZonedDateTime lastLogin();

        ZonedDateTime lastMessageSentAt();

        ZonedDateTime lastSeenSubscription();

        @JsonProperty("os")
        OperatingSystem operatingSystem();

        Process process();

        Deploy deploy();

        Migration migration();

        int instanceCount();

        ZonedDateTime createdAt();

        @JsonProperty("_updatedAt")
        ZonedDateTime updatedAt();

        @Value.Immutable
        @JsonSerialize(as = ImmutableStatisticsResponse.OperatingSystem.class)
        @JsonDeserialize(as = ImmutableStatisticsResponse.OperatingSystem.class)
        interface OperatingSystem {

            String type();

            String platform();

            @JsonProperty("arch")
            String architecture();

            String release();

            long uptime();

            @JsonProperty("loadavg")
            List<Float> loadAverage();

            @JsonProperty("totalmem")
            long totalMemory();

            @JsonProperty("freemem")
            long freeMemory();

            List<CPU> cpus();

            @Value.Immutable
            @JsonSerialize(as = ImmutableStatisticsResponse.CPU.class)
            @JsonDeserialize(as = ImmutableStatisticsResponse.CPU.class)
            interface CPU {

                String model();

                int speed();

                Times times();

                @Value.Immutable
                @JsonSerialize(as = ImmutableStatisticsResponse.Times.class)
                @JsonDeserialize(as = ImmutableStatisticsResponse.Times.class)
                interface Times {

                    long user();

                    long nice();

                    long sys();

                    long idle();

                    long irq();
                }
            }
        }

        @Value.Immutable
        @JsonSerialize(as = ImmutableStatisticsResponse.Process.class)
        @JsonDeserialize(as = ImmutableStatisticsResponse.Process.class)
        interface Process {

            String nodeVersion();

            int pid();

            float uptime();
        }

        @Value.Immutable
        @JsonSerialize(as = ImmutableStatisticsResponse.Deploy.class)
        @JsonDeserialize(as = ImmutableStatisticsResponse.Deploy.class)
        interface Deploy {

            String method();

            String platform();
        }

        @Value.Immutable
        @JsonSerialize(as = ImmutableStatisticsResponse.Migration.class)
        @JsonDeserialize(as = ImmutableStatisticsResponse.Migration.class)
        interface Migration {

            @JsonProperty("_id")
            String id();

            int version();

            boolean locked();

            ZonedDateTime lockedAt();

            ZonedDateTime buildAt();
        }
    }
}
