package com.martian.mibook.mvvm.payment.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.payment.adapter.VipPaymentMethodAdapter;
import com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel;
import id.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import zc.b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u00020\u00072\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter$ViewHolder;", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "mViewModel", "Lkotlin/Function1;", "", "", "onItemClick", "<init>", "(Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;Lkotlin/jvm/functions/Function1;)V", "m", "()V", "Landroid/view/ViewGroup;", "parent", "viewType", t.f11204d, "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter$ViewHolder;", "holder", c.f26972i, "j", "(Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter$ViewHolder;I)V", "getItemCount", "()I", "c", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "d", "Lkotlin/jvm/functions/Function1;", e.TAG, "I", "selectedPosition", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class VipPaymentMethodAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final VipPayViewModel mViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Function1<Integer, Unit> onItemClick;

    /* renamed from: e */
    public int selectedPosition;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\f\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter;Landroid/view/View;)V", "Landroid/widget/LinearLayout;", "b", "Landroid/widget/LinearLayout;", "()Landroid/widget/LinearLayout;", "itemRootView", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "a", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "text", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final LinearLayout itemRootView;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final ImageView icon;

        /* renamed from: d, reason: from kotlin metadata */
        @k
        public final TextView text;

        /* renamed from: e */
        public final /* synthetic */ VipPaymentMethodAdapter f14264e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k VipPaymentMethodAdapter vipPaymentMethodAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f14264e = vipPaymentMethodAdapter;
            View findViewById = view.findViewById(R.id.paymentMethodView);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.itemRootView = (LinearLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.paymentMethodIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.icon = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.paymentMethodTitle);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.text = (TextView) findViewById3;
        }

        @k
        /* renamed from: a, reason: from getter */
        public final ImageView getIcon() {
            return this.icon;
        }

        @k
        /* renamed from: b, reason: from getter */
        public final LinearLayout getItemRootView() {
            return this.itemRootView;
        }

        @k
        /* renamed from: c, reason: from getter */
        public final TextView getText() {
            return this.text;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VipPaymentMethodAdapter(@k VipPayViewModel mViewModel, @k Function1<? super Integer, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.mViewModel = mViewModel;
        this.onItemClick = onItemClick;
    }

    public static final void k(VipPaymentMethodAdapter this$0, int i10, b paymentMethod, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paymentMethod, "$paymentMethod");
        if (this$0.selectedPosition == i10) {
            return;
        }
        if (this$0.mViewModel.v0(paymentMethod.h())) {
            VipPayViewModel vipPayViewModel = this$0.mViewModel;
            vipPayViewModel.k0(vipPayViewModel.getPaymentActiveCounter() + 1);
            if (this$0.mViewModel.getPaymentActiveCounter() == 5) {
                this$0.notifyItemChanged(i10);
                return;
            }
            return;
        }
        if (this$0.mViewModel.getPaymentActiveCounter() < 3) {
            this$0.mViewModel.k0(0);
        }
        int i11 = this$0.selectedPosition;
        this$0.selectedPosition = i10;
        this$0.notifyItemChanged(i11);
        this$0.notifyItemChanged(this$0.selectedPosition);
        this$0.onItemClick.invoke(Integer.valueOf(paymentMethod.h()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mViewModel.T().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@k ViewHolder holder, @SuppressLint({"RecyclerView"}) int r52) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        b bVar = this.mViewModel.T().get(r52);
        holder.getIcon().setImageResource(bVar.g());
        holder.getText().setText(bVar.j());
        holder.getItemRootView().setSelected(this.selectedPosition == r52);
        if (this.mViewModel.v0(bVar.h())) {
            holder.getItemRootView().setAlpha(0.4f);
        } else {
            holder.getItemRootView().setAlpha(1.0f);
        }
        holder.getItemRootView().setOnClickListener(new View.OnClickListener() { // from class: zc.d

            /* renamed from: c */
            public final /* synthetic */ int f33764c;

            /* renamed from: d */
            public final /* synthetic */ b f33765d;

            public /* synthetic */ d(int r522, b bVar2) {
                position = r522;
                bVar = bVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPaymentMethodAdapter.k(VipPaymentMethodAdapter.this, position, bVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: l */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int i10) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_method_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void m() {
        this.selectedPosition = 0;
        notifyDataSetChanged();
    }
}
