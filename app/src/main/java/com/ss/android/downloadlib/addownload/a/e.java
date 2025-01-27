package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;

/* loaded from: classes4.dex */
public class e extends Dialog {

    /* renamed from: a */
    private TextView f21153a;

    /* renamed from: b */
    private TextView f21154b;

    /* renamed from: c */
    private TextView f21155c;

    /* renamed from: d */
    private TextView f21156d;

    /* renamed from: e */
    private d f21157e;

    /* renamed from: f */
    private c f21158f;

    /* renamed from: g */
    private boolean f21159g;

    /* renamed from: h */
    private boolean f21160h;

    /* renamed from: i */
    private Activity f21161i;

    /* renamed from: j */
    private String f21162j;

    /* renamed from: k */
    private String f21163k;

    /* renamed from: l */
    private String f21164l;

    /* renamed from: m */
    private String f21165m;

    /* renamed from: com.ss.android.downloadlib.addownload.a.e$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.e();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.a.e$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.g();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.a.e$3 */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f();
        }
    }

    public static class a {

        /* renamed from: a */
        private Activity f21169a;

        /* renamed from: b */
        private String f21170b;

        /* renamed from: c */
        private String f21171c;

        /* renamed from: d */
        private String f21172d;

        /* renamed from: e */
        private String f21173e;

        /* renamed from: f */
        private boolean f21174f;

        /* renamed from: g */
        private d f21175g;

        /* renamed from: h */
        private c f21176h;

        public a(Activity activity) {
            this.f21169a = activity;
        }

        public a a(String str) {
            this.f21170b = str;
            return this;
        }

        public a b(String str) {
            this.f21171c = str;
            return this;
        }

        public a c(String str) {
            this.f21172d = str;
            return this;
        }

        public a d(String str) {
            this.f21173e = str;
            return this;
        }

        public a a(boolean z10) {
            this.f21174f = z10;
            return this;
        }

        public a a(d dVar) {
            this.f21175g = dVar;
            return this;
        }

        public a a(c cVar) {
            this.f21176h = cVar;
            return this;
        }

        public e a() {
            return new e(this.f21169a, this.f21170b, this.f21171c, this.f21172d, this.f21173e, this.f21174f, this.f21175g, this.f21176h);
        }
    }

    public e(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z10, @NonNull d dVar, c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f21161i = activity;
        this.f21157e = dVar;
        this.f21162j = str;
        this.f21163k = str2;
        this.f21164l = str3;
        this.f21165m = str4;
        this.f21158f = cVar;
        setCanceledOnTouchOutside(z10);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f21161i.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.f21153a = (TextView) findViewById(b());
        this.f21154b = (TextView) findViewById(c());
        this.f21155c = (TextView) findViewById(R.id.message_tv);
        this.f21156d = (TextView) findViewById(R.id.delete_tv);
        if (!TextUtils.isEmpty(this.f21163k)) {
            this.f21153a.setText(this.f21163k);
        }
        if (!TextUtils.isEmpty(this.f21164l)) {
            this.f21154b.setText(this.f21164l);
        }
        if (TextUtils.isEmpty(this.f21165m)) {
            this.f21156d.setVisibility(8);
        } else {
            this.f21156d.setText(this.f21165m);
        }
        if (!TextUtils.isEmpty(this.f21162j)) {
            this.f21155c.setText(this.f21162j);
        }
        this.f21153a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.e.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.e();
            }
        });
        this.f21154b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.e.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.g();
            }
        });
        this.f21156d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.e.3
            public AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.f();
            }
        });
    }

    public void e() {
        this.f21159g = true;
        dismiss();
    }

    public void f() {
        this.f21160h = true;
        dismiss();
    }

    public void g() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f21161i.isFinishing()) {
            this.f21161i.finish();
        }
        if (this.f21159g) {
            this.f21157e.a();
        } else if (this.f21160h) {
            this.f21158f.a();
        } else {
            this.f21157e.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int a() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int b() {
        return R.id.confirm_tv;
    }

    public int c() {
        return R.id.cancel_tv;
    }
}
