package c5;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f1697e = Logger.getLogger(a.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final String f1698f = "com.google.common.base.FinalizableReference";

    /* renamed from: g, reason: collision with root package name */
    @CheckForNull
    public static final Constructor<Thread> f1699g;

    /* renamed from: h, reason: collision with root package name */
    @CheckForNull
    public static final Field f1700h;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<Class<?>> f1701b;

    /* renamed from: c, reason: collision with root package name */
    public final PhantomReference<Object> f1702c;

    /* renamed from: d, reason: collision with root package name */
    public final ReferenceQueue<Object> f1703d;

    static {
        Constructor<Thread> b10 = b();
        f1699g = b10;
        f1700h = b10 == null ? d() : null;
    }

    public a(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.f1703d = referenceQueue;
        this.f1701b = new WeakReference<>(cls);
        this.f1702c = phantomReference;
    }

    @CheckForNull
    public static Constructor<Thread> b() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    public static Field d() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            f1697e.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(10:5|6|7|(1:9)|10|11|12|(1:14)|16|17)|24|(0)|10|11|12|(0)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        c5.a.f1697e.log(java.util.logging.Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[Catch: all -> 0x005a, TRY_LEAVE, TryCatch #0 {all -> 0x005a, blocks: (B:12:0x0052, B:14:0x0056), top: B:11:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(java.lang.Class<?> r5, java.lang.ref.ReferenceQueue<java.lang.Object> r6, java.lang.ref.PhantomReference<java.lang.Object> r7) {
        /*
            r0 = 1
            java.lang.String r1 = r5.getName()
            java.lang.String r2 = "b5.j"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L68
            c5.a r1 = new c5.a
            r1.<init>(r5, r6, r7)
            java.lang.Class<c5.a> r5 = c5.a.class
            java.lang.String r5 = r5.getName()
            java.lang.reflect.Constructor<java.lang.Thread> r6 = c5.a.f1699g
            r7 = 0
            if (r6 == 0) goto L47
            r2 = 0
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L3d
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L3d
            r4 = 0
            r3[r4] = r7     // Catch: java.lang.Throwable -> L3d
            r3[r0] = r1     // Catch: java.lang.Throwable -> L3d
            r4 = 2
            r3[r4] = r5     // Catch: java.lang.Throwable -> L3d
            r4 = 3
            r3[r4] = r2     // Catch: java.lang.Throwable -> L3d
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L3d
            r4 = 4
            r3[r4] = r2     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r6 = r6.newInstance(r3)     // Catch: java.lang.Throwable -> L3d
            java.lang.Thread r6 = (java.lang.Thread) r6     // Catch: java.lang.Throwable -> L3d
            goto L48
        L3d:
            r6 = move-exception
            java.util.logging.Logger r2 = c5.a.f1697e
            java.util.logging.Level r3 = java.util.logging.Level.INFO
            java.lang.String r4 = "Failed to create a thread without inherited thread-local values"
            r2.log(r3, r4, r6)
        L47:
            r6 = r7
        L48:
            if (r6 != 0) goto L4f
            java.lang.Thread r6 = new java.lang.Thread
            r6.<init>(r7, r1, r5)
        L4f:
            r6.setDaemon(r0)
            java.lang.reflect.Field r5 = c5.a.f1700h     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L64
            r5.set(r6, r7)     // Catch: java.lang.Throwable -> L5a
            goto L64
        L5a:
            r5 = move-exception
            java.util.logging.Logger r7 = c5.a.f1697e
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r1 = "Failed to clear thread local values inherited by reference finalizer thread."
            r7.log(r0, r1, r5)
        L64:
            r6.start()
            return
        L68:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Expected com.google.common.base.FinalizableReference."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.a.e(java.lang.Class, java.lang.ref.ReferenceQueue, java.lang.ref.PhantomReference):void");
    }

    public final boolean a(Reference<?> reference) {
        Method c10 = c();
        if (c10 == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.f1702c) {
                return false;
            }
            try {
                c10.invoke(reference, null);
            } catch (Throwable th2) {
                f1697e.log(Level.SEVERE, "Error cleaning up after reference.", th2);
            }
            reference = this.f1703d.poll();
        } while (reference != null);
        return true;
    }

    @CheckForNull
    public final Method c() {
        Class<?> cls = this.f1701b.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", null);
        } catch (NoSuchMethodException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.f1703d.remove())) {
        }
    }
}
