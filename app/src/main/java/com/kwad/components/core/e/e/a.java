package com.kwad.components.core.e.e;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes3.dex */
public final class a extends KSFrameLayout {
    private final DialogFragment Nq;
    private final View Nr;
    private a.C0427a Ns;

    public a(@NonNull Context context, DialogFragment dialogFragment, a.C0427a c0427a) {
        super(context);
        this.Nq = dialogFragment;
        this.Ns = c0427a;
        m.inflate(context, R.layout.ksad_seconed_confirm_dialog_layout, this);
        this.Nr = findViewById(R.id.ksad_second_confirm_root_view);
    }

    private static Presenter aG() {
        Presenter presenter = new Presenter();
        presenter.a(new d());
        return presenter;
    }

    private c pf() {
        c cVar = new c();
        cVar.Nq = this.Nq;
        cVar.Ns = this.Ns;
        return cVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        Presenter aG = aG();
        aG.I(this.Nr);
        aG.k(pf());
    }
}
