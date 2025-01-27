package com.martian.mibook.activity;

import ac.a;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import ba.h;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.SettingActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.RestoreBookStoreActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivitySettingsBinding;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import l9.c;
import l9.i0;
import ya.e0;

/* loaded from: classes3.dex */
public class SettingActivity extends MiBackableActivity {
    public static int E = 10001;
    public long A;
    public boolean B = false;
    public String C = "";
    public ActivitySettingsBinding D;

    public final String S2() {
        int Q1 = MiConfigSingleton.b2().Q1();
        return Q1 != 0 ? Q1 != 1 ? getString(R.string.push_wifi) : getString(R.string.push_always) : getString(R.string.push_no);
    }

    public final int T2(int i10) {
        if (i10 == 0) {
            return e0.f33147e0;
        }
        if (i10 != 1) {
            return i10 != 2 ? 7200000 : 3600000;
        }
        return 2700000;
    }

    public final String U2() {
        int g22 = MiConfigSingleton.b2().g2();
        return g22 != 1800 ? g22 != 2700 ? g22 != 3600 ? getString(R.string.two_hour) : getString(R.string.one_hour) : getString(R.string.forty_five_minutes) : getString(R.string.thirty_minutes);
    }

    public final int V2() {
        int g22 = MiConfigSingleton.b2().g2();
        if (g22 == 1800) {
            return 0;
        }
        if (g22 != 2700) {
            return g22 != 3600 ? 3 : 2;
        }
        return 1;
    }

    public final /* synthetic */ void W2() {
        a.Q(this, "退出登录");
        P1("退出成功");
        d3();
    }

    public final /* synthetic */ void X2(int i10) {
        MiConfigSingleton.b2().Z2(i10);
        this.D.checkUpdateDesc.setText(S2());
    }

    public final /* synthetic */ void Y2(int i10) {
        MiConfigSingleton.b2().j3(T2(i10));
        this.D.checkUpdateIntervalDesc.setText(U2());
    }

    public final /* synthetic */ void Z2() {
        this.A = c.f(this);
        P1("清除完毕");
        this.D.clearCacheSize.setText(getString(R.string.clear_storage_cache_desc) + c.e(this.A));
        this.B = false;
    }

    public final /* synthetic */ void a3() {
        a.Q(this, "注销账号");
        MiWebViewActivity.K5(this, ConfigSingleton.D().H(), false, E);
    }

    public final /* synthetic */ void b3(PopupWindow popupWindow, View view) {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        i0.z0(this, getString(R.string.account_security_logout), getString(R.string.account_security_logout_desc), new i0.l() { // from class: qa.q
            public /* synthetic */ q() {
            }

            @Override // l9.i0.l
            public final void a() {
                SettingActivity.this.a3();
            }
        });
    }

