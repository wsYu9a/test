package com.vivo.mobilead.util;

import com.kwad.sdk.core.response.model.SdkConfigData;

/* loaded from: classes4.dex */
public final class r {
    public static String a(long j2) {
        if (j2 <= 0) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int i2 = ((int) j2) / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
            if (i2 >= 1) {
                if (i2 < 10) {
                    sb.append("0");
                }
                sb.append(i2);
                sb.append(":");
            }
            long j3 = j2 - (i2 * SdkConfigData.DEFAULT_REQUEST_INTERVAL);
            int i3 = ((int) j3) / 60;
            if (i3 >= 1) {
                if (i3 < 10) {
                    sb.append("0");
                }
                sb.append(i3);
                sb.append(":");
            } else {
                sb.append("00:");
            }
            int i4 = (int) (j3 - (i3 * 60));
            if (i4 >= 1) {
                if (i4 < 10) {
                    sb.append("0");
                }
                sb.append(i4);
            } else {
                sb.append("00");
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
