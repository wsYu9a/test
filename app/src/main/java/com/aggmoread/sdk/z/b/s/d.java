package com.aggmoread.sdk.z.b.s;

import java.util.Map;

/* loaded from: classes.dex */
public interface d extends com.aggmoread.sdk.z.b.i.b {

    /* renamed from: d */
    public static final d f4863d = new a();

    public static class a implements d {
        @Override // com.aggmoread.sdk.z.b.s.d
        public void a() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdDismissed enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.d
        public void d() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdExposure enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.d
        public void onAdClicked() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdClicked enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.d
        public void onAdShow() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdShow enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.d
        public void onReward(Map<String, Object> map) {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onReward enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.d
        public void onVideoCached() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onVideoCached enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.d
        public void onVideoCompleted() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onVideoCompleted enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.d
        public void a(com.aggmoread.sdk.z.b.a aVar) {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdLoaded enter");
        }

        @Override // com.aggmoread.sdk.z.b.i.b
        public void a(com.aggmoread.sdk.z.b.g.e eVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onAdError = ");
            sb2.append(eVar != null ? eVar.toString() : "empty");
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", sb2.toString());
        }
    }

    void a();

    void a(com.aggmoread.sdk.z.b.a aVar);

    void d();

    void onAdClicked();

    void onAdShow();

    void onReward(Map<String, Object> map);

    void onVideoCached();

    void onVideoCompleted();
}
