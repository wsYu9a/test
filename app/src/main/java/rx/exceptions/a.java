package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import rx.j.b;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    private static final int f35761a = 25;

    private a() {
    }

    public static void a(Throwable th, Throwable th2) {
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (th.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 >= 25) {
                return;
            }
            th = th.getCause();
            if (!hashSet.contains(th.getCause())) {
                hashSet.add(th.getCause());
                i2 = i3;
            }
        }
        try {
            th.initCause(th2);
        } catch (Throwable unused) {
        }
    }

    public static Throwable b(Throwable th) {
        int i2 = 0;
        while (th.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th = th.getCause();
            i2 = i3;
        }
        return th;
    }

    public static RuntimeException c(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    @b
    public static void d(List<? extends Throwable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() != 1) {
            throw new CompositeException("Multiple exceptions", list);
        }
        Throwable th = list.get(0);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static void e(Throwable th) {
        if (th instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th);
        }
        if (th instanceof OnErrorFailedException) {
            OnErrorFailedException onErrorFailedException = (OnErrorFailedException) th;
            Throwable cause = onErrorFailedException.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw onErrorFailedException;
            }
            throw ((RuntimeException) cause);
        }
        if (th instanceof StackOverflowError) {
            throw ((StackOverflowError) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
