package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class a extends b {
    private ComplianceTextView kT;
    private OrientationEventListener kU;
    private KsAutoCloseView kV;

    /* renamed from: com.kwad.components.ad.interstitial.f.a$1 */
    public class AnonymousClass1 extends OrientationEventListener {
        final /* synthetic */ c kW;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, c cVar) {
            super(context);
            cVar = cVar;
        }

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int i10) {
            a.this.b(cVar);
        }
    }

    public void b(c cVar) {
        i(this.kT);
        if (an.isOrientationPortrait()) {
            com.kwad.sdk.c.a.a.b(this.kV, 0, com.kwad.sdk.c.a.a.a(getContext(), 25.0f), 0, 0);
        } else {
            com.kwad.sdk.c.a.a.b(this.kV, 0, 0, 0, 0);
        }
        this.kT.setVisibility(0);
        this.kT.setAdTemplate(cVar.mAdTemplate);
    }

    private void i(View view) {
        int a10 = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        int a11 = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        com.kwad.sdk.c.a.a.b(view, a11, a10, a11, 0);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        c cVar = (c) Lj();
        b(cVar);
        a(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kT = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.kV = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.kU;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    private void a(c cVar) {
        AnonymousClass1 anonymousClass1 = new OrientationEventListener(cVar.jz.getContext()) { // from class: com.kwad.components.ad.interstitial.f.a.1
            final /* synthetic */ c kW;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Context context, c cVar2) {
                super(context);
                cVar = cVar2;
            }

            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i10) {
                a.this.b(cVar);
            }
        };
        this.kU = anonymousClass1;
        if (anonymousClass1.canDetectOrientation()) {
            this.kU.enable();
        } else {
            this.kU.disable();
        }
    }
}
