package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import com.martian.libmars.utils.k0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class WeixinGroupFollowActivity extends com.martian.mibook.lib.model.b.a {
    /* renamed from: r2 */
    public /* synthetic */ void s2() {
        if (com.martian.apptask.g.g.s(this, "com.tencent.mm")) {
            k1("正在跳转微信");
        } else {
            k1("跳转微信失败，请检查是否已安装微信");
        }
    }

    private void u2(String text) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("group", text));
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin_group_follow);
        com.martian.mibook.e.d0.a(g2()).f11818c.setText("复制“" + MiConfigSingleton.V3().W3().getWeixinGroupId() + "”，搜索并关注");
    }

    public void onWexinIdClick(View view) {
        t2(MiConfigSingleton.V3().W3().getWeixinGroupId());
    }

    public void onWexinKeyClick(View view) {
        t2("邀请码");
    }

    public void t2(String key) {
        u2(key);
        com.martian.libmars.utils.k0.P(this, getString(R.string.confirm_message), "已复制\"" + key + "\"到剪贴板，是否跳转到微信？", new k0.l() { // from class: com.martian.mibook.activity.a1
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                WeixinGroupFollowActivity.this.s2();
            }
        });
    }
}
