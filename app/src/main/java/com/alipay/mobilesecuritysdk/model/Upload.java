package com.alipay.mobilesecuritysdk.model;

import android.content.Context;
import android.util.Log;
import com.alipay.mobilesecuritysdk.a.d;
import com.alipay.mobilesecuritysdk.a.e;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

/* loaded from: classes.dex */
public class Upload {

    /* renamed from: a */
    private Context f5267a;

    /* renamed from: b */
    private b f5268b = new b();

    /* renamed from: c */
    private e f5269c;

    public Upload(Context context) {
        this.f5267a = context;
    }

    public com.alipay.mobilesecuritysdk.a.b a() {
        HttpResponse execute;
        com.alipay.mobilesecuritysdk.a.b bVar = new com.alipay.mobilesecuritysdk.a.b();
        if (!com.alipay.mobilesecuritysdk.c.a.k(this.f5267a)) {
            return bVar;
        }
        try {
            execute = new a.a().a().execute(new HttpGet(com.alipay.mobilesecuritysdk.constant.a.B));
        } catch (Exception unused) {
            bVar.l(false);
        }
        if (execute.getStatusLine().getStatusCode() == 200) {
            return this.f5268b.g(EntityUtils.toString(execute.getEntity()));
        }
        bVar.l(false);
        return bVar;
    }

    public e b() {
        return this.f5269c;
    }

    public void c(e eVar) {
        this.f5269c = eVar;
    }

    public com.alipay.mobilesecuritysdk.a.b d(String str, String str2, String str3) {
        HttpResponse c2;
        com.alipay.mobilesecuritysdk.a.b bVar = new com.alipay.mobilesecuritysdk.a.b();
        try {
            c2 = new a.a().c(this.f5267a, com.alipay.mobilesecuritysdk.constant.a.C, str, str2, str3, true);
        } catch (IOException e2) {
            Log.i("upload data  error", e2.getLocalizedMessage());
        }
        if (c2 != null && c2.getStatusLine().getStatusCode() == 200) {
            return this.f5268b.g(EntityUtils.toString(c2.getEntity()));
        }
        bVar.l(false);
        return bVar;
    }

    public com.alipay.mobilesecuritysdk.a.b e(List<String> list, d dVar) {
        com.alipay.mobilesecuritysdk.a.b bVar = new com.alipay.mobilesecuritysdk.a.b();
        if (com.alipay.mobilesecuritysdk.c.a.j(list)) {
            bVar.l(false);
            return bVar;
        }
        if (this.f5269c.a().size() > 0) {
            this.f5268b.l(list);
            b bVar2 = this.f5268b;
            StringBuilder sb = new StringBuilder(String.valueOf(this.f5267a.getFilesDir().getPath()));
            String str = File.separator;
            sb.append(str);
            sb.append(com.alipay.mobilesecuritysdk.constant.a.o);
            String a2 = bVar2.a(sb.toString(), this.f5269c.a());
            if (com.alipay.mobilesecuritysdk.b.a.c()) {
                Log.i("str app info", a2);
            }
            if (a2 != null && a2.length() > 0) {
                bVar = d(com.alipay.mobilesecuritysdk.constant.a.N, a2, "1");
            }
            if (bVar.f()) {
                this.f5268b.h(String.valueOf(this.f5267a.getFilesDir().getPath()) + str + com.alipay.mobilesecuritysdk.constant.a.o);
                Log.i("app write file", "upload  suceess  delete file");
            } else {
                try {
                    com.alipay.mobilesecuritysdk.c.a.f(String.valueOf(this.f5267a.getFilesDir().getPath()) + str + com.alipay.mobilesecuritysdk.constant.a.o, a2);
                } catch (IOException e2) {
                    Log.d("app write file", e2.getLocalizedMessage());
                }
            }
        }
        if (this.f5269c.b().size() > 0) {
            this.f5268b.l(list);
            b bVar3 = this.f5268b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(this.f5267a.getFilesDir().getPath()));
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(com.alipay.mobilesecuritysdk.constant.a.m);
            String f2 = bVar3.f(sb2.toString(), this.f5269c.b());
            if (com.alipay.mobilesecuritysdk.b.a.c()) {
                Log.i("str aloc info", f2);
            }
            if (f2 != null && f2.length() > 0) {
                bVar = d(com.alipay.mobilesecuritysdk.constant.a.N, f2, "1");
            }
            if (bVar.f()) {
                this.f5268b.h(String.valueOf(this.f5267a.getFilesDir().getPath()) + str2 + com.alipay.mobilesecuritysdk.constant.a.m);
                Log.i("location write file", "upload  suceess  delete file");
            } else {
                try {
                    com.alipay.mobilesecuritysdk.c.a.f(String.valueOf(this.f5267a.getFilesDir().getPath()) + str2 + com.alipay.mobilesecuritysdk.constant.a.m, f2);
                } catch (IOException e3) {
                    Log.d("location write file", e3.getLocalizedMessage());
                }
            }
        }
        return bVar;
    }
}
