package com.opos.mobad.i;

import android.content.Context;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static volatile d f21016a;

    /* renamed from: b */
    private static final byte[] f21017b = new byte[0];

    public static b a(Context context, a aVar) {
        b bVar;
        if (context != null && aVar != null) {
            a();
            try {
                bVar = f21016a.a(context.getApplicationContext(), aVar);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadTool", "download", (Throwable) e2);
            }
            com.opos.cmn.an.f.a.b("DownloadTool", "download request=", aVar, "response=", bVar);
            return bVar;
        }
        bVar = null;
        com.opos.cmn.an.f.a.b("DownloadTool", "download request=", aVar, "response=", bVar);
        return bVar;
    }

    private static void a() {
        if (f21016a == null) {
            synchronized (f21017b) {
                if (f21016a == null) {
                    f21016a = new com.opos.mobad.i.a.a();
                }
            }
        }
    }
}
