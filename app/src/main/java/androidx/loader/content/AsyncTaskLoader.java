package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* renamed from: j */
    static final String f2672j = "AsyncTaskLoader";
    static final boolean k = false;
    private final Executor l;
    volatile AsyncTaskLoader<D>.LoadTask m;
    volatile AsyncTaskLoader<D>.LoadTask n;
    long o;
    long p;
    Handler q;

    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch p = new CountDownLatch(1);
        boolean q;

        LoadTask() {
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void e(D d2) {
            try {
                AsyncTaskLoader.this.g(this, d2);
            } finally {
                this.p.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void f(D d2) {
            try {
                AsyncTaskLoader.this.h(this, d2);
            } finally {
                this.p.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        /* renamed from: l */
        public D a(Void... voidArr) {
            try {
                return (D) AsyncTaskLoader.this.j();
            } catch (OperationCanceledException e2) {
                if (isCancelled()) {
                    return null;
                }
                throw e2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.q = false;
            AsyncTaskLoader.this.i();
        }

        public void waitForLoader() {
            try {
                this.p.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public AsyncTaskLoader(@NonNull Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override // androidx.loader.content.Loader
    protected boolean b() {
        if (this.m == null) {
            return false;
        }
        if (!this.f2677e) {
            this.f2680h = true;
        }
        if (this.n != null) {
            if (this.m.q) {
                this.m.q = false;
                this.q.removeCallbacks(this.m);
            }
            this.m = null;
            return false;
        }
        if (this.m.q) {
            this.m.q = false;
            this.q.removeCallbacks(this.m);
            this.m = null;
            return false;
        }
        boolean cancel = this.m.cancel(false);
        if (cancel) {
            this.n = this.m;
            cancelLoadInBackground();
        }
        this.m = null;
        return cancel;
    }

    @Override // androidx.loader.content.Loader
    protected void c() {
        super.c();
        cancelLoad();
        this.m = new LoadTask();
        i();
    }

    public void cancelLoadInBackground() {
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.m);
            printWriter.print(" waiting=");
            printWriter.println(this.m.q);
        }
        if (this.n != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.n);
            printWriter.print(" waiting=");
            printWriter.println(this.n.q);
        }
        if (this.o != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.o, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.p, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    void g(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        onCanceled(d2);
        if (this.n == loadTask) {
            rollbackContentChanged();
            this.p = SystemClock.uptimeMillis();
            this.n = null;
            deliverCancellation();
            i();
        }
    }

    void h(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        if (this.m != loadTask) {
            g(loadTask, d2);
            return;
        }
        if (isAbandoned()) {
            onCanceled(d2);
            return;
        }
        commitContentChanged();
        this.p = SystemClock.uptimeMillis();
        this.m = null;
        deliverResult(d2);
    }

    void i() {
        if (this.n != null || this.m == null) {
            return;
        }
        if (this.m.q) {
            this.m.q = false;
            this.q.removeCallbacks(this.m);
        }
        if (this.o <= 0 || SystemClock.uptimeMillis() >= this.p + this.o) {
            this.m.executeOnExecutor(this.l, null);
        } else {
            this.m.q = true;
            this.q.postAtTime(this.m, this.p + this.o);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.n != null;
    }

    @Nullable
    protected D j() {
        return loadInBackground();
    }

    @Nullable
    public abstract D loadInBackground();

    public void onCanceled(@Nullable D d2) {
    }

    public void setUpdateThrottle(long j2) {
        this.o = j2;
        if (j2 != 0) {
            this.q = new Handler();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask = this.m;
        if (loadTask != null) {
            loadTask.waitForLoader();
        }
    }

    private AsyncTaskLoader(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        this.p = -10000L;
        this.l = executor;
    }
}
