package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import f.b.a.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/BindcpnReq;", "Lcom/wbl/ad/yzz/network/bean/request/SceneReq;", "", "", "getRequestMap", "()Ljava/util/Map;", "getParams", "()Ljava/lang/String;", "user_id", "Ljava/lang/String;", "getUser_id", "cpn", "getCpn", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class BindcpnReq extends SceneReq {

    @d
    private final String cpn;

    @d
    private final String user_id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindcpnReq(@d String user_id, @d String cpn, @e String str) {
        super(str);
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        Intrinsics.checkNotNullParameter(cpn, "cpn");
        this.user_id = user_id;
        this.cpn = cpn;
    }

    public final String getCpn() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11085, this, null);
    }

    public final String getParams() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11088, this, null);
    }

    public final Map<String, String> getRequestMap() {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11087, this, null);
    }

    public final String getUser_id() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11082, this, null);
    }
}
