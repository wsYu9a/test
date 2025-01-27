package com.ss.android.downloadlib.lg;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* loaded from: classes4.dex */
public class zx {

    /* renamed from: j */
    static final j f24347j = new C0503zx();

    private static class j {
        private j() {
        }

        public <T> void j(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.lg.zx$zx */
    private static class C0503zx extends j {
        private C0503zx() {
            super();
        }

        @Override // com.ss.android.downloadlib.lg.zx.j
        public <T> void j(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }

        /* synthetic */ C0503zx(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static <T> void j(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f24347j.j(asyncTask, tArr);
    }
}
