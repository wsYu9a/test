package com.martian.mibook.mvvm.net.request;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0094\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0005HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018¨\u0006C"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/SearchBooksParams;", "", "keywords", "", "page", "", "pageSize", "searchType", "ctype", "sourceName", "sourceId", "maxWords", "minWords", "status", "freeType", "order", "(Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;I)V", "getCtype", "()I", "setCtype", "(I)V", "getFreeType", "()Ljava/lang/Integer;", "setFreeType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getKeywords", "()Ljava/lang/String;", "setKeywords", "(Ljava/lang/String;)V", "getMaxWords", "setMaxWords", "getMinWords", "setMinWords", "getOrder", "setOrder", "getPage", "setPage", "getPageSize", "setPageSize", "getSearchType", "setSearchType", "getSourceId", "setSourceId", "getSourceName", "setSourceName", "getStatus", "setStatus", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;I)Lcom/martian/mibook/mvvm/net/request/SearchBooksParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchBooksParams {
    private int ctype;

    @l
    private Integer freeType;

    @l
    private String keywords;

    @l
    private Integer maxWords;

    @l
    private Integer minWords;
    private int order;
    private int page;
    private int pageSize;
    private int searchType;

    @l
    private String sourceId;

    @l
    private String sourceName;

    @l
    private Integer status;

    public SearchBooksParams() {
        this(null, 0, 0, 0, 0, null, null, null, null, null, null, 0, 4095, null);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final String getKeywords() {
        return this.keywords;
    }

    @l
    /* renamed from: component10, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @l
    /* renamed from: component11, reason: from getter */
    public final Integer getFreeType() {
        return this.freeType;
    }

    /* renamed from: component12, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSearchType() {
        return this.searchType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCtype() {
        return this.ctype;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    /* renamed from: component8, reason: from getter */
    public final Integer getMaxWords() {
        return this.maxWords;
    }

    @l
    /* renamed from: component9, reason: from getter */
    public final Integer getMinWords() {
        return this.minWords;
    }

    @k
    public final SearchBooksParams copy(@l String keywords, int page, int pageSize, int searchType, int ctype, @l String sourceName, @l String sourceId, @l Integer maxWords, @l Integer minWords, @l Integer status, @l Integer freeType, int order) {
        return new SearchBooksParams(keywords, page, pageSize, searchType, ctype, sourceName, sourceId, maxWords, minWords, status, freeType, order);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof SearchBooksParams)) {
            return false;
        }
        SearchBooksParams searchBooksParams = (SearchBooksParams) r52;
        return Intrinsics.areEqual(this.keywords, searchBooksParams.keywords) && this.page == searchBooksParams.page && this.pageSize == searchBooksParams.pageSize && this.searchType == searchBooksParams.searchType && this.ctype == searchBooksParams.ctype && Intrinsics.areEqual(this.sourceName, searchBooksParams.sourceName) && Intrinsics.areEqual(this.sourceId, searchBooksParams.sourceId) && Intrinsics.areEqual(this.maxWords, searchBooksParams.maxWords) && Intrinsics.areEqual(this.minWords, searchBooksParams.minWords) && Intrinsics.areEqual(this.status, searchBooksParams.status) && Intrinsics.areEqual(this.freeType, searchBooksParams.freeType) && this.order == searchBooksParams.order;
    }

    public final int getCtype() {
        return this.ctype;
    }

    @l
    public final Integer getFreeType() {
        return this.freeType;
    }

    @l
    public final String getKeywords() {
        return this.keywords;
    }

    @l
    public final Integer getMaxWords() {
        return this.maxWords;
    }

    @l
    public final Integer getMinWords() {
        return this.minWords;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getSearchType() {
        return this.searchType;
    }

    @l
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    public final String getSourceName() {
        return this.sourceName;
    }

    @l
    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.keywords;
        int hashCode = (((((((((str == null ? 0 : str.hashCode()) * 31) + this.page) * 31) + this.pageSize) * 31) + this.searchType) * 31) + this.ctype) * 31;
        String str2 = this.sourceName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sourceId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.maxWords;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.minWords;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.status;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.freeType;
        return ((hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 31) + this.order;
    }

    public final void setCtype(int i10) {
        this.ctype = i10;
    }

    public final void setFreeType(@l Integer num) {
        this.freeType = num;
    }

    public final void setKeywords(@l String str) {
        this.keywords = str;
    }

    public final void setMaxWords(@l Integer num) {
        this.maxWords = num;
    }

    public final void setMinWords(@l Integer num) {
        this.minWords = num;
    }

    public final void setOrder(int i10) {
        this.order = i10;
    }

    public final void setPage(int i10) {
        this.page = i10;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public final void setSearchType(int i10) {
        this.searchType = i10;
    }

    public final void setSourceId(@l String str) {
        this.sourceId = str;
    }

    public final void setSourceName(@l String str) {
        this.sourceName = str;
    }

    public final void setStatus(@l Integer num) {
        this.status = num;
    }

    @k
    public String toString() {
        return "SearchBooksParams(keywords=" + this.keywords + ", page=" + this.page + ", pageSize=" + this.pageSize + ", searchType=" + this.searchType + ", ctype=" + this.ctype + ", sourceName=" + this.sourceName + ", sourceId=" + this.sourceId + ", maxWords=" + this.maxWords + ", minWords=" + this.minWords + ", status=" + this.status + ", freeType=" + this.freeType + ", order=" + this.order + ")";
    }

    public SearchBooksParams(@l String str, int i10, int i11, int i12, int i13, @l String str2, @l String str3, @l Integer num, @l Integer num2, @l Integer num3, @l Integer num4, int i14) {
        this.keywords = str;
        this.page = i10;
        this.pageSize = i11;
        this.searchType = i12;
        this.ctype = i13;
        this.sourceName = str2;
        this.sourceId = str3;
        this.maxWords = num;
        this.minWords = num2;
        this.status = num3;
        this.freeType = num4;
        this.order = i14;
    }

    public /* synthetic */ SearchBooksParams(String str, int i10, int i11, int i12, int i13, String str2, String str3, Integer num, Integer num2, Integer num3, Integer num4, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? null : str, (i15 & 2) != 0 ? 0 : i10, (i15 & 4) != 0 ? 10 : i11, (i15 & 8) != 0 ? 0 : i12, (i15 & 16) != 0 ? 0 : i13, (i15 & 32) != 0 ? null : str2, (i15 & 64) != 0 ? null : str3, (i15 & 128) != 0 ? null : num, (i15 & 256) != 0 ? null : num2, (i15 & 512) != 0 ? null : num3, (i15 & 1024) == 0 ? num4 : null, (i15 & 2048) == 0 ? i14 : 0);
    }
}
