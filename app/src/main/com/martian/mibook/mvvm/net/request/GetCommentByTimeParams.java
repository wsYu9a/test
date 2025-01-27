package com.martian.mibook.mvvm.net.request;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010+\u001a\u00020\u0003HÆ\u0003J`\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001d¨\u00063"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/GetCommentByTimeParams;", "", "type", "", "sourceName", "", "sourceId", "chapterId", "paragraphIdx", "lastCreatedOn", "", "pageSize", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;I)V", "getChapterId", "()Ljava/lang/String;", "setChapterId", "(Ljava/lang/String;)V", "getLastCreatedOn", "()Ljava/lang/Long;", "setLastCreatedOn", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPageSize", "()I", "setPageSize", "(I)V", "getParagraphIdx", "()Ljava/lang/Integer;", "setParagraphIdx", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSourceId", "setSourceId", "getSourceName", "setSourceName", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;I)Lcom/martian/mibook/mvvm/net/request/GetCommentByTimeParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GetCommentByTimeParams {

    @l
    private String chapterId;

    @l
    private Long lastCreatedOn;
    private int pageSize;

    @l
    private Integer paragraphIdx;

    @l
    private String sourceId;

    @l
    private String sourceName;

    @l
    private Integer type;

    public GetCommentByTimeParams() {
        this(null, null, null, null, null, null, 0, 127, null);
    }

    public static /* synthetic */ GetCommentByTimeParams copy$default(GetCommentByTimeParams getCommentByTimeParams, Integer num, String str, String str2, String str3, Integer num2, Long l10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = getCommentByTimeParams.type;
        }
        if ((i11 & 2) != 0) {
            str = getCommentByTimeParams.sourceName;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            str2 = getCommentByTimeParams.sourceId;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            str3 = getCommentByTimeParams.chapterId;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            num2 = getCommentByTimeParams.paragraphIdx;
        }
        Integer num3 = num2;
        if ((i11 & 32) != 0) {
            l10 = getCommentByTimeParams.lastCreatedOn;
        }
        Long l11 = l10;
        if ((i11 & 64) != 0) {
            i10 = getCommentByTimeParams.pageSize;
        }
        return getCommentByTimeParams.copy(num, str4, str5, str6, num3, l11, i10);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final String getChapterId() {
        return this.chapterId;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final Integer getParagraphIdx() {
        return this.paragraphIdx;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final Long getLastCreatedOn() {
        return this.lastCreatedOn;
    }

    /* renamed from: component7, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    @k
    public final GetCommentByTimeParams copy(@l Integer type, @l String sourceName, @l String sourceId, @l String chapterId, @l Integer paragraphIdx, @l Long lastCreatedOn, int pageSize) {
        return new GetCommentByTimeParams(type, sourceName, sourceId, chapterId, paragraphIdx, lastCreatedOn, pageSize);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof GetCommentByTimeParams)) {
            return false;
        }
        GetCommentByTimeParams getCommentByTimeParams = (GetCommentByTimeParams) r52;
        return Intrinsics.areEqual(this.type, getCommentByTimeParams.type) && Intrinsics.areEqual(this.sourceName, getCommentByTimeParams.sourceName) && Intrinsics.areEqual(this.sourceId, getCommentByTimeParams.sourceId) && Intrinsics.areEqual(this.chapterId, getCommentByTimeParams.chapterId) && Intrinsics.areEqual(this.paragraphIdx, getCommentByTimeParams.paragraphIdx) && Intrinsics.areEqual(this.lastCreatedOn, getCommentByTimeParams.lastCreatedOn) && this.pageSize == getCommentByTimeParams.pageSize;
    }

    @l
    public final String getChapterId() {
        return this.chapterId;
    }

    @l
    public final Long getLastCreatedOn() {
        return this.lastCreatedOn;
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
        String str = this.sourceName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sourceId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.chapterId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.paragraphIdx;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.lastCreatedOn;
        return ((hashCode5 + (l10 != null ? l10.hashCode() : 0)) * 31) + this.pageSize;
    }

    public final void setChapterId(@l String str) {
        this.chapterId = str;
    }

    public final void setLastCreatedOn(@l Long l10) {
        this.lastCreatedOn = l10;
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
        return "GetCommentByTimeParams(type=" + this.type + ", sourceName=" + this.sourceName + ", sourceId=" + this.sourceId + ", chapterId=" + this.chapterId + ", paragraphIdx=" + this.paragraphIdx + ", lastCreatedOn=" + this.lastCreatedOn + ", pageSize=" + this.pageSize + ")";
    }

    public GetCommentByTimeParams(@l Integer num, @l String str, @l String str2, @l String str3, @l Integer num2, @l Long l10, int i10) {
        this.type = num;
        this.sourceName = str;
        this.sourceId = str2;
        this.chapterId = str3;
        this.paragraphIdx = num2;
        this.lastCreatedOn = l10;
        this.pageSize = i10;
    }

    public /* synthetic */ GetCommentByTimeParams(Integer num, String str, String str2, String str3, Integer num2, Long l10, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : num2, (i11 & 32) == 0 ? l10 : null, (i11 & 64) != 0 ? 10 : i10);
    }
}
