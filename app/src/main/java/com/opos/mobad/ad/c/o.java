package com.opos.mobad.ad.c;

import java.util.List;

/* loaded from: classes4.dex */
public interface o extends a<p> {

    /* renamed from: a */
    public static final o f19477a = new o() { // from class: com.opos.mobad.ad.c.o.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdFailed ret=" + i2 + ",msg=" + str);
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdClick iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(q qVar, p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderFailed nativeAdError=");
            sb.append(qVar != null ? qVar.toString() : "null");
            sb.append("iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(List<p> list) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdReady iNativeTempletAdViewList=", list);
        }

        @Override // com.opos.mobad.ad.c.o
        public void b(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdShow iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void c(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdClose iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void d(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderSuccess iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }
    };

    /* renamed from: com.opos.mobad.ad.c.o$1 */
    class AnonymousClass1 implements o {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdFailed ret=" + i2 + ",msg=" + str);
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdClick iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(q qVar, p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderFailed nativeAdError=");
            sb.append(qVar != null ? qVar.toString() : "null");
            sb.append("iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(List<p> list) {
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdReady iNativeTempletAdViewList=", list);
        }

        @Override // com.opos.mobad.ad.c.o
        public void b(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdShow iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void c(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdClose iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.o
        public void d(p pVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderSuccess iNativeTempletAdView=");
            Object obj = pVar;
            if (pVar == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", sb.toString());
        }
    }

    void a(p pVar);

    void a(q qVar, p pVar);

    void b(p pVar);

    void c(p pVar);

    void d(p pVar);
}
