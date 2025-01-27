package com.martian.libfeedback.request;

import com.martian.libmars.c.d;
import com.martian.libmars.d.h;

/* loaded from: classes2.dex */
public class FeedbackTaskUrlProvider extends d {
    @Override // com.martian.libcomm.http.requests.c
    public String getBaseUrl() {
        return h.F().Q0() ? "http://testfeedback.taoyuewenhua.net/" : h.F().G0() ? "http://betafeedback.taoyuewenhua.net/" : "https://feedback.taoyuewenhua.net/";
    }
}
