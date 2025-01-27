package com.martian.mibook.mvvm.payment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.payment.adapter.VipBenefitGridAdapter;
import com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel;
import id.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import zc.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\u00072\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter$ViewHolder;", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "mViewModel", "Lkotlin/Function1;", "", "", "onItemClick", "<init>", "(Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/ViewGroup;", "parent", "viewType", t.f11204d, "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter$ViewHolder;", "holder", c.f26972i, "j", "(Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter$ViewHolder;I)V", "getItemCount", "()I", "c", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "d", "Lkotlin/jvm/functions/Function1;", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class VipBenefitGridAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final VipPayViewModel mViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Function1<Integer, Unit> onItemClick;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\u0007\u0010\nR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "a", "()Landroid/widget/ImageView;", "icon", "c", "iconBg", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "text", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ImageView icon;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final ImageView iconBg;

        /* renamed from: d, reason: from kotlin metadata */
        @k
        public final TextView text;

        /* renamed from: e */
        public final /* synthetic */ VipBenefitGridAdapter f14257e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k VipBenefitGridAdapter vipBenefitGridAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f14257e = vipBenefitGridAdapter;
            View findViewById = itemView.findViewById(R.id.icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.icon = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.iconBg);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.iconBg = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.text);
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
        public final ImageView getIconBg() {
            return this.iconBg;
        }

        @k
        /* renamed from: c, reason: from getter */
        public final TextView getText() {
            return this.text;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VipBenefitGridAdapter(@k VipPayViewModel mViewModel, @k Function1<? super Integer, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.mViewModel = mViewModel;
        this.onItemClick = onItemClick;
    }

    public static final void k(VipBenefitGridAdapter this$0, int i10, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onItemClick.invoke(Integer.valueOf(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mViewModel.E().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@k ViewHolder holder, int r52) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        a aVar = this.mViewModel.E().get(r52);
        holder.getIcon().setImageResource(this.mViewModel.getIsVip() ? aVar.j() : aVar.h());
        holder.getIconBg().setImageResource(this.mViewModel.getIsVip() ? R.drawable.vip_bg_benefit_opened : R.drawable.vip_bg_benefit);
        holder.getText().setText(aVar.i());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: zc.c

            /* renamed from: c */
            public final /* synthetic */ int f33762c;

            public /* synthetic */ c(int r522) {
                position = r522;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipBenefitGridAdapter.k(VipBenefitGridAdapter.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: l */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int i10) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.benefit_grid_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(this, inflate);
    }
}
