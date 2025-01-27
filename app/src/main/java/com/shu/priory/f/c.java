package com.shu.priory.f;

import android.content.Context;
import java.io.File;

/* loaded from: classes3.dex */
public class c {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, com.shu.priory.f.d dVar);
    }

    public interface b {
        void a(String str);

        String[] a();

        void b(String str);

        String c(String str);

        String d(String str);
    }

    /* renamed from: com.shu.priory.f.c$c */
    public interface InterfaceC0556c {
        void a();

        void a(Throwable th2);
    }

    public interface d {
        void a(String str);
    }

    public static void a(Context context, String str) {
        a(context, str, null, null);
    }

    public static void a(Context context, String str, String str2, InterfaceC0556c interfaceC0556c) {
        new com.shu.priory.f.d().a(context, str, str2, interfaceC0556c);
    }
}
