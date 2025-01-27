package com.martian.mibook.mvvm.yuewen.adapter.holder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import ba.l;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.FinishedOrNewBooksActivity;
import com.martian.mibook.activity.book.YWChannelBooksActivity;
import com.martian.mibook.databinding.ItemBookMallTypeRecommendTitleBinding;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRecommendTitleHolder;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import i8.g;
import id.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l9.m0;
import xi.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JC\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemRecommendTitleHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendTitleBinding;", "binding", "<init>", "(Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendTitleBinding;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannel", "", "tid", "cType", "", "title", "mCid", "speed", "", t.f11204d, "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;II)Z", "ywBookChannel", "k", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)Z", c.f26972i, "", "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "g", "()V", "f", "(I)V", "Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendTitleBinding;", "j", "()Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendTitleBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ItemRecommendTitleHolder extends BookMallAdapter.ItemBaseHolder {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ItemBookMallTypeRecommendTitleBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemRecommendTitleHolder(@k ItemBookMallTypeRecommendTitleBinding binding) {
        super(binding, null, 2, null);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public static final void i(ItemRecommendTitleHolder this$0, YWBookChannel bookChannel, YWBookChannel this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bookChannel, "$bookChannel");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Integer tid = this_apply.getTid();
        BookMallViewModel mViewModel = this$0.getMViewModel();
        Integer valueOf = mViewModel != null ? Integer.valueOf(mViewModel.u()) : null;
        String title = this_apply.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
        Integer mcid = this_apply.getMcid();
        Intrinsics.checkNotNullExpressionValue(mcid, "getMcid(...)");
        int intValue = mcid.intValue();
        BookMallViewModel mViewModel2 = this$0.getMViewModel();
        this$0.l(bookChannel, tid, valueOf, title, intValue, mViewModel2 != null ? mViewModel2.getSpeed() : 0);
    }

    private final boolean k(YWBookChannel ywBookChannel) {
        if (ywBookChannel == null) {
            return false;
        }
        if (g.h(getCom.umeng.analytics.pro.f.X java.lang.String(), ywBookChannel.getBottomDeeplink())) {
            g.A(getCom.umeng.analytics.pro.f.X java.lang.String(), ywBookChannel.getBottomDeeplink(), "", "", true);
            return true;
        }
        if (l.q(ywBookChannel.getBottomUrl())) {
            return false;
        }
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            MiWebViewActivity.startWebViewActivity(activity, ywBookChannel.getBottomUrl());
        }
        return true;
    }

    private final boolean l(YWBookChannel yWBookChannel, Integer num, Integer num2, String str, int i10, int i11) {
        if (k(yWBookChannel)) {
            return true;
        }
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return false;
        }
        if (num != null && num2 != null) {
            FinishedOrNewBooksActivity.startActivity(activity, num.intValue(), num2.intValue(), str);
            return false;
        }
        Integer valueOf = Integer.valueOf(i10);
        int intValue = yWBookChannel.getPageIndex().intValue() - 1;
        Integer size = yWBookChannel.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "getSize(...)");
        YWChannelBooksActivity.L2(activity, str, valueOf, i11, (intValue * size.intValue()) / 10, "");
        return false;
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void a(@k YWBookChannel bookChannel, int r62) {
        Intrinsics.checkNotNullParameter(bookChannel, "bookChannel");
        if (l.q(bookChannel.getTitle())) {
            this.binding.titleView.getRoot().setVisibility(8);
        } else {
            this.binding.titleView.getRoot().setVisibility(0);
            this.binding.titleView.contentTitle.setText(ExtKt.c(bookChannel.getTitle()));
        }
        if (l.q(bookChannel.getTopBgUrl())) {
            this.binding.titleView.tvBg.setVisibility(8);
        } else {
            this.binding.titleView.tvBg.setVisibility(0);
            m0.k(getCom.umeng.analytics.pro.f.X java.lang.String(), bookChannel.getTopBgUrl(), this.binding.titleView.tvBg);
        }
        this.binding.getRoot().setSelectableLayout(false);
        this.binding.titleView.contentMore.setSelectableLayout(false);
        this.binding.titleView.contentMore.setVisibility(bookChannel.getBottomType() > 0 ? 0 : 8);
        if (bookChannel.getBottomType() <= 1) {
            this.binding.titleView.authorBookMore.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.search_recommend_tags));
            this.binding.titleView.authorBookMoreView.setImageResource(R.drawable.loan_more);
            if (bookChannel.getBottomType() == 1) {
                this.binding.titleView.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ud.v

                    /* renamed from: c */
                    public final /* synthetic */ YWBookChannel f31035c;

                    /* renamed from: d */
                    public final /* synthetic */ YWBookChannel f31036d;

                    public /* synthetic */ v(YWBookChannel bookChannel2, YWBookChannel bookChannel22) {
                        bookChannel = bookChannel22;
                        bookChannel = bookChannel22;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ItemRecommendTitleHolder.i(ItemRecommendTitleHolder.this, bookChannel, bookChannel, view);
                    }
                });
            }
        }
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void f(int r12) {
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void g() {
    }

    @k
    /* renamed from: j, reason: from getter */
    public final ItemBookMallTypeRecommendTitleBinding getBinding() {
        return this.binding;
    }
}
