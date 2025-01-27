package com.martian.libmars.c;

import android.text.TextUtils;
import com.martian.libmars.d.h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes2.dex */
public abstract class d extends com.martian.libcomm.http.requests.c {
    @Override // com.martian.libcomm.http.requests.c
    public String getRequestUrl(com.martian.libcomm.http.requests.b params, String charset) {
        StringBuilder sb = new StringBuilder(getBaseUrl());
        sb.append(params.getRequestMethod());
        String d2 = com.martian.libsupport.b.d(com.martian.libcomm.http.requests.a.e(params, charset, false), h.F().f().f9880b);
        try {
            d2 = URLEncoder.encode(d2, charset);
        } catch (UnsupportedEncodingException unused) {
        }
        sb.append("?");
        String d3 = com.martian.libcomm.http.requests.a.d(params, charset);
        sb.append(d3);
        if (!TextUtils.isEmpty(d3)) {
            sb.append("&");
        }
        sb.append("sign=");
        sb.append(d2);
        return sb.toString();
    }
}
