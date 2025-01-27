package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import ba.l;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.databinding.ItemGridBookBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.GridBookAdapter;
import id.c;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import je.i;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import xi.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00060\u00060\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter$BookViewHolder;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "newData", "", "o", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "n", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter$BookViewHolder;", "holder", c.f26972i, "m", "(Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter$BookViewHolder;I)V", "getItemCount", "()I", "", "getItemId", "(I)J", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "c", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "d", "BookViewHolder", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class GridBookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e */
    public static int f15506e = 4;

    /* renamed from: f */
    public static int f15507f = 2;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final AsyncListDiffer<TYBookItem> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<TYBookItem>() { // from class: com.martian.mibook.mvvm.yuewen.adapter.GridBookAdapter$mDiffer$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a */
        public boolean areContentsTheSame(@k TYBookItem oldItem, @k TYBookItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getBookId(), newItem.getBookId()) && Intrinsics.areEqual(oldItem.getBookName(), newItem.getBookName()) && Intrinsics.areEqual(oldItem.getRecommendId(), newItem.getRecommendId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@k TYBookItem oldItem, @k TYBookItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter$BookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemGridBookBinding;", "bookBinding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter;Lcom/martian/mibook/databinding/ItemGridBookBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "tyBookItem", "", c.f26972i, "", "c", "(Lcom/martian/mibook/lib/model/data/TYBookItem;I)V", "b", "Lcom/martian/mibook/databinding/ItemGridBookBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class BookViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemGridBookBinding bookBinding;

        /* renamed from: c */
        public final /* synthetic */ GridBookAdapter f15510c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BookViewHolder(@k GridBookAdapter gridBookAdapter, ItemGridBookBinding bookBinding) {
            super(bookBinding.getRoot());
            Intrinsics.checkNotNullParameter(bookBinding, "bookBinding");
            this.f15510c = gridBookAdapter;
            this.bookBinding = bookBinding;
            bookBinding.getRoot().setPadding(bookBinding.getRoot().getPaddingLeft(), getBindingAdapterPosition() < GridBookAdapter.INSTANCE.a() ? 0 : bookBinding.getRoot().getPaddingTop(), bookBinding.getRoot().getPaddingRight(), bookBinding.getRoot().getPaddingBottom());
        }

        public static final void d(Context context, TYBookItem tyBookItem, View view) {
            Intrinsics.checkNotNullParameter(tyBookItem, "$tyBookItem");
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                i.H(activity, tyBookItem);
            }
        }

        public static final void e(Context context, TYBookItem tyBookItem, View view) {
            Intrinsics.checkNotNullParameter(tyBookItem, "$tyBookItem");
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                i.H(activity, tyBookItem);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void c(@k TYBookItem tyBookItem, int r10) {
            Intrinsics.checkNotNullParameter(tyBookItem, "tyBookItem");
            Context context = this.bookBinding.getRoot().getContext();
            MiBookManager.u1(context, tyBookItem, this.bookBinding.bookCover);
            this.bookBinding.bsGridBookName.setText(ExtKt.c(tyBookItem.getTitle()));
            if (tyBookItem.getScore() > 0) {
                this.bookBinding.bsGridBookCategory.setVisibility(8);
                this.bookBinding.bsBookScore.setVisibility(0);
                TextView textView = this.bookBinding.bsBookScore;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(tyBookItem.getScore() / 10.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format + "分");
            } else {
                if (l.q(tyBookItem.getRecTitle())) {
                    this.bookBinding.bsGridBookCategory.setVisibility(8);
                } else {
                    this.bookBinding.bsGridBookCategory.setVisibility(0);
                    this.bookBinding.bsGridBookCategory.setText(ExtKt.c(tyBookItem.getRecTitle()));
                }
                this.bookBinding.bsBookScore.setVisibility(8);
            }
            this.bookBinding.bookCover.setOnClickListener(new View.OnClickListener() { // from class: td.s

                /* renamed from: b */
                public final /* synthetic */ Context f30842b;

                /* renamed from: c */
                public final /* synthetic */ TYBookItem f30843c;

                public /* synthetic */ s(Context context2, TYBookItem tyBookItem2) {
                    context = context2;
                    tyBookItem = tyBookItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GridBookAdapter.BookViewHolder.d(context, tyBookItem, view);
                }
            });
            this.bookBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.t

                /* renamed from: b */
                public final /* synthetic */ Context f30844b;

                /* renamed from: c */
                public final /* synthetic */ TYBookItem f30845c;

                public /* synthetic */ t(Context context2, TYBookItem tyBookItem2) {
                    context = context2;
                    tyBookItem = tyBookItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GridBookAdapter.BookViewHolder.e(context, tyBookItem, view);
                }
            });
        }
    }

    /* renamed from: com.martian.mibook.mvvm.yuewen.adapter.GridBookAdapter$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GridBookAdapter.f15506e;
        }

        public final int b() {
            return GridBookAdapter.f15507f;
        }

        public final void c(int i10) {
            GridBookAdapter.f15506e = i10;
        }

        public final void d(int i10) {
            GridBookAdapter.f15507f = i10;
        }

        public Companion() {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDiffer.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r32) {
        return r32;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@k BookViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TYBookItem tYBookItem = this.mDiffer.getCurrentList().get(r32);
        Intrinsics.checkNotNull(tYBookItem);
        holder.c(tYBookItem, r32);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: n */
    public BookViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemGridBookBinding inflate = ItemGridBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BookViewHolder(this, inflate);
    }

    public final void o(@xi.l List<? extends TYBookItem> newData) {
        List<TYBookItem> emptyList;
        AsyncListDiffer<TYBookItem> asyncListDiffer = this.mDiffer;
        if (newData == null || (emptyList = CollectionsKt.take(newData, f15506e * f15507f)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        asyncListDiffer.submitList(emptyList);
    }
}
