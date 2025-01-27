package com.google.android.material.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static final String f7226a = "TextAppearance";

    /* renamed from: b */
    private static final int f7227b = 1;

    /* renamed from: c */
    private static final int f7228c = 2;

    /* renamed from: d */
    private static final int f7229d = 3;

    /* renamed from: e */
    public final float f7230e;

    /* renamed from: f */
    @Nullable
    public final ColorStateList f7231f;

    /* renamed from: g */
    @Nullable
    public final ColorStateList f7232g;

    /* renamed from: h */
    @Nullable
    public final ColorStateList f7233h;

    /* renamed from: i */
    public final int f7234i;

    /* renamed from: j */
    public final int f7235j;

    @Nullable
    public final String k;
    public final boolean l;

    @Nullable
    public final ColorStateList m;
    public final float n;
    public final float o;
    public final float p;

    @FontRes
    private final int q;
    private boolean r = false;
    private Typeface s;

    class a extends ResourcesCompat.FontCallback {

        /* renamed from: a */
        final /* synthetic */ f f7236a;

        a(f fVar) {
            this.f7236a = fVar;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i2) {
            d.this.r = true;
            this.f7236a.a(i2);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            d dVar = d.this;
            dVar.s = Typeface.create(typeface, dVar.f7234i);
            d.this.r = true;
            this.f7236a.b(d.this.s, false);
        }
    }

    class b extends f {

        /* renamed from: a */
        final /* synthetic */ TextPaint f7238a;

        /* renamed from: b */
        final /* synthetic */ f f7239b;

        b(TextPaint textPaint, f fVar) {
            this.f7238a = textPaint;
            this.f7239b = fVar;
        }

        @Override // com.google.android.material.g.f
        public void a(int i2) {
            this.f7239b.a(i2);
        }

        @Override // com.google.android.material.g.f
        public void b(@NonNull Typeface typeface, boolean z) {
            d.this.k(this.f7238a, typeface);
            this.f7239b.b(typeface, z);
        }
    }

    public d(@NonNull Context context, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.f7230e = obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.f7231f = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.f7232g = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f7233h = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f7234i = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f7235j = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int e2 = c.e(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.q = obtainStyledAttributes.getResourceId(e2, 0);
        this.k = obtainStyledAttributes.getString(e2);
        this.l = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.m = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.n = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.o = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.p = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private void d() {
        String str;
        if (this.s == null && (str = this.k) != null) {
            this.s = Typeface.create(str, this.f7234i);
        }
        if (this.s == null) {
            int i2 = this.f7235j;
            if (i2 == 1) {
                this.s = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.s = Typeface.SERIF;
            } else if (i2 != 3) {
                this.s = Typeface.DEFAULT;
            } else {
                this.s = Typeface.MONOSPACE;
            }
            this.s = Typeface.create(this.s, this.f7234i);
        }
    }

    public Typeface e() {
        d();
        return this.s;
    }

    @NonNull
    @VisibleForTesting
    public Typeface f(@NonNull Context context) {
        if (this.r) {
            return this.s;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.q);
                this.s = font;
                if (font != null) {
                    this.s = Typeface.create(font, this.f7234i);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d(f7226a, "Error loading font " + this.k, e2);
            }
        }
        d();
        this.r = true;
        return this.s;
    }

    public void g(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        k(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(@NonNull Context context, @NonNull f fVar) {
        if (e.b()) {
            f(context);
        } else {
            d();
        }
        int i2 = this.q;
        if (i2 == 0) {
            this.r = true;
        }
        if (this.r) {
            fVar.b(this.s, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i2, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.r = true;
            fVar.a(1);
        } catch (Exception e2) {
            Log.d(f7226a, "Error loading font " + this.k, e2);
            this.r = true;
            fVar.a(-3);
        }
    }

    public void i(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        j(context, textPaint, fVar);
        ColorStateList colorStateList = this.f7231f;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.p;
        float f3 = this.n;
        float f4 = this.o;
        ColorStateList colorStateList2 = this.m;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void j(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        if (e.b()) {
            k(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void k(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ (-1)) & this.f7234i;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f7230e);
    }
}
