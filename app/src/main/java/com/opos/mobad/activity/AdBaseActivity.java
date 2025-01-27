package com.opos.mobad.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.activity.webview.b.e;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.cmn.b.f;

/* loaded from: classes4.dex */
public abstract class AdBaseActivity extends Activity {

    /* renamed from: a */
    private b f19368a;

    /* renamed from: b */
    private f f19369b;

    /* renamed from: com.opos.mobad.activity.AdBaseActivity$1 */
    class AnonymousClass1 implements b.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.activity.webview.b.a
        public void a() {
            AdBaseActivity.this.a();
        }
    }

    public void a() {
        finish();
    }

    private void a(WebDataHepler webDataHepler) {
        f fVar = new f(webDataHepler.f());
        this.f19369b = fVar;
        fVar.a(this, webDataHepler.g(), webDataHepler.h());
    }

    private void a(d dVar, WebDataHepler webDataHepler) {
        try {
            if (TextUtils.isEmpty(webDataHepler.d())) {
                com.opos.cmn.an.f.a.b("AdActivity", "data is null " + webDataHepler);
                a();
                return;
            }
            b bVar = this.f19368a;
            if (bVar != null) {
                bVar.d();
            }
            e.a aVar = webDataHepler.f() != null ? new e.a(webDataHepler.f()) : null;
            b bVar2 = new b(this, webDataHepler);
            this.f19368a = bVar2;
            bVar2.a();
            this.f19368a.a(aVar);
            this.f19368a.a(new b.a() { // from class: com.opos.mobad.activity.AdBaseActivity.1
                AnonymousClass1() {
                }

                @Override // com.opos.mobad.activity.webview.b.a
                public void a() {
                    AdBaseActivity.this.a();
                }
            });
            setContentView(this.f19368a.c());
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdActivity", "initWebView", (Throwable) e2);
        }
    }

    private void b(Intent intent) {
        d b2 = com.opos.mobad.cmn.service.a.a().b();
        if (b2 == null) {
            a();
            com.opos.cmn.an.f.a.b("AdActivity", "handle but not init");
            return;
        }
        if (intent != null) {
            try {
                WebDataHepler webDataHepler = (WebDataHepler) intent.getParcelableExtra("webData");
                if (webDataHepler == null) {
                    com.opos.cmn.an.f.a.b("AdActivity", "data is null " + webDataHepler);
                    a();
                    return;
                }
                int g2 = webDataHepler.g();
                if (g2 == 1 || g2 == 2) {
                    g.a((Activity) this, "#F5EEEEEE");
                    a(b2, webDataHepler);
                } else if (g2 == 3 || g2 == 4) {
                    a(webDataHepler);
                } else {
                    a();
                }
                com.opos.cmn.an.f.a.a("AdActivity", webDataHepler);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdActivity", "handleAction", (Throwable) e2);
                a();
            }
        }
    }

    public void a(Intent intent) {
        com.opos.cmn.an.f.a.b("AdActivity", "reInitWebView");
        b bVar = this.f19368a;
        if (bVar != null) {
            bVar.d();
        }
        b(intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.opos.cmn.an.f.a.b("AdActivity", "onConfigurationChanged newConfig=" + configuration.toString());
        b bVar = this.f19368a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        g.a(this);
        com.opos.cmn.i.g.a((Activity) this);
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b("AdActivity", "onCreate");
        b(getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.opos.cmn.an.f.a.b("AdActivity", "onDestroy");
        b bVar = this.f19368a;
        if (bVar != null) {
            bVar.d();
        }
        f fVar = this.f19369b;
        if (fVar != null) {
            fVar.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        f fVar;
        com.opos.cmn.an.f.a.b("AdActivity", "onKeyDown");
        b bVar = this.f19368a;
        if ((bVar == null || !bVar.a(i2, keyEvent)) && ((fVar = this.f19369b) == null || !fVar.a(i2, keyEvent))) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.b("AdActivity", "onNewIntent");
        setIntent(intent);
        a(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.b("AdActivity", "onPause");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.opos.cmn.an.f.a.b("AdActivity", "onStart");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.opos.cmn.an.f.a.b("AdActivity", "onStop");
    }
}
