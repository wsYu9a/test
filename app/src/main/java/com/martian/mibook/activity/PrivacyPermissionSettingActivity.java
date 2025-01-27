package com.martian.mibook.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.martian.libfeedback.request.FeedbackMailParams;
import com.martian.libmars.utils.k0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.j.s2;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class PrivacyPermissionSettingActivity extends com.martian.mibook.lib.model.b.a {
    private com.martian.mibook.e.o F;

    class a implements com.martian.libsupport.permission.f {
        a() {
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            PrivacyPermissionSettingActivity.this.D2();
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            PrivacyPermissionSettingActivity.this.D2();
        }
    }

    class b implements com.martian.libsupport.permission.f {
        b() {
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            PrivacyPermissionSettingActivity.this.D2();
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            PrivacyPermissionSettingActivity.this.D2();
        }
    }

    class c extends com.martian.libfeedback.b.c {
        c() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            PrivacyPermissionSettingActivity.this.k1("提交失败：" + errorResult.d());
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(Integer integer) {
            PrivacyPermissionSettingActivity.this.k1("提交成功");
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* renamed from: B2 */
    public /* synthetic */ void C2() {
        Intent intent = new Intent();
        String packageName = getApplicationContext().getPackageName();
        if (com.martian.libsupport.l.p()) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + packageName));
        } else {
            intent = new Intent("android.settings.SETTINGS");
        }
        startActivityForResult(intent, 1001);
    }

    /* renamed from: r2 */
    public /* synthetic */ void s2() {
        MiConfigSingleton.V3().i8(false);
        k1("操作成功，下次启动时生效");
    }

    /* renamed from: t2 */
    public /* synthetic */ void u2() {
        this.F.f12450f.setChecked(true);
    }

    /* renamed from: v2 */
    public /* synthetic */ void w2() {
        s2.d(this);
    }

    /* renamed from: x2 */
    public /* synthetic */ void y2() {
        Intent intent = new Intent();
        String packageName = getApplicationContext().getPackageName();
        if (com.martian.libsupport.l.p()) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + packageName));
        } else {
            intent = new Intent("android.settings.SETTINGS");
        }
        startActivityForResult(intent, 1001);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: z2 */
    public /* synthetic */ void A2(String text) {
        if (TextUtils.isEmpty(text)) {
            k1("邮箱不能为空,请重试");
            return;
        }
        c cVar = new c();
        ((FeedbackMailParams) cVar.k()).setMail(text);
        cVar.j();
    }

    public void D2() {
        this.F.f12446b.setText(com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c) ? "已开启" : "去设置");
        this.F.f12451g.setText(com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9325j) ? "已开启" : "去设置");
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == -1) {
            D2();
        }
    }

    public void onAdInfoClick(View view) {
        MiConfigSingleton.V3().h8(this.F.f12449e.isChecked());
        k1("操作成功，下次启动时生效");
    }

    public void onBookInfoClick(View view) {
        if (!this.F.f12450f.isChecked()) {
            com.martian.libmars.utils.k0.Q(this, getString(R.string.confirm_message), getString(R.string.cancel_recommend_desc), getString(R.string.cancel), getString(R.string.confirm), false, new k0.l() { // from class: com.martian.mibook.activity.g0
                @Override // com.martian.libmars.utils.k0.l
                public final void a() {
                    PrivacyPermissionSettingActivity.this.s2();
                }
            }, new k0.j() { // from class: com.martian.mibook.activity.j0
                @Override // com.martian.libmars.utils.k0.j
                public final void a() {
                    PrivacyPermissionSettingActivity.this.u2();
                }
            });
        } else {
            MiConfigSingleton.V3().i8(true);
            k1("操作成功");
        }
    }

    public void onCancelPrivacyClick(View view) {
        com.martian.libmars.utils.k0.P(this, getString(R.string.confirm_message), getString(R.string.cancel_privacy_desc), new k0.l() { // from class: com.martian.mibook.activity.k0
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                PrivacyPermissionSettingActivity.this.w2();
            }
        });
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_setting);
        com.martian.mibook.e.o a2 = com.martian.mibook.e.o.a(g2());
        this.F = a2;
        a2.f12450f.setChecked(MiConfigSingleton.V3().Q6());
        this.F.f12449e.setChecked(MiConfigSingleton.V3().P6());
        D2();
    }

    public void onPhoneStatePermissionClick(View view) {
        if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c)) {
            com.martian.libmars.utils.k0.P(this, "确定要关闭吗？", "关闭后，信息推送的相关度可能会下降，并影响确定安全事件的准确度", new k0.l() { // from class: com.martian.mibook.activity.h0
                @Override // com.martian.libmars.utils.k0.l
                public final void a() {
                    PrivacyPermissionSettingActivity.this.y2();
                }
            });
        } else {
            com.martian.libsupport.permission.g.h(this, new a(), new String[]{com.kuaishou.weapon.p0.g.f9318c}, false, null, true);
        }
    }

    public void onReceivePrivacyClick(View view) {
        com.martian.libmars.utils.k0.V(this, "获取个人信息", "请填写邮箱用于信息查收", false, false, new k0.i() { // from class: com.martian.mibook.activity.i0
            @Override // com.martian.libmars.utils.k0.i
            public final void a(String str) {
                PrivacyPermissionSettingActivity.this.A2(str);
            }
        });
    }

    public void onStoragePermissionClick(View view) {
        if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9325j)) {
            com.martian.libmars.utils.k0.P(this, "确定要关闭吗？", "关闭后，小说内容将占用内存空间，且无法使用缓存功能", new k0.l() { // from class: com.martian.mibook.activity.l0
                @Override // com.martian.libmars.utils.k0.l
                public final void a() {
                    PrivacyPermissionSettingActivity.this.C2();
                }
            });
        } else {
            com.martian.libsupport.permission.g.h(this, new b(), new String[]{com.kuaishou.weapon.p0.g.f9325j}, false, null, true);
        }
    }
}
