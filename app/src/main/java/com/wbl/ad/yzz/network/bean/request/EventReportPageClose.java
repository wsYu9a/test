package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.a.a;
import f.b.a.e;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0005R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/EventReportPageClose;", "Lcom/wbl/ad/yzz/network/b/a/a;", "Ljava/io/Serializable;", "", "getSubSign", "()Ljava/lang/String;", "", "is_active_call", "I", "()I", "scene", "Ljava/lang/String;", "getScene", "event", "getEvent", "<init>", "(IILjava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class EventReportPageClose extends a implements Serializable {
    private final int event;
    private final int is_active_call;

    @e
    private final String scene;

    public EventReportPageClose(int i2, int i3, @e String str) {
        this.event = i2;
        this.is_active_call = i3;
        this.scene = str;
    }

    public final int getEvent() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11102, this, null);
    }

    public final String getScene() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11101, this, null);
    }

    @Override // com.wbl.ad.yzz.network.b.a.a
    public String getSubSign() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11104, this, null);
    }

    public final int is_active_call() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11103, this, null);
    }
}
