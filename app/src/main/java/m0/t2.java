package m0;

import android.os.SystemClock;
import androidx.media3.common.SimpleBasePlayer;

/* loaded from: classes.dex */
public final /* synthetic */ class t2 {
    static {
        SimpleBasePlayer.PositionSupplier positionSupplier = SimpleBasePlayer.PositionSupplier.ZERO;
    }

    public static SimpleBasePlayer.PositionSupplier a(long j10) {
        return new SimpleBasePlayer.PositionSupplier() { // from class: m0.s2

            /* renamed from: a */
            public final /* synthetic */ long f28230a;

            public /* synthetic */ s2(long j102) {
                j10 = j102;
            }

            @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return t2.c(j10);
            }
        };
    }

    public static SimpleBasePlayer.PositionSupplier b(long j10, float f10) {
        return new SimpleBasePlayer.PositionSupplier() { // from class: m0.r2

            /* renamed from: a */
            public final /* synthetic */ long f28224a;

            /* renamed from: b */
            public final /* synthetic */ long f28225b;

            /* renamed from: c */
            public final /* synthetic */ float f28226c;

            public /* synthetic */ r2(long j102, long j11, float f102) {
                j10 = j102;
                elapsedRealtime = j11;
                f10 = f102;
            }

            @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return t2.d(j10, elapsedRealtime, f10);
            }
        };
    }

    public static /* synthetic */ long d(long j10, long j11, float f10) {
        return j10 + ((long) ((SystemClock.elapsedRealtime() - j11) * f10));
    }

    public static /* synthetic */ long c(long j10) {
        return j10;
    }
}
