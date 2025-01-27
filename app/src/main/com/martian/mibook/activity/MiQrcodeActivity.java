package com.martian.mibook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.martian.libzxing.QrcodeActivity;
import ea.b;
import ea.c;

/* loaded from: classes3.dex */
public class MiQrcodeActivity extends QrcodeActivity {

    public class a implements b {
        public a() {
        }

        @Override // ea.b
        public void permissionDenied() {
        }

        @Override // ea.b
        public void permissionGranted() {
            MiQrcodeActivity.super.d();
        }
    }

    public static void g(Activity activity, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(QrcodeActivity.f13070e, str2);
        bundle.putString(QrcodeActivity.f13071f, str);
        Intent intent = new Intent(activity, (Class<?>) MiQrcodeActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // com.martian.libzxing.QrcodeActivity
    public void d() {
        c.m(this, "图片存储", new a());
    }
}
