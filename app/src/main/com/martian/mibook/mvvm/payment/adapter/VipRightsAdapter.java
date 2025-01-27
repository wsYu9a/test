package com.martian.mibook.mvvm.payment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.R;
import com.tencent.open.SocialConstants;
import id.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import zc.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u00102\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/martian/mibook/mvvm/payment/adapter/VipRightsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/payment/adapter/VipRightsAdapter$ViewHolder;", "", "Lzc/a;", "rightsItems", "<init>", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "j", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/payment/adapter/VipRightsAdapter$ViewHolder;", "holder", c.f26972i, "", "i", "(Lcom/martian/mibook/mvvm/payment/adapter/VipRightsAdapter$ViewHolder;I)V", "getItemCount", "()I", "c", "Ljava/util/List;", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class VipRightsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final List<a> rightsItems;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/martian/mibook/mvvm/payment/adapter/VipRightsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Lcom/martian/mibook/mvvm/payment/adapter/VipRightsAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "title", "c", "a", SocialConstants.PARAM_APP_DESC, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final TextView title;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final TextView com.tencent.open.SocialConstants.PARAM_APP_DESC java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ VipRightsAdapter f14279d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k VipRightsAdapter vipRightsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f14279d = vipRightsAdapter;
            View findViewById = view.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.title = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.desc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.com.tencent.open.SocialConstants.PARAM_APP_DESC java.lang.String = (TextView) findViewById2;
        }

        @k
        /* renamed from: a, reason: from getter */
        public final TextView getCom.tencent.open.SocialConstants.PARAM_APP_DESC java.lang.String() {
            return this.com.tencent.open.SocialConstants.PARAM_APP_DESC java.lang.String;
        }

        @k
        /* renamed from: b, reason: from getter */
        public final TextView getTitle() {
            return this.title;
        }
    }

    public VipRightsAdapter(@k List<a> rightsItems) {
        Intrinsics.checkNotNullParameter(rightsItems, "rightsItems");
        this.rightsItems = rightsItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.rightsItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(@k ViewHolder holder, int r42) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        a aVar = this.rightsItems.get(r42);
        holder.getTitle().setText(aVar.i());
        holder.getCom.tencent.open.SocialConstants.PARAM_APP_DESC java.lang.String().setText(aVar.g());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: j */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.vip_rights_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(this, inflate);
    }
}
