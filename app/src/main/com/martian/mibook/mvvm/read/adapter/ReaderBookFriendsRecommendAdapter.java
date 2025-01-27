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
import com.martian.mibook.databinding.ItemReaderBookFriendRecommendBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.ReaderBookFriendsRecommendAdapter;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u000256B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\t2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010 J!\u0010\"\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\"\u0010#R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter$ViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "readBooks", "", "o", "(Ljava/util/List;)V", "k", "Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter$a;", "onItemClickListener", "n", "(Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter$a;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "m", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, t.f11204d, "(Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter$ViewHolder;I)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "c", "Ljava/util/List;", "d", "Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter$a;", "", e.TAG, "Z", "isInitHandleCurrentVisibleItems", "", "", "f", "Ljava/util/Set;", "sourceIdSet", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "g", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "a", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderBookFriendsRecommendAdapter extends RecyclerView.Adapter<ViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public List<? extends TYBookItem> readBooks;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public a onItemClickListener;

    /* renamed from: e */
    public boolean isInitHandleCurrentVisibleItems;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Set<String> sourceIdSet = new HashSet();

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemReaderBookFriendRecommendBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReaderBookFriendsRecommendAdapter;Lcom/martian/mibook/databinding/ItemReaderBookFriendRecommendBinding;)V", "", "i", "()V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "tyBookItem", "g", "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "b", "Lcom/martian/mibook/databinding/ItemReaderBookFriendRecommendBinding;", "h", "()Lcom/martian/mibook/databinding/ItemReaderBookFriendRecommendBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemReaderBookFriendRecommendBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ ReaderBookFriendsRecommendAdapter f14453d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k ReaderBookFriendsRecommendAdapter readerBookFriendsRecommendAdapter, ItemReaderBookFriendRecommendBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14453d = readerBookFriendsRecommendAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.ivBookCover.setOnClickListener(new View.OnClickListener() { // from class: cd.z
                public /* synthetic */ z() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookFriendsRecommendAdapter.ViewHolder.d(ReaderBookFriendsRecommendAdapter.ViewHolder.this, view);
                }
            });
            binding.tvAddBookShelf.setOnClickListener(new View.OnClickListener() { // from class: cd.a0

                /* renamed from: c */
                public final /* synthetic */ ReaderBookFriendsRecommendAdapter f1772c;

                public /* synthetic */ a0(ReaderBookFriendsRecommendAdapter readerBookFriendsRecommendAdapter2) {
                    readerBookFriendsRecommendAdapter = readerBookFriendsRecommendAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookFriendsRecommendAdapter.ViewHolder.e(ReaderBookFriendsRecommendAdapter.ViewHolder.this, readerBookFriendsRecommendAdapter, view);
                }
            });
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.b0
                public /* synthetic */ b0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderBookFriendsRecommendAdapter.ViewHolder.f(ReaderBookFriendsRecommendAdapter.ViewHolder.this, view);
                }
            });
        }

        public static final void d(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i();
        }

        public static final void e(ViewHolder this$0, ReaderBookFriendsRecommendAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.readBooks;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            a aVar = this$1.onItemClickListener;
            if (aVar != null) {
                TextView tvAddBookShelf = this$0.binding.tvAddBookShelf;
                Intrinsics.checkNotNullExpressionValue(tvAddBookShelf, "tvAddBookShelf");
                aVar.a(tYBookItem, tvAddBookShelf);
            }
        }

        public static final void f(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i();
        }

        private final void i() {
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition >= this.f14453d.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            Context context = this.com.umeng.analytics.pro.f.X java.lang.String;
            if (context instanceof Activity) {
                ac.a.y(context, "书尾页-阅读");
                List list = this.f14453d.readBooks;
                i.R((Activity) this.com.umeng.analytics.pro.f.X java.lang.String, list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void g(@k TYBookItem tyBookItem) {
            Intrinsics.checkNotNullParameter(tyBookItem, "tyBookItem");
            MiBookManager.v1(this.com.umeng.analytics.pro.f.X java.lang.String, tyBookItem.getCover(), false, this.binding.ivBookCover);
            ReaderThemeTextView readerThemeTextView = this.binding.tvBookName;
            String bookName = tyBookItem.getBookName();
            readerThemeTextView.setText(bookName != null ? ExtKt.c(bookName) : null);
            this.binding.tvAddBookShelf.setVisibility(tyBookItem.isInBookStore() ? 8 : 0);
            TextView textView = this.binding.tvReadTime;
            Integer duration = tyBookItem.getDuration();
            textView.setText(oe.f.a(duration != null ? duration.intValue() : 0));
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }

        @k
        /* renamed from: h, reason: from getter */
        public final ItemReaderBookFriendRecommendBinding getBinding() {
            return this.binding;
        }
    }

    public interface a {
        void a(@l TYBookItem tYBookItem, @k TextView textView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<? extends TYBookItem> list = this.readBooks;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void k() {
        RecyclerViewExposeManager recyclerViewExposeManager;
        if (this.isInitHandleCurrentVisibleItems || (recyclerViewExposeManager = this.recyclerViewExposeManager) == null) {
            return;
        }
        RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(@k ViewHolder holder, int i10) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends TYBookItem> list = this.readBooks;
        TYBookItem tYBookItem = list != null ? list.get(i10) : null;
        if (tYBookItem != null) {
            holder.g(tYBookItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: m */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemReaderBookFriendRecommendBinding inflate = ItemReaderBookFriendRecommendBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    public final void n(@k a onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void o(@l List<? extends TYBookItem> readBooks) {
        this.readBooks = readBooks;
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
        List<? extends TYBookItem> list;
        TYBookItem tYBookItem;
        List<? extends TYBookItem> list2 = this.readBooks;
        if (list2 == null || list2.isEmpty() || getPageSize() <= r92 || (list = this.readBooks) == null || (tYBookItem = list.get(r92)) == null) {
            return;
        }
        Set<String> set = this.sourceIdSet;
        String sourceId = tYBookItem.getSourceId();
        Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
        if (set.add(sourceId)) {
            if (r92 == 0) {
                Context context = recyclerView != null ? recyclerView.getContext() : null;
                ac.a.K(context, tYBookItem.getRecommend() + tYBookItem.getSource(), "展示");
            }
            MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
        }
    }
}
