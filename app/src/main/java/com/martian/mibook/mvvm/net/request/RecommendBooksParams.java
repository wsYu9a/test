package com.martian.mibook.mvvm.net.request;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011Jb\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006-"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/RecommendBooksParams;", "", "page", "", "pageSize", "searchType", "sourceName", "", "sourceId", "keywords", "seed", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getKeywords", "()Ljava/lang/String;", "setKeywords", "(Ljava/lang/String;)V", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPageSize", "setPageSize", "getSearchType", "setSearchType", "getSeed", "setSeed", "getSourceId", "setSourceId", "getSourceName", "setSourceName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/martian/mibook/mvvm/net/request/RecommendBooksParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RecommendBooksParams {

    @l
    private String keywords;

    @l
    private Integer page;

    @l
    private Integer pageSize;

    @l
    private Integer searchType;

    @l
    private Integer seed;

    @l
    private String sourceId;

    @l
    private String sourceName;

    public RecommendBooksParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ RecommendBooksParams copy$default(RecommendBooksParams recommendBooksParams, Integer num, Integer num2, Integer num3, String str, String str2, String str3, Integer num4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = recommendBooksParams.page;
        }
        if ((i10 & 2) != 0) {
            num2 = recommendBooksParams.pageSize;
        }
        Integer num5 = num2;
        if ((i10 & 4) != 0) {
            num3 = recommendBooksParams.searchType;
        }
        Integer num6 = num3;
        if ((i10 & 8) != 0) {
            str = recommendBooksParams.sourceName;
        }
        String str4 = str;
        if ((i10 & 16) != 0) {
            str2 = recommendBooksParams.sourceId;
        }
        String str5 = str2;
        if ((i10 & 32) != 0) {
            str3 = recommendBooksParams.keywords;
        }
        String str6 = str3;
        if ((i10 & 64) != 0) {
            num4 = recommendBooksParams.seed;
        }
        return recommendBooksParams.copy(num, num5, num6, str4, str5, str6, num4);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Integer getPage() {
        return this.page;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final Integer getPageSize() {
        return this.pageSize;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final Integer getSearchType() {
        return this.searchType;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final String getKeywords() {
        return this.keywords;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final Integer getSeed() {
        return this.seed;
    }

    @k
    public final RecommendBooksParams copy(@l Integer page, @l Integer pageSize, @l Integer searchType, @l String sourceName, @l String sourceId, @l String keywords, @l Integer seed) {
        return new RecommendBooksParams(page, pageSize, searchType, sourceName, sourceId, keywords, seed);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof RecommendBooksParams)) {
            return false;
        }
        RecommendBooksParams recommendBooksParams = (RecommendBooksParams) r52;
        return Intrinsics.areEqual(this.page, recommendBooksParams.page) && Intrinsics.areEqual(this.pageSize, recommendBooksParams.pageSize) && Intrinsics.areEqual(this.searchType, recommendBooksParams.searchType) && Intrinsics.areEqual(this.sourceName, recommendBooksParams.sourceName) && Intrinsics.areEqual(this.sourceId, recommendBooksParams.sourceId) && Intrinsics.areEqual(this.keywords, recommendBooksParams.keywords) && Intrinsics.areEqual(this.seed, recommendBooksParams.seed);
    }

    @l
    public final String getKeywords() {
        return this.keywords;
    }

    @l
    public final Integer getPage() {
        return this.page;
    }

    @l
    public final Integer getPageSize() {
        return this.pageSize;
    }

    @l
    public final Integer getSearchType() {
        return this.searchType;
    }

    @l
    public final Integer getSeed() {
        return this.seed;
    }

    @l
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    public final String getSourceName() {
        return this.sourceName;
    }

    public int hashCode() {
        Integer num = this.page;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.pageSize;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.searchType;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.sourceName;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sourceId;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.keywords;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num4 = this.seed;
        return hashCode6 + (num4 != null ? num4.hashCode() : 0);
    }

    public final void setKeywords(@l String str) {
        this.keywords = str;
    }

    public final void setPage(@l Integer num) {
        this.page = num;
    }

    public final void setPageSize(@l Integer num) {
        this.pageSize = num;
    }

    public final void setSearchType(@l Integer num) {
        this.searchType = num;
    }

    public final void setSeed(@l Integer num) {
        this.seed = num;
    }

    public final void setSourceId(@l String str) {
        this.sourceId = str;
    }

    public final void setSourceName(@l String str) {
        this.sourceName = str;
    }

    @k
    public String toString() {
        return "RecommendBooksParams(page=" + this.page + ", pageSize=" + this.pageSize + ", searchType=" + this.searchType + ", sourceName=" + this.sourceName + ", sourceId=" + this.sourceId + ", keywords=" + this.keywords + ", seed=" + this.seed + ")";
    }

    public RecommendBooksParams(@l Integer num, @l Integer num2, @l Integer num3, @l String str, @l String str2, @l String str3, @l Integer num4) {
        this.page = num;
        this.pageSize = num2;
        this.searchType = num3;
        this.sourceName = str;
        this.sourceId = str2;
        this.keywords = str3;
        this.seed = num4;
    }

    public /* synthetic */ RecommendBooksParams(Integer num, Integer num2, Integer num3, String str, String str2, String str3, Integer num4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : num3, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : num4);
    }
}
