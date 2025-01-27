package com.google.common.util.concurrent;

import b5.u;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@a5.a
@CanIgnoreReturnValue
@a5.c
@p5.m
/* loaded from: classes2.dex */
public class CycleDetectingLockFactory {

    /* renamed from: b */
    public static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, c>> f10337b = new MapMaker().l().i();

    /* renamed from: c */
    public static final Logger f10338c = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* renamed from: d */
    public static final ThreadLocal<ArrayList<c>> f10339d = new a();

    /* renamed from: a */
    public final d f10340a;

    public final class CycleDetectingReentrantLock extends ReentrantLock implements b {
        private final c lockGraphNode;

        public /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, c cVar, boolean z10, a aVar) {
            this(cVar, z10);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public c getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        private CycleDetectingReentrantLock(c cVar, boolean z10) {
            super(z10);
            this.lockGraphNode = (c) u.E(cVar);
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock(j10, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }
    }

    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements b {
        private final c lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;

        public /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, c cVar, boolean z10, a aVar) {
            this(cycleDetectingLockFactory, cVar, z10);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public c getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, c cVar, boolean z10) {
            super(z10);
            this.readLock = cycleDetectingLockFactory.new CycleDetectingReentrantReadLock(this);
            this.writeLock = cycleDetectingLockFactory.new CycleDetectingReentrantWriteLock(this);
            this.lockGraphNode = (c) u.E(cVar);
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    public static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), c.class.getName());

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ExampleStackTrace(com.google.common.util.concurrent.CycleDetectingLockFactory.c r4, com.google.common.util.concurrent.CycleDetectingLockFactory.c r5) {
            /*
                r3 = this;
                java.lang.String r4 = r4.d()
                java.lang.String r5 = r5.d()
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r0 = r0.length()
                int r0 = r0 + 4
                java.lang.String r1 = java.lang.String.valueOf(r5)
                int r1 = r1.length()
                int r0 = r0 + r1
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                r1.append(r4)
                java.lang.String r4 = " -> "
                r1.append(r4)
                r1.append(r5)
                java.lang.String r4 = r1.toString()
                r3.<init>(r4)
                java.lang.StackTraceElement[] r4 = r3.getStackTrace()
                int r5 = r4.length
                r0 = 0
            L38:
                if (r0 >= r5) goto L6d
                java.lang.Class<com.google.common.util.concurrent.CycleDetectingLockFactory$e> r1 = com.google.common.util.concurrent.CycleDetectingLockFactory.e.class
                java.lang.String r1 = r1.getName()
                r2 = r4[r0]
                java.lang.String r2 = r2.getClassName()
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L52
                java.lang.StackTraceElement[] r4 = com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace.EMPTY_STACK_TRACE
                r3.setStackTrace(r4)
                goto L6d
            L52:
                com.google.common.collect.ImmutableSet<java.lang.String> r1 = com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace.EXCLUDED_CLASS_NAMES
                r2 = r4[r0]
                java.lang.String r2 = r2.getClassName()
                boolean r1 = r1.contains(r2)
                if (r1 != 0) goto L6a
                java.lang.Object[] r4 = java.util.Arrays.copyOfRange(r4, r0, r5)
                java.lang.StackTraceElement[] r4 = (java.lang.StackTraceElement[]) r4
                r3.setStackTrace(r4)
                goto L6d
            L6a:
                int r0 = r0 + 1
                goto L38
            L6d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace.<init>(com.google.common.util.concurrent.CycleDetectingLockFactory$c, com.google.common.util.concurrent.CycleDetectingLockFactory$c):void");
        }
    }

    @a5.a
    public enum Policies implements d {
        THROW { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f10338c.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$2 */
        public enum AnonymousClass2 extends Policies {
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f10338c.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        }

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$3 */
        public enum AnonymousClass3 extends Policies {
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        }

        /* synthetic */ Policies(a aVar) {
            this();
        }

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$1 */
        public enum AnonymousClass1 extends Policies {
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        }
    }

