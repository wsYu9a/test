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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemBookFriendsRecommendBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.BookFriendsRecommendAdapter;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0003678B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001e\u001a\u00020\u000b2\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#J!\u0010%\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b%\u0010&R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$ViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "readBooks", "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$ViewType;", "viewType", "", "p", "(Ljava/util/List;Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$ViewType;)V", "", "bookIndex", t.f11204d, "(I)V", "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$a;", "onClickListener", "o", "(Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$a;)V", "Landroid/view/ViewGroup;", "parent", "n", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "m", "(Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$ViewHolder;I)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "c", "Ljava/util/List;", "d", "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$ViewType;", e.TAG, "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$a;", "", "", "f", "Ljava/util/Set;", "sourceIdSet", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "g", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "a", "ViewHolder", "ViewType", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookFriendsRecommendAdapter extends RecyclerView.Adapter<ViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public List<? extends TYBookItem> readBooks;

    /* renamed from: e */
    @l
    public a onClickListener;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public ViewType viewType = ViewType.TYPE_PAGE_RECOMMEND;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Set<String> sourceIdSet = new HashSet();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemBookFriendsRecommendBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter;Lcom/martian/mibook/databinding/ItemBookFriendsRecommendBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "tyBookItem", "", "i", "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "k", "()V", "b", "Lcom/martian/mibook/databinding/ItemBookFriendsRecommendBinding;", "j", "()Lcom/martian/mibook/databinding/ItemBookFriendsRecommendBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemBookFriendsRecommendBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BookFriendsRecommendAdapter f14393d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k BookFriendsRecommendAdapter bookFriendsRecommendAdapter, ItemBookFriendsRecommendBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14393d = bookFriendsRecommendAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.ivBookCover.setOnClickListener(new View.OnClickListener() { // from class: cd.b
                public /* synthetic */ b() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookFriendsRecommendAdapter.ViewHolder.e(BookFriendsRecommendAdapter.ViewHolder.this, view);
                }
            });
            binding.tvAddBookShelf.setOnClickListener(new View.OnClickListener() { // from class: cd.c

                /* renamed from: c */
                public final /* synthetic */ BookFriendsRecommendAdapter f1784c;

                public /* synthetic */ c(BookFriendsRecommendAdapter bookFriendsRecommendAdapter2) {
                    bookFriendsRecommendAdapter = bookFriendsRecommendAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookFriendsRecommendAdapter.ViewHolder.f(BookFriendsRecommendAdapter.ViewHolder.this, bookFriendsRecommendAdapter, view);
                }
            });
            binding.llAddBookshelf.setOnClickListener(new View.OnClickListener() { // from class: cd.d

                /* renamed from: c */
                public final /* synthetic */ BookFriendsRecommendAdapter f1792c;

                public /* synthetic */ d(BookFriendsRecommendAdapter bookFriendsRecommendAdapter2) {
                    bookFriendsRecommendAdapter = bookFriendsRecommendAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookFriendsRecommendAdapter.ViewHolder.g(BookFriendsRecommendAdapter.ViewHolder.this, bookFriendsRecommendAdapter, view);
                }
            });
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.e
                public /* synthetic */ e() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookFriendsRecommendAdapter.ViewHolder.h(BookFriendsRecommendAdapter.ViewHolder.this, view);
                }
            });
        }

        public static final void e(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.k();
        }

        public static final void f(ViewHolder this$0, BookFriendsRecommendAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.readBooks;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            a aVar = this$1.onClickListener;
            if (aVar != null) {
                TextView tvAddBookShelf = this$0.binding.tvAddBookShelf;
                Intrinsics.checkNotNullExpressionValue(tvAddBookShelf, "tvAddBookShelf");
                aVar.a(tYBookItem, tvAddBookShelf, this$1.viewType);
            }
        }

        public static final void g(ViewHolder this$0, BookFriendsRecommendAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.readBooks;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            this$0.binding.llAddBookshelf.setEnabled(false);
            this$0.binding.llAddBookshelf.setAlpha(0.5f);
            a aVar = this$1.onClickListener;
            if (aVar != null) {
                ThemeTextView tvAddShelf = this$0.binding.tvAddShelf;
                Intrinsics.checkNotNullExpressionValue(tvAddShelf, "tvAddShelf");
                aVar.a(tYBookItem, tvAddShelf, this$1.viewType);
            }
        }

        public static final void h(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.k();
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }

        @SuppressLint({"SetTextI18n"})
        public final void i(@k TYBookItem tyBookItem) {
            Intrinsics.checkNotNullParameter(tyBookItem, "tyBookItem");
            MiBookManager.v1(this.com.umeng.analytics.pro.f.X java.lang.String, tyBookItem.getCover(), false, this.binding.ivBookCover);
            ThemeTextView themeTextView = this.binding.tvBookName;
            String bookName = tyBookItem.getBookName();
            themeTextView.setText(bookName != null ? ExtKt.c(bookName) : null);
            TextView textView = this.binding.tvReadTime;
            Integer duration = tyBookItem.getDuration();
            textView.setText(oe.f.a(duration == null ? 0 : duration.intValue()));
            if (this.f14393d.viewType != ViewType.TYPE_DIALOG_RECOMMEND) {
                this.binding.llAddBookshelf.setVisibility(8);
                this.binding.tvAddBookShelf.setVisibility(tyBookItem.isInBookStore() ? 8 : 0);
                return;
            }
            this.binding.tvAddBookShelf.setVisibility(8);
            this.binding.llAddBookshelf.setVisibility(0);
            if (tyBookItem.isInBookStore()) {
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
        /* renamed from: j, reason: from getter */
        public final ItemBookFriendsRecommendBinding getBinding() {
            return this.binding;
        }

        public final void k() {
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition >= this.f14393d.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            Context context = this.com.umeng.analytics.pro.f.X java.lang.String;
            if (context instanceof Activity) {
                ac.a.y(context, "退出弹窗-阅读");
                List list = this.f14393d.readBooks;
                i.R((Activity) this.com.umeng.analytics.pro.f.X java.lang.String, list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter$ViewType;", "", "(Ljava/lang/String;I)V", "TYPE_DIALOG_RECOMMEND", "TYPE_PAGE_RECOMMEND", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewType extends Enum<ViewType> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ViewType[] $VALUES;
        public static final ViewType TYPE_DIALOG_RECOMMEND = new ViewType("TYPE_DIALOG_RECOMMEND", 0);
        public static final ViewType TYPE_PAGE_RECOMMEND = new ViewType("TYPE_PAGE_RECOMMEND", 1);

        private static final /* synthetic */ ViewType[] $values() {
            return new ViewType[]{TYPE_DIALOG_RECOMMEND, TYPE_PAGE_RECOMMEND};
        }

        static {
            ViewType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private ViewType(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<ViewType> getEntries() {
            return $ENTRIES;
        }

        public static ViewType valueOf(String str) {
            return (ViewType) Enum.valueOf(ViewType.class, str);
        }

        public static ViewType[] values() {
            return (ViewType[]) $VALUES.clone();
        }
    }

    public interface a {
        void a(@l TYBookItem tYBookItem, @k TextView textView, @k ViewType viewType);
    }

    public static /* synthetic */ void q(BookFriendsRecommendAdapter bookFriendsRecommendAdapter, List list, ViewType viewType, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            viewType = ViewType.TYPE_PAGE_RECOMMEND;
        }
        bookFriendsRecommendAdapter.p(list, viewType);
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

    public final void l(int i10) {
        notifyItemChanged(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@k ViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends TYBookItem> list = this.readBooks;
        TYBookItem tYBookItem = list != null ? list.get(r32) : null;
        if (tYBookItem != null) {
            holder.i(tYBookItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: n */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBookFriendsRecommendBinding inflate = ItemBookFriendsRecommendBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    public final void o(@k a onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.onClickListener = onClickListener;
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

    @SuppressLint({"NotifyDataSetChanged"})
    public final void p(@l List<? extends TYBookItem> readBooks, @k ViewType viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        this.readBooks = readBooks;
        this.viewType = viewType;
        notifyDataSetChanged();
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
        }
    }
}
