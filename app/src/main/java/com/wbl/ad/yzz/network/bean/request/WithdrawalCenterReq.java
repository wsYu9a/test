package com.wbl.ad.yzz.network.bean.request;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.e;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/WithdrawalCenterReq;", "Lcom/wbl/ad/yzz/network/bean/request/SceneReq;", "Ljava/io/Serializable;", "", "user_id", "I", "getUser_id", "()I", "", "scene", "<init>", "(ILjava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class WithdrawalCenterReq extends SceneReq implements Serializable {
    private final int user_id;

    public WithdrawalCenterReq(int i2, @e String str) {
        this.user_id = i2;
        setScene(str);
    }

    public final int getUser_id() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11214, this, null);
    }
}
