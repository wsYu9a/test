package androidx.media3.session;

import android.os.Handler;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
final class SequencedFutureManager {
    private static final String TAG = "SequencedFutureManager";

    @GuardedBy("lock")
    private boolean isReleased;

    @GuardedBy("lock")
    private int nextSequenceNumber;

    @Nullable
    @GuardedBy("lock")
    private Runnable pendingLazyReleaseCallback;

    @Nullable
    @GuardedBy("lock")
    private Handler releaseCallbackHandler;
    private final Object lock = new Object();

    @GuardedBy("lock")
    private final ArrayMap<Integer, SequencedFuture<?>> seqToFutureMap = new ArrayMap<>();

    public static final class SequencedFuture<T> extends AbstractFuture<T> {
        private final T resultWhenClosed;
        private final int sequenceNumber;

        private SequencedFuture(int i10, T t10) {
            this.sequenceNumber = i10;
            this.resultWhenClosed = t10;
        }

        public static <T> SequencedFuture<T> create(int i10, T t10) {
            return new SequencedFuture<>(i10, t10);
        }

        public T getResultWhenClosed() {
            return this.resultWhenClosed;
        }

        public int getSequenceNumber() {
            return this.sequenceNumber;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean set(T t10) {
            return super.set(t10);
        }

        public void setWithTheValueOfResultWhenClosed() {
            set(this.resultWhenClosed);
        }
    }

    public <T> SequencedFuture<T> createSequencedFuture(T t10) {
        SequencedFuture<T> create;
        synchronized (this.lock) {
            try {
                int obtainNextSequenceNumber = obtainNextSequenceNumber();
                create = SequencedFuture.create(obtainNextSequenceNumber, t10);
                if (this.isReleased) {
                    create.setWithTheValueOfResultWhenClosed();
                } else {
                    this.seqToFutureMap.put(Integer.valueOf(obtainNextSequenceNumber), create);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return create;
    }

    public void lazyRelease(long j10, Runnable runnable) {
        synchronized (this.lock) {
            try {
                Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper();
                this.releaseCallbackHandler = createHandlerForCurrentLooper;
                this.pendingLazyReleaseCallback = runnable;
                if (this.seqToFutureMap.isEmpty()) {
                    release();
                } else {
                    createHandlerForCurrentLooper.postDelayed(new Runnable() { // from class: androidx.media3.session.wd
                        public /* synthetic */ wd() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            SequencedFutureManager.this.release();
                        }
                    }, j10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int obtainNextSequenceNumber() {
        int i10;
        synchronized (this.lock) {
            i10 = this.nextSequenceNumber;
            this.nextSequenceNumber = i10 + 1;
        }
        return i10;
    }

    public void release() {
        ArrayList arrayList;
        synchronized (this.lock) {
            try {
                this.isReleased = true;
                arrayList = new ArrayList(this.seqToFutureMap.values());
                this.seqToFutureMap.clear();
                if (this.pendingLazyReleaseCallback != null) {
                    ((Handler) Assertions.checkNotNull(this.releaseCallbackHandler)).post(this.pendingLazyReleaseCallback);
                    this.pendingLazyReleaseCallback = null;
                    this.releaseCallbackHandler = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SequencedFuture) it.next()).setWithTheValueOfResultWhenClosed();
        }
    }

    public <T> void setFutureResult(int i10, T t10) {
        synchronized (this.lock) {
            try {
                SequencedFuture<?> remove = this.seqToFutureMap.remove(Integer.valueOf(i10));
                if (remove != null) {
                    if (remove.getResultWhenClosed().getClass() == t10.getClass()) {
                        remove.set(t10);
                    } else {
                        Log.w(TAG, "Type mismatch, expected " + remove.getResultWhenClosed().getClass() + ", but was " + t10.getClass());
                    }
                }
                if (this.pendingLazyReleaseCallback != null && this.seqToFutureMap.isEmpty()) {
                    release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
