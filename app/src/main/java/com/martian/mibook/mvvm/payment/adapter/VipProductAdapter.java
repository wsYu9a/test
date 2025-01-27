package com.martian.mibook.mvvm.payment.adapter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.m.e;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.payment.adapter.VipProductAdapter;
import com.martian.mibook.mvvm.payment.data.PriceInfo;
import com.martian.mibook.mvvm.payment.data.VipProduct;
import com.martian.mibook.mvvm.payment.ui.ThemeVipTextView;
import com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel;
import id.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001$B1\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\t2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter$ProductViewHolder;", "", "Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "productList", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "viewModel", "Lkotlin/Function1;", "", "onItemClick", "<init>", "(Ljava/util/List;Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;Lkotlin/jvm/functions/Function1;)V", "p", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "o", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter$ProductViewHolder;", "holder", c.f26972i, "n", "(Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter$ProductViewHolder;I)V", "getItemCount", "()I", "c", "Ljava/util/List;", "d", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", e.TAG, "Lkotlin/jvm/functions/Function1;", "f", "I", "selectedPosition", "ProductViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class VipProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public List<VipProduct> productList;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final VipPayViewModel viewModel;

    /* renamed from: e */
    @k
    public final Function1<VipProduct, Unit> onItemClick;

    /* renamed from: f, reason: from kotlin metadata */
    public int selectedPosition;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter;Landroid/view/View;)V", "", c.f26972i, "", "b", "(I)V", "Lcom/martian/libmars/ui/theme/ThemeTextView;", "Lcom/martian/libmars/ui/theme/ThemeTextView;", "productTitle", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "productCurrency", "d", "productOriginalPrice", e.TAG, "productPrice", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "productView", "Lcom/martian/mibook/mvvm/payment/ui/ThemeVipTextView;", "g", "Lcom/martian/mibook/mvvm/payment/ui/ThemeVipTextView;", "discountTag", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ProductViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ThemeTextView productTitle;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final TextView productCurrency;

        /* renamed from: d, reason: from kotlin metadata */
        @k
        public final TextView productOriginalPrice;

        /* renamed from: e */
        @k
        public final ThemeTextView productPrice;

        /* renamed from: f, reason: from kotlin metadata */
        @k
        public final LinearLayout productView;

        /* renamed from: g, reason: from kotlin metadata */
        @k
        public final ThemeVipTextView discountTag;

        /* renamed from: h */
        public final /* synthetic */ VipProductAdapter f14275h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProductViewHolder(@k VipProductAdapter vipProductAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f14275h = vipProductAdapter;
            View findViewById = itemView.findViewById(R.id.productTitle);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.productTitle = (ThemeTextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.productCurrency);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.productCurrency = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.productOriginalPrice);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.productOriginalPrice = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.productPrice);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.productPrice = (ThemeTextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.productView);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.productView = (LinearLayout) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.discountTag);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.discountTag = (ThemeVipTextView) findViewById6;
        }

        public static final void c(VipProductAdapter this$0, int i10, VipProduct vipProduct, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(vipProduct, "$vipProduct");
            int i11 = this$0.selectedPosition;
            this$0.selectedPosition = i10;
            this$0.notifyItemChanged(i11);
            this$0.notifyItemChanged(this$0.selectedPosition);
            this$0.onItemClick.invoke(vipProduct);
        }

        @SuppressLint({"ResourceAsColor", "DefaultLocale", "SetTextI18n"})
        public final void b(int r12) {
            if (r12 < 0 || r12 >= this.f14275h.getPageSize()) {
                return;
            }
            VipProduct vipProduct = (VipProduct) this.f14275h.productList.get(r12);
            boolean z10 = this.f14275h.selectedPosition == r12;
            this.productTitle.setText(ExtKt.c(vipProduct.getContent()));
            PriceInfo V = this.f14275h.viewModel.V(vipProduct);
            if (TextUtils.isEmpty(vipProduct.getTag())) {
                this.discountTag.setVisibility(8);
            } else {
                this.discountTag.setVisibility(0);
                this.discountTag.setVip(this.f14275h.viewModel.getIsVip());
                this.discountTag.setText(vipProduct.getTag());
            }
            this.productOriginalPrice.setVisibility(4);
            Integer oriPrice = vipProduct.getOriPrice();
            if (oriPrice != null) {
                VipProductAdapter vipProductAdapter = this.f14275h;
                int intValue = oriPrice.intValue();
                Integer price = vipProduct.getPrice();
                if (price != null && intValue > price.intValue()) {
                    this.productOriginalPrice.setText(vipProductAdapter.viewModel.D(intValue / 100.0d));
                    this.productOriginalPrice.setVisibility(0);
                    TextView textView = this.productOriginalPrice;
                    textView.setPaintFlags(textView.getPaintFlags() | 16);
                }
            }
            this.productCurrency.setText(V.getCurrency());
            this.productPrice.setText(V.getPrice());
            this.productView.setSelected(z10);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: zc.e

                /* renamed from: c */
                public final /* synthetic */ int f33767c;

                /* renamed from: d */
                public final /* synthetic */ VipProduct f33768d;

                public /* synthetic */ e(int r122, VipProduct vipProduct2) {
                    position = r122;
                    vipProduct = vipProduct2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VipProductAdapter.ProductViewHolder.c(VipProductAdapter.this, position, vipProduct, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VipProductAdapter(@k List<VipProduct> productList, @k VipPayViewModel viewModel, @k Function1<? super VipProduct, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(productList, "productList");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.productList = productList;
        this.viewModel = viewModel;
        this.onItemClick = onItemClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.productList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@k ProductViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(r32);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: o */
    public ProductViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.vip_product_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ProductViewHolder(this, inflate);
    }

    public final void p() {
        notifyItemChanged(this.selectedPosition);
    }
}
