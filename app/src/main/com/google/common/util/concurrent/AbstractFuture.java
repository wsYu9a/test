package com.google.common.util.concurrent;

import b5.a0;
import b5.u;
import b5.y;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import p5.c0;
import p5.j0;
import p5.k0;
import p5.l0;
import sun.misc.Unsafe;

@a5.b(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
@p5.m
/* loaded from: classes2.dex */
public abstract class AbstractFuture<V> extends q5.a implements c0<V> {
    private static final b ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log;

    @CheckForNull
    private volatile d listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile k waiters;

    public static final class Failure {

        /* renamed from: b */
        public static final Failure f10240b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            public AnonymousClass1(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a */
        public final Throwable f10241a;

        /* renamed from: com.google.common.util.concurrent.AbstractFuture$Failure$1 */
        public class AnonymousClass1 extends Throwable {
            public AnonymousClass1(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public Failure(Throwable th2) {
            this.f10241a = (Throwable) u.E(th2);
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, @CheckForNull d dVar, d dVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, @CheckForNull k kVar, @CheckForNull k kVar2);

        public abstract d d(AbstractFuture<?> abstractFuture, d dVar);

        public abstract k e(AbstractFuture<?> abstractFuture, k kVar);

        public abstract void f(k kVar, @CheckForNull k kVar2);

        public abstract void g(k kVar, Thread thread);

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static final class c {

        /* renamed from: c */
        @CheckForNull
        public static final c f10242c;

        /* renamed from: d */
        @CheckForNull
        public static final c f10243d;

        /* renamed from: a */
        public final boolean f10244a;

        /* renamed from: b */
        @CheckForNull
        public final Throwable f10245b;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                f10243d = null;
                f10242c = null;
            } else {
                f10243d = new c(false, null);
                f10242c = new c(true, null);
            }
        }

        public c(boolean z10, @CheckForNull Throwable th2) {
            this.f10244a = z10;
            this.f10245b = th2;
        }
    }

    public static final class e extends b {

        /* renamed from: a */
        public final AtomicReferenceFieldUpdater<k, Thread> f10250a;

        /* renamed from: b */
        public final AtomicReferenceFieldUpdater<k, k> f10251b;

        /* renamed from: c */
        public final AtomicReferenceFieldUpdater<AbstractFuture, k> f10252c;

        /* renamed from: d */
        public final AtomicReferenceFieldUpdater<AbstractFuture, d> f10253d;

        /* renamed from: e */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f10254e;

        public e(AtomicReferenceFieldUpdater<k, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<k, k> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, k> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f10250a = atomicReferenceFieldUpdater;
            this.f10251b = atomicReferenceFieldUpdater2;
            this.f10252c = atomicReferenceFieldUpdater3;
            this.f10253d = atomicReferenceFieldUpdater4;
            this.f10254e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull d dVar, d dVar2) {
            return k.a.a(this.f10253d, abstractFuture, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return k.a.a(this.f10254e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull k kVar, @CheckForNull k kVar2) {
            return k.a.a(this.f10252c, abstractFuture, kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            return this.f10253d.getAndSet(abstractFuture, dVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k e(AbstractFuture<?> abstractFuture, k kVar) {
            return this.f10252c.getAndSet(abstractFuture, kVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, @CheckForNull k kVar2) {
            this.f10251b.lazySet(kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(k kVar, Thread thread) {
            this.f10250a.lazySet(kVar, thread);
        }
    }

    public static final class f<V> implements Runnable {

        /* renamed from: b */
        public final AbstractFuture<V> f10255b;

        /* renamed from: c */
        public final c0<? extends V> f10256c;

        public f(AbstractFuture<V> abstractFuture, c0<? extends V> c0Var) {
            this.f10255b = abstractFuture;
            this.f10256c = c0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.f10255b).value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.b(this.f10255b, this, AbstractFuture.j(this.f10256c))) {
                AbstractFuture.g(this.f10255b);
            }
        }
    }

    public static final class g extends b {
        public g() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull d dVar, d dVar2) {
            synchronized (abstractFuture) {
                try {
                    if (((AbstractFuture) abstractFuture).listeners != dVar) {
                        return false;
                    }
                    ((AbstractFuture) abstractFuture).listeners = dVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (((AbstractFuture) abstractFuture).value != obj) {
                        return false;
                    }
                    ((AbstractFuture) abstractFuture).value = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull k kVar, @CheckForNull k kVar2) {
            synchronized (abstractFuture) {
                try {
                    if (((AbstractFuture) abstractFuture).waiters != kVar) {
                        return false;
                    }
                    ((AbstractFuture) abstractFuture).waiters = kVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            d dVar2;
            synchronized (abstractFuture) {
                try {
                    dVar2 = ((AbstractFuture) abstractFuture).listeners;
                    if (dVar2 != dVar) {
                        ((AbstractFuture) abstractFuture).listeners = dVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k e(AbstractFuture<?> abstractFuture, k kVar) {
            k kVar2;
            synchronized (abstractFuture) {
                try {
                    kVar2 = ((AbstractFuture) abstractFuture).waiters;
                    if (kVar2 != kVar) {
                        ((AbstractFuture) abstractFuture).waiters = kVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, @CheckForNull k kVar2) {
            kVar.f10265b = kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(k kVar, Thread thread) {
            kVar.f10264a = thread;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public interface h<V> extends c0<V> {
    }

    public static abstract class i<V> extends AbstractFuture<V> implements h<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, p5.c0
        public void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public boolean cancel(boolean z10) {
            return super.cancel(z10);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        @l0
        public V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        @l0
        public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j10, timeUnit);
        }
    }

    public static final class j extends b {

        /* renamed from: a */
        public static final Unsafe f10257a;

        /* renamed from: b */
        public static final long f10258b;

        /* renamed from: c */
        public static final long f10259c;

        /* renamed from: d */
        public static final long f10260d;

        /* renamed from: e */
        public static final long f10261e;

        /* renamed from: f */
        public static final long f10262f;

        public class a implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new a());
                }
                try {
                    f10259c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                    f10258b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                    f10260d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
                    f10261e = unsafe.objectFieldOffset(k.class.getDeclaredField("a"));
                    f10262f = unsafe.objectFieldOffset(k.class.getDeclaredField("b"));
                    f10257a = unsafe;
                } catch (Exception e10) {
                    a0.w(e10);
                    throw new RuntimeException(e10);
                }
            } catch (PrivilegedActionException e11) {
                throw new RuntimeException("Could not initialize intrinsics", e11.getCause());
            }
        }

        public j() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull d dVar, d dVar2) {
            return p5.a.a(f10257a, abstractFuture, f10258b, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return p5.a.a(f10257a, abstractFuture, f10260d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull k kVar, @CheckForNull k kVar2) {
            return p5.a.a(f10257a, abstractFuture, f10259c, kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public d d(AbstractFuture<?> abstractFuture, d dVar) {
            d dVar2;
            do {
                dVar2 = ((AbstractFuture) abstractFuture).listeners;
                if (dVar == dVar2) {
                    return dVar2;
                }
            } while (!a(abstractFuture, dVar2, dVar));
            return dVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public k e(AbstractFuture<?> abstractFuture, k kVar) {
            k kVar2;
            do {
                kVar2 = ((AbstractFuture) abstractFuture).waiters;
                if (kVar == kVar2) {
                    return kVar2;
                }
            } while (!c(abstractFuture, kVar2, kVar));
            return kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void f(k kVar, @CheckForNull k kVar2) {
            f10257a.putObject(kVar, f10262f, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void g(k kVar, Thread thread) {
            f10257a.putObject(kVar, f10261e, thread);
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    public static final class k {

        /* renamed from: c */
        public static final k f10263c = new k(false);

        /* renamed from: a */
        @CheckForNull
        public volatile Thread f10264a;

        /* renamed from: b */
        @CheckForNull
        public volatile k f10265b;

        public k(boolean z10) {
        }

        public void a(@CheckForNull k kVar) {
            AbstractFuture.ATOMIC_HELPER.f(this, kVar);
        }

        public void b() {
            Thread thread = this.f10264a;
            if (thread != null) {
                this.f10264a = null;
                LockSupport.unpark(thread);
            }
        }

        public k() {
            AbstractFuture.ATOMIC_HELPER.g(this, Thread.currentThread());
        }
    }

    static {
        boolean z10;
        b gVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        GENERATE_CANCELLATION_CAUSES = z10;
        log = Logger.getLogger(AbstractFuture.class.getName());
        Throwable th2 = null;
        try {
            gVar = new j();
            th = null;
        } catch (Throwable th3) {
            th = th3;
            try {
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, k.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            } catch (Throwable th4) {
                gVar = new g();
                th2 = th4;
            }
        }
        ATOMIC_HELPER = gVar;
        if (th2 != null) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
        NULL = new Object();
    }

    public static CancellationException e(String str, @CheckForNull Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    public static void g(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.l();
            abstractFuture.afterDone();
            d f10 = abstractFuture.f(dVar);
            while (f10 != null) {
                dVar = f10.f10249c;
                Runnable runnable = f10.f10247a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof f) {
                    f fVar = (f) runnable2;
                    abstractFuture = fVar.f10255b;
                    if (((AbstractFuture) abstractFuture).value == fVar) {
                        if (ATOMIC_HELPER.b(abstractFuture, fVar, j(fVar.f10256c))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = f10.f10248b;
                    Objects.requireNonNull(executor);
                    h(runnable2, executor);
                }
                f10 = dVar;
            }
            return;
        }
    }

    public static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = log;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.log(level, sb2.toString(), (Throwable) e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object j(c0<?> c0Var) {
        Throwable a10;
        if (c0Var instanceof h) {
            Object obj = ((AbstractFuture) c0Var).value;
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f10244a) {
                    obj = cVar.f10245b != null ? new c(false, cVar.f10245b) : c.f10243d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        }
        if ((c0Var instanceof q5.a) && (a10 = q5.b.a((q5.a) c0Var)) != null) {
            return new Failure(a10);
        }
        boolean isCancelled = c0Var.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            c cVar2 = c.f10243d;
            Objects.requireNonNull(cVar2);
            return cVar2;
        }
        try {
            Object k10 = k(c0Var);
            if (!isCancelled) {
                return k10 == null ? NULL : k10;
            }
            String valueOf = String.valueOf(c0Var);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 84);
            sb2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb2.append(valueOf);
            return new c(false, new IllegalArgumentException(sb2.toString()));
        } catch (CancellationException e10) {
            if (isCancelled) {
                return new c(false, e10);
            }
            String valueOf2 = String.valueOf(c0Var);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 77);
            sb3.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
            sb3.append(valueOf2);
            return new Failure(new IllegalArgumentException(sb3.toString(), e10));
        } catch (ExecutionException e11) {
            if (!isCancelled) {
                return new Failure(e11.getCause());
            }
            String valueOf3 = String.valueOf(c0Var);
            StringBuilder sb4 = new StringBuilder(valueOf3.length() + 84);
            sb4.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb4.append(valueOf3);
            return new c(false, new IllegalArgumentException(sb4.toString(), e11));
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

    @l0
    public static <V> V k(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    public final void a(StringBuilder sb2) {
        try {
            Object k10 = k(this);
            sb2.append("SUCCESS, result=[");
            c(sb2, k10);
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    @Override // p5.c0
    public void addListener(Runnable runnable, Executor executor) {
        d dVar;
        u.F(runnable, "Runnable was null.");
        u.F(executor, "Executor was null.");
        if (!isDone() && (dVar = this.listeners) != d.f10246d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f10249c = dVar;
                if (ATOMIC_HELPER.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.listeners;
                }
            } while (dVar != d.f10246d);
        }
        h(runnable, executor);
    }

    @a5.a
    @ForOverride
    public void afterDone() {
    }

    public final void b(StringBuilder sb2) {
        String sb3;
        int length = sb2.length();
        sb2.append("PENDING");
        Object obj = this.value;
        if (obj instanceof f) {
            sb2.append(", setFuture=[");
            d(sb2, ((f) obj).f10256c);
            sb2.append("]");
        } else {
            try {
                sb3 = y.c(pendingToString());
            } catch (RuntimeException | StackOverflowError e10) {
                String valueOf = String.valueOf(e10.getClass());
                StringBuilder sb4 = new StringBuilder(valueOf.length() + 38);
                sb4.append("Exception thrown from implementation: ");
                sb4.append(valueOf);
                sb3 = sb4.toString();
            }
            if (sb3 != null) {
                sb2.append(", info=[");
                sb2.append(sb3);
                sb2.append("]");
            }
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            a(sb2);
        }
    }

    public final void c(StringBuilder sb2, @CheckForNull Object obj) {
        if (obj == null) {
            sb2.append("null");
        } else {
            if (obj == this) {
                sb2.append("this future");
                return;
            }
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean z10) {
        c cVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cVar = new c(z10, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z10 ? c.f10242c : c.f10243d;
            Objects.requireNonNull(cVar);
        }
        boolean z11 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (ATOMIC_HELPER.b(abstractFuture, obj, cVar)) {
                if (z10) {
                    abstractFuture.interruptTask();
                }
                g(abstractFuture);
                if (!(obj instanceof f)) {
                    return true;
                }
                c0<? extends V> c0Var = ((f) obj).f10256c;
                if (!(c0Var instanceof h)) {
                    c0Var.cancel(z10);
                    return true;
                }
                abstractFuture = (AbstractFuture) c0Var;
                obj = abstractFuture.value;
                if (!(obj == null) && !(obj instanceof f)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof f)) {
                    return z11;
                }
            }
        }
    }

    public final void d(StringBuilder sb2, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb2.append("this future");
            } else {
                sb2.append(obj);
            }
        } catch (RuntimeException e10) {
            e = e10;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        } catch (StackOverflowError e11) {
            e = e11;
            sb2.append("Exception thrown from implementation: ");
            sb2.append(e.getClass());
        }
    }

    @CheckForNull
    public final d f(@CheckForNull d dVar) {
        d dVar2 = dVar;
        d d10 = ATOMIC_HELPER.d(this, d.f10246d);
        while (d10 != null) {
            d dVar3 = d10.f10249c;
            d10.f10249c = dVar2;
            dVar2 = d10;
            d10 = dVar3;
        }
        return dVar2;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    @l0
    public V get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof f))) {
            return i(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            k kVar = this.waiters;
            if (kVar != k.f10263c) {
                k kVar2 = new k();
                do {
                    kVar2.a(kVar);
                    if (ATOMIC_HELPER.c(this, kVar, kVar2)) {
                        do {
                            k0.a(this, nanos);
                            if (Thread.interrupted()) {
                                m(kVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return i(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        m(kVar2);
                    } else {
                        kVar = this.waiters;
                    }
                } while (kVar != k.f10263c);
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return i(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.value;
            if ((obj4 != null) && (!(obj4 instanceof f))) {
                return i(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String abstractFuture = toString();
        String obj5 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj5.toLowerCase(locale);
        String lowerCase2 = timeUnit.toString().toLowerCase(locale);
        StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
        sb2.append("Waited ");
        sb2.append(j10);
        sb2.append(" ");
        sb2.append(lowerCase2);
        String sb3 = sb2.toString();
        if (nanos + 1000 < 0) {
            String concat = String.valueOf(sb3).concat(" (plus ");
            long j11 = -nanos;
            long convert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(convert);
            boolean z10 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String valueOf = String.valueOf(concat);
                StringBuilder sb4 = new StringBuilder(valueOf.length() + 21 + String.valueOf(lowerCase).length());
                sb4.append(valueOf);
                sb4.append(convert);
                sb4.append(" ");
                sb4.append(lowerCase);
                String sb5 = sb4.toString();
                if (z10) {
                    sb5 = String.valueOf(sb5).concat(",");
                }
                concat = String.valueOf(sb5).concat(" ");
            }
            if (z10) {
                String valueOf2 = String.valueOf(concat);
                StringBuilder sb6 = new StringBuilder(valueOf2.length() + 33);
                sb6.append(valueOf2);
                sb6.append(nanos2);
                sb6.append(" nanoseconds ");
                concat = sb6.toString();
            }
            sb3 = String.valueOf(concat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(sb3).concat(" but future completed as timeout expired"));
        }
        StringBuilder sb7 = new StringBuilder(String.valueOf(sb3).length() + 5 + String.valueOf(abstractFuture).length());
        sb7.append(sb3);
        sb7.append(" for ");
        sb7.append(abstractFuture);
        throw new TimeoutException(sb7.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @l0
    public final V i(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw e("Task was cancelled.", ((c) obj).f10245b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f10241a);
        }
        return obj == NULL ? (V) j0.b() : obj;
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof f)) & (this.value != null);
    }

    public final void l() {
        for (k e10 = ATOMIC_HELPER.e(this, k.f10263c); e10 != null; e10 = e10.f10265b) {
            e10.b();
        }
    }

    public final void m(k kVar) {
        kVar.f10264a = null;
        while (true) {
            k kVar2 = this.waiters;
            if (kVar2 == k.f10263c) {
                return;
            }
            k kVar3 = null;
            while (kVar2 != null) {
                k kVar4 = kVar2.f10265b;
                if (kVar2.f10264a != null) {
                    kVar3 = kVar2;
                } else if (kVar3 != null) {
                    kVar3.f10265b = kVar4;
                    if (kVar3.f10264a == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.c(this, kVar2, kVar4)) {
                    break;
                }
                kVar2 = kVar4;
            }
            return;
        }
    }

    public final void maybePropagateCancellationTo(@CheckForNull Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }

    @CanIgnoreReturnValue
    public boolean set(@l0 V v10) {
        if (v10 == null) {
            v10 = (V) NULL;
        }
        if (!ATOMIC_HELPER.b(this, null, v10)) {
            return false;
        }
        g(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setException(Throwable th2) {
        if (!ATOMIC_HELPER.b(this, null, new Failure((Throwable) u.E(th2)))) {
            return false;
        }
        g(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean setFuture(c0<? extends V> c0Var) {
        Failure failure;
        u.E(c0Var);
        Object obj = this.value;
        if (obj == null) {
            if (c0Var.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, j(c0Var))) {
                    return false;
                }
                g(this);
                return true;
            }
            f fVar = new f(this, c0Var);
            if (ATOMIC_HELPER.b(this, null, fVar)) {
                try {
                    c0Var.addListener(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable th2) {
                    try {
                        failure = new Failure(th2);
                    } catch (Throwable unused) {
                        failure = Failure.f10240b;
                    }
                    ATOMIC_HELPER.b(this, fVar, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            c0Var.cancel(((c) obj).f10244a);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            b(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // q5.a
    @CheckForNull
    public final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof h)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).f10241a;
        }
        return null;
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).f10244a;
    }

    public static final class d {

        /* renamed from: d */
        public static final d f10246d = new d();

        /* renamed from: a */
        @CheckForNull
        public final Runnable f10247a;

        /* renamed from: b */
        @CheckForNull
        public final Executor f10248b;

        /* renamed from: c */
        @CheckForNull
        public d f10249c;

        public d(Runnable runnable, Executor executor) {
            this.f10247a = runnable;
            this.f10248b = executor;
        }

        public d() {
            this.f10247a = null;
            this.f10248b = null;
        }
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    @l0
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return i(obj2);
            }
            k kVar = this.waiters;
            if (kVar != k.f10263c) {
                k kVar2 = new k();
                do {
                    kVar2.a(kVar);
                    if (ATOMIC_HELPER.c(this, kVar, kVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                m(kVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return i(obj);
                    }
                    kVar = this.waiters;
                } while (kVar != k.f10263c);
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return i(obj3);
        }
        throw new InterruptedException();
    }
}
