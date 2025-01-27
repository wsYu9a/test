package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class HandlerScheduler extends Scheduler {
    private final Handler handler;

    public static final class HandlerWorker extends Scheduler.Worker {
        private volatile boolean disposed;
        private final Handler handler;

        public HandlerWorker(Handler handler) {
            this.handler = handler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.disposed) {
                return Disposables.disposed();
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(runnable));
            Message obtain = Message.obtain(this.handler, scheduledRunnable);
            obtain.obj = this;
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j10));
            if (!this.disposed) {
                return scheduledRunnable;
            }
            this.handler.removeCallbacks(scheduledRunnable);
            return Disposables.disposed();
        }
    }

    public static final class ScheduledRunnable implements Runnable, Disposable {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        public ScheduledRunnable(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.delegate = runnable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacks(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Throwable th2) {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public HandlerScheduler(Handler handler) {
        this.handler = handler;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler);
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(runnable));
        this.handler.postDelayed(scheduledRunnable, timeUnit.toMillis(j10));
        return scheduledRunnable;
    }
}
