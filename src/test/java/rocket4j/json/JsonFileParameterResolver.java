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
package rocket4j.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public final class JsonFileParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(
        final ParameterContext parameterContext,
        final ExtensionContext extensionContext
    ) {
        return parameterContext.isAnnotated(JsonFile.class);
    }

    @Override
    public Object resolveParameter(
        final ParameterContext parameterContext,
        final ExtensionContext extensionContext
    ) {
        final Class<?> type = parameterContext.getParameter().getType();
        if (!String.class.equals(type)) {
            throw new ParameterResolutionException("Unsupported Type: " + type);
        }

        @SuppressWarnings("OptionalGetWithoutIsPresent")
        final String fileName = parameterContext.findAnnotation(JsonFile.class).get().value();

        final Class<?> testClass = extensionContext.getRequiredTestClass();
        final InputStream resource = testClass.getResourceAsStream(fileName);
        final Reader reader = new InputStreamReader(resource, StandardCharsets.UTF_8);
        try (final BufferedReader buffer = new BufferedReader(reader)) {
            return buffer.lines().collect(Collectors.joining());

        } catch (final IOException exception) {
            throw new ParameterResolutionException(fileName, exception);
        }
    }
}
