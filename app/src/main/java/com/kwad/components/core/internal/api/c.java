package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class c {

    @NonNull
    private List<b> Ok = new CopyOnWriteArrayList();
    private boolean Ol = false;
    private boolean Om = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Ok.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Ok.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.Om);
        if (this.Om) {
            return;
        }
        Iterator<b> it = this.Ok.iterator();
        while (it.hasNext()) {
            it.next().c(aVar);
        }
        this.Om = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.Ol);
        if (this.Ol) {
            return;
        }
        Iterator<b> it = this.Ok.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        this.Ol = true;
    }
}
