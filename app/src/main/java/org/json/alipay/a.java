package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public ArrayList f29227a;

    public a() {
        this.f29227a = new ArrayList();
    }

    public final int a() {
        return this.f29227a.size();
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }

    public a(Object obj) {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f29227a.add(Array.get(obj, i10));
        }
    }

    public final Object a(int i10) {
        Object obj = (i10 < 0 || i10 >= this.f29227a.size()) ? null : this.f29227a.get(i10);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i10 + "] not found.");
    }

    public a(String str) {
        this(new c(str));
    }

    private String a(String str) {
        int size = this.f29227a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f29227a.get(i10)));
        }
        return stringBuffer.toString();
    }

    public a(Collection collection) {
        this.f29227a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c10;
        ArrayList arrayList;
        Object d10;
        char c11 = cVar.c();
        if (c11 == '[') {
            c10 = ']';
        } else {
            if (c11 != '(') {
                throw cVar.a("A JSONArray text must start with '['");
            }
            c10 = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c12 = cVar.c();
            cVar.a();
            if (c12 == ',') {
                arrayList = this.f29227a;
                d10 = null;
            } else {
                arrayList = this.f29227a;
                d10 = cVar.d();
            }
            arrayList.add(d10);
            char c13 = cVar.c();
            if (c13 != ')') {
                if (c13 != ',' && c13 != ';') {
                    if (c13 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c10 == c13) {
                return;
            }
            throw cVar.a("Expected a '" + new Character(c10) + "'");
        } while (cVar.c() != ']');
    }
}
