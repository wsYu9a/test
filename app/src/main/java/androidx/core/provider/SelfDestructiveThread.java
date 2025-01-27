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
@Deprecated
/* loaded from: classes.dex */
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private final int mDestructAfterMillisec;

    @GuardedBy("mLock")
    private Handler mHandler;
    private final int mPriority;

    @GuardedBy("mLock")
    private HandlerThread mThread;
    private final String mThreadName;
    private final Object mLock = new Object();
    private Handler.Callback mCallback = new Handler.Callback() { // from class: androidx.core.provider.SelfDestructiveThread.1
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                SelfDestructiveThread.this.onDestruction();
                return true;
            }
            if (i10 != 1) {
                return true;
            }
            SelfDestructiveThread.this.onInvokeRunnable((Runnable) message.obj);
            return true;
        }
    };

    @GuardedBy("mLock")
    private int mGeneration = 0;

    /* renamed from: androidx.core.provider.SelfDestructiveThread$1 */
    public class AnonymousClass1 implements Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                SelfDestructiveThread.this.onDestruction();
                return true;
            }
            if (i10 != 1) {
                return true;
            }
            SelfDestructiveThread.this.onInvokeRunnable((Runnable) message.obj);
            return true;
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Callable val$callable;
        final /* synthetic */ Handler val$calleeHandler;
        final /* synthetic */ ReplyCallback val$reply;

        /* renamed from: androidx.core.provider.SelfDestructiveThread$2$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ Object val$result;

            public AnonymousClass1(Object obj) {
                obj = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                replyCallback.onReply(obj);
            }
        }

        public AnonymousClass2(Callable callable, Handler handler, ReplyCallback replyCallback) {
            callable = callable;
            create = handler;
            replyCallback = replyCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = callable.call();
            } catch (Exception unused) {
                obj = null;
            }
            create.post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2.1
                final /* synthetic */ Object val$result;

                public AnonymousClass1(Object obj2) {
                    obj = obj2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    replyCallback.onReply(obj);
                }
            });
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ Callable val$callable;
        final /* synthetic */ Condition val$cond;
        final /* synthetic */ AtomicReference val$holder;
        final /* synthetic */ ReentrantLock val$lock;
        final /* synthetic */ AtomicBoolean val$running;

        public AnonymousClass3(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            atomicReference = atomicReference;
            callable = callable;
            reentrantLock = reentrantLock;
            atomicBoolean = atomicBoolean;
            newCondition = condition;
        }

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
    }

    public interface ReplyCallback<T> {
        void onReply(T t10);
    }

    public SelfDestructiveThread(String str, int i10, int i11) {
        this.mThreadName = str;
        this.mPriority = i10;
        this.mDestructAfterMillisec = i11;
    }

    private void post(Runnable runnable) {
        synchronized (this.mLock) {
            try {
                if (this.mThread == null) {
                    HandlerThread handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
                    this.mThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
                    this.mGeneration++;
                }
                this.mHandler.removeMessages(0);
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage(1, runnable));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        int i10;
        synchronized (this.mLock) {
            i10 = this.mGeneration;
        }
        return i10;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z10;
        synchronized (this.mLock) {
            z10 = this.mThread != null;
        }
        return z10;
    }

    public void onDestruction() {
        synchronized (this.mLock) {
            try {
                if (this.mHandler.hasMessages(1)) {
                    return;
                }
                this.mThread.quit();
                this.mThread = null;
                this.mHandler = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void onInvokeRunnable(Runnable runnable) {
        runnable.run();
        synchronized (this.mLock) {
            this.mHandler.removeMessages(0);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.mDestructAfterMillisec);
        }
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2
            final /* synthetic */ Callable val$callable;
            final /* synthetic */ Handler val$calleeHandler;
            final /* synthetic */ ReplyCallback val$reply;

            /* renamed from: androidx.core.provider.SelfDestructiveThread$2$1 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ Object val$result;

                public AnonymousClass1(Object obj2) {
                    obj = obj2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    replyCallback.onReply(obj);
                }
            }

            public AnonymousClass2(Callable callable2, Handler handler, ReplyCallback replyCallback2) {
                callable = callable2;
                create = handler;
                replyCallback = replyCallback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                try {
                    obj2 = callable.call();
                } catch (Exception unused) {
                    obj2 = null;
                }
                create.post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2.1
                    final /* synthetic */ Object val$result;

                    public AnonymousClass1(Object obj22) {
                        obj = obj22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        replyCallback.onReply(obj);
                    }
                });
            }
        });
    }

    public <T> T postAndWait(Callable<T> callable, int i10) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.3
            final /* synthetic */ Callable val$callable;
            final /* synthetic */ Condition val$cond;
            final /* synthetic */ AtomicReference val$holder;
            final /* synthetic */ ReentrantLock val$lock;
            final /* synthetic */ AtomicBoolean val$running;

            public AnonymousClass3(AtomicReference atomicReference2, Callable callable2, ReentrantLock reentrantLock2, AtomicBoolean atomicBoolean2, Condition newCondition2) {
                atomicReference = atomicReference2;
                callable = callable2;
                reentrantLock = reentrantLock2;
                atomicBoolean = atomicBoolean2;
                newCondition = newCondition2;
            }

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
        reentrantLock2.lock();
        try {
            if (!atomicBoolean2.get()) {
                return (T) atomicReference2.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i10);
            do {
                try {
                    nanos = newCondition2.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean2.get()) {
                    return (T) atomicReference2.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock2.unlock();
        }
    }
}
