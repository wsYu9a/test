package com.kwad.components.core.webview.tachikoma.c;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.components.n;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes3.dex */
public final class d extends Presenter {
    private FrameLayout Vr;
    private n Vx;
    private e abM;
    protected b adD;

    /* renamed from: com.kwad.components.core.webview.tachikoma.c.d$1 */
    public class AnonymousClass1 implements com.kwad.components.core.webview.tachikoma.e.e {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void gl() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void gt() {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        b bVar = (b) Lj();
        this.adD = bVar;
        e eVar = bVar.abM;
        this.abM = eVar;
        if (eVar != null) {
            eVar.a(new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.core.webview.tachikoma.c.d.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.e
                public final void gl() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.e
                public final void gt() {
                }
            });
        }
        n a10 = this.adD.adG.a(null);
        this.Vx = a10;
        if (a10 == null) {
            this.adD.adF.callbackPageStatus(false, null);
            this.abM.getDialog().dismiss();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.Vx.getView();
        view.setLayoutParams(layoutParams);
        this.Vr.addView(view);
        this.Vx.render();
        this.adD.adF.callbackPageStatus(true, null);
    }

    public final boolean onBackPressed() {
        n nVar = this.Vx;
        return nVar != null && nVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Vr = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
