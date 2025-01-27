package com.jd.ad.sdk.dl.error;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public enum JADError {
    GW_REQUEST_SLOT_IS_NULL_ERROR(31001, "slot is null"),
    GW_REQUEST_AD_TYPE_IS_NOT_SET_ERROR(31005, "ad type is error"),
    GW_RESPONSE_TOLERATE_TIME_ERROR(31018, "arrive tolerance time when load"),
    RENDER_AD_VIEW_IS_NULL_ERROR(33001, "ad view is null"),
    RENDER_CREATE_AD_VIEW_FAIL_ERROR(33002, "create ad view failed"),
    RENDER_IMAGE_URL_IS_NULL_ERROR(33003, "ad image is null"),
    RENDER_IMAGE_LOAD_FAIL_ERROR(33004, "ad image load failed"),
    RENDER_DYNAMIC_VIEW_INIT_OTHER_ERROR(33013, "other error"),
    RENDER_TOLERATE_TIME_ERROR(33016, "arrive tolerance time when render"),
    RENDER_SPLASH_RESPONSE_TEMPLATE_ID_ERROR(33017, "create splash ad view failed by data"),
    RENDER_FEED_RESPONSE_TEMPLATE_ID_ERROR(33018, "create feed ad view failed by data"),
    RENDER_VIDEO_FAIL_ERROR(330302, "ad video render failed"),
    EXPOSURE_EXCEPTION_ERROR(34001, "exposure error "),
    DEFAULT_ERROR(-1, "error");

    public int code;
    public String message;

    JADError(int i10, String str) {
        this.code = i10;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage(String... strArr) {
        StringBuilder sb2 = new StringBuilder(this.message);
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    sb2.append(":");
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }
}
