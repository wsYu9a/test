package com.alimm.tanx.core.ad.ad.template.rendering.splash.shake;

import com.alimm.tanx.core.ad.bean.TemplateConfig;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class ShakeBean implements NotConfused {
    private static final int DEFAULT_SHAKE_COUNT = 3;
    private static final double DEFAULT_SHAKE_INTENSITY_THRESHOLD = 10.0d;
    private static final int DEFAULT_SHAKE_SENSOR_CHECK_INTERVAL = 50;
    private static final int DEFAULT_SHAKE_SENSOR_SHAKE_INTERVAL = 1000;
    private static final int MAX_SHAKE_THRESHOLD = 50;
    private static final int MIN_SHAKE_THRESHOLD = 1;
    private int shakeCount;
    private int shakeSensorCheckInterval;
    private int shakeSensorShakeInterval;
    private double shakeSplash;

    public ShakeBean build(TemplateConfig templateConfig) {
        if (templateConfig != null) {
            try {
                this.shakeSplash = Integer.parseInt(templateConfig.getShakeSplash());
            } catch (Exception unused) {
                this.shakeSplash = DEFAULT_SHAKE_INTENSITY_THRESHOLD;
            }
            try {
                this.shakeSensorCheckInterval = Integer.parseInt(templateConfig.getShakeSensorCheckInterval());
            } catch (Exception unused2) {
                this.shakeSensorCheckInterval = 50;
            }
            try {
                this.shakeSensorShakeInterval = Integer.parseInt(templateConfig.getShakeSensorShakeInterval());
            } catch (Exception unused3) {
                this.shakeSensorShakeInterval = 1000;
            }
            try {
                this.shakeCount = Integer.parseInt(templateConfig.getShakeCount());
            } catch (Exception unused4) {
                this.shakeCount = 3;
            }
            if (this.shakeSplash < 1.0d) {
                this.shakeSplash = DEFAULT_SHAKE_INTENSITY_THRESHOLD;
            }
            if (this.shakeSplash > 50.0d) {
                this.shakeSplash = DEFAULT_SHAKE_INTENSITY_THRESHOLD;
            }
        } else {
            this.shakeSplash = DEFAULT_SHAKE_INTENSITY_THRESHOLD;
            this.shakeSensorCheckInterval = 50;
            this.shakeSensorShakeInterval = 1000;
            this.shakeCount = 3;
        }
        return this;
    }

    public int getShakeCount() {
        return this.shakeCount;
    }

    public int getShakeSensorCheckInterval() {
        return this.shakeSensorCheckInterval;
    }

    public int getShakeSensorShakeInterval() {
        return this.shakeSensorShakeInterval;
    }

    public double getShakeSplash() {
        return this.shakeSplash;
    }

    public void setShakeCount(int i10) {
        this.shakeCount = i10;
    }

    public void setShakeSensorCheckInterval(int i10) {
        this.shakeSensorCheckInterval = i10;
    }

    public void setShakeSensorShakeInterval(int i10) {
        this.shakeSensorShakeInterval = i10;
    }

    public void setShakeSplash(double d10) {
        this.shakeSplash = d10;
    }

    public String toString() {
        return "ShakeBean{shakeSplash=" + this.shakeSplash + ", shakeSensorCheckInterval=" + this.shakeSensorCheckInterval + ", shakeSensorShakeInterval=" + this.shakeSensorShakeInterval + ", shakeCount=" + this.shakeCount + '}';
    }
}
