package com.kwad.sdk.l.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    private final List<b> aRy = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.aRy.add(bVar);
        }
    }

    public final boolean onBackPressed() {
        Iterator<b> it = this.aRy.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.aRy.remove(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i10) {
        if (bVar != null) {
            this.aRy.add(i10, bVar);
        }
    }
}
