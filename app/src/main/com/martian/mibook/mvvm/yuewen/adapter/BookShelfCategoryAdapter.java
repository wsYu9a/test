package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.R;
import com.martian.mibook.databinding.ItemBookShelfCategoryBinding;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.BookShelfCategoryAdapter;
import id.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\"#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\b2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$ViewHolder;", "<init>", "()V", "", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$a;", "categoryList", "", t.f11204d, "(Ljava/util/List;)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$b;", "onItemClickListener", "m", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$b;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "k", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "j", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$ViewHolder;I)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "d", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$b;", "mOnItemClickListener", "a", "b", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookShelfCategoryAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public ArrayList<a> categoryList = new ArrayList<>();

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public b mOnItemClickListener;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemBookShelfCategoryBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter;Lcom/martian/mibook/databinding/ItemBookShelfCategoryBinding;)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$a;", "categoryItem", "", c.f26972i, "", "b", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfCategoryAdapter$a;I)V", "Lcom/martian/mibook/databinding/ItemBookShelfCategoryBinding;", "d", "()Lcom/martian/mibook/databinding/ItemBookShelfCategoryBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemBookShelfCategoryBinding binding;

        /* renamed from: c */
        public final /* synthetic */ BookShelfCategoryAdapter f15492c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k BookShelfCategoryAdapter bookShelfCategoryAdapter, ItemBookShelfCategoryBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15492c = bookShelfCategoryAdapter;
            this.binding = binding;
        }

        public static final void c(a categoryItem, BookShelfCategoryAdapter this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(categoryItem, "$categoryItem");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (categoryItem.e() == null) {
                b bVar = this$0.mOnItemClickListener;
                if (bVar != null) {
                    bVar.b();
                    return;
                }
                return;
            }
            b bVar2 = this$0.mOnItemClickListener;
            if (bVar2 != null) {
                bVar2.a(view, categoryItem, i10);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void b(@k a categoryItem, int r82) {
            Intrinsics.checkNotNullParameter(categoryItem, "categoryItem");
            if (categoryItem.e() == null) {
                this.binding.ivIcon.setImageResource(R.drawable.icon_book_shelf_category_create);
                this.binding.ivIcon.setColorFilterType(6);
                this.binding.ivIcon.p();
                this.binding.tvCategoryName.setText(ExtKt.c("新建分组"));
                this.binding.tvCategoryName.setTextColorType(4);
                this.binding.tvCategoryName.p();
                this.binding.tvBookCount.setVisibility(8);
                this.binding.ivVip.setVisibility(8);
            } else {
                this.binding.ivIcon.setImageResource(R.drawable.icon_book_shelf_category_folder);
                this.binding.ivIcon.setColorFilterType(0);
                this.binding.ivIcon.p();
                this.binding.tvCategoryName.setText(ExtKt.c(categoryItem.e()));
                this.binding.tvCategoryName.setTextColorType(0);
                this.binding.tvCategoryName.p();
                if (StringsKt.equals(BookrackCategoryManager.SECRETE_CATEGORY, categoryItem.e(), true)) {
                    this.binding.tvBookCount.setVisibility(8);
                    this.binding.ivVip.setVisibility(0);
                } else {
                    this.binding.tvBookCount.setText("共" + categoryItem.f() + "本");
                    this.binding.tvBookCount.setVisibility(0);
                    this.binding.ivVip.setVisibility(8);
                }
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.o

                /* renamed from: c */
                public final /* synthetic */ BookShelfCategoryAdapter f30832c;

                /* renamed from: d */
                public final /* synthetic */ int f30833d;

                public /* synthetic */ o(BookShelfCategoryAdapter bookShelfCategoryAdapter, int r822) {
                    bookShelfCategoryAdapter = bookShelfCategoryAdapter;
                    position = r822;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfCategoryAdapter.ViewHolder.c(BookShelfCategoryAdapter.a.this, bookShelfCategoryAdapter, position, view);
                }
            });
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ItemBookShelfCategoryBinding getBinding() {
            return this.binding;
        }
    }

    public static final class a {

        /* renamed from: a */
        @l
        public String f15493a;

        /* renamed from: b */
        public int f15494b;

        public a() {
            this(null, 0, 3, null);
        }

        public static /* synthetic */ a d(a aVar, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = aVar.f15493a;
            }
            if ((i11 & 2) != 0) {
                i10 = aVar.f15494b;
            }
            return aVar.c(str, i10);
        }

        @l
        public final String a() {
            return this.f15493a;
        }

        public final int b() {
            return this.f15494b;
        }

        @k
        public final a c(@l String str, int i10) {
            return new a(str, i10);
        }

        @l
        public final String e() {
            return this.f15493a;
        }

        public boolean equals(@l Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f15493a, aVar.f15493a) && this.f15494b == aVar.f15494b;
        }

        public final int f() {
            return this.f15494b;
        }

        public final void g(@l String str) {
            this.f15493a = str;
        }

        public final void h(int i10) {
            this.f15494b = i10;
        }

        public int hashCode() {
            String str = this.f15493a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f15494b;
        }

        @k
        public String toString() {
            return "CategoryItem(category=" + this.f15493a + ", count=" + this.f15494b + ")";
        }

        public a(@l String str, int i10) {
            this.f15493a = str;
            this.f15494b = i10;
        }

        public /* synthetic */ a(String str, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0 : i10);
        }
    }

    public interface b {
        void a(@l View view, @l a aVar, int i10);

        void b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.categoryList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@k ViewHolder holder, int r42) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        a aVar = this.categoryList.get(r42);
        Intrinsics.checkNotNullExpressionValue(aVar, "get(...)");
        holder.b(aVar, r42);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: k */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBookShelfCategoryBinding inflate = ItemBookShelfCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void l(@l List<a> list) {
        this.categoryList.clear();
        this.categoryList.add(new a(null, 0));
        if (list != null) {
            this.categoryList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void m(@k b onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }
}
