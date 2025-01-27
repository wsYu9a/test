package com.kwad.sdk.kwai.kwai;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class d {
    public static String tf() {
        String uT = com.kwad.sdk.core.config.d.uT();
        return TextUtils.isEmpty(uT) ? "安装" : uT;
    }

    public static String tg() {
        String uU = com.kwad.sdk.core.config.d.uU();
        return TextUtils.isEmpty(uU) ? "取消" : uU;
    }

    public static String z(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.uS().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.r.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }
}
