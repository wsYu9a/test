package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class d extends RecyclerView.Adapter<c> {
    private List<Presenter> MR = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.mPresenter.jW();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        c b2 = b(viewGroup, i2);
        this.MR.add(b2.mPresenter);
        return b2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i2) {
        cVar.mPresenter.f(cVar.Lj);
    }

    protected abstract c b(ViewGroup viewGroup, int i2);

    public final void oM() {
        Iterator<Presenter> it = this.MR.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        oM();
    }
}
