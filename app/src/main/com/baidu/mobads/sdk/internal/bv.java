package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bz;
import com.baidu.mobads.sdk.internal.ci;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* loaded from: classes2.dex */
public class bv extends Thread {

    /* renamed from: b */
    private static final String f6961b = "ApkDownloadThread";

    /* renamed from: c */
    private static final int f6962c = 900000;

    /* renamed from: h */
    private static volatile bv f6963h;

    /* renamed from: d */
    private volatile String f6965d;

    /* renamed from: e */
    private String f6966e;

    /* renamed from: f */
    private double f6967f;

    /* renamed from: g */
    private Handler f6968g;

    /* renamed from: i */
    private final Context f6969i;

    /* renamed from: k */
    private final bx f6971k;

    /* renamed from: j */
    private ci f6970j = null;

    /* renamed from: l */
    private bt f6972l = bt.a();

    /* renamed from: a */
    ci.a f6964a = new bw(this);

    private bv(Context context, bx bxVar, String str, Handler handler) {
        this.f6966e = null;
        this.f6969i = context;
        this.f6971k = bxVar;
        a(bxVar.c());
        this.f6968g = handler;
        this.f6966e = str;
    }

    private boolean b() {
        try {
            try {
                this.f6970j = new ci(this.f6969i, new URL(this.f6965d), this.f6971k, this.f6964a);
            } catch (MalformedURLException unused) {
                this.f6970j = new ci(this.f6969i, this.f6965d, this.f6971k, this.f6964a);
            }
            double d10 = bz.f6999q != null ? bz.f6999q.f6920b : bz.f6998p != null ? bz.f6998p.f6920b > l5.c.f27899e ? bz.f6998p.f6920b : bz.f6998p.f6920b : 0.0d;
            this.f6972l.a(f6961b, "isNewApkAvailable: local apk version is: " + d10 + ", remote apk version: " + this.f6971k.b());
            if (d10 > l5.c.f27899e) {
                if (this.f6971k.b() <= l5.c.f27899e) {
                    this.f6972l.a(f6961b, "remote is null, local apk version is null, do not upgrade");
                    return false;
                }
                this.f6972l.a(f6961b, "remote not null, local apk version is null, force upgrade");
                this.f6967f = this.f6971k.b();
                return true;
            }
            if (this.f6971k.b() > l5.c.f27899e) {
                if (this.f6971k.b() <= d10) {
                    return false;
                }
                this.f6967f = this.f6971k.b();
                return true;
            }
            this.f6972l.a(f6961b, "remote apk version is: null, local apk version is: " + d10 + ", do not upgrade");
            return false;
        } catch (Exception e10) {
            String str = "parse apk failed, error:" + e10.toString();
            this.f6972l.a(f6961b, str);
            throw new bz.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.f6972l.a(f6961b, "download apk successfully, downloader exit");
                    f6963h = null;
                } catch (IOException e10) {
                    this.f6972l.a(f6961b, "create File or HTTP Get failed, exception: " + e10.getMessage());
                }
                this.f6972l.a(f6961b, "no newer apk, downloader exit");
                f6963h = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static bv a(Context context, bx bxVar, String str, Handler handler) {
        if (f6963h == null) {
            f6963h = new bv(context, bxVar, str, handler);
        }
        return f6963h;
    }

    public void a(String str) {
        this.f6965d = str;
        interrupt();
    }

    public void a(String str, bx bxVar, String str2) {
        if (str.equals(bz.f6993k) || str.equals(bz.f6994l)) {
            Message obtainMessage = this.f6968g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(bz.f6995m, bxVar);
            bundle.putString(bz.f6996n, str);
            obtainMessage.setData(bundle);
            this.f6968g.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f6966e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f6970j.a(this.f6966e, str);
            return str2;
        } catch (IOException e10) {
            file.delete();
            throw e10;
        }
    }
}
