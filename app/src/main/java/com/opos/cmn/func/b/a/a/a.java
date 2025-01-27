package com.opos.cmn.func.b.a.a;

import com.heytap.nearx.okhttp.extension.HeyConfig;
import com.heytap.okhttp.extension.HeyConfig;
import com.opos.cmn.func.b.a.f;

/* loaded from: classes4.dex */
public class a {
    public static f a() {
        f fVar;
        try {
            com.opos.cmn.an.f.a.b("HttpImplUtils", new HeyConfig.Builder().toString());
            fVar = new com.opos.cmn.func.b.a.c();
        } catch (Throwable unused) {
            fVar = null;
        }
        if (fVar == null) {
            try {
                com.opos.cmn.an.f.a.b("HttpImplUtils", new HeyConfig.Builder().toString());
                fVar = new com.opos.cmn.func.b.a.b();
            } catch (Throwable unused2) {
            }
        }
        return fVar == null ? new com.opos.cmn.func.b.a.a() : fVar;
    }
}
