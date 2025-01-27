package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.e;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0005\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/GetXyzConfReq;", "Lcom/wbl/ad/yzz/network/bean/request/SceneReq;", "Ljava/io/Serializable;", "", "is_active_call", "I", "()I", "cond_x", "getCond_x", "", "scene", "<init>", "(IILjava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class GetXyzConfReq extends SceneReq implements Serializable {
    private final int cond_x;
    private final int is_active_call;

    public GetXyzConfReq(int i2, int i3, @e String str) {
        super(str);
        this.cond_x = i2;
        this.is_active_call = i3;
    }

    public final int getCond_x() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11234, this, null);
    }

    public final int is_active_call() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11233, this, null);
    }
}
