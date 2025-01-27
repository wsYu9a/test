package com.opos.mobad.e.a;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    private static volatile boolean f20518a;

    /* renamed from: com.opos.mobad.e.a.n$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f20519a;

        /* renamed from: b */
        final /* synthetic */ String f20520b;

        /* renamed from: c */
        final /* synthetic */ h f20521c;

        AnonymousClass1(String str, String str2, h hVar) {
            str = str;
            str2 = str2;
            hVar = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            boolean a2 = com.opos.mobad.e.a.a.d.a(str, str2);
            h hVar = hVar;
            if (hVar != null) {
                hVar.a(a2, str2);
            }
            com.opos.cmn.an.f.a.b("MatManager", "prepare result:" + a2 + ",destPath:" + str2 + ",costTime" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static f a() {
        return new com.opos.mobad.e.a.a.b();
    }

    public static void a(Context context, String str, String str2, m mVar) {
        if (f20518a) {
            com.opos.cmn.an.f.a.b("MatManager", "already init!");
            return;
        }
        com.opos.cmn.an.f.a.b("MatManager", "init!");
        f20518a = true;
        com.opos.mobad.e.a.a.b.a.a().f20502a = mVar;
        com.opos.mobad.e.a.a.b.a.a().a(context, str, str2, "com.opos.dy.mat");
    }

    public static void a(String str, String str2, h hVar) {
        com.opos.cmn.an.f.a.b("MatManager", "prepare!");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.e.a.n.1

                /* renamed from: a */
                final /* synthetic */ String f20519a;

                /* renamed from: b */
                final /* synthetic */ String f20520b;

                /* renamed from: c */
                final /* synthetic */ h f20521c;

                AnonymousClass1(String str3, String str22, h hVar2) {
                    str = str3;
                    str2 = str22;
                    hVar = hVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean a2 = com.opos.mobad.e.a.a.d.a(str, str2);
                    h hVar2 = hVar;
                    if (hVar2 != null) {
                        hVar2.a(a2, str2);
                    }
                    com.opos.cmn.an.f.a.b("MatManager", "prepare result:" + a2 + ",destPath:" + str2 + ",costTime" + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
            return;
        }
        com.opos.cmn.an.f.a.d("MatManager", "prepare failed!zipPath or destPath is empty!");
        if (hVar2 != null) {
            hVar2.a(false, str22);
        }
    }
}
