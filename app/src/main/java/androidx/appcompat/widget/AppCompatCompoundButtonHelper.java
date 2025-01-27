package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

/* loaded from: classes.dex */
class AppCompatCompoundButtonHelper {

    /* renamed from: a */
    private final CompoundButton f693a;

    /* renamed from: b */
    private ColorStateList f694b = null;

    /* renamed from: c */
    private PorterDuff.Mode f695c = null;

    /* renamed from: d */
    private boolean f696d = false;

    /* renamed from: e */
    private boolean f697e = false;

    /* renamed from: f */
    private boolean f698f;

    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(Drawable drawable);
    }

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f693a = compoundButton;
    }

    void a() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f693a);
        if (buttonDrawable != null) {
            if (this.f696d || this.f697e) {
                Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.f696d) {
                    DrawableCompat.setTintList(mutate, this.f694b);
                }
                if (this.f697e) {
                    DrawableCompat.setTintMode(mutate, this.f695c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f693a.getDrawableState());
                }
                this.f693a.setButtonDrawable(mutate);
            }
        }
    }

    int b(int i2) {
        Drawable buttonDrawable;
        return (Build.VERSION.SDK_INT >= 17 || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f693a)) == null) ? i2 : i2 + buttonDrawable.getIntrinsicWidth();
    }

    ColorStateList c() {
        return this.f694b;
    }

    PorterDuff.Mode d() {
        return this.f695c;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d A[Catch: all -> 0x0074, TRY_ENTER, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002d, B:13:0x0035, B:15:0x003b, B:16:0x0048, B:18:0x0050, B:19:0x0059, B:21:0x0061), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[Catch: all -> 0x0074, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002d, B:13:0x0035, B:15:0x003b, B:16:0x0048, B:18:0x0050, B:19:0x0059, B:21:0x0061), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002d, B:13:0x0035, B:15:0x003b, B:16:0x0048, B:18:0x0050, B:19:0x0059, B:21:0x0061), top: B:2:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void e(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f693a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R.styleable.CompoundButton
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L74
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L2a
            int r5 = r4.getResourceId(r5, r2)     // Catch: java.lang.Throwable -> L74
            if (r5 == 0) goto L2a
            android.widget.CompoundButton r0 = r3.f693a     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L74
            android.content.Context r1 = r0.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L74
            android.graphics.drawable.Drawable r5 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r5)     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L74
            r0.setButtonDrawable(r5)     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L74
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            if (r5 != 0) goto L48
            int r5 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L74
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L48
            int r5 = r4.getResourceId(r5, r2)     // Catch: java.lang.Throwable -> L74
            if (r5 == 0) goto L48
            android.widget.CompoundButton r0 = r3.f693a     // Catch: java.lang.Throwable -> L74
            android.content.Context r1 = r0.getContext()     // Catch: java.lang.Throwable -> L74
            android.graphics.drawable.Drawable r5 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r5)     // Catch: java.lang.Throwable -> L74
            r0.setButtonDrawable(r5)     // Catch: java.lang.Throwable -> L74
        L48:
            int r5 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L74
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L59
            android.widget.CompoundButton r0 = r3.f693a     // Catch: java.lang.Throwable -> L74
            android.content.res.ColorStateList r5 = r4.getColorStateList(r5)     // Catch: java.lang.Throwable -> L74
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r0, r5)     // Catch: java.lang.Throwable -> L74
        L59:
            int r5 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L74
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L70
            android.widget.CompoundButton r0 = r3.f693a     // Catch: java.lang.Throwable -> L74
            r1 = -1
            int r5 = r4.getInt(r5, r1)     // Catch: java.lang.Throwable -> L74
            r1 = 0
            android.graphics.PorterDuff$Mode r5 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r5, r1)     // Catch: java.lang.Throwable -> L74
            androidx.core.widget.CompoundButtonCompat.setButtonTintMode(r0, r5)     // Catch: java.lang.Throwable -> L74
        L70:
            r4.recycle()
            return
        L74:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.e(android.util.AttributeSet, int):void");
    }

    void f() {
        if (this.f698f) {
            this.f698f = false;
        } else {
            this.f698f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) {
        this.f694b = colorStateList;
        this.f696d = true;
        a();
    }

    void h(@Nullable PorterDuff.Mode mode) {
        this.f695c = mode;
        this.f697e = true;
        a();
    }
}
