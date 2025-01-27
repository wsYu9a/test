package com.opos.mobad.f.a.c;

import android.content.Context;
import android.os.Build;
import com.kuaishou.weapon.p0.g;
import com.opos.mobad.service.f;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Context f20676a;

    /* renamed from: com.opos.mobad.f.a.c.a$a */
    public static final class C0445a {

        /* renamed from: a */
        public final boolean f20679a;

        /* renamed from: b */
        public final int f20680b;

        /* renamed from: c */
        public final String f20681c;

        public C0445a(int i2, String str) {
            this.f20679a = i2 == 0;
            this.f20680b = i2;
            this.f20681c = str;
        }
    }

    public a(Context context) {
        this.f20676a = context.getApplicationContext();
    }

    private boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 29 || !f.b().c() || com.opos.cmn.an.h.d.a.a(context, g.f9318c);
    }

    private boolean b(int i2) {
        if (!com.opos.mobad.service.f.a.a(com.opos.mobad.service.f.a.a().v()) || !c(i2)) {
            return false;
        }
        com.opos.cmn.an.f.a.b("", "checkChannel is child " + i2);
        return true;
    }

    private boolean c(int i2) {
        return i2 == 2 || i2 == 3 || i2 == 6 || i2 == 7 || i2 == 8;
    }

    public C0445a a(int i2) {
        return !f.b().a(i2) ? new C0445a(-5, "") : b(i2) ? new C0445a(-8, "") : new C0445a(0, "");
    }

    public C0445a a(String str) {
        return !f.d() ? new C0445a(-4, "no init.") : !a(this.f20676a) ? new C0445a(-3, "read phone state is required.") : !f.c().a(str) ? new C0445a(DownloadErrorCode.ERROR_TEMP_FILE_IS_DIRECTORY, "inter error request") : new C0445a(0, "");
    }

    public C0445a a(String str, int i2) {
        return !f.c().a(str) ? new C0445a(DownloadErrorCode.ERROR_TEMP_FILE_IS_DIRECTORY, "inter error request") : b(i2) ? new C0445a(-8, "inter error request") : new C0445a(0, "");
    }
}
