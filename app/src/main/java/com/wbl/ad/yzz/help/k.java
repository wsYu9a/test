package com.wbl.ad.yzz.help;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a */
    public OrientationEventListener f32688a;

    /* renamed from: b */
    public boolean f32689b;

    /* renamed from: c */
    public boolean f32690c;

    public static final class a extends OrientationEventListener {
        public a(Activity activity, Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13822, this, Integer.valueOf(i2));
        }
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13824, this, null);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13823, this, Integer.valueOf(i2));
    }

    public final void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13818, this, activity);
    }

    public final boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13817, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13820, this, null);
    }
}
