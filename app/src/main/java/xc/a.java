package xc;

import android.os.SystemClock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import xi.k;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    @k
    public static final C0809a f31995a = new C0809a(null);

    /* renamed from: b */
    public static long f31996b = -1;

    /* renamed from: xc.a$a */
    public static final class C0809a {
        public /* synthetic */ C0809a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return a.f31996b == -1 ? System.currentTimeMillis() : a.f31996b + SystemClock.elapsedRealtime();
        }

        public final void b(long j10) {
            a.f31996b = j10 - SystemClock.elapsedRealtime();
        }

        public C0809a() {
        }
    }
}
