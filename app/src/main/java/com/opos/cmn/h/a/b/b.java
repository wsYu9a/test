package com.opos.cmn.h.a.b;

import android.content.Context;

/* loaded from: classes4.dex */
public class b {
    public static boolean a(Context context) {
        try {
            return com.opos.cmn.h.a.a.a.a(context);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("WxTools", "isSupportMiniProgram", th);
            return false;
        }
    }

    public static boolean a(Context context, a aVar) {
        try {
            return com.opos.cmn.h.a.a.a.a(context, aVar);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("WxTools", "openMiniProgram", th);
            return false;
        }
    }
}
