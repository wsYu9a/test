package com.martian.mibook.mvvm.category.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.linkage.BaseLinkageItem;
import com.martian.libmars.widget.linkage.BaseQuickLinkageAdapter;
import com.martian.mibook.databinding.ItemCategoryGroupBinding;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.umeng.analytics.pro.f;
import id.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00060\bR\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/category/adapter/BDCategoryGroupAdapter;", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/martian/mibook/mvvm/category/adapter/BDCategoryGroupAdapter$MyHolder;", IAdInterListener.AdReqParam.WIDTH, "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/category/adapter/BDCategoryGroupAdapter$MyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", c.f26972i, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "MyHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BDCategoryGroupAdapter extends BaseQuickLinkageAdapter {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/martian/mibook/mvvm/category/adapter/BDCategoryGroupAdapter$MyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemCategoryGroupBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/category/adapter/BDCategoryGroupAdapter;Lcom/martian/mibook/databinding/ItemCategoryGroupBinding;)V", "", c.f26972i, "Lcom/martian/libmars/widget/linkage/BaseLinkageItem;", "item", "", "a", "(ILcom/martian/libmars/widget/linkage/BaseLinkageItem;)V", "b", "Lcom/martian/mibook/databinding/ItemCategoryGroupBinding;", "()Lcom/martian/mibook/databinding/ItemCategoryGroupBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class MyHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemCategoryGroupBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BDCategoryGroupAdapter f14199d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyHolder(@k BDCategoryGroupAdapter bDCategoryGroupAdapter, ItemCategoryGroupBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14199d = bDCategoryGroupAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
        }

        public final void a(int r52, @k BaseLinkageItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.f14199d.k(this, r52);
            boolean z10 = this.f14199d.getSelectedPosition() == r52;
            boolean A0 = ConfigSingleton.D().A0();
            this.binding.tvGroup.setText(ExtKt.c(item.getParentName()));
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
        /* renamed from: b, reason: from getter */
        public final ItemCategoryGroupBinding getBinding() {
            return this.binding;
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    public BDCategoryGroupAdapter() {
        super(null, 1, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@k RecyclerView.ViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof MyHolder) {
            ((MyHolder) holder).a(r32, o(r32));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: w */
    public MyHolder onCreateViewHolder(@k ViewGroup parent, int i10) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemCategoryGroupBinding inflate = ItemCategoryGroupBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MyHolder(this, inflate);
    }
}
