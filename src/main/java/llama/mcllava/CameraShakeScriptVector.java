package llama.mcllava;

import mchorse.mappet.api.scripts.user.data.ScriptVector;

public class CameraShakeScriptVector extends ScriptVector {
    public float angle;
    public float rotation;
    public float scale;
    public float minus;
    public float plus;

    public CameraShakeScriptVector(float x, float y, float z, float angle, float rotation, float scale, float minus, float plus) {
        super(x, y, z);
        this.angle = angle;
        this.rotation = rotation;
        this.scale = scale;
        this.minus = minus;
        this.plus = plus;
    }
}