package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class ab implements w {
    private final SparseArray<Handler> aiq = new SparseArray<>();

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean bi(int i10) {
        return this.aiq.get(i10) != null;
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void p(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            b(this.aiq.get(it.next().intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void wi() {
        for (int i10 = 0; i10 < this.aiq.size(); i10++) {
            a(this.aiq.get(this.aiq.keyAt(i10)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int wj() {
        return this.aiq.size();
    }
}
