package com.vivo.push.b;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class m extends s {

    /* renamed from: a */
    private ArrayList<String> f24936a;

    public m() {
        super(8);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("tags_list", this.f24936a);
    }

    public final ArrayList<String> d() {
        return this.f24936a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnListTagCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24936a = aVar.c("tags_list");
    }
}
