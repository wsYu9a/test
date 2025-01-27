package com.martian.mibook.mvvm.net.result;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.mibook.lib.model.data.TYBookItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003Jh\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017¨\u00061"}, d2 = {"Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "", "bid", "", "cuid", "nickname", "header", "readCount", "", "duration", "readBooks", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "getCuid", "setCuid", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeader", "setHeader", "getNickname", "setNickname", "getReadBooks", "()Ljava/util/List;", "setReadBooks", "(Ljava/util/List;)V", "getReadCount", "setReadCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TYBookTopUser {

    @l
    private String bid;

    @l
    private String cuid;

    @l
    private Integer duration;

    @l
    private String header;

    @l
    private String nickname;

    @l
    private List<? extends TYBookItem> readBooks;

    @l
    private Integer readCount;

    public TYBookTopUser() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ TYBookTopUser copy$default(TYBookTopUser tYBookTopUser, String str, String str2, String str3, String str4, Integer num, Integer num2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tYBookTopUser.bid;
        }
        if ((i10 & 2) != 0) {
            str2 = tYBookTopUser.cuid;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = tYBookTopUser.nickname;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            str4 = tYBookTopUser.header;
        }
        String str7 = str4;
        if ((i10 & 16) != 0) {
            num = tYBookTopUser.readCount;
        }
        Integer num3 = num;
        if ((i10 & 32) != 0) {
            num2 = tYBookTopUser.duration;
        }
        Integer num4 = num2;
        if ((i10 & 64) != 0) {
            list = tYBookTopUser.readBooks;
        }
        return tYBookTopUser.copy(str, str5, str6, str7, num3, num4, list);
    }

    @l
    /* renamed from: component1, reason: from getter */
    public final String getBid() {
        return this.bid;
    }

    @l
    /* renamed from: component2, reason: from getter */
    public final String getCuid() {
        return this.cuid;
    }

    @l
    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @l
    /* renamed from: component4, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    @l
    /* renamed from: component5, reason: from getter */
    public final Integer getReadCount() {
        return this.readCount;
    }

    @l
    /* renamed from: component6, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    @l
    public final List<TYBookItem> component7() {
        return this.readBooks;
    }

    @k
    public final TYBookTopUser copy(@l String bid, @l String cuid, @l String nickname, @l String header, @l Integer readCount, @l Integer duration, @l List<? extends TYBookItem> readBooks) {
        return new TYBookTopUser(bid, cuid, nickname, header, readCount, duration, readBooks);
    }

    public boolean equals(@l Object r52) {
        if (this == r52) {
            return true;
        }
        if (!(r52 instanceof TYBookTopUser)) {
            return false;
        }
        TYBookTopUser tYBookTopUser = (TYBookTopUser) r52;
        return Intrinsics.areEqual(this.bid, tYBookTopUser.bid) && Intrinsics.areEqual(this.cuid, tYBookTopUser.cuid) && Intrinsics.areEqual(this.nickname, tYBookTopUser.nickname) && Intrinsics.areEqual(this.header, tYBookTopUser.header) && Intrinsics.areEqual(this.readCount, tYBookTopUser.readCount) && Intrinsics.areEqual(this.duration, tYBookTopUser.duration) && Intrinsics.areEqual(this.readBooks, tYBookTopUser.readBooks);
    }

    @l
    public final String getBid() {
        return this.bid;
    }

    @l
    public final String getCuid() {
        return this.cuid;
    }

    @l
    public final Integer getDuration() {
        return this.duration;
    }

    @l
    public final String getHeader() {
        return this.header;
    }

    @l
    public final String getNickname() {
        return this.nickname;
    }

    @l
    public final List<TYBookItem> getReadBooks() {
        return this.readBooks;
    }

    @l
    public final Integer getReadCount() {
        return this.readCount;
    }

    public int hashCode() {
        String str = this.bid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cuid;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nickname;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.header;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.readCount;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.duration;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<? extends TYBookItem> list = this.readBooks;
        return hashCode6 + (list != null ? list.hashCode() : 0);
    }

    public final void setBid(@l String str) {
        this.bid = str;
    }

    public final void setCuid(@l String str) {
        this.cuid = str;
    }

    public final void setDuration(@l Integer num) {
        this.duration = num;
    }

    public final void setHeader(@l String str) {
        this.header = str;
    }

    public final void setNickname(@l String str) {
        this.nickname = str;
    }

    public final void setReadBooks(@l List<? extends TYBookItem> list) {
        this.readBooks = list;
    }

    public final void setReadCount(@l Integer num) {
        this.readCount = num;
    }

    @k
    public String toString() {
        return "TYBookTopUser(bid=" + this.bid + ", cuid=" + this.cuid + ", nickname=" + this.nickname + ", header=" + this.header + ", readCount=" + this.readCount + ", duration=" + this.duration + ", readBooks=" + this.readBooks + ")";
    }

    public TYBookTopUser(@l String str, @l String str2, @l String str3, @l String str4, @l Integer num, @l Integer num2, @l List<? extends TYBookItem> list) {
        this.bid = str;
        this.cuid = str2;
        this.nickname = str3;
        this.header = str4;
        this.readCount = num;
        this.duration = num2;
        this.readBooks = list;
    }

    public /* synthetic */ TYBookTopUser(String str, String str2, String str3, String str4, Integer num, Integer num2, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? null : num2, (i10 & 64) != 0 ? null : list);
    }
}
