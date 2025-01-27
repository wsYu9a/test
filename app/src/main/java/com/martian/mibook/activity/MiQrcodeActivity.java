package com.martian.mibook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.martian.libsupport.permission.TipInfo;

/* loaded from: classes3.dex */
public class MiQrcodeActivity extends b.d.d.b {

    class a implements com.martian.libsupport.permission.f {
        a() {
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            MiQrcodeActivity.this.f("缺少存储权限");
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            MiQrcodeActivity.super.d();
        }
    }

    public static void g(Activity activity, String title, String qrcode) {
        Bundle bundle = new Bundle();
        bundle.putString("MARTIAN_QRCODE", qrcode);
        bundle.putString("MARTIAN_TITLE", title);
        Intent intent = new Intent(activity, (Class<?>) MiQrcodeActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override // b.d.d.b
    public void d() {
        com.martian.libsupport.permission.g.h(this, new a(), new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo("权限申请", "需要存储权限才能正常存储二维码\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。", "取消", "前往开启"), true);
    }
}
