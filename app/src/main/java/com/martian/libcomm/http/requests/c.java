package com.martian.libcomm.http.requests;

import com.martian.libsupport.k;

/* loaded from: classes2.dex */
public abstract class c {
    public abstract String getBaseUrl();

    public String getRequestUrl(b params, String charset) {
        StringBuilder sb = new StringBuilder(getBaseUrl());
        sb.append(params.getRequestMethod());
        String d2 = a.d(params, charset);
        if (!k.p(d2)) {
            sb.append("?");
            sb.append(d2);
        }
        return sb.toString();
    }
}
