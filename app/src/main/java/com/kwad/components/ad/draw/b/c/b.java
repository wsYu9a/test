package com.kwad.components.ad.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.m.b;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.draw.a.a {

    @Nullable
    private com.kwad.components.ad.m.b dw;

    /* renamed from: ee */
    private com.kwad.sdk.core.webview.d.a.a f11443ee = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.b.c.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.f11413df.f11414de != null) {
                b.this.f11413df.f11414de.onAdClicked();
            }
        }
    };
    private FrameLayout en;

    /* renamed from: com.kwad.components.ad.draw.b.c.b$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.f11413df.f11414de != null) {
                b.this.f11413df.f11414de.onAdClicked();
            }
        }
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.m.b bVar = this.f11413df.dw;
        this.dw = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.f11443ee);
        com.kwad.components.ad.m.b bVar2 = this.dw;
        FrameLayout frameLayout = this.en;
        com.kwad.components.ad.draw.a.b bVar3 = this.f11413df;
        bVar2.a(frameLayout, bVar3.mRootContainer, bVar3.mAdTemplate, bVar3.mApkDownloadHelper);
        this.dw.a((b.InterfaceC0390b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.en = (FrameLayout) findViewById(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.m.b bVar = this.dw;
        if (bVar != null) {
            bVar.mM();
        }
    }
}
