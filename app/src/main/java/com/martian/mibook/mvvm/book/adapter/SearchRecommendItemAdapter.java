package com.martian.mibook.mvvm.book.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.databinding.SearchRecommendItemBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.book.adapter.SearchRecommendItemAdapter;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter$ViewHolder;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "books", "", "keyword", "", "o", "(Ljava/util/List;Ljava/lang/String;)V", "clear", "Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter$a;", "onItemClickListener", "p", "(Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter$a;)V", "", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "n", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter$ViewHolder;", "holder", c.f26972i, "m", "(Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter$ViewHolder;I)V", "Landroid/content/Context;", f.X, "name", "Landroid/text/SpannableString;", t.f11204d, "(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableString;", "c", "Ljava/util/List;", "d", "Ljava/lang/String;", e.TAG, "Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter$a;", "a", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SearchRecommendItemAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public List<? extends TYBookItem> books;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public String keyword;

    /* renamed from: e */
    @l
    public a onItemClickListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/SearchRecommendItemBinding;", "itemBinding", "<init>", "(Lcom/martian/mibook/mvvm/book/adapter/SearchRecommendItemAdapter;Lcom/martian/mibook/databinding/SearchRecommendItemBinding;)V", "b", "Lcom/martian/mibook/databinding/SearchRecommendItemBinding;", "c", "()Lcom/martian/mibook/databinding/SearchRecommendItemBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final SearchRecommendItemBinding itemBinding;

        /* renamed from: c */
        public final /* synthetic */ SearchRecommendItemAdapter f14131c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k SearchRecommendItemAdapter searchRecommendItemAdapter, SearchRecommendItemBinding itemBinding) {
            super(itemBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemBinding, "itemBinding");
            this.f14131c = searchRecommendItemAdapter;
            this.itemBinding = itemBinding;
            itemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: nc.g

                /* renamed from: c */
                public final /* synthetic */ SearchRecommendItemAdapter.ViewHolder f28852c;

                public /* synthetic */ g(SearchRecommendItemAdapter.ViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchRecommendItemAdapter.ViewHolder.b(SearchRecommendItemAdapter.this, this, view);
                }
            });
        }

        public static final void b(SearchRecommendItemAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!TextUtils.isEmpty(this$0.keyword) && this$1.getBindingAdapterPosition() >= 0 && this$1.getBindingAdapterPosition() < this$0.getPageSize()) {
                List list = this$0.books;
                TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(this$1.getBindingAdapterPosition()) : null;
                a aVar = this$0.onItemClickListener;
                if (aVar != null) {
                    String str = this$0.keyword;
                    Intrinsics.checkNotNull(str);
                    aVar.a(tYBookItem, str);
                }
            }
        }

        @k
        /* renamed from: c, reason: from getter */
        public final SearchRecommendItemBinding getItemBinding() {
            return this.itemBinding;
        }
    }

    public interface a {
        void a(@l TYBookItem tYBookItem, @k String str);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void clear() {
        List<? extends TYBookItem> list = this.books;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.books = null;
        this.keyword = null;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<? extends TYBookItem> list = this.books;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final SpannableString l(Context context, String str) {
        String str2 = this.keyword;
        if (str2 == null) {
            str2 = "";
        }
        SpannableString m10 = ba.l.m(context, str, str2, R.color.theme_default);
        Intrinsics.checkNotNullExpressionValue(m10, "getSpannableString(...)");
        return m10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@k ViewHolder holder, int r13) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends TYBookItem> list = this.books;
        TYBookItem tYBookItem = list != null ? list.get(r13) : null;
        SearchRecommendItemBinding itemBinding = holder.getItemBinding();
        if (tYBookItem != null) {
            if (!TextUtils.isEmpty(tYBookItem.getBookName())) {
                String bookName = tYBookItem.getBookName();
                Intrinsics.checkNotNullExpressionValue(bookName, "getBookName(...)");
                String str = this.keyword;
                if (str == null) {
                    str = "";
                }
                if (StringsKt.contains$default((CharSequence) bookName, (CharSequence) str, false, 2, (Object) null)) {
                    itemBinding.scRcLogo.setImageResource(com.martian.mibook.R.drawable.page_mode);
                    ThemeTextView themeTextView = itemBinding.scRcTitle;
                    Context context = holder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    String bookName2 = tYBookItem.getBookName();
                    Intrinsics.checkNotNullExpressionValue(bookName2, "getBookName(...)");
                    themeTextView.setText(l(context, bookName2));
                    itemBinding.tvTagType.setVisibility(8);
                    return;
                }
            }
            if (!TextUtils.isEmpty(tYBookItem.getAuthor())) {
                String author = tYBookItem.getAuthor();
                Intrinsics.checkNotNullExpressionValue(author, "getAuthor(...)");
                String str2 = this.keyword;
                if (StringsKt.contains$default((CharSequence) author, (CharSequence) (str2 != null ? str2 : ""), false, 2, (Object) null)) {
                    itemBinding.scRcLogo.setImageResource(com.martian.mibook.R.drawable.search_author_icon);
                    ThemeTextView themeTextView2 = itemBinding.scRcTitle;
                    Context context2 = holder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    String author2 = tYBookItem.getAuthor();
                    Intrinsics.checkNotNullExpressionValue(author2, "getAuthor(...)");
                    themeTextView2.setText(l(context2, author2));
                    itemBinding.tvTagType.setVisibility(0);
                    return;
                }
            }
            itemBinding.scRcLogo.setImageResource(com.martian.mibook.R.drawable.page_mode);
            ThemeTextView themeTextView3 = itemBinding.scRcTitle;
            Context context3 = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            String bookName3 = tYBookItem.getBookName();
            Intrinsics.checkNotNullExpressionValue(bookName3, "getBookName(...)");
            themeTextView3.setText(l(context3, bookName3));
            itemBinding.tvTagType.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: n */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SearchRecommendItemBinding inflate = SearchRecommendItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void o(@l List<? extends TYBookItem> books, @l String keyword) {
        this.books = books;
        this.keyword = keyword;
        notifyDataSetChanged();
    }

    public final void p(@l a onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
