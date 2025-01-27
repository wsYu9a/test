package com.zk_oaction.adengine.lk_variable;

import com.zk_oaction.adengine.lk_animation.i;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class d implements a.w, c.b {

    /* renamed from: a */
    public String f35040a;

    /* renamed from: b */
    private com.zk_oaction.adengine.lk_sdk.c f35041b;

    /* renamed from: d */
    private String f35043d;

    /* renamed from: e */
    private String f35044e;

    /* renamed from: g */
    private float f35046g;

    /* renamed from: i */
    private ArrayList<com.zk_oaction.adengine.lk_command.g> f35048i;

    /* renamed from: h */
    private float f35047h = 0.0f;

    /* renamed from: c */
    private ArrayList<f> f35042c = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<com.zk_oaction.adengine.lk_animation.b> f35045f = new ArrayList<>();

    public d(com.zk_oaction.adengine.lk_sdk.c cVar, String str) {
        this.f35041b = cVar;
        this.f35043d = str;
        if (str != null) {
            str.equals("point_count");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.zk_oaction.adengine.lk_animation.b, com.zk_oaction.adengine.lk_animation.i] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.zk_oaction.adengine.lk_animation.c] */
    private void g(XmlPullParser xmlPullParser) {
        ArrayList arrayList;
        com.zk_oaction.adengine.lk_command.g gVar;
        if (xmlPullParser.getName().equals("VariableAnimation")) {
            ?? iVar = new i(this.f35041b, this);
            if (!iVar.c(xmlPullParser)) {
                return;
            }
            this.f35041b.K.c(iVar);
            arrayList = this.f35045f;
            gVar = iVar;
        } else {
            if (!xmlPullParser.getName().equals("Trigger")) {
                return;
            }
            com.zk_oaction.adengine.lk_command.g gVar2 = new com.zk_oaction.adengine.lk_command.g(this.f35041b);
            if (!gVar2.c(xmlPullParser, "Trigger")) {
                return;
            }
            if (this.f35048i == null) {
                this.f35048i = new ArrayList<>();
            }
            arrayList = this.f35048i;
            gVar = gVar2;
        }
        arrayList.add(gVar);
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        f("" + f2);
    }

    public void b(f fVar) {
        if (this.f35042c.contains(fVar)) {
            return;
        }
        this.f35042c.add(fVar);
    }

    public boolean c() {
        String str = this.f35040a;
        return str == null || str.equals("number");
    }

    public boolean d(XmlPullParser xmlPullParser) {
        this.f35040a = xmlPullParser.getAttributeValue(null, "type");
        String attributeValue = xmlPullParser.getAttributeValue(null, "threshold");
        if (attributeValue != null) {
            try {
                this.f35046g = Float.parseFloat(attributeValue);
                this.f35048i = new ArrayList<>();
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "thresholdtype");
                if (attributeValue2 != null) {
                    this.f35047h = Float.parseFloat(attributeValue2);
                }
            } catch (Throwable unused) {
            }
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "expression");
        if (attributeValue3 != null) {
            if (c()) {
                com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f35041b, this.f35043d, attributeValue3, 0.0f, null, false);
                String str = this.f35043d;
                if (str != null && this.f35041b.A(str, aVar.f34840e)) {
                    aVar.i(this);
                }
            } else {
                new com.zk_oaction.adengine.lk_expression.c(this.f35041b, attributeValue3, this);
            }
        }
        xmlPullParser.getAttributeValue(null, "persist");
        if (attributeValue3 != null && attributeValue3.indexOf("rand") == -1 && attributeValue3.indexOf("screen_width") == -1) {
            attributeValue3.indexOf("screen_height");
        }
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                if (next == 2) {
                    g(xmlPullParser);
                } else if (next == 3 && xmlPullParser.getName().equals("Var")) {
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public String e() {
        return this.f35044e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
    
        if ((r0 - r6) >= r5.f35046g) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
    
        if (r2 == 0.0f) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = r5.f35044e
            if (r0 == 0) goto Lc
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto Lc
            goto L95
        Lc:
            java.lang.String r0 = r5.f35044e
            r5.f35044e = r6
            r1 = 0
            r2 = 0
        L12:
            java.util.ArrayList<com.zk_oaction.adengine.lk_variable.f> r3 = r5.f35042c
            int r3 = r3.size()
            if (r2 >= r3) goto L2a
            java.util.ArrayList<com.zk_oaction.adengine.lk_variable.f> r3 = r5.f35042c
            java.lang.Object r3 = r3.get(r2)
            com.zk_oaction.adengine.lk_variable.f r3 = (com.zk_oaction.adengine.lk_variable.f) r3
            java.lang.String r4 = r5.f35043d
            r3.a(r4, r6)
            int r2 = r2 + 1
            goto L12
        L2a:
            java.util.ArrayList<com.zk_oaction.adengine.lk_command.g> r2 = r5.f35048i     // Catch: java.lang.Exception -> L91
            if (r2 == 0) goto L95
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L91
            if (r2 != 0) goto L95
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L91
            if (r2 != 0) goto L95
            float r2 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.Exception -> L91
            float r3 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.Exception -> L91
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)     // Catch: java.lang.Exception -> L91
            float r3 = r5.f35046g     // Catch: java.lang.Exception -> L91
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L95
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.Exception -> L91
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.Exception -> L91
            float r2 = r5.f35047h     // Catch: java.lang.Exception -> L91
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 != 0) goto L66
            float r3 = r6 - r0
            float r4 = r5.f35046g     // Catch: java.lang.Exception -> L91
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 < 0) goto L66
            goto L78
        L66:
            r3 = 1073741824(0x40000000, float:2.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 != 0) goto L73
            float r3 = r5.f35046g     // Catch: java.lang.Exception -> L91
            float r0 = r0 - r6
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 >= 0) goto L78
        L73:
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 != 0) goto L79
        L78:
            r1 = 1
        L79:
            if (r1 == 0) goto L95
            java.util.ArrayList<com.zk_oaction.adengine.lk_command.g> r6 = r5.f35048i     // Catch: java.lang.Exception -> L91
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Exception -> L91
        L81:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L95
            java.lang.Object r0 = r6.next()     // Catch: java.lang.Exception -> L91
            com.zk_oaction.adengine.lk_command.g r0 = (com.zk_oaction.adengine.lk_command.g) r0     // Catch: java.lang.Exception -> L91
            r0.a()     // Catch: java.lang.Exception -> L91
            goto L81
        L91:
            r6 = move-exception
            r6.printStackTrace()
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_variable.d.f(java.lang.String):void");
    }

    public String h() {
        return this.f35043d;
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void m(String str) {
        f(str);
    }
}
