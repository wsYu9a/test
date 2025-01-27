package com.vivo.push.b;

import com.kwai.sodler.lib.ext.PluginError;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class z extends c {

    /* renamed from: a */
    private ArrayList<String> f30933a;

    public z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? PluginError.ERROR_UPD_EXTRACT : PluginError.ERROR_UPD_CAPACITY, str);
        this.f30933a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags", (Serializable) this.f30933a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30933a = aVar.c("tags");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "TagCommand";
    }
}
