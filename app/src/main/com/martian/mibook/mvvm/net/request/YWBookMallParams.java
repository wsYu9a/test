package com.martian.mibook.mvvm.net.request;

import c7.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003JZ\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0006\u0010.\u001a\u00020/J\t\u00100\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000f¨\u00061"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/YWBookMallParams;", "", "page", "", "pageSize", g.f1744b, "seed", "ctype", "tid", "ext", "", "(Ljava/lang/Integer;Ljava/lang/Integer;IIIILjava/lang/String;)V", "getCount", "()I", "setCount", "(I)V", "getCtype", "setCtype", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPageSize", "setPageSize", "getSeed", "setSeed", "getTid", "setTid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;IIIILjava/lang/String;)Lcom/martian/mibook/mvvm/net/request/YWBookMallParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "makeSpeed", "", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class YWBookMallParams {
    private int count;
    private int ctype;

    @l
    private String ext;

    @l
    private Integer page;

    @l
    private Integer pageSize;
    private int seed;
    private int tid;

    public YWBookMallParams() {
        this(null, null, 0, 0, 0, 0, null, 127, null);
    }

    public static /* synthetic */ YWBookMallParams copy$default(YWBookMallParams yWBookMallParams, Integer num, Integer num2, int i10, int i11, int i12, int i13, String str, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            num = yWBookMallParams.page;
        }
        if ((i14 & 2) != 0) {
            num2 = yWBookMallParams.pageSize;
        }
        Integer num3 = num2;
        if ((i14 & 4) != 0) {
            i10 = yWBookMallParams.count;
        }
        int i15 = i10;
        if ((i14 & 8) != 0) {
            i11 = yWBookMallParams.seed;
        }
        int i16 = i11;
        if ((i14 & 16) != 0) {
            i12 = yWBookMallParams.ctype;
        }
        int i17 = i12;
        if ((i14 & 32) != 0) {
            i13 = yWBookMallParams.tid;
        }
        int i18 = i13;
        if ((i14 & 64) != 0) {
            str = yWBookMallParams.ext;
        }
        return yWBookMallParams.copy(num, num3, i15, i16, i17, i18, str);
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
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSeed() {
        return this.seed;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCtype() {
        return this.ctype;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTid() {
        return this.tid;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final String getExt() {
        return this.ext;
    }

    @k
    public final YWBookMallParams copy(@l Integer page, @l Integer pageSize, int r12, int seed, int ctype, int tid, @l String ext) {
        return new YWBookMallParams(page, pageSize, r12, seed, ctype, tid, ext);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof YWBookMallParams)) {
            return false;
        }
        YWBookMallParams yWBookMallParams = (YWBookMallParams) r52;
        return Intrinsics.areEqual(this.page, yWBookMallParams.page) && Intrinsics.areEqual(this.pageSize, yWBookMallParams.pageSize) && this.count == yWBookMallParams.count && this.seed == yWBookMallParams.seed && this.ctype == yWBookMallParams.ctype && this.tid == yWBookMallParams.tid && Intrinsics.areEqual(this.ext, yWBookMallParams.ext);
    }

    public final int getCount() {
        return this.count;
    }

    public final int getCtype() {
        return this.ctype;
    }

    @l
    public final String getExt() {
        return this.ext;
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

    public final int getTid() {
        return this.tid;
    }

    public int hashCode() {
        Integer num = this.page;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.pageSize;
        int hashCode2 = (((((((((hashCode + (num2 == null ? 0 : num2.hashCode())) * 31) + this.count) * 31) + this.seed) * 31) + this.ctype) * 31) + this.tid) * 31;
        String str = this.ext;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void makeSpeed() {
        this.seed = new Random().nextInt(10000);
    }

    public final void setCount(int i10) {
        this.count = i10;
    }

    public final void setCtype(int i10) {
        this.ctype = i10;
    }

    public final void setExt(@l String str) {
        this.ext = str;
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

    public final void setTid(int i10) {
        this.tid = i10;
    }

    @k
    public String toString() {
        return "YWBookMallParams(page=" + this.page + ", pageSize=" + this.pageSize + ", count=" + this.count + ", seed=" + this.seed + ", ctype=" + this.ctype + ", tid=" + this.tid + ", ext=" + this.ext + ")";
    }

    public YWBookMallParams(@l Integer num, @l Integer num2, int i10, int i11, int i12, int i13, @l String str) {
        this.page = num;
        this.pageSize = num2;
        this.count = i10;
        this.seed = i11;
        this.ctype = i12;
        this.tid = i13;
        this.ext = str;
    }

    public /* synthetic */ YWBookMallParams(Integer num, Integer num2, int i10, int i11, int i12, int i13, String str, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? 0 : num, (i14 & 2) != 0 ? 10 : num2, (i14 & 4) != 0 ? 0 : i10, (i14 & 8) != 0 ? 0 : i11, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) == 0 ? i13 : 0, (i14 & 64) != 0 ? null : str);
    }
}
