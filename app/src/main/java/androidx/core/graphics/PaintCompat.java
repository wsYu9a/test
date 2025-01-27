package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;

/* loaded from: classes.dex */
public final class PaintCompat {

    /* renamed from: a */
    private static final String f1732a = "\udfffd";

    /* renamed from: b */
    private static final String f1733b = "m";

    /* renamed from: c */
    private static final ThreadLocal<Pair<Rect, Rect>> f1734c = new ThreadLocal<>();

    private PaintCompat() {
    }

    private static Pair<Rect, Rect> a() {
        ThreadLocal<Pair<Rect, Rect>> threadLocal = f1734c;
        Pair<Rect, Rect> pair = threadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        pair.first.setEmpty();
        pair.second.setEmpty();
        return pair;
    }

    public static boolean hasGlyph(@NonNull Paint paint, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText(f1732a);
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f2 = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i2 = 0;
            while (i2 < length) {
                int charCount = Character.charCount(str.codePointAt(i2)) + i2;
                f2 += paint.measureText(str, i2, charCount);
                i2 = charCount;
            }
            if (measureText3 >= f2) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair<Rect, Rect> a2 = a();
        paint.getTextBounds(f1732a, 0, 2, a2.first);
        paint.getTextBounds(str, 0, length, a2.second);
        return !a2.first.equals(a2.second);
    }

    public static boolean setBlendMode(@NonNull Paint paint, @Nullable BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            paint.setBlendMode(blendModeCompat != null ? BlendModeUtils.a(blendModeCompat) : null);
            return true;
        }
        if (blendModeCompat == null) {
            paint.setXfermode(null);
            return true;
        }
        PorterDuff.Mode b2 = BlendModeUtils.b(blendModeCompat);
        paint.setXfermode(b2 != null ? new PorterDuffXfermode(b2) : null);
        return b2 != null;
    }
}
