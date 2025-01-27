package com.jd.ad.sdk.jad_zm;

import android.text.TextUtils;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
public class jad_hu implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !Arrays.asList(jad_iv.jad_cp).contains(str);
    }
}
