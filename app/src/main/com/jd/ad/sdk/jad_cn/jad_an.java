package com.jd.ad.sdk.jad_cn;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public enum jad_an {
    NET_CONNECTION_IS_NULL_ERROR(10001, "http connection is null"),
    NET_HTTP_RESPONSE_IS_NULL_ERROR(10002, "http response is null"),
    NET_HTTP_OTHER_ERROR(10003, "http other error");

    public int jad_an;
    public String jad_bo;

    jad_an(int i10, String str) {
        this.jad_an = i10;
        this.jad_bo = str;
    }

    public String jad_an(String... strArr) {
        StringBuilder sb2 = new StringBuilder(this.jad_bo);
        if (strArr.length > 0) {
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
