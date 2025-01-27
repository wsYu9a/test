package com.opos.mobad.ad;

/* loaded from: classes4.dex */
public interface e {

    /* renamed from: c */
    public static final e f19487c = new e() { // from class: com.opos.mobad.ad.e.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.e
        public void a() {
            com.opos.cmn.an.f.a.b("IInitListener", "init success.");
        }

        @Override // com.opos.mobad.ad.e
        public void a(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("init failed.reason=");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.c("IInitListener", sb.toString());
        }
    };

    /* renamed from: com.opos.mobad.ad.e$1 */
    class AnonymousClass1 implements e {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.ad.e
        public void a() {
            com.opos.cmn.an.f.a.b("IInitListener", "init success.");
        }

        @Override // com.opos.mobad.ad.e
        public void a(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("init failed.reason=");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.c("IInitListener", sb.toString());
        }
    }

    void a();

    void a(String str);
}
