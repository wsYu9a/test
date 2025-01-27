package com.martian.mibook.mvvm.net.request;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014Jn\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016¨\u00061"}, d2 = {"Lcom/martian/mibook/mvvm/net/request/RtParams;", "", "d", "", "s", "", "c", "cs", "ci", "ccid", "v", "seq", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getC", "()Ljava/lang/String;", "setC", "(Ljava/lang/String;)V", "getCcid", "setCcid", "getCi", "()Ljava/lang/Integer;", "setCi", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCs", "setCs", "getD", "setD", "getS", "setS", "getSeq", "setSeq", "getV", "setV", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/martian/mibook/mvvm/net/request/RtParams;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RtParams {

    @l
    private String c;

    @l
    private String ccid;

    @l
    private Integer ci;

    @l
    private Integer cs;

    @l
    private Integer d;

    @l
    private String s;

    @l
    private Integer seq;

    @l
    private Integer v;

    public RtParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Integer getD() {
        return this.d;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final String getS() {
        return this.s;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final String getC() {
        return this.c;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final Integer getCs() {
        return this.cs;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final Integer getCi() {
        return this.ci;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final String getCcid() {
        return this.ccid;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final Integer getV() {
        return this.v;
    }

    @l
    /* renamed from: component8, reason: from getter */
    public final Integer getSeq() {
        return this.seq;
    }

    @k
    public final RtParams copy(@l Integer d10, @l String s10, @l String c10, @l Integer cs, @l Integer ci2, @l String ccid, @l Integer v10, @l Integer seq) {
        return new RtParams(d10, s10, c10, cs, ci2, ccid, v10, seq);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof RtParams)) {
            return false;
        }
        RtParams rtParams = (RtParams) r52;
        return Intrinsics.areEqual(this.d, rtParams.d) && Intrinsics.areEqual(this.s, rtParams.s) && Intrinsics.areEqual(this.c, rtParams.c) && Intrinsics.areEqual(this.cs, rtParams.cs) && Intrinsics.areEqual(this.ci, rtParams.ci) && Intrinsics.areEqual(this.ccid, rtParams.ccid) && Intrinsics.areEqual(this.v, rtParams.v) && Intrinsics.areEqual(this.seq, rtParams.seq);
    }

    @l
    public final String getC() {
        return this.c;
    }

    @l
    public final String getCcid() {
        return this.ccid;
    }

    @l
    public final Integer getCi() {
        return this.ci;
    }

    @l
    public final Integer getCs() {
        return this.cs;
    }

    @l
    public final Integer getD() {
        return this.d;
    }

    @l
    public final String getS() {
        return this.s;
    }

    @l
    public final Integer getSeq() {
        return this.seq;
    }

    @l
    public final Integer getV() {
        return this.v;
    }

    public int hashCode() {
        Integer num = this.d;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.s;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.cs;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.ci;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.ccid;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num4 = this.v;
        int hashCode7 = (hashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.seq;
        return hashCode7 + (num5 != null ? num5.hashCode() : 0);
    }

    public final void setC(@l String str) {
        this.c = str;
    }

    public final void setCcid(@l String str) {
        this.ccid = str;
    }

    public final void setCi(@l Integer num) {
        this.ci = num;
    }

    public final void setCs(@l Integer num) {
        this.cs = num;
    }

    public final void setD(@l Integer num) {
        this.d = num;
    }

    public final void setS(@l String str) {
        this.s = str;
    }

    public final void setSeq(@l Integer num) {
        this.seq = num;
    }

    public final void setV(@l Integer num) {
        this.v = num;
    }

    @k
    public String toString() {
        return "RtParams(d=" + this.d + ", s=" + this.s + ", c=" + this.c + ", cs=" + this.cs + ", ci=" + this.ci + ", ccid=" + this.ccid + ", v=" + this.v + ", seq=" + this.seq + ")";
    }

    public RtParams(@l Integer num, @l String str, @l String str2, @l Integer num2, @l Integer num3, @l String str3, @l Integer num4, @l Integer num5) {
        this.d = num;
        this.s = str;
        this.c = str2;
        this.cs = num2;
        this.ci = num3;
        this.ccid = str3;
        this.v = num4;
        this.seq = num5;
    }

    public /* synthetic */ RtParams(Integer num, String str, String str2, Integer num2, Integer num3, String str3, Integer num4, Integer num5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : num2, (i10 & 16) != 0 ? null : num3, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : num4, (i10 & 128) == 0 ? num5 : null);
    }
}
