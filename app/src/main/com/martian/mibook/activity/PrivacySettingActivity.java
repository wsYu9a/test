package com.martian.mibook.activity;

import ac.a;
import android.os.Bundle;
import android.view.View;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityPrivacyBinding;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import lb.c;

/* loaded from: classes3.dex */
public class PrivacySettingActivity extends MiBackableActivity {
    public void onAppAuthorityClick(View view) {
        a.Q(this, "应用权限申请与使用");
        c.j(this);
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_privacy);
        ActivityPrivacyBinding.bind(D2());
    }

    public void onPersonalInfoClick(View view) {
        a.Q(this, "个人信息收集清单");
        MiTaskAccount p22 = MiConfigSingleton.b2().p2();
        c.m(this, (p22 != null && p22.getPhoneBound()) || MiConfigSingleton.b2().N2(), MiConfigSingleton.b2().N2());
    }

    public void onPrivacyClick(View view) {
        a.Q(this, "隐私政策");
        c.n(this);
    }

    public void onPrivacySettingClick(View view) {
        a.Q(this, "隐私设置");
        startActivity(PrivacyPermissionSettingActivity.class);
    }

    public void onShareListClick(View view) {
        a.Q(this, "第三方信息共享清单");
        c.o(this);
    }

    public void onUserAgreementClick(View view) {
        a.Q(this, "用户协议");
        c.q(this);
    }
}
