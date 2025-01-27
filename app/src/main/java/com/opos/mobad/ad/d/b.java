package com.opos.mobad.ad.d;

import com.opos.mobad.ad.h;
import com.opos.mobad.ad.i;

/* loaded from: classes4.dex */
public interface b extends h, i.a {

    /* renamed from: a */
    public static final b f19486a = new b() { // from class: com.opos.mobad.ad.d.b.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdFailed code:" + i2 + ",msg:" + str);
        }

        @Override // com.opos.mobad.ad.d.b, com.opos.mobad.ad.i.b
        public void a(long j2) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdClick currentPosition=" + j2);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdShow");
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
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdClose");
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(long j2) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayClose currentPosition=" + j2);
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoPlayError msg=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.d.b
        public void c() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayStart");
        }

        @Override // com.opos.mobad.ad.d.b
        public void d() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayComplete");
        }

        @Override // com.opos.mobad.ad.d.b
        public void e() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onLandingPageOpen");
        }

        @Override // com.opos.mobad.ad.d.b
        public void f() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onLandingPageClose");
        }
    };

    /* renamed from: com.opos.mobad.ad.d.b$1 */
    class AnonymousClass1 implements b {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdFailed code:" + i2 + ",msg:" + str);
        }

        @Override // com.opos.mobad.ad.d.b, com.opos.mobad.ad.i.b
        public void a(long j2) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdClick currentPosition=" + j2);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdShow");
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
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdClose");
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(long j2) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayClose currentPosition=" + j2);
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoPlayError msg=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", sb.toString());
        }

        @Override // com.opos.mobad.ad.d.b
        public void c() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayStart");
        }

        @Override // com.opos.mobad.ad.d.b
        public void d() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayComplete");
        }

        @Override // com.opos.mobad.ad.d.b
        public void e() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onLandingPageOpen");
        }

        @Override // com.opos.mobad.ad.d.b
        public void f() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onLandingPageClose");
        }
    }

    void a(long j2);

    void b(long j2);

    void b(String str);

    void c();

    void d();

    void e();

    void f();
}
