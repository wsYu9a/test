package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
class o extends BaseAdapter {

    /* renamed from: a */
    static final int f7078a = w.v().getMaximum(4);

    /* renamed from: b */
    final n f7079b;

    /* renamed from: c */
    final f<?> f7080c;

    /* renamed from: d */
    c f7081d;

    /* renamed from: e */
    final a f7082e;

    o(n nVar, f<?> fVar, a aVar) {
        this.f7079b = nVar;
        this.f7080c = fVar;
        this.f7082e = aVar;
    }

    private void e(Context context) {
        if (this.f7081d == null) {
            this.f7081d = new c(context);
        }
    }

    int a(int i2) {
        return b() + (i2 - 1);
    }

    int b() {
        return this.f7079b.f();
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: c */
    public Long getItem(int i2) {
        if (i2 < this.f7079b.f() || i2 > h()) {
            return null;
        }
        return Long.valueOf(this.f7079b.g(i(i2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            r8 = 1
            if (r7 < 0) goto L61
            com.google.android.material.datepicker.n r2 = r5.f7079b
            int r3 = r2.f7076f
            if (r7 < r3) goto L2e
            goto L61
        L2e:
            int r7 = r7 + r8
            r0.setTag(r2)
            java.lang.String r2 = java.lang.String.valueOf(r7)
            r0.setText(r2)
            com.google.android.material.datepicker.n r2 = r5.f7079b
            long r2 = r2.g(r7)
            com.google.android.material.datepicker.n r7 = r5.f7079b
            int r7 = r7.f7074d
            com.google.android.material.datepicker.n r4 = com.google.android.material.datepicker.n.e()
            int r4 = r4.f7074d
            if (r7 != r4) goto L53
            java.lang.String r7 = com.google.android.material.datepicker.g.g(r2)
            r0.setContentDescription(r7)
            goto L5a
        L53:
            java.lang.String r7 = com.google.android.material.datepicker.g.k(r2)
            r0.setContentDescription(r7)
        L5a:
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            goto L69
        L61:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L69:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L70
            return r0
        L70:
            com.google.android.material.datepicker.a r7 = r5.f7082e
            com.google.android.material.datepicker.a$c r7 = r7.g()
            long r2 = r6.longValue()
            boolean r7 = r7.c(r2)
            if (r7 == 0) goto Ld5
            r0.setEnabled(r8)
            com.google.android.material.datepicker.f<?> r7 = r5.f7080c
            java.util.Collection r7 = r7.h0()
            java.util.Iterator r7 = r7.iterator()
        L8d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lb5
            java.lang.Object r8 = r7.next()
            java.lang.Long r8 = (java.lang.Long) r8
            long r1 = r8.longValue()
            long r3 = r6.longValue()
            long r3 = com.google.android.material.datepicker.w.a(r3)
            long r1 = com.google.android.material.datepicker.w.a(r1)
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 != 0) goto L8d
            com.google.android.material.datepicker.c r6 = r5.f7081d
            com.google.android.material.datepicker.b r6 = r6.f7025b
            r6.f(r0)
            return r0
        Lb5:
            java.util.Calendar r7 = com.google.android.material.datepicker.w.t()
            long r7 = r7.getTimeInMillis()
            long r1 = r6.longValue()
            int r6 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r6 != 0) goto Lcd
            com.google.android.material.datepicker.c r6 = r5.f7081d
            com.google.android.material.datepicker.b r6 = r6.f7026c
            r6.f(r0)
            return r0
        Lcd:
            com.google.android.material.datepicker.c r6 = r5.f7081d
            com.google.android.material.datepicker.b r6 = r6.f7024a
            r6.f(r0)
            return r0
        Ld5:
            r0.setEnabled(r1)
            com.google.android.material.datepicker.c r6 = r5.f7081d
            com.google.android.material.datepicker.b r6 = r6.f7030g
            r6.f(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.o.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    boolean f(int i2) {
        return i2 % this.f7079b.f7075e == 0;
    }

    boolean g(int i2) {
        return (i2 + 1) % this.f7079b.f7075e == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7079b.f7076f + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.f7079b.f7075e;
    }

    int h() {
        return (this.f7079b.f() + this.f7079b.f7076f) - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i(int i2) {
        return (i2 - this.f7079b.f()) + 1;
    }

    boolean j(int i2) {
        return i2 >= b() && i2 <= h();
    }
}
