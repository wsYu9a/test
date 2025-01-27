package com.martian.mibook.mvvm.net.request;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;
import z8.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ²\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\u0003HÖ\u0001J\u0015\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u0015\u0010Q\u001a\u00020O2\b\u0010R\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u0015\u0010S\u001a\u00020O2\b\u0010T\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u0015\u0010U\u001a\u00020O2\b\u0010V\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u0015\u0010W\u001a\u00020O2\b\u0010X\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\t\u0010Y\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001e\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001cR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017¨\u0006Z"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;", "", "freeType", "", "categoryId", "subCategoryId", "page", "pageSize", "wordCountLower", "wordCountUpper", "status", "completeAfter", "", "publicAfter", "updateAfter", "order", "tags", "", TypedValues.TransitionType.S_FROM, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getCategoryId", "()Ljava/lang/Integer;", "setCategoryId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCompleteAfter", "()Ljava/lang/Long;", "setCompleteAfter", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFreeType", "setFreeType", "getFrom", "setFrom", "getOrder", "setOrder", "getPage", "()I", "setPage", "(I)V", "getPageSize", "setPageSize", "getPublicAfter", "setPublicAfter", "getStatus", "setStatus", "getSubCategoryId", "setSubCategoryId", "getTags", "()Ljava/lang/String;", "setTags", "(Ljava/lang/String;)V", "getUpdateAfter", "setUpdateAfter", "getWordCountLower", "setWordCountLower", "getWordCountUpper", "setWordCountUpper", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/martian/mibook/mvvm/net/request/YWCategoryBookListParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "setCompletePosition", "", "completePosition", "setOrderPosition", "orderPosition", "setPublicPosition", "publicPosition", "setStatusPosition", "statusPosition", "setWordCount", "numberPosition", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class YWCategoryBookListParams {

    @l
    private Integer categoryId;

    @l
    private Long completeAfter;

    @l
    private Integer freeType;

    @l
    private Integer from;

    @l
    private Integer order;
    private int page;
    private int pageSize;

    @l
    private Long publicAfter;

    @l
    private Integer status;

    @l
    private Integer subCategoryId;

    @l
    private String tags;

    @l
    private Long updateAfter;

    @l
    private Integer wordCountLower;

    @l
    private Integer wordCountUpper;

    public YWCategoryBookListParams() {
        this(null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Integer getFreeType() {
        return this.freeType;
    }

    @l
    /* renamed from: component10, reason: from getter */
    public final Long getPublicAfter() {
        return this.publicAfter;
    }

    @l
    /* renamed from: component11, reason: from getter */
    public final Long getUpdateAfter() {
        return this.updateAfter;
    }

    @l
    /* renamed from: component12, reason: from getter */
    public final Integer getOrder() {
        return this.order;
    }

    @l
    /* renamed from: component13, reason: from getter */
    public final String getTags() {
        return this.tags;
    }

    @l
    /* renamed from: component14, reason: from getter */
    public final Integer getFrom() {
        return this.from;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final Integer getCategoryId() {
        return this.categoryId;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final Integer getWordCountLower() {
        return this.wordCountLower;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final Integer getWordCountUpper() {
        return this.wordCountUpper;
    }

    @l
    /* renamed from: component8, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @l
    /* renamed from: component9, reason: from getter */
    public final Long getCompleteAfter() {
        return this.completeAfter;
    }

    @k
    public final YWCategoryBookListParams copy(@l Integer freeType, @l Integer categoryId, @l Integer subCategoryId, int page, int pageSize, @l Integer wordCountLower, @l Integer wordCountUpper, @l Integer status, @l Long completeAfter, @l Long publicAfter, @l Long updateAfter, @l Integer order, @l String tags, @l Integer r30) {
        return new YWCategoryBookListParams(freeType, categoryId, subCategoryId, page, pageSize, wordCountLower, wordCountUpper, status, completeAfter, publicAfter, updateAfter, order, tags, r30);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof YWCategoryBookListParams)) {
            return false;
        }
        YWCategoryBookListParams yWCategoryBookListParams = (YWCategoryBookListParams) r52;
        return Intrinsics.areEqual(this.freeType, yWCategoryBookListParams.freeType) && Intrinsics.areEqual(this.categoryId, yWCategoryBookListParams.categoryId) && Intrinsics.areEqual(this.subCategoryId, yWCategoryBookListParams.subCategoryId) && this.page == yWCategoryBookListParams.page && this.pageSize == yWCategoryBookListParams.pageSize && Intrinsics.areEqual(this.wordCountLower, yWCategoryBookListParams.wordCountLower) && Intrinsics.areEqual(this.wordCountUpper, yWCategoryBookListParams.wordCountUpper) && Intrinsics.areEqual(this.status, yWCategoryBookListParams.status) && Intrinsics.areEqual(this.completeAfter, yWCategoryBookListParams.completeAfter) && Intrinsics.areEqual(this.publicAfter, yWCategoryBookListParams.publicAfter) && Intrinsics.areEqual(this.updateAfter, yWCategoryBookListParams.updateAfter) && Intrinsics.areEqual(this.order, yWCategoryBookListParams.order) && Intrinsics.areEqual(this.tags, yWCategoryBookListParams.tags) && Intrinsics.areEqual(this.from, yWCategoryBookListParams.from);
    }

    @l
    public final Integer getCategoryId() {
        return this.categoryId;
    }

    @l
    public final Long getCompleteAfter() {
        return this.completeAfter;
    }

    @l
    public final Integer getFreeType() {
        return this.freeType;
    }

    @l
    public final Integer getFrom() {
        return this.from;
    }

    @l
    public final Integer getOrder() {
        return this.order;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @l
    public final Long getPublicAfter() {
        return this.publicAfter;
    }

    @l
    public final Integer getStatus() {
        return this.status;
    }

    @l
    public final Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    @l
    public final String getTags() {
        return this.tags;
    }

    @l
    public final Long getUpdateAfter() {
        return this.updateAfter;
    }

    @l
    public final Integer getWordCountLower() {
        return this.wordCountLower;
    }

    @l
    public final Integer getWordCountUpper() {
        return this.wordCountUpper;
    }

    public int hashCode() {
        Integer num = this.freeType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.categoryId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.subCategoryId;
        int hashCode3 = (((((hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.page) * 31) + this.pageSize) * 31;
        Integer num4 = this.wordCountLower;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.wordCountUpper;
        int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.status;
        int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Long l10 = this.completeAfter;
        int hashCode7 = (hashCode6 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.publicAfter;
        int hashCode8 = (hashCode7 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.updateAfter;
        int hashCode9 = (hashCode8 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Integer num7 = this.order;
        int hashCode10 = (hashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str = this.tags;
        int hashCode11 = (hashCode10 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num8 = this.from;
        return hashCode11 + (num8 != null ? num8.hashCode() : 0);
    }

    public final void setCategoryId(@l Integer num) {
        this.categoryId = num;
    }

    public final void setCompleteAfter(@l Long l10) {
        this.completeAfter = l10;
    }

    public final void setCompletePosition(@l Integer completePosition) {
        this.completeAfter = (completePosition != null && completePosition.intValue() == 1) ? Long.valueOf(h.f33712a.a()) : (completePosition != null && completePosition.intValue() == 2) ? Long.valueOf(h.f33712a.c()) : (completePosition != null && completePosition.intValue() == 3) ? Long.valueOf(h.f33712a.b()) : null;
    }

    public final void setFreeType(@l Integer num) {
        this.freeType = num;
    }

    public final void setFrom(@l Integer num) {
        this.from = num;
    }

    public final void setOrder(@l Integer num) {
        this.order = num;
    }

    public final void setOrderPosition(@l Integer orderPosition) {
        int i10 = 0;
        if (orderPosition == null || orderPosition.intValue() != 0) {
            if (orderPosition != null && orderPosition.intValue() == 1) {
                i10 = 1;
            } else if (orderPosition != null && orderPosition.intValue() == 2) {
                i10 = 2;
            }
        }
        this.order = i10;
    }

    public final void setPage(int i10) {
        this.page = i10;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    public final void setPublicAfter(@l Long l10) {
        this.publicAfter = l10;
    }

    public final void setPublicPosition(@l Integer publicPosition) {
        this.publicAfter = (publicPosition != null && publicPosition.intValue() == 1) ? Long.valueOf(h.f33712a.d()) : (publicPosition != null && publicPosition.intValue() == 2) ? Long.valueOf(h.f33712a.c()) : null;
    }

    public final void setStatus(@l Integer num) {
        this.status = num;
    }

    public final void setStatusPosition(@l Integer statusPosition) {
        int i10 = 0;
        if (statusPosition == null || statusPosition.intValue() != 0) {
            if (statusPosition != null && statusPosition.intValue() == 1) {
                i10 = 50;
            } else if (statusPosition != null && statusPosition.intValue() == 2) {
                i10 = 30;
            } else if (statusPosition != null && statusPosition.intValue() == 3) {
                i10 = 10;
            }
        }
        this.status = i10;
    }

    public final void setSubCategoryId(@l Integer num) {
        this.subCategoryId = num;
    }

    public final void setTags(@l String str) {
        this.tags = str;
    }

    public final void setUpdateAfter(@l Long l10) {
        this.updateAfter = l10;
    }

    public final void setWordCount(@l Integer numberPosition) {
        if (numberPosition != null && numberPosition.intValue() == 0) {
            this.wordCountLower = null;
            this.wordCountUpper = null;
            return;
        }
        if (numberPosition != null && numberPosition.intValue() == 1) {
            this.wordCountLower = null;
            this.wordCountUpper = 1000000;
            return;
        }
        if (numberPosition != null && numberPosition.intValue() == 2) {
            this.wordCountLower = 1000000;
            this.wordCountUpper = 3000000;
        } else if (numberPosition != null && numberPosition.intValue() == 3) {
            this.wordCountLower = 3000000;
            this.wordCountUpper = null;
        } else {
            this.wordCountLower = null;
            this.wordCountUpper = null;
        }
    }

    public final void setWordCountLower(@l Integer num) {
        this.wordCountLower = num;
    }

    public final void setWordCountUpper(@l Integer num) {
        this.wordCountUpper = num;
    }

    @k
    public String toString() {
        return "YWCategoryBookListParams(freeType=" + this.freeType + ", categoryId=" + this.categoryId + ", subCategoryId=" + this.subCategoryId + ", page=" + this.page + ", pageSize=" + this.pageSize + ", wordCountLower=" + this.wordCountLower + ", wordCountUpper=" + this.wordCountUpper + ", status=" + this.status + ", completeAfter=" + this.completeAfter + ", publicAfter=" + this.publicAfter + ", updateAfter=" + this.updateAfter + ", order=" + this.order + ", tags=" + this.tags + ", from=" + this.from + ")";
    }

    public YWCategoryBookListParams(@l Integer num, @l Integer num2, @l Integer num3, int i10, int i11, @l Integer num4, @l Integer num5, @l Integer num6, @l Long l10, @l Long l11, @l Long l12, @l Integer num7, @l String str, @l Integer num8) {
        this.freeType = num;
        this.categoryId = num2;
        this.subCategoryId = num3;
        this.page = i10;
        this.pageSize = i11;
        this.wordCountLower = num4;
        this.wordCountUpper = num5;
        this.status = num6;
        this.completeAfter = l10;
        this.publicAfter = l11;
        this.updateAfter = l12;
        this.order = num7;
        this.tags = str;
        this.from = num8;
    }

    public /* synthetic */ YWCategoryBookListParams(Integer num, Integer num2, Integer num3, int i10, int i11, Integer num4, Integer num5, Integer num6, Long l10, Long l11, Long l12, Integer num7, String str, Integer num8, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : num, (i12 & 2) != 0 ? null : num2, (i12 & 4) != 0 ? null : num3, (i12 & 8) != 0 ? 0 : i10, (i12 & 16) != 0 ? 10 : i11, (i12 & 32) != 0 ? null : num4, (i12 & 64) != 0 ? null : num5, (i12 & 128) != 0 ? null : num6, (i12 & 256) != 0 ? null : l10, (i12 & 512) != 0 ? null : l11, (i12 & 1024) != 0 ? null : l12, (i12 & 2048) != 0 ? null : num7, (i12 & 4096) != 0 ? null : str, (i12 & 8192) == 0 ? num8 : null);
    }
}
