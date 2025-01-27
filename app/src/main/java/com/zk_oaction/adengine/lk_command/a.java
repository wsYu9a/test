package com.zk_oaction.adengine.lk_command;

import android.graphics.RectF;
import com.vivo.ic.dm.Downloads;
import com.zk_oaction.adengine.lk_expression.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class a implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.a, com.zk_oaction.adengine.lk_sdk.interfaces.f {

    /* renamed from: a */
    protected com.zk_oaction.adengine.lk_sdk.c f34803a;

    /* renamed from: b */
    protected com.zk_oaction.adengine.lk_expression.a f34804b;

    /* renamed from: c */
    protected com.zk_oaction.adengine.lk_expression.a f34805c;

    /* renamed from: d */
    protected com.zk_oaction.adengine.lk_expression.a f34806d;

    /* renamed from: e */
    protected com.zk_oaction.adengine.lk_expression.a f34807e;

    /* renamed from: f */
    protected com.zk_oaction.adengine.lk_expression.a f34808f;

    /* renamed from: g */
    protected RectF f34809g = new RectF();

    /* renamed from: h */
    protected ArrayList<g> f34810h = new ArrayList<>();

    /* renamed from: i */
    protected com.zk_oaction.adengine.lk_unlock.c f34811i;

    /* renamed from: j */
    protected com.zk_oaction.adengine.lk_unlock.c f34812j;
    protected String k;
    protected com.zk_oaction.adengine.lk_view.f l;
    protected boolean m;

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34803a = cVar;
    }

    private void d(XmlPullParser xmlPullParser) {
        if ("Trigger".equals(xmlPullParser.getName())) {
            g gVar = new g(this.f34803a);
            if (gVar.c(xmlPullParser, "Trigger")) {
                this.f34810h.add(gVar);
                return;
            }
            return;
        }
        if (xmlPullParser.getName().equals("Normal")) {
            com.zk_oaction.adengine.lk_unlock.c cVar = new com.zk_oaction.adengine.lk_unlock.c(this.f34803a);
            this.f34811i = cVar;
            cVar.d(this.l);
            if (this.f34811i.g(xmlPullParser, "Normal")) {
                return;
            }
            this.f34811i = null;
            return;
        }
        if (xmlPullParser.getName().equals("Pressed")) {
            com.zk_oaction.adengine.lk_unlock.c cVar2 = new com.zk_oaction.adengine.lk_unlock.c(this.f34803a);
            this.f34812j = cVar2;
            cVar2.d(this.l);
            if (this.f34812j.g(xmlPullParser, "Pressed")) {
                return;
            }
            this.f34812j = null;
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void a() {
        Iterator<g> it = this.f34810h.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str = next.f34828a;
            if (str != null && str.equals("double")) {
                next.a();
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void a(String str) {
        boolean z;
        if (str.equals("true")) {
            z = false;
        } else if (str.equals("false")) {
            this.m = true;
            return;
        } else if (!str.equals("toggle")) {
            return;
        } else {
            z = !this.m;
        }
        this.m = z;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        if (str == null || !str.equals(b(this.f34808f, Downloads.Column.VISIBILITY))) {
            g();
        } else {
            this.m = f2 <= 0.0f;
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean a(float f2, float f3) {
        return this.f34809g.contains(f2, f3);
    }

    public String b(com.zk_oaction.adengine.lk_expression.a aVar, String str) {
        return aVar != null ? aVar.f34838c : str;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
    }

    public void c(com.zk_oaction.adengine.lk_view.f fVar) {
        this.l = fVar;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
        a(str);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean c() {
        com.zk_oaction.adengine.lk_view.f fVar;
        return this.m || !((fVar = this.l) == null || fVar.W() == 1.0f);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d() {
        Iterator<g> it = this.f34810h.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str = next.f34828a;
            if (str != null && str.equals("click")) {
                next.a();
            }
        }
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f34812j;
        if (cVar != null) {
            cVar.f(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f34811i;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b2, code lost:
    
        r0 = r11.f34811i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b4, code lost:
    
        if (r0 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b9, code lost:
    
        r0 = r11.f34812j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bb, code lost:
    
        if (r0 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bd, code lost:
    
        r0.f(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c0, code lost:
    
        r0 = r11.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c2, code lost:
    
        if (r0 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c4, code lost:
    
        r0.k(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(org.xmlpull.v1.XmlPullParser r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_command.a.e(org.xmlpull.v1.XmlPullParser, java.lang.String):boolean");
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void f(float f2, float f3) {
        Iterator<g> it = this.f34810h.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str = next.f34828a;
            if (str != null && str.equals("down")) {
                next.a();
            }
        }
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f34812j;
        if (cVar != null) {
            cVar.a();
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f34811i;
        if (cVar2 != null) {
            cVar2.f(true);
        }
    }

    public void g() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.f34804b;
        if (aVar == null || this.f34805c == null || this.f34806d == null || this.f34807e == null) {
            return;
        }
        this.f34809g.set(aVar.b(), this.f34805c.b(), this.f34804b.b() + this.f34806d.b(), this.f34805c.b() + this.f34807e.b());
        com.zk_oaction.adengine.lk_view.f fVar = this.l;
        if (fVar != null) {
            this.f34809g.offset(fVar.K(), this.l.N());
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void h(float f2, float f3) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void j(float f2, float f3) {
        Iterator<g> it = this.f34810h.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str = next.f34828a;
            if (str != null && str.equals("up")) {
                next.a();
            }
        }
        com.zk_oaction.adengine.lk_unlock.c cVar = this.f34812j;
        if (cVar != null) {
            cVar.f(true);
        }
        com.zk_oaction.adengine.lk_unlock.c cVar2 = this.f34811i;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void k(float f2, float f3) {
    }
}
