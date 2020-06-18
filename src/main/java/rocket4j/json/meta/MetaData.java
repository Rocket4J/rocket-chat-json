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
package rocket4j.json.meta;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.util.Optional;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableMetaData.class)
@JsonDeserialize(as = ImmutableMetaData.class)
public interface MetaData {

    int revision();

    int version();

    ZonedDateTime created();

    Optional<ZonedDateTime> updated();
}
