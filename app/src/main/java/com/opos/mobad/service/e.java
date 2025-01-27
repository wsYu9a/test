package com.opos.mobad.service;

import android.content.Context;

/* loaded from: classes4.dex */
public class e {
    public static int a(Context context, String str, String str2) {
        try {
            return b.b(context).getResources().getIdentifier(str, str2, b.b(context).getPackageName());
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ResourcesUtils", "getIdentifierFromHost", e2);
            return 0;
        }
    }
}
