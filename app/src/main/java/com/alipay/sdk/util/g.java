package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import java.util.Iterator;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    public static final String f5460a = "failed";

    /* renamed from: b */
    private Activity f5461b;

    /* renamed from: c */
    private IAlixPay f5462c;

    /* renamed from: d */
    private Object f5463d = IAlixPay.class;

    /* renamed from: e */
    private boolean f5464e = false;

    /* renamed from: f */
    private ServiceConnection f5465f = new h(this);

    /* renamed from: g */
    private IRemoteServiceCallback f5466g = new i(this);

    public g(Activity activity) {
        this.f5461b = activity;
    }

    private String d(String str, Intent intent) {
        IAlixPay iAlixPay;
        if (this.f5464e) {
            return "";
        }
        this.f5464e = true;
        if (this.f5462c == null) {
            this.f5461b.getApplicationContext().bindService(intent, this.f5465f, 1);
        }
        try {
            try {
                try {
                    synchronized (this.f5463d) {
                        if (this.f5462c == null) {
                            this.f5463d.wait(3000L);
                        }
                    }
                    iAlixPay = this.f5462c;
                } finally {
                    try {
                        this.f5461b.unbindService(this.f5465f);
                    } catch (Exception unused) {
                        this.f5462c = null;
                    }
                    this.f5464e = false;
                }
            } catch (Exception unused2) {
                str = null;
            }
        } catch (Exception unused3) {
            this.f5462c = null;
        }
        if (iAlixPay == null) {
            return f5460a;
        }
        iAlixPay.registerCallback(this.f5466g);
        str = this.f5462c.Pay(str);
        try {
            this.f5462c.unregisterCallback(this.f5466g);
            this.f5462c = null;
            this.f5461b.unbindService(this.f5465f);
        } catch (Exception unused4) {
            this.f5461b.unbindService(this.f5465f);
            this.f5464e = false;
            return str;
        }
        this.f5464e = false;
        return str;
    }

    public final String c(String str) {
        byte[] bArr;
        Iterator<PackageInfo> it = this.f5461b.getPackageManager().getInstalledPackages(64).iterator();
        while (true) {
            if (!it.hasNext()) {
                bArr = null;
                break;
            }
            PackageInfo next = it.next();
            if (next.packageName.equals("com.eg.android.AlipayGphone")) {
                bArr = next.signatures[0].toByteArray();
                break;
            }
        }
        String c2 = j.c(bArr);
        if (c2 != null && !TextUtils.equals(c2, b.b.a.b.a.f4194g)) {
            return com.alipay.sdk.app.d.d();
        }
        Intent intent = new Intent();
        intent.setClassName("com.eg.android.AlipayGphone", "com.alipay.android.app.MspService");
        intent.setAction("com.eg.android.AlipayGphone.IAlixPay");
        return d(str, intent);
    }
}
