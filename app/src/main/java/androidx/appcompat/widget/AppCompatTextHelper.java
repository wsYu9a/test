package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.AutoSizeableTextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AppCompatTextHelper {

    /* renamed from: a */
    private static final int f764a = -1;

    /* renamed from: b */
    private static final int f765b = 1;

    /* renamed from: c */
    private static final int f766c = 2;

    /* renamed from: d */
    private static final int f767d = 3;

    /* renamed from: e */
    private final TextView f768e;

    /* renamed from: f */
    private TintInfo f769f;

    /* renamed from: g */
    private TintInfo f770g;

    /* renamed from: h */
    private TintInfo f771h;

    /* renamed from: i */
    private TintInfo f772i;

    /* renamed from: j */
    private TintInfo f773j;
    private TintInfo k;
    private TintInfo l;

    @NonNull
    private final AppCompatTextViewAutoSizeHelper m;
    private int n = 0;
    private int o = -1;
    private Typeface p;
    private boolean q;

    private static class ApplyTextViewCallback extends ResourcesCompat.FontCallback {

        /* renamed from: a */
        private final WeakReference<AppCompatTextHelper> f774a;

        /* renamed from: b */
        private final int f775b;

        /* renamed from: c */
        private final int f776c;

        private class TypefaceApplyCallback implements Runnable {

            /* renamed from: a */
            private final WeakReference<AppCompatTextHelper> f777a;

            /* renamed from: b */
            private final Typeface f778b;

            TypefaceApplyCallback(@NonNull WeakReference<AppCompatTextHelper> weakReference, @NonNull Typeface typeface) {
                this.f777a = weakReference;
                this.f778b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                AppCompatTextHelper appCompatTextHelper = this.f777a.get();
                if (appCompatTextHelper == null) {
                    return;
                }
                appCompatTextHelper.setTypefaceByCallback(this.f778b);
            }
        }

        ApplyTextViewCallback(@NonNull AppCompatTextHelper appCompatTextHelper, int i2, int i3) {
            this.f774a = new WeakReference<>(appCompatTextHelper);
            this.f775b = i2;
            this.f776c = i3;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i2) {
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            int i2;
            AppCompatTextHelper appCompatTextHelper = this.f774a.get();
            if (appCompatTextHelper == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.f775b) != -1) {
                typeface = Typeface.create(typeface, i2, (this.f776c & 2) != 0);
            }
            appCompatTextHelper.runOnUiThread(new TypefaceApplyCallback(this.f774a, typeface));
        }
    }

    AppCompatTextHelper(TextView textView) {
        this.f768e = textView;
        this.m = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void A(Context context, TintTypedArray tintTypedArray) {
        String string;
        this.n = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.n);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.o = i3;
            if (i3 != -1) {
                this.n = (this.n & 2) | 0;
            }
        }
        int i4 = R.styleable.TextAppearance_android_fontFamily;
        if (!tintTypedArray.hasValue(i4) && !tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            int i5 = R.styleable.TextAppearance_android_typeface;
            if (tintTypedArray.hasValue(i5)) {
                this.q = false;
                int i6 = tintTypedArray.getInt(i5, 1);
                if (i6 == 1) {
                    this.p = Typeface.SANS_SERIF;
                    return;
                } else if (i6 == 2) {
                    this.p = Typeface.SERIF;
                    return;
                } else {
                    if (i6 != 3) {
                        return;
                    }
                    this.p = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.p = null;
        int i7 = R.styleable.TextAppearance_fontFamily;
        if (tintTypedArray.hasValue(i7)) {
            i4 = i7;
        }
        int i8 = this.o;
        int i9 = this.n;
        if (!context.isRestricted()) {
            try {
                Typeface font = tintTypedArray.getFont(i4, this.n, new ApplyTextViewCallback(this, i8, i9));
                if (font != null) {
                    if (i2 < 28 || this.o == -1) {
                        this.p = font;
                    } else {
                        this.p = Typeface.create(Typeface.create(font, 0), this.o, (this.n & 2) != 0);
                    }
                }
                this.q = this.p == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.p != null || (string = tintTypedArray.getString(i4)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.o == -1) {
            this.p = Typeface.create(string, this.n);
        } else {
            this.p = Typeface.create(Typeface.create(string, 0), this.o, (this.n & 2) != 0);
        }
    }

    private void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        AppCompatDrawableManager.e(drawable, tintInfo, this.f768e.getDrawableState());
    }

    private static TintInfo d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i2) {
        ColorStateList c2 = appCompatDrawableManager.c(context, i2);
        if (c2 == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = c2;
        return tintInfo;
    }

    private void w(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f768e.getCompoundDrawablesRelative();
            TextView textView = this.f768e;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (i2 >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.f768e.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f768e;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f768e.getCompoundDrawables();
        TextView textView3 = this.f768e;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void x() {
        TintInfo tintInfo = this.l;
        this.f769f = tintInfo;
        this.f770g = tintInfo;
        this.f771h = tintInfo;
        this.f772i = tintInfo;
        this.f773j = tintInfo;
        this.k = tintInfo;
    }

    private void z(int i2, float f2) {
        this.m.y(i2, f2);
    }

    void b() {
        if (this.f769f != null || this.f770g != null || this.f771h != null || this.f772i != null) {
            Drawable[] compoundDrawables = this.f768e.getCompoundDrawables();
            a(compoundDrawables[0], this.f769f);
            a(compoundDrawables[1], this.f770g);
            a(compoundDrawables[2], this.f771h);
            a(compoundDrawables[3], this.f772i);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f773j == null && this.k == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f768e.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f773j);
            a(compoundDrawablesRelative[2], this.k);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void c() {
        this.m.b();
    }

    int e() {
        return this.m.j();
    }

    int f() {
        return this.m.k();
    }

    int g() {
        return this.m.l();
    }

    int[] h() {
        return this.m.m();
    }

    int i() {
        return this.m.n();
    }

    @Nullable
    ColorStateList j() {
        TintInfo tintInfo = this.l;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    @Nullable
    PorterDuff.Mode k() {
        TintInfo tintInfo = this.l;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean l() {
        return this.m.s();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d9  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m(android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.m(android.util.AttributeSet, int):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void n(boolean z, int i2, int i3, int i4, int i5) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return;
        }
        c();
    }

    void o() {
        b();
    }

    void p(Context context, int i2) {
        String string;
        ColorStateList colorStateList;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i2, R.styleable.TextAppearance);
        int i3 = R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i3)) {
            q(obtainStyledAttributes.getBoolean(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = R.styleable.TextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i5) && (colorStateList = obtainStyledAttributes.getColorStateList(i5)) != null) {
                this.f768e.setTextColor(colorStateList);
            }
        }
        int i6 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i6) && obtainStyledAttributes.getDimensionPixelSize(i6, -1) == 0) {
            this.f768e.setTextSize(0, 0.0f);
        }
        A(context, obtainStyledAttributes);
        if (i4 >= 26) {
            int i7 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i7) && (string = obtainStyledAttributes.getString(i7)) != null) {
                this.f768e.setFontVariationSettings(string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.p;
        if (typeface != null) {
            this.f768e.setTypeface(typeface, this.n);
        }
    }

    void q(boolean z) {
        this.f768e.setAllCaps(z);
    }

    void r(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.m.u(i2, i3, i4, i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void runOnUiThread(@NonNull Runnable runnable) {
        this.f768e.post(runnable);
    }

    void s(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        this.m.v(iArr, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setTypefaceByCallback(@NonNull Typeface typeface) {
        if (this.q) {
            this.f768e.setTypeface(typeface);
            this.p = typeface;
        }
    }

    void t(int i2) {
        this.m.w(i2);
    }

    void u(@Nullable ColorStateList colorStateList) {
        if (this.l == null) {
            this.l = new TintInfo();
        }
        TintInfo tintInfo = this.l;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        x();
    }

    void v(@Nullable PorterDuff.Mode mode) {
        if (this.l == null) {
            this.l = new TintInfo();
        }
        TintInfo tintInfo = this.l;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        x();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void y(int i2, float f2) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE || l()) {
            return;
        }
        z(i2, f2);
    }
}
