package vj;

import java.util.HashSet;
import java.util.List;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import uj.b;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final int f31550a = 25;

    public static void a(Throwable th2, Throwable th3) {
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (th2.getCause() != null) {
            int i11 = i10 + 1;
            if (i10 >= 25) {
                return;
            }
            th2 = th2.getCause();
            if (!hashSet.contains(th2.getCause())) {
                hashSet.add(th2.getCause());
                i10 = i11;
            }
        }
        try {
            th2.initCause(th3);
        } catch (Throwable unused) {
        }
    }

    public static Throwable b(Throwable th2) {
        int i10 = 0;
        while (th2.getCause() != null) {
            int i11 = i10 + 1;
            if (i10 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th2 = th2.getCause();
            i10 = i11;
        }
        return th2;
    }

    public static RuntimeException c(Throwable th2) {
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        throw new RuntimeException(th2);
    }

    @b
    public static void d(List<? extends Throwable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() != 1) {
            throw new CompositeException("Multiple exceptions", list);
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (!(th2 instanceof Error)) {
            throw new RuntimeException(th2);
        }
        throw ((Error) th2);
    }

    public static void e(Throwable th2) {
        if (th2 instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th2);
        }
        if (th2 instanceof OnErrorFailedException) {
            OnErrorFailedException onErrorFailedException = (OnErrorFailedException) th2;
            Throwable cause = onErrorFailedException.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw onErrorFailedException;
            }
            throw ((RuntimeException) cause);
        }
        if (th2 instanceof StackOverflowError) {
            throw ((StackOverflowError) th2);
        }
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        }
        if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        }
        if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }
}
