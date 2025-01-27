package com.martian.mibook.mvvm.net.request;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003JR\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u0006+"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/YWRankBooksParams;", "", "brtype", "", "page", "pageSize", "ctype", "status", "category", "", "(Ljava/lang/Integer;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getBrtype", "()Ljava/lang/Integer;", "setBrtype", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getCtype", "setCtype", "getPage", "()I", "setPage", "(I)V", "getPageSize", "setPageSize", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/martian/mibook/mvvm/net/request/YWRankBooksParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class YWRankBooksParams {

    @l
    private Integer brtype;

    @l
    private String category;

    @l
    private Integer ctype;
    private int page;
    private int pageSize;

    @l
    private Integer status;

    public YWRankBooksParams() {
        this(null, 0, 0, null, null, null, 63, null);
    }

    public static /* synthetic */ YWRankBooksParams copy$default(YWRankBooksParams yWRankBooksParams, Integer num, int i10, int i11, Integer num2, Integer num3, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            num = yWRankBooksParams.brtype;
        }
        if ((i12 & 2) != 0) {
            i10 = yWRankBooksParams.page;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            i11 = yWRankBooksParams.pageSize;
        }
        int i14 = i11;
        if ((i12 & 8) != 0) {
            num2 = yWRankBooksParams.ctype;
        }
        Integer num4 = num2;
        if ((i12 & 16) != 0) {
            num3 = yWRankBooksParams.status;
        }
        Integer num5 = num3;
        if ((i12 & 32) != 0) {
            str = yWRankBooksParams.category;
        }
        return yWRankBooksParams.copy(num, i13, i14, num4, num5, str);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Integer getBrtype() {
        return this.brtype;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final Integer getCtype() {
        return this.ctype;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @k
    public final YWRankBooksParams copy(@l Integer brtype, int page, int pageSize, @l Integer ctype, @l Integer status, @l String category) {
        return new YWRankBooksParams(brtype, page, pageSize, ctype, status, category);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof YWRankBooksParams)) {
            return false;
        }
        YWRankBooksParams yWRankBooksParams = (YWRankBooksParams) r52;
        return Intrinsics.areEqual(this.brtype, yWRankBooksParams.brtype) && this.page == yWRankBooksParams.page && this.pageSize == yWRankBooksParams.pageSize && Intrinsics.areEqual(this.ctype, yWRankBooksParams.ctype) && Intrinsics.areEqual(this.status, yWRankBooksParams.status) && Intrinsics.areEqual(this.category, yWRankBooksParams.category);
    }

    @l
    public final Integer getBrtype() {
        return this.brtype;
    }

    @l
    public final String getCategory() {
        return this.category;
    }

    @l
    public final Integer getCtype() {
        return this.ctype;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @l
    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        Integer num = this.brtype;
        int hashCode = (((((num == null ? 0 : num.hashCode()) * 31) + this.page) * 31) + this.pageSize) * 31;
        Integer num2 = this.ctype;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.status;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.category;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final void setBrtype(@l Integer num) {
        this.brtype = num;
    }

    public final void setCategory(@l String str) {
        this.category = str;
    }

    public final void setCtype(@l Integer num) {
        this.ctype = num;
    }

    public final void setPage(int i10) {
        this.page = i10;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public final void setStatus(@l Integer num) {
        this.status = num;
    }

    @k
    public String toString() {
        return "YWRankBooksParams(brtype=" + this.brtype + ", page=" + this.page + ", pageSize=" + this.pageSize + ", ctype=" + this.ctype + ", status=" + this.status + ", category=" + this.category + ")";
    }

    public YWRankBooksParams(@l Integer num, int i10, int i11, @l Integer num2, @l Integer num3, @l String str) {
        this.brtype = num;
        this.page = i10;
        this.pageSize = i11;
        this.ctype = num2;
        this.status = num3;
        this.category = str;
    }

    public /* synthetic */ YWRankBooksParams(Integer num, int i10, int i11, Integer num2, Integer num3, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : num, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 10 : i11, (i12 & 8) != 0 ? null : num2, (i12 & 16) != 0 ? null : num3, (i12 & 32) != 0 ? null : str);
    }
}
