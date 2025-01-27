package com.wbl.ad.yzz.help.n;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.List;

/* loaded from: classes5.dex */
public final class b implements e {

    /* renamed from: a */
    public com.wbl.ad.yzz.manager.f f32710a = new com.wbl.ad.yzz.manager.f();

    public static final class a implements NativeResponse.AdInteractionListener {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32711a;

        /* renamed from: b */
        public final /* synthetic */ f f32712b;

        /* renamed from: c */
        public final /* synthetic */ int f32713c;

        public a(com.wbl.ad.yzz.bean.b bVar, f fVar, int i2) {
            this.f32711a = bVar;
            this.f32712b = fVar;
            this.f32713c = i2;
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12860, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12859, this, Integer.valueOf(i2));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12854, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12853, this, null);
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12856, this, null);
        }
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(Context context, com.wbl.ad.yzz.bean.b bVar, View view, List<View> list, int i2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12855, this, context, bVar, view, list, Integer.valueOf(i2), fVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(FrameLayout frameLayout, Context context, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12850, this, frameLayout, context, bVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(com.wbl.ad.yzz.manager.f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12849, this, fVar);
    }
}
