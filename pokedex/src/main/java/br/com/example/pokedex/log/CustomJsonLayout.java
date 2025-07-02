package br.com.example.pokedex.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.util.ReadOnlyStringMap;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

@Plugin(name = "CustomJsonLayout", category = "Core", elementType = "layout", printObject = true)
public class CustomJsonLayout extends AbstractStringLayout {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);

    protected CustomJsonLayout(Charset charset) {
        super(charset);
    }

    @PluginFactory
    public static Layout<String> createLayout(
            @PluginAttribute(value = "charset", defaultString = "UTF-8") final Charset charset) {
        return new CustomJsonLayout(charset);
    }

    @Override
    public String toSerializable(LogEvent event) {
        ObjectNode root = MAPPER.createObjectNode();

        // Format timestamp
        root.put("timestamp", SDF.format(new Date(event.getTimeMillis())));
        root.put("level", event.getLevel().toString());
        root.put("logger", event.getLoggerName());
        root.put("thread", event.getThreadName());
        root.put("message", event.getMessage().getFormattedMessage());

        // Include MDC / ThreadContext values
        ReadOnlyStringMap contextData = event.getContextData();
        contextData.forEach((key, value) -> root.put(key, String.valueOf(value)));

        return root.toString() + System.lineSeparator(); // Add newline
    }
}
