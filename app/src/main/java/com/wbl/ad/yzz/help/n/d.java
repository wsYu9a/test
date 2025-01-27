package com.wbl.ad.yzz.help.n;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.List;

/* loaded from: classes5.dex */
public final class d implements e {

    public static final class a implements TTNativeAd.AdInteractionListener {

        /* renamed from: a */
        public final /* synthetic */ f f32717a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32718b;

        /* renamed from: c */
        public final /* synthetic */ int f32719c;

        public a(f fVar, com.wbl.ad.yzz.bean.b bVar, int i2) {
            this.f32717a = fVar;
            this.f32718b = bVar;
            this.f32719c = i2;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12802, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12801, this, view, tTNativeAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12804, this, tTNativeAd);
        }
    }

    public static final class b implements TTAppDownloadListener {
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12803, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12830, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12829, this, Long.valueOf(j2), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12832, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12831, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12826, this, str, str2);
        }
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(Context context, com.wbl.ad.yzz.bean.b bVar, View view, List<View> list, int i2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12825, this, context, bVar, view, list, Integer.valueOf(i2), fVar);
    }

    public final void a(Context context, com.wbl.ad.yzz.bean.b bVar, FrameLayout frameLayout, List<? extends View> list, int i2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12828, this, context, bVar, frameLayout, list, Integer.valueOf(i2), fVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(FrameLayout frameLayout, Context context, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12827, this, frameLayout, context, bVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(com.wbl.ad.yzz.manager.f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12822, this, fVar);
    }
}
