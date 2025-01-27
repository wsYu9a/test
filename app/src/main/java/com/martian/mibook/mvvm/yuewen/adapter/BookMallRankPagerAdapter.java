package com.martian.mibook.mvvm.yuewen.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import ba.l;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.databinding.ItemRankBookBinding;
import com.martian.mibook.databinding.ItemRankPageBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallRankPagerAdapter;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.List;
import je.i;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\n2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR.\u0010 \u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u001d*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter$ViewHolder;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "newData", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "", t.f11204d, "(Ljava/util/List;Landroidx/viewpager2/widget/ViewPager2;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "k", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "j", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter$ViewHolder;I)V", "c", "I", "pageSize", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "d", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookMallRankPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    public final int pageSize = 4;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final AsyncListDiffer<List<TYBookItem>> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<List<? extends TYBookItem>>() { // from class: com.martian.mibook.mvvm.yuewen.adapter.BookMallRankPagerAdapter$mDiffer$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a */
        public boolean areContentsTheSame(@k List<? extends TYBookItem> oldItem, @k List<? extends TYBookItem> newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            int size = oldItem.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!Intrinsics.areEqual(oldItem.get(i10), newItem.get(i10)) || !Intrinsics.areEqual(oldItem.get(i10).getBookId(), newItem.get(i10).getBookId()) || !oldItem.get(i10).getBookName().equals(newItem.get(i10).getBookName())) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@k List<? extends TYBookItem> oldItem, @k List<? extends TYBookItem> newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    });

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemRankPageBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter;Lcom/martian/mibook/databinding/ItemRankPageBinding;)V", "Landroid/widget/TextView;", "textView", "", "colorId", "", e.TAG, "(Landroid/widget/TextView;I)V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "books", "pagePosition", "b", "(Ljava/util/List;I)V", "Lcom/martian/mibook/databinding/ItemRankPageBinding;", "d", "()Lcom/martian/mibook/databinding/ItemRankPageBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    @SourceDebugExtension({"SMAP\nBookMallRankPagerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookMallRankPagerAdapter.kt\ncom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter$ViewHolder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,126:1\n1864#2,3:127\n*S KotlinDebug\n*F\n+ 1 BookMallRankPagerAdapter.kt\ncom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter$ViewHolder\n*L\n90#1:127,3\n*E\n"})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemRankPageBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BookMallRankPagerAdapter f15441d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k BookMallRankPagerAdapter bookMallRankPagerAdapter, ItemRankPageBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15441d = bookMallRankPagerAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
        }

        public static final void c(ViewHolder this$0, TYBookItem tyBookItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tyBookItem, "$tyBookItem");
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            if ((context instanceof Activity ? (Activity) context : null) != null) {
                i.H((Activity) context, tyBookItem);
            }
        }

        private final void e(TextView textView, int i10) {
            textView.setTextColor(ContextCompat.getColor(this.com.umeng.analytics.pro.f.X java.lang.String, i10));
        }

        public final void b(@k List<? extends TYBookItem> books, int pagePosition) {
            Intrinsics.checkNotNullParameter(books, "books");
            ItemRankPageBinding itemRankPageBinding = this.binding;
            BookMallRankPagerAdapter bookMallRankPagerAdapter = this.f15441d;
            if (itemRankPageBinding.getRoot().getChildCount() > 0) {
                itemRankPageBinding.getRoot().removeAllViews();
            }
            int i10 = 0;
            for (Object obj : books) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TYBookItem tYBookItem = (TYBookItem) obj;
                ItemRankBookBinding inflate = ItemRankBookBinding.inflate(LayoutInflater.from(this.com.umeng.analytics.pro.f.X java.lang.String));
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                inflate.bsRankIndex.setText(ExtKt.c(String.valueOf((bookMallRankPagerAdapter.pageSize * pagePosition) + i11)));
                int j02 = ConfigSingleton.D().j0();
                if (pagePosition != 0) {
                    inflate.bsRankIndex.setTextColor(j02);
                } else if (i10 == 0) {
                    TextView bsRankIndex = inflate.bsRankIndex;
                    Intrinsics.checkNotNullExpressionValue(bsRankIndex, "bsRankIndex");
                    e(bsRankIndex, R.color.book_mall_rank_1);
                } else if (i10 == 1) {
                    TextView bsRankIndex2 = inflate.bsRankIndex;
                    Intrinsics.checkNotNullExpressionValue(bsRankIndex2, "bsRankIndex");
                    e(bsRankIndex2, R.color.book_mall_rank_2);
                } else if (i10 == 2) {
                    TextView bsRankIndex3 = inflate.bsRankIndex;
                    Intrinsics.checkNotNullExpressionValue(bsRankIndex3, "bsRankIndex");
                    e(bsRankIndex3, R.color.book_mall_rank_3);
                } else if (i10 == 3) {
                    inflate.bsRankIndex.setTextColor(j02);
                }
                MiBookManager.u1(this.com.umeng.analytics.pro.f.X java.lang.String, tYBookItem, inflate.bookCover);
                if (!TextUtils.isEmpty(tYBookItem.getTitle())) {
                    inflate.bsRankBookName.setText(ExtKt.c(tYBookItem.getTitle()));
                }
                if (!l.q(tYBookItem.getRecTitle())) {
                    inflate.bsRankBookCategory.setText(ExtKt.c(tYBookItem.getRecTitle()));
                }
                inflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.i

                    /* renamed from: c */
                    public final /* synthetic */ TYBookItem f30820c;

                    public /* synthetic */ i(TYBookItem tYBookItem2) {
                        tYBookItem = tYBookItem2;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookMallRankPagerAdapter.ViewHolder.c(BookMallRankPagerAdapter.ViewHolder.this, tYBookItem, view);
                    }
                });
                itemRankPageBinding.getRoot().addView(inflate.getRoot());
                i10 = i11;
            }
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ItemRankPageBinding getBinding() {
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
        return this.mDiffer.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@k ViewHolder holder, int r52) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.itemView.setTag(R.id.viewPager2_position, Integer.valueOf(r52));
        List<TYBookItem> list = this.mDiffer.getCurrentList().get(r52);
        Intrinsics.checkNotNull(list);
        holder.b(list, r52);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: k */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemRankPageBinding inflate = ItemRankPageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    public final void l(@xi.l List<? extends TYBookItem> list, @xi.l ViewPager2 viewPager2) {
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(0);
        }
        this.mDiffer.submitList(list != null ? CollectionsKt.chunked(list, this.pageSize) : null);
    }
}
