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
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* loaded from: classes4.dex */
public class a extends Dialog {

    /* renamed from: a */
    private TextView f21270a;

    /* renamed from: b */
    private TextView f21271b;

    /* renamed from: c */
    private TextView f21272c;

    /* renamed from: d */
    private TextView f21273d;

    /* renamed from: e */
    private TextView f21274e;

    /* renamed from: f */
    private TextView f21275f;

    /* renamed from: g */
    private ClipImageView f21276g;

    /* renamed from: h */
    private LinearLayout f21277h;

    /* renamed from: i */
    private Activity f21278i;

    /* renamed from: j */
    private final long f21279j;

    /* renamed from: k */
    private long f21280k;

    /* renamed from: l */
    private final com.ss.android.downloadlib.addownload.b.b f21281l;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.a$1 */
    public class AnonymousClass1 implements DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            g.a("lp_app_dialog_cancel", a.this.f21280k);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.a$2 */
    public class AnonymousClass2 implements d.a {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.d.a
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                a.this.f21276g.setImageBitmap(bitmap);
            } else {
                g.a(8, a.this.f21280k);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.a$3 */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a().a(a.this.f21278i);
            AppDetailInfoActivity.a(a.this.f21278i, a.this.f21279j);
            g.a("lp_app_dialog_click_detail", a.this.f21280k);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.a$4 */
    public class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a().a(a.this.f21278i);
            AppPrivacyPolicyActivity.a(a.this.f21278i, a.this.f21279j);
            g.a("lp_app_dialog_click_privacy", a.this.f21280k);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.a$5 */
    public class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            g.a("lp_app_dialog_click_giveup", a.this.f21280k);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.a$6 */
    public class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a("lp_app_dialog_click_download", a.this.f21280k);
            b.a().b(a.this.f21280k);
            a.this.dismiss();
        }
    }

    public a(@NonNull Activity activity, long j10) {
        super(activity);
        this.f21278i = activity;
        this.f21279j = j10;
        this.f21281l = c.a().get(Long.valueOf(j10));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.c.a(this.f21278i);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f21281l == null) {
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
        this.f21280k = this.f21281l.f21190b;
        a();
        g.b("lp_app_dialog_show", this.f21280k);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
            public AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                g.a("lp_app_dialog_cancel", a.this.f21280k);
            }
        });
    }

    private void a() {
        this.f21270a = (TextView) findViewById(R.id.tv_app_name);
        this.f21271b = (TextView) findViewById(R.id.tv_app_version);
        this.f21272c = (TextView) findViewById(R.id.tv_app_developer);
        this.f21273d = (TextView) findViewById(R.id.tv_app_detail);
        this.f21274e = (TextView) findViewById(R.id.tv_app_privacy);
        this.f21275f = (TextView) findViewById(R.id.tv_give_up);
        this.f21276g = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.f21277h = (LinearLayout) findViewById(R.id.ll_download);
        this.f21270a.setText(m.a(this.f21281l.f21193e, "--"));
        this.f21271b.setText("版本号：" + m.a(this.f21281l.f21194f, "--"));
        this.f21272c.setText("开发者：" + m.a(this.f21281l.f21195g, "应用信息正在完善中"));
        this.f21276g.setRoundRadius(m.a(k.a(), 8.0f));
        this.f21276g.setBackgroundColor(Color.parseColor("#EBEBEB"));
        d.a().a(this.f21279j, new d.a() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            public AnonymousClass2() {
            }

            @Override // com.ss.android.downloadlib.addownload.compliance.d.a
            public void a(Bitmap bitmap) {
                if (bitmap != null) {
                    a.this.f21276g.setImageBitmap(bitmap);
                } else {
                    g.a(8, a.this.f21280k);
                }
            }
        });
        this.f21273d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.3
            public AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f21278i);
                AppDetailInfoActivity.a(a.this.f21278i, a.this.f21279j);
                g.a("lp_app_dialog_click_detail", a.this.f21280k);
            }
        });
        this.f21274e.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.4
            public AnonymousClass4() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.f21278i);
                AppPrivacyPolicyActivity.a(a.this.f21278i, a.this.f21279j);
                g.a("lp_app_dialog_click_privacy", a.this.f21280k);
            }
        });
        this.f21275f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.5
            public AnonymousClass5() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                g.a("lp_app_dialog_click_giveup", a.this.f21280k);
            }
        });
        this.f21277h.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.a.6
            public AnonymousClass6() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.a("lp_app_dialog_click_download", a.this.f21280k);
                b.a().b(a.this.f21280k);
                a.this.dismiss();
            }
        });
    }
}
