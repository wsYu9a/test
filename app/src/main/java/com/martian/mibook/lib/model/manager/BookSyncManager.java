package com.martian.mibook.lib.model.manager;

import android.content.Context;
import com.google.gson.Gson;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.utils.q0;
import com.martian.libsupport.e;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.data.BookSyncInfo;
import com.martian.mibook.lib.model.data.BookSyncList;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class BookSyncManager {

    /* renamed from: a */
    public static final String f14034a = "booksync.json";

    /* renamed from: b */
    public Map<String, BookSyncInfo> f14035b;

    /* renamed from: c */
    private final Context f14036c;

    class a extends com.google.gson.b.a<Map<String, BookSyncInfo>> {
        a() {
        }
    }

    public BookSyncManager(Context context) {
        this.f14036c = context;
    }

    private Map<String, BookSyncInfo> g(String json) throws JSONException {
        return (Map) GsonUtils.a().fromJson(json, new a().getType());
    }

    private Map<String, BookSyncInfo> h() throws IOException, JSONException {
        String B = e.B(this.f14036c, f14034a);
        q0.d(this, "bookSyncRestore -> " + B);
        return g(B);
    }

    public void a() {
        e.p(this.f14036c, f14034a);
        Map<String, BookSyncInfo> map = this.f14035b;
        if (map != null) {
            map.clear();
        }
    }

    public void b() throws IOException {
        String json = new Gson().toJson(this.f14035b);
        q0.d(this, "bookSyncRestore -> " + json);
        e.E(this.f14036c, f14034a, json);
    }

    public void c(Map<String, BookSyncInfo> items) throws IOException {
        String json = new Gson().toJson(items);
        q0.d(this, "bookSyncRestore -> " + json);
        e.E(this.f14036c, f14034a, json);
    }

    public Map<String, BookSyncInfo> d() {
        try {
            this.f14035b = h();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f14035b == null) {
            this.f14035b = new ConcurrentHashMap();
        }
        return this.f14035b;
    }

    public String e(LinkedList<BookSyncInfo> bookSynclist) {
        return new Gson().toJson(new BookSyncList(bookSynclist));
    }

    public String f() {
        if (this.f14035b == null) {
            d();
        }
        return e(new LinkedList<>(this.f14035b.values()));
    }

    public void i(Map<String, BookSyncInfo> booksyncList) {
        this.f14035b = booksyncList;
    }

    public void j(BookSyncInfo bookSyncInfo) {
        if (this.f14035b == null) {
            d();
        }
        if (bookSyncInfo == null || k.p(bookSyncInfo.getSourceString())) {
            return;
        }
        this.f14035b.remove(bookSyncInfo.getSourceString());
        this.f14035b.put(bookSyncInfo.getSourceString(), bookSyncInfo);
    }
}
