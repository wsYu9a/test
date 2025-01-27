package com.martian.mibook.mvvm.net.request;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010'\u001a\u00020\u0003HÆ\u0003J`\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013¨\u0006/"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/GetCommentByScoreParams;", "", "type", "", "page", "sourceName", "", "sourceId", "chapterId", "paragraphIdx", "pageSize", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "getChapterId", "()Ljava/lang/String;", "setChapterId", "(Ljava/lang/String;)V", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPageSize", "()I", "setPageSize", "(I)V", "getParagraphIdx", "setParagraphIdx", "getSourceId", "setSourceId", "getSourceName", "setSourceName", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)Lcom/martian/mibook/mvvm/net/request/GetCommentByScoreParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GetCommentByScoreParams {

    @l
    private String chapterId;

    @l
    private Integer page;
    private int pageSize;

    @l
    private Integer paragraphIdx;

    @l
    private String sourceId;

    @l
    private String sourceName;

    @l
    private Integer type;

    public GetCommentByScoreParams() {
        this(null, null, null, null, null, null, 0, 127, null);
    }

    public static /* synthetic */ GetCommentByScoreParams copy$default(GetCommentByScoreParams getCommentByScoreParams, Integer num, Integer num2, String str, String str2, String str3, Integer num3, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = getCommentByScoreParams.type;
        }
        if ((i11 & 2) != 0) {
            num2 = getCommentByScoreParams.page;
        }
        Integer num4 = num2;
        if ((i11 & 4) != 0) {
            str = getCommentByScoreParams.sourceName;
        }
        String str4 = str;
        if ((i11 & 8) != 0) {
            str2 = getCommentByScoreParams.sourceId;
        }
        String str5 = str2;
        if ((i11 & 16) != 0) {
            str3 = getCommentByScoreParams.chapterId;
        }
        String str6 = str3;
        if ((i11 & 32) != 0) {
            num3 = getCommentByScoreParams.paragraphIdx;
        }
        Integer num5 = num3;
        if ((i11 & 64) != 0) {
            i10 = getCommentByScoreParams.pageSize;
        }
        return getCommentByScoreParams.copy(num, num4, str4, str5, str6, num5, i10);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final Integer getPage() {
        return this.page;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final String getChapterId() {
        return this.chapterId;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final Integer getParagraphIdx() {
        return this.paragraphIdx;
    }

    /* renamed from: component7, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    @k
    public final GetCommentByScoreParams copy(@l Integer type, @l Integer page, @l String sourceName, @l String sourceId, @l String chapterId, @l Integer paragraphIdx, int pageSize) {
        return new GetCommentByScoreParams(type, page, sourceName, sourceId, chapterId, paragraphIdx, pageSize);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof GetCommentByScoreParams)) {
            return false;
        }
        GetCommentByScoreParams getCommentByScoreParams = (GetCommentByScoreParams) r52;
        return Intrinsics.areEqual(this.type, getCommentByScoreParams.type) && Intrinsics.areEqual(this.page, getCommentByScoreParams.page) && Intrinsics.areEqual(this.sourceName, getCommentByScoreParams.sourceName) && Intrinsics.areEqual(this.sourceId, getCommentByScoreParams.sourceId) && Intrinsics.areEqual(this.chapterId, getCommentByScoreParams.chapterId) && Intrinsics.areEqual(this.paragraphIdx, getCommentByScoreParams.paragraphIdx) && this.pageSize == getCommentByScoreParams.pageSize;
    }

    @l
    public final String getChapterId() {
        return this.chapterId;
    }

    @l
    public final Integer getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @l
    public final Integer getParagraphIdx() {
        return this.paragraphIdx;
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
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.type;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.page;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.sourceName;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sourceId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.chapterId;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.paragraphIdx;
        return ((hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 31) + this.pageSize;
    }

    public final void setChapterId(@l String str) {
        this.chapterId = str;
    }

    public final void setPage(@l Integer num) {
        this.page = num;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public final void setParagraphIdx(@l Integer num) {
        this.paragraphIdx = num;
    }

    public final void setSourceId(@l String str) {
        this.sourceId = str;
    }

    public final void setSourceName(@l String str) {
        this.sourceName = str;
    }

    public final void setType(@l Integer num) {
        this.type = num;
    }

    @k
    public String toString() {
        return "GetCommentByScoreParams(type=" + this.type + ", page=" + this.page + ", sourceName=" + this.sourceName + ", sourceId=" + this.sourceId + ", chapterId=" + this.chapterId + ", paragraphIdx=" + this.paragraphIdx + ", pageSize=" + this.pageSize + ")";
    }

    public GetCommentByScoreParams(@l Integer num, @l Integer num2, @l String str, @l String str2, @l String str3, @l Integer num3, int i10) {
        this.type = num;
        this.page = num2;
        this.sourceName = str;
        this.sourceId = str2;
        this.chapterId = str3;
        this.paragraphIdx = num3;
        this.pageSize = i10;
    }

    public /* synthetic */ GetCommentByScoreParams(Integer num, Integer num2, String str, String str2, String str3, Integer num3, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : num2, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) == 0 ? num3 : null, (i11 & 64) != 0 ? 10 : i10);
    }
}
