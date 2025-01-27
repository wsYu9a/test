package com.kwad.components.ad.splashscreen.presenter.endcard;

/* loaded from: classes2.dex */
public final class e extends com.kwad.components.ad.splashscreen.presenter.e {

    /* renamed from: lf */
    private com.kwad.components.core.webview.tachikoma.e.f f11902lf = new com.kwad.components.core.webview.tachikoma.e.f() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.e.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            if ("tk_splash_end_card".equals(str)) {
                e.this.a(new d(), true);
                e.this.a(new a(), true);
                e.this.a(new b(), true);
                e.this.a(new c(), true);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.e$1 */
    public class AnonymousClass1 extends com.kwad.components.core.webview.tachikoma.e.f {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            if ("tk_splash_end_card".equals(str)) {
                e.this.a(new d(), true);
                e.this.a(new a(), true);
                e.this.a(new b(), true);
                e.this.a(new c(), true);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.core.webview.tachikoma.d.b.uj().a(this.f11902lf);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.tachikoma.d.b.uj().b(this.f11902lf);
    }
}
