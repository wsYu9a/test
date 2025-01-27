package com.wbl.ad.yzz.gson;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes5.dex */
public abstract class k {
    public h a() {
        if (d()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m b() {
        if (f()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n c() {
        if (g()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean d() {
        return this instanceof h;
    }

    public boolean e() {
        return this instanceof l;
    }

    public boolean f() {
        return this instanceof m;
    }

    public boolean g() {
        return this instanceof n;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.wbl.ad.yzz.gson.v.b bVar = new com.wbl.ad.yzz.gson.v.b(stringWriter);
            bVar.b(true);
            com.wbl.ad.yzz.gson.t.i.a(this, bVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
