package com.czhj.sdk.common.ThreadPool;

import android.os.AsyncTask;
import com.czhj.sdk.common.utils.Preconditions;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class AsyncTasks {

    /* renamed from: a */
    public static Executor f8457a;

    static {
        a();
    }

    public static void a() {
        f8457a = AsyncTask.THREAD_POOL_EXECUTOR;
    }

    @SafeVarargs
    public static <P> void safeExecuteOnExecutor(AsyncTask<P, ?, ?> asyncTask, P... pArr) {
        Preconditions.NoThrow.checkNotNull(asyncTask, "Unable to execute null AsyncTask.");
        Preconditions.NoThrow.checkUiThread("AsyncTask must be executed on the main thread");
        asyncTask.executeOnExecutor(f8457a, pArr);
    }
}
