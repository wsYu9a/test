package com.aggmoread.sdk.z.b.s;

/* loaded from: classes.dex */
public interface c extends com.aggmoread.sdk.z.b.i.b {

    /* renamed from: c */
    public static final c f4862c = new a();

    public static class a implements c {
        @Override // com.aggmoread.sdk.z.b.s.c
        public void a() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdDismissed enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.c
        public void d() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdExposure enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.c
        public void onAdClicked() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdClicked enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.c
        public void onAdShow() {
            com.aggmoread.sdk.z.b.d.c("DspListenerSplash_[EMPTY]", "onAdShow enter");
        }

        @Override // com.aggmoread.sdk.z.b.s.c
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
}
