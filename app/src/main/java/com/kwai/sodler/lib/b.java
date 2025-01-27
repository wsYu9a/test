package com.kwai.sodler.lib;

import com.kwai.sodler.lib.a.b;

/* loaded from: classes2.dex */
public final class b implements com.kwai.sodler.lib.a.b {
    private b.a aJK;

    @Override // com.kwai.sodler.lib.a.b
    public final void e(com.kwai.sodler.lib.a.f fVar) {
        b.a aVar = this.aJK;
        if (aVar != null) {
            fVar.b(aVar.Jz());
        } else {
            a.w("Sodler.PluginConfigUpdater", "config reqester not set");
        }
    }
}
