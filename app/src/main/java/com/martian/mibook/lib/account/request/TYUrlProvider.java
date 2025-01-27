package com.martian.mibook.lib.account.request;

import com.martian.libmars.common.ConfigSingleton;
import f9.d;
import s8.b;

/* loaded from: classes3.dex */
public class TYUrlProvider extends d {
    @Override // u8.c
    public String getBaseUrl() {
        return ConfigSingleton.D().J0() ? "http://testtfbook.taoyuewenhua.net/" : ConfigSingleton.D().z0() ? "http://betatfbook.taoyuewenhua.net/" : b.f30606b ? b.f30614j : b.f30613i;
    }
}
