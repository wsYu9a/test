package b.d.c.c;

import android.os.AsyncTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class g<Input, Result> {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int MAXIMUM_POOL_SIZE;
    private static final ThreadPoolExecutor SerialExecutor;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    protected c<Input, Result> task;

    /* loaded from: classes2.dex */
    class a extends c<Input, Result> {
        a() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... values) {
            g.this.onProgressUpdate(values);
        }

        @Override // android.os.AsyncTask
        protected Result doInBackground(Input... inputArr) {
            return (Result) g.this.doInBackground(inputArr);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled(Result result) {
            g.this.onCancelled(result);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Result result) {
            g.this.onPostExecute(result);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            g.this.onPreExecute();
        }
    }

    /* loaded from: classes2.dex */
    static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4477a = new AtomicInteger(1);

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            return new Thread(r, "AsyncTask #" + this.f4477a.getAndIncrement());
        }
    }

    /* loaded from: classes2.dex */
    private static abstract class c<Input, Result> extends AsyncTask<Input, Integer, Result> {
        private c() {
        }

        public void a(Integer... values) {
            publishProgress(values);
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        CORE_POOL_SIZE = max;
        int i2 = (availableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE = i2;
        b bVar = new b();
        sThreadFactory = bVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        sPoolWorkQueue = linkedBlockingQueue;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i2, 30L, timeUnit, linkedBlockingQueue, bVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 2, 30L, timeUnit, linkedBlockingQueue, bVar);
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        SerialExecutor = threadPoolExecutor2;
    }

    private c<Input, Result> buildAsyncTask() {
        a aVar = new a();
        this.task = aVar;
        return aVar;
    }

    private void executeOnExecutor(Input... inputs) {
        buildAsyncTask().executeOnExecutor(THREAD_POOL_EXECUTOR, inputs);
    }

    public void cancel(boolean mayInterruptIfRunning) {
        c<Input, Result> cVar = this.task;
        if (cVar != null) {
            cVar.cancel(mayInterruptIfRunning);
        }
    }

    protected abstract Result doInBackground(Input... params);

    public void execute(Input... inputs) {
        try {
            buildAsyncTask().executeOnExecutor(SerialExecutor, inputs);
        } catch (RejectedExecutionException unused) {
        }
    }

    public void executeParallel(Input... inputs) {
        try {
            executeOnExecutor(inputs);
        } catch (RejectedExecutionException unused) {
        }
    }

    public boolean isCancelled() {
        c<Input, Result> cVar = this.task;
        if (cVar != null) {
            return cVar.isCancelled();
        }
        return false;
    }

    public void onCancelled(Result result) {
    }

    protected void onPostExecute(Result result) {
        showLoading(false);
        this.task = null;
    }

    protected void onPreExecute() {
        showLoading(true);
    }

    protected void onProgressUpdate(Integer... values) {
    }

    public void publishProgress(Integer... values) {
        c<Input, Result> cVar = this.task;
        if (cVar != null) {
            cVar.a(values);
        }
    }

    protected abstract void showLoading(boolean show);
}
