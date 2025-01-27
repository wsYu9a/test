package com.bytedance.sdk.openadsdk.c.a.a;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.Map;

/* loaded from: classes2.dex */
public class l implements TTFullScreenVideoAd {

    /* renamed from: a */
    private final Bridge f8110a;

    public l(Bridge bridge) {
        this.f8110a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.f8110a.values().longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.f8110a.values().intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.f8110a.values().intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f8110a.values().objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(3);
        a10.a(0, d10);
        a10.a(1, str);
        a10.a(2, str2);
        this.f8110a.call(210102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.a(tTAdInteractionListener));
        this.f8110a.call(210104, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.b(tTAppDownloadListener));
        this.f8110a.call(130102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.j.a.a.a.a(fullScreenVideoAdInteractionListener));
        this.f8110a.call(130101, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8110a.call(210103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, z10);
        this.f8110a.call(130105, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, activity);
        this.f8110a.call(130103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8110a.call(210101, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(3);
        a10.a(0, activity);
        a10.a(1, ritScenes);
        a10.a(2, str);
        this.f8110a.call(130104, a10.b(), Void.class);
    }
}
