package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import f.b.a.d;
import f.b.a.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b \u0010!J\u0019\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/AdCallBackReq;", "Lcom/wbl/ad/yzz/network/bean/request/SceneReq;", "", "", "getRequestMap", "()Ljava/util/Map;", "getParams", "()Ljava/lang/String;", OapsKey.KEY_VERID, "Ljava/lang/String;", "getVid", "slotId", "getSlotId", "imei", "getImei", OapsKey.KEY_SUB_ID, "getSid", "macAddress", "getMacAddress", "", "ptime", "I", "getPtime", "()I", "oaid", "getOaid", "", "clickTime", "J", "getClickTime", "()J", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class AdCallBackReq extends SceneReq {
    private final long clickTime;

    @d
    private final String imei;

    @d
    private final String macAddress;

    @d
    private final String oaid;
    private final int ptime;

    @d
    private final String sid;

    @d
    private final String slotId;

    @d
    private final String vid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCallBackReq(@d String imei, @d String oaid, @d String sid, @d String vid, int i2, long j2, @d String slotId, @d String macAddress, @e String str) {
        super(str);
        Intrinsics.checkNotNullParameter(imei, "imei");
        Intrinsics.checkNotNullParameter(oaid, "oaid");
        Intrinsics.checkNotNullParameter(sid, "sid");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(slotId, "slotId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        this.imei = imei;
        this.oaid = oaid;
        this.sid = sid;
        this.vid = vid;
        this.ptime = i2;
        this.clickTime = j2;
        this.slotId = slotId;
        this.macAddress = macAddress;
    }

    public final long getClickTime() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-11106, this, null);
    }

    public final String getImei() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11105, this, null);
    }

    public final String getMacAddress() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11108, this, null);
    }

    public final String getOaid() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11107, this, null);
    }

    public final String getParams() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11134, this, null);
    }

    public final int getPtime() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11133, this, null);
    }

    public final Map<String, String> getRequestMap() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11136, this, null);
    }

    public final String getSid() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11135, this, null);
    }

    public final String getSlotId() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11130, this, null);
    }

    public final String getVid() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11129, this, null);
    }
}
