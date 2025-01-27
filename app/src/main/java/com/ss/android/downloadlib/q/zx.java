package com.ss.android.downloadlib.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class zx {

    /* renamed from: com.ss.android.downloadlib.q.zx$1 */
    static class AnonymousClass1 implements j<Void> {

        /* renamed from: j */
        final /* synthetic */ Runnable f24352j;

        AnonymousClass1(Runnable runnable) {
            runnable = runnable;
        }

        @Override // com.ss.android.downloadlib.q.zx.j
        /* renamed from: j */
        public Void zx() {
            runnable.run();
            return null;
        }
    }

    public interface j<T> {
        T zx();
    }

    public static <T> T j(boolean z, String str, @NonNull j<T> jVar) {
        try {
            return jVar.zx();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.q.j) {
                throw th;
            }
            i.j().j(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T j(j<T> jVar) {
        return (T) j(true, null, jVar);
    }

    public static void j(Runnable runnable) {
        j(new j<Void>() { // from class: com.ss.android.downloadlib.q.zx.1

            /* renamed from: j */
            final /* synthetic */ Runnable f24352j;

            AnonymousClass1(Runnable runnable2) {
                runnable = runnable2;
            }

            @Override // com.ss.android.downloadlib.q.zx.j
            /* renamed from: j */
            public Void zx() {
                runnable.run();
                return null;
            }
        });
    }
}
