package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: com.ss.android.downloadlib.e.b$1 */
    public static class AnonymousClass1 implements a<Void> {

        /* renamed from: a */
        final /* synthetic */ Runnable f21601a;

        public AnonymousClass1(Runnable runnable) {
            runnable = runnable;
        }

        @Override // com.ss.android.downloadlib.e.b.a
        /* renamed from: a */
        public Void b() {
            runnable.run();
            return null;
        }
    }

    public interface a<T> {
        T b();
    }

    public static <T> T a(boolean z10, String str, @NonNull a<T> aVar) {
        try {
            return aVar.b();
        } catch (Throwable th2) {
            if (th2 instanceof com.ss.android.downloadlib.e.a) {
                throw th2;
            }
            c.a().a(z10, th2, str);
            if (TextUtils.isEmpty(str)) {
                throw th2;
            }
            return null;
        }
    }

    public static <T> T a(a<T> aVar) {
        return (T) a(true, null, aVar);
    }

    public static void a(Runnable runnable) {
        a(new a<Void>() { // from class: com.ss.android.downloadlib.e.b.1

            /* renamed from: a */
            final /* synthetic */ Runnable f21601a;

            public AnonymousClass1(Runnable runnable2) {
                runnable = runnable2;
            }

            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a */
            public Void b() {
                runnable.run();
                return null;
            }
        });
    }
}
