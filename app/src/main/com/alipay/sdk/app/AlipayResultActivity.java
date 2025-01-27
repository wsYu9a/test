package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bz;
import com.umeng.analytics.pro.f;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import n3.a;
import org.json.JSONObject;
import p3.i;
import x2.b;

/* loaded from: classes.dex */
public class AlipayResultActivity extends Activity {

    /* renamed from: b */
    public static final ConcurrentHashMap<String, a> f6486b = new ConcurrentHashMap<>();

    public interface a {
        void a(int i10, String str, String str2);
    }

    public final void a(String str, Bundle bundle) {
        a remove = f6486b.remove(str);
        if (remove == null) {
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString(i.f29757b), bundle.getString(i.f29758c));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Throwable th2;
        JSONObject jSONObject;
        Bundle bundle2;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            try {
                String stringExtra = intent.getStringExtra(f.aC);
                Bundle bundleExtra = intent.getBundleExtra(i.f29758c);
                String stringExtra2 = intent.getStringExtra(com.umeng.ccg.a.f24233j);
                n3.a b10 = a.C0746a.b(stringExtra);
                if (b10 == null) {
                    finish();
                    return;
                }
                x2.a.d(b10, b.f31789l, "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        jSONObject = jSONObject2.getJSONObject(i.f29758c);
                        stringExtra = jSONObject2.getString(f.aC);
                        x2.a.d(b10, b.f31789l, "BSPUriSession", stringExtra);
                        bundle2 = new Bundle();
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                    try {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            bundle2.putString(next, jSONObject.getString(next));
                        }
                        bundleExtra = bundle2;
                    } catch (Throwable th4) {
                        th2 = th4;
                        bundleExtra = bundle2;
                        x2.a.e(b10, b.f31789l, "BSPResEx", th2);
                        x2.a.e(b10, b.f31789l, b.f31804s0, th2);
                        if (TextUtils.isEmpty(stringExtra)) {
                        }
                        x2.a.h(this, b10, "", b10.f28764d);
                        finish();
                        return;
                    }
                }
                if (!TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    x2.a.h(this, b10, "", b10.f28764d);
                    finish();
                    return;
                }
                try {
                    x2.a.d(b10, b.f31789l, b.V, "" + SystemClock.elapsedRealtime());
                    x2.a.d(b10, b.f31789l, b.W, bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString(i.f29757b, "-"));
                    OpenAuthTask.d(stringExtra, 9000, bz.f6993k, bundleExtra);
                    x2.a.h(this, b10, "", b10.f28764d);
                    finish();
                } catch (Throwable th5) {
                    x2.a.h(this, b10, "", b10.f28764d);
                    finish();
                    throw th5;
                }
            } catch (Throwable th6) {
                x2.a.e(null, b.f31789l, "BSPSerError", th6);
                x2.a.e(null, b.f31789l, b.f31802r0, th6);
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
