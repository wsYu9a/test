package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private Toast f29851a;

    /* renamed from: b */
    private Context f29852b;

    public f(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        this.f29852b = context.getApplicationContext();
    }

    public void a(String str) {
        if (this.f29852b == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = this.f29851a;
        if (toast != null) {
            toast.cancel();
            this.f29851a = null;
        }
        this.f29851a = new Toast(this.f29852b);
        TextView textView = new TextView(this.f29852b);
        textView.setBackground(y0.b(this.f29852b));
        textView.setText(str);
        textView.setTextSize(1, 14.0f);
        int a2 = com.vivo.mobilead.util.m.a(this.f29852b, 8.0f);
        int a3 = com.vivo.mobilead.util.m.a(this.f29852b, 16.0f);
        textView.setPadding(a3, a2, a3, a2);
        textView.setTextColor(-1);
        this.f29851a.setView(textView);
        this.f29851a.setDuration(0);
        this.f29851a.setGravity(48, 0, (int) (com.vivo.mobilead.util.m.d(this.f29852b) * 0.06f));
        this.f29851a.show();
    }

    public void a() {
        Toast toast = this.f29851a;
        if (toast != null) {
            toast.cancel();
            this.f29851a = null;
        }
    }
}
