package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.databinding.ItemSimilarityBookBannerBinding;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.SimilarityBookBannerAdapter;
import id.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\b2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter$ViewHolder;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookList", "", t.f11204d, "(Ljava/util/List;)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter$a;", "onItemClickListener", "m", "(Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter$a;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "k", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "j", "(Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter$ViewHolder;I)V", "c", "Ljava/util/List;", "d", "Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter$a;", "a", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SimilarityBookBannerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public List<? extends BookWrapper> bookList;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public a onItemClickListener;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemSimilarityBookBannerBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/SimilarityBookBannerAdapter;Lcom/martian/mibook/databinding/ItemSimilarityBookBannerBinding;)V", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrapper", "", "c", "(Lcom/martian/mibook/lib/model/data/BookWrapper;)V", "b", "Lcom/martian/mibook/databinding/ItemSimilarityBookBannerBinding;", "d", "()Lcom/martian/mibook/databinding/ItemSimilarityBookBannerBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemSimilarityBookBannerBinding binding;

        /* renamed from: c */
        public final /* synthetic */ SimilarityBookBannerAdapter f15526c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k SimilarityBookBannerAdapter similarityBookBannerAdapter, ItemSimilarityBookBannerBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15526c = similarityBookBannerAdapter;
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.x

                /* renamed from: c */
                public final /* synthetic */ SimilarityBookBannerAdapter.ViewHolder f30855c;

                public /* synthetic */ x(SimilarityBookBannerAdapter.ViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimilarityBookBannerAdapter.ViewHolder.b(SimilarityBookBannerAdapter.this, this, view);
                }
            });
        }

        public static final void b(SimilarityBookBannerAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            a aVar = this$0.onItemClickListener;
            if (aVar != null) {
                aVar.a(view, this$1.getBindingAdapterPosition());
            }
        }

        public final void c(@l BookWrapper bookWrapper) {
            Book book;
            Book book2;
            String bookName;
            this.binding.tvBookName.setVisibility(8);
            if (bookWrapper != null && (book = bookWrapper.book) != null && book.isLocal() && (book2 = bookWrapper.book) != null && (bookName = book2.getBookName()) != null) {
                this.binding.tvBookName.setVisibility(0);
                this.binding.tvBookName.setText(ExtKt.c(bookName));
            }
            MiBookManager.u1(this.binding.getRoot().getContext(), bookWrapper != null ? bookWrapper.book : null, this.binding.bookCover);
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ItemSimilarityBookBannerBinding getBinding() {
            return this.binding;
        }
    }

    public interface a {
        void a(@l View view, int i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<? extends BookWrapper> list = this.bookList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@k ViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends BookWrapper> list = this.bookList;
        holder.c(list != null ? list.get(r32) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: k */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSimilarityBookBannerBinding inflate = ItemSimilarityBookBannerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void l(@l List<? extends BookWrapper> list) {
        this.bookList = list;
        notifyDataSetChanged();
    }

    public final void m(@k a onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
    }
}
