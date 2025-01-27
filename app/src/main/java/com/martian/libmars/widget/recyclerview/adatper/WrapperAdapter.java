package com.martian.libmars.widget.recyclerview.adatper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.martian.libmars.widget.recyclerview.RefreshHeaderLayout;

/* loaded from: classes3.dex */
public class WrapperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: h */
    public static final int f12829h = Integer.MIN_VALUE;

    /* renamed from: i */
    public static final int f12830i = -2147483647;

    /* renamed from: j */
    public static final int f12831j = 2147483646;

    /* renamed from: k */
    public static final int f12832k = Integer.MAX_VALUE;

    /* renamed from: c */
    public final RecyclerView.Adapter f12833c;

    /* renamed from: d */
    public final RefreshHeaderLayout f12834d;

    /* renamed from: e */
    public final FrameLayout f12835e;

    /* renamed from: f */
    public final LinearLayout f12836f;

    /* renamed from: g */
    public final LinearLayout f12837g;

    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            WrapperAdapter.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11) {
            WrapperAdapter.this.notifyItemRangeChanged(i10 + 2, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i10, int i11) {
            WrapperAdapter.this.notifyItemRangeInserted(i10 + 2, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i10, int i11, int i12) {
            WrapperAdapter.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i10, int i11) {
            WrapperAdapter.this.notifyItemRangeRemoved(i10 + 2, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            WrapperAdapter.this.notifyItemRangeChanged(i10 + 2, i11, obj);
        }
    }

    public class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a */
        public final /* synthetic */ RecyclerView f12839a;

        /* renamed from: b */
        public final /* synthetic */ GridLayoutManager f12840b;

        public b(RecyclerView recyclerView, GridLayoutManager gridLayoutManager) {
            this.f12839a = recyclerView;
            this.f12840b = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i10) {
            WrapperAdapter wrapperAdapter = (WrapperAdapter) this.f12839a.getAdapter();
            if (wrapperAdapter == null || !WrapperAdapter.this.k(wrapperAdapter.getItemViewType(i10))) {
                return 1;
            }
            return this.f12840b.getSpanCount();
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        public c(View view) {
            super(view);
        }
    }

    public static class d extends RecyclerView.ViewHolder {
        public d(View view) {
            super(view);
        }
    }

    public static class e extends RecyclerView.ViewHolder {
        public e(View view) {
            super(view);
        }
    }

    public static class f extends RecyclerView.ViewHolder {
        public f(View view) {
            super(view);
        }
    }

    public WrapperAdapter(RecyclerView.Adapter adapter, RefreshHeaderLayout refreshHeaderLayout, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout) {
        this.f12833c = adapter;
        this.f12834d = refreshHeaderLayout;
        this.f12836f = linearLayout;
        this.f12837g = linearLayout2;
        this.f12835e = frameLayout;
        adapter.registerAdapterDataObserver(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.f12833c.getPageSize() + 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (i10 == 0) {
            return Integer.MIN_VALUE;
        }
        if (i10 == 1) {
            return -2147483647;
        }
        return (1 >= i10 || i10 >= this.f12833c.getPageSize() + 2) ? i10 == this.f12833c.getPageSize() + 2 ? f12831j : i10 == this.f12833c.getPageSize() + 3 ? Integer.MAX_VALUE : 0 : this.f12833c.getItemViewType(i10 - 2);
    }

    public RecyclerView.Adapter j() {
        return this.f12833c;
    }

    public final boolean k(int i10) {
        return i10 == Integer.MIN_VALUE || i10 == -2147483647 || i10 == 2147483646 || i10 == Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new b(recyclerView, gridLayoutManager));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        if (1 >= i10 || i10 >= this.f12833c.getPageSize() + 2) {
            return;
        }
        this.f12833c.onBindViewHolder(viewHolder, i10 - 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return i10 == Integer.MIN_VALUE ? new f(this.f12834d) : i10 == -2147483647 ? new d(this.f12836f) : i10 == 2147483646 ? new c(this.f12837g) : i10 == Integer.MAX_VALUE ? new e(this.f12835e) : this.f12833c.onCreateViewHolder(viewGroup, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (k(getItemViewType(viewHolder.getLayoutPosition()))) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
    }
}
