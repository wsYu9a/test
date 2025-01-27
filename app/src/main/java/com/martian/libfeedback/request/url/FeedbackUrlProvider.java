package com.martian.libfeedback.request.url;

import android.text.TextUtils;
import com.martian.libmars.common.ConfigSingleton;
import f9.d;
import u8.a;
import u8.b;

/* loaded from: classes3.dex */
public class FeedbackUrlProvider extends d {
    @Override // u8.c
    public String getBaseUrl() {
        return ConfigSingleton.D().J0() ? "http://testfeedback.taoyuewenhua.com/" : ConfigSingleton.D().z0() ? "http://betafeedback.taoyuewenhua.com/" : "http://feedback.taoyuewenhua.com/";
    }

    @Override // f9.d, u8.c
    public String getRequestUrl(b bVar, String str) {
        StringBuilder sb2 = new StringBuilder(getBaseUrl());
        sb2.append(bVar.getRequestMethod());
        a.e(bVar, str, false);
        sb2.append("?");
        String d10 = a.d(bVar, str);
        sb2.append(d10);
        if (!TextUtils.isEmpty(d10)) {
            sb2.append("&");
        }
        return sb2.toString();
    }
}
