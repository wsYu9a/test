package com.wbl.ad.yzz.network.bean.request;

import com.baidu.mobads.sdk.internal.a;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import f.b.a.e;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/wbl/ad/yzz/network/bean/request/UploadFeedbackReq;", "Lcom/wbl/ad/yzz/network/bean/request/SceneReq;", "Ljava/io/Serializable;", "", "user_id", "I", "getUser_id", "()I", "type", "getType", "", a.f5473b, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "scene", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class UploadFeedbackReq extends SceneReq implements Serializable {

    @d
    private final String text;
    private final int type;
    private final int user_id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadFeedbackReq(int i2, int i3, @d String text, @e String str) {
        super(str);
        Intrinsics.checkNotNullParameter(text, "text");
        this.user_id = i2;
        this.type = i3;
        this.text = text;
    }

    public final String getText() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11249, this, null);
    }

    public final int getType() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11252, this, null);
    }

    public final int getUser_id() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11251, this, null);
    }
}
