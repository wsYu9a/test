package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SelfDestructiveThread {

    /* renamed from: a, reason: collision with root package name */
    private static final int f1881a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f1882b = 0;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("mLock")
    private HandlerThread f1884d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("mLock")
    private Handler f1885e;

    /* renamed from: h, reason: collision with root package name */
    private final int f1888h;

    /* renamed from: i, reason: collision with root package name */
    private final int f1889i;

    /* renamed from: j, reason: collision with root package name */
    private final String f1890j;

    /* renamed from: c, reason: collision with root package name */
    private final Object f1883c = new Object();

    /* renamed from: g, reason: collision with root package name */
    private Handler.Callback f1887g = new Handler.Callback() { // from class: androidx.core.provider.SelfDestructiveThread.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                SelfDestructiveThread.this.a();
                return true;
            }
            if (i2 != 1) {
                return true;
            }
            SelfDestructiveThread.this.b((Runnable) message.obj);
            return true;
        }
    };

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f1886f = 0;

    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(String str, int i2, int i3) {
        this.f1890j = str;
        this.f1889i = i2;
        this.f1888h = i3;
    }

    private void c(Runnable runnable) {
        synchronized (this.f1883c) {
            if (this.f1884d == null) {
                HandlerThread handlerThread = new HandlerThread(this.f1890j, this.f1889i);
                this.f1884d = handlerThread;
                handlerThread.start();
                this.f1885e = new Handler(this.f1884d.getLooper(), this.f1887g);
                this.f1886f++;
            }
            this.f1885e.removeMessages(0);
            Handler handler = this.f1885e;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    void a() {
        synchronized (this.f1883c) {
            if (this.f1885e.hasMessages(1)) {
                return;
            }
            this.f1884d.quit();
            this.f1884d = null;
            this.f1885e = null;
        }
    }

    void b(Runnable runnable) {
        runnable.run();
        synchronized (this.f1883c) {
            this.f1885e.removeMessages(0);
            Handler handler = this.f1885e;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f1888h);
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        int i2;
        synchronized (this.f1883c) {
            i2 = this.f1886f;
        }
        return i2;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z;
        synchronized (this.f1883c) {
            z = this.f1884d != null;
        }
        return z;
    }

    public <T> void postAndReply(final Callable<T> callable, final ReplyCallback<T> replyCallback) {
        final Handler handler = new Handler();
        c(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2
            @Override // java.lang.Runnable
            public void run() {
                final Object obj;
                try {
                    obj = callable.call();
                } catch (Exception unused) {
                    obj = null;
                }
                handler.post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        replyCallback.onReply(obj);
                    }
                });
            }
        });
    }

    public <T> T postAndWait(final Callable<T> callable, int i2) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        c(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i2);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
