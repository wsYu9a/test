package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import n3.a;
import p3.d;

/* loaded from: classes.dex */
public final class PayResultActivity extends Activity {

    /* renamed from: c */
    public static final String f6517c = "{\"isLogin\":\"false\"}";

    /* renamed from: d */
    public static final HashMap<String, Object> f6518d = new HashMap<>();

    /* renamed from: e */
    public static final String f6519e = "hk.alipay.wallet";

    /* renamed from: f */
    public static final String f6520f = "phonecashier.pay.hash";

    /* renamed from: g */
    public static final String f6521g = "orderSuffix";

    /* renamed from: h */
    public static final String f6522h = "externalPkgName";

    /* renamed from: i */
    public static final String f6523i = "phonecashier.pay.result";

    /* renamed from: j */
    public static final String f6524j = "phonecashier.pay.resultOrderHash";

    /* renamed from: b */
    public n3.a f6525b = null;

    public static class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Activity f6526b;

        public a(Activity activity) {
            this.f6526b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6526b.finish();
        }
    }

    public static final class b {

        /* renamed from: a */
        public static volatile String f6527a;

        /* renamed from: b */
        public static volatile String f6528b;
    }

    public static void a(Activity activity, int i10) {
        new Handler().postDelayed(new a(activity), i10);
    }

    public static void b(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage("hk.alipay.wallet");
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e10) {
            d.e(e10);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    public static void c(String str) {
        b.f6528b = v2.b.a();
        e(f6518d, str);
    }

    public static void d(String str, String str2) {
        b.f6528b = str;
        e(f6518d, str2);
    }

    public static boolean e(HashMap<String, Object> hashMap, String str) {
        Object obj;
        if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra(f6521g))) {
                b.f6527a = intent.getStringExtra(f6520f);
                String stringExtra = intent.getStringExtra(f6521g);
                String stringExtra2 = intent.getStringExtra(f6522h);
                n3.a a10 = a.C0746a.a(intent);
                this.f6525b = a10;
                if (a10 == null) {
                    finish();
                }
                b(this, b.f6527a, stringExtra, stringExtra2);
                a(this, 300);
                return;
            }
            if (this.f6525b == null) {
                finish();
            }
            String stringExtra3 = intent.getStringExtra(f6523i);
            int intExtra = intent.getIntExtra(f6524j, 0);
            if (intExtra != 0 && TextUtils.equals(b.f6527a, String.valueOf(intExtra))) {
                if (TextUtils.isEmpty(stringExtra3)) {
                    c(b.f6527a);
                } else {
                    d(stringExtra3, b.f6527a);
                }
                b.f6527a = "";
                a(this, 300);
                return;
            }
            x2.a.i(this.f6525b, x2.b.f31789l, x2.b.f31790l0, "Expected " + b.f6527a + ", got " + intExtra);
            c(b.f6527a);
            a(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }
}
