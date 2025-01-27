package com.martian.libmars.widget.recyclerview.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.martian.libmars.widget.recyclerview.RefreshHeaderLayout;

/* loaded from: classes2.dex */
public class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    protected static final int f10481a = Integer.MIN_VALUE;

    /* renamed from: b */
    protected static final int f10482b = -2147483647;

    /* renamed from: c */
    protected static final int f10483c = 2147483646;

    /* renamed from: d */
    protected static final int f10484d = Integer.MAX_VALUE;

    /* renamed from: e */
    private final RecyclerView.Adapter f10485e;

    /* renamed from: f */
    private final RefreshHeaderLayout f10486f;

    /* renamed from: g */
    private final FrameLayout f10487g;

    /* renamed from: h */
    private final LinearLayout f10488h;

    /* renamed from: i */
    private final LinearLayout f10489i;

    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            e.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount) {
            e.this.notifyItemRangeChanged(positionStart + 2, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            e.this.notifyItemRangeInserted(positionStart + 2, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            e.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            e.this.notifyItemRangeRemoved(positionStart + 2, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            e.this.notifyItemRangeChanged(positionStart + 2, itemCount, payload);
        }
    }

    class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a */
        final /* synthetic */ RecyclerView f10491a;

        /* renamed from: b */
        final /* synthetic */ GridLayoutManager f10492b;

        b(final RecyclerView val$gridLayoutManager, final GridLayoutManager val$recyclerView) {
            this.f10491a = val$gridLayoutManager;
            this.f10492b = val$recyclerView;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            e eVar = (e) this.f10491a.getAdapter();
            if (eVar == null || !e.this.F(eVar.getItemViewType(position))) {
                return 1;
            }
            return this.f10492b.getSpanCount();
        }
    }

    static class c extends RecyclerView.ViewHolder {
        public c(View itemView) {
            super(itemView);
        }
    }

    static class d extends RecyclerView.ViewHolder {
        public d(View itemView) {
            super(itemView);
        }
    }

    /* renamed from: com.martian.libmars.widget.recyclerview.e.e$e */
    static class C0260e extends RecyclerView.ViewHolder {
        public C0260e(View itemView) {
            super(itemView);
        }
    }

    static class f extends RecyclerView.ViewHolder {
        public f(View itemView) {
            super(itemView);
        }
    }

    public e(RecyclerView.Adapter adapter, RefreshHeaderLayout refreshHeaderContainer, LinearLayout headerContainer, LinearLayout footerContainer, FrameLayout loadMoreFooterContainer) {
        this.f10485e = adapter;
        this.f10486f = refreshHeaderContainer;
        this.f10488h = headerContainer;
        this.f10489i = footerContainer;
        this.f10487g = loadMoreFooterContainer;
        adapter.registerAdapterDataObserver(new a());
    }

    public boolean F(int type) {
        return type == Integer.MIN_VALUE || type == f10482b || type == f10483c || type == Integer.MAX_VALUE;
    }

    public RecyclerView.Adapter E() {
        return this.f10485e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10485e.getItemCount() + 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return Integer.MIN_VALUE;
        }
        if (position == 1) {
            return f10482b;
        }
        if (1 < position && position < this.f10485e.getItemCount() + 2) {
            return this.f10485e.getItemViewType(position - 2);
        }
        if (position == this.f10485e.getItemCount() + 2) {
            return f10483c;
        }
        if (position == this.f10485e.getItemCount() + 3) {
            return Integer.MAX_VALUE;
        }
        throw new IllegalArgumentException("Wrong type! Position = " + position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new b(recyclerView, gridLayoutManager));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (1 >= position || position >= this.f10485e.getItemCount() + 2) {
            return;
        }
        this.f10485e.onBindViewHolder(holder, position - 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return viewType == Integer.MIN_VALUE ? new f(this.f10486f) : viewType == f10482b ? new d(this.f10488h) : viewType == f10483c ? new c(this.f10489i) : viewType == Integer.MAX_VALUE ? new C0260e(this.f10487g) : this.f10485e.onCreateViewHolder(parent, viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (F(getItemViewType(holder.getLayoutPosition()))) {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
    }
}
