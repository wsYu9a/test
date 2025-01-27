package com.wbl.ad.yzz.help.n;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes5.dex */
public final class i implements e {

    /* renamed from: a */
    public WeakReference<FrameLayout> f32731a;

    public static final class a implements NativeADEventListener {

        /* renamed from: a */
        public final /* synthetic */ f f32732a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32733b;

        /* renamed from: c */
        public final /* synthetic */ int f32734c;

        /* renamed from: d */
        public final /* synthetic */ NativeUnifiedADData f32735d;

        public a(f fVar, com.wbl.ad.yzz.bean.b bVar, int i2, NativeUnifiedADData nativeUnifiedADData) {
            this.f32732a = fVar;
            this.f32733b = bVar;
            this.f32734c = i2;
            this.f32735d = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12901, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12904, this, adError);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12903, this, null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12898, this, null);
        }
    }

    public final NativeAdContainer a(Context context, FrameLayout frameLayout) {
        return (NativeAdContainer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12897, this, context, frameLayout);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(Context context, com.wbl.ad.yzz.bean.b bVar, View view, List<View> list, int i2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12900, this, context, bVar, view, list, Integer.valueOf(i2), fVar);
    }

    public final void a(Context context, com.wbl.ad.yzz.bean.b bVar, FrameLayout frameLayout, List<? extends View> list, int i2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12899, this, context, bVar, frameLayout, list, Integer.valueOf(i2), fVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(FrameLayout frameLayout, Context context, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12926, this, frameLayout, context, bVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(com.wbl.ad.yzz.manager.f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12925, this, fVar);
    }
}
