package com.martian.mibook.mvvm.payment.data;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/martian/mibook/mvvm/payment/data/VipInfo;", "", "vipEnd", "", "products", "", "Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "(Ljava/lang/Long;Ljava/util/List;)V", "getProducts", "()Ljava/util/List;", "setProducts", "(Ljava/util/List;)V", "getVipEnd", "()Ljava/lang/Long;", "setVipEnd", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/util/List;)Lcom/martian/mibook/mvvm/payment/data/VipInfo;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VipInfo {

    @l
    private List<VipProduct> products;

    @l
    private Long vipEnd;

    public VipInfo() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VipInfo copy$default(VipInfo vipInfo, Long l10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = vipInfo.vipEnd;
        }
        if ((i10 & 2) != 0) {
            list = vipInfo.products;
        }
        return vipInfo.copy(l10, list);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Long getVipEnd() {
        return this.vipEnd;
    }

    @l
    public final List<VipProduct> component2() {
        return this.products;
    }

    @k
    public final VipInfo copy(@l Long vipEnd, @l List<VipProduct> products) {
        return new VipInfo(vipEnd, products);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof VipInfo)) {
            return false;
        }
        VipInfo vipInfo = (VipInfo) r52;
        return Intrinsics.areEqual(this.vipEnd, vipInfo.vipEnd) && Intrinsics.areEqual(this.products, vipInfo.products);
    }

    @l
    public final List<VipProduct> getProducts() {
        return this.products;
    }

    @l
    public final Long getVipEnd() {
        return this.vipEnd;
    }

    public int hashCode() {
        Long l10 = this.vipEnd;
        int hashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        List<VipProduct> list = this.products;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setProducts(@l List<VipProduct> list) {
        this.products = list;
    }

    public final void setVipEnd(@l Long l10) {
        this.vipEnd = l10;
    }

    @k
    public String toString() {
        return "VipInfo(vipEnd=" + this.vipEnd + ", products=" + this.products + ")";
    }

    public VipInfo(@l Long l10, @l List<VipProduct> list) {
        this.vipEnd = l10;
        this.products = list;
    }

    public /* synthetic */ VipInfo(Long l10, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : list);
    }
}
