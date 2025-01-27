package com.vivo.mobilead.g;

import android.view.View;

/* loaded from: classes4.dex */
public abstract class c implements View.OnClickListener {

    /* renamed from: a */
    private long f28845a = 300;

    /* renamed from: b */
    private long f28846b = 0;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f28846b > this.f28845a) {
            a(view);
            this.f28846b = currentTimeMillis;
        }
    }
}
