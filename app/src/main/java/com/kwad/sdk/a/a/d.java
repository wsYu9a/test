package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes3.dex */
public final class d {
    public static String Bm() {
        String Eb = com.kwad.sdk.core.config.d.Eb();
        return TextUtils.isEmpty(Eb) ? "安装" : Eb;
    }

    public static String Bn() {
        String Ec = com.kwad.sdk.core.config.d.Ec();
        return TextUtils.isEmpty(Ec) ? "取消" : Ec;
    }

    public static String F(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.Ea().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.s.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }
}