    public final void d3() {
        MiConfigSingleton.b2().P2(this, null);
        setResult(-1);
        f3();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: qa.s.<init>(com.martian.mibook.activity.SettingActivity, android.widget.PopupWindow):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public final void e3() {
        /*
            r4 = this;
            java.lang.String r0 = "layout_inflater"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            r1 = 0
            r2 = 0
            com.martian.mibook.databinding.PopupwindowAccountLogoutBinding r0 = com.martian.mibook.databinding.PopupwindowAccountLogoutBinding.inflate(r0, r1, r2)
            com.martian.libmars.ui.theme.ThemeLinearLayout r1 = r0.getRoot()
            r2 = 1
            r3 = 80
            android.widget.PopupWindow r1 = l9.i0.J(r4, r1, r2, r3)
            com.martian.libmars.ui.theme.ThemeTextView r2 = r0.acpLogoutTitle
            int r3 = com.martian.mibook.R.string.account_security_logout
            java.lang.String r3 = r4.getString(r3)
            r2.setText(r3)
            com.martian.libmars.ui.theme.ThemeLinearLayout r2 = r0.acpLogoutLayout
            qa.s r3 = new qa.s
            r3.<init>()
            r2.setOnClickListener(r3)
            com.martian.libmars.ui.theme.ThemeLinearLayout r0 = r0.acpCancelLayout
            qa.t r2 = new qa.t
            r2.<init>()
            r0.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.activity.SettingActivity.e3():void");
    }

    public final void f3() {
        this.D.acAccountSecurity.setVisibility(MiConfigSingleton.b2().N2() ? 0 : 8);
        this.D.acAccountSecurityDivider.setVisibility(MiConfigSingleton.b2().N2() ? 0 : 8);
        this.D.acAccountLogout.setVisibility(MiConfigSingleton.b2().N2() ? 0 : 8);
        this.D.acAccountLogoutDivider.setVisibility(MiConfigSingleton.b2().N2() ? 0 : 8);
    }

    public final void g3() {
        if (h.e(this)) {
            this.D.pushNotificationStatus.setText(getString(R.string.push_notification_opened));
            this.D.notificationDot.setVisibility(8);
            this.C = "开启";
        } else {
            this.D.pushNotificationStatus.setText(getString(R.string.push_notification_closed));
            this.D.notificationDot.setVisibility(0);
            this.C = "关闭";
        }
    }

    public void onAccountLogoutClick(View view) {
        i0.z0(this, getString(R.string.logout), getString(R.string.logout_hint), new i0.l() { // from class: qa.r
            public /* synthetic */ r() {
            }

            @Override // l9.i0.l
            public final void a() {
                SettingActivity.this.W2();
            }
        });
    }

    public void onAccountSecurityClick(View view) {
        a.Q(this, "账户与安全");
        e3();
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == E && i11 == -1) {
            a.P(this, "申请注销账号");
            d3();
        } else if (i10 == 1001) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("设置:");
            sb2.append(this.C);
            sb2.append(h.e(this) ? "-开启" : "-关闭");
            a.I(this, sb2.toString());
        }
    }

    public void onBackupClick(View view) {
        a.Q(this, "本地备份");
        startActivity(RestoreBookStoreActivity.class);
    }

    public void onBookrackArchiveClick(View view) {
        a.Q(this, "归档收藏");
        MiConfigSingleton.b2().M1().F0(this.D.bookrackArchive.isChecked());
    }

    public void onBookrackRecommendClick(View view) {
        MiConfigSingleton.b2().M1().D2(this, !this.D.receiveBookrackRecommend.isChecked());
    }

    public void onCheckAppUpdateClick(View view) {
        a.Q(this, "检查更新-原生");
        MiConfigSingleton.b2().G1().h(this, true);
    }

    public void onCheckUpdateClick(View view) {
        a.Q(this, "推送方式");
        i0.K0(this, getString(R.string.chapter_update_push), new String[]{getString(R.string.push_no), getString(R.string.push_always), getString(R.string.push_wifi)}, MiConfigSingleton.b2().Q1(), new i0.n() { // from class: qa.u
            public /* synthetic */ u() {
            }

            @Override // l9.i0.n
            public final void a(int i10) {
                SettingActivity.this.X2(i10);
            }
        });
    }

    public void onCheckUpdateIntervalClick(View view) {
        a.Q(this, "推送间隔");
        i0.K0(this, getString(R.string.push_interval_time), new String[]{getString(R.string.thirty_minutes), getString(R.string.forty_five_minutes), getString(R.string.one_hour), getString(R.string.two_hour)}, V2(), new i0.n() { // from class: qa.v
            public /* synthetic */ v() {
            }

            @Override // l9.i0.n
            public final void a(int i10) {
                SettingActivity.this.Y2(i10);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    public void onClearCacheClick(View view) {
        a.Q(this, "清除缓存");
        boolean z10 = this.A <= 0;
        P1(this.B ? "正在清除中" : z10 ? "已经很干净啦" : "清除中...");
        if (this.B || z10) {
            return;
        }
        this.B = true;
        c.b(this, new c.b() { // from class: qa.p
            public /* synthetic */ p() {
            }

            @Override // l9.c.b
            public final void clear() {
                SettingActivity.this.Z2();
            }
        });
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        this.D = ActivitySettingsBinding.bind(D2());
        this.A = c.f(this);
        this.D.clearCacheSize.setText(getString(R.string.clear_storage_cache_desc) + c.e(this.A));
        this.D.checkUpdateDesc.setText(S2());
        this.D.checkUpdateIntervalDesc.setText(U2());
        this.D.checkAppUpdateDesc.setText(getResources().getString(R.string.version_name) + ConfigSingleton.D().p0() + "  " + getString(R.string.version_code) + ConfigSingleton.D().o0());
        this.D.showImage.setChecked(MiConfigSingleton.b2().x1());
        this.D.recordBookrackCategory.setChecked(MiConfigSingleton.b2().T2());
        if (MiConfigSingleton.b2().M1().r1(this)) {
            this.D.receiveBookrackRecommend.setVisibility(0);
            this.D.receiveBookrackRecommend.setChecked(false);
        } else {
            this.D.receiveBookrackRecommend.setVisibility(8);
        }
        this.D.bookrackArchive.setChecked(MiConfigSingleton.b2().M1().H0());
        f3();
        a.I(this, "设置:曝光");
        a.Q(this, "设置-展示");
    }

    public void onGenderClick(View view) {
        a.Q(this, "性别偏好");
        GenderGuideActivity.k3(this);
    }

    public void onQrcodeClick(View view) {
        a.Q(this, "扫描二维码");
        if (MiConfigSingleton.b2().G1().i(this)) {
            MiQrcodeActivity.g(this, "微信扫一扫邀请", MiConfigSingleton.b2().c2().getPhoneInviteShareLink());
        }
    }

    public void onRecordCategoryClick(View view) {
        a.Q(this, "记住书架分类");
        MiConfigSingleton.b2().l3(this.D.recordBookrackCategory.isChecked());
    }

    public void onShowImageClick(View view) {
        a.Q(this, "2G3G显示图片");
        MiConfigSingleton.b2().Y2(this.D.showImage.isChecked());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        g3();
    }

    public void onTeenagerClick(View view) {
        a.Q(this, "青少年模式");
        startActivity(TeenagerGuideActivity.class);
    }

    public void onUpdateNotificationClick(View view) {
        a.Q(this, "追更推送");
        h.b(this);
    }

    public void onUserAgreementClick(View view) {
        a.Q(this, "用户协议");
        startActivity(PrivacySettingActivity.class);
    }
}
