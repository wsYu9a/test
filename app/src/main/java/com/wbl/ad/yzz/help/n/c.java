package com.wbl.ad.yzz.help.n;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;

/* loaded from: classes5.dex */
public final class c implements e {

    public static final class a implements TTAppDownloadListener {
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12852, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12851, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12814, this, Long.valueOf(j2), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12813, this, Long.valueOf(j2), Long.valueOf(j3), str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12816, this, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12815, this, str, str2);
        }
    }

    public static final class b implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* renamed from: a */
        public final /* synthetic */ f f32714a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.bean.b f32715b;

        /* renamed from: c */
        public final /* synthetic */ int f32716c;

        public b(f fVar, com.wbl.ad.yzz.bean.b bVar, int i2) {
            this.f32714a = fVar;
            this.f32715b = bVar;
            this.f32716c = i2;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12810, this, view, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12809, this, view, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12812, this, view, str, Integer.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12811, this, view, Float.valueOf(f2), Float.valueOf(f3));
        }
    }

    public final void a(Context context, com.wbl.ad.yzz.bean.b bVar, View view, int i2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12806, this, context, bVar, view, Integer.valueOf(i2), fVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(Context context, com.wbl.ad.yzz.bean.b bVar, View view, List<View> list, int i2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12805, this, context, bVar, view, list, Integer.valueOf(i2), fVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(FrameLayout frameLayout, Context context, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12808, this, frameLayout, context, bVar);
    }

    @Override // com.wbl.ad.yzz.help.n.e
    public void a(com.wbl.ad.yzz.manager.f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12807, this, fVar);
    }
}
