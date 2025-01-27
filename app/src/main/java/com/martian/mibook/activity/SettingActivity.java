package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.martian.libmars.utils.j0;
import com.martian.libmars.utils.k0;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.RestoreBookStoreActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.p4;
import com.martian.ttbookhd.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.bugly.beta.Beta;

/* loaded from: classes3.dex */
public class SettingActivity extends com.martian.mibook.lib.model.b.a {
    public static int F = 10001;
    private long G;
    private boolean H = false;
    private String I = "";
    private com.martian.mibook.e.s J;

    /* renamed from: B2 */
    public /* synthetic */ void C2(int which) {
        MiConfigSingleton.V3().T7(s2(which));
        this.J.f12643j.setText(t2());
    }

    /* renamed from: D2 */
    public /* synthetic */ void E2() {
        this.G = com.martian.libmars.utils.j0.f(this);
        k1("清除完毕");
        this.J.k.setText(getString(R.string.clear_storage_cache_desc) + com.martian.libmars.utils.j0.e(this.G));
        this.H = false;
    }

    /* renamed from: F2 */
    public /* synthetic */ void G2(final PopupWindow window, View v) {
        if (window != null) {
            window.dismiss();
        }
        com.martian.libmars.utils.k0.P(this, getString(R.string.account_security_logout), getString(R.string.account_security_logout_desc), new k0.l() { // from class: com.martian.mibook.activity.n0
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                SettingActivity.this.w2();
            }
        });
    }

    private void I2() {
        MiConfigSingleton.V3().t6(this, null);
        setResult(-1);
        K2();
    }

    private void J2() {
        p4 d2 = p4.d((LayoutInflater) getSystemService("layout_inflater"), null, false);
        final PopupWindow e2 = com.martian.libmars.utils.k0.e(this, d2.getRoot(), true, 80);
        d2.f12526d.setText(getString(R.string.account_security_logout));
        d2.f12525c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.G2(e2, view);
            }
        });
        d2.f12524b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e2.dismiss();
            }
        });
    }

    private void K2() {
        this.J.f12637d.setVisibility(MiConfigSingleton.V3().l6() ? 0 : 8);
        this.J.f12638e.setVisibility(MiConfigSingleton.V3().l6() ? 0 : 8);
        this.J.f12635b.setVisibility(MiConfigSingleton.V3().l6() ? 0 : 8);
        this.J.f12636c.setVisibility(MiConfigSingleton.V3().l6() ? 0 : 8);
    }

    private void L2() {
        if (com.martian.libsupport.f.d(this)) {
            this.J.m.setText(getString(R.string.push_notification_opened));
            this.J.l.setVisibility(8);
            this.I = "开启";
        } else {
            this.J.m.setText(getString(R.string.push_notification_closed));
            this.J.l.setVisibility(0);
            this.I = "关闭";
        }
    }

    private String r2() {
        int t3 = MiConfigSingleton.V3().t3();
        return t3 != 0 ? t3 != 1 ? getString(R.string.push_wifi) : getString(R.string.push_always) : getString(R.string.push_no);
    }

    private int s2(int position) {
        if (position == 0) {
            return 1800000;
        }
        if (position == 1) {
            return 2700000;
        }
        if (position != 2) {
            return 7200000;
        }
        return BaseConstants.Time.HOUR;
    }

    private String t2() {
        int g4 = MiConfigSingleton.V3().g4();
        return g4 != 1800 ? g4 != 2700 ? g4 != 3600 ? getString(R.string.two_hour) : getString(R.string.one_hour) : getString(R.string.forty_five_minutes) : getString(R.string.thirty_minutes);
    }

    private int u2() {
        int g4 = MiConfigSingleton.V3().g4();
        if (g4 == 1800) {
            return 0;
        }
        if (g4 != 2700) {
            return g4 != 3600 ? 3 : 2;
        }
        return 1;
    }

    /* renamed from: v2 */
    public /* synthetic */ void w2() {
        com.martian.mibook.lib.model.g.b.a0(this, "注销账号");
        MiWebViewActivity.d4(this, com.martian.libmars.d.h.F().N(), false, F);
    }

    /* renamed from: x2 */
    public /* synthetic */ void y2() {
        com.martian.mibook.lib.model.g.b.a0(this, "退出登录");
        k1("退出成功");
        I2();
    }

    /* renamed from: z2 */
    public /* synthetic */ void A2(int which) {
        MiConfigSingleton.V3().n7(which);
        this.J.f12642i.setText(r2());
    }

    public void onAccountLogoutClick(View view) {
        com.martian.libmars.utils.k0.P(this, getString(R.string.logout), getString(R.string.logout_hint), new k0.l() { // from class: com.martian.mibook.activity.r0
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                SettingActivity.this.y2();
            }
        });
    }

    public void onAccountSecurityClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "账户与安全");
        J2();
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == F && resultCode == -1) {
            com.martian.mibook.lib.model.g.b.Z(this, "申请注销账号");
            I2();
        } else if (requestCode == 1001) {
            StringBuilder sb = new StringBuilder();
            sb.append("设置:");
            sb.append(this.I);
            sb.append(com.martian.libsupport.f.d(this) ? "-开启" : "-关闭");
            com.martian.mibook.lib.model.g.b.P(this, sb.toString());
        }
    }

    public void onBackupClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "本地备份");
        startActivity(RestoreBookStoreActivity.class);
    }

    public void onBookrackArchiveClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "归档收藏");
        MiConfigSingleton.V3().l3().Y0(this.J.f12640g.isChecked());
    }

    public void onBookrackRecommendClick(View view) {
        MiConfigSingleton.V3().t7(!this.J.o.isChecked());
    }

    public void onCheckAppUpdateClick(View view) {
        if (MiConfigSingleton.V3().j5()) {
            k1("您已经是最新版本");
        } else if (MiConfigSingleton.V3().N2()) {
            com.martian.mibook.lib.model.g.b.a0(this, "检查更新-原生");
            MiConfigSingleton.V3().m2(this, true);
        } else {
            com.martian.mibook.lib.model.g.b.a0(this, "检查更新");
            Beta.checkUpgrade(true, false);
        }
    }

    public void onCheckUpdateClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "推送方式");
        com.martian.libmars.utils.k0.b0(this, getString(R.string.chapter_update_push), new String[]{getString(R.string.push_no), getString(R.string.push_always), getString(R.string.push_wifi)}, MiConfigSingleton.V3().t3(), new k0.n() { // from class: com.martian.mibook.activity.o0
            @Override // com.martian.libmars.utils.k0.n
            public final void a(int i2) {
                SettingActivity.this.A2(i2);
            }
        });
    }

    public void onCheckUpdateIntervalClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "推送间隔");
        com.martian.libmars.utils.k0.b0(this, getString(R.string.push_interval_time), new String[]{getString(R.string.thirty_minutes), getString(R.string.forty_five_minutes), getString(R.string.one_hour), getString(R.string.two_hour)}, u2(), new k0.n() { // from class: com.martian.mibook.activity.q0
            @Override // com.martian.libmars.utils.k0.n
            public final void a(int i2) {
                SettingActivity.this.C2(i2);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    public void onClearCacheClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "清除缓存");
        boolean z = this.G <= 0;
        k1(this.H ? "正在清除中" : z ? "已经很干净啦" : "清除中...");
        if (this.H || z) {
            return;
        }
        this.H = true;
        com.martian.libmars.utils.j0.b(this, new j0.b() { // from class: com.martian.mibook.activity.t0
            @Override // com.martian.libmars.utils.j0.b
            public final void clear() {
                SettingActivity.this.E2();
            }
        });
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        this.J = com.martian.mibook.e.s.a(g2());
        this.G = com.martian.libmars.utils.j0.f(this);
        this.J.k.setText(getString(R.string.clear_storage_cache_desc) + com.martian.libmars.utils.j0.e(this.G));
        this.J.f12642i.setText(r2());
        this.J.f12643j.setText(t2());
        this.J.f12641h.setText(getResources().getString(R.string.version_name) + com.martian.libmars.d.h.F().x0() + "  " + getString(R.string.version_code) + com.martian.libmars.d.h.F().w0());
        this.J.q.setChecked(MiConfigSingleton.V3().e2());
        this.J.p.setChecked(MiConfigSingleton.V3().E6());
        if (MiConfigSingleton.V3().z2()) {
            this.J.o.setVisibility(0);
            this.J.o.setChecked(false);
        } else {
            this.J.o.setVisibility(8);
        }
        this.J.f12640g.setChecked(MiConfigSingleton.V3().l3().a1());
        K2();
        com.martian.mibook.lib.model.g.b.P(this, "设置:曝光");
        com.martian.mibook.lib.model.g.b.a0(this, "设置-展示");
    }

    public void onGenderClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "性别偏好");
        GenderGuideActivity.S2(this);
    }

    public void onQrcodeClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "扫描二维码");
        if (MiConfigSingleton.V3().n2(this)) {
            MiQrcodeActivity.g(this, "微信扫一扫邀请", MiConfigSingleton.V3().W3().getPhoneInviteShareLink());
        }
    }

    public void onRecordCategoryClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "记住书架分类");
        MiConfigSingleton.V3().b8(this.J.p.isChecked());
    }

    public void onShowImageClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "2G3G显示图片");
        MiConfigSingleton.V3().k7(this.J.q.isChecked());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        L2();
    }

    public void onTeenagerClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "青少年模式");
        startActivity(TeenagerGuideActivity.class);
    }

    public void onUpdateNotificationClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "追更推送");
        com.martian.libsupport.f.a(this);
    }

    public void onUserAgreementClick(View view) {
        com.martian.mibook.lib.model.g.b.a0(this, "用户协议");
        startActivity(PrivacySettingActivity.class);
    }
}
