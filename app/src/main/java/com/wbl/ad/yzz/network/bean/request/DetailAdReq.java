package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.e;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/DetailAdReq;", "Lcom/wbl/ad/yzz/network/bean/request/SceneReq;", "Ljava/io/Serializable;", "", "oaid", "Ljava/lang/String;", "getOaid", "()Ljava/lang/String;", "setOaid", "(Ljava/lang/String;)V", "imei", "getImei", "setImei", "", "user_id", "I", "getUser_id", "()I", "android_id", "getAndroid_id", "setAndroid_id", "scene", "<init>", "(ILjava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class DetailAdReq extends SceneReq implements Serializable {

    @e
    private String android_id;

    @e
    private String imei;

    @e
    private String oaid;
    private final int user_id;

    public DetailAdReq(int i2, @e String str) {
        super(str);
        this.user_id = i2;
    }

    public final String getAndroid_id() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11081, this, null);
    }

    public final String getImei() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11084, this, null);
    }

    public final String getOaid() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11083, this, null);
    }

    public final int getUser_id() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11078, this, null);
    }

    public final void setAndroid_id(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11077, this, str);
    }

    public final void setImei(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11080, this, str);
    }

    public final void setOaid(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11079, this, str);
    }
}
