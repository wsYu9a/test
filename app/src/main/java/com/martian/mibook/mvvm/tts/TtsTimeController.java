package com.martian.mibook.mvvm.tts;

import android.content.Context;
import ba.j;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import xi.k;

/* loaded from: classes3.dex */
public final class TtsTimeController {

    /* renamed from: b */
    @k
    public static final String f15067b = "audio_book_available_time";

    /* renamed from: c */
    @k
    public static final String f15068c = "audio_book_unlock_expiration_timestamp";

    /* renamed from: d */
    @k
    public static final String f15069d = "sp_audio_book_next_replenishment_time";

    /* renamed from: e */
    public static final long f15070e = -2;

    /* renamed from: f */
    public static final long f15071f = -1;

    /* renamed from: g */
    public static final long f15072g = 7200;

    /* renamed from: h */
    public static final long f15073h = 300;

    /* renamed from: i */
    public static volatile long f15074i;

    /* renamed from: a */
    @k
    public static final TtsTimeController f15066a = new TtsTimeController();

    /* renamed from: j */
    public static volatile long f15075j = -1;

    /* renamed from: k */
    public static volatile long f15076k = -1;

    /* renamed from: l */
    @k
    public static final Lazy f15077l = LazyKt.lazy(TtsTimeController$currentTimeMode$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/martian/mibook/mvvm/tts/TtsTimeController$TimeMode;", "", "videoMinutes", "", "supplementalMinutes", "(Ljava/lang/String;III)V", "getSupplementalMinutes", "getVideoMinutes", "MODE_ACCUMULATED_DURATION", "MODE_NATURAL_TIME", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimeMode extends Enum<TimeMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TimeMode[] $VALUES;
        public static final TimeMode MODE_ACCUMULATED_DURATION;
        public static final TimeMode MODE_NATURAL_TIME;
        private final int supplementalMinutes;
        private final int videoMinutes;

        private static final /* synthetic */ TimeMode[] $values() {
            return new TimeMode[]{MODE_ACCUMULATED_DURATION, MODE_NATURAL_TIME};
        }

        static {
            int audioVideoMinutes = MiConfigSingleton.b2().c2().getAudioVideoMinutes();
            TtsTimeController ttsTimeController = TtsTimeController.f15066a;
            MODE_ACCUMULATED_DURATION = new TimeMode("MODE_ACCUMULATED_DURATION", 0, audioVideoMinutes, ttsTimeController.k() + 10);
            Integer ttsUnlockMinutes = MiConfigSingleton.b2().c2().getTtsUnlockMinutes();
            Intrinsics.checkNotNullExpressionValue(ttsUnlockMinutes, "getTtsUnlockMinutes(...)");
            MODE_NATURAL_TIME = new TimeMode("MODE_NATURAL_TIME", 1, ttsUnlockMinutes.intValue(), MiConfigSingleton.b2().c2().getAudioUnlockMinutes() + ttsTimeController.k());
            TimeMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private TimeMode(String str, int i10, int i11, int i12) {
            super(str, i10);
            this.videoMinutes = i11;
            this.supplementalMinutes = i12;
        }

        @k
        public static EnumEntries<TimeMode> getEntries() {
            return $ENTRIES;
        }

        public static TimeMode valueOf(String str) {
            return (TimeMode) Enum.valueOf(TimeMode.class, str);
        }

        public static TimeMode[] values() {
            return (TimeMode[]) $VALUES.clone();
        }

        public final int getSupplementalMinutes() {
            return this.supplementalMinutes;
        }

        public final int getVideoMinutes() {
            return this.videoMinutes;
        }
    }

    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15078a;

        static {
            int[] iArr = new int[TimeMode.values().length];
            try {
                iArr[TimeMode.MODE_NATURAL_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimeMode.MODE_ACCUMULATED_DURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15078a = iArr;
        }
    }

    @JvmStatic
    public static final int b(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f15074i == 0) {
            f15074i = j.h(context, f15069d, -1L);
        }
        long a10 = xc.a.f31995a.a();
        if (a10 <= f15074i) {
            return 0;
        }
        TtsTimeController ttsTimeController = f15066a;
        f15074i = ttsTimeController.m(a10);
        j.n(context, f15069d, f15074i);
        if (ttsTimeController.h() == TimeMode.MODE_NATURAL_TIME) {
            long supplementalMinutes = ttsTimeController.h().getSupplementalMinutes() * 60;
            long coerceAtLeast = RangesKt.coerceAtLeast(f15076k - a10, 0L) / 1000;
            if (coerceAtLeast >= supplementalMinutes) {
                return 0;
            }
            long coerceIn = RangesKt.coerceIn(supplementalMinutes - coerceAtLeast, 300L, supplementalMinutes);
            w(context, RangesKt.coerceAtLeast(f15076k, a10) + (1000 * coerceIn));
            return (int) (coerceIn / 60);
        }
        long supplementalMinutes2 = ttsTimeController.h().getSupplementalMinutes() * 60;
        long j10 = supplementalMinutes2 - f15075j;
        if (j10 <= 0) {
            return 0;
        }
        long coerceIn2 = RangesKt.coerceIn(j10, 300L, supplementalMinutes2);
        v(context, f15075j + coerceIn2);
        return (int) (coerceIn2 / 60);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x0003, B:6:0x0012, B:10:0x001f, B:12:0x0029, B:13:0x0046, B:14:0x005e, B:16:0x0066, B:21:0x0058), top: B:3:0x0003 }] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final synchronized void c(@xi.k android.content.Context r7, boolean r8) {
        /*
            java.lang.Class<com.martian.mibook.mvvm.tts.TtsTimeController> r0 = com.martian.mibook.mvvm.tts.TtsTimeController.class
            monitor-enter(r0)
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)     // Catch: java.lang.Throwable -> L44
            com.martian.mibook.application.MiConfigSingleton r1 = com.martian.mibook.application.MiConfigSingleton.b2()     // Catch: java.lang.Throwable -> L44
            boolean r1 = r1.K2()     // Catch: java.lang.Throwable -> L44
            if (r1 != 0) goto L58
            com.martian.mibook.application.MiConfigSingleton r1 = com.martian.mibook.application.MiConfigSingleton.b2()     // Catch: java.lang.Throwable -> L44
            boolean r1 = r1.E2()     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L1d
            goto L58
        L1d:
            if (r8 == 0) goto L5e
            com.martian.mibook.mvvm.tts.TtsTimeController r8 = com.martian.mibook.mvvm.tts.TtsTimeController.f15066a     // Catch: java.lang.Throwable -> L44
            com.martian.mibook.mvvm.tts.TtsTimeController$TimeMode r8 = r8.h()     // Catch: java.lang.Throwable -> L44
            com.martian.mibook.mvvm.tts.TtsTimeController$TimeMode r1 = com.martian.mibook.mvvm.tts.TtsTimeController.TimeMode.MODE_NATURAL_TIME     // Catch: java.lang.Throwable -> L44
            if (r8 != r1) goto L46
            int r8 = r1.getVideoMinutes()     // Catch: java.lang.Throwable -> L44
            long r1 = (long) r8     // Catch: java.lang.Throwable -> L44
            long r3 = com.martian.mibook.mvvm.tts.TtsTimeController.f15076k     // Catch: java.lang.Throwable -> L44
            xc.a$a r8 = xc.a.f31995a     // Catch: java.lang.Throwable -> L44
            long r5 = r8.a()     // Catch: java.lang.Throwable -> L44
            long r3 = kotlin.ranges.RangesKt.coerceAtLeast(r3, r5)     // Catch: java.lang.Throwable -> L44
            r5 = 60000(0xea60, double:2.9644E-319)
            long r1 = r1 * r5
            long r3 = r3 + r1
            w(r7, r3)     // Catch: java.lang.Throwable -> L44
            goto L5e
        L44:
            r7 = move-exception
            goto L79
        L46:
            com.martian.mibook.mvvm.tts.TtsTimeController$TimeMode r8 = com.martian.mibook.mvvm.tts.TtsTimeController.TimeMode.MODE_ACCUMULATED_DURATION     // Catch: java.lang.Throwable -> L44
            int r8 = r8.getVideoMinutes()     // Catch: java.lang.Throwable -> L44
            long r1 = (long) r8     // Catch: java.lang.Throwable -> L44
            r3 = 60
            long r1 = r1 * r3
            long r3 = com.martian.mibook.mvvm.tts.TtsTimeController.f15075j     // Catch: java.lang.Throwable -> L44
            long r3 = r3 + r1
            v(r7, r3)     // Catch: java.lang.Throwable -> L44
            goto L5e
        L58:
            r1 = -1
            com.martian.mibook.mvvm.tts.TtsTimeController.f15075j = r1     // Catch: java.lang.Throwable -> L44
            com.martian.mibook.mvvm.tts.TtsTimeController.f15076k = r1     // Catch: java.lang.Throwable -> L44
        L5e:
            com.martian.mibook.mvvm.tts.service.BaseReadAloudService$a r8 = com.martian.mibook.mvvm.tts.service.BaseReadAloudService.INSTANCE     // Catch: java.lang.Throwable -> L44
            boolean r8 = r8.m()     // Catch: java.lang.Throwable -> L44
            if (r8 == 0) goto L77
            android.content.Intent r8 = new android.content.Intent     // Catch: java.lang.Throwable -> L44
            java.lang.Class r1 = com.martian.mibook.mvvm.tts.TTSReadManager.o()     // Catch: java.lang.Throwable -> L44
            r8.<init>(r7, r1)     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "upTtsAvailableTime"
            r8.setAction(r1)     // Catch: java.lang.Throwable -> L44
            androidx.core.content.ContextCompat.startForegroundService(r7, r8)     // Catch: java.lang.Throwable -> L44
        L77:
            monitor-exit(r0)
            return
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.tts.TtsTimeController.c(android.content.Context, boolean):void");
    }

    public static /* synthetic */ void d(Context context, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        c(context, z10);
    }

    @JvmStatic
    public static final long f(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return j.h(context, f15067b, -2L);
    }

    @JvmStatic
    public static final long g() {
        if (f15066a.h() != TimeMode.MODE_NATURAL_TIME) {
            return f15075j;
        }
        return RangesKt.coerceAtLeast(f15076k - xc.a.f31995a.a(), 0L) / 1000;
    }

    @JvmStatic
    public static final int i() {
        return f15066a.h().getSupplementalMinutes();
    }

    @JvmStatic
    public static final int j() {
        return f15066a.h().getVideoMinutes();
    }

    @JvmStatic
    public static final long o(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return j.h(context, f15068c, -2L);
    }

    @JvmStatic
    public static final boolean p() {
        return t() || !s();
    }

    @JvmStatic
    public static final void q(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (MiConfigSingleton.b2().K2() || MiConfigSingleton.b2().C2()) {
            f15076k = -1L;
            f15075j = -1L;
            return;
        }
        if (f15066a.h() == TimeMode.MODE_NATURAL_TIME) {
            f15076k = o(context);
            if (f15076k == -2) {
                long f10 = f(context);
                if (f10 == -2) {
                    w(context, xc.a.f31995a.a() + 7200000);
                    return;
                } else {
                    if (f10 <= 0) {
                        w(context, 0L);
                        return;
                    }
                    long a10 = xc.a.f31995a.a() + (f10 * 6000);
                    v(context, -2L);
                    w(context, a10);
                    return;
                }
            }
            return;
        }
        f15075j = f(context);
        if (f15075j == -2) {
            long o10 = o(context);
            if (o10 == -2) {
                v(context, f15072g);
                return;
            }
            if (o10 > 0) {
                long a11 = o10 - xc.a.f31995a.a();
                if (a11 > 0) {
                    v(context, a11 / 6000);
                    w(context, -2L);
                    return;
                }
            }
            v(context, 0L);
        }
    }

    @JvmStatic
    public static final boolean r(long j10) {
        int i10 = a.f15078a[f15066a.h().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (j10 >= 43200) {
                return false;
            }
        } else if (j10 >= 259200) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean s() {
        if (f15066a.h() == TimeMode.MODE_NATURAL_TIME) {
            if (f15076k > xc.a.f31995a.a()) {
                return false;
            }
        } else if (f15075j > 0) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean t() {
        if (f15066a.h() == TimeMode.MODE_NATURAL_TIME) {
            if (f15076k != -1) {
                return false;
            }
        } else if (f15075j != -1) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void u(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        v(context, f15075j);
    }

    @JvmStatic
    public static final void v(@k Context context, long j10) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (j10 >= 0 || j10 == -2) {
            f15075j = j10;
            j.n(context, f15067b, j10);
        }
    }

    @JvmStatic
    public static final void w(@k Context context, long j10) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (j10 >= 0 || j10 == -2) {
            f15076k = j10;
            j.n(context, f15068c, j10);
        }
    }

    public final long e() {
        return f15075j;
    }

    @k
    public final TimeMode h() {
        return (TimeMode) f15077l.getValue();
    }

    public final int k() {
        int W1 = MiConfigSingleton.b2().W1();
        if (W1 < 10) {
            return 0;
        }
        if (W1 < 20) {
            return 10;
        }
        if (W1 < 30) {
            return 20;
        }
        if (W1 < 40) {
            return 30;
        }
        return W1 < 50 ? 40 : 50;
    }

    public final long l() {
        return f15074i;
    }

    public final long m(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        calendar.add(5, 1);
        calendar.set(11, 6);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final long n() {
        return f15076k;
    }

    public final void x(long j10) {
        f15075j = j10;
    }

    public final void y(long j10) {
        f15074i = j10;
    }

    public final void z(long j10) {
        f15076k = j10;
    }
}
