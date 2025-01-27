package com.zk_oaction.adengine.lk_expression;

import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_variable.f;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class c implements a.w, f {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f34850a;

    /* renamed from: b */
    private String f34851b;

    /* renamed from: c */
    private String f34852c;

    /* renamed from: d */
    private b f34853d;

    /* renamed from: e */
    private int f34854e;

    /* renamed from: f */
    private ArrayList<com.zk_oaction.adengine.lk_expression.a> f34855f;

    /* renamed from: g */
    private ArrayList<Object> f34856g;

    /* renamed from: h */
    private boolean f34857h;

    /* renamed from: i */
    private com.zk_oaction.adengine.lk_expression.a f34858i;

    /* renamed from: j */
    private ArrayList<c> f34859j;
    private b k = new a();

    class a implements b {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_expression.c.b
        public void m(String str) {
            c.this.e();
        }
    }

    public interface b {
        void m(String str);
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar, String str, b bVar) {
        this.f34850a = cVar;
        this.f34851b = str;
        this.f34853d = bVar;
        if (str.isEmpty()) {
            this.f34852c = "";
        } else {
            char charAt = str.charAt(0);
            if (str.startsWith("ifelse")) {
                int indexOf = str.indexOf(40);
                String substring = str.substring(0, indexOf);
                ArrayList<String> g2 = com.zk_oaction.adengine.lk_expression.a.g(str.substring(indexOf + 1, str.length() - 1));
                if (substring.equals("ifelse")) {
                    this.f34854e = 2;
                    this.f34855f = new ArrayList<>();
                    this.f34856g = new ArrayList<>();
                    int size = g2.size();
                    for (int i2 = 0; i2 < size - 1; i2 += 2) {
                        this.f34855f.add(new com.zk_oaction.adengine.lk_expression.a(this.f34850a, null, g2.get(i2), 0.0f, this, false));
                        String str2 = g2.get(i2 + 1);
                        if (str2.contains("'")) {
                            this.f34856g.add(str2.substring(1, str2.length() - 1));
                        } else {
                            this.f34856g.add(new c(this.f34850a, str2, this.k));
                        }
                    }
                    String str3 = g2.get(g2.size() - 1);
                    if (str3.contains("'")) {
                        this.f34856g.add(str3.substring(1, str3.length() - 1));
                    } else {
                        this.f34856g.add(new c(this.f34850a, str3, this.k));
                    }
                }
            } else if (str.contains("+")) {
                this.f34854e = 4;
                this.f34859j = c(str.replace(" ", "").replace("+", "~"));
            } else if (charAt == '\'') {
                this.f34854e = 1;
                this.f34852c = str.substring(1, str.length() - 1);
            } else if (charAt == '#' || charAt == '@') {
                this.f34854e = 0;
                String substring2 = str.substring(1);
                this.f34851b = substring2;
                this.f34850a.t(substring2, this);
            } else if (str.contains("#")) {
                this.f34854e = 3;
                this.f34858i = new com.zk_oaction.adengine.lk_expression.a(this.f34850a, null, str, 0.0f, this, false);
            } else {
                this.f34854e = 1;
                this.f34852c = str;
            }
        }
        this.f34857h = true;
        e();
    }

    private ArrayList<c> c(String str) {
        ArrayList<c> arrayList = new ArrayList<>();
        for (String str2 : str.split("~")) {
            arrayList.add(new c(this.f34850a, str2, this.k));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r5 = this;
            boolean r0 = r5.f34857h
            if (r0 != 0) goto L6
            goto L78
        L6:
            int r0 = r5.f34854e
            java.lang.String r1 = ""
            if (r0 == 0) goto L5d
            r2 = 2
            if (r0 == r2) goto L59
            r2 = 3
            if (r0 == r2) goto L42
            r2 = 4
            if (r0 == r2) goto L16
            goto L69
        L16:
            r5.f34852c = r1
            java.util.ArrayList<com.zk_oaction.adengine.lk_expression.c> r0 = r5.f34859j
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L69
            java.lang.Object r2 = r0.next()
            com.zk_oaction.adengine.lk_expression.c r2 = (com.zk_oaction.adengine.lk_expression.c) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r5.f34852c
            r3.append(r4)
            java.lang.String r2 = r2.b()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r5.f34852c = r2
            goto L1e
        L42:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            com.zk_oaction.adengine.lk_expression.a r2 = r5.f34858i
            float r2 = r2.b()
            int r2 = (int) r2
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L67
        L59:
            r5.f()
            goto L69
        L5d:
            com.zk_oaction.adengine.lk_sdk.c r0 = r5.f34850a
            com.zk_oaction.adengine.lk_variable.g r0 = r0.J
            java.lang.String r2 = r5.f34851b
            java.lang.String r0 = r0.h(r2)
        L67:
            r5.f34852c = r0
        L69:
            java.lang.String r0 = r5.f34852c
            if (r0 != 0) goto L6f
            r5.f34852c = r1
        L6f:
            com.zk_oaction.adengine.lk_expression.c$b r0 = r5.f34853d
            if (r0 == 0) goto L78
            java.lang.String r1 = r5.f34852c
            r0.m(r1)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_expression.c.e():void");
    }

    private void f() {
        int size = this.f34855f.size();
        Object obj = this.f34856g.get(size - 1);
        this.f34852c = obj instanceof String ? (String) obj : ((c) obj).b();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f34855f.get(i2).b() != 0.0f) {
                Object obj2 = this.f34856g.get(i2);
                this.f34852c = obj2 instanceof String ? (String) obj2 : ((c) obj2).b();
                return;
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        e();
    }

    @Override // com.zk_oaction.adengine.lk_variable.f
    public void a(String str, String str2) {
        e();
    }

    public String b() {
        String str = this.f34852c;
        return str == null ? "" : str;
    }
}
