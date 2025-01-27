package com.ss.android.downloadlib.g;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    static final a f21641a = new C0643b();

    public static class a {
        private a() {
        }

        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.g.b$b */
    public static class C0643b extends a {
        private C0643b() {
            super();
        }

        @Override // com.ss.android.downloadlib.g.b.a
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }

        public /* synthetic */ C0643b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f21641a.a(asyncTask, tArr);
    }
}
