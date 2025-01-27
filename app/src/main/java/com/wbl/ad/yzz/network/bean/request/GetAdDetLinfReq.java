package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import f.b.a.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/GetAdDetLinfReq;", "Lcom/wbl/ad/yzz/network/bean/request/SceneReq;", "", "", "getRequestMap", "()Ljava/util/Map;", "getParams", "()Ljava/lang/String;", "", "user_id", "I", "getUser_id", "()I", "supplier", "Ljava/lang/String;", "getSupplier", "is_active_call", "ad_id", "getAd_id", "scene", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class GetAdDetLinfReq extends SceneReq {

    @d
    private final String ad_id;
    private final int is_active_call;

    @d
    private final String supplier;
    private final int user_id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAdDetLinfReq(int i2, int i3, @d String ad_id, @d String supplier, @e String str) {
        super(str);
        Intrinsics.checkNotNullParameter(ad_id, "ad_id");
        Intrinsics.checkNotNullParameter(supplier, "supplier");
        this.user_id = i2;
        this.is_active_call = i3;
        this.ad_id = ad_id;
        this.supplier = supplier;
    }

    public final String getAd_id() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11089, this, null);
    }

    public final String getParams() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11092, this, null);
    }

    public final Map<String, String> getRequestMap() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11091, this, null);
    }

    public final String getSupplier() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11182, this, null);
    }

    public final int getUser_id() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11181, this, null);
    }

    public final int is_active_call() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11184, this, null);
    }
}
