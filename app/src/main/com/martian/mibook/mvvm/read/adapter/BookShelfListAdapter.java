package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemBookFirendShelfBookBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.BookShelfListAdapter;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001-B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000bJ#\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ!\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BookShelfListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/BookShelfListAdapter$ViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", "", "m", "(Ljava/util/List;)V", "books", "j", "Landroid/view/ViewGroup;", "parent", "", "viewType", t.f11204d, "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/BookShelfListAdapter$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "k", "(Lcom/martian/mibook/mvvm/read/adapter/BookShelfListAdapter$ViewHolder;I)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "", "c", "Ljava/util/List;", "", "", "d", "Ljava/util/Set;", "sourceIdSet", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", e.TAG, "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBookShelfListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookShelfListAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/BookShelfListAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
/* loaded from: classes3.dex */
public final class BookShelfListAdapter extends RecyclerView.Adapter<ViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public List<TYBookItem> bookList;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Set<String> sourceIdSet = new HashSet();

    /* renamed from: e */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BookShelfListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemBookFirendShelfBookBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/BookShelfListAdapter;Lcom/martian/mibook/databinding/ItemBookFirendShelfBookBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "book", "", e.TAG, "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "b", "Lcom/martian/mibook/databinding/ItemBookFirendShelfBookBinding;", "f", "()Lcom/martian/mibook/databinding/ItemBookFirendShelfBookBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    @SuppressLint({"SetTextI18n"})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemBookFirendShelfBookBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BookShelfListAdapter f14410d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k BookShelfListAdapter bookShelfListAdapter, ItemBookFirendShelfBookBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14410d = bookShelfListAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.h

                /* renamed from: c */
                public final /* synthetic */ BookShelfListAdapter f1820c;

                public /* synthetic */ h(BookShelfListAdapter bookShelfListAdapter2) {
                    bookShelfListAdapter = bookShelfListAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfListAdapter.ViewHolder.c(BookShelfListAdapter.ViewHolder.this, bookShelfListAdapter, view);
                }
            });
            binding.llAddBookshelf.setOnClickListener(new View.OnClickListener() { // from class: cd.i

                /* renamed from: c */
                public final /* synthetic */ BookShelfListAdapter f1827c;

                public /* synthetic */ i(BookShelfListAdapter bookShelfListAdapter2) {
                    bookShelfListAdapter = bookShelfListAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfListAdapter.ViewHolder.d(BookShelfListAdapter.ViewHolder.this, bookShelfListAdapter, view);
                }
            });
        }

        public static final void c(ViewHolder this$0, BookShelfListAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                List list = this$1.bookList;
                i.H(activity, list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null);
            }
        }

        public static final void d(ViewHolder this$0, BookShelfListAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.bookList;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            this$0.binding.llAddBookshelf.setEnabled(false);
            this$0.binding.llAddBookshelf.setAlpha(0.5f);
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                MiConfigSingleton.b2().M1().g(activity, tYBookItem);
                if (tYBookItem != null) {
                    tYBookItem.setInBookStore(true);
                }
                t0.b(this$0.com.umeng.analytics.pro.f.X java.lang.String, "已加入书架");
            }
            this$0.binding.tvAddShelf.setText(ExtKt.c("已在书架"));
        }

        @SuppressLint({"SetTextI18n"})
        public final void e(@k TYBookItem book) {
            Intrinsics.checkNotNullParameter(book, "book");
            MiBookManager.u1(this.com.umeng.analytics.pro.f.X java.lang.String, book, this.binding.bookCover);
            this.binding.tvBookName.setText(ExtKt.c(book.getTitle()));
            this.binding.tvBookShortContent.setText(ExtKt.c(ba.l.y(book.getIntro())));
            if (!ba.l.q(book.getBookInfo())) {
                this.binding.tvBookCategory.setText(ExtKt.c(book.getBookInfo()));
            }
            TextView textView = this.binding.tvReadTime;
            Integer duration = book.getDuration();
            Intrinsics.checkNotNullExpressionValue(duration, "getDuration(...)");
            textView.setText(ExtKt.c("读了" + oe.f.a(duration.intValue())));
            if (book.isInBookStore()) {
                this.binding.tvAddShelf.setText(ExtKt.c("已在书架"));
                this.binding.llAddBookshelf.setEnabled(false);
                this.binding.llAddBookshelf.setAlpha(0.5f);
            } else {
                this.binding.tvAddShelf.setText(ExtKt.c("加入书架"));
                this.binding.llAddBookshelf.setEnabled(true);
                this.binding.llAddBookshelf.setAlpha(1.0f);
            }
        }

        @k
        /* renamed from: f, reason: from getter */
        public final ItemBookFirendShelfBookBinding getBinding() {
            return this.binding;
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
        List<TYBookItem> list = this.bookList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void j(@l List<? extends TYBookItem> books) {
        List<? extends TYBookItem> list = books;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.bookList == null) {
            this.bookList = new ArrayList();
        }
        List<TYBookItem> list2 = this.bookList;
        int size = list2 != null ? list2.size() : 0;
        List<TYBookItem> list3 = this.bookList;
        if (list3 != null) {
            list3.addAll(list);
        }
        notifyItemRangeInserted(size, books.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(@k ViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<TYBookItem> list = this.bookList;
        TYBookItem tYBookItem = list != null ? list.get(r32) : null;
        if (tYBookItem != null) {
            holder.e(tYBookItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: l */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int i10) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBookFirendShelfBookBinding inflate = ItemBookFirendShelfBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void m(@l List<? extends TYBookItem> bookList) {
        this.bookList = bookList != null ? CollectionsKt.toMutableList((Collection) bookList) : null;
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
        List<TYBookItem> list = this.bookList;
        if (list == null || list.isEmpty() || getPageSize() <= r92) {
            return;
        }
        List<TYBookItem> list2 = this.bookList;
        TYBookItem tYBookItem = list2 != null ? list2.get(r92) : null;
        if (tYBookItem == null || this.sourceIdSet.contains(tYBookItem.getSourceId())) {
            return;
        }
        if (r92 == 0) {
            Context context = recyclerView != null ? recyclerView.getContext() : null;
            ac.a.K(context, tYBookItem.getRecommend() + tYBookItem.getSource(), "展示");
        }
        Set<String> set = this.sourceIdSet;
        String sourceId = tYBookItem.getSourceId();
        Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
        set.add(sourceId);
        MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
    }
}
