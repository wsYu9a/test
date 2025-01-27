package com.opos.mobad.ad.c;

import java.util.List;

/* loaded from: classes4.dex */
public interface m extends f, com.opos.mobad.ad.f, com.opos.mobad.ad.h {

    /* renamed from: c */
    public static final m f19476c = new m() { // from class: com.opos.mobad.ad.c.m.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.f
        public void a(String str) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onInstallCompleted pkgName=" + str);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdReady =", list);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReward objects=");
            Object obj = objArr;
            if (objArr == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.m
        public void b(Object... objArr) {
        }
    };

    /* renamed from: com.opos.mobad.ad.c.m$1 */
    class AnonymousClass1 implements m {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdFailed=", qVar);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, d dVar) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdError nativeAdError=", qVar, "iNativeAdData=", dVar);
        }

        @Override // com.opos.mobad.ad.f
        public void a(String str) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onInstallCompleted pkgName=" + str);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<d> list) {
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", "onAdReady =", list);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReward objects=");
            Object obj = objArr;
            if (objArr == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("INativeRewardAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.c.m
        public void b(Object... objArr) {
        }
    }

    void b(Object... objArr);
}
