package com.martian.mibook.mvvm.yuewen.adapter.holder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.databinding.ItemBookMallTypeRecommendBookBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRecommendBookHolder;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import id.c;
import java.util.Arrays;
import java.util.Locale;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemRecommendBookHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendBookBinding;", "binding", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "mViewModel", "<init>", "(Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendBookBinding;Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannel", "", c.f26972i, "", "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "k", "()V", "g", "f", "(I)V", "Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendBookBinding;", "j", "()Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendBookBinding;", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "Landroid/graphics/Rect;", "h", "Landroid/graphics/Rect;", "viewBounds", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ItemRecommendBookHolder extends BookMallAdapter.ItemBaseHolder {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ItemBookMallTypeRecommendBookBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public YWBookChannel bookChannel;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Rect viewBounds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemRecommendBookHolder(@k ItemBookMallTypeRecommendBookBinding binding, @l BookMallViewModel bookMallViewModel) {
        super(binding, bookMallViewModel);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.viewBounds = new Rect();
    }

    public static final void i(ItemRecommendBookHolder this$0, TYBookItem bookItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bookItem, "$bookItem");
        Context context = this$0.getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.H(activity, bookItem);
        }
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    @SuppressLint({"SetTextI18n"})
    public void a(@k YWBookChannel bookChannel, int r82) {
        Intrinsics.checkNotNullParameter(bookChannel, "bookChannel");
        this.bookChannel = bookChannel;
        TYBookItem bookItem = bookChannel.getBookItem();
        if (bookItem != null) {
            MiBookManager.u1(getCom.umeng.analytics.pro.f.X java.lang.String(), bookItem, this.binding.bookCover);
            this.binding.tvBookName.setText(ExtKt.c(bookItem.getTitle()));
            this.binding.tvBookShortContent.setText(ExtKt.c(ba.l.y(bookItem.getIntro())));
            this.binding.tvBookAuthorName.setText(ExtKt.c(bookItem.getRecTitle()));
            if (bookItem.getScore() > 0) {
                this.binding.tvBookScore.setVisibility(0);
                TextView textView = this.binding.tvBookScore;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(bookItem.getScore() / 10.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format + "分");
            } else {
                this.binding.tvBookScore.setVisibility(8);
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ud.u

                /* renamed from: c */
                public final /* synthetic */ TYBookItem f31033c;

                public /* synthetic */ u(TYBookItem bookItem2) {
                    bookItem = bookItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ItemRecommendBookHolder.i(ItemRecommendBookHolder.this, bookItem, view);
                }
            });
            ThemeLinearLayout root = this.binding.getRoot();
            if (!(root instanceof ThemeLinearLayout)) {
                root = null;
            }
            if (root != null) {
                root.setBackgroundType(bookChannel.isLastBookItem() ? 22 : 23);
            }
        }
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void f(int r22) {
        TYBookItem bookItem;
        ThemeLinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.viewBounds.setEmpty();
        if (!root.getLocalVisibleRect(this.viewBounds) || root.getHeight() <= 0 || this.viewBounds.height() / root.getHeight() < 0.8f) {
            return;
        }
        YWBookChannel yWBookChannel = this.bookChannel;
        if (yWBookChannel != null) {
            yWBookChannel.setExposed(Boolean.TRUE);
        }
        YWBookChannel yWBookChannel2 = this.bookChannel;
        if (yWBookChannel2 == null || (bookItem = yWBookChannel2.getBookItem()) == null) {
            return;
        }
        e(bookItem);
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void g() {
    }

    @k
    /* renamed from: j, reason: from getter */
    public final ItemBookMallTypeRecommendBookBinding getBinding() {
        return this.binding;
    }

    public final void k() {
        if (this.bookChannel != null) {
            ThemeLinearLayout root = this.binding.getRoot();
            if (!(root instanceof ThemeLinearLayout)) {
                root = null;
            }
            if (root != null) {
                YWBookChannel yWBookChannel = this.bookChannel;
                if (yWBookChannel != null) {
                    yWBookChannel.setLastBookItem(false);
                }
                root.setBackgroundType(23);
                root.p();
            }
        }
    }
}
