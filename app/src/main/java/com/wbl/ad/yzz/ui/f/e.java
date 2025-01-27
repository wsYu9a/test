package com.wbl.ad.yzz.ui.f;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;
import com.wbl.ad.yzz.ui.ADActivity;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: f */
    public static long f34131f = 20000;

    /* renamed from: a */
    public TextView f34132a;

    /* renamed from: b */
    public CountDownTimer f34133b;

    /* renamed from: c */
    public int f34134c;

    /* renamed from: d */
    public WeakReference<ADActivity> f34135d;

    /* renamed from: e */
    public d f34136e;

    public class a extends CountDownTimer {
        public a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8852, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8851, this, Long.valueOf(j2));
        }
    }

    public e(ADActivity aDActivity, d dVar) {
        this.f34135d = new WeakReference<>(aDActivity);
        this.f34136e = dVar;
        this.f34132a = (TextView) aDActivity.findViewById(R.id.loading_tip_text_view);
        a();
    }

    public static /* synthetic */ CountDownTimer a(e eVar, CountDownTimer countDownTimer) {
        return (CountDownTimer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8941, null, eVar, countDownTimer);
    }

    public static /* synthetic */ TextView c(e eVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8943, null, eVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8938, this, null);
    }

    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8937, this, str);
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8940, this, null);
    }

    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8939, this, null);
    }
}
