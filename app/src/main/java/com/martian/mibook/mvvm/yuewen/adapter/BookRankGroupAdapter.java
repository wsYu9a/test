package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.data.BookRankTab;
import com.martian.mibook.databinding.ItemCategoryGroupBinding;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.BookRankGroupAdapter;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002-.B\u0017\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\n2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0007¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010)\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\fR\u0018\u0010,\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter$MyHolder;", "", "Lcom/martian/mibook/data/BookRankTab;", "rankTabList", "<init>", "(Ljava/util/List;)V", "", "index", "", t.f11211k, "(I)V", "j", "()Ljava/lang/Integer;", "brtype", "q", "(Ljava/lang/Integer;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "m", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter$MyHolder;", "getItemCount", "()I", "holder", c.f26972i, t.f11204d, "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter$MyHolder;I)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter$a;", "listener", "o", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter$a;)V", "n", "()V", "c", "Ljava/util/List;", "d", "I", "k", "p", "selectedPosition", e.TAG, "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter$a;", "onItemClickListener", "MyHolder", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBookRankGroupAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookRankGroupAdapter.kt\ncom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n1864#2,3:139\n*S KotlinDebug\n*F\n+ 1 BookRankGroupAdapter.kt\ncom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter\n*L\n42#1:139,3\n*E\n"})
/* loaded from: classes3.dex */
public final class BookRankGroupAdapter extends RecyclerView.Adapter<MyHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public final List<BookRankTab> rankTabList;

    /* renamed from: d, reason: from kotlin metadata */
    public int selectedPosition;

    /* renamed from: e */
    @l
    public a onItemClickListener;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter$MyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemCategoryGroupBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter;Lcom/martian/mibook/databinding/ItemCategoryGroupBinding;)V", "", c.f26972i, "Lcom/martian/mibook/data/BookRankTab;", "bookRankTab", "", "c", "(ILcom/martian/mibook/data/BookRankTab;)V", "b", "Lcom/martian/mibook/databinding/ItemCategoryGroupBinding;", "d", "()Lcom/martian/mibook/databinding/ItemCategoryGroupBinding;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class MyHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemCategoryGroupBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BookRankGroupAdapter f15459d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyHolder(@k BookRankGroupAdapter bookRankGroupAdapter, ItemCategoryGroupBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15459d = bookRankGroupAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.l

                /* renamed from: c */
                public final /* synthetic */ BookRankGroupAdapter f30826c;

                public /* synthetic */ l(BookRankGroupAdapter bookRankGroupAdapter2) {
                    bookRankGroupAdapter = bookRankGroupAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookRankGroupAdapter.MyHolder.b(BookRankGroupAdapter.MyHolder.this, bookRankGroupAdapter, view);
                }
            });
        }

        public static final void b(MyHolder this$0, BookRankGroupAdapter this$1, View view) {
            a aVar;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0 || (aVar = this$1.onItemClickListener) == null) {
                return;
            }
            aVar.a(bindingAdapterPosition);
        }

        public final void c(int r62, @l BookRankTab bookRankTab) {
            boolean z10 = this.f15459d.getSelectedPosition() == r62;
            boolean A0 = ConfigSingleton.D().A0();
            this.binding.tvGroup.setText(ExtKt.c(bookRankTab != null ? bookRankTab.getName() : null));
            if (A0) {
                if (z10) {
                    this.binding.tvGroup.setTextColor(ContextCompat.getColor(this.com.umeng.analytics.pro.f.X java.lang.String, R.color.night_text_color_primary));
                    this.binding.tvGroup.setTypeface(null, 1);
                    return;
                } else {
                    this.binding.tvGroup.setTextColor(ContextCompat.getColor(this.com.umeng.analytics.pro.f.X java.lang.String, R.color.night_text_color_thirdly));
                    this.binding.tvGroup.setTypeface(null, 0);
                    return;
                }
            }
            if (z10) {
                this.binding.tvGroup.setTextColor(ContextCompat.getColor(this.com.umeng.analytics.pro.f.X java.lang.String, R.color.day_text_color_primary));
                this.binding.tvGroup.setTypeface(null, 1);
            } else {
                this.binding.tvGroup.setTextColor(ContextCompat.getColor(this.com.umeng.analytics.pro.f.X java.lang.String, R.color.day_text_color_thirdly));
                this.binding.tvGroup.setTypeface(null, 0);
            }
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ItemCategoryGroupBinding getBinding() {
            return this.binding;
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    public interface a {
        void a(int i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BookRankGroupAdapter(@l List<? extends BookRankTab> list) {
        this.rankTabList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<BookRankTab> list = this.rankTabList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @l
    public final Integer j() {
        List<BookRankTab> list;
        BookRankTab bookRankTab;
        int i10 = this.selectedPosition;
        if (i10 < 0) {
            return null;
        }
        List<BookRankTab> list2 = this.rankTabList;
        if (i10 >= (list2 != null ? list2.size() : 0) || (list = this.rankTabList) == null || (bookRankTab = list.get(this.selectedPosition)) == null) {
            return null;
        }
        return Integer.valueOf(bookRankTab.getBtype());
    }

    /* renamed from: k, reason: from getter */
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(@k MyHolder holder, int i10) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<BookRankTab> list = this.rankTabList;
        holder.c(i10, list != null ? list.get(i10) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: m */
    public MyHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemCategoryGroupBinding inflate = ItemCategoryGroupBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MyHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void n() {
        if (this.rankTabList != null) {
            notifyDataSetChanged();
        }
    }

    public final void o(@l a listener) {
        this.onItemClickListener = listener;
    }

    public final void p(int i10) {
        this.selectedPosition = i10;
    }

    public final void q(@l Integer brtype) {
        List<BookRankTab> list;
        if (brtype == null || brtype.intValue() == 0 || (list = this.rankTabList) == null) {
            return;
        }
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((BookRankTab) obj).getBtype() == brtype.intValue()) {
                r(i10);
                return;
            }
            i10 = i11;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void r(int i10) {
        this.selectedPosition = i10;
        notifyDataSetChanged();
    }
}
