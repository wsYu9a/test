package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class m<T extends e> implements l<T> {
    private final Map<String, T> aBS = new LinkedHashMap();

    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b */
    public synchronized void j(@NonNull T t10) {
        this.aBS.put(t10.actionId, t10);
    }

    @Override // com.kwad.sdk.core.report.l
    public final List<T> dn(int i10) {
        ArrayList arrayList = new ArrayList(this.aBS.size());
        Iterator<Map.Entry<String, T>> it = this.aBS.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        int size;
        size = this.aBS.size();
        com.kwad.sdk.core.d.c.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void x(List<T> list) {
        for (T t10 : list) {
            if (t10 != null) {
                this.aBS.remove(t10.actionId);
            }
        }
    }
}
