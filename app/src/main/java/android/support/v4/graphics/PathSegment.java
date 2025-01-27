package android.support.v4.graphics;

import android.graphics.PointF;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.util.Preconditions;
import android.support.v4.view.C0008;
import com.google.gason.C0107;
import com.google.gason.internal.C0104;
import com.tencent.a.utils.C0520;

/* loaded from: classes7.dex */
public final class PathSegment {

    /* renamed from: short */
    private static final short[] f4short;
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(3623133)}[0]).intValue() ^ 3623059];
        sArr[0] = 2522;
        sArr[1] = 2525;
        sArr[2] = 2504;
        sArr[3] = 2523;
        sArr[4] = 2525;
        sArr[5] = 2441;
        sArr[6] = 2452;
        sArr[7] = 2452;
        sArr[8] = 2441;
        sArr[9] = 2503;
        sArr[10] = 2524;
        sArr[11] = 2501;
        sArr[12] = 2501;
        sArr[13] = 1941;
        sArr[14] = 1950;
        sArr[15] = 1940;
        sArr[16] = 2000;
        sArr[17] = 1997;
        sArr[18] = 1997;
        sArr[19] = 2000;
        sArr[20] = 1950;
        sArr[21] = 1925;
        sArr[22] = 1948;
        sArr[23] = 1948;
        sArr[24] = 2079;
        sArr[25] = 2094;
        sArr[26] = 2107;
        sArr[27] = 2087;
        sArr[28] = 2076;
        sArr[29] = 2090;
        sArr[30] = 2088;
        sArr[31] = 2082;
        sArr[32] = 2090;
        sArr[33] = 2081;
        sArr[34] = 2107;
        sArr[35] = 2100;
        sArr[36] = 2108;
        sArr[37] = 2107;
        sArr[38] = 2094;
        sArr[39] = 2109;
        sArr[40] = 2107;
        sArr[41] = 2162;
        sArr[42] = 1809;
        sArr[43] = 1821;
        sArr[44] = 1870;
        sArr[45] = 1865;
        sArr[46] = 1884;
        sArr[47] = 1871;
        sArr[48] = 1865;
        sArr[49] = 1915;
        sArr[50] = 1871;
        sArr[51] = 1884;
        sArr[52] = 1886;
        sArr[53] = 1865;
        sArr[54] = 1876;
        sArr[55] = 1874;
        sArr[56] = 1875;
        sArr[57] = 1792;
        sArr[58] = 481;
        sArr[59] = 493;
        sArr[60] = 424;
        sArr[61] = 419;
        sArr[62] = 425;
        sArr[63] = 496;
        sArr[64] = 2742;
        sArr[65] = 2746;
        sArr[66] = 2815;
        sArr[67] = 2804;
        sArr[68] = 2814;
        sArr[69] = 2780;
        sArr[70] = 2792;
        sArr[71] = 2811;
        sArr[72] = 2809;
        sArr[73] = 2798;
        sArr[74] = 2803;
        sArr[75] = 2805;
        sArr[76] = 2804;
        sArr[77] = 2727;
        f4short = sArr;
    }

    public PathSegment(PointF pointF, float f2, PointF pointF2, float f3) {
        this.mStart = (PointF) Preconditions.checkNotNull(pointF, C0520.m66(f4short, 1751532 ^ C0008.m27((Object) "ۤ۠ۨ"), 1748845 ^ C0008.m27((Object) "ۡۦۥ"), C0008.m27((Object) "۠ۥۥ") ^ 1745449));
        this.mStartFraction = f2;
        this.mEnd = (PointF) Preconditions.checkNotNull(pointF2, C0000.m1(f4short, 1746770 ^ C0008.m27((Object) "۟ۢۢ"), 1749640 ^ C0008.m27((Object) "ۢۡۢ"), C0008.m27((Object) "ۦۢۧ") ^ 1754715));
        this.mEndFraction = f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.mStartFraction, pathSegment.mStartFraction) == 0 && Float.compare(this.mEndFraction, pathSegment.mEndFraction) == 0 && this.mStart.equals(pathSegment.mStart) && this.mEnd.equals(pathSegment.mEnd);
    }

    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        Object[] objArr = {new Integer(5524213), new Integer(2177245), new Integer(8108715)};
        int hashCode = this.mStart.hashCode();
        int intValue = ((Integer) objArr[1]).intValue();
        float f2 = this.mStartFraction;
        int floatToIntBits = f2 != 0.0f ? Float.floatToIntBits(f2) : 0;
        int intValue2 = ((Integer) objArr[0]).intValue();
        int hashCode2 = this.mEnd.hashCode();
        int intValue3 = ((Integer) objArr[2]).intValue();
        float f3 = this.mEndFraction;
        return ((intValue3 ^ 8108724) * (((floatToIntBits + ((2177218 ^ intValue) * hashCode)) * (5524202 ^ intValue2)) + hashCode2)) + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
    }

    public String toString() {
        return C0107.m50(f4short, 1755505 ^ C0008.m27((Object) "ۨۤۥ"), 1746774 ^ C0008.m27((Object) "۟ۡۦ"), C0008.m27((Object) "ۣۥۧ") ^ 1752714) + this.mStart + C0003.m11(f4short, 1747819 ^ C0008.m27((Object) "ۣ۠ۤ"), 1747823 ^ C0008.m27((Object) "۠ۥۤ"), C0008.m27((Object) "ۣۢۥ") ^ 1750521) + this.mStartFraction + C0104.m40(f4short, 1753458 ^ C0008.m27((Object) "ۦ۟ۡ"), 1755470 ^ C0008.m27((Object) "ۣۣۨ"), C0008.m27((Object) "ۦۡ") ^ 56694) + this.mEnd + C0104.m40(f4short, 1750537 ^ C0008.m27((Object) "ۣۡۧ"), 56431 ^ C0008.m27((Object) "ۣۤ"), C0008.m27((Object) "ۣۨۤ") ^ 1754067) + this.mEndFraction + '}';
    }
}
