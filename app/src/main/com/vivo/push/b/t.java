package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class t extends s {

    /* renamed from: a */
    private ArrayList<String> f24950a;

    /* renamed from: b */
    private ArrayList<String> f24951b;

    public t(int i10) {
        super(i10);
        this.f24950a = null;
        this.f24951b = null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f24950a);
        aVar.a("error_msg", this.f24951b);
    }

    public final ArrayList<String> d() {
        return this.f24950a;
    }

    public final List<String> e() {
        return this.f24951b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f24950a = aVar.c("content");
        this.f24951b = aVar.c("error_msg");
    }
}
