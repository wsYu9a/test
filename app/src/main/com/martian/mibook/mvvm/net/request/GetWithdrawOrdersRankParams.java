package com.martian.mibook.mvvm.net.request;

import bb.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/GetWithdrawOrdersRankParams;", "", "page", "", "pageSize", "withHeader", "", "type", "(IIZI)V", "getPage", "()I", "setPage", "(I)V", "getPageSize", "setPageSize", "getType", "setType", "getWithHeader", "()Z", "setWithHeader", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GetWithdrawOrdersRankParams {
    private int page;
    private int pageSize;
    private int type;
    private boolean withHeader;

    public GetWithdrawOrdersRankParams() {
        this(0, 0, false, 0, 15, null);
    }

    public static /* synthetic */ GetWithdrawOrdersRankParams copy$default(GetWithdrawOrdersRankParams getWithdrawOrdersRankParams, int i10, int i11, boolean z10, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = getWithdrawOrdersRankParams.page;
        }
        if ((i13 & 2) != 0) {
            i11 = getWithdrawOrdersRankParams.pageSize;
        }
        if ((i13 & 4) != 0) {
            z10 = getWithdrawOrdersRankParams.withHeader;
        }
        if ((i13 & 8) != 0) {
            i12 = getWithdrawOrdersRankParams.type;
        }
        return getWithdrawOrdersRankParams.copy(i10, i11, z10, i12);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getWithHeader() {
        return this.withHeader;
    }

    /* renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @k
    public final GetWithdrawOrdersRankParams copy(int page, int pageSize, boolean withHeader, int type) {
        return new GetWithdrawOrdersRankParams(page, pageSize, withHeader, type);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof GetWithdrawOrdersRankParams)) {
            return false;
        }
        GetWithdrawOrdersRankParams getWithdrawOrdersRankParams = (GetWithdrawOrdersRankParams) r52;
        return this.page == getWithdrawOrdersRankParams.page && this.pageSize == getWithdrawOrdersRankParams.pageSize && this.withHeader == getWithdrawOrdersRankParams.withHeader && this.type == getWithdrawOrdersRankParams.type;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean getWithHeader() {
        return this.withHeader;
    }

    public int hashCode() {
        return (((((this.page * 31) + this.pageSize) * 31) + a.a(this.withHeader)) * 31) + this.type;
    }

    public final void setPage(int i10) {
        this.page = i10;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public final void setWithHeader(boolean z10) {
        this.withHeader = z10;
    }

    @k
    public String toString() {
        return "GetWithdrawOrdersRankParams(page=" + this.page + ", pageSize=" + this.pageSize + ", withHeader=" + this.withHeader + ", type=" + this.type + ")";
    }

    public GetWithdrawOrdersRankParams(int i10, int i11, boolean z10, int i12) {
        this.page = i10;
        this.pageSize = i11;
        this.withHeader = z10;
        this.type = i12;
    }

    public /* synthetic */ GetWithdrawOrdersRankParams(int i10, int i11, boolean z10, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 10 : i11, (i13 & 4) != 0 ? false : z10, (i13 & 8) != 0 ? 0 : i12);
    }
}
