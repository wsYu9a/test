package com.zk_oaction.adengine.lk_unlock;

import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_sdk.a;
import java.net.URISyntaxException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class d implements a.w, a.b {

    /* renamed from: a */
    public com.zk_oaction.adengine.lk_unlock.a f35011a;

    /* renamed from: b */
    public com.zk_oaction.adengine.lk_command.g f35012b;

    /* renamed from: c */
    public Intent f35013c;

    /* renamed from: d */
    private com.zk_oaction.adengine.lk_sdk.c f35014d;

    /* renamed from: e */
    private com.zk_oaction.adengine.lk_unlock.c f35015e;

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_unlock.c f35016f;

    /* renamed from: g */
    private com.zk_oaction.adengine.lk_unlock.c f35017g;

    /* renamed from: h */
    private com.zk_oaction.adengine.lk_expression.a f35018h;

    /* renamed from: i */
    private com.zk_oaction.adengine.lk_expression.a f35019i;

    /* renamed from: j */
    private com.zk_oaction.adengine.lk_expression.a f35020j;
    private com.zk_oaction.adengine.lk_expression.a k;
    private float m;
    private float n;
    private float o;
    private float p;
    private String r;
    private String s;
    private String t;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> u;
    private com.zk_oaction.adengine.lk_unlock.b v;
    private float w;
    private float x;
    private float y;
    private RectF l = new RectF();
    private int q = -1;

    class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            d.this.g(xmlPullParser);
            return null;
        }
    }

    class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            d.this.m(xmlPullParser);
            return null;
        }
    }

    class c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            d.this.p(xmlPullParser);
            return null;
        }
    }

    /* renamed from: com.zk_oaction.adengine.lk_unlock.d$d */
    class C0816d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        C0816d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            d.this.s(xmlPullParser);
            return null;
        }
    }

    class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            d.this.v(xmlPullParser);
            return null;
        }
    }

    class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            d.this.y(xmlPullParser);
            return null;
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.f35014d.G.p(d.this.f35013c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public d(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f35014d = cVar;
        D();
    }

    private void A(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        try {
            if (attributeValue != null) {
                this.f35013c = (Intent) Intent.parseUri(attributeValue, 0).clone();
                return;
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "selectIntent");
            if (attributeValue2 != null) {
                int lastIndexOf = attributeValue2.lastIndexOf("#Intent");
                Intent parseUri = Intent.parseUri(attributeValue2.substring(0, lastIndexOf - 1), 0);
                if (this.f35014d.F.getPackageManager().queryIntentActivities(parseUri, 0).isEmpty()) {
                    parseUri = Intent.parseUri(attributeValue2.substring(lastIndexOf), 0);
                }
                this.f35013c = (Intent) parseUri.clone();
            }
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
    }

    private void C(XmlPullParser xmlPullParser) {
        this.f35013c.addFlags(270532608);
        String attributeValue = xmlPullParser.getAttributeValue(null, "action");
        if (attributeValue != null) {
            this.f35013c.setAction(attributeValue);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "uri");
        if (attributeValue2 != null) {
            this.f35013c.setData(Uri.parse(attributeValue2));
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "type");
        if (attributeValue3 != null) {
            this.f35013c.setType(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "category");
        if (attributeValue4 != null) {
            this.f35013c.addCategory(attributeValue4);
        }
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "package");
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "class");
        if (attributeValue5 == null || attributeValue6 == null) {
            return;
        }
        this.f35013c.setClassName(attributeValue5, attributeValue6);
    }

    private void D() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> hashMap = new HashMap<>();
        this.u = hashMap;
        hashMap.put("NormalState", new a());
        this.u.put("PressedState", new b());
        this.u.put("ReachedState", new c());
        this.u.put("Path", new C0816d());
        this.u.put("Trigger", new e());
        this.u.put("Intent", new f());
    }

    private void E() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f35015e;
        if (cVar != null && !cVar.j()) {
            this.f35015e.a();
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f35016f;
        if (cVar2 != null) {
            cVar2.f(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar3 = this.f35017g;
        if (cVar3 != null) {
            cVar3.f(true);
        }
        String str = this.r;
        if (str != null) {
            this.f35014d.G.q(str, 1.0f, false, false);
        }
    }

    private void F() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f35016f;
        if (cVar != null && !cVar.j()) {
            this.f35016f.a();
            com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f35015e;
            if (cVar2 != null) {
                cVar2.f(true);
            }
            com.zk_oaction.adengine.lk_unlock.c cVar3 = this.f35017g;
            if (cVar3 != null) {
                cVar3.f(true);
            }
        }
        String str = this.s;
        if (str != null) {
            this.f35014d.G.q(str, 1.0f, false, false);
        }
    }

    private void G() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f35017g;
        if (cVar != null && !cVar.j()) {
            this.f35017g.a();
            com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f35015e;
            if (cVar2 != null) {
                cVar2.f(true);
            }
            com.zk_oaction.adengine.lk_unlock.c cVar3 = this.f35016f;
            if (cVar3 != null) {
                cVar3.f(this.q != 1);
            }
        }
        String str = this.t;
        if (str != null) {
            this.f35014d.G.q(str, 1.0f, false, false);
        }
    }

    private void H() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f35015e;
        if (cVar != null) {
            cVar.f(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f35016f;
        if (cVar2 != null) {
            cVar2.f(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar3 = this.f35017g;
        if (cVar3 != null) {
            cVar3.f(true);
        }
    }

    public void g(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.c cVar = new com.zk_oaction.adengine.lk_unlock.c(this.f35014d);
        this.f35015e = cVar;
        if (cVar.g(xmlPullParser, "NormalState")) {
            return;
        }
        this.f35015e = null;
    }

    public void m(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.c cVar = new com.zk_oaction.adengine.lk_unlock.c(this.f35014d);
        this.f35016f = cVar;
        if (cVar.g(xmlPullParser, "PressedState")) {
            return;
        }
        this.f35016f = null;
    }

    public void p(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.c cVar = new com.zk_oaction.adengine.lk_unlock.c(this.f35014d);
        this.f35017g = cVar;
        if (cVar.g(xmlPullParser, "ReachedState")) {
            return;
        }
        this.f35017g = null;
    }

    public void s(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.a aVar = new com.zk_oaction.adengine.lk_unlock.a(this.f35014d);
        this.f35011a = aVar;
        if (aVar.d(xmlPullParser, "Path")) {
            return;
        }
        this.f35011a = null;
    }

    public void v(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.g gVar = new com.zk_oaction.adengine.lk_command.g(this.f35014d);
        this.f35012b = gVar;
        if (gVar.c(xmlPullParser, "Trigger")) {
            return;
        }
        this.f35012b = null;
    }

    public void y(XmlPullParser xmlPullParser) {
        this.f35013c = new Intent();
        A(xmlPullParser);
        C(xmlPullParser);
    }

    public void B() {
        if (this.f35013c != null) {
            new Handler(Looper.getMainLooper()).post(new g());
        }
        com.zk_oaction.adengine.lk_command.g gVar = this.f35012b;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.a.b
    public void a() {
        this.v.n();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.a.b
    public void a(float f2) {
        float f3 = f2 / this.w;
        float f4 = this.x;
        float f5 = this.m;
        float f6 = this.y;
        this.v.d((f4 * f3) + f5, (f3 * f6) + this.n, true);
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        com.zk_oaction.adengine.lk_expression.a aVar = this.f35018h;
        if (aVar == null || this.f35019i == null || this.f35020j == null || this.k == null) {
            return;
        }
        this.l.set(aVar.b(), this.f35019i.b(), this.f35018h.b() + this.f35020j.b(), this.f35019i.b() + this.k.b());
    }

    public void c(float f2, float f3, com.zk_oaction.adengine.lk_unlock.b bVar, float[] fArr) {
        this.f35014d.X = true;
        if (f2 == -1.0f) {
            bVar.d(this.m, this.n, true);
            bVar.n();
            return;
        }
        float f4 = f2 < 100.0f ? 100.0f : f2;
        float f5 = f3 < 10.0f ? 10.0f : f3;
        this.v = bVar;
        float sqrt = (float) Math.sqrt((n() * n()) + (q() * q()));
        this.w = sqrt;
        if (sqrt == 0.0f) {
            this.v.n();
            return;
        }
        this.x = n();
        this.y = q();
        new com.zk_oaction.adengine.lk_sdk.a().c(f4, f5, this.w, this, fArr);
    }

    public void d(float f2, float f3, boolean z) {
        float f4 = f2 - this.m;
        this.o = f4;
        float f5 = f3 - this.n;
        this.p = f5;
        com.zk_oaction.adengine.lk_unlock.a aVar = this.f35011a;
        if (aVar != null) {
            aVar.b(f4, f5, z);
        }
    }

    public void e(int i2) {
        if (this.q == i2) {
            return;
        }
        if (i2 == 0) {
            E();
        } else if (i2 == 1) {
            F();
        } else if (i2 != 2) {
            H();
        } else {
            G();
        }
        this.q = i2;
    }

    public boolean h(float f2, float f3) {
        float f4 = (int) (f2 + 0.5f);
        float f5 = (int) (f3 + 0.5f);
        RectF rectF = this.l;
        return f4 >= ((float) ((int) (rectF.left + 0.5f))) && f4 <= ((float) ((int) (rectF.right + 0.5f))) && f5 >= ((float) ((int) (rectF.top + 0.5f))) && f5 <= ((float) ((int) (rectF.bottom + 0.5f)));
    }

    public boolean i(XmlPullParser xmlPullParser, String str) {
        try {
            this.f35018h = new com.zk_oaction.adengine.lk_expression.a(this.f35014d, null, xmlPullParser.getAttributeValue(null, "x"), 0.0f, this, true);
            this.f35019i = new com.zk_oaction.adengine.lk_expression.a(this.f35014d, null, xmlPullParser.getAttributeValue(null, "y"), 0.0f, this, true);
            this.f35020j = new com.zk_oaction.adengine.lk_expression.a(this.f35014d, null, xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH), 0.0f, this, true);
            this.k = new com.zk_oaction.adengine.lk_expression.a(this.f35014d, null, xmlPullParser.getAttributeValue(null, "h"), 0.0f, this, true);
            this.l.set(this.f35018h.b(), this.f35019i.b(), this.f35018h.b() + this.f35020j.b(), this.f35019i.b() + this.k.b());
            String attributeValue = xmlPullParser.getAttributeValue(null, "normalSound");
            this.r = attributeValue;
            if (attributeValue != null) {
                String str2 = this.f35014d.H + this.r;
                this.r = str2;
                this.f35014d.G.a(str2);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "pressedSound");
            this.s = attributeValue2;
            if (attributeValue2 != null) {
                String str3 = this.f35014d.H + this.s;
                this.s = str3;
                this.f35014d.G.a(str3);
            }
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "reachedSound");
            this.t = attributeValue3;
            if (attributeValue3 != null) {
                String str4 = this.f35014d.H + this.t;
                this.t = str4;
                this.f35014d.G.a(str4);
            }
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                if (next == 2) {
                    com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> cVar = this.u.get(xmlPullParser.getName());
                    if (cVar != null) {
                        cVar.a(xmlPullParser);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public int j() {
        return this.q;
    }

    public void k(float f2, float f3) {
        this.m = f2;
        this.n = f3;
    }

    public float n() {
        com.zk_oaction.adengine.lk_unlock.a aVar = this.f35011a;
        return aVar != null ? aVar.a() - this.f35018h.b() : this.o;
    }

    public float q() {
        com.zk_oaction.adengine.lk_unlock.a aVar = this.f35011a;
        return aVar != null ? aVar.e() - this.f35019i.b() : this.p;
    }

    public float t() {
        return this.f35018h.b() + n();
    }

    public float w() {
        return this.f35019i.b() + q();
    }

    public void z() {
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f35015e;
        if (cVar != null) {
            cVar.b(n(), q());
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f35016f;
        if (cVar2 != null) {
            cVar2.b(n(), q());
        }
        com.zk_oaction.adengine.lk_unlock.c cVar3 = this.f35017g;
        if (cVar3 != null) {
            cVar3.b(n(), q());
        }
    }
}
