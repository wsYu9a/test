package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class h {
    private static volatile h azQ;
    private List<a> azP = new CopyOnWriteArrayList();

    public interface a {
        void a(f fVar, int i10);
    }

    private h() {
    }

    public static h Fs() {
        if (azQ == null) {
            synchronized (h.class) {
                try {
                    if (azQ == null) {
                        azQ = new h();
                    }
                } finally {
                }
            }
        }
        return azQ;
    }

    public final void a(a aVar) {
        this.azP.add(aVar);
    }

    public final void b(f fVar, int i10) {
        Iterator<a> it = this.azP.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i10);
        }
    }
}
