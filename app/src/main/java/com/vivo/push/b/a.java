package com.vivo.push.b;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class a extends c {

    /* renamed from: a */
    private ArrayList<String> f24915a;

    public a(boolean z10, String str, ArrayList<String> arrayList) {
        super(z10 ? 2002 : 2003, str);
        this.f24915a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags", this.f24915a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24915a = aVar.c("tags");
    }

    @Override // com.vivo.push.b.c, com.vivo.push.o
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
