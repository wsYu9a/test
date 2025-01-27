package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.a.a;
import f.b.a.e;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\u0005R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0007\u001a\u0004\b\n\u0010\u0005R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/EventReportApkInstallReq;", "Lcom/wbl/ad/yzz/network/b/a/a;", "Ljava/io/Serializable;", "", "getSubSign", "()Ljava/lang/String;", "ad_id", "Ljava/lang/String;", "getAd_id", "scene", "getScene", "", "event", "I", "getEvent", "()I", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class EventReportApkInstallReq extends a implements Serializable {

    @e
    private final String ad_id;
    private final int event;

    @e
    private final String scene;

    public EventReportApkInstallReq(int i2, @e String str, @e String str2) {
        this.event = i2;
        this.ad_id = str;
        this.scene = str2;
    }

    public final String getAd_id() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11074, this, null);
    }

    public final int getEvent() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11073, this, null);
    }

    public final String getScene() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11076, this, null);
    }

    @Override // com.wbl.ad.yzz.network.b.a.a
    public String getSubSign() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11075, this, null);
    }
}
