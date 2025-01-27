package com.wbl.ad.yzz.bean;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.u;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u0013\u0010\u001a\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/wbl/ad/yzz/bean/AdPageNeedData;", "Ljava/io/Serializable;", "", "bgType", "I", "getBgType", "()I", "setBgType", "(I)V", "", "bookId", "Ljava/lang/String;", "getBookId", "()Ljava/lang/String;", "setBookId", "(Ljava/lang/String;)V", "page", "getPage", "setPage", "freeStatus", "getFreeStatus", "setFreeStatus", "section", "getSection", "setSection", "getUp_slide_sec", "up_slide_sec", "callType", "getCallType", "setCallType", "Lcom/wbl/ad/yzz/network/b/b/u;", "bean", "Lcom/wbl/ad/yzz/network/b/b/u;", "getBean", "()Lcom/wbl/ad/yzz/network/b/b/u;", "setBean", "(Lcom/wbl/ad/yzz/network/b/b/u;)V", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class AdPageNeedData implements Serializable {

    @f.b.a.e
    private u bean;
    private int bgType;

    @f.b.a.e
    private String bookId;
    private int callType;
    private int freeStatus;
    private int page;
    private int section;

    public final u getBean() {
        return (u) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15805, this, null);
    }

    public final int getBgType() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15808, this, null);
    }

    public final String getBookId() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15807, this, null);
    }

    public final int getCallType() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15802, this, null);
    }

    public final int getFreeStatus() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15801, this, null);
    }

    public final int getPage() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15804, this, null);
    }

    public final int getSection() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15803, this, null);
    }

    public final int getUp_slide_sec() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15798, this, null);
    }

    public final void setBean(u uVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15797, this, uVar);
    }

    public final void setBgType(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15800, this, Integer.valueOf(i2));
    }

    public final void setBookId(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15799, this, str);
    }

    public final void setCallType(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15794, this, Integer.valueOf(i2));
    }

    public final void setFreeStatus(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15793, this, Integer.valueOf(i2));
    }

    public final void setPage(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15796, this, Integer.valueOf(i2));
    }

    public final void setSection(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15795, this, Integer.valueOf(i2));
    }
}
