package com.zk_oaction.adengine.lk_variable;

import com.vivo.ic.dm.Downloads;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class c implements a.w, c.b {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f35033a;

    /* renamed from: b */
    private String f35034b;

    /* renamed from: c */
    private ArrayList<d> f35035c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<String> f35036d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<String> f35037e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<com.zk_oaction.adengine.lk_expression.c> f35038f = new ArrayList<>();

    /* renamed from: g */
    private ArrayList<com.zk_oaction.adengine.lk_expression.a> f35039g = new ArrayList<>();

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f35033a = cVar;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        String substring = str.substring(0, str.lastIndexOf(46));
        Iterator<d> it = this.f35035c.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.h().equals(substring) && f2 >= 0.0f && f2 < this.f35037e.size()) {
                next.f(this.f35037e.get((int) f2));
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(XmlPullParser xmlPullParser) {
        ArrayList arrayList;
        String str;
        this.f35034b = xmlPullParser.getAttributeValue(null, "type");
        try {
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next == 2) {
                    if (xmlPullParser.getName().equals("Var")) {
                        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                        d a2 = this.f35033a.J.a(attributeValue);
                        if (a2 == null) {
                            a2 = new d(this.f35033a, attributeValue);
                            this.f35033a.J.d(a2);
                        }
                        a2.f35040a = this.f35034b;
                        this.f35035c.add(a2);
                        arrayList = this.f35036d;
                        str = xmlPullParser.getAttributeValue(null, "index");
                    } else if (xmlPullParser.getName().equals("Item")) {
                        String attributeValue2 = xmlPullParser.getAttributeValue(null, Downloads.RequestHeaders.COLUMN_VALUE);
                        if (attributeValue2.contains("@")) {
                            com.zk_oaction.adengine.lk_expression.c cVar = new com.zk_oaction.adengine.lk_expression.c(this.f35033a, attributeValue2, this);
                            this.f35037e.add(cVar.b());
                            arrayList = this.f35038f;
                            str = cVar;
                        } else {
                            this.f35037e.add(attributeValue2);
                            this.f35038f.add(null);
                        }
                    }
                    arrayList.add(str);
                } else if (next == 3 && xmlPullParser.getName().equals("VarArray")) {
                    for (int i2 = 0; i2 < this.f35035c.size(); i2++) {
                        d dVar = this.f35035c.get(i2);
                        this.f35039g.add(new com.zk_oaction.adengine.lk_expression.a(this.f35033a, dVar.h() + ".index", this.f35036d.get(i2), 0.0f, this, false));
                    }
                    return true;
                }
                next = xmlPullParser.next();
            }
            return false;
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void m(String str) {
        Iterator<com.zk_oaction.adengine.lk_expression.c> it = this.f35038f.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.zk_oaction.adengine.lk_expression.c next = it.next();
            if (next != null && next.b().equals(str)) {
                this.f35037e.remove(i2);
                this.f35037e.add(i2, str);
                break;
            }
            i2++;
        }
        Iterator<com.zk_oaction.adengine.lk_expression.a> it2 = this.f35039g.iterator();
        while (it2.hasNext()) {
            com.zk_oaction.adengine.lk_expression.a next2 = it2.next();
            a(next2.f34838c, next2.b());
        }
    }
}
