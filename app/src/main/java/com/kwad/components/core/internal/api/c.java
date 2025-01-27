package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class c {

    @NonNull
    private List<b> JI = new CopyOnWriteArrayList();
    private boolean JJ = false;
    private boolean JK = false;

    public final void a(a aVar) {
        com.kwad.sdk.core.d.b.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.JK);
        if (this.JK) {
            return;
        }
        Iterator<b> it = this.JI.iterator();
        while (it.hasNext()) {
            it.next().onAdEnter(aVar);
        }
        this.JK = true;
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.JI.add(bVar);
    }

    public final void b(a aVar) {
        com.kwad.sdk.core.d.b.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.JJ);
        if (this.JJ) {
            return;
        }
        Iterator<b> it = this.JI.iterator();
        while (it.hasNext()) {
            it.next().onAdExit(aVar);
        }
        this.JJ = true;
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.JI.remove(bVar);
    }
}
