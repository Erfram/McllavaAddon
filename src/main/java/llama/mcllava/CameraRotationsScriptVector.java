package llama.mcllava;

import mchorse.mappet.api.scripts.user.data.ScriptVector;

public class CameraRotationsScriptVector extends ScriptVector {
    public float angle;
    public float rotation;
    public float scale;

    public CameraRotationsScriptVector(float x, float y, float z, float angle, float rotation, float scale) {
        super(x, y, z);
        this.angle = angle;
        this.rotation = rotation;
        this.scale = scale;
    }
}