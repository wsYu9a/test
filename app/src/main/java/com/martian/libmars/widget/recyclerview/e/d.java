package com.martian.libmars.widget.recyclerview.e;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class d<T> extends c<T> {

    /* renamed from: g */
    private final com.martian.libmars.widget.recyclerview.h.a<T> f10480g;

    public d(Context context, @NonNull com.martian.libmars.widget.recyclerview.h.a<T> multiItemTypeSupport) {
        super(context, -1);
        this.f10480g = multiItemTypeSupport;
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: L */
    public com.martian.libmars.widget.recyclerview.d onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        com.martian.libmars.widget.recyclerview.d b2 = com.martian.libmars.widget.recyclerview.d.b(this.f10474a, parent, this.f10480g.b(viewType));
        M(parent, b2);
        return b2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return this.f10480g.a(i2, this.f10476c.get(i2));
    }

    public d(Context context, List<T> datas, @NonNull com.martian.libmars.widget.recyclerview.h.a<T> multiItemTypeSupport) {
        super(context, -1, datas);
        this.f10480g = multiItemTypeSupport;
    }
}
