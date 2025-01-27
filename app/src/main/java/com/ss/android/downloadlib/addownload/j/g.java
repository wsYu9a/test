package com.ss.android.downloadlib.addownload.j;

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
public class g extends Dialog {

    /* renamed from: g */
    private i f24172g;
    private Activity gv;

    /* renamed from: i */
    private TextView f24173i;

    /* renamed from: j */
    private TextView f24174j;
    private String k;
    private String lg;
    private boolean q;
    private String y;
    private TextView zx;

    /* renamed from: com.ss.android.downloadlib.addownload.j.g$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.q();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.j.g$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.gv();
        }
    }

    public static class j {

        /* renamed from: g */
        private String f24177g;
        private i gv;

        /* renamed from: i */
        private String f24178i;

        /* renamed from: j */
        private Activity f24179j;
        private boolean q;
        private String zx;

        public j(Activity activity) {
            this.f24179j = activity;
        }

        public j i(String str) {
            this.f24177g = str;
            return this;
        }

        public j j(String str) {
            this.zx = str;
            return this;
        }

        public j zx(String str) {
            this.f24178i = str;
            return this;
        }

        public j j(boolean z) {
            this.q = z;
            return this;
        }

        public j j(i iVar) {
            this.gv = iVar;
            return this;
        }

        public g j() {
            return new g(this.f24179j, this.zx, this.f24178i, this.f24177g, this.q, this.gv);
        }
    }

    public g(@NonNull Activity activity, String str, String str2, String str3, boolean z, @NonNull i iVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.gv = activity;
        this.f24172g = iVar;
        this.lg = str;
        this.y = str2;
        this.k = str3;
        setCanceledOnTouchOutside(z);
        g();
    }

    private void g() {
        setContentView(LayoutInflater.from(this.gv.getApplicationContext()).inflate(j(), (ViewGroup) null));
        this.f24174j = (TextView) findViewById(zx());
        this.zx = (TextView) findViewById(i());
        this.f24173i = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.y)) {
            this.f24174j.setText(this.y);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.zx.setText(this.k);
        }
        if (!TextUtils.isEmpty(this.lg)) {
            this.f24173i.setText(this.lg);
        }
        this.f24174j.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.j.g.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.q();
            }
        });
        this.zx.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.j.g.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.gv();
            }
        });
    }

    public void gv() {
        dismiss();
    }

    public void q() {
        this.q = true;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.gv.isFinishing()) {
            this.gv.finish();
        }
        if (this.q) {
            this.f24172g.j();
        } else {
            this.f24172g.zx();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int i() {
        return R.id.cancel_tv;
    }

    public int j() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int zx() {
        return R.id.confirm_tv;
    }
}
