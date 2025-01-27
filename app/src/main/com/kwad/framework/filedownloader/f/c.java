package com.kwad.framework.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;

/* loaded from: classes3.dex */
public final class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context als;

    public interface a {
        int P(long j10);
    }

    public interface b {
        com.kwad.framework.filedownloader.a.b bi(String str);
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$c */
    public interface InterfaceC0468c {
        com.kwad.framework.filedownloader.b.a xU();
    }

    public interface d {
        int f(String str, String str2, boolean z10);

        int g(String str, String str2, boolean z10);
    }

    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static boolean a(int i10, String str, boolean z10, boolean z11) {
        if (!z10 && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.xn().s(com.kwad.framework.filedownloader.message.f.a(i10, file, z11));
                return true;
            }
        }
        return false;
    }

    public static void aB(Context context) {
        als = context;
    }

    public static Context xT() {
        return als;
    }

    public static boolean a(int i10, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z10) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.xn().s(com.kwad.framework.filedownloader.message.f.a(i10, cVar.xt(), cVar.getTotal(), z10));
        return true;
    }

    public static boolean a(int i10, long j10, String str, String str2, y yVar) {
        int o10;
        if (str2 == null || str == null || (o10 = yVar.o(str, i10)) == 0) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.xn().s(com.kwad.framework.filedownloader.message.f.a(i10, j10, new PathConflictException(o10, str, str2)));
        return true;
    }
}
