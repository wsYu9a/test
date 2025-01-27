package com.martian.mibook.lib.model.manager;

import android.content.Context;
import ba.g;
import ba.l;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.lib.model.data.BookSyncInfo;
import com.martian.mibook.lib.model.data.BookSyncList;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class BookSyncManager {

    /* renamed from: c */
    public static final String f14005c = "booksync.json";

    /* renamed from: a */
    public Map<String, BookSyncInfo> f14006a;

    /* renamed from: b */
    public final Context f14007b;

    public class a extends TypeToken<Map<String, BookSyncInfo>> {
        public a() {
        }
    }

    public BookSyncManager(Context context) {
        this.f14007b = context;
    }

    public void a() {
        g.p(this.f14007b, f14005c);
        Map<String, BookSyncInfo> map = this.f14006a;
        if (map != null) {
            map.clear();
        }
    }

    public void b() throws IOException {
        g.F(this.f14007b, f14005c, new Gson().toJson(this.f14006a));
    }

    public Map<String, BookSyncInfo> c() {
        try {
            this.f14006a = g();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (this.f14006a == null) {
            this.f14006a = new ConcurrentHashMap();
        }
        return this.f14006a;
    }

    public String d(LinkedList<BookSyncInfo> linkedList) {
        return new Gson().toJson(new BookSyncList(linkedList));
    }

    public String e() {
        if (this.f14006a == null) {
            c();
        }
        return d(new LinkedList<>(this.f14006a.values()));
    }

    public final Map<String, BookSyncInfo> f(String str) {
        return (Map) GsonUtils.a().fromJson(str, new a().getType());
    }

    public final Map<String, BookSyncInfo> g() throws IOException {
        return f(g.B(this.f14007b, f14005c));
    }

    public void h(BookSyncInfo bookSyncInfo) {
        if (this.f14006a == null) {
            c();
        }
        if (bookSyncInfo == null || l.q(bookSyncInfo.getSourceString())) {
            return;
        }
        this.f14006a.remove(bookSyncInfo.getSourceString());
        this.f14006a.put(bookSyncInfo.getSourceString(), bookSyncInfo);
    }
}
