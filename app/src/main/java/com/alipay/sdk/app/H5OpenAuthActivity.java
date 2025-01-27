package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import n3.a;
import x2.b;

/* loaded from: classes.dex */
public class H5OpenAuthActivity extends H5PayActivity {

    /* renamed from: j */
    public boolean f6492j = false;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.f6492j) {
            try {
                a a10 = a.C0746a.a(getIntent());
                if (a10 != null) {
                    x2.a.h(this, a10, "", a10.f28764d);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            a a10 = a.C0746a.a(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data == null || !data.toString().startsWith("alipays://platformapi/startapp")) {
                    return;
                }
                finish();
            } catch (Throwable th2) {
                String uri = (intent == null || intent.getData() == null) ? "null" : intent.getData().toString();
                if (a10 != null) {
                    x2.a.f(a10, b.f31789l, b.f31798p0, th2, uri);
                }
                this.f6492j = true;
                throw th2;
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
