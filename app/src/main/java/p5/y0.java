package p5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@CanIgnoreReturnValue
@a5.c
@m
/* loaded from: classes2.dex */
public final class y0 {

    /* renamed from: a */
    @CheckForNull
    public String f29834a = null;

    /* renamed from: b */
    @CheckForNull
    public Boolean f29835b = null;

    /* renamed from: c */
    @CheckForNull
    public Integer f29836c = null;

    /* renamed from: d */
    @CheckForNull
    public Thread.UncaughtExceptionHandler f29837d = null;

    /* renamed from: e */
    @CheckForNull
    public ThreadFactory f29838e = null;

    public class a implements ThreadFactory {

        /* renamed from: b */
        public final /* synthetic */ ThreadFactory f29839b;

        /* renamed from: c */
        public final /* synthetic */ String f29840c;

        /* renamed from: d */
        public final /* synthetic */ AtomicLong f29841d;

        /* renamed from: e */
        public final /* synthetic */ Boolean f29842e;

        /* renamed from: f */
        public final /* synthetic */ Integer f29843f;

        /* renamed from: g */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f29844g;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f29839b = threadFactory;
            this.f29840c = str;
            this.f29841d = atomicLong;
            this.f29842e = bool;
            this.f29843f = num;
            this.f29844g = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f29839b.newThread(runnable);
            String str = this.f29840c;
            if (str != null) {
                AtomicLong atomicLong = this.f29841d;
                Objects.requireNonNull(atomicLong);
                newThread.setName(y0.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f29842e;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f29843f;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f29844g;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    public static ThreadFactory c(y0 y0Var) {
        String str = y0Var.f29834a;
        Boolean bool = y0Var.f29835b;
        Integer num = y0Var.f29836c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = y0Var.f29837d;
        ThreadFactory threadFactory = y0Var.f29838e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    @CheckReturnValue
    public ThreadFactory b() {
        return c(this);
    }

    public y0 e(boolean z10) {
        this.f29835b = Boolean.valueOf(z10);
        return this;
    }

    public y0 f(String str) {
        d(str, 0);
        this.f29834a = str;
        return this;
    }

    public y0 g(int i10) {
        b5.u.m(i10 >= 1, "Thread priority (%s) must be >= %s", i10, 1);
        b5.u.m(i10 <= 10, "Thread priority (%s) must be <= %s", i10, 10);
        this.f29836c = Integer.valueOf(i10);
        return this;
    }

    public y0 h(ThreadFactory threadFactory) {
        this.f29838e = (ThreadFactory) b5.u.E(threadFactory);
        return this;
    }

    public y0 i(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f29837d = (Thread.UncaughtExceptionHandler) b5.u.E(uncaughtExceptionHandler);
        return this;
    }
}
