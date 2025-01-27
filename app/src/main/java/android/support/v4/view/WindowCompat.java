package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tencent.as.C0523;

/* loaded from: classes7.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    /* renamed from: short */
    private static final short[] f44short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(1769942)}[0]).intValue() ^ 1769977];
        sArr[0] = 2744;
        sArr[1] = 2741;
        sArr[2] = 2769;
        sArr[3] = 2709;
        sArr[4] = 2718;
        sArr[5] = 2708;
        sArr[6] = 2690;
        sArr[7] = 2769;
        sArr[8] = 2719;
        sArr[9] = 2718;
        sArr[10] = 2693;
        sArr[11] = 2769;
        sArr[12] = 2691;
        sArr[13] = 2708;
        sArr[14] = 2711;
        sArr[15] = 2708;
        sArr[16] = 2691;
        sArr[17] = 2708;
        sArr[18] = 2719;
        sArr[19] = 2706;
        sArr[20] = 2708;
        sArr[21] = 2769;
        sArr[22] = 2704;
        sArr[23] = 2769;
        sArr[24] = 2727;
        sArr[25] = 2712;
        sArr[26] = 2708;
        sArr[27] = 2694;
        sArr[28] = 2769;
        sArr[29] = 2712;
        sArr[30] = 2719;
        sArr[31] = 2690;
        sArr[32] = 2712;
        sArr[33] = 2709;
        sArr[34] = 2708;
        sArr[35] = 2769;
        sArr[36] = 2693;
        sArr[37] = 2713;
        sArr[38] = 2712;
        sArr[39] = 2690;
        sArr[40] = 2769;
        sArr[41] = 2726;
        sArr[42] = 2712;
        sArr[43] = 2719;
        sArr[44] = 2709;
        sArr[45] = 2718;
        sArr[46] = 2694;
        f44short = sArr;
    }

    private WindowCompat() {
    }

    public static <T extends View> T requireViewById(Window window, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) window.requireViewById(i2);
        }
        T t = (T) window.findViewById(i2);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(C0523.m77(f44short, 1751654 ^ C0008.m27((Object) "ۤۤۦ"), 1751757 ^ C0008.m27((Object) "ۤۨۦ"), C0008.m27((Object) "۠ۤۨ") ^ 1745301));
    }
}
