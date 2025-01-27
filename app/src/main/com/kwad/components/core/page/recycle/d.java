package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class d extends RecyclerView.Adapter<c> {
    private List<Presenter> Sc = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public c onCreateViewHolder(ViewGroup viewGroup, int i10) {
        c b10 = b(viewGroup, i10);
        this.Sc.add(b10.mPresenter);
        return b10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i10) {
        cVar.mPresenter.k(cVar.Qj);
    }

    public abstract c b(ViewGroup viewGroup, int i10);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        qK();
    }

    public final void qK() {
        Iterator<Presenter> it = this.Sc.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.mPresenter.mM();
    }
}
