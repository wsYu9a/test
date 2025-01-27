package com.opos.mobad.ad.e;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.opos.mobad.ad.i;

/* loaded from: classes4.dex */
public interface c extends i.a {

    /* renamed from: b */
    public static final c f19488b = new c() { // from class: com.opos.mobad.ad.e.c.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdFailed code:" + i2 + ",msg:" + str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", IAdInterListener.AdCommandType.AD_CLICK);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdShow " + str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdClose");
        }
    };

    /* renamed from: com.opos.mobad.ad.e.c$1 */
    class AnonymousClass1 implements c {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdFailed code:" + i2 + ",msg:" + str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", IAdInterListener.AdCommandType.AD_CLICK);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdShow " + str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("ISplashAdListener", "onAdClose");
        }
    }
}
