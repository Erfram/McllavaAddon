package llama.mcllava;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class LlavaMethods {
    public static final Map<UUID, Consumer<String>> clipboardCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<Number>> perspectiveCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<double[]>> mousePositionCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<String>> systemTimeCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<Boolean>> getSettingCameraCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<CameraShakeScriptVector>> cameraShakeScriptVectorCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<CameraRotationsScriptVector>> cameraRotationsScripVectorCallBacks = new HashMap<>();
}
