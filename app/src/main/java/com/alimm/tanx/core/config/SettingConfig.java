package com.alimm.tanx.core.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SettingConfig implements Serializable {

    @JSONField(serialize = false)
    private static final int MAX_TITLE_SIZE = 28;

    @JSONField(serialize = false)
    private static final int MIN_TITLE_SIZE = 5;
    private String TAG = "SettingConfig";
    private boolean nightSwitch = false;
    private boolean customTitleSizeSwitch = false;
    private boolean customTextSizeDpSwitch = true;
    private int customTitleSize = -1;

    @JSONField(serialize = false)
    public void clearTitleSize() {
        LogUtils.d(this.TAG, "clearTitleSize：");
        this.customTitleSizeSwitch = false;
        this.customTextSizeDpSwitch = true;
        this.customTitleSize = -1;
    }

    public int getCustomTitleSize() {
        return this.customTitleSize;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig getNightConfig() {
        return this;
    }

    public boolean isCustomTextSizeDpSwitch() {
        return this.customTextSizeDpSwitch;
    }

    public boolean isCustomTitleSizeSwitch() {
        LogUtils.d(this.TAG, "isCustomTitleSizeSwitch：" + this.customTitleSizeSwitch);
        return this.customTitleSizeSwitch;
    }

    public boolean isNightSwitch() {
        return this.nightSwitch;
    }

    public void setCustomTextSizeDpSwitch(boolean z10) {
        this.customTextSizeDpSwitch = z10;
    }

    public void setCustomTitleSize(int i10) {
        this.customTitleSize = i10;
    }

    public void setCustomTitleSizeSwitch(boolean z10) {
        this.customTitleSizeSwitch = z10;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setDefaultConfig(String str, String str2) {
        return this;
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setNightConfig(String str, String str2) {
        return this;
    }

    public void setNightSwitch(boolean z10) {
        LogUtils.d(this.TAG, "setNightSwitch：");
        this.nightSwitch = z10;
    }

    @JSONField(serialize = false)
    public void setTitleSize(int i10) {
        LogUtils.d(this.TAG, "setTitleSize：" + i10);
        this.customTitleSizeSwitch = true;
        this.customTextSizeDpSwitch = false;
        this.customTitleSize = i10;
        if (i10 < 5) {
            this.customTitleSize = 5;
        } else if (i10 > 28) {
            this.customTitleSize = 28;
        }
    }

    @JSONField(serialize = false)
    public void setTitleSizeDp(int i10) {
        LogUtils.d(this.TAG, "setTitleSizeDp：" + i10);
        this.customTitleSizeSwitch = true;
        this.customTextSizeDpSwitch = true;
        this.customTitleSize = i10;
        if (i10 < 5) {
            this.customTitleSize = 5;
        } else if (i10 > 28) {
            this.customTitleSize = 28;
        }
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setDefaultConfig() {
        return setDefaultConfig("", "");
    }

    @JSONField(serialize = false)
    @Deprecated
    public SettingConfig setNightConfig() {
        return setNightConfig("", "");
    }
}
