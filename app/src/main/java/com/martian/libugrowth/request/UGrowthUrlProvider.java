package com.martian.libugrowth.request;

import com.martian.libmars.common.ConfigSingleton;
import f9.d;
import s8.b;

/* loaded from: classes3.dex */
public class UGrowthUrlProvider extends d {
    @Override // u8.c
    public String getBaseUrl() {
        return ConfigSingleton.D().J0() ? b.f30627w : ConfigSingleton.D().z0() ? b.f30628x : b.f30629y;
    }
}
