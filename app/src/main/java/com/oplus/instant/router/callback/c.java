package com.oplus.instant.router.callback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.oplus.instant.router.callback.Callback;
import com.oplus.instant.router.h.d;

/* loaded from: classes4.dex */
public class c extends Callback {

    /* renamed from: a */
    private Context f16054a;

    /* renamed from: b */
    private String f16055b;

    /* renamed from: c */
    private Callback f16056c;

    public c(Context context, String str, Callback callback) {
        this.f16054a = context;
        this.f16055b = str;
        this.f16056c = callback;
    }

    private String a(String str) {
        return str.replace("hap://app/", "hap://on_stack/");
    }

    @Override // com.oplus.instant.router.callback.Callback
    public void onResponse(Callback.Response response) {
        String str;
        StringBuilder sb;
        if (this.f16056c == null) {
            return;
        }
        if (this.f16054a instanceof Activity) {
            if (response.f16051a == 1) {
                Intent intent = new Intent("android.intent.action.instant.on_stack", Uri.parse(a(this.f16055b)));
                intent.putExtra("in_one_task", "1");
                if (intent.resolveActivity(this.f16054a.getPackageManager()) != null) {
                    sb = new StringBuilder();
                } else {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f16055b));
                    if (intent.resolveActivity(this.f16054a.getPackageManager()) != null) {
                        sb = new StringBuilder();
                    } else {
                        response.f16051a = 200;
                        str = "QuickApp is not support";
                    }
                }
                sb.append("req_uri: ");
                sb.append(intent.getDataString());
                d.b("OneTaskCallback", sb.toString());
                this.f16054a.startActivity(intent);
            }
            this.f16056c.onResponse(response);
        }
        response.f16051a = 200;
        str = "context is not activity";
        response.f16052b = str;
        this.f16056c.onResponse(response);
    }
}
