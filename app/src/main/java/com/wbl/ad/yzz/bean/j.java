package com.wbl.ad.yzz.bean;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.List;

/* loaded from: classes5.dex */
public class j implements Object<TTFeedAd> {

    /* renamed from: a */
    public final TTFeedAd f31579a;

    public j(TTFeedAd tTFeedAd) {
        this.f31579a = tTFeedAd;
    }

    public void a(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14874, this, viewGroup, list, list2, adInteractionListener);
    }

    public void a(TTAppDownloadListener tTAppDownloadListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14873, this, tTAppDownloadListener);
    }

    public void a(h hVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14876, this, hVar);
    }

    public TTFeedAd b() {
        return (TTFeedAd) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14875, this, null);
    }

    public View c() {
        return (View) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14870, this, null);
    }

    public String d() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14869, this, null);
    }

    public DownloadStatusController e() {
        return (DownloadStatusController) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14872, this, null);
    }

    public TTImage f() {
        return (TTImage) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14871, this, null);
    }

    public List<TTImage> g() {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14866, this, null);
    }

    public int h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14865, this, null);
    }

    public int i() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14868, this, null);
    }

    public String j() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14867, this, null);
    }
}
