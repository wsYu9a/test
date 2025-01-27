package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import n3.a;
import p3.i;
import x2.b;

/* loaded from: classes.dex */
public class APayEntranceActivity extends Activity {

    /* renamed from: e */
    public static final String f6478e = "ap_order_info";

    /* renamed from: f */
    public static final String f6479f = "ap_target_packagename";

    /* renamed from: g */
    public static final String f6480g = "ap_session";

    /* renamed from: h */
    public static final String f6481h = "ap_local_info";

    /* renamed from: i */
    public static final ConcurrentHashMap<String, a> f6482i = new ConcurrentHashMap<>();

    /* renamed from: b */
    public String f6483b;

    /* renamed from: c */
    public String f6484c;

    /* renamed from: d */
    public n3.a f6485d;

    public interface a {
        void a(String str);
    }

    @Override // android.app.Activity
    public void finish() {
        String str = this.f6484c;
        x2.a.d(this.f6485d, b.f31789l, "BSAFinish", str + "|" + TextUtils.isEmpty(this.f6483b));
        if (TextUtils.isEmpty(this.f6483b)) {
            this.f6483b = v2.b.a();
            n3.a aVar = this.f6485d;
            if (aVar != null) {
                aVar.l(true);
            }
        }
        if (str != null) {
            a remove = f6482i.remove(str);
            if (remove != null) {
                remove.a(this.f6483b);
            } else {
                x2.a.i(this.f6485d, "wr", "refNull", "session=" + str);
            }
        }
        try {
            super.finish();
        } catch (Throwable th2) {
            x2.a.e(this.f6485d, "wr", "APStartFinish", th2);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        x2.a.d(this.f6485d, b.f31789l, "BSAOnAR", this.f6484c + "|" + i10 + "," + i11);
        if (i10 == 1000) {
            if (intent != null) {
                try {
                    this.f6483b = intent.getStringExtra(i.f29758c);
                } catch (Throwable unused) {
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            String string = extras.getString(f6478e);
            String string2 = extras.getString(f6479f);
            this.f6484c = extras.getString(f6480g);
            String string3 = extras.getString(f6481h, "{}");
            if (!TextUtils.isEmpty(this.f6484c)) {
                n3.a b10 = a.C0746a.b(this.f6484c);
                this.f6485d = b10;
                x2.a.d(b10, b.f31789l, "BSAEntryCreate", this.f6484c + "|" + SystemClock.elapsedRealtime());
            }
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable th2) {
                x2.a.e(this.f6485d, "wr", "APStartEx", th2);
                finish();
            }
            if (this.f6485d != null) {
                Context applicationContext = getApplicationContext();
                n3.a aVar = this.f6485d;
                x2.a.b(applicationContext, aVar, string, aVar.f28764d);
                this.f6485d.g(true);
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
