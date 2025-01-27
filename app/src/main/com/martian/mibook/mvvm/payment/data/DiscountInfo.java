package com.martian.mibook.mvvm.payment.data;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/payment/data/DiscountInfo;", "", "originalPrice", "", TTDownloadField.TT_TAG, "(Ljava/lang/String;Ljava/lang/String;)V", "getOriginalPrice", "()Ljava/lang/String;", "getTag", "component1", "component2", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DiscountInfo {

    @l
    private final String originalPrice;

    @k
    private final String tag;

    public DiscountInfo(@l String str, @k String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.originalPrice = str;
        this.tag = tag;
    }

    public static /* synthetic */ DiscountInfo copy$default(DiscountInfo discountInfo, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = discountInfo.originalPrice;
        }
        if ((i10 & 2) != 0) {
            str2 = discountInfo.tag;
        }
        return discountInfo.copy(str, str2);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final String getOriginalPrice() {
        return this.originalPrice;
    }

    @k
    /* renamed from: component2, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @k
    public final DiscountInfo copy(@l String originalPrice, @k String r32) {
        Intrinsics.checkNotNullParameter(r32, "tag");
        return new DiscountInfo(originalPrice, r32);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof DiscountInfo)) {
            return false;
        }
        DiscountInfo discountInfo = (DiscountInfo) r52;
        return Intrinsics.areEqual(this.originalPrice, discountInfo.originalPrice) && Intrinsics.areEqual(this.tag, discountInfo.tag);
    }

    @l
    public final String getOriginalPrice() {
        return this.originalPrice;
    }

    @k
    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        String str = this.originalPrice;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.tag.hashCode();
    }

    @k
    public String toString() {
        return "DiscountInfo(originalPrice=" + this.originalPrice + ", tag=" + this.tag + ")";
    }
}
