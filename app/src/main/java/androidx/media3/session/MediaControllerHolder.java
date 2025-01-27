package androidx.media3.session;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaController;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class MediaControllerHolder<T extends MediaController> extends AbstractFuture<T> implements MediaController.ConnectionCallback {
    private boolean accepted;

    @Nullable
    private T controller;
    private final Handler handler;

    public MediaControllerHolder(Looper looper) {
        this.handler = new Handler(looper);
    }

    public /* synthetic */ void lambda$setController$0(MediaController mediaController) {
        if (isCancelled()) {
            mediaController.release();
        }
    }

    public /* synthetic */ void lambda$setController$1(Runnable runnable) {
        Util.postOrRun(this.handler, runnable);
    }

    private void maybeSetException() {
        setException(new SecurityException("Session rejected the connection request."));
    }

    private void maybeSetFutureResult() {
        T t10 = this.controller;
        if (t10 == null || !this.accepted) {
            return;
        }
        set(t10);
    }

    @Override // androidx.media3.session.MediaController.ConnectionCallback
    public void onAccepted() {
        this.accepted = true;
        maybeSetFutureResult();
    }

    @Override // androidx.media3.session.MediaController.ConnectionCallback
    public void onRejected() {
        maybeSetException();
    }

    public void setController(T t10) {
        this.controller = t10;
        maybeSetFutureResult();
        addListener(new Runnable() { // from class: androidx.media3.session.m

            /* renamed from: c */
            public final /* synthetic */ MediaController f730c;

            public /* synthetic */ m(MediaController t102) {
                t10 = t102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MediaControllerHolder.this.lambda$setController$0(t10);
            }
        }, new Executor() { // from class: androidx.media3.session.n
            public /* synthetic */ n() {
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                MediaControllerHolder.this.lambda$setController$1(runnable);
            }
        });
    }
}
