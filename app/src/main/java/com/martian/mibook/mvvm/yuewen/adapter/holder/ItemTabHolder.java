package com.martian.mibook.mvvm.yuewen.adapter.holder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.martian.mibook.R;
import com.martian.mibook.databinding.ItemBookMallTypeTabBinding;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemTabHolder;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import id.c;
import kc.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemTabHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeTabBinding;", "binding", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "mViewModel", "<init>", "(Lcom/martian/mibook/databinding/ItemBookMallTypeTabBinding;Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannel", "", c.f26972i, "", "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "g", "()V", "f", "(I)V", "Lcom/martian/mibook/databinding/ItemBookMallTypeTabBinding;", "p", "()Lcom/martian/mibook/databinding/ItemBookMallTypeTabBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ItemTabHolder extends BookMallAdapter.ItemBaseHolder {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ItemBookMallTypeTabBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemTabHolder(@k ItemBookMallTypeTabBinding binding, @l BookMallViewModel bookMallViewModel) {
        super(binding, bookMallViewModel);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public static final void l(ItemTabHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.binding.getRoot().getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ac.a.w(activity, "新书");
            BookMallViewModel mViewModel = this$0.getMViewModel();
            if (mViewModel != null) {
                b.B("新书", mViewModel.u(), 13);
            }
        }
    }

    public static final void m(ItemTabHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.binding.getRoot().getContext();
        ac.a.w(context instanceof Activity ? (Activity) context : null, "榜单");
        BookMallViewModel mViewModel = this$0.getMViewModel();
        if (mViewModel != null) {
            b.j(mViewModel.u(), null, null, null, 14, null);
        }
    }

    public static final void n(ItemTabHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.binding.getRoot().getContext();
        ac.a.w(context instanceof Activity ? (Activity) context : null, wd.a.f31693b);
        BookMallViewModel mViewModel = this$0.getMViewModel();
        if (mViewModel != null) {
            b.g(mViewModel.u());
        }
    }

    public static final void o(ItemTabHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.binding.getRoot().getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ac.a.w(activity, Book.STATUS_FINISHED);
            BookMallViewModel mViewModel = this$0.getMViewModel();
            if (mViewModel != null) {
                b.B(Book.STATUS_FINISHED, mViewModel.u(), 13);
            }
        }
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void a(@k YWBookChannel bookChannel, int r22) {
        Intrinsics.checkNotNullParameter(bookChannel, "bookChannel");
        BookMallViewModel mViewModel = getMViewModel();
        if (mViewModel == null || mViewModel.getTid() != 2) {
            this.binding.ivTabList.setImageResource(R.drawable.icon_tab_list);
            this.binding.ivTabCategory.setImageResource(R.drawable.icon_tab_category);
            this.binding.ivTabBookComplete.setImageResource(R.drawable.icon_tab_book_complete);
            this.binding.ivTabNewBook.setImageResource(R.drawable.icon_tab_new_book);
        } else {
            this.binding.ivTabList.setImageResource(R.drawable.icon_tab_list_girl);
            this.binding.ivTabCategory.setImageResource(R.drawable.icon_tab_category_girl);
            this.binding.ivTabBookComplete.setImageResource(R.drawable.icon_tab_book_complete_girl);
            this.binding.ivTabNewBook.setImageResource(R.drawable.icon_tab_new_book_girl);
        }
        this.binding.rlTabList.setOnClickListener(new View.OnClickListener() { // from class: ud.w
            public /* synthetic */ w() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemTabHolder.m(ItemTabHolder.this, view);
            }
        });
        this.binding.rlTabCategory.setOnClickListener(new View.OnClickListener() { // from class: ud.x
            public /* synthetic */ x() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemTabHolder.n(ItemTabHolder.this, view);
            }
        });
        this.binding.rlTabBookComplete.setOnClickListener(new View.OnClickListener() { // from class: ud.y
            public /* synthetic */ y() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemTabHolder.o(ItemTabHolder.this, view);
            }
        });
        this.binding.rlTabNewBook.setOnClickListener(new View.OnClickListener() { // from class: ud.z
            public /* synthetic */ z() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemTabHolder.l(ItemTabHolder.this, view);
            }
        });
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void f(int r12) {
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void g() {
    }

    @k
    /* renamed from: p, reason: from getter */
    public final ItemBookMallTypeTabBinding getBinding() {
        return this.binding;
    }
}
