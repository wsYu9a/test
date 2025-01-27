package com.martian.mibook.lib.model.manager;

import com.martian.libmars.d.h;
import com.martian.mibook.lib.model.c.f;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a */
    public static final String f14049a = "zhuishu";

    /* renamed from: b */
    public static final String f14050b = "leidian";

    /* renamed from: c */
    public static final String f14051c = "baidu";

    /* renamed from: d */
    public static final String f14052d = "sogou";

    /* renamed from: e */
    public static final String f14053e = "easou";

    /* renamed from: f */
    public static final String f14054f = "bdcs";

    /* renamed from: g */
    public static final String f14055g = "txs";

    /* renamed from: h */
    public static final String f14056h = "txt";

    /* renamed from: i */
    public static final String f14057i = "dd";

    /* renamed from: j */
    public static final String f14058j = "mht";
    public static final String k = "yw";
    public static final String l = "tf";
    public static final int m = 888;
    public static final String n = "orbook_title";
    public static final String o = "orbook_consume_coins";
    public static final String p = "orbook_account_coins";
    private final Map<String, f> q;

    public d() {
        HashMap hashMap = new HashMap();
        this.q = hashMap;
        l(hashMap);
    }

    public static String a(g sourceProvider) {
        return sourceProvider.getSourceName() + "_" + sourceProvider.getSourceId();
    }

    public static g b(String sourceName, String sourceId) {
        Source source = new Source();
        source.setSourceName(sourceName);
        source.setSourceId(sourceId);
        return source;
    }

    public static String c(String sourceStr) {
        String[] split = sourceStr.split("\\|");
        if (split.length == 1) {
            return split[0];
        }
        if (split.length == 2) {
            return split[1];
        }
        throw new IllegalStateException();
    }

    public static String d(String sourceStr) {
        String[] split = sourceStr.split("\\|");
        return split.length < 2 ? f14049a : split[0];
    }

    public static String e(String sourceName) {
        sourceName.hashCode();
        switch (sourceName) {
            case "zhuishu":
                return "[默认]";
            case "dd":
            case "mht":
            case "sogou":
                return "[搜狗]";
            case "tf":
                return "[免费]";
            case "yw":
                return "[阅文]";
            case "txs":
                return "[小淘原创]";
            case "txt":
                return "[TXT]";
            case "bdcs":
                return "[百度正版]";
            case "leidian":
                return "[雷电]";
            case "baidu":
                return "[百度]";
            case "easou":
                return "[宜搜]";
            default:
                return "[未知来源]";
        }
    }

    public static String i(g source) {
        return j(source.getSourceName(), source.getSourceId());
    }

    public static String j(String sourceName, String sourceId) {
        return sourceName + "|" + sourceId;
    }

    public static g k(String sourceStr) {
        String[] split = sourceStr.split("\\|");
        if (split.length == 1) {
            return b(f14049a, sourceStr);
        }
        if (split.length != 2) {
            if (h.F().Q0()) {
                throw new NoSuchElementException();
            }
            return null;
        }
        Source source = new Source();
        source.setSourceName(split[0]);
        source.setSourceId(split[1]);
        return source;
    }

    protected f f(Book book) {
        return this.q.get(book.getSourceName());
    }

    protected f g(String sourceName) {
        return this.q.get(sourceName);
    }

    public Collection<f> h() {
        return this.q.values();
    }

    protected abstract void l(Map<String, f> sourceProviders);
}
