package com.wbl.ad.yzz.adapter.base.loadmore;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/wbl/ad/yzz/adapter/base/loadmore/LoadMoreStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Complete", "Loading", "Fail", "End", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public enum LoadMoreStatus {
    Complete,
    Loading,
    Fail,
    End;

    public static LoadMoreStatus valueOf(String str) {
        return (LoadMoreStatus) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16055, null, str);
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static LoadMoreStatus[] valuesCustom() {
        return (LoadMoreStatus[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-16050, null, null);
    }
}
