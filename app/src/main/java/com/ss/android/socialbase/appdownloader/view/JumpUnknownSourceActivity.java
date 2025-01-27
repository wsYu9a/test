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
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.appdownloader.i.nt;
import com.ss.android.socialbase.appdownloader.i.t;
import com.ss.android.socialbase.appdownloader.k;
import com.ss.android.socialbase.appdownloader.y;
import com.ss.android.socialbase.appdownloader.zx;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* renamed from: g */
    private int f24503g;

    /* renamed from: i */
    @Nullable
    private Intent f24504i;

    /* renamed from: j */
    private t f24505j;
    private JSONObject q;
    private Intent zx;

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$1 */
    class AnonymousClass1 implements DialogInterface.OnCancelListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (JumpUnknownSourceActivity.this.f24504i != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                zx.j((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f24504i, true);
            }
            zx.zx(JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$2 */
    class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (JumpUnknownSourceActivity.this.f24504i != null) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                zx.j((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f24504i, true);
            }
            zx.zx(JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity$3 */
    class AnonymousClass3 implements DialogInterface.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
            if (zx.j(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f24504i, JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q)) {
                zx.i(JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q);
            } else {
                JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                zx.j((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f24504i, true);
            }
            zx.j(JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q);
            JumpUnknownSourceActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        j();
        y.j().j(this);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        y.j().j(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.zx = intent;
        if (intent != null) {
            this.f24504i = (Intent) intent.getParcelableExtra("intent");
            this.f24503g = intent.getIntExtra("id", -1);
            try {
                this.q = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.q == null) {
            i.j((Activity) this);
            return;
        }
        zx();
        t tVar = this.f24505j;
        if (tVar != null && !tVar.zx()) {
            this.f24505j.j();
        } else if (this.f24505j == null) {
            finish();
        }
    }

    private void j() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void zx() {
        if (this.f24505j != null || this.zx == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.i.i j2 = g.pa().j();
            nt j3 = j2 != null ? j2.j(this) : null;
            if (j3 == null) {
                j3 = new com.ss.android.socialbase.appdownloader.g.j(this);
            }
            int j4 = k.j(this, "tt_appdownloader_tip");
            int j5 = k.j(this, "tt_appdownloader_label_ok");
            int j6 = k.j(this, "tt_appdownloader_label_cancel");
            String optString = this.q.optString(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_TIPS);
            if (TextUtils.isEmpty(optString)) {
                optString = getString(k.j(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            j3.j(j4).j(optString).j(j5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                AnonymousClass3() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (zx.j(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f24504i, JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q)) {
                        zx.i(JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        zx.j((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f24504i, true);
                    }
                    zx.j(JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).zx(j6, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                AnonymousClass2() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (JumpUnknownSourceActivity.this.f24504i != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        zx.j((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f24504i, true);
                    }
                    zx.zx(JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).j(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                AnonymousClass1() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.f24504i != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        zx.j((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f24504i, true);
                    }
                    zx.zx(JumpUnknownSourceActivity.this.f24503g, JumpUnknownSourceActivity.this.q);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).j(false);
            this.f24505j = j3.j();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
