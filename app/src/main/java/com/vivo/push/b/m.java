package com.vivo.push.b;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class m extends s {

    /* renamed from: a */
    private ArrayList<String> f30909a;

    public m() {
        super(8);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags_list", this.f30909a);
    }

    public final ArrayList<String> d() {
        return this.f30909a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnListTagCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30909a = aVar.c("tags_list");
    }
}
