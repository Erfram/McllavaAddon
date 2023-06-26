package llama.mcllava;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class KeyBindings {
    public static final Map<UUID, Consumer<String>> keybindingCallBacks = new HashMap<>();
}