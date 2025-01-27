package com.martian.libfeedback.request.url;

import android.text.TextUtils;
import com.martian.libcomm.http.requests.a;
import com.martian.libcomm.http.requests.b;
import com.martian.libmars.c.d;
import com.martian.libmars.d.h;

/* loaded from: classes2.dex */
public class FeedbackUrlProvider extends d {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testfeedback.taoyuewenhua.com/" : h.F().G0() ? "http://betafeedback.taoyuewenhua.com/" : "http://feedback.taoyuewenhua.com/";
    }

    @Override // com.martian.libmars.c.d, com.martian.libcomm.http.requests.c
    public String getRequestUrl(b params, String charset) {
        StringBuilder sb = new StringBuilder(getBaseUrl());
        sb.append(params.getRequestMethod());
        a.e(params, charset, false);
        sb.append("?");
        String d2 = a.d(params, charset);
        sb.append(d2);
        if (!TextUtils.isEmpty(d2)) {
            sb.append("&");
        }
        return sb.toString();
    }
}
