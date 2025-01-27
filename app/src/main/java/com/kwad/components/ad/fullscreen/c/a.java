package com.kwad.components.ad.fullscreen.c;

import com.kwad.components.ad.reward.e.m;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.tachikoma.b.q;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {

    /* renamed from: ia */
    private l f11508ia = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.rO.fV();
        }
    };

    /* renamed from: ib */
    private final m f11509ib = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.m
        public final void a(q qVar) {
            if (qVar == null || qVar.type != 1) {
                return;
            }
            a.this.rO.f11689qf.release();
            a.this.rO.fV();
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.c.a$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.rO.fV();
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a$2 */
    public class AnonymousClass2 implements m {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.m
        public final void a(q qVar) {
            if (qVar == null || qVar.type != 1) {
                return;
            }
            a.this.rO.f11689qf.release();
            a.this.rO.fV();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.f11689qf.a(this.f11508ia);
        com.kwad.components.ad.reward.c.fy().a(this.f11509ib);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.f11508ia);
        com.kwad.components.ad.reward.c.fy().b(this.f11509ib);
    }
}
