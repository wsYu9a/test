package com.martian.mibook.mvvm.payment.data;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016Jª\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\u0006\u0010>\u001a\u00020;J\u0006\u0010?\u001a\u00020;J\u0006\u0010@\u001a\u00020;J\u0006\u0010A\u001a\u00020;J\t\u0010B\u001a\u00020\bHÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0013¨\u0006C"}, d2 = {"Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "", ExposeManager.UtArgsNames.pid, "", "price", "oriPrice", "ptype", "subject", "", "content", "extra", "period", "periodType", "singleFee", "paymentType", TTDownloadField.TT_TAG, "periodTag", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getExtra", "getOriPrice", "()Ljava/lang/Integer;", "setOriPrice", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPaymentType", "setPaymentType", "getPeriod", "setPeriod", "getPeriodTag", "getPeriodType", "setPeriodType", "getPid", "setPid", "getPrice", "setPrice", "getPtype", "setPtype", "getSingleFee", "setSingleFee", "getSubject", "getTag", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "isSubsType", "supportAliPay", "supportGooglePay", "supportWeixinPay", "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVipProduct.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VipProduct.kt\ncom/martian/mibook/mvvm/payment/data/VipProduct\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
/* loaded from: classes3.dex */
public final /* data */ class VipProduct {

    @l
    private final String content;

    @l
    private final String extra;

    @l
    private Integer oriPrice;

    @l
    private Integer paymentType;

    @l
    private Integer period;

    @l
    private final String periodTag;

    @l
    private Integer periodType;

    @l
    private Integer pid;

    @l
    private Integer price;

    @l
    private Integer ptype;

    @l
    private Integer singleFee;

    @l
    private final String subject;

    @l
    private final String tag;

    public VipProduct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final Integer getPid() {
        return this.pid;
    }

    @l
    /* renamed from: component10, reason: from getter */
    public final Integer getSingleFee() {
        return this.singleFee;
    }

    @l
    /* renamed from: component11, reason: from getter */
    public final Integer getPaymentType() {
        return this.paymentType;
    }

    @l
    /* renamed from: component12, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @l
    /* renamed from: component13, reason: from getter */
    public final String getPeriodTag() {
        return this.periodTag;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final Integer getPrice() {
        return this.price;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final Integer getOriPrice() {
        return this.oriPrice;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final Integer getPtype() {
        return this.ptype;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @l
    /* renamed from: component7, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    @l
    /* renamed from: component8, reason: from getter */
    public final Integer getPeriod() {
        return this.period;
    }

    @l
    /* renamed from: component9, reason: from getter */
    public final Integer getPeriodType() {
        return this.periodType;
    }

    @k
    public final VipProduct copy(@l Integer r16, @l Integer price, @l Integer oriPrice, @l Integer ptype, @l String subject, @l String content, @l String extra, @l Integer period, @l Integer periodType, @l Integer singleFee, @l Integer paymentType, @l String r27, @l String periodTag) {
        return new VipProduct(r16, price, oriPrice, ptype, subject, content, extra, period, periodType, singleFee, paymentType, r27, periodTag);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof VipProduct)) {
            return false;
        }
        VipProduct vipProduct = (VipProduct) r52;
        return Intrinsics.areEqual(this.pid, vipProduct.pid) && Intrinsics.areEqual(this.price, vipProduct.price) && Intrinsics.areEqual(this.oriPrice, vipProduct.oriPrice) && Intrinsics.areEqual(this.ptype, vipProduct.ptype) && Intrinsics.areEqual(this.subject, vipProduct.subject) && Intrinsics.areEqual(this.content, vipProduct.content) && Intrinsics.areEqual(this.extra, vipProduct.extra) && Intrinsics.areEqual(this.period, vipProduct.period) && Intrinsics.areEqual(this.periodType, vipProduct.periodType) && Intrinsics.areEqual(this.singleFee, vipProduct.singleFee) && Intrinsics.areEqual(this.paymentType, vipProduct.paymentType) && Intrinsics.areEqual(this.tag, vipProduct.tag) && Intrinsics.areEqual(this.periodTag, vipProduct.periodTag);
    }

    @l
    public final String getContent() {
        return this.content;
    }

    @l
    public final String getExtra() {
        return this.extra;
    }

    @l
    public final Integer getOriPrice() {
        return this.oriPrice;
    }

    @l
    public final Integer getPaymentType() {
        return this.paymentType;
    }

    @l
    public final Integer getPeriod() {
        return this.period;
    }

    @l
    public final String getPeriodTag() {
        return this.periodTag;
    }

    @l
    public final Integer getPeriodType() {
        return this.periodType;
    }

    @l
    public final Integer getPid() {
        return this.pid;
    }

    @l
    public final Integer getPrice() {
        return this.price;
    }

    @l
    public final Integer getPtype() {
        return this.ptype;
    }

    @l
    public final Integer getSingleFee() {
        return this.singleFee;
    }

    @l
    public final String getSubject() {
        return this.subject;
    }

    @l
    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        Integer num = this.pid;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.price;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.oriPrice;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.ptype;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.subject;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.extra;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num5 = this.period;
        int hashCode8 = (hashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.periodType;
        int hashCode9 = (hashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.singleFee;
        int hashCode10 = (hashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.paymentType;
        int hashCode11 = (hashCode10 + (num8 == null ? 0 : num8.hashCode())) * 31;
        String str4 = this.tag;
        int hashCode12 = (hashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.periodTag;
        return hashCode12 + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isSubsType() {
        Integer num = this.period;
        return num != null && num.intValue() > 0;
    }

    public final void setOriPrice(@l Integer num) {
        this.oriPrice = num;
    }

    public final void setPaymentType(@l Integer num) {
        this.paymentType = num;
    }

    public final void setPeriod(@l Integer num) {
        this.period = num;
    }

    public final void setPeriodType(@l Integer num) {
        this.periodType = num;
    }

    public final void setPid(@l Integer num) {
        this.pid = num;
    }

    public final void setPrice(@l Integer num) {
        this.price = num;
    }

    public final void setPtype(@l Integer num) {
        this.ptype = num;
    }

    public final void setSingleFee(@l Integer num) {
        this.singleFee = num;
    }

    public final boolean supportAliPay() {
        int intValue;
        Integer num = this.paymentType;
        return num == null || (intValue = num.intValue()) == 0 || (intValue & 2) > 0;
    }

    public final boolean supportGooglePay() {
        int intValue;
        Integer num = this.paymentType;
        return num == null || (intValue = num.intValue()) == 0 || (intValue & 32) > 0;
    }

    public final boolean supportWeixinPay() {
        int intValue;
        Integer num = this.paymentType;
        return num == null || (intValue = num.intValue()) == 0 || (intValue & 1) > 0;
    }

    @k
    public String toString() {
        return "VipProduct(pid=" + this.pid + ", price=" + this.price + ", oriPrice=" + this.oriPrice + ", ptype=" + this.ptype + ", subject=" + this.subject + ", content=" + this.content + ", extra=" + this.extra + ", period=" + this.period + ", periodType=" + this.periodType + ", singleFee=" + this.singleFee + ", paymentType=" + this.paymentType + ", tag=" + this.tag + ", periodTag=" + this.periodTag + ")";
    }

    public VipProduct(@l Integer num, @l Integer num2, @l Integer num3, @l Integer num4, @l String str, @l String str2, @l String str3, @l Integer num5, @l Integer num6, @l Integer num7, @l Integer num8, @l String str4, @l String str5) {
        this.pid = num;
        this.price = num2;
        this.oriPrice = num3;
        this.ptype = num4;
        this.subject = str;
        this.content = str2;
        this.extra = str3;
        this.period = num5;
        this.periodType = num6;
        this.singleFee = num7;
        this.paymentType = num8;
        this.tag = str4;
        this.periodTag = str5;
    }

    public /* synthetic */ VipProduct(Integer num, Integer num2, Integer num3, Integer num4, String str, String str2, String str3, Integer num5, Integer num6, Integer num7, Integer num8, String str4, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : num3, (i10 & 8) != 0 ? null : num4, (i10 & 16) != 0 ? null : str, (i10 & 32) != 0 ? null : str2, (i10 & 64) != 0 ? null : str3, (i10 & 128) != 0 ? null : num5, (i10 & 256) != 0 ? null : num6, (i10 & 512) != 0 ? null : num7, (i10 & 1024) != 0 ? null : num8, (i10 & 2048) != 0 ? null : str4, (i10 & 4096) == 0 ? str5 : null);
    }
}
