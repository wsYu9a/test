package com.baidu.mobads.sdk.internal;

import java.util.Comparator;
import java.util.Map;

/* loaded from: classes2.dex */
class aq implements Comparator<Map.Entry<String, Long>> {

    /* renamed from: a */
    final /* synthetic */ ap f6778a;

    public aq(ap apVar) {
        this.f6778a = apVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
        return entry2.getValue().compareTo(entry.getValue());
    }
}
