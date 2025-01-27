package com.martian.libmars.widget.recyclerview.adatper;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import java.util.List;
import u9.a;

/* loaded from: classes3.dex */
public abstract class MultiItemRecycleViewAdapter<T> extends CommonRecycleViewAdapter<T> {

    /* renamed from: i */
    public final a<T> f12828i;

    public MultiItemRecycleViewAdapter(Context context, @NonNull a<T> aVar) {
        super(context, -1);
        this.f12828i = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return this.f12828i.a(i10, this.f12824e.get(i10));
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: q */
    public ViewHolderHelper onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        ViewHolderHelper b10 = ViewHolderHelper.b(this.f12822c, viewGroup, this.f12828i.b(i10));
        r(viewGroup, b10);
        return b10;
    }

    public MultiItemRecycleViewAdapter(Context context, List<T> list, @NonNull a<T> aVar) {
        super(context, -1, list);
        this.f12828i = aVar;
    }
}
