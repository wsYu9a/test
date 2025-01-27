package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {

    /* renamed from: a */
    private static final char f1927a = '\n';

    /* renamed from: b */
    private static final Object f1928b = new Object();

    /* renamed from: c */
    @NonNull
    @GuardedBy("sLock")
    private static Executor f1929c;

    /* renamed from: d */
    @NonNull
    private final Spannable f1930d;

    /* renamed from: e */
    @NonNull
    private final Params f1931e;

    /* renamed from: f */
    @NonNull
    private final int[] f1932f;

    /* renamed from: g */
    @Nullable
    private final PrecomputedText f1933g;

    private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        private static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {

            /* renamed from: a */
            private Params f1943a;

            /* renamed from: b */
            private CharSequence f1944b;

            PrecomputedTextCallback(@NonNull Params params, @NonNull CharSequence charSequence) {
                this.f1943a = params;
                this.f1944b = charSequence;
            }

            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.f1944b, this.f1943a);
            }
        }

        PrecomputedTextFutureTask(@NonNull Params params, @NonNull CharSequence charSequence) {
            super(new PrecomputedTextCallback(params, charSequence));
        }
    }

    private PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull Params params, @NonNull int[] iArr) {
        this.f1930d = new SpannableString(charSequence);
        this.f1931e = params;
        this.f1932f = iArr;
        this.f1933g = null;
    }

    @SuppressLint({"NewApi"})
    public static PrecomputedTextCompat create(@NonNull CharSequence charSequence, @NonNull Params params) {
        PrecomputedText.Params params2;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(params);
        try {
            TraceCompat.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params2 = params.f1938e) != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params2), params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                int indexOf = TextUtils.indexOf(charSequence, f1927a, i2, length);
                i2 = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i2));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
            }
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
            } else if (i4 >= 21) {
                new StaticLayout(charSequence, params.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return new PrecomputedTextCompat(charSequence, params, iArr);
        } finally {
            TraceCompat.endSection();
        }
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence charSequence, @NonNull Params params, @Nullable Executor executor) {
        PrecomputedTextFutureTask precomputedTextFutureTask = new PrecomputedTextFutureTask(params, charSequence);
        if (executor == null) {
            synchronized (f1928b) {
                if (f1929c == null) {
                    f1929c = Executors.newFixedThreadPool(1);
                }
                executor = f1929c;
            }
        }
        executor.execute(precomputedTextFutureTask);
        return precomputedTextFutureTask;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f1930d.charAt(i2);
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphCount() {
        return Build.VERSION.SDK_INT >= 29 ? this.f1933g.getParagraphCount() : this.f1932f.length;
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphEnd(@IntRange(from = 0) int i2) {
        Preconditions.checkArgumentInRange(i2, 0, getParagraphCount(), "paraIndex");
        return Build.VERSION.SDK_INT >= 29 ? this.f1933g.getParagraphEnd(i2) : this.f1932f[i2];
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphStart(@IntRange(from = 0) int i2) {
        Preconditions.checkArgumentInRange(i2, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f1933g.getParagraphStart(i2);
        }
        if (i2 == 0) {
            return 0;
        }
        return this.f1932f[i2 - 1];
    }

    @NonNull
    public Params getParams() {
        return this.f1931e;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.f1930d;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1930d.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1930d.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1930d.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f1933g.getSpans(i2, i3, cls) : (T[]) this.f1930d.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1930d.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f1930d.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1933g.removeSpan(obj);
        } else {
            this.f1930d.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1933g.setSpan(obj, i2, i3, i4);
        } else {
            this.f1930d.setSpan(obj, i2, i3, i4);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.f1930d.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.f1930d.toString();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull Params params) {
        this.f1930d = precomputedText;
        this.f1931e = params;
        this.f1932f = null;
        this.f1933g = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public static final class Params {

        /* renamed from: a */
        @NonNull
        private final TextPaint f1934a;

        /* renamed from: b */
        @Nullable
        private final TextDirectionHeuristic f1935b;

        /* renamed from: c */
        private final int f1936c;

        /* renamed from: d */
        private final int f1937d;

        /* renamed from: e */
        final PrecomputedText.Params f1938e;

        public static class Builder {

            /* renamed from: a */
            @NonNull
            private final TextPaint f1939a;

            /* renamed from: b */
            private TextDirectionHeuristic f1940b;

            /* renamed from: c */
            private int f1941c;

            /* renamed from: d */
            private int f1942d;

            public Builder(@NonNull TextPaint textPaint) {
                this.f1939a = textPaint;
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23) {
                    this.f1941c = 1;
                    this.f1942d = 1;
                } else {
                    this.f1942d = 0;
                    this.f1941c = 0;
                }
                if (i2 >= 18) {
                    this.f1940b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f1940b = null;
                }
            }

            @NonNull
            public Params build() {
                return new Params(this.f1939a, this.f1940b, this.f1941c, this.f1942d);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int i2) {
                this.f1941c = i2;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int i2) {
                this.f1942d = i2;
                return this;
            }

            @RequiresApi(18)
            public Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f1940b = textDirectionHeuristic;
                return this;
            }
        }

        @SuppressLint({"NewApi"})
        Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f1938e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f1938e = null;
            }
            this.f1934a = textPaint;
            this.f1935b = textDirectionHeuristic;
            this.f1936c = i2;
            this.f1937d = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (equalsWithoutTextDirection(params)) {
                return Build.VERSION.SDK_INT < 18 || this.f1935b == params.getTextDirection();
            }
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params params) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.f1936c != params.getBreakStrategy() || this.f1937d != params.getHyphenationFrequency())) || this.f1934a.getTextSize() != params.getTextPaint().getTextSize() || this.f1934a.getTextScaleX() != params.getTextPaint().getTextScaleX() || this.f1934a.getTextSkewX() != params.getTextPaint().getTextSkewX()) {
                return false;
            }
            if ((i2 >= 21 && (this.f1934a.getLetterSpacing() != params.getTextPaint().getLetterSpacing() || !TextUtils.equals(this.f1934a.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()))) || this.f1934a.getFlags() != params.getTextPaint().getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.f1934a.getTextLocales().equals(params.getTextPaint().getTextLocales())) {
                    return false;
                }
            } else if (i2 >= 17 && !this.f1934a.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                return false;
            }
            return this.f1934a.getTypeface() == null ? params.getTextPaint().getTypeface() == null : this.f1934a.getTypeface().equals(params.getTextPaint().getTypeface());
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            return this.f1936c;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.f1937d;
        }

        @Nullable
        @RequiresApi(18)
        public TextDirectionHeuristic getTextDirection() {
            return this.f1935b;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.f1934a;
        }

        public int hashCode() {
            int i2 = Build.VERSION.SDK_INT;
            return i2 >= 24 ? ObjectsCompat.hash(Float.valueOf(this.f1934a.getTextSize()), Float.valueOf(this.f1934a.getTextScaleX()), Float.valueOf(this.f1934a.getTextSkewX()), Float.valueOf(this.f1934a.getLetterSpacing()), Integer.valueOf(this.f1934a.getFlags()), this.f1934a.getTextLocales(), this.f1934a.getTypeface(), Boolean.valueOf(this.f1934a.isElegantTextHeight()), this.f1935b, Integer.valueOf(this.f1936c), Integer.valueOf(this.f1937d)) : i2 >= 21 ? ObjectsCompat.hash(Float.valueOf(this.f1934a.getTextSize()), Float.valueOf(this.f1934a.getTextScaleX()), Float.valueOf(this.f1934a.getTextSkewX()), Float.valueOf(this.f1934a.getLetterSpacing()), Integer.valueOf(this.f1934a.getFlags()), this.f1934a.getTextLocale(), this.f1934a.getTypeface(), Boolean.valueOf(this.f1934a.isElegantTextHeight()), this.f1935b, Integer.valueOf(this.f1936c), Integer.valueOf(this.f1937d)) : i2 >= 18 ? ObjectsCompat.hash(Float.valueOf(this.f1934a.getTextSize()), Float.valueOf(this.f1934a.getTextScaleX()), Float.valueOf(this.f1934a.getTextSkewX()), Integer.valueOf(this.f1934a.getFlags()), this.f1934a.getTextLocale(), this.f1934a.getTypeface(), this.f1935b, Integer.valueOf(this.f1936c), Integer.valueOf(this.f1937d)) : i2 >= 17 ? ObjectsCompat.hash(Float.valueOf(this.f1934a.getTextSize()), Float.valueOf(this.f1934a.getTextScaleX()), Float.valueOf(this.f1934a.getTextSkewX()), Integer.valueOf(this.f1934a.getFlags()), this.f1934a.getTextLocale(), this.f1934a.getTypeface(), this.f1935b, Integer.valueOf(this.f1936c), Integer.valueOf(this.f1937d)) : ObjectsCompat.hash(Float.valueOf(this.f1934a.getTextSize()), Float.valueOf(this.f1934a.getTextScaleX()), Float.valueOf(this.f1934a.getTextSkewX()), Integer.valueOf(this.f1934a.getFlags()), this.f1934a.getTypeface(), this.f1935b, Integer.valueOf(this.f1936c), Integer.valueOf(this.f1937d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1934a.getTextSize());
            sb.append(", textScaleX=" + this.f1934a.getTextScaleX());
            sb.append(", textSkewX=" + this.f1934a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                sb.append(", letterSpacing=" + this.f1934a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1934a.isElegantTextHeight());
            }
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.f1934a.getTextLocales());
            } else if (i2 >= 17) {
                sb.append(", textLocale=" + this.f1934a.getTextLocale());
            }
            sb.append(", typeface=" + this.f1934a.getTypeface());
            if (i2 >= 26) {
                sb.append(", variationSettings=" + this.f1934a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1935b);
            sb.append(", breakStrategy=" + this.f1936c);
            sb.append(", hyphenationFrequency=" + this.f1937d);
            sb.append("}");
            return sb.toString();
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params params) {
            this.f1934a = params.getTextPaint();
            this.f1935b = params.getTextDirection();
            this.f1936c = params.getBreakStrategy();
            this.f1937d = params.getHyphenationFrequency();
            this.f1938e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
