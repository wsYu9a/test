package com.zk_oaction.adengine.lk_expression;

import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class b implements a.w, c.b {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f34845a;

    /* renamed from: b */
    private c.b f34846b;

    /* renamed from: c */
    private ArrayList<String> f34847c;

    /* renamed from: d */
    private ArrayList<Object> f34848d;

    /* renamed from: e */
    private boolean f34849e = true;

    public b(com.zk_oaction.adengine.lk_sdk.c cVar, String str, String str2, c.b bVar) {
        this.f34845a = cVar;
        this.f34846b = bVar;
        this.f34847c = c(str);
        this.f34848d = d(str2);
        b();
    }

    private void b() {
        String str;
        if (this.f34849e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("");
            Iterator<String> it = this.f34847c.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                String next = it.next();
                if (next.equals("%d")) {
                    a aVar = (a) this.f34848d.get(i2);
                    int b2 = (int) aVar.b();
                    String str2 = aVar.f34839d;
                    if (str2 == null || (!(str2.equals("#sms_unread_count") || aVar.f34839d.equals("#call_missed_count")) || b2 < 100)) {
                        stringBuffer.append(b2);
                        i2++;
                    } else {
                        str = "99+";
                    }
                } else if (next.equals("%s")) {
                    str = ((c) this.f34848d.get(i2)).b();
                } else {
                    stringBuffer.append(next);
                }
                stringBuffer.append(str);
                i2++;
            }
            this.f34846b.m(stringBuffer.toString());
        }
    }

    private static ArrayList<String> c(String str) {
        String str2;
        ArrayList<String> arrayList = new ArrayList<>();
        int length = str.length();
        String str3 = "";
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (!z && charAt != '%') {
                str3 = str3 + charAt;
            } else if (z || charAt != '%') {
                if (charAt == 'd') {
                    str2 = "%d";
                } else if (charAt == '%') {
                    str2 = "%";
                } else {
                    if (charAt == 's') {
                        str2 = "%s";
                    }
                    z = false;
                }
                arrayList.add(str2);
                z = false;
            } else {
                arrayList.add(str3);
                z = true;
                str3 = "";
            }
        }
        if (!str3.equals("")) {
            arrayList.add(str3);
        }
        return arrayList;
    }

    private ArrayList<Object> d(String str) {
        ArrayList<Object> arrayList = new ArrayList<>();
        if (str != null) {
            Iterator<String> it = a.g(str).iterator();
            while (it.hasNext()) {
                String next = it.next();
                arrayList.add(next.contains("@") ? new c(this.f34845a, next, this) : new a(this.f34845a, null, next, 0.0f, this, false));
            }
        }
        return arrayList;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        b();
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void m(String str) {
        b();
    }
}
