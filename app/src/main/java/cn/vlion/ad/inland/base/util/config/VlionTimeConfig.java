package cn.vlion.ad.inland.base.util.config;

/* loaded from: classes.dex */
public class VlionTimeConfig {
    public static final float TOLERATE_MAX_TIME = 5.0f;
    public static final float TOLERATE_MIN_TIME = 1.0f;

    public static float getMaxTolerateTime(float f10) {
        return Math.max(f10, 1.0f);
    }
}
