package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes3.dex */
public final class c extends RecyclerView.ViewHolder {
    public final e Qj;
    public final Presenter mPresenter;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.Qj = eVar;
        this.mPresenter = presenter;
        presenter.I(view);
    }
}
