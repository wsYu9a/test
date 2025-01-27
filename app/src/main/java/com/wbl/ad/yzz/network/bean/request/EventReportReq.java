package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.a.a;
import f.b.a.e;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/EventReportReq;", "Lcom/wbl/ad/yzz/network/b/a/a;", "Ljava/io/Serializable;", "", "getSubSign", "()Ljava/lang/String;", "", "event", "I", "getEvent", "()I", "scene", "Ljava/lang/String;", "getScene", "<init>", "(ILjava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class EventReportReq extends a implements Serializable {
    private final int event;

    @e
    private final String scene;

    public EventReportReq(int i2, @e String str) {
        this.event = i2;
        this.scene = str;
    }

    public final int getEvent() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11098, this, null);
    }

    public final String getScene() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11097, this, null);
    }

    @Override // com.wbl.ad.yzz.network.b.a.a
    public String getSubSign() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11100, this, null);
    }
}
