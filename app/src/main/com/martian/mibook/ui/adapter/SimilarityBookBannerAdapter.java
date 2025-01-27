package com.martian.mibook.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.ui.adapter.SimilarityBookBannerAdapter;
import com.martian.mibook.ui.recybanner.BannerLayout;
import java.util.List;

/* loaded from: classes3.dex */
public class SimilarityBookBannerAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: c */
    public final Activity f15875c;

    /* renamed from: d */
    public final List<BookWrapper> f15876d;

    /* renamed from: e */
    public BannerLayout.c f15877e;

    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: b */
        public final ImageView f15878b;

        public a(View view) {
            super(view);
            this.f15878b = (ImageView) view.findViewById(R.id.img_banner);
        }
    }

    public SimilarityBookBannerAdapter(Activity activity, List<BookWrapper> list) {
        this.f15875c = activity;
        this.f15876d = list;
    }

    public /* synthetic */ void j(int i10, View view) {
        BannerLayout.c cVar = this.f15877e;
        if (cVar != null) {
            cVar.a(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<BookWrapper> list = this.f15876d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(@NonNull a aVar, int i10) {
        List<BookWrapper> list = this.f15876d;
        if (list == null || list.isEmpty()) {
            return;
        }
        MiBookManager.s1(this.f15875c, this.f15876d.get(i10).book, aVar.f15878b);
        aVar.f15878b.setOnClickListener(new View.OnClickListener() { // from class: ce.o

            /* renamed from: c */
            public final /* synthetic */ int f1961c;

            public /* synthetic */ o(int i102) {
                i10 = i102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimilarityBookBannerAdapter.this.j(i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.similarity_item_banner, viewGroup, false));
    }

    public void m(BannerLayout.c cVar) {
        this.f15877e = cVar;
    }
}
