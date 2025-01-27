package com.martian.libfeedback.request;

import com.martian.libmars.common.ConfigSingleton;
import f9.d;

/* loaded from: classes3.dex */
public class FeedbackTaskUrlProvider extends d {
    @Override // u8.c
    public String getBaseUrl() {
        return ConfigSingleton.D().J0() ? "http://testfeedback.taoyuewenhua.net/" : ConfigSingleton.D().z0() ? "http://betafeedback.taoyuewenhua.net/" : "https://feedback.taoyuewenhua.net/";
    }
}
