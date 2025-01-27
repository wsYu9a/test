package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.am;
import com.baidu.mobads.sdk.internal.c;
import com.baidu.mobads.sdk.internal.d;
import com.baidu.mobads.sdk.internal.r;
import dalvik.system.DexClassLoader;

@Route(path = c.a.f5683a)
/* loaded from: classes.dex */
public class AdservRemoteLoaderImpl implements r {
    @Override // com.baidu.mobads.sdk.internal.r
    public void startLoadRemotePhp(double d2, am.b bVar) {
        d.a().a(d2, bVar);
    }

    @Override // com.baidu.mobads.sdk.internal.r
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        return d.a().a(str, str2, str3, classLoader);
    }
}
