package com.google.android.material.g;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a */
    private final Typeface f7223a;

    /* renamed from: b */
    private final InterfaceC0091a f7224b;

    /* renamed from: c */
    private boolean f7225c;

    /* renamed from: com.google.android.material.g.a$a */
    public interface InterfaceC0091a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0091a interfaceC0091a, Typeface typeface) {
        this.f7223a = typeface;
        this.f7224b = interfaceC0091a;
    }

    private void d(Typeface typeface) {
        if (this.f7225c) {
            return;
        }
        this.f7224b.a(typeface);
    }

    @Override // com.google.android.material.g.f
    public void a(int i2) {
        d(this.f7223a);
    }

    @Override // com.google.android.material.g.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.f7225c = true;
    }
}
