package com.martian.mibook.mvvm.net.request;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003JR\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0006\u0010*\u001a\u00020+J\t\u0010,\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u0006-"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/YWBookChannelBooksParams;", "", "page", "", "pageSize", "mcid", "seed", "category", "", "ext", "(Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getExt", "setExt", "getMcid", "()I", "setMcid", "(I)V", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPageSize", "setPageSize", "getSeed", "setSeed", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/String;)Lcom/martian/mibook/mvvm/net/request/YWBookChannelBooksParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "makeSpeed", "", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class YWBookChannelBooksParams {

    @l
    private String category;

    @l
    private String ext;
    private int mcid;

    @l
    private Integer page;

    @l
    private Integer pageSize;
    private int seed;

    public YWBookChannelBooksParams() {
        this(null, null, 0, 0, null, null, 63, null);
    }

    public static /* synthetic */ YWBookChannelBooksParams copy$default(YWBookChannelBooksParams yWBookChannelBooksParams, Integer num, Integer num2, int i10, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            num = yWBookChannelBooksParams.page;
        }
        if ((i12 & 2) != 0) {
            num2 = yWBookChannelBooksParams.pageSize;
        }
        Integer num3 = num2;
        if ((i12 & 4) != 0) {
            i10 = yWBookChannelBooksParams.mcid;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = yWBookChannelBooksParams.seed;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            str = yWBookChannelBooksParams.category;
        }
        String str3 = str;
        if ((i12 & 32) != 0) {
            str2 = yWBookChannelBooksParams.ext;
        }
        return yWBookChannelBooksParams.copy(num, num3, i13, i14, str3, str2);
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

    /* renamed from: component3, reason: from getter */
    public final int getMcid() {
        return this.mcid;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSeed() {
        return this.seed;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final String getExt() {
        return this.ext;
    }

    @k
    public final YWBookChannelBooksParams copy(@l Integer page, @l Integer pageSize, int mcid, int seed, @l String category, @l String ext) {
        return new YWBookChannelBooksParams(page, pageSize, mcid, seed, category, ext);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof YWBookChannelBooksParams)) {
            return false;
        }
        YWBookChannelBooksParams yWBookChannelBooksParams = (YWBookChannelBooksParams) r52;
        return Intrinsics.areEqual(this.page, yWBookChannelBooksParams.page) && Intrinsics.areEqual(this.pageSize, yWBookChannelBooksParams.pageSize) && this.mcid == yWBookChannelBooksParams.mcid && this.seed == yWBookChannelBooksParams.seed && Intrinsics.areEqual(this.category, yWBookChannelBooksParams.category) && Intrinsics.areEqual(this.ext, yWBookChannelBooksParams.ext);
    }

    @l
    public final String getCategory() {
        return this.category;
    }

    @l
    public final String getExt() {
        return this.ext;
    }

    public final int getMcid() {
        return this.mcid;
    }

    @l
    public final Integer getPage() {
        return this.page;
    }

    @l
    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final int getSeed() {
        return this.seed;
    }

    public int hashCode() {
        Integer num = this.page;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.pageSize;
        int hashCode2 = (((((hashCode + (num2 == null ? 0 : num2.hashCode())) * 31) + this.mcid) * 31) + this.seed) * 31;
        String str = this.category;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ext;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void makeSpeed() {
        this.seed = new Random().nextInt(10000);
    }

    public final void setCategory(@l String str) {
        this.category = str;
    }

    public final void setExt(@l String str) {
        this.ext = str;
    }

    public final void setMcid(int i10) {
        this.mcid = i10;
    }

    public final void setPage(@l Integer num) {
        this.page = num;
    }

    public final void setPageSize(@l Integer num) {
        this.pageSize = num;
    }

    public final void setSeed(int i10) {
        this.seed = i10;
    }

    @k
    public String toString() {
        return "YWBookChannelBooksParams(page=" + this.page + ", pageSize=" + this.pageSize + ", mcid=" + this.mcid + ", seed=" + this.seed + ", category=" + this.category + ", ext=" + this.ext + ")";
    }

    public YWBookChannelBooksParams(@l Integer num, @l Integer num2, int i10, int i11, @l String str, @l String str2) {
        this.page = num;
        this.pageSize = num2;
        this.mcid = i10;
        this.seed = i11;
        this.category = str;
        this.ext = str2;
    }

    public /* synthetic */ YWBookChannelBooksParams(Integer num, Integer num2, int i10, int i11, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : num, (i12 & 2) != 0 ? 10 : num2, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) == 0 ? i11 : 0, (i12 & 16) != 0 ? null : str, (i12 & 32) != 0 ? null : str2);
    }
}
