package com.kwad.sdk.i.kwai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    private final List<b> axL = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.axL.add(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i2) {
        if (bVar != null) {
            this.axL.add(i2, bVar);
        }
    }

    public final boolean bX() {
        Iterator<b> it = this.axL.iterator();
        while (it.hasNext()) {
            if (it.next().bX()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.axL.remove(bVar);
        }
    }
}
