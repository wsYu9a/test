package com.kwad.components.ad.splashscreen.presenter.endcard;

/* loaded from: classes2.dex */
public final class f extends com.kwad.components.ad.splashscreen.presenter.e {
    com.kwad.components.ad.splashscreen.f Gr = new com.kwad.components.ad.splashscreen.f() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.f.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.splashscreen.f
        public final void kO() {
            f.this.a(new e(), true);
            f.this.a(new h(), true);
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.f$1 */
    public class AnonymousClass1 implements com.kwad.components.ad.splashscreen.f {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.splashscreen.f
        public final void kO() {
            f.this.a(new e(), true);
            f.this.a(new h(), true);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.EJ.a(this.Gr);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.EJ.b(this.Gr);
    }
}
