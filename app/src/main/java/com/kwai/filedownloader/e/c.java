package com.kwai.filedownloader.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwai.filedownloader.exception.PathConflictException;
import com.kwai.filedownloader.y;
import java.io.File;

/* loaded from: classes2.dex */
public final class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context aJp;

    public interface a {
        int ak(long j2);
    }

    public interface b {
        com.kwai.filedownloader.kwai.b q(String str);
    }

    /* renamed from: com.kwai.filedownloader.e.c$c */
    public interface InterfaceC0242c {
        com.kwai.filedownloader.a.a Ja();
    }

    public interface d {
        int j(String str, String str2, boolean z);

        int k(String str, String str2, boolean z);
    }

    public interface e {
        com.kwai.filedownloader.d.a ac(File file);
    }

    public static Context IZ() {
        return aJp;
    }

    public static boolean a(int i2, long j2, String str, String str2, y yVar) {
        int r;
        if (str2 == null || str == null || (r = yVar.r(str, i2)) == 0) {
            return false;
        }
        com.kwai.filedownloader.message.e.Iv().s(com.kwai.filedownloader.message.f.a(i2, j2, new PathConflictException(r, str, str2)));
        return true;
    }

    public static boolean a(int i2, com.kwai.filedownloader.c.c cVar, y yVar, boolean z) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwai.filedownloader.message.e.Iv().s(com.kwai.filedownloader.message.f.a(i2, cVar.IB(), cVar.getTotal(), z));
        return true;
    }

    public static boolean a(int i2, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwai.filedownloader.message.e.Iv().s(com.kwai.filedownloader.message.f.a(i2, file, z2));
                return true;
            }
        }
        return false;
    }

    public static void dt(Context context) {
        aJp = context;
    }
}
