package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class ab implements w {
    private final SparseArray<Handler> aGn = new SparseArray<>();

    ab() {
    }

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwai.filedownloader.w
    public final void F(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            b(this.aGn.get(it.next().intValue()));
        }
    }

    @Override // com.kwai.filedownloader.w
    public final void Hv() {
        for (int i2 = 0; i2 < this.aGn.size(); i2++) {
            a(this.aGn.get(this.aGn.keyAt(i2)));
        }
    }

    @Override // com.kwai.filedownloader.w
    public final int Hw() {
        return this.aGn.size();
    }

    @Override // com.kwai.filedownloader.w
    public final boolean cF(int i2) {
        return this.aGn.get(i2) != null;
    }
}
