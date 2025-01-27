package com.kwad.sdk.k.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class a implements c {
    protected List<c> aRk;
    protected boolean enabled;

    public a(boolean z10) {
        this.enabled = z10;
    }

    private List<c> getChildren() {
        return this.aRk;
    }

    @Override // com.kwad.sdk.k.a.c
    public final boolean bR(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children == null || children.size() <= 0) {
            try {
                return bS(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        Iterator<c> it = children.iterator();
        while (it.hasNext()) {
            if (it.next().bR(context)) {
                return true;
            }
        }
        return false;
    }

    public boolean bS(Context context) {
        return false;
    }

    public a() {
        this.enabled = true;
    }
}
