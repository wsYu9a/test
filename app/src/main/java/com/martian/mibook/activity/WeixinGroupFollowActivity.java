package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import com.martian.mibook.R;
import com.martian.mibook.activity.WeixinGroupFollowActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityWeixinGroupFollowBinding;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import i8.g;
import l9.i0;

/* loaded from: classes3.dex */
public class WeixinGroupFollowActivity extends MiBackableActivity {
    public final /* synthetic */ void M2() {
        if (g.y(this, "com.tencent.mm")) {
            P1("正在跳转微信");
        } else {
            P1("跳转微信失败，请检查是否已安装微信");
        }
    }

    public void N2(String str) {
        O2(str);
        i0.z0(this, getString(R.string.confirm_message), "已复制\"" + str + "\"到剪贴板，是否跳转到微信？", new i0.l() { // from class: qa.d0
            public /* synthetic */ d0() {
            }

            @Override // l9.i0.l
            public final void a() {
                WeixinGroupFollowActivity.this.M2();
            }
        });
    }

    public final void O2(String str) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("group", str));
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_weixin_group_follow);
        ActivityWeixinGroupFollowBinding.bind(D2()).rulesFirstTitle.setText("复制“" + MiConfigSingleton.b2().c2().getWeixinGroupId() + "”，搜索并关注");
    }

    public void onWexinIdClick(View view) {
        N2(MiConfigSingleton.b2().c2().getWeixinGroupId());
    }

    public void onWexinKeyClick(View view) {
        N2("邀请码");
    }
}
