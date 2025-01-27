package com.martian.mibook.lib.account.request;

import com.martian.libmars.common.ConfigSingleton;
import u8.c;

/* loaded from: classes3.dex */
public class TYBookUrlProvider extends c {
    @Override // u8.c
    public String getBaseUrl() {
        return ConfigSingleton.D().J0() ? "http://testm.taoyuewenhua.com/" : ConfigSingleton.D().z0() ? "http://betam.taoyuewenhua.com/" : "http://m.taoyuewenhua.com/";
    }
}
