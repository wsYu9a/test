package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.C0008;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import com.google.gason.C0107;
import com.google.gason.C0108;
import java.io.InputStream;

/* loaded from: classes7.dex */
public final class RoundedBitmapDrawableFactory {
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f14short;

    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // android.support.v4.graphics.drawable.RoundedBitmapDrawable
        void gravityCompatApply(int i2, int i3, int i4, Rect rect, Rect rect2) {
            GravityCompat.apply(i2, i3, i4, rect, rect2, 0);
        }

        @Override // android.support.v4.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            return this.mBitmap != null && BitmapCompat.hasMipMap(this.mBitmap);
        }

        @Override // android.support.v4.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean z) {
            if (this.mBitmap != null) {
                BitmapCompat.setHasMipMap(this.mBitmap, z);
                invalidateSelf();
            }
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(5111465)}[0]).intValue() ^ 5111332];
        sArr[0] = 3322;
        sArr[1] = 3271;
        sArr[2] = 3293;
        sArr[3] = 3270;
        sArr[4] = 3276;
        sArr[5] = 3277;
        sArr[6] = 3276;
        sArr[7] = 3306;
        sArr[8] = 3265;
        sArr[9] = 3292;
        sArr[10] = 3269;
        sArr[11] = 3273;
        sArr[12] = 3288;
        sArr[13] = 3308;
        sArr[14] = 3290;
        sArr[15] = 3273;
        sArr[16] = 3295;
        sArr[17] = 3273;
        sArr[18] = 3274;
        sArr[19] = 3268;
        sArr[20] = 3277;
        sArr[21] = 3310;
        sArr[22] = 3273;
        sArr[23] = 1552;
        sArr[24] = 1581;
        sArr[25] = 1591;
        sArr[26] = 1580;
        sArr[27] = 1574;
        sArr[28] = 1575;
        sArr[29] = 1574;
        sArr[30] = 1536;
        sArr[31] = 1579;
        sArr[32] = 1590;
        sArr[33] = 1583;
        sArr[34] = 1571;
        sArr[35] = 1586;
        sArr[36] = 1542;
        sArr[37] = 1584;
        sArr[38] = 1571;
        sArr[39] = 1589;
        sArr[40] = 1571;
        sArr[41] = 1568;
        sArr[42] = 1582;
        sArr[43] = 1575;
        sArr[44] = 1634;
        sArr[45] = 1569;
        sArr[46] = 1571;
        sArr[47] = 1580;
        sArr[48] = 1580;
        sArr[49] = 1581;
        sArr[50] = 1590;
        sArr[51] = 1634;
        sArr[52] = 1574;
        sArr[53] = 1575;
        sArr[54] = 1569;
        sArr[55] = 1581;
        sArr[56] = 1574;
        sArr[57] = 1575;
        sArr[58] = 1634;
        sArr[59] = 3023;
        sArr[60] = 3058;
        sArr[61] = 3048;
        sArr[62] = 3059;
        sArr[63] = 3065;
        sArr[64] = 3064;
        sArr[65] = 3065;
        sArr[66] = 3039;
        sArr[67] = 3060;
        sArr[68] = 3049;
        sArr[69] = 3056;
        sArr[70] = 3068;
        sArr[71] = 3053;
        sArr[72] = 3033;
        sArr[73] = 3055;
        sArr[74] = 3068;
        sArr[75] = 3050;
        sArr[76] = 3068;
        sArr[77] = 3071;
        sArr[78] = 3057;
        sArr[79] = 3064;
        sArr[80] = 3035;
        sArr[81] = 3068;
        sArr[82] = 1455;
        sArr[83] = 1426;
        sArr[84] = 1416;
        sArr[85] = 1427;
        sArr[86] = 1433;
        sArr[87] = 1432;
        sArr[88] = 1433;
        sArr[89] = 1471;
        sArr[90] = 1428;
        sArr[91] = 1417;
        sArr[92] = 1424;
        sArr[93] = 1436;
        sArr[94] = 1421;
        sArr[95] = 1465;
        sArr[96] = 1423;
        sArr[97] = 1436;
        sArr[98] = 1418;
        sArr[99] = 1436;
        sArr[100] = 1439;
        sArr[101] = 1425;
        sArr[102] = 1432;
        sArr[103] = 1501;
        sArr[104] = 1438;
        sArr[105] = 1436;
        sArr[106] = 1427;
        sArr[107] = 1427;
        sArr[108] = 1426;
        sArr[109] = 1417;
        sArr[110] = 1501;
        sArr[111] = 1433;
        sArr[112] = 1432;
        sArr[113] = 1438;
        sArr[114] = 1426;
        sArr[115] = 1433;
        sArr[116] = 1432;
        sArr[117] = 1501;
        sArr[118] = 2248;
        sArr[119] = 2293;
        sArr[120] = 2287;
        sArr[121] = 2292;
        sArr[122] = 2302;
        sArr[123] = 2303;
        sArr[124] = 2302;
        sArr[125] = 2264;
        sArr[126] = 2291;
        sArr[127] = 2286;
        sArr[128] = 2295;
        sArr[129] = 2299;
        sArr[130] = 2282;
        sArr[131] = 2270;
        sArr[132] = 2280;
        sArr[133] = 2299;
        sArr[134] = 2285;
        sArr[135] = 2299;
        sArr[136] = 2296;
        sArr[137] = 2294;
        sArr[138] = 2303;
        sArr[139] = 2268;
        sArr[140] = 2299;
        f14short = sArr;
        TAG = C0107.m50(f14short, 1746970 ^ C0008.m27((Object) "ۣ۟ۨ"), 1753458 ^ C0008.m27((Object) "ۦ۠۟"), C0008.m27((Object) "ۣۡۨ") ^ 1745716);
    }

    private RoundedBitmapDrawableFactory() {
    }

    public static RoundedBitmapDrawable create(Resources resources, Bitmap bitmap) {
        return Build.VERSION.SDK_INT >= 21 ? new RoundedBitmapDrawable21(resources, bitmap) : new DefaultRoundedBitmapDrawable(resources, bitmap);
    }

    public static RoundedBitmapDrawable create(Resources resources, InputStream inputStream) {
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeStream(inputStream));
        if (create.getBitmap() == null) {
            Log.w(C0107.m50(f14short, 1755475 ^ C0008.m27((Object) "ۨۤۤ"), 1751799 ^ C0008.m27((Object) "ۤۨۤ"), C0008.m27((Object) "ۣۥ۠") ^ 1752355), C0108.m52(f14short, 1749781 ^ C0008.m27((Object) "ۢۥۥ"), 1749677 ^ C0008.m27((Object) "ۢۡۨ"), C0008.m27((Object) "ۧۨۨ") ^ 1753189) + inputStream);
        }
        return create;
    }

    public static RoundedBitmapDrawable create(Resources resources, String str) {
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeFile(str));
        if (create.getBitmap() == null) {
            Log.w(C0000.m1(f14short, 1753403 ^ C0008.m27((Object) "ۦ۟ۦ"), 56492 ^ C0008.m27((Object) "ۦۡ"), C0008.m27((Object) "ۣۣۡ") ^ 1752799), C0008.m24(f14short, 1753595 ^ C0008.m27((Object) "ۦۢۥ"), 1754536 ^ C0008.m27((Object) "ۣۧۨ"), C0008.m27((Object) "ۦۡۢ") ^ 1754234) + str);
        }
        return create;
    }
}
