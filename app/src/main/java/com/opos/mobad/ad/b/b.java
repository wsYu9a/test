package com.opos.mobad.ad.b;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.opos.mobad.ad.i;

/* loaded from: classes4.dex */
public interface b extends i.a {

    /* renamed from: a */
    public static final b f19472a = new b() { // from class: com.opos.mobad.ad.b.b.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdFailed code:" + i2 + ", msg:" + str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", IAdInterListener.AdCommandType.AD_CLICK);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdShow");
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdClose");
        }
    };

    /* renamed from: com.opos.mobad.ad.b.b$1 */
    class AnonymousClass1 implements b {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdFailed code:" + i2 + ", msg:" + str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", IAdInterListener.AdCommandType.AD_CLICK);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdShow");
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("IInterstitialAdListener", "onAdClose");
        }
    }
}
