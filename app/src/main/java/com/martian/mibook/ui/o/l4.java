package com.martian.mibook.ui.o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.ui.recybanner.BannerLayout;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class l4 extends RecyclerView.Adapter<a> {

    /* renamed from: a */
    private final com.martian.libmars.activity.j1 f14553a;

    /* renamed from: b */
    private final List<BookWrapper> f14554b;

    /* renamed from: c */
    private BannerLayout.d f14555c;

    static class a extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final ImageView f14556a;

        a(View itemView) {
            super(itemView);
            this.f14556a = (ImageView) itemView.findViewById(R.id.img_banner);
        }
    }

    public l4(com.martian.libmars.activity.j1 activity, List<BookWrapper> urlList) {
        this.f14553a = activity;
        this.f14554b = urlList;
    }

    /* renamed from: b */
    public /* synthetic */ void c(final int position, View v) {
        BannerLayout.d dVar = this.f14555c;
        if (dVar != null) {
            dVar.a(position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull a holder, final int position) {
        List<BookWrapper> list = this.f14554b;
        if (list == null || list.isEmpty()) {
            return;
        }
        MiBookManager.d2(this.f14553a, this.f14554b.get(position).book, holder.f14556a);
        holder.f14556a.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.v2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l4.this.c(position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new a(LayoutInflater.from(parent.getContext()).inflate(R.layout.similarity_item_banner, parent, false));
    }

    public void f(BannerLayout.d onBannerItemClickListener) {
        this.f14555c = onBannerItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<BookWrapper> list = this.f14554b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
