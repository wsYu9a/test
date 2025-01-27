package p5;

import java.util.concurrent.locks.LockSupport;
import javax.annotation.CheckForNull;

@m
/* loaded from: classes2.dex */
public final class k0 {

    /* renamed from: a */
    public static final long f29801a = 2147483647999999999L;

    public static void a(@CheckForNull Object obj, long j10) {
        LockSupport.parkNanos(obj, Math.min(j10, f29801a));
    }
}
