package b.d.e.c.a.l;

/* loaded from: classes4.dex */
public interface c extends b.d.e.c.a.g.b {

    /* renamed from: i */
    public static final c f4681i = new a();

    static class a implements c {
        a() {
        }

        @Override // b.d.e.c.a.g.b
        public void b(b.d.e.c.a.f.e eVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(eVar != null ? eVar.toString() : "empty");
            b.d.e.c.a.d.k("DspListenerSplash_[EMPTY]", sb.toString());
        }

        @Override // b.d.e.c.a.l.c
        public void onAdClicked() {
            b.d.e.c.a.d.k("DspListenerSplash_[EMPTY]", "onAdClicked enter");
        }

        @Override // b.d.e.c.a.l.c
        public void onAdDismissed() {
            b.d.e.c.a.d.k("DspListenerSplash_[EMPTY]", "onAdDismissed enter");
        }

        @Override // b.d.e.c.a.l.c
        public void onAdExposure() {
            b.d.e.c.a.d.k("DspListenerSplash_[EMPTY]", "onAdExposure enter");
        }

        @Override // b.d.e.c.a.l.c
        public void onAdShow() {
            b.d.e.c.a.d.k("DspListenerSplash_[EMPTY]", "onAdShow enter");
        }
    }

    void onAdClicked();

    void onAdDismissed();

    void onAdExposure();

    void onAdShow();
}
