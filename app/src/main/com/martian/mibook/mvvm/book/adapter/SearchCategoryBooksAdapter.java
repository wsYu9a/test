package com.martian.mibook.mvvm.book.adapter;

import ac.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemCategoryTagBookBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.book.adapter.SearchCategoryBooksAdapter;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001*B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\b2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/martian/mibook/mvvm/book/adapter/SearchCategoryBooksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/book/adapter/SearchCategoryBooksAdapter$BookViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", t.f11204d, "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "k", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/book/adapter/SearchCategoryBooksAdapter$BookViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "j", "(Lcom/martian/mibook/mvvm/book/adapter/SearchCategoryBooksAdapter$BookViewHolder;I)V", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "c", "Ljava/util/List;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "d", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "", "", e.TAG, "Ljava/util/Set;", "sourceIdSet", "BookViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SearchCategoryBooksAdapter extends RecyclerView.Adapter<BookViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public List<? extends TYBookItem> bookList;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    /* renamed from: e */
    @k
    public final Set<String> sourceIdSet = new HashSet();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/martian/mibook/mvvm/book/adapter/SearchCategoryBooksAdapter$BookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemCategoryTagBookBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/book/adapter/SearchCategoryBooksAdapter;Lcom/martian/mibook/databinding/ItemCategoryTagBookBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "book", "", e.TAG, "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "g", "()V", "b", "Lcom/martian/mibook/databinding/ItemCategoryTagBookBinding;", "f", "()Lcom/martian/mibook/databinding/ItemCategoryTagBookBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class BookViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemCategoryTagBookBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ SearchCategoryBooksAdapter f14126d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BookViewHolder(@k SearchCategoryBooksAdapter searchCategoryBooksAdapter, ItemCategoryTagBookBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14126d = searchCategoryBooksAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.ivBookCover.setOnClickListener(new View.OnClickListener() { // from class: nc.e
                public /* synthetic */ e() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchCategoryBooksAdapter.BookViewHolder.c(SearchCategoryBooksAdapter.BookViewHolder.this, view);
                }
            });
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: nc.f
                public /* synthetic */ f() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchCategoryBooksAdapter.BookViewHolder.d(SearchCategoryBooksAdapter.BookViewHolder.this, view);
                }
            });
        }

        public static final void c(BookViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.g();
        }

        public static final void d(BookViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.g();
        }

        @SuppressLint({"SetTextI18n"})
        public final void e(@l TYBookItem tYBookItem) {
            String bookName;
            MiBookManager.u1(this.com.umeng.analytics.pro.f.X java.lang.String, tYBookItem, this.binding.ivBookCover);
            this.binding.tvBookName.setText((tYBookItem == null || (bookName = tYBookItem.getBookName()) == null) ? null : ExtKt.c(bookName));
            if ((tYBookItem != null ? Integer.valueOf(tYBookItem.getScore()) : null) == null || tYBookItem.getScore() <= 0) {
                if (TextUtils.isEmpty(tYBookItem != null ? tYBookItem.getRecTitle() : null)) {
                    this.binding.tvBookCategory.setVisibility(8);
                } else {
                    this.binding.tvBookCategory.setVisibility(0);
                    this.binding.tvBookCategory.setText(ExtKt.c(tYBookItem != null ? tYBookItem.getRecTitle() : null));
                }
                this.binding.tvBookScore.setVisibility(8);
                return;
            }
            this.binding.tvBookCategory.setVisibility(8);
            this.binding.tvBookScore.setVisibility(0);
            TextView textView = this.binding.tvBookScore;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(tYBookItem.getScore() / 10.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format + "分");
        }

        @k
        /* renamed from: f, reason: from getter */
        public final ItemCategoryTagBookBinding getBinding() {
            return this.binding;
        }

        public final void g() {
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition >= this.f14126d.getPageSize() || bindingAdapterPosition < 0 || !(this.com.umeng.analytics.pro.f.X java.lang.String instanceof Activity)) {
                return;
            }
            List list = this.f14126d.bookList;
            i.H((Activity) this.com.umeng.analytics.pro.f.X java.lang.String, list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null);
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<? extends TYBookItem> list = this.bookList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@k BookViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends TYBookItem> list = this.bookList;
        holder.e(list != null ? list.get(r32) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: k */
    public BookViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemCategoryTagBookBinding inflate = ItemCategoryTagBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BookViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void l(@l List<? extends TYBookItem> list) {
        this.bookList = list;
        notifyDataSetChanged();
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        if (this.recyclerViewExposeManager == null) {
            this.recyclerViewExposeManager = new RecyclerViewExposeManager();
        }
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            recyclerViewExposeManager.setRecyclerItemExposeListener(recyclerView, this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            recyclerViewExposeManager.removeRecyclerItemExposeListener();
        }
    }

    @Override // com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.OnItemExposeListener
    public void onItemViewVisible(int r92, @l RecyclerView recyclerView) {
        List<? extends TYBookItem> list = this.bookList;
        if (list == null || list.isEmpty() || getPageSize() <= r92) {
            return;
        }
        List<? extends TYBookItem> list2 = this.bookList;
        TYBookItem tYBookItem = list2 != null ? list2.get(r92) : null;
        if (tYBookItem == null || this.sourceIdSet.contains(tYBookItem.getSourceId())) {
            return;
        }
        if (r92 == 0) {
            Context context = recyclerView != null ? recyclerView.getContext() : null;
            a.K(context, tYBookItem.getRecommend() + tYBookItem.getSource(), "展示");
        }
        Set<String> set = this.sourceIdSet;
        String sourceId = tYBookItem.getSourceId();
        Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
        set.add(sourceId);
        MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
    }
}
