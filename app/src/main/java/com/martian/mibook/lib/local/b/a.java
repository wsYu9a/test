package com.martian.mibook.lib.local.b;

import android.content.Context;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.d.b;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.manager.BookManager;
import com.martian.mibook.lib.model.manager.d;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    private Map<String, com.martian.mibook.lib.local.b.c.a> f13930a;

    /* renamed from: b */
    private final BookManager f13931b;

    /* renamed from: c */
    private final Context f13932c;

    public a(Context context, BookManager bookManager) {
        this.f13932c = context;
        this.f13931b = bookManager;
        d();
    }

    private g e(String filepath) {
        return new Source(d.f14056h, filepath);
    }

    public void a(String filepath, b receiver) {
        g e2 = e(filepath);
        b(e2).v(e2, receiver, false);
    }

    public com.martian.mibook.lib.local.b.c.a b(g source) {
        return c(source.getSourceName());
    }

    public com.martian.mibook.lib.local.b.c.a c(String sourceName) {
        return this.f13930a.get(sourceName);
    }

    public void d() {
        this.f13930a = new Hashtable();
        f(new com.martian.mibook.lib.local.c.c.a(this.f13932c, this.f13931b));
    }

    public void f(com.martian.mibook.lib.local.b.c.a bookProvider) {
        this.f13930a.put(bookProvider.F(), bookProvider);
    }
}
