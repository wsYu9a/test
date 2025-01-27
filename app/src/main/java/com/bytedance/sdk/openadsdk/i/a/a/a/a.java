package com.bytedance.sdk.openadsdk.i.a.a.a;

import com.bykv.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: classes2.dex */
public class a implements TTFeedAd.CustomizeVideo {

    /* renamed from: a */
    private final Bridge f8205a;

    public a(Bridge bridge) {
        this.f8205a = bridge == null ? b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        return (String) this.f8205a.call(162101, b.a(0).b(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        this.f8205a.call(162107, b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j10) {
        b a10 = b.a(1);
        a10.a(0, j10);
        this.f8205a.call(162106, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j10) {
        b a10 = b.a(1);
        a10.a(0, j10);
        this.f8205a.call(162104, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j10, int i10, int i11) {
        b a10 = b.a(3);
        a10.a(0, j10);
        a10.a(1, i10);
        a10.a(2, i11);
        this.f8205a.call(162109, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        this.f8205a.call(162105, b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j10) {
        b a10 = b.a(1);
        a10.a(0, j10);
        this.f8205a.call(162103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        this.f8205a.call(162102, b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i10, int i11) {
        b a10 = b.a(2);
        a10.a(0, i10);
        a10.a(1, i11);
        this.f8205a.call(162108, a10.b(), Void.class);
    }
}
