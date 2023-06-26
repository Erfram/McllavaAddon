package llama.mcllava.utility;

import net.minecraft.nbt.NBTTagCompound;

public class ShakeBuilder {
    public static NBTTagCompound tag = new NBTTagCompound();

    public ShakeBuilder setActive(boolean flag){
        tag.setBoolean("active", flag);
        return this;
    }

    public ShakeBuilder setX(float x){
        tag.setFloat("x", x);
        return this;
    }

    public ShakeBuilder setY(float y){
        tag.setFloat("y", y);
        return this;
    }

    public ShakeBuilder setZ(float z){
        tag.setFloat("z", z);
        return this;
    }

    public ShakeBuilder setAngle(float angle){
        tag.setFloat("angle", angle);
        return this;
    }

    public ShakeBuilder setRotation(float rotation){
        tag.setFloat("rotation", rotation);
        return this;
    }

    public ShakeBuilder setScale(float scale){
        tag.setFloat("scale", scale);
        return this;
    }

    public ShakeBuilder setMinus(float minus){
        tag.setFloat("minus", minus);
        return this;
    }

    public ShakeBuilder setPlus(float plus){
        tag.setFloat("plus", plus);
        return this;
    }

    public ShakeBuilder setAnimationProgress(float animationProgress){
        tag.setFloat("animationProgress", animationProgress);
        return this;
    }
}