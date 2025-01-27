package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.f;
import java.io.File;

/* loaded from: classes4.dex */
public class l {

    public enum a {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        CANCELED,
        UNKNOWN
    }

    public static f a(String str, String str2, String str3) {
        return new f.a(str, str2, str3).a();
    }

    public static com.sigmob.sdk.downloader.core.breakpoint.c b(String str, String str2, String str3) {
        return a(a(str, str2, str3));
    }

    public static a c(String str, String str2, String str3) {
        return b(a(str, str2, str3));
    }

    public static boolean d(String str, String str2, String str3) {
        return c(a(str, str2, str3));
    }

    public static boolean e(f fVar) {
        return g.j().e().e(fVar) != null;
    }

    public static com.sigmob.sdk.downloader.core.breakpoint.c a(f fVar) {
        com.sigmob.sdk.downloader.core.breakpoint.g a10 = g.j().a();
        com.sigmob.sdk.downloader.core.breakpoint.c h10 = a10.h(a10.b(fVar));
        if (h10 == null) {
            return null;
        }
        return h10.a();
    }

    public static a b(f fVar) {
        a d10 = d(fVar);
        a aVar = a.COMPLETED;
        if (d10 == aVar) {
            return aVar;
        }
        com.sigmob.sdk.downloader.core.dispatcher.b e10 = g.j().e();
        return e10.j(fVar) ? a.PENDING : e10.k(fVar) ? a.RUNNING : e10.h(fVar) ? a.CANCELED : d10;
    }

    public static boolean c(f fVar) {
        return d(fVar) == a.COMPLETED;
    }

    public static a d(f fVar) {
        com.sigmob.sdk.downloader.core.breakpoint.g a10 = g.j().a();
        com.sigmob.sdk.downloader.core.breakpoint.c h10 = a10.h(fVar.b());
        String a11 = fVar.a();
        File c10 = fVar.c();
        File j10 = fVar.j();
        if (h10 != null) {
            if (!h10.l() && h10.i() <= 0) {
                return a.UNKNOWN;
            }
            if (j10 != null && j10.equals(h10.d()) && j10.exists() && h10.j() == h10.i()) {
                return a.COMPLETED;
            }
            if (a11 == null && h10.d() != null && h10.d().exists()) {
                return a.IDLE;
            }
            if (j10 != null && j10.equals(h10.d()) && j10.exists()) {
                return a.IDLE;
            }
        } else {
            if (a10.a() || a10.a(fVar.b())) {
                return a.UNKNOWN;
            }
            if (j10 != null && j10.exists()) {
                return a.COMPLETED;
            }
            String a12 = a10.a(fVar.e());
            if (a12 != null && new File(c10, a12).exists()) {
                return a.COMPLETED;
            }
        }
        return a.UNKNOWN;
    }
}
