package com.aggmoread.sdk.z.d.a.a.d.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.d.a.a.c.g;

/* loaded from: classes.dex */
public class c implements g.a {

    /* renamed from: a */
    private d f5855a;

    public c(Context context) {
        d dVar = new d();
        this.f5855a = dVar;
        dVar.f5858d = context;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(int i10) {
        this.f5855a.f5868n = i10;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a b(int i10) {
        this.f5855a.f5867m = i10;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a c(int i10) {
        this.f5855a.A = i10;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a d(int i10) {
        this.f5855a.f5869o = i10;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(ViewGroup viewGroup) {
        this.f5855a.f5864j = viewGroup;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a b(String str) {
        this.f5855a.f5863i = str;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a c(String str) {
        String str2;
        com.aggmoread.sdk.z.d.a.a.e.e.a("raw token " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = new String(com.aggmoread.sdk.z.d.a.a.b.a(str), "utf-8").split("\\|");
                if (split.length >= 2) {
                    d dVar = this.f5855a;
                    dVar.f5877w = split[0];
                    dVar.f5878x = split[1];
                    com.aggmoread.sdk.z.d.a.a.e.e.a("token " + this.f5855a.f5877w);
                    com.aggmoread.sdk.z.d.a.a.e.e.a("slotId " + this.f5855a.f5878x);
                    if (split.length == 3) {
                        this.f5855a.f5879y = split[2];
                        str2 = "s2s price " + this.f5855a.f5879y;
                    }
                } else {
                    str2 = "err token ";
                }
                com.aggmoread.sdk.z.d.a.a.e.e.a(str2);
            } catch (Exception e10) {
                e10.printStackTrace();
                com.aggmoread.sdk.z.d.a.a.e.e.a("set token err " + e10.getMessage());
            }
        }
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(com.aggmoread.sdk.z.d.a.a.c.f fVar) {
        this.f5855a.f5861g = fVar;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(com.aggmoread.sdk.z.d.a.a.c.h hVar) {
        this.f5855a.f5871q = hVar;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(com.aggmoread.sdk.z.d.a.a.c.i iVar) {
        this.f5855a.f5859e = iVar;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(com.aggmoread.sdk.z.d.a.a.c.r.c cVar) {
        this.f5855a.f5870p = cVar;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(com.aggmoread.sdk.z.d.a.a.c.t.b bVar) {
        this.f5855a.f5873s = bVar;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(String str) {
        this.f5855a.f5860f = str;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public g.a a(boolean z10) {
        this.f5855a.f5880z = z10;
        return this;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.g.a
    public com.aggmoread.sdk.z.d.a.a.c.g a() {
        try {
            return (com.aggmoread.sdk.z.d.a.a.c.g) this.f5855a.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
