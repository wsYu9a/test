package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class c {
    private List<b> aIa = new CopyOnWriteArrayList();

    public final void a(b bVar) {
        this.aIa.add(bVar);
    }

    public final void b(b bVar) {
        this.aIa.remove(bVar);
    }

    public final void j(View view, boolean z10) {
        Iterator<b> it = this.aIa.iterator();
        while (it.hasNext()) {
            it.next().i(view, z10);
        }
    }
}
