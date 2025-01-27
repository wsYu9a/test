package com.opos.mobad.ad.c;

import java.util.List;

/* loaded from: classes4.dex */
public interface f {

    /* renamed from: b */
    public static final f f19475b = new f() { // from class: com.opos.mobad.ad.c.f.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdReady =", list);
        }
    };

    /* renamed from: com.opos.mobad.ad.c.f$1 */
    class AnonymousClass1 implements f {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeAdListener", "onAdReady =", list);
        }
    }

    void a(q qVar);

    void a(q qVar, d dVar);

    void a(List<d> list);
}
