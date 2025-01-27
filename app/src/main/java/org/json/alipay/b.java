package org.json.alipay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import m5.d;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static final Object f29228a = new a((byte) 0);

    /* renamed from: b */
    public Map f29229b;

    public static final class a {
        public a() {
        }

        public final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return "null";
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public b() {
        this.f29229b = new HashMap();
    }

    public static void b(Object obj) {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d10 = (Double) obj;
                if (d10.isInfinite() || d10.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
                return;
            }
            if (obj instanceof Float) {
                Float f10 = (Float) obj;
                if (f10.isInfinite() || f10.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        if (r4 == '<') goto L135;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0034. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r8) {
        /*
            if (r8 == 0) goto La1
            int r0 = r8.length()
            if (r0 != 0) goto La
            goto La1
        La:
            int r0 = r8.length()
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            int r2 = r0 + 4
            r1.<init>(r2)
            r2 = 34
            r1.append(r2)
            r3 = 0
            r4 = 0
        L1c:
            if (r3 >= r0) goto L99
            char r5 = r8.charAt(r3)
            r6 = 12
            if (r5 == r6) goto L92
            r6 = 13
            if (r5 == r6) goto L8f
            r6 = 92
            if (r5 == r2) goto L8b
            r7 = 47
            if (r5 == r7) goto L82
            if (r5 == r6) goto L8b
            switch(r5) {
                case 8: goto L7f;
                case 9: goto L7c;
                case 10: goto L79;
                default: goto L37;
            }
        L37:
            r4 = 32
            if (r5 < r4) goto L4b
            r4 = 128(0x80, float:1.8E-43)
            if (r5 < r4) goto L43
            r4 = 160(0xa0, float:2.24E-43)
            if (r5 < r4) goto L4b
        L43:
            r4 = 8192(0x2000, float:1.148E-41)
            if (r5 < r4) goto L87
            r4 = 8448(0x2100, float:1.1838E-41)
            if (r5 >= r4) goto L87
        L4b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "000"
            r4.<init>(r6)
            java.lang.String r6 = java.lang.Integer.toHexString(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "\\u"
            r6.<init>(r7)
            int r7 = r4.length()
            int r7 = r7 + (-4)
            java.lang.String r4 = r4.substring(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
        L75:
            r1.append(r4)
            goto L95
        L79:
            java.lang.String r4 = "\\n"
            goto L75
        L7c:
            java.lang.String r4 = "\\t"
            goto L75
        L7f:
            java.lang.String r4 = "\\b"
            goto L75
        L82:
            r7 = 60
            if (r4 != r7) goto L87
            goto L8b
        L87:
            r1.append(r5)
            goto L95
        L8b:
            r1.append(r6)
            goto L87
        L8f:
            java.lang.String r4 = "\\r"
            goto L75
        L92:
            java.lang.String r4 = "\\f"
            goto L75
        L95:
            int r3 = r3 + 1
            r4 = r5
            goto L1c
        L99:
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            return r8
        La1:
            java.lang.String r8 = "\"\""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.b.c(java.lang.String):java.lang.String");
    }

    public final Object a(String str) {
        Object obj = str == null ? null : this.f29229b.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONObject[" + c(str) + "] not found.");
    }

    public String toString() {
        try {
            Iterator a10 = a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (a10.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = a10.next();
                stringBuffer.append(c(next.toString()));
                stringBuffer.append(d.f28378d);
                stringBuffer.append(a(this.f29229b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public b(String str) {
        this(new c(str));
    }

    public static String a(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof b) || (obj instanceof org.json.alipay.a)) ? obj.toString() : obj instanceof Map ? new b((Map) obj).toString() : obj instanceof Collection ? new org.json.alipay.a((Collection) obj).toString() : obj.getClass().isArray() ? new org.json.alipay.a(obj).toString() : c(obj.toString());
        }
        Number number = (Number) obj;
        b(number);
        String obj2 = number.toString();
        if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
            return obj2;
        }
        while (obj2.endsWith("0")) {
            obj2 = obj2.substring(0, obj2.length() - 1);
        }
        return obj2.endsWith(p1.b.f29697h) ? obj2.substring(0, obj2.length() - 1) : obj2;
    }

    public final boolean b(String str) {
        return this.f29229b.containsKey(str);
    }

    public b(Map map) {
        this.f29229b = map == null ? new HashMap() : map;
    }

    public final Iterator a() {
        return this.f29229b.keySet().iterator();
    }

    public b(c cVar) {
        this();
        if (cVar.c() != '{') {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c10 = cVar.c();
            if (c10 == 0) {
                throw cVar.a("A JSONObject text must end with '}'");
            }
            if (c10 == '}') {
                return;
            }
            cVar.a();
            String obj = cVar.d().toString();
            char c11 = cVar.c();
            if (c11 == '=') {
                if (cVar.b() != '>') {
                    cVar.a();
                }
            } else if (c11 != ':') {
                throw cVar.a("Expected a ':' after a key");
            }
            Object d10 = cVar.d();
            if (obj == null) {
                throw new JSONException("Null key.");
            }
            if (d10 != null) {
                b(d10);
                this.f29229b.put(obj, d10);
            } else {
                this.f29229b.remove(obj);
            }
            char c12 = cVar.c();
            if (c12 != ',' && c12 != ';') {
                if (c12 != '}') {
                    throw cVar.a("Expected a ',' or '}'");
                }
                return;
            } else if (cVar.c() == '}') {
                return;
            } else {
                cVar.a();
            }
        }
    }
}
