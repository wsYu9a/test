package com.wbl.ad.yzz.counttimer;

import android.os.CountDownTimer;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.counttimer.b;
import f.b.a.e;

/* loaded from: classes5.dex */
public final class a implements b {

    /* renamed from: a */
    public final CountDownTimer f31809a;

    /* renamed from: b */
    public final b.a f31810b;

    /* renamed from: c */
    public boolean f31811c = false;

    /* renamed from: d */
    public final long f31812d;

    /* renamed from: com.wbl.ad.yzz.counttimer.a$a */
    public static final class CountDownTimerC0701a extends CountDownTimer {
        public CountDownTimerC0701a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15299, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15326, this, Long.valueOf(j2));
        }
    }

    public a(long j2, @e b.a aVar) {
        this.f31810b = aVar;
        long j3 = j2 * 1000;
        this.f31812d = j3;
        this.f31809a = new CountDownTimerC0701a(j3, 1000L);
    }

    public static final /* synthetic */ b.a b(a aVar) {
        return (b.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15327, null, aVar);
    }

    @Override // com.wbl.ad.yzz.counttimer.b
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15321, this, null);
    }

    @Override // com.wbl.ad.yzz.counttimer.b
    public void cancel() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15324, this, null);
    }
}
