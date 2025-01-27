package com.martian.mibook.mvvm.yuewen.adapter.holder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemBookMallTypeGenderBinding;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGenderHolder;
import id.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l9.i0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGenderHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeGenderBinding;", "binding", "<init>", "(Lcom/martian/mibook/databinding/ItemBookMallTypeGenderBinding;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannel", "", c.f26972i, "", "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "g", "()V", "f", "(I)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGenderHolder$a;", "bookMallActionListener", t.f11211k, "(Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGenderHolder$a;)V", "Landroid/view/View;", "tvClose", "gender", "o", "(Landroid/view/View;I)V", "Lcom/martian/mibook/databinding/ItemBookMallTypeGenderBinding;", "q", "()Lcom/martian/mibook/databinding/ItemBookMallTypeGenderBinding;", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGenderHolder$a;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ItemGenderHolder extends BookMallAdapter.ItemBaseHolder {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ItemBookMallTypeGenderBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public a bookMallActionListener;

    public interface a {
        void a(int i10, @k YWBookChannel yWBookChannel);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemGenderHolder(@k ItemBookMallTypeGenderBinding binding) {
        super(binding, null, 2, null);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public static final void l(ItemGenderHolder this$0, int i10, YWBookChannel bookChannel, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bookChannel, "$bookChannel");
        a aVar = this$0.bookMallActionListener;
        if (aVar != null) {
            aVar.a(i10, bookChannel);
        }
    }

    public static final void m(ItemGenderHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(this$0.binding.tvClose, 1);
    }

    public static final void n(ItemGenderHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(this$0.binding.tvClose, 2);
    }

    public static final void p(int i10, ItemGenderHolder this$0, View view) {
        a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiConfigSingleton.b2().b3(i10);
        if (i10 == 2 && (aVar = this$0.bookMallActionListener) != null) {
            aVar.b();
        }
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void a(@k YWBookChannel bookChannel, int r42) {
        Intrinsics.checkNotNullParameter(bookChannel, "bookChannel");
        this.binding.contentTitle.setText(ExtKt.c(bookChannel.getTitle()));
        this.binding.tvClose.setVisibility(0);
        this.binding.tvClose.setOnClickListener(new View.OnClickListener() { // from class: ud.f

            /* renamed from: c */
            public final /* synthetic */ int f31005c;

            /* renamed from: d */
            public final /* synthetic */ YWBookChannel f31006d;

            public /* synthetic */ f(int r422, YWBookChannel bookChannel2) {
                position = r422;
                bookChannel = bookChannel2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemGenderHolder.l(ItemGenderHolder.this, position, bookChannel, view);
            }
        });
        this.binding.tvGenderMale.setOnClickListener(new View.OnClickListener() { // from class: ud.g
            public /* synthetic */ g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemGenderHolder.m(ItemGenderHolder.this, view);
            }
        });
        this.binding.tvGenderFemale.setOnClickListener(new View.OnClickListener() { // from class: ud.h
            public /* synthetic */ h() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemGenderHolder.n(ItemGenderHolder.this, view);
            }
        });
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void f(int r12) {
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void g() {
    }

    public final void o(View tvClose, int gender) {
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            String string = activity.getString(R.string.prompt);
            String string2 = activity.getString(com.martian.mibook.R.string.gender_set);
            String string3 = gender == 2 ? activity.getString(com.martian.mibook.R.string.female) : activity.getString(com.martian.mibook.R.string.male);
            i0.z0(activity, string, string2 + string3 + activity.getString(com.martian.mibook.R.string.novel) + activity.getString(com.martian.mibook.R.string.gender_change_hint3), new i0.l() { // from class: ud.e

                /* renamed from: a */
                public final /* synthetic */ int f31001a;

                /* renamed from: b */
                public final /* synthetic */ ItemGenderHolder f31002b;

                /* renamed from: c */
                public final /* synthetic */ View f31003c;

                public /* synthetic */ e(int gender2, ItemGenderHolder this, View tvClose2) {
                    gender = gender2;
                    this = this;
                    tvClose = tvClose2;
                }

                @Override // l9.i0.l
                public final void a() {
                    ItemGenderHolder.p(gender, this, tvClose);
                }
            });
        }
    }

    @k
    /* renamed from: q, reason: from getter */
    public final ItemBookMallTypeGenderBinding getBinding() {
        return this.binding;
    }

    public final void r(@l a aVar) {
        this.bookMallActionListener = aVar;
    }
}
