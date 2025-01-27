package com.kwad.components.core.f;

import android.content.Context;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.core.f.a$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ long Js;
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context, long j2) {
            context = context;
            currentTimeMillis = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c(context, currentTimeMillis);
            } catch (Throwable th) {
                b.printStackTraceOnly(th);
            }
        }
    }

    /* renamed from: com.kwad.components.core.f.a$2 */
    final class AnonymousClass2 implements FileFilter {
        AnonymousClass2() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String name = file.getName();
            return name.startsWith("dynamic-") && name.endsWith(".apk");
        }
    }

    /* renamed from: com.kwad.components.core.f.a$a */
    static final class C0174a {
        private static final a Ju = new a((byte) 0);
    }

    private a() {
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    private static File ab(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    public void c(Context context, long j2) {
        File[] listFiles = ab(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.f.a.2
            AnonymousClass2() {
            }

            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                return name.startsWith("dynamic-") && name.endsWith(".apk");
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        long j3 = 0;
        for (File file : listFiles) {
            j3 = Math.max(j3, file.lastModified());
        }
        long min = Math.min(j2, j3);
        for (File file2 : listFiles) {
            if (file2.exists() && file2.lastModified() < min) {
                file2.delete();
            }
        }
    }

    public static a nA() {
        return C0174a.Ju;
    }

    public final void aa(Context context) {
        g.schedule(new Runnable() { // from class: com.kwad.components.core.f.a.1
            final /* synthetic */ long Js;
            final /* synthetic */ Context jN;

            AnonymousClass1(Context context2, long j2) {
                context = context2;
                currentTimeMillis = j2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.c(context, currentTimeMillis);
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }
}
