package com.alipay.mobilesecuritysdk.constant;

import com.alipay.mobilesecuritysdk.deviceID.c;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.d;

/* loaded from: classes.dex */
public enum LocationNameEnum {
    LOCATE_LATITUDE("t"),
    LOCATE_LONGITUDE(OapsKey.KEY_GRADE),
    LOCATE_CELL_ID("c"),
    LOCATE_LAC(t.f9404d),
    TIME_STAMP("s"),
    LOCATE_WIFI(IAdInterListener.AdReqParam.WIDTH),
    LOCATION_ITEM("locationitem"),
    START_TAG(d.B),
    VERSION("ver"),
    MCC("mcc"),
    MNC("mnc"),
    PHONETYPE("phoneType"),
    CDMA("cdma"),
    BSSID("bssid"),
    SSID("ssid"),
    LEVEL("level"),
    CURRENT("isCurrent"),
    TIME(c.y),
    GSM("gsm");

    private String value;

    LocationNameEnum(String str) {
        setValue(str);
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static LocationNameEnum[] valuesCustom() {
        LocationNameEnum[] valuesCustom = values();
        int length = valuesCustom.length;
        LocationNameEnum[] locationNameEnumArr = new LocationNameEnum[length];
        System.arraycopy(valuesCustom, 0, locationNameEnumArr, 0, length);
        return locationNameEnumArr;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
