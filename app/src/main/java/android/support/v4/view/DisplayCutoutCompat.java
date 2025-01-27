package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import com.google.gason.reflect.C0105;
import com.tencent.a.C0521;
import java.util.List;

/* loaded from: classes7.dex */
public final class DisplayCutoutCompat {

    /* renamed from: short */
    private static final short[] f28short;
    private final Object mDisplayCutout;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(7690035)}[0]).intValue() ^ 7690022];
        sArr[0] = 684;
        sArr[1] = 641;
        sArr[2] = 667;
        sArr[3] = 664;
        sArr[4] = 644;
        sArr[5] = 649;
        sArr[6] = 657;
        sArr[7] = 683;
        sArr[8] = 669;
        sArr[9] = 668;
        sArr[10] = 647;
        sArr[11] = 669;
        sArr[12] = 668;
        sArr[13] = 683;
        sArr[14] = 647;
        sArr[15] = 645;
        sArr[16] = 664;
        sArr[17] = 649;
        sArr[18] = 668;
        sArr[19] = 659;
        sArr[20] = 2577;
        f28short = sArr;
    }

    public DisplayCutoutCompat(Rect rect, List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? new DisplayCutout(rect, list) : null);
    }

    private DisplayCutoutCompat(Object obj) {
        this.mDisplayCutout = obj;
    }

    static DisplayCutoutCompat wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new DisplayCutoutCompat(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DisplayCutoutCompat displayCutoutCompat = (DisplayCutoutCompat) obj;
        Object obj2 = this.mDisplayCutout;
        return obj2 == null ? displayCutoutCompat.mDisplayCutout == null : obj2.equals(displayCutoutCompat.mDisplayCutout);
    }

    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getBoundingRects();
        }
        return null;
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getSafeInsetBottom();
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getSafeInsetLeft();
        }
        return 0;
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getSafeInsetRight();
        }
        return 0;
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getSafeInsetTop();
        }
        return 0;
    }

    public int hashCode() {
        Object obj = this.mDisplayCutout;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return C0105.m44(f28short, 1755436 ^ C0008.m27((Object) "ۨۢۦ"), 1749681 ^ C0008.m27((Object) "ۢۢۥ"), C0008.m27((Object) "ۥۡۤ") ^ 1752864) + this.mDisplayCutout + C0521.m71(f28short, 1755454 ^ C0008.m27((Object) "ۨۢۤ"), 1752708 ^ C0008.m27((Object) "ۥۧۧ"), C0008.m27((Object) "ۨۥۧ") ^ 1754086);
    }
}
