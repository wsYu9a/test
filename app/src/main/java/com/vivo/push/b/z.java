package com.vivo.push.b;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class z extends c {

    /* renamed from: a */
    private ArrayList<String> f24960a;

    public z(boolean z10, String str, ArrayList<String> arrayList) {
        super(z10 ? 2004 : 2005, str);
        this.f24960a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags", (Serializable) this.f24960a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24960a = aVar.c("tags");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "TagCommand";
    }
}
