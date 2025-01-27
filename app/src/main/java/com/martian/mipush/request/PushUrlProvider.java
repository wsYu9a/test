package com.martian.mipush.request;

import android.text.TextUtils;
import com.martian.libcomm.http.requests.a;
import com.martian.libcomm.http.requests.b;
import com.martian.libmars.c.d;
import com.martian.libmars.d.h;

/* loaded from: classes4.dex */
public class PushUrlProvider extends d {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testpush.taoyuewenhua.net/" : h.F().G0() ? "http://betapush.taoyuewenhua.net/" : "https://push.taoyuewenhua.net/";
    }

    @Override // com.martian.libmars.c.d, com.martian.libcomm.http.requests.c
    public String getRequestUrl(b params, String charset) {
        StringBuilder sb = new StringBuilder(getBaseUrl());
        sb.append(params.getRequestMethod());
        sb.append("?");
        String d2 = a.d(params, charset);
        sb.append(d2);
        if (!TextUtils.isEmpty(d2)) {
            sb.append("&");
        }
        return sb.toString();
    }
}
