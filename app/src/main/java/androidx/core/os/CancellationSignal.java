package androidx.core.os;

import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static void cancel(Object obj) {
            ((android.os.CancellationSignal) obj).cancel();
        }

        @DoNotInline
        public static android.os.CancellationSignal createCancellationSignal() {
            return new android.os.CancellationSignal();
        }
    }

    public interface OnCancelListener {
        void onCancel();
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void cancel() {
        synchronized (this) {
            try {
                if (this.mIsCanceled) {
                    return;
                }
                this.mIsCanceled = true;
                this.mCancelInProgress = true;
                OnCancelListener onCancelListener = this.mOnCancelListener;
                Object obj = this.mCancellationSignalObj;
                if (onCancelListener != null) {
                    try {
                        onCancelListener.onCancel();
                    } catch (Throwable th2) {
                        synchronized (this) {
                            this.mCancelInProgress = false;
                            notifyAll();
                            throw th2;
                        }
                    }
                }
                if (obj != null) {
                    Api16Impl.cancel(obj);
                }
                synchronized (this) {
                    this.mCancelInProgress = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    @Nullable
    public Object getCancellationSignalObject() {
        Object obj;
        synchronized (this) {
            try {
                if (this.mCancellationSignalObj == null) {
                    android.os.CancellationSignal createCancellationSignal = Api16Impl.createCancellationSignal();
                    this.mCancellationSignalObj = createCancellationSignal;
                    if (this.mIsCanceled) {
                        Api16Impl.cancel(createCancellationSignal);
                    }
                }
                obj = this.mCancellationSignalObj;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z10;
        synchronized (this) {
            z10 = this.mIsCanceled;
        }
        return z10;
    }

    public void setOnCancelListener(@Nullable OnCancelListener onCancelListener) {
        synchronized (this) {
            try {
                waitForCancelFinishedLocked();
                if (this.mOnCancelListener == onCancelListener) {
                    return;
                }
                this.mOnCancelListener = onCancelListener;
                if (this.mIsCanceled && onCancelListener != null) {
                    onCancelListener.onCancel();
                }
            } finally {
            }
        }
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
