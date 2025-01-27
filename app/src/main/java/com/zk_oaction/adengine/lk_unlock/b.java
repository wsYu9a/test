package com.zk_oaction.adengine.lk_unlock;

import android.os.Handler;
import android.os.Looper;
import com.vivo.ic.dm.Downloads;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_sdk.interfaces.f;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class b implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.a, f {

    /* renamed from: a */
    protected com.zk_oaction.adengine.lk_sdk.c f34987a;

    /* renamed from: b */
    protected String f34988b;

    /* renamed from: c */
    protected com.zk_oaction.adengine.lk_expression.a f34989c;

    /* renamed from: d */
    protected com.zk_oaction.adengine.lk_expression.a f34990d;

    /* renamed from: e */
    protected com.zk_oaction.adengine.lk_expression.a f34991e;

    /* renamed from: f */
    protected com.zk_oaction.adengine.lk_expression.a f34992f;

    /* renamed from: g */
    protected d f34993g;

    /* renamed from: j */
    protected boolean f34996j;
    protected d k;
    protected float[] l;
    protected com.zk_oaction.adengine.lk_variable.d m;
    protected com.zk_oaction.adengine.lk_variable.d n;
    protected com.zk_oaction.adengine.lk_variable.d o;
    protected com.zk_oaction.adengine.lk_variable.d p;
    protected Handler q = new Handler(Looper.getMainLooper());

    /* renamed from: h */
    protected ArrayList<d> f34994h = new ArrayList<>();

    /* renamed from: i */
    protected int f34995i = -1;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.f34993g.c(-1.0f, 0.0f, bVar, bVar.l);
        }
    }

    public b(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34987a = cVar;
        this.f34987a.O.add(this);
    }

    private void c(float f2) {
        int i2;
        com.zk_oaction.adengine.lk_sdk.c cVar;
        String str;
        String str2;
        if (f2 == 1.0f) {
            i2 = 0;
            this.f34995i = 0;
            this.f34993g.e(0);
            Iterator<d> it = this.f34994h.iterator();
            while (it.hasNext()) {
                it.next().e(0);
            }
            if (this.f34988b != null) {
                cVar = this.f34987a;
                str = this.f34988b + ".visibility";
                str2 = "1";
                cVar.u(str, str2);
            }
        } else {
            i2 = 3;
            this.f34995i = 3;
            this.f34993g.e(3);
            Iterator<d> it2 = this.f34994h.iterator();
            while (it2.hasNext()) {
                it2.next().e(3);
            }
            if (this.f34988b != null) {
                cVar = this.f34987a;
                str = this.f34988b + ".visibility";
                str2 = "0";
                cVar.u(str, str2);
            }
        }
        e(i2);
    }

    private void g(XmlPullParser xmlPullParser) {
        try {
            l(xmlPullParser);
            this.f34989c = new com.zk_oaction.adengine.lk_expression.a(this.f34987a, null, xmlPullParser.getAttributeValue(null, "bounceInitSpeed"), 0.0f, null, true);
            this.f34990d = new com.zk_oaction.adengine.lk_expression.a(this.f34987a, null, xmlPullParser.getAttributeValue(null, "bounceAccelation"), 0.0f, null, true);
            this.f34991e = new com.zk_oaction.adengine.lk_expression.a(this.f34987a, null, xmlPullParser.getAttributeValue(null, Downloads.Column.VISIBILITY), 1.0f, null, false);
            this.f34992f = new com.zk_oaction.adengine.lk_expression.a(this.f34987a, "always", xmlPullParser.getAttributeValue(null, "always"), 0.0f, null, false);
            String attributeValue = xmlPullParser.getAttributeValue(null, "keyPoint");
            if (attributeValue != null) {
                String[] split = attributeValue.split(",");
                this.l = new float[split.length];
                int length = split.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.l[i2] = Float.parseFloat(split[i2]);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void l(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        this.f34988b = attributeValue;
        if (attributeValue != null) {
            com.zk_oaction.adengine.lk_variable.d a2 = this.f34987a.J.a(this.f34988b + ".move_x");
            this.m = a2;
            if (a2 == null) {
                com.zk_oaction.adengine.lk_variable.d dVar = new com.zk_oaction.adengine.lk_variable.d(this.f34987a, this.f34988b + ".move_x");
                this.m = dVar;
                this.f34987a.J.d(dVar);
            }
            com.zk_oaction.adengine.lk_variable.d a3 = this.f34987a.J.a(this.f34988b + ".move_y");
            this.n = a3;
            if (a3 == null) {
                com.zk_oaction.adengine.lk_variable.d dVar2 = new com.zk_oaction.adengine.lk_variable.d(this.f34987a, this.f34988b + ".move_y");
                this.n = dVar2;
                this.f34987a.J.d(dVar2);
            }
            com.zk_oaction.adengine.lk_variable.d a4 = this.f34987a.J.a(this.f34988b + ".move_dist");
            this.o = a4;
            if (a4 == null) {
                com.zk_oaction.adengine.lk_variable.d dVar3 = new com.zk_oaction.adengine.lk_variable.d(this.f34987a, this.f34988b + ".move_dist");
                this.o = dVar3;
                this.f34987a.J.d(dVar3);
            }
            com.zk_oaction.adengine.lk_variable.d a5 = this.f34987a.J.a(this.f34988b + ".state");
            this.p = a5;
            if (a5 == null) {
                com.zk_oaction.adengine.lk_variable.d dVar4 = new com.zk_oaction.adengine.lk_variable.d(this.f34987a, this.f34988b + ".state");
                this.p = dVar4;
                this.f34987a.J.d(dVar4);
            }
        }
    }

    private void o() {
        this.f34987a.r(this);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void a() {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void a(String str) {
        int i2;
        com.zk_oaction.adengine.lk_sdk.c cVar;
        String str2;
        String str3;
        if (str.equals("true")) {
            i2 = 0;
            this.f34993g.e(0);
            Iterator<d> it = this.f34994h.iterator();
            while (it.hasNext()) {
                it.next().e(0);
            }
            if (this.f34988b != null) {
                cVar = this.f34987a;
                str2 = this.f34988b + ".visibility";
                str3 = "1";
                cVar.u(str2, str3);
            }
            e(i2);
        }
        if (!str.equals("false")) {
            if (str.equals("toggle")) {
                a((String) null, this.f34995i == 0 ? 0.0f : 1.0f);
                return;
            }
            return;
        }
        i2 = 3;
        this.f34993g.e(3);
        Iterator<d> it2 = this.f34994h.iterator();
        while (it2.hasNext()) {
            it2.next().e(3);
        }
        if (this.f34988b != null) {
            cVar = this.f34987a;
            str2 = this.f34988b + ".visibility";
            str3 = "0";
            cVar.u(str2, str3);
        }
        e(i2);
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        if (str == null) {
            c(f2);
        } else if (b(this.f34992f, "always").equals(str)) {
            o();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean a(float f2, float f3) {
        if (this.f34995i == 3) {
            return false;
        }
        return this.f34993g.h(f2, f3);
    }

    public String b(com.zk_oaction.adengine.lk_expression.a aVar, String str) {
        return aVar != null ? aVar.f34838c : str;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
        a(str);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean c() {
        return this.f34995i == 3;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d() {
    }

    public void d(float f2, float f3, boolean z) {
        this.f34993g.d(f2, f3, z);
        this.f34993g.z();
        if (this.f34988b != null) {
            this.m.f("" + (this.f34993g.n() / this.f34987a.P));
            this.n.f("" + (this.f34993g.q() / this.f34987a.P));
            com.zk_oaction.adengine.lk_variable.d dVar = this.o;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            double sqrt = Math.sqrt((this.f34993g.n() * this.f34993g.n()) + (this.f34993g.q() * this.f34993g.q()));
            double d2 = this.f34987a.P;
            Double.isNaN(d2);
            sb.append(sqrt / d2);
            dVar.f(sb.toString());
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.f34988b;
    }

    protected void e(int i2) {
        if (this.f34995i == i2) {
            return;
        }
        this.f34995i = i2;
        if (this.f34988b == null || i2 >= 3) {
            return;
        }
        this.p.f("" + i2);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void f(float f2, float f3) {
        this.f34993g.e(1);
        Iterator<d> it = this.f34994h.iterator();
        while (it.hasNext()) {
            it.next().e(1);
        }
        e(1);
        this.f34993g.k(f2, f3);
        this.f34987a.m(50L);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void h(float f2, float f3) {
        d(f2, f3, false);
        this.f34996j = false;
        this.k = null;
        Iterator<d> it = this.f34994h.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.h(this.f34993g.t(), this.f34993g.w())) {
                this.f34996j = true;
                this.k = next;
                next.e(2);
            } else {
                next.e(1);
            }
        }
        if (!this.f34996j) {
            if (this.f34993g.j() != 1) {
                this.f34993g.e(1);
                e(1);
                return;
            }
            return;
        }
        if (this.f34993g.j() != 2) {
            this.f34993g.e(2);
            e(2);
            this.f34987a.m(50L);
        }
    }

    public boolean i(XmlPullParser xmlPullParser, String str) {
        g(xmlPullParser);
        try {
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        if (this.f34994h.size() == 1) {
                            this.f34993g.f35011a = this.f34994h.get(0).f35011a;
                        }
                        this.f34991e.i(this);
                        this.f34992f.i(this);
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("StartPoint")) {
                    d dVar = new d(this.f34987a);
                    this.f34993g = dVar;
                    if (!dVar.i(xmlPullParser, "StartPoint")) {
                        break;
                    }
                } else if (xmlPullParser.getName().equals("EndPoint")) {
                    d dVar2 = new d(this.f34987a);
                    if (!dVar2.i(xmlPullParser, "EndPoint")) {
                        break;
                    }
                    this.f34994h.add(dVar2);
                } else {
                    continue;
                }
                next = xmlPullParser.next();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void j(float f2, float f3) {
        if (this.f34996j) {
            this.k.B();
        } else {
            this.f34987a.m(50L);
        }
        if (this.f34995i == 2) {
            this.q.postDelayed(new a(), 100L);
        } else {
            this.f34993g.c(this.f34989c.b(), this.f34990d.b(), this, this.l);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void k(float f2, float f3) {
        this.f34993g.c(this.f34989c.b(), this.f34990d.b(), this, this.l);
    }

    public boolean m() {
        return this.f34992f.b() == 1.0f;
    }

    public void n() {
        this.f34987a.X = false;
        if (this.f34995i != 3) {
            this.f34993g.e(0);
            Iterator<d> it = this.f34994h.iterator();
            while (it.hasNext()) {
                it.next().e(0);
            }
            e(0);
        }
    }
}
