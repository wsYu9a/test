package com.martian.appwall.request;

import com.martian.libmars.common.ConfigSingleton;
import f9.d;

/* loaded from: classes3.dex */
public class MartianApUrlProvider extends d {
    @Override // u8.c
    public String getBaseUrl() {
        return ConfigSingleton.D().J0() ? "http://testap.taoyuewenhua.com/" : ConfigSingleton.D().z0() ? "http://betaap.taoyuewenhua.com/" : "https://ap.taoyuewenhua.com/";
    }
}
