package com.martian.mibook.activity;

import android.os.Bundle;
import android.view.View;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class PrivacySettingActivity extends com.martian.mibook.lib.model.b.a {
    public void onAppAuthorityClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "应用权限申请与使用");
        com.martian.mibook.lib.account.e.c.c(this);
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        com.martian.mibook.e.n.a(g2());
    }

    public void onPersonalInfoClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "个人信息收集清单");
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        boolean z = true;
        if (!(x4 != null && x4.getPhoneBound()) && !MiConfigSingleton.V3().l6()) {
            z = false;
        }
        com.martian.mibook.lib.account.e.c.e(this, z, MiConfigSingleton.V3().l6());
    }

    public void onPrivacyClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "隐私政策");
        com.martian.mibook.lib.account.e.c.f(this);
    }

    public void onPrivacySettingClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "隐私设置");
        startActivity(PrivacyPermissionSettingActivity.class);
    }

    public void onShareListClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "第三方信息共享清单");
        com.martian.mibook.lib.account.e.c.g(this);
    }

    public void onUserAgreementClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "用户协议");
        com.martian.mibook.lib.account.e.c.i(this);
    }
}
