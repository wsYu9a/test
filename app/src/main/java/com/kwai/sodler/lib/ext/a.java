package com.kwai.sodler.lib.ext;

import androidx.annotation.Nullable;
import com.kwai.sodler.lib.a.f;

/* loaded from: classes2.dex */
public final class a {
    @Nullable
    private static b n(f fVar) {
        return fVar.JI();
    }

    public final void c(f fVar, com.kwai.sodler.lib.a.a aVar) {
        b n = n(fVar);
        if (n != null) {
            n.a((b) fVar, (f) aVar);
        }
    }

    public final void c(f fVar, PluginError pluginError) {
        b n = n(fVar);
        if (n != null) {
            n.a((b) fVar, pluginError);
        }
    }

    public final void o(f fVar) {
        b n = n(fVar);
        if (n != null) {
            n.a(fVar);
        }
    }

    public final void p(f fVar) {
        b n = n(fVar);
        if (n != null) {
            n.c(fVar);
        }
    }

    public final void q(f fVar) {
        b n = n(fVar);
        if (n != null) {
            n.b(fVar);
        }
    }
}
