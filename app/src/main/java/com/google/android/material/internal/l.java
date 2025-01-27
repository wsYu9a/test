package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class l {

    /* renamed from: c */
    private float f7367c;

    /* renamed from: f */
    @Nullable
    private com.google.android.material.g.d f7370f;

    /* renamed from: a */
    private final TextPaint f7365a = new TextPaint(1);

    /* renamed from: b */
    private final com.google.android.material.g.f f7366b = new a();

    /* renamed from: d */
    private boolean f7368d = true;

    /* renamed from: e */
    @Nullable
    private WeakReference<b> f7369e = new WeakReference<>(null);

    class a extends com.google.android.material.g.f {
        a() {
        }

        @Override // com.google.android.material.g.f
        public void a(int i2) {
            l.this.f7368d = true;
            b bVar = (b) l.this.f7369e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.google.android.material.g.f
        public void b(@NonNull Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            l.this.f7368d = true;
            b bVar = (b) l.this.f7369e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public l(@Nullable b bVar) {
        h(bVar);
    }

    private float c(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f7365a.measureText(charSequence, 0, charSequence.length());
    }

    @Nullable
    public com.google.android.material.g.d d() {
        return this.f7370f;
    }

    @NonNull
    public TextPaint e() {
        return this.f7365a;
    }

    public float f(String str) {
        if (!this.f7368d) {
            return this.f7367c;
        }
        float c2 = c(str);
        this.f7367c = c2;
        this.f7368d = false;
        return c2;
    }

    public boolean g() {
        return this.f7368d;
    }

    public void h(@Nullable b bVar) {
        this.f7369e = new WeakReference<>(bVar);
    }

    public void i(@Nullable com.google.android.material.g.d dVar, Context context) {
        if (this.f7370f != dVar) {
            this.f7370f = dVar;
            if (dVar != null) {
                dVar.j(context, this.f7365a, this.f7366b);
                b bVar = this.f7369e.get();
                if (bVar != null) {
                    this.f7365a.drawableState = bVar.getState();
                }
                dVar.i(context, this.f7365a, this.f7366b);
                this.f7368d = true;
            }
            b bVar2 = this.f7369e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void j(boolean z) {
        this.f7368d = z;
    }

    public void k(Context context) {
        this.f7370f.i(context, this.f7365a, this.f7366b);
    }
}
