package com.kwad.sdk.h.kwai;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a implements c {
    protected List<c> axx;
    protected boolean enabled;

    public a() {
        this.enabled = true;
    }

    public a(boolean z) {
        this.enabled = z;
    }

    private List<c> getChildren() {
        return this.axx;
    }

    @Override // com.kwad.sdk.h.kwai.c
    public final boolean br(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children == null || children.size() <= 0) {
            try {
                return bs(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        Iterator<c> it = children.iterator();
        while (it.hasNext()) {
            if (it.next().br(context)) {
                return true;
            }
        }
        return false;
    }

    protected boolean bs(Context context) {
        return false;
    }
}
