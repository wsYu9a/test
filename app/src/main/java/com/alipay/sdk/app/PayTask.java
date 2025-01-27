package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class PayTask {

    /* renamed from: a */
    static final Object f5282a = com.alipay.sdk.util.g.class;

    /* renamed from: b */
    private Activity f5283b;

    /* renamed from: c */
    private String f5284c;

    /* renamed from: d */
    private boolean f5285d;

    public PayTask(Activity activity) {
        this.f5283b = activity;
    }

    private String a() {
        StringBuilder sb;
        String str;
        String sb2;
        com.alipay.sdk.util.g gVar = new com.alipay.sdk.util.g(this.f5283b);
        if (this.f5284c.contains("bizcontext=")) {
            sb2 = this.f5284c;
        } else {
            if (this.f5284c.contains("\"")) {
                sb = new StringBuilder();
                sb.append(this.f5284c);
                str = b.b.a.b.a.q;
            } else {
                sb = new StringBuilder();
                sb.append(this.f5284c);
                str = b.b.a.b.a.r;
            }
            sb.append(str);
            sb2 = sb.toString();
        }
        return gVar.c(sb2);
    }

    private String b(com.alipay.sdk.protocol.a aVar) {
        String[] a2 = com.alipay.sdk.util.a.a(aVar.e());
        Intent intent = new Intent(this.f5283b, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", a2[0]);
        if (a2.length == 2) {
            bundle.putString("cookie", a2[1]);
        }
        intent.putExtras(bundle);
        this.f5283b.startActivity(intent);
        Object obj = f5282a;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
            }
        }
        String str = d.f5308a;
        return TextUtils.isEmpty(str) ? d.a() : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d2, code lost:
    
        if (r1 == null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00eb, code lost:
    
        if (r0 != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ed, code lost:
    
        r0 = com.alipay.sdk.app.ac.a(com.alipay.sdk.app.ac.FAILED.a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0105, code lost:
    
        return com.alipay.sdk.app.d.b(r0.a(), r0.b(), "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00da, code lost:
    
        r1.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e8, code lost:
    
        if (r1 == null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d8, code lost:
    
        if (r1 == null) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004e A[Catch: all -> 0x00d5, Exception -> 0x00d7, NetErrorException -> 0x00de, TryCatch #5 {NetErrorException -> 0x00de, Exception -> 0x00d7, blocks: (B:10:0x0031, B:12:0x004e, B:14:0x0054, B:16:0x0060, B:18:0x006a, B:20:0x007d, B:25:0x0087, B:28:0x00ab, B:33:0x00b0, B:34:0x00b3, B:24:0x00b4, B:42:0x00b9, B:43:0x00bc, B:45:0x00bf, B:49:0x00c5), top: B:9:0x0031, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9 A[Catch: all -> 0x00d5, Exception -> 0x00d7, NetErrorException -> 0x00de, TryCatch #5 {NetErrorException -> 0x00de, Exception -> 0x00d7, blocks: (B:10:0x0031, B:12:0x004e, B:14:0x0054, B:16:0x0060, B:18:0x006a, B:20:0x007d, B:25:0x0087, B:28:0x00ab, B:33:0x00b0, B:34:0x00b3, B:24:0x00b4, B:42:0x00b9, B:43:0x00bc, B:45:0x00bf, B:49:0x00c5), top: B:9:0x0031, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bf A[Catch: all -> 0x00d5, Exception -> 0x00d7, NetErrorException -> 0x00de, TryCatch #5 {NetErrorException -> 0x00de, Exception -> 0x00d7, blocks: (B:10:0x0031, B:12:0x004e, B:14:0x0054, B:16:0x0060, B:18:0x006a, B:20:0x007d, B:25:0x0087, B:28:0x00ab, B:33:0x00b0, B:34:0x00b3, B:24:0x00b4, B:42:0x00b9, B:43:0x00bc, B:45:0x00bf, B:49:0x00c5), top: B:9:0x0031, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.c():java.lang.String");
    }

    public boolean checkAccountIfExist() {
        try {
            return new b.b.a.e.d().a(this.f5283b, b.b.a.c.b.a(), true).f5419c.optBoolean("hasAccount", false);
        } catch (Exception unused) {
            return false;
        }
    }

    public String getVersion() {
        return b.b.a.b.a.f4193f;
    }

    public synchronized String pay(String str) {
        String str2;
        this.f5284c = str;
        b.b.a.f.a.a().c(this.f5283b, b.b.a.c.d.a());
        if (str.contains("paymethod=\"expressGateway\"")) {
            return c();
        }
        if (!com.alipay.sdk.util.j.h(this.f5283b)) {
            return c();
        }
        if (this.f5283b.getRequestedOrientation() == 0 || this.f5283b.getRequestedOrientation() == 6 || this.f5283b.getRequestedOrientation() == 8) {
            this.f5283b.setRequestedOrientation(1);
            this.f5285d = true;
        }
        com.alipay.sdk.util.g gVar = new com.alipay.sdk.util.g(this.f5283b);
        if (this.f5284c.contains("bizcontext=")) {
            str2 = this.f5284c;
        } else if (this.f5284c.contains("\"")) {
            str2 = this.f5284c + b.b.a.b.a.q;
        } else {
            str2 = this.f5284c + b.b.a.b.a.r;
        }
        String c2 = gVar.c(str2);
        if (TextUtils.equals(c2, com.alipay.sdk.util.g.f5460a)) {
            if (this.f5285d) {
                this.f5283b.setRequestedOrientation(0);
                this.f5285d = false;
            }
            return c();
        }
        if (TextUtils.isEmpty(c2)) {
            return d.a();
        }
        if (this.f5285d) {
            this.f5283b.setRequestedOrientation(0);
            this.f5285d = false;
        }
        return c2;
    }
}
