package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.util.Pair;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0005;
import com.google.gason.C0107;
import com.google.gason.stream.C0106;

/* loaded from: classes7.dex */
public final class PaintCompat {
    private static final String EM_STRING;
    private static final String TOFU_STRING;
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal;

    /* renamed from: short */
    private static final short[] f1short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(3568532)}[0]).intValue() ^ 3568530];
        sArr[0] = 417;
        sArr[1] = -8244;
        sArr[2] = -9458;
        sArr[3] = -11855;
        sArr[4] = -10893;
        sArr[5] = 2326;
        f1short = sArr;
        EM_STRING = C0003.m11(f1short, 1754468 ^ C0008.m27((Object) "ۧۢ۟"), 56296 ^ C0008.m27((Object) "۟ۨ"), C0008.m27((Object) "ۦۡ۟") ^ 1753160);
        TOFU_STRING = C0106.m46(f1short, 1747717 ^ C0008.m27((Object) "۠ۡۥ"), 1747654 ^ C0008.m27((Object) "ۣ۠۟"), C0008.m27((Object) "ۣۣ۟") ^ 1745804);
        sRectThreadLocal = new ThreadLocal<>();
    }

    private PaintCompat() {
    }

    public static boolean hasGlyph(Paint paint, String str) {
        Float f2 = new Float(2.0f);
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        String m17 = C0005.m17(f1short, 1746975 ^ C0008.m27((Object) "۟ۨۥ"), 1749576 ^ C0008.m27((Object) "ۢ۟ۧ"), C0008.m27((Object) "ۤۥۥ") ^ 1749002);
        float measureText = paint.measureText(m17);
        float measureText2 = paint.measureText(C0107.m50(f1short, 56421 ^ C0008.m27((Object) "ۣۣ"), 1751774 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۣۥۡ") ^ 1753028));
        float measureText3 = paint.measureText(str);
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > ((Float) new Object[]{f2}[0]).floatValue() * measureText2) {
                return false;
            }
            float f3 = 0.0f;
            int i2 = 0;
            while (i2 < length) {
                int charCount = Character.charCount(str.codePointAt(i2));
                f3 += paint.measureText(str, i2, i2 + charCount);
                i2 += charCount;
            }
            if (measureText3 >= f3) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair<Rect, Rect> obtainEmptyRects = obtainEmptyRects();
        paint.getTextBounds(m17, 0, m17.length(), (Rect) obtainEmptyRects.first);
        paint.getTextBounds(str, 0, length, (Rect) obtainEmptyRects.second);
        return !((Rect) obtainEmptyRects.first).equals(obtainEmptyRects.second);
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        ThreadLocal<Pair<Rect, Rect>> threadLocal = sRectThreadLocal;
        Pair<Rect, Rect> pair = threadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        ((Rect) pair.first).setEmpty();
        ((Rect) pair.second).setEmpty();
        return pair;
    }
}
