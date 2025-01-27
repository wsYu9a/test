package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class t extends s {

    /* renamed from: a */
    private ArrayList<String> f30923a;

    /* renamed from: b */
    private ArrayList<String> f30924b;

    public t(int i2) {
        super(i2);
        this.f30923a = null;
        this.f30924b = null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f30923a);
        aVar.a("error_msg", this.f30924b);
    }

    public final ArrayList<String> d() {
        return this.f30923a;
    }

    public final List<String> e() {
        return this.f30924b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    protected final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f30923a = aVar.c("content");
        this.f30924b = aVar.c("error_msg");
    }
}
