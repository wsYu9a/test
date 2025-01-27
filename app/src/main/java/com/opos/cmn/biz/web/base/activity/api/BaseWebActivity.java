package com.opos.cmn.biz.web.base.activity.api;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.cmn.biz.web.b.a.a;
import com.opos.cmn.biz.web.b.a.a.b;
import com.opos.cmn.biz.web.b.a.b;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class BaseWebActivity extends Activity implements b {

    /* renamed from: a */
    private a f16894a;

    /* renamed from: b */
    private String f16895b;

    /* renamed from: c */
    private boolean f16896c = false;

    /* renamed from: d */
    private ViewGroup f16897d;

    private void b(Intent intent) {
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("loadUrl");
                this.f16895b = stringExtra;
                if (TextUtils.isEmpty(stringExtra)) {
                    e();
                } else {
                    b();
                    d();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("AdActivity", "handleAction", e2);
                e();
            }
        }
    }

    private void d() {
        try {
            com.opos.cmn.an.f.a.b("AdActivity", "showWebView url:" + this.f16895b);
            if (com.opos.cmn.an.c.a.a(this.f16895b)) {
                return;
            }
            this.f16897d = (ViewGroup) getWindow().getDecorView().findViewById(R.id.content);
            if (this.f16894a.b() != null && this.f16894a.b().getParent() == null) {
                this.f16897d.addView(this.f16894a.b(), new RelativeLayout.LayoutParams(-1, -1));
            }
            this.f16894a.a(this.f16895b);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("AdActivity", "showWebView", e2);
        }
    }

    private void e() {
        finish();
    }

    protected abstract Map<String, Object> a();

    public void a(Intent intent) {
        com.opos.cmn.an.f.a.b("AdActivity", "reInitWebView");
        a aVar = this.f16894a;
        if (aVar != null) {
            aVar.e();
            b(intent);
        }
    }

    public void b() {
        if (this.f16896c) {
            return;
        }
        try {
            com.opos.cmn.biz.web.base.activity.a.a.a.a(this);
            com.opos.cmn.biz.web.base.activity.a.a.a.b(this);
            this.f16894a = new a(this, new b.a().a(this).a(a()).a(true).a());
            this.f16896c = true;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("AdActivity", "initWebView", e2);
        }
    }

    @Override // com.opos.cmn.biz.web.b.a.a.b
    public void c() {
        com.opos.cmn.an.f.a.b("AdActivity", "onWebViewClose");
        e();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b("AdActivity", "onCreate");
        b(getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.opos.cmn.an.f.a.b("AdActivity", "onDestroy");
        com.opos.cmn.an.f.a.b("AdActivity", "closeWebWidget");
        a aVar = this.f16894a;
        if (aVar != null && aVar.b() != null) {
            this.f16897d.removeView(this.f16894a.b());
        }
        a aVar2 = this.f16894a;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.f16894a = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        a aVar;
        com.opos.cmn.an.f.a.b("AdActivity", "onKeyDown");
        if (i2 != 4 || keyEvent.getAction() != 0 || (aVar = this.f16894a) == null) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (aVar.c() || !this.f16894a.d()) {
            c();
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
        com.opos.cmn.an.f.a.b("AdActivity", "onResume");
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
