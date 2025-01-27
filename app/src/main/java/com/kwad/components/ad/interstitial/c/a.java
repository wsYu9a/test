package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ai;

/* loaded from: classes.dex */
public final class a extends b {
    private ComplianceTextView jo;
    private OrientationEventListener jp;
    private KsAutoCloseView jq;

    /* renamed from: com.kwad.components.ad.interstitial.c.a$1 */
    final class AnonymousClass1 implements c.e {
        final /* synthetic */ c jr;

        AnonymousClass1(c cVar) {
            cVar = cVar;
        }

        @Override // com.kwad.components.ad.interstitial.c.c.e
        public final void onError() {
            a.this.b(cVar);
            a.this.a(cVar);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.a$2 */
    final class AnonymousClass2 extends OrientationEventListener {
        final /* synthetic */ c jr;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, c cVar) {
            super(context);
            cVar = cVar;
        }

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int i2) {
            a.this.b(cVar);
        }
    }

    public void a(c cVar) {
        AnonymousClass2 anonymousClass2 = new OrientationEventListener(cVar.hU.getContext()) { // from class: com.kwad.components.ad.interstitial.c.a.2
            final /* synthetic */ c jr;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Context context, c cVar2) {
                super(context);
                cVar = cVar2;
            }

            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i2) {
                a.this.b(cVar);
            }
        };
        this.jp = anonymousClass2;
        if (anonymousClass2.canDetectOrientation()) {
            this.jp.enable();
        } else {
            this.jp.disable();
        }
    }

    public void b(c cVar) {
        h(this.jo);
        if (ai.DM()) {
            com.kwad.sdk.c.kwai.a.b(this.jq, 0, com.kwad.sdk.c.kwai.a.a(getContext(), 25.0f), 0, 0);
        } else {
            com.kwad.sdk.c.kwai.a.b(this.jq, 0, 0, 0, 0);
        }
        this.jo.setVisibility(0);
        this.jo.setAdTemplate(cVar.mAdTemplate);
    }

    private void h(View view) {
        int a2 = com.kwad.sdk.c.kwai.a.a(getContext(), 4.0f);
        int a3 = com.kwad.sdk.c.kwai.a.a(getContext(), 4.0f);
        com.kwad.sdk.c.kwai.a.b(view, a3, a2, a3, 0);
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        c cVar = (c) Bh();
        cVar.a(new c.e() { // from class: com.kwad.components.ad.interstitial.c.a.1
            final /* synthetic */ c jr;

            AnonymousClass1(c cVar2) {
                cVar = cVar2;
            }

            @Override // com.kwad.components.ad.interstitial.c.c.e
            public final void onError() {
                a.this.b(cVar);
                a.this.a(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jo = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.jq = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.jp;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }
}
