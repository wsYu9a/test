package ze;

import android.content.Context;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import hf.f;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: ze.a$a */
    public static class ThreadFactoryC0854a implements ThreadFactory {

        /* renamed from: f */
        public static final AtomicInteger f33772f = new AtomicInteger(1);

        /* renamed from: d */
        public final String f33775d;

        /* renamed from: e */
        public final int f33776e;

        /* renamed from: c */
        public final AtomicInteger f33774c = new AtomicInteger(1);

        /* renamed from: b */
        public final ThreadGroup f33773b = Thread.currentThread().getThreadGroup();

        public ThreadFactoryC0854a(int i10, String str) {
            this.f33776e = i10;
            this.f33775d = str + f33772f.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f33773b, runnable, this.f33775d + this.f33774c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f33776e);
            return thread;
        }
    }

    public static df.a a() {
        return new df.e();
    }

    public static te.b b(Context context, we.a aVar, long j10, int i10) {
        File h10 = h(context);
        if (j10 > 0 || i10 > 0) {
            try {
                return new ve.b(f.d(context), h10, aVar, j10, i10);
            } catch (IOException e10) {
                hf.d.d(e10);
            }
        }
        return new ue.c(f.a(context), h10, aVar);
    }

    public static Executor c(int i10, int i11, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue()), j(i11, "uil-pool-"));
    }

    public static we.a d() {
        return new we.b();
    }

    public static cf.b e(boolean z10) {
        return new cf.a(z10);
    }

    public static ImageDownloader f(Context context) {
        return new BaseImageDownloader(context);
    }

    public static xe.c g(int i10) {
        if (i10 == 0) {
            i10 = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        return new ye.f(i10);
    }

    public static File h(Context context) {
        File b10 = f.b(context, false);
        File file = new File(b10, f.f26697b);
        return (file.exists() || file.mkdir()) ? file : b10;
    }

    public static Executor i() {
        return Executors.newCachedThreadPool(j(5, "uil-pool-d-"));
    }

    public static ThreadFactory j(int i10, String str) {
        return new ThreadFactoryC0854a(i10, str);
    }
}
