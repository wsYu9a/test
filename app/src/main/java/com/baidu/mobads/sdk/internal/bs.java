package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bw;
import com.baidu.mobads.sdk.internal.cf;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* loaded from: classes.dex */
public class bs extends Thread {

    /* renamed from: b */
    private static final String f5648b = "ApkDownloadThread";

    /* renamed from: c */
    private static final int f5649c = 900000;

    /* renamed from: h */
    private static volatile bs f5650h;

    /* renamed from: d */
    private volatile String f5652d;

    /* renamed from: e */
    private String f5653e;

    /* renamed from: f */
    private double f5654f;

    /* renamed from: g */
    private Handler f5655g;

    /* renamed from: i */
    private final Context f5656i;
    private final bu k;

    /* renamed from: j */
    private cf f5657j = null;
    private bq l = bq.a();

    /* renamed from: a */
    cf.a f5651a = new bt(this);

    private bs(Context context, bu buVar, String str, Handler handler) {
        this.f5653e = null;
        this.f5656i = context;
        this.k = buVar;
        a(buVar.c());
        this.f5655g = handler;
        this.f5653e = str;
    }

    private boolean b() {
        try {
            try {
                this.f5657j = new cf(this.f5656i, new URL(this.f5652d), this.k, this.f5651a);
            } catch (MalformedURLException unused) {
                this.f5657j = new cf(this.f5656i, this.f5652d, this.k, this.f5651a);
            }
            double d2 = bw.q != null ? bw.q.f5609b : bw.p != null ? bw.p.f5609b > 0.0d ? bw.p.f5609b : bw.p.f5609b : 0.0d;
            this.l.a(f5648b, "isNewApkAvailable: local apk version is: " + d2 + ", remote apk version: " + this.k.b());
            if (d2 > 0.0d) {
                if (this.k.b() <= 0.0d) {
                    this.l.a(f5648b, "remote is null, local apk version is null, do not upgrade");
                    return false;
                }
                this.l.a(f5648b, "remote not null, local apk version is null, force upgrade");
                this.f5654f = this.k.b();
                return true;
            }
            if (this.k.b() > 0.0d) {
                if (this.k.b() <= d2) {
                    return false;
                }
                this.f5654f = this.k.b();
                return true;
            }
            this.l.a(f5648b, "remote apk version is: null, local apk version is: " + d2 + ", do not upgrade");
            return false;
        } catch (Exception e2) {
            String str = "parse apk failed, error:" + e2.toString();
            this.l.a(f5648b, str);
            throw new bw.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.l.a(f5648b, "download apk successfully, downloader exit");
                    f5650h = null;
                } catch (IOException e2) {
                    this.l.a(f5648b, "create File or HTTP Get failed, exception: " + e2.getMessage());
                }
                this.l.a(f5648b, "no newer apk, downloader exit");
                f5650h = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static bs a(Context context, bu buVar, String str, Handler handler) {
        if (f5650h == null) {
            f5650h = new bs(context, buVar, str, handler);
        }
        return f5650h;
    }

    public void a(String str) {
        this.f5652d = str;
        interrupt();
    }

    public void a(String str, bu buVar, String str2) {
        if (str.equals(bw.k) || str.equals(bw.l)) {
            Message obtainMessage = this.f5655g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(bw.m, buVar);
            bundle.putString(bw.n, str);
            obtainMessage.setData(bundle);
            this.f5655g.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f5653e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f5657j.a(this.f5653e, str);
            return str2;
        } catch (IOException e2) {
            file.delete();
            throw e2;
        }
    }
}