    @a5.a
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        public /* synthetic */ PotentialDeadlockException(c cVar, c cVar2, ExampleStackTrace exampleStackTrace, a aVar) {
            this(cVar, cVar2, exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb2 = new StringBuilder(message);
            for (Throwable th2 = this.conflictingStackTrace; th2 != null; th2 = th2.getCause()) {
                sb2.append(", ");
                sb2.append(th2.getMessage());
            }
            return sb2.toString();
        }

        private PotentialDeadlockException(c cVar, c cVar2, ExampleStackTrace exampleStackTrace) {
            super(cVar, cVar2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    public class a extends ThreadLocal<ArrayList<c>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<c> initialValue() {
            return Lists.u(3);
        }
    }

    public interface b {
        c getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    public static class c {

        /* renamed from: a */
        public final Map<c, ExampleStackTrace> f10341a = new MapMaker().l().i();

        /* renamed from: b */
        public final Map<c, PotentialDeadlockException> f10342b = new MapMaker().l().i();

        /* renamed from: c */
        public final String f10343c;

        public c(String str) {
            this.f10343c = (String) u.E(str);
        }

        public void a(d dVar, c cVar) {
            u.x0(this != cVar, "Attempted to acquire multiple locks with the same rank %s", cVar.d());
            if (this.f10341a.containsKey(cVar)) {
                return;
            }
            PotentialDeadlockException potentialDeadlockException = this.f10342b.get(cVar);
            if (potentialDeadlockException != null) {
                dVar.handlePotentialDeadlock(new PotentialDeadlockException(cVar, this, potentialDeadlockException.getConflictingStackTrace(), null));
                return;
            }
            ExampleStackTrace c10 = cVar.c(this, Sets.z());
            if (c10 == null) {
                this.f10341a.put(cVar, new ExampleStackTrace(cVar, this));
                return;
            }
            PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(cVar, this, c10, null);
            this.f10342b.put(cVar, potentialDeadlockException2);
            dVar.handlePotentialDeadlock(potentialDeadlockException2);
        }

        public void b(d dVar, List<c> list) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                a(dVar, it.next());
            }
        }

        @CheckForNull
        public final ExampleStackTrace c(c cVar, Set<c> set) {
            if (!set.add(this)) {
                return null;
            }
            ExampleStackTrace exampleStackTrace = this.f10341a.get(cVar);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (Map.Entry<c, ExampleStackTrace> entry : this.f10341a.entrySet()) {
                c key = entry.getKey();
                ExampleStackTrace c10 = key.c(cVar, set);
                if (c10 != null) {
                    ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(key, this);
                    exampleStackTrace2.setStackTrace(entry.getValue().getStackTrace());
                    exampleStackTrace2.initCause(c10);
                    return exampleStackTrace2;
                }
            }
            return null;
        }

        public String d() {
            return this.f10343c;
        }
    }

    @a5.a
    public interface d {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    @a5.a
    public static final class e<E extends Enum<E>> extends CycleDetectingLockFactory {

        /* renamed from: e */
        public final Map<E, c> f10344e;

        @a5.d
        public e(d dVar, Map<E, c> map) {
            super(dVar, null);
            this.f10344e = map;
        }

        public ReentrantLock o(E e10) {
            return p(e10, false);
        }

        public ReentrantLock p(E e10, boolean z10) {
            if (this.f10340a == Policies.DISABLED) {
                return new ReentrantLock(z10);
            }
            c cVar = this.f10344e.get(e10);
            Objects.requireNonNull(cVar);
            return new CycleDetectingReentrantLock(this, cVar, z10, null);
        }

        public ReentrantReadWriteLock q(E e10) {
            return r(e10, false);
        }

        public ReentrantReadWriteLock r(E e10, boolean z10) {
            if (this.f10340a == Policies.DISABLED) {
                return new ReentrantReadWriteLock(z10);
            }
            c cVar = this.f10344e.get(e10);
            Objects.requireNonNull(cVar);
            return new CycleDetectingReentrantReadWriteLock(this, cVar, z10, null);
        }
    }

    public /* synthetic */ CycleDetectingLockFactory(d dVar, a aVar) {
        this(dVar);
    }

    @a5.d
    public static <E extends Enum<E>> Map<E, c> e(Class<E> cls) {
        EnumMap W = Maps.W(cls);
        E[] enumConstants = cls.getEnumConstants();
        int length = enumConstants.length;
        ArrayList u10 = Lists.u(length);
        int i10 = 0;
        for (E e10 : enumConstants) {
            c cVar = new c(f(e10));
            u10.add(cVar);
            W.put((EnumMap) e10, (E) cVar);
        }
        for (int i11 = 1; i11 < length; i11++) {
            ((c) u10.get(i11)).b(Policies.THROW, u10.subList(0, i11));
        }
        while (i10 < length - 1) {
            i10++;
            ((c) u10.get(i10)).b(Policies.DISABLED, u10.subList(i10, length));
        }
        return Collections.unmodifiableMap(W);
    }

    public static String f(Enum<?> r32) {
        String simpleName = r32.getDeclaringClass().getSimpleName();
        String name = r32.name();
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 1 + String.valueOf(name).length());
        sb2.append(simpleName);
        sb2.append(p1.b.f29697h);
        sb2.append(name);
        return sb2.toString();
    }

    public static <E extends Enum<E>> Map<? extends E, c> g(Class<E> cls) {
        ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, c>> concurrentMap = f10337b;
        Map<? extends E, c> map = (Map) concurrentMap.get(cls);
        if (map != null) {
            return map;
        }
        Map<? extends Enum<?>, c> e10 = e(cls);
        return (Map) com.google.common.base.a.a(concurrentMap.putIfAbsent(cls, e10), e10);
    }

    public static void h(b bVar) {
        if (bVar.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<c> arrayList = f10339d.get();
        c lockGraphNode = bVar.getLockGraphNode();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == lockGraphNode) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public static CycleDetectingLockFactory i(d dVar) {
        return new CycleDetectingLockFactory(dVar);
    }

    public static <E extends Enum<E>> e<E> j(Class<E> cls, d dVar) {
        u.E(cls);
        u.E(dVar);
        return new e<>(dVar, g(cls));
    }

    public final void a(b bVar) {
        if (bVar.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<c> arrayList = f10339d.get();
        c lockGraphNode = bVar.getLockGraphNode();
        lockGraphNode.b(this.f10340a, arrayList);
        arrayList.add(lockGraphNode);
    }

    public ReentrantLock k(String str) {
        return l(str, false);
    }

    public ReentrantLock l(String str, boolean z10) {
        return this.f10340a == Policies.DISABLED ? new ReentrantLock(z10) : new CycleDetectingReentrantLock(this, new c(str), z10, null);
    }

    public ReentrantReadWriteLock m(String str) {
        return n(str, false);
    }

    public ReentrantReadWriteLock n(String str, boolean z10) {
        return this.f10340a == Policies.DISABLED ? new ReentrantReadWriteLock(z10) : new CycleDetectingReentrantReadWriteLock(this, new c(str), z10, null);
    }

    public CycleDetectingLockFactory(d dVar) {
        this.f10340a = (d) u.E(dVar);
    }

    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {

        @Weak
        final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j10, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }
    }

    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {

        @Weak
        final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j10, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this.readWriteLock);
            }
        }
    }
}
