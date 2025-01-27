package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.h;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* renamed from: a */
    private k f21962a;

    /* renamed from: b */
    private Intent f21963b;

    /* renamed from: c */
    @Nullable
    private Intent f21964c;

    /* renamed from: d */
    private int f21965d;

    /* renamed from: e */
    private JSONObject f21966e;

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$1 */
    public class AnonymousClass1 implements DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (JumpUnknownSourceActivity.this.f21964c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21964c, true);
            }
            b.b(JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$2 */
    public class AnonymousClass2 implements DialogInterface.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (JumpUnknownSourceActivity.this.f21964c != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21964c, true);
            }
            b.b(JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$3 */
    public class AnonymousClass3 implements DialogInterface.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
            if (b.a(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21964c, JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e)) {
                b.c(JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e);
            } else {
                JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                b.a((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f21964c, true);
            }
            b.a(JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
        h.a().a(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        h.a().a(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f21963b = intent;
        if (intent != null) {
            this.f21964c = (Intent) intent.getParcelableExtra("intent");
            this.f21965d = intent.getIntExtra("id", -1);
            try {
                this.f21966e = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (this.f21966e == null) {
            c.a((Activity) this);
            return;
        }
        b();
        k kVar = this.f21962a;
        if (kVar != null && !kVar.b()) {
            this.f21962a.a();
        } else if (this.f21962a == null) {
            finish();
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void b() {
        if (this.f21962a != null || this.f21963b == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.c.c a10 = d.j().a();
            l a11 = a10 != null ? a10.a(this) : null;
            if (a11 == null) {
                a11 = new com.ss.android.socialbase.appdownloader.d.a(this);
            }
            int a12 = i.a(this, "tt_appdownloader_tip");
            int a13 = i.a(this, "tt_appdownloader_label_ok");
            int a14 = i.a(this, "tt_appdownloader_label_cancel");
            String optString = this.f21966e.optString(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_TIPS);
            if (TextUtils.isEmpty(optString)) {
                optString = getString(i.a(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            a11.a(a12).a(optString).a(a13, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                public AnonymousClass3() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (b.a(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21964c, JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e)) {
                        b.c(JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f21964c, true);
                    }
                    b.a(JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).b(a14, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                public AnonymousClass2() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (JumpUnknownSourceActivity.this.f21964c != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21964c, true);
                    }
                    b.b(JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).a(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                public AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.f21964c != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21964c, true);
                    }
                    b.b(JumpUnknownSourceActivity.this.f21965d, JumpUnknownSourceActivity.this.f21966e);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).a(false);
            this.f21962a = a11.a();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
