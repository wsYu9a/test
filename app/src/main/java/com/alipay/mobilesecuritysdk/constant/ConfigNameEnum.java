package com.alipay.mobilesecuritysdk.constant;

/* loaded from: classes.dex */
public enum ConfigNameEnum {
    MAIN_SWITCH_LUT("mainSwitchLUT"),
    MAIN_SWITCH_STATE("mainSwitchState"),
    MAIN_SWITCH_INTERVAL("mainSwitchInterval"),
    LOCATE_LUT("locateLUT"),
    LOCATE_INTERVAL("locateInterval"),
    APP_LUT("appLUT"),
    APP_INTERVAL("appInterval"),
    PACKAGE_CHANGED("pkgchanged"),
    LOCATION_MAX_LINES("locationMaxLines"),
    CONFIGS("configs"),
    PKG_NAME("n"),
    PUB_KEY_HASH("h"),
    APP_ITEM("appitem"),
    START_TAG(a.H);

    private String value;

    ConfigNameEnum(String str) {
        setValue(str);
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ConfigNameEnum[] valuesCustom() {
        ConfigNameEnum[] valuesCustom = values();
        int length = valuesCustom.length;
        ConfigNameEnum[] configNameEnumArr = new ConfigNameEnum[length];
        System.arraycopy(valuesCustom, 0, configNameEnumArr, 0, length);
        return configNameEnumArr;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
