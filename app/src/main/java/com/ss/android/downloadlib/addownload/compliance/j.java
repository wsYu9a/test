package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.g;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.lg.nt;

/* loaded from: classes4.dex */
public class j extends Dialog {

    /* renamed from: g */
    private TextView f24122g;
    private TextView gv;

    /* renamed from: i */
    private TextView f24123i;

    /* renamed from: j */
    private TextView f24124j;
    private Activity k;
    private ClipImageView lg;
    private final com.ss.android.downloadlib.addownload.zx.zx nt;
    private final long pa;
    private TextView q;
    private long t;
    private LinearLayout y;
    private TextView zx;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.j$1 */
    class AnonymousClass1 implements DialogInterface.OnCancelListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            q.j("lp_app_dialog_cancel", j.this.t);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.j$2 */
    class AnonymousClass2 implements g.j {
        AnonymousClass2() {
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.g.j
        public void j(Bitmap bitmap) {
            if (bitmap != null) {
                j.this.lg.setImageBitmap(bitmap);
            } else {
                q.j(8, j.this.t);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.j$3 */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zx.j().j(j.this.k);
            AppDetailInfoActivity.j(j.this.k, j.this.pa);
            q.j("lp_app_dialog_click_detail", j.this.t);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.j$4 */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zx.j().j(j.this.k);
            AppPrivacyPolicyActivity.j(j.this.k, j.this.pa);
            q.j("lp_app_dialog_click_privacy", j.this.t);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.j$5 */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.dismiss();
            q.j("lp_app_dialog_click_giveup", j.this.t);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.j$6 */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.j("lp_app_dialog_click_download", j.this.t);
            zx.j().zx(j.this.t);
            j.this.dismiss();
        }
    }

    public j(@NonNull Activity activity, long j2) {
        super(activity);
        this.k = activity;
        this.pa = j2;
        this.nt = i.j().get(Long.valueOf(j2));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.i.j(this.k);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.nt == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.t = this.nt.zx;
        j();
        q.zx("lp_app_dialog_show", this.t);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.j.1
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                q.j("lp_app_dialog_cancel", j.this.t);
            }
        });
    }

    private void j() {
        this.f24124j = (TextView) findViewById(R.id.tv_app_name);
        this.zx = (TextView) findViewById(R.id.tv_app_version);
        this.f24123i = (TextView) findViewById(R.id.tv_app_developer);
        this.f24122g = (TextView) findViewById(R.id.tv_app_detail);
        this.q = (TextView) findViewById(R.id.tv_app_privacy);
        this.gv = (TextView) findViewById(R.id.tv_give_up);
        this.lg = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.y = (LinearLayout) findViewById(R.id.ll_download);
        this.f24124j.setText(nt.j(this.nt.q, "--"));
        this.zx.setText("版本号：" + nt.j(this.nt.gv, "--"));
        this.f24123i.setText("开发者：" + nt.j(this.nt.lg, "应用信息正在完善中"));
        this.lg.setRoundRadius(nt.j(pa.getContext(), 8.0f));
        this.lg.setBackgroundColor(Color.parseColor("#EBEBEB"));
        g.j().j(this.pa, new g.j() { // from class: com.ss.android.downloadlib.addownload.compliance.j.2
            AnonymousClass2() {
            }

            @Override // com.ss.android.downloadlib.addownload.compliance.g.j
            public void j(Bitmap bitmap) {
                if (bitmap != null) {
                    j.this.lg.setImageBitmap(bitmap);
                } else {
                    q.j(8, j.this.t);
                }
            }
        });
        this.f24122g.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.j.3
            AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zx.j().j(j.this.k);
                AppDetailInfoActivity.j(j.this.k, j.this.pa);
                q.j("lp_app_dialog_click_detail", j.this.t);
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.j.4
            AnonymousClass4() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zx.j().j(j.this.k);
                AppPrivacyPolicyActivity.j(j.this.k, j.this.pa);
                q.j("lp_app_dialog_click_privacy", j.this.t);
            }
        });
        this.gv.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.j.5
            AnonymousClass5() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.dismiss();
                q.j("lp_app_dialog_click_giveup", j.this.t);
            }
        });
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.j.6
            AnonymousClass6() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.j("lp_app_dialog_click_download", j.this.t);
                zx.j().zx(j.this.t);
                j.this.dismiss();
            }
        });
    }
}
