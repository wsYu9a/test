package com.opos.cmn.an.transactivity.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes4.dex */
public class TransActivity extends Activity {

    /* renamed from: a */
    private com.opos.cmn.an.transactivity.a.a f16611a = null;

    private void a() {
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b("TransActivity", "onCreate");
        try {
            Intent intent = getIntent();
            if (intent != null) {
                com.opos.cmn.an.transactivity.a.a aVar = (com.opos.cmn.an.transactivity.a.a) intent.getSerializableExtra("extra_key_trans_life_callback");
                this.f16611a = aVar;
                if (aVar != null) {
                    aVar.a(this, bundle);
                }
            }
            com.opos.cmn.an.f.a.b("TransActivity", "onCreate ITransLifeCallback cannot be null");
            a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("TransActivity", "onCreate", e2);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.opos.cmn.an.f.a.b("TransActivity", "onDestroy");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f16611a;
            if (aVar != null) {
                aVar.f(this);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("TransActivity", "onDestroy", e2);
        }
        this.f16611a = null;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.b("TransActivity", "onNewIntent");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f16611a;
            if (aVar != null) {
                aVar.a(this, intent);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("TransActivity", "onNewIntent", e2);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.b("TransActivity", "onPause");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f16611a;
            if (aVar != null) {
                aVar.d(this);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("TransActivity", "onPause", e2);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.opos.cmn.an.f.a.b("TransActivity", "onRestart");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f16611a;
            if (aVar != null) {
                aVar.b(this);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("TransActivity", "onRestart", e2);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.opos.cmn.an.f.a.b("TransActivity", "onResume");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f16611a;
            if (aVar != null) {
                aVar.c(this);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("TransActivity", "onResume", e2);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.opos.cmn.an.f.a.b("TransActivity", "onStart");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f16611a;
            if (aVar != null) {
                aVar.a(this);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("TransActivity", "onStart", e2);
            a();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.opos.cmn.an.f.a.b("TransActivity", "onStop");
        try {
            com.opos.cmn.an.transactivity.a.a aVar = this.f16611a;
            if (aVar != null) {
                aVar.e(this);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("TransActivity", "onStop", e2);
            a();
        }
    }
}
