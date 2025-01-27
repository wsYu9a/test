package androidx.core.os;

import android.os.Build;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class CancellationSignal {

    /* renamed from: a */
    private boolean f1812a;

    /* renamed from: b */
    private OnCancelListener f1813b;

    /* renamed from: c */
    private Object f1814c;

    /* renamed from: d */
    private boolean f1815d;

    public interface OnCancelListener {
        void onCancel();
    }

    private void a() {
        while (this.f1815d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void cancel() {
        synchronized (this) {
            if (this.f1812a) {
                return;
            }
            this.f1812a = true;
            this.f1815d = true;
            OnCancelListener onCancelListener = this.f1813b;
            Object obj = this.f1814c;
            if (onCancelListener != null) {
                try {
                    onCancelListener.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f1815d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((android.os.CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f1815d = false;
                notifyAll();
            }
        }
    }

    @Nullable
    public Object getCancellationSignalObject() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f1814c == null) {
                android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                this.f1814c = cancellationSignal;
                if (this.f1812a) {
                    cancellationSignal.cancel();
                }
            }
            obj = this.f1814c;
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.f1812a;
        }
        return z;
    }

    public void setOnCancelListener(@Nullable OnCancelListener onCancelListener) {
        synchronized (this) {
            a();
            if (this.f1813b == onCancelListener) {
                return;
            }
            this.f1813b = onCancelListener;
            if (this.f1812a && onCancelListener != null) {
                onCancelListener.onCancel();
            }
        }
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
