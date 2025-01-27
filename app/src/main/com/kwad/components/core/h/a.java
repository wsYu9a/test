package com.kwad.components.core.h;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.kwad.components.core.h.a$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ long NU;
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context, long j10) {
            context = context;
            currentTimeMillis = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.a(context, currentTimeMillis);
            } catch (Throwable th2) {
                c.printStackTraceOnly(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.h.a$2 */
    public class AnonymousClass2 implements FileFilter {
        public AnonymousClass2() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String name = file.getName();
            return name.startsWith("dynamic-") && name.endsWith(".apk");
        }
    }

    /* renamed from: com.kwad.components.core.h.a$a */
    public static final class C0430a {
        private static final a NW = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    private static File an(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    public static a pt() {
        return C0430a.NW;
    }

    public final void am(Context context) {
        h.schedule(new Runnable() { // from class: com.kwad.components.core.h.a.1
            final /* synthetic */ long NU;
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2, long j10) {
                context = context2;
                currentTimeMillis = j10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(context, currentTimeMillis);
                } catch (Throwable th2) {
                    c.printStackTraceOnly(th2);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    private a() {
    }

    public void a(Context context, long j10) {
        File[] listFiles = an(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.h.a.2
            public AnonymousClass2() {
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
        long j11 = 0;
        for (File file : listFiles) {
            j11 = Math.max(j11, file.lastModified());
        }
        long min = Math.min(j10, j11);
        for (File file2 : listFiles) {
            if (file2.exists() && file2.lastModified() < min) {
                file2.delete();
            }
        }
    }
}
