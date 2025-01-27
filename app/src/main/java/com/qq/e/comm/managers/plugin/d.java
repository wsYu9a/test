package com.qq.e.comm.managers.plugin;

import com.cdo.oaps.ad.wrapper.BaseWrapper;

/* loaded from: classes4.dex */
class d {

    /* renamed from: a */
    private static final String[] f24036a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", BaseWrapper.ENTER_ID_MESSAGE, "a", "b", "c", "d", com.kwad.sdk.ranger.e.TAG, "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 : bArr) {
            if (i2 < 0) {
                i2 += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f24036a;
            sb.append(strArr[i2 / 16]);
            sb.append(strArr[i2 % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
