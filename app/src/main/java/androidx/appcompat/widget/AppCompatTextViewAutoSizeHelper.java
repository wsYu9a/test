package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class AppCompatTextViewAutoSizeHelper {

    /* renamed from: a */
    private static final String f784a = "ACTVAutoSizeHelper";

    /* renamed from: c */
    private static final int f786c = 12;

    /* renamed from: d */
    private static final int f787d = 112;

    /* renamed from: e */
    private static final int f788e = 1;

    /* renamed from: h */
    static final float f791h = -1.0f;

    /* renamed from: i */
    private static final int f792i = 1048576;

    /* renamed from: j */
    private int f793j = 0;
    private boolean k = false;
    private float l = -1.0f;
    private float m = -1.0f;
    private float n = -1.0f;
    private int[] o = new int[0];
    private boolean p = false;
    private TextPaint q;
    private final TextView r;
    private final Context s;

    /* renamed from: b */
    private static final RectF f785b = new RectF();

    /* renamed from: f */
    private static ConcurrentHashMap<String, Method> f789f = new ConcurrentHashMap<>();

    /* renamed from: g */
    private static ConcurrentHashMap<String, Field> f790g = new ConcurrentHashMap<>();

    AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.r = textView;
        this.s = textView.getContext();
    }

    private void A(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.o = c(iArr);
            B();
        }
    }

    private boolean B() {
        boolean z = this.o.length > 0;
        this.p = z;
        if (z) {
            this.f793j = 1;
            this.m = r0[0];
            this.n = r0[r1 - 1];
            this.l = -1.0f;
        }
        return z;
    }

    private boolean C(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.r.getText();
        TransformationMethod transformationMethod = this.r.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.r)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.r.getMaxLines() : -1;
        q(i2);
        StaticLayout e2 = e(text, (Layout.Alignment) r(this.r, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (e2.getLineCount() <= maxLines && e2.getLineEnd(e2.getLineCount() - 1) == text.length())) && ((float) e2.getHeight()) <= rectF.bottom;
    }

    private boolean D() {
        return !(this.r instanceof AppCompatEditText);
    }

    private void E(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
        this.f793j = 1;
        this.m = f2;
        this.n = f3;
        this.l = f4;
        this.p = false;
    }

    private static <T> T a(@NonNull Object obj, @NonNull String str, @NonNull T t) {
        try {
            Field o = o(str);
            return o == null ? t : (T) o.get(obj);
        } catch (IllegalAccessException e2) {
            Log.w(f784a, "Failed to access TextView#" + str + " member", e2);
            return t;
        }
    }

    private int[] c(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void d() {
        this.f793j = 0;
        this.m = -1.0f;
        this.n = -1.0f;
        this.l = -1.0f;
        this.o = new int[0];
        this.k = false;
    }

    @RequiresApi(23)
    private StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.q, i2);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.r.getLineSpacingExtra(), this.r.getLineSpacingMultiplier()).setIncludePad(this.r.getIncludeFontPadding()).setBreakStrategy(this.r.getBreakStrategy()).setHyphenationFrequency(this.r.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i3);
        try {
            obtain.setTextDirection(Build.VERSION.SDK_INT >= 29 ? this.r.getTextDirectionHeuristic() : (TextDirectionHeuristic) r(this.r, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        } catch (ClassCastException unused) {
            Log.w(f784a, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private StaticLayout g(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.q, i2, alignment, ((Float) a(this.r, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.r, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.r, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    @RequiresApi(16)
    private StaticLayout h(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.q, i2, alignment, this.r.getLineSpacingMultiplier(), this.r.getLineSpacingExtra(), this.r.getIncludeFontPadding());
    }

    private int i(RectF rectF) {
        int length = this.o.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = length - 1;
        int i3 = 1;
        int i4 = 0;
        while (i3 <= i2) {
            int i5 = (i3 + i2) / 2;
            if (C(this.o[i5], rectF)) {
                int i6 = i5 + 1;
                i4 = i3;
                i3 = i6;
            } else {
                i4 = i5 - 1;
                i2 = i4;
            }
        }
        return this.o[i4];
    }

    @Nullable
    private static Field o(@NonNull String str) {
        try {
            Field field = f790g.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f790g.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e2) {
            Log.w(f784a, "Failed to access TextView#" + str + " member", e2);
            return null;
        }
    }

    @Nullable
    private static Method p(@NonNull String str) {
        try {
            Method method = f789f.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f789f.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w(f784a, "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    private static <T> T r(@NonNull Object obj, @NonNull String str, @NonNull T t) {
        try {
            return (T) p(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w(f784a, "Failed to invoke TextView#" + str + "() method", e2);
            return t;
        }
    }

    private void x(float f2) {
        if (f2 != this.r.getPaint().getTextSize()) {
            this.r.getPaint().setTextSize(f2);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.r.isInLayout() : false;
            if (this.r.getLayout() != null) {
                this.k = false;
                try {
                    Method p = p("nullLayouts");
                    if (p != null) {
                        p.invoke(this.r, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w(f784a, "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (isInLayout) {
                    this.r.forceLayout();
                } else {
                    this.r.requestLayout();
                }
                this.r.invalidate();
            }
        }
    }

    private boolean z() {
        if (D() && this.f793j == 1) {
            if (!this.p || this.o.length == 0) {
                int floor = ((int) Math.floor((this.n - this.m) / this.l)) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round(this.m + (i2 * this.l));
                }
                this.o = c(iArr);
            }
            this.k = true;
        } else {
            this.k = false;
        }
        return this.k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void b() {
        if (s()) {
            if (this.k) {
                if (this.r.getMeasuredHeight() <= 0 || this.r.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = Build.VERSION.SDK_INT >= 29 ? this.r.isHorizontallyScrollable() : ((Boolean) r(this.r, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue() ? 1048576 : (this.r.getMeasuredWidth() - this.r.getTotalPaddingLeft()) - this.r.getTotalPaddingRight();
                int height = (this.r.getHeight() - this.r.getCompoundPaddingBottom()) - this.r.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f785b;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float i2 = i(rectF);
                    if (i2 != this.r.getTextSize()) {
                        y(0, i2);
                    }
                }
            }
            this.k = true;
        }
    }

    @VisibleForTesting
    StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= 23 ? f(charSequence, alignment, i2, i3) : i4 >= 16 ? h(charSequence, alignment, i2) : g(charSequence, alignment, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int j() {
        return Math.round(this.n);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int k() {
        return Math.round(this.m);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int l() {
        return Math.round(this.l);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int[] m() {
        return this.o;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    int n() {
        return this.f793j;
    }

    @VisibleForTesting
    void q(int i2) {
        TextPaint textPaint = this.q;
        if (textPaint == null) {
            this.q = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.q.set(this.r.getPaint());
        this.q.setTextSize(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean s() {
        return D() && this.f793j != 0;
    }

    void t(AttributeSet attributeSet, int i2) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.s.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i2, 0);
        int i3 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f793j = obtainStyledAttributes.getInt(i3, 0);
        }
        int i4 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = obtainStyledAttributes.hasValue(i4) ? obtainStyledAttributes.getDimension(i4, -1.0f) : -1.0f;
        int i5 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = obtainStyledAttributes.hasValue(i5) ? obtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = obtainStyledAttributes.hasValue(i6) ? obtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i7) && (resourceId = obtainStyledAttributes.getResourceId(i7, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            A(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!D()) {
            this.f793j = 0;
            return;
        }
        if (this.f793j == 1) {
            if (!this.p) {
                DisplayMetrics displayMetrics = this.s.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                E(dimension2, dimension3, dimension);
            }
            z();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void u(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (D()) {
            DisplayMetrics displayMetrics = this.s.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (z()) {
                b();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void v(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        if (D()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.s.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                this.o = c(iArr2);
                if (!B()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.p = false;
            }
            if (z()) {
                b();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void w(int i2) {
        if (D()) {
            if (i2 == 0) {
                d();
                return;
            }
            if (i2 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
            }
            DisplayMetrics displayMetrics = this.s.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (z()) {
                b();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void y(int i2, float f2) {
        Context context = this.s;
        x(TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
