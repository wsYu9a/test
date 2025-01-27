package com.martian.libugrowth.adx.request;

import com.martian.libmars.common.ConfigSingleton;
import f9.d;

/* loaded from: classes3.dex */
public class AdxUrlProvider extends d {
    @Override // u8.c
    public String getBaseUrl() {
        return ConfigSingleton.D().J0() ? "http://testadx.taoyuewenhua.net/" : ConfigSingleton.D().z0() ? "http://betaadx.taoyuewenhua.net/" : "https://adx.taoyuewenhua.net/";
    }
}
