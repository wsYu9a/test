package com.kwad.components.core.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class g extends KSFrameLayout {
    private final d LK;
    private a LT;
    private final d LV;

    /* renamed from: dh */
    private final com.kwad.components.core.widget.a.b f11915dh;
    private final AdTemplate mAdTemplate;
    private Presenter mPresenter;
    private boolean pv;

    /* renamed from: com.kwad.components.core.e.a.g$1 */
    public class AnonymousClass1 implements d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.e.a.d
        public final void nS() {
            g.this.ef();
        }
    }

    public g(@NonNull Context context, AdTemplate adTemplate, d dVar) {
        super(context);
        this.LV = new d() { // from class: com.kwad.components.core.e.a.g.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.e.a.d
            public final void nS() {
                g.this.ef();
            }
        };
        this.mAdTemplate = adTemplate;
        this.LK = dVar;
        this.f11915dh = new com.kwad.components.core.widget.a.b(this, 70);
        initMVP();
    }

    public void ef() {
        if (this.pv) {
            return;
        }
        this.pv = true;
        this.LK.nS();
    }

    private void initMVP() {
        this.LT = nZ();
        Presenter onCreatePresenter = onCreatePresenter();
        this.mPresenter = onCreatePresenter;
        onCreatePresenter.I(this);
        this.mPresenter.k(this.LT);
    }

    private a nZ() {
        a aVar = new a();
        aVar.LI = this;
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.LJ = this.f11915dh;
        aVar.LK = this.LV;
        return aVar;
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewAttached");
        this.f11915dh.uE();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewDetached");
        this.f11915dh.release();
        this.mPresenter.destroy();
        this.LT.release();
        ef();
    }
}
