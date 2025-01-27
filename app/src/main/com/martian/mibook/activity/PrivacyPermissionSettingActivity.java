package com.martian.mibook.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.kuaishou.weapon.p0.g;
import com.martian.libfeedback.request.FeedbackMailParams;
import com.martian.mibook.R;
import com.martian.mibook.activity.PrivacyPermissionSettingActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityPrivacySettingBinding;
import com.martian.mibook.lib.model.activity.MiBackableActivity;
import je.i;
import l9.i0;

/* loaded from: classes3.dex */
public class PrivacyPermissionSettingActivity extends MiBackableActivity {
    public ActivityPrivacySettingBinding A;

    public class a implements ea.b {
        public a() {
        }

        @Override // ea.b
        public void permissionDenied() {
            PrivacyPermissionSettingActivity.this.X2();
        }

        @Override // ea.b
        public void permissionGranted() {
            PrivacyPermissionSettingActivity.this.X2();
        }
    }

    public class b implements ea.b {
        public b() {
        }

        @Override // ea.b
        public void permissionDenied() {
            PrivacyPermissionSettingActivity.this.X2();
        }

        @Override // ea.b
        public void permissionGranted() {
            PrivacyPermissionSettingActivity.this.X2();
        }
    }

    public class c extends b9.c {
        public c() {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            PrivacyPermissionSettingActivity.this.P1("提交失败：" + cVar.d());
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(Integer num) {
            PrivacyPermissionSettingActivity.this.P1("提交成功");
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public final /* synthetic */ void R2() {
        MiConfigSingleton.b2().n3(false);
        P1("操作成功，下次启动时生效");
    }

    public final /* synthetic */ void S2() {
        this.A.sendBookInfo.setChecked(true);
    }

    public final /* synthetic */ void T2() {
        i.i(this);
    }

    public final /* synthetic */ void U2() {
        Intent intent = new Intent();
        String packageName = getApplicationContext().getPackageName();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + packageName));
        startActivityForResult(intent, 1001);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void V2(String str) {
        if (TextUtils.isEmpty(str)) {
            P1("邮箱不能为空,请重试");
            return;
        }
        c cVar = new c();
        ((FeedbackMailParams) cVar.k()).setMail(str);
        cVar.j();
    }

    public final /* synthetic */ void W2() {
        Intent intent = new Intent();
        String packageName = getApplicationContext().getPackageName();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + packageName));
        startActivityForResult(intent, 1001);
    }

    public void X2() {
        this.A.phoneStateStatus.setText(ea.c.d(this, g.f11102c) ? "已开启" : "去设置");
        this.A.storageStatus.setText(ea.c.f(this) ? "已开启" : "去设置");
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1001 && i11 == -1) {
            X2();
        }
    }

    public void onAdInfoClick(View view) {
        MiConfigSingleton.b2().m3(this.A.sendAdInfo.isChecked());
        P1("操作成功，下次启动时生效");
    }

    public void onBookInfoClick(View view) {
        if (!this.A.sendBookInfo.isChecked()) {
            i0.x0(this, getString(R.string.confirm_message), getString(R.string.cancel_recommend_desc), getString(com.martian.libmars.R.string.cancel), getString(R.string.confirm), false, new i0.l() { // from class: qa.m
                public /* synthetic */ m() {
                }

                @Override // l9.i0.l
                public final void a() {
                    PrivacyPermissionSettingActivity.this.R2();
                }
            }, new i0.k() { // from class: qa.n
                public /* synthetic */ n() {
                }

                @Override // l9.i0.k
                public final void a() {
                    PrivacyPermissionSettingActivity.this.S2();
                }
            });
        } else {
            MiConfigSingleton.b2().n3(true);
            P1("操作成功");
        }
    }

    public void onCancelPrivacyClick(View view) {
        i0.z0(this, getString(R.string.confirm_message), getString(R.string.cancel_privacy_desc), new i0.l() { // from class: qa.k
            public /* synthetic */ k() {
            }

            @Override // l9.i0.l
            public final void a() {
                PrivacyPermissionSettingActivity.this.T2();
            }
        });
    }

    @Override // com.martian.mibook.lib.model.activity.MiBackableActivity, com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_privacy_setting);
        ActivityPrivacySettingBinding bind = ActivityPrivacySettingBinding.bind(D2());
        this.A = bind;
        bind.sendBookInfo.setChecked(MiConfigSingleton.b2().W2());
        this.A.sendAdInfo.setChecked(MiConfigSingleton.b2().V2());
        X2();
    }

    public void onPhoneStatePermissionClick(View view) {
        if (ea.c.d(this, g.f11102c)) {
            i0.z0(this, "确定要关闭吗？", "关闭后，信息推送的相关度可能会下降，并影响确定安全事件的准确度", new i0.l() { // from class: qa.l
                public /* synthetic */ l() {
                }

                @Override // l9.i0.l
                public final void a() {
                    PrivacyPermissionSettingActivity.this.U2();
                }
            });
        } else {
            ea.c.k(this, new a(), new String[]{g.f11102c}, false, null, true);
        }
    }

    public void onReceivePrivacyClick(View view) {
        i0.D0(this, "获取个人信息", "请填写邮箱用于信息查收", false, false, new i0.j() { // from class: qa.i
            public /* synthetic */ i() {
            }

            @Override // l9.i0.j
            public final void a(String str) {
                PrivacyPermissionSettingActivity.this.V2(str);
            }
        });
    }

    public void onStoragePermissionClick(View view) {
        if (ea.c.f(this)) {
            i0.z0(this, "确定要关闭吗？", "关闭后，小说内容将占用内存空间，且无法使用缓存功能", new i0.l() { // from class: qa.j
                public /* synthetic */ j() {
                }

                @Override // l9.i0.l
                public final void a() {
                    PrivacyPermissionSettingActivity.this.W2();
                }
            });
        } else {
            ea.c.m(this, "图片存储", new b());
        }
    }
}
