package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.opos.cmn.biz.web.c.b.c;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private e f19408a;

    /* renamed from: b */
    private c f19409b;

    /* renamed from: c */
    private WebDataHepler f19410c;

    /* renamed from: d */
    private com.opos.mobad.activity.webview.a.b f19411d;

    /* renamed from: e */
    private Activity f19412e;

    /* renamed from: f */
    private com.opos.mobad.activity.webview.a.a f19413f;

    /* renamed from: g */
    private com.opos.mobad.cmn.a.d f19414g;

    /* renamed from: h */
    private com.opos.mobad.activity.webview.b.d f19415h;

    /* renamed from: i */
    private a f19416i;

    public interface a {
        void a();
    }

    public b(Activity activity, WebDataHepler webDataHepler) {
        this.f19412e = activity;
        this.f19410c = webDataHepler;
        c.a a2 = new c.a().b("ad_mob").a(true).a(webDataHepler.c());
        this.f19414g = com.opos.mobad.cmn.service.a.a().b();
        this.f19413f = new com.opos.mobad.activity.webview.a.a(activity);
        this.f19411d = com.opos.mobad.cmn.service.a.a().c().a(activity, a2.a(), this.f19413f);
    }

    private void a(com.opos.mobad.activity.webview.a.b bVar, com.opos.mobad.activity.webview.a.a aVar, com.opos.mobad.cmn.a.d dVar) {
        if (this.f19408a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mixad", bVar);
        c cVar = new c(this.f19412e, new d(hashMap, this.f19410c.g(), this.f19410c.i(), this.f19410c.j()));
        this.f19409b = cVar;
        e eVar = new e(this.f19412e, cVar);
        this.f19408a = eVar;
        com.opos.mobad.activity.webview.b.d dVar2 = this.f19415h;
        if (dVar2 != null) {
            eVar.a(dVar2);
        }
        a aVar2 = this.f19416i;
        if (aVar2 != null) {
            this.f19413f.a(aVar2);
            this.f19408a.a(this.f19416i);
        }
        aVar.a(this.f19408a, this.f19410c, dVar);
    }

    public void a() {
        com.opos.cmn.an.f.a.b("WebPresenter", "render");
        if (this.f19408a != null) {
            return;
        }
        a(this.f19411d, this.f19413f, this.f19414g);
        this.f19408a.a(this.f19410c);
    }

    public void a(a aVar) {
        this.f19416i = aVar;
        com.opos.mobad.activity.webview.a.a aVar2 = this.f19413f;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        e eVar = this.f19408a;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public void a(com.opos.mobad.activity.webview.b.d dVar) {
        this.f19415h = dVar;
        e eVar = this.f19408a;
        if (eVar != null) {
            eVar.a(dVar);
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        e eVar = this.f19408a;
        return eVar != null && eVar.a(i2, keyEvent);
    }

    public void b() {
        c cVar = this.f19409b;
        if (cVar == null) {
            return;
        }
        cVar.e();
    }

    public View c() {
        c cVar = this.f19409b;
        if (cVar == null) {
            return null;
        }
        return cVar.d();
    }

    public void d() {
        com.opos.mobad.activity.webview.a.b bVar = this.f19411d;
        if (bVar != null) {
            bVar.a();
        }
        e eVar = this.f19408a;
        if (eVar != null) {
            eVar.b();
        }
        com.opos.mobad.activity.webview.a.a aVar = this.f19413f;
        if (aVar != null) {
            aVar.e();
        }
    }
}
