package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class p<T extends f> implements n<T> {
    private final Map<String, T> aiE = new LinkedHashMap();

    @Override // com.kwad.sdk.core.report.n
    /* renamed from: b */
    public synchronized void e(@NonNull T t) {
        this.aiE.put(t.actionId, t);
    }

    @Override // com.kwad.sdk.core.report.n
    public final synchronized void o(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.aiE.remove(it.next().actionId);
        }
    }

    @Override // com.kwad.sdk.core.report.n
    public final synchronized long size() {
        int size;
        size = this.aiE.size();
        com.kwad.sdk.core.d.b.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.n
    public final synchronized List<T> wV() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.aiE.size());
        Iterator<Map.Entry<String, T>> it = this.aiE.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }
}
