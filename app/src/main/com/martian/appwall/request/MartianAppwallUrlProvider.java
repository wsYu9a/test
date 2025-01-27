package com.martian.appwall.request;

import com.martian.libmars.common.ConfigSingleton;
import f9.d;

/* loaded from: classes3.dex */
public class MartianAppwallUrlProvider extends d {
    @Override // u8.c
    public String getBaseUrl() {
        return ConfigSingleton.D().J0() ? "http://testappwall.taoyuewenhua.net/" : ConfigSingleton.D().z0() ? "http://betaappwall.taoyuewenhua.net/" : "https://appwall.taoyuewenhua.net/";
    }
}
