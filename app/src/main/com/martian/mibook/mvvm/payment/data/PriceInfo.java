package com.martian.mibook.mvvm.payment.data;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.shu.priory.config.AdKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/payment/data/PriceInfo;", "", AdKeys.CURRENCY, "", "price", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurrency", "()Ljava/lang/String;", "getPrice", "component1", "component2", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PriceInfo {

    @k
    private final String currency;

    @k
    private final String price;

    public PriceInfo(@k String currency, @k String price) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(price, "price");
        this.currency = currency;
        this.price = price;
    }

    public static /* synthetic */ PriceInfo copy$default(PriceInfo priceInfo, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = priceInfo.currency;
        }
        if ((i10 & 2) != 0) {
            str2 = priceInfo.price;
        }
        return priceInfo.copy(str, str2);
    }

    @k
    /* renamed from: component1, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    @k
    /* renamed from: component2, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    @k
    public final PriceInfo copy(@k String r22, @k String price) {
        Intrinsics.checkNotNullParameter(r22, "currency");
        Intrinsics.checkNotNullParameter(price, "price");
        return new PriceInfo(r22, price);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof PriceInfo)) {
            return false;
        }
        PriceInfo priceInfo = (PriceInfo) r52;
        return Intrinsics.areEqual(this.currency, priceInfo.currency) && Intrinsics.areEqual(this.price, priceInfo.price);
    }

    @k
    public final String getCurrency() {
        return this.currency;
    }

    @k
    public final String getPrice() {
        return this.price;
    }

    public int hashCode() {
        return (this.currency.hashCode() * 31) + this.price.hashCode();
    }

    @k
    public String toString() {
        return "PriceInfo(currency=" + this.currency + ", price=" + this.price + ")";
    }
}
