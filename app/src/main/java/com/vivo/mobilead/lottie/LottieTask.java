package com.vivo.mobilead.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes4.dex */
public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    private volatile h<T> result;
    private final Set<LottieListener<T>> successListeners;

    /* renamed from: com.vivo.mobilead.lottie.LottieTask$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LottieTask.this.result == null) {
                return;
            }
            h hVar = LottieTask.this.result;
            if (hVar.a() != null) {
                LottieTask.this.notifySuccessListeners(hVar.a());
            } else {
                LottieTask.this.notifyFailureListeners(hVar.b());
            }
        }
    }

    private class a extends FutureTask<h<T>> {
        a(Callable<h<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask.this.setResult(get());
            } catch (InterruptedException | ExecutionException e2) {
                LottieTask.this.setResult(new h(e2));
            }
        }
    }

    public LottieTask(Callable<h<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<h<T>> callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (!z) {
            EXECUTOR.execute(new a(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (Throwable th) {
            setResult(new h<>(th));
        }
    }

    public synchronized void notifyFailureListeners(Throwable th) {
        ArrayList arrayList = new ArrayList(this.failureListeners);
        if (arrayList.isEmpty()) {
            com.vivo.mobilead.lottie.f.d.a("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(th);
        }
    }

    private void notifyListeners() {
        this.handler.post(new Runnable() { // from class: com.vivo.mobilead.lottie.LottieTask.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (LottieTask.this.result == null) {
                    return;
                }
                h hVar = LottieTask.this.result;
                if (hVar.a() != null) {
                    LottieTask.this.notifySuccessListeners(hVar.a());
                } else {
                    LottieTask.this.notifyFailureListeners(hVar.b());
                }
            }
        });
    }

    public synchronized void notifySuccessListeners(T t) {
        Iterator it = new ArrayList(this.successListeners).iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(t);
        }
    }

    public void setResult(h<T> hVar) {
        if (this.result != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.result = hVar;
        notifyListeners();
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        if (this.result != null && this.result.b() != null) {
            lottieListener.onResult(this.result.b());
        }
        this.failureListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        if (this.result != null && this.result.a() != null) {
            lottieListener.onResult(this.result.a());
        }
        this.successListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListeners.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.successListeners.remove(lottieListener);
        return this;
    }
}
