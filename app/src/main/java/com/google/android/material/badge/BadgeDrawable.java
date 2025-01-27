package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.g.c;
import com.google.android.material.g.d;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.j.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements l.b {

    /* renamed from: a */
    public static final int f6712a = 8388661;

    /* renamed from: b */
    public static final int f6713b = 8388659;

    /* renamed from: c */
    public static final int f6714c = 8388693;

    /* renamed from: d */
    public static final int f6715d = 8388691;

    /* renamed from: e */
    private static final int f6716e = 4;

    /* renamed from: f */
    private static final int f6717f = -1;

    /* renamed from: g */
    private static final int f6718g = 9;

    /* renamed from: h */
    @StyleRes
    private static final int f6719h = R.style.Widget_MaterialComponents_Badge;

    /* renamed from: i */
    @AttrRes
    private static final int f6720i = R.attr.badgeStyle;

    /* renamed from: j */
    static final String f6721j = "+";

    @NonNull
    private final WeakReference<Context> k;

    @NonNull
    private final j l;

    @NonNull
    private final l m;

    @NonNull
    private final Rect n;
    private final float o;
    private final float p;
    private final float q;

    @NonNull
    private final SavedState r;
    private float s;
    private float t;
    private int u;
    private float v;
    private float w;
    private float x;

    @Nullable
    private WeakReference<View> y;

    @Nullable
    private WeakReference<ViewGroup> z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private BadgeDrawable(@NonNull Context context) {
        this.k = new WeakReference<>(context);
        n.c(context);
        Resources resources = context.getResources();
        this.n = new Rect();
        this.l = new j();
        this.o = resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.q = resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.p = resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        l lVar = new l(this);
        this.m = lVar;
        lVar.e().setTextAlign(Paint.Align.CENTER);
        this.r = new SavedState(context);
        G(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void F(@Nullable d dVar) {
        Context context;
        if (this.m.d() == dVar || (context = this.k.get()) == null) {
            return;
        }
        this.m.i(dVar, context);
        K();
    }

    private void G(@StyleRes int i2) {
        Context context = this.k.get();
        if (context == null) {
            return;
        }
        F(new d(context, i2));
    }

    private void K() {
        Context context = this.k.get();
        WeakReference<View> weakReference = this.y;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.n);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<ViewGroup> weakReference2 = this.z;
        ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
        if (viewGroup != null || com.google.android.material.badge.a.f6732a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        b(context, rect2, view);
        com.google.android.material.badge.a.f(this.n, this.s, this.t, this.w, this.x);
        this.l.j0(this.v);
        if (rect.equals(this.n)) {
            return;
        }
        this.l.setBounds(this.n);
    }

    private void L() {
        Double.isNaN(o());
        this.u = ((int) Math.pow(10.0d, r0 - 1.0d)) - 1;
    }

    private void b(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i2 = this.r.f6730i;
        if (i2 == 8388691 || i2 == 8388693) {
            this.t = rect.bottom - this.r.k;
        } else {
            this.t = rect.top + this.r.k;
        }
        if (p() <= 9) {
            float f2 = !s() ? this.o : this.p;
            this.v = f2;
            this.x = f2;
            this.w = f2;
        } else {
            float f3 = this.p;
            this.v = f3;
            this.x = f3;
            this.w = (this.m.f(k()) / 2.0f) + this.q;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(s() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int i3 = this.r.f6730i;
        if (i3 == 8388659 || i3 == 8388691) {
            this.s = ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.w) + dimensionPixelSize + this.r.f6731j : ((rect.right + this.w) - dimensionPixelSize) - this.r.f6731j;
        } else {
            this.s = ViewCompat.getLayoutDirection(view) == 0 ? ((rect.right + this.w) - dimensionPixelSize) - this.r.f6731j : (rect.left - this.w) + dimensionPixelSize + this.r.f6731j;
        }
    }

    @NonNull
    public static BadgeDrawable d(@NonNull Context context) {
        return e(context, null, f6720i, f6719h);
    }

    @NonNull
    private static BadgeDrawable e(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.t(context, attributeSet, i2, i3);
        return badgeDrawable;
    }

    @NonNull
    public static BadgeDrawable f(@NonNull Context context, @XmlRes int i2) {
        AttributeSet a2 = com.google.android.material.d.a.a(context, i2, "badge");
        int styleAttribute = a2.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = f6719h;
        }
        return e(context, a2, f6720i, styleAttribute);
    }

    @NonNull
    static BadgeDrawable g(@NonNull Context context, @NonNull SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.v(savedState);
        return badgeDrawable;
    }

    private void h(Canvas canvas) {
        Rect rect = new Rect();
        String k = k();
        this.m.e().getTextBounds(k, 0, k.length(), rect);
        canvas.drawText(k, this.s, this.t + (rect.height() / 2), this.m.e());
    }

    @NonNull
    private String k() {
        if (p() <= this.u) {
            return Integer.toString(p());
        }
        Context context = this.k.get();
        return context == null ? "" : context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.u), f6721j);
    }

    private void t(Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray j2 = n.j(context, attributeSet, R.styleable.Badge, i2, i3, new int[0]);
        D(j2.getInt(R.styleable.Badge_maxCharacterCount, 4));
        int i4 = R.styleable.Badge_number;
        if (j2.hasValue(i4)) {
            E(j2.getInt(i4, 0));
        }
        w(u(context, j2, R.styleable.Badge_backgroundColor));
        int i5 = R.styleable.Badge_badgeTextColor;
        if (j2.hasValue(i5)) {
            y(u(context, j2, i5));
        }
        x(j2.getInt(R.styleable.Badge_badgeGravity, f6712a));
        C(j2.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        H(j2.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        j2.recycle();
    }

    private static int u(Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        return c.a(context, typedArray, i2).getDefaultColor();
    }

    private void v(@NonNull SavedState savedState) {
        D(savedState.f6726e);
        if (savedState.f6725d != -1) {
            E(savedState.f6725d);
        }
        w(savedState.f6722a);
        y(savedState.f6723b);
        x(savedState.f6730i);
        C(savedState.f6731j);
        H(savedState.k);
    }

    public void A(CharSequence charSequence) {
        this.r.f6727f = charSequence;
    }

    public void B(@StringRes int i2) {
        this.r.f6728g = i2;
    }

    public void C(int i2) {
        this.r.f6731j = i2;
        K();
    }

    public void D(int i2) {
        if (this.r.f6726e != i2) {
            this.r.f6726e = i2;
            L();
            this.m.j(true);
            K();
            invalidateSelf();
        }
    }

    public void E(int i2) {
        int max = Math.max(0, i2);
        if (this.r.f6725d != max) {
            this.r.f6725d = max;
            this.m.j(true);
            K();
            invalidateSelf();
        }
    }

    public void H(int i2) {
        this.r.k = i2;
        K();
    }

    public void I(boolean z) {
        setVisible(z, false);
    }

    public void J(@NonNull View view, @Nullable ViewGroup viewGroup) {
        this.y = new WeakReference<>(view);
        this.z = new WeakReference<>(viewGroup);
        K();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.l.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    public void c() {
        this.r.f6725d = -1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.l.draw(canvas);
        if (s()) {
            h(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.r.f6724c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.n.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.n.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @ColorInt
    public int i() {
        return this.l.y().getDefaultColor();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int j() {
        return this.r.f6730i;
    }

    @ColorInt
    public int l() {
        return this.m.e().getColor();
    }

    @Nullable
    public CharSequence m() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!s()) {
            return this.r.f6727f;
        }
        if (this.r.f6728g <= 0 || (context = this.k.get()) == null) {
            return null;
        }
        return p() <= this.u ? context.getResources().getQuantityString(this.r.f6728g, p(), Integer.valueOf(p())) : context.getString(this.r.f6729h, Integer.valueOf(this.u));
    }

    public int n() {
        return this.r.f6731j;
    }

    public int o() {
        return this.r.f6726e;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.l.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public int p() {
        if (s()) {
            return this.r.f6725d;
        }
        return 0;
    }

    @NonNull
    public SavedState q() {
        return this.r;
    }

    public int r() {
        return this.r.k;
    }

    public boolean s() {
        return this.r.f6725d != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.r.f6724c = i2;
        this.m.e().setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void w(@ColorInt int i2) {
        this.r.f6722a = i2;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (this.l.y() != valueOf) {
            this.l.n0(valueOf);
            invalidateSelf();
        }
    }

    public void x(int i2) {
        if (this.r.f6730i != i2) {
            this.r.f6730i = i2;
            WeakReference<View> weakReference = this.y;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.y.get();
            WeakReference<ViewGroup> weakReference2 = this.z;
            J(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void y(@ColorInt int i2) {
        this.r.f6723b = i2;
        if (this.m.e().getColor() != i2) {
            this.m.e().setColor(i2);
            invalidateSelf();
        }
    }

    public void z(@StringRes int i2) {
        this.r.f6729h = i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a */
        @ColorInt
        private int f6722a;

        /* renamed from: b */
        @ColorInt
        private int f6723b;

        /* renamed from: c */
        private int f6724c;

        /* renamed from: d */
        private int f6725d;

        /* renamed from: e */
        private int f6726e;

        /* renamed from: f */
        @Nullable
        private CharSequence f6727f;

        /* renamed from: g */
        @PluralsRes
        private int f6728g;

        /* renamed from: h */
        @StringRes
        private int f6729h;

        /* renamed from: i */
        private int f6730i;

        /* renamed from: j */
        @Dimension(unit = 1)
        private int f6731j;

        @Dimension(unit = 1)
        private int k;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(@NonNull Context context) {
            this.f6724c = 255;
            this.f6725d = -1;
            this.f6723b = new d(context, R.style.TextAppearance_MaterialComponents_Badge).f7231f.getDefaultColor();
            this.f6727f = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.f6728g = R.plurals.mtrl_badge_content_description;
            this.f6729h = R.string.mtrl_exceed_max_badge_number_content_description;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.f6722a);
            parcel.writeInt(this.f6723b);
            parcel.writeInt(this.f6724c);
            parcel.writeInt(this.f6725d);
            parcel.writeInt(this.f6726e);
            parcel.writeString(this.f6727f.toString());
            parcel.writeInt(this.f6728g);
            parcel.writeInt(this.f6730i);
            parcel.writeInt(this.f6731j);
            parcel.writeInt(this.k);
        }

        protected SavedState(@NonNull Parcel parcel) {
            this.f6724c = 255;
            this.f6725d = -1;
            this.f6722a = parcel.readInt();
            this.f6723b = parcel.readInt();
            this.f6724c = parcel.readInt();
            this.f6725d = parcel.readInt();
            this.f6726e = parcel.readInt();
            this.f6727f = parcel.readString();
            this.f6728g = parcel.readInt();
            this.f6730i = parcel.readInt();
            this.f6731j = parcel.readInt();
            this.k = parcel.readInt();
        }
    }
}
