package com.umeng.commonsdk.statistics.common;

import com.shu.priory.config.AdKeys;

/* loaded from: classes4.dex */
public enum DeviceTypeEnum {
    IMEI("imei", "imei"),
    OAID(AdKeys.OAID, AdKeys.OAID),
    ANDROIDID("android_id", "android_id"),
    MAC("mac", "mac"),
    SERIALNO("serial_no", "serial_no"),
    IDFA("idfa", "idfa"),
    DEFAULT("null", "null");

    private String description;
    private String deviceIdType;

    DeviceTypeEnum(String str, String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }
}
