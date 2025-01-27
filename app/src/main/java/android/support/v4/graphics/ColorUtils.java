package android.support.v4.graphics;

import android.graphics.Color;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import com.google.gason.C0108;
import com.google.gason.internal.C0104;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;
import com.tencent.a.utils.C0520;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY;
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    /* renamed from: short */
    private static final short[] f0short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(3811917)}[0]).intValue() ^ 3812171];
        sArr[0] = 2624;
        sArr[1] = 2650;
        sArr[2] = 2651;
        sArr[3] = 2679;
        sArr[4] = 2646;
        sArr[5] = 2645;
        sArr[6] = 2575;
        sArr[7] = 2626;
        sArr[8] = 2650;
        sArr[9] = 2652;
        sArr[10] = 2651;
        sArr[11] = 2575;
        sArr[12] = 2631;
        sArr[13] = 2638;
        sArr[14] = 2649;
        sArr[15] = 2634;
        sArr[16] = 2575;
        sArr[17] = 2638;
        sArr[18] = 2575;
        sArr[19] = 2627;
        sArr[20] = 2634;
        sArr[21] = 2625;
        sArr[22] = 2632;
        sArr[23] = 2651;
        sArr[24] = 2631;
        sArr[25] = 2575;
        sArr[26] = 2624;
        sArr[27] = 2633;
        sArr[28] = 2575;
        sArr[29] = 2588;
        sArr[30] = 2561;
        sArr[31] = 1668;
        sArr[32] = 1694;
        sArr[33] = 1695;
        sArr[34] = 1703;
        sArr[35] = 1674;
        sArr[36] = 1673;
        sArr[37] = 1739;
        sArr[38] = 1670;
        sArr[39] = 1694;
        sArr[40] = 1688;
        sArr[41] = 1695;
        sArr[42] = 1739;
        sArr[43] = 1667;
        sArr[44] = 1674;
        sArr[45] = 1693;
        sArr[46] = 1678;
        sArr[47] = 1739;
        sArr[48] = 1674;
        sArr[49] = 1739;
        sArr[50] = 1671;
        sArr[51] = 1678;
        sArr[52] = 1669;
        sArr[53] = 1676;
        sArr[54] = 1695;
        sArr[55] = 1667;
        sArr[56] = 1739;
        sArr[57] = 1668;
        sArr[58] = 1677;
        sArr[59] = 1739;
        sArr[60] = 1752;
        sArr[61] = 1733;
        sArr[62] = 3030;
        sArr[63] = 3009;
        sArr[64] = 3031;
        sArr[65] = 3025;
        sArr[66] = 3016;
        sArr[67] = 3024;
        sArr[68] = 2948;
        sArr[69] = 3017;
        sArr[70] = 3025;
        sArr[71] = 3031;
        sArr[72] = 3024;
        sArr[73] = 2948;
        sArr[74] = 3020;
        sArr[75] = 3013;
        sArr[76] = 3026;
        sArr[77] = 3009;
        sArr[78] = 2948;
        sArr[79] = 3013;
        sArr[80] = 2948;
        sArr[81] = 3016;
        sArr[82] = 3009;
        sArr[83] = 3018;
        sArr[84] = 3011;
        sArr[85] = 3024;
        sArr[86] = 3020;
        sArr[87] = 2948;
        sArr[88] = 3019;
        sArr[89] = 3010;
        sArr[90] = 2948;
        sArr[91] = 2967;
        sArr[92] = 2954;
        sArr[93] = 2778;
        sArr[94] = 2752;
        sArr[95] = 2753;
        sArr[96] = 2791;
        sArr[97] = 2768;
        sArr[98] = 2758;
        sArr[99] = 2752;
        sArr[100] = 2777;
        sArr[101] = 2753;
        sArr[102] = 2709;
        sArr[103] = 2776;
        sArr[104] = 2752;
        sArr[105] = 2758;
        sArr[106] = 2753;
        sArr[107] = 2709;
        sArr[108] = 2781;
        sArr[109] = 2772;
        sArr[110] = 2755;
        sArr[111] = 2768;
        sArr[112] = 2709;
        sArr[113] = 2772;
        sArr[114] = 2709;
        sArr[115] = 2777;
        sArr[116] = 2768;
        sArr[117] = 2779;
        sArr[118] = 2770;
        sArr[119] = 2753;
        sArr[120] = 2781;
        sArr[121] = 2709;
        sArr[122] = 2778;
        sArr[123] = 2771;
        sArr[124] = 2709;
        sArr[125] = 2694;
        sArr[126] = 2715;
        sArr[127] = 821;
        sArr[128] = 822;
        sArr[129] = 820;
        sArr[130] = 828;
        sArr[131] = 816;
        sArr[132] = 805;
        sArr[133] = 824;
        sArr[134] = 802;
        sArr[135] = 825;
        sArr[136] = 819;
        sArr[137] = 887;
        sArr[138] = 820;
        sArr[139] = 822;
        sArr[140] = 825;
        sArr[141] = 887;
        sArr[142] = 825;
        sArr[143] = 824;
        sArr[144] = 803;
        sArr[145] = 887;
        sArr[146] = 821;
        sArr[147] = 818;
        sArr[148] = 887;
        sArr[149] = 803;
        sArr[150] = 805;
        sArr[151] = 822;
        sArr[152] = 825;
        sArr[153] = 804;
        sArr[154] = 827;
        sArr[155] = 802;
        sArr[156] = 820;
        sArr[157] = 818;
        sArr[158] = 825;
        sArr[159] = 803;
        sArr[160] = 877;
        sArr[161] = 887;
        sArr[162] = 884;
        sArr[163] = 2816;
        sArr[164] = 2819;
        sArr[165] = 2817;
        sArr[166] = 2825;
        sArr[167] = 2821;
        sArr[168] = 2832;
        sArr[169] = 2829;
        sArr[170] = 2839;
        sArr[171] = 2828;
        sArr[172] = 2822;
        sArr[173] = 2882;
        sArr[174] = 2817;
        sArr[175] = 2819;
        sArr[176] = 2828;
        sArr[177] = 2882;
        sArr[178] = 2828;
        sArr[179] = 2829;
        sArr[180] = 2838;
        sArr[181] = 2882;
        sArr[182] = 2816;
        sArr[183] = 2823;
        sArr[184] = 2882;
        sArr[185] = 2838;
        sArr[186] = 2832;
        sArr[187] = 2819;
        sArr[188] = 2828;
        sArr[189] = 2833;
        sArr[190] = 2830;
        sArr[191] = 2839;
        sArr[192] = 2817;
        sArr[193] = 2823;
        sArr[194] = 2828;
        sArr[195] = 2838;
        sArr[196] = 2904;
        sArr[197] = 2882;
        sArr[198] = 2881;
        sArr[199] = 1653;
        sArr[200] = 1625;
        sArr[201] = 1626;
        sArr[202] = 1625;
        sArr[203] = 1604;
        sArr[204] = 1558;
        sArr[205] = 1627;
        sArr[206] = 1625;
        sArr[207] = 1618;
        sArr[208] = 1619;
        sArr[209] = 1626;
        sArr[210] = 1605;
        sArr[211] = 1558;
        sArr[212] = 1627;
        sArr[213] = 1603;
        sArr[214] = 1605;
        sArr[215] = 1602;
        sArr[216] = 1558;
        sArr[217] = 1627;
        sArr[218] = 1623;
        sArr[219] = 1602;
        sArr[220] = 1621;
        sArr[221] = 1630;
        sArr[222] = 1558;
        sArr[223] = 1566;
        sArr[224] = 2191;
        sArr[225] = 2265;
        sArr[226] = 2268;
        sArr[227] = 2177;
        sArr[228] = 2191;
        sArr[229] = 811;
        sArr[230] = 275;
        sArr[231] = 286;
        sArr[232] = 258;
        sArr[233] = 282;
        sArr[234] = 275;
        sArr[235] = 338;
        sArr[236] = 287;
        sArr[237] = 263;
        sArr[238] = 257;
        sArr[239] = 262;
        sArr[240] = 338;
        sArr[241] = 272;
        sArr[242] = 279;
        sArr[243] = 338;
        sArr[244] = 272;
        sArr[245] = 279;
        sArr[246] = 262;
        sArr[247] = 261;
        sArr[248] = 279;
        sArr[249] = 279;
        sArr[250] = 284;
        sArr[251] = 338;
        sArr[252] = 322;
        sArr[253] = 338;
        sArr[254] = 275;
        sArr[255] = 284;
        sArr[256] = 278;
        sArr[257] = 338;
        sArr[258] = 320;
        sArr[259] = 327;
        sArr[260] = 327;
        sArr[261] = 348;
        f0short = sArr;
        TEMP_ARRAY = new ThreadLocal<>();
    }

    private ColorUtils() {
    }

    public static int HSLToColor(float[] fArr) {
        int i2;
        int i3;
        int i4;
        Object[] objArr = {new Float(255.0f), new Float(2.0f), new Integer(7903138), new Integer(3820366), new Integer(6679453), new Float(1.0f), new Float(60.0f), new Float(0.5f), new Integer(683105)};
        float f2 = fArr[0];
        float f3 = fArr[((Integer) objArr[8]).intValue() ^ 683104];
        float f4 = fArr[((Integer) objArr[3]).intValue() ^ 3820364];
        float floatValue = ((Float) objArr[1]).floatValue();
        float floatValue2 = ((Float) objArr[5]).floatValue();
        float abs = (floatValue2 - Math.abs((f4 * floatValue) - floatValue2)) * f3;
        float floatValue3 = f4 - (((Float) objArr[7]).floatValue() * abs);
        float abs2 = (floatValue2 - Math.abs(((f2 / ((Float) objArr[6]).floatValue()) % floatValue) - floatValue2)) * abs;
        int intValue = ((int) f2) / (((Integer) objArr[4]).intValue() ^ 6679457);
        float floatValue4 = ((Float) objArr[0]).floatValue();
        switch (intValue) {
            case 0:
                int round = Math.round((abs + floatValue3) * floatValue4);
                int round2 = Math.round((abs2 + floatValue3) * floatValue4);
                int round3 = Math.round(floatValue4 * floatValue3);
                i2 = round;
                i3 = round2;
                i4 = round3;
                break;
            case 1:
                int round4 = Math.round((abs2 + floatValue3) * floatValue4);
                int round5 = Math.round((abs + floatValue3) * floatValue4);
                int round6 = Math.round(floatValue4 * floatValue3);
                i2 = round4;
                i3 = round5;
                i4 = round6;
                break;
            case 2:
                int round7 = Math.round(floatValue3 * floatValue4);
                int round8 = Math.round((abs + floatValue3) * floatValue4);
                int round9 = Math.round(floatValue4 * (floatValue3 + abs2));
                i2 = round7;
                i3 = round8;
                i4 = round9;
                break;
            case 3:
                int round10 = Math.round(floatValue3 * floatValue4);
                int round11 = Math.round((abs2 + floatValue3) * floatValue4);
                int round12 = Math.round(floatValue4 * (floatValue3 + abs));
                i2 = round10;
                i3 = round11;
                i4 = round12;
                break;
            case 4:
                int round13 = Math.round((abs2 + floatValue3) * floatValue4);
                int round14 = Math.round(floatValue3 * floatValue4);
                int round15 = Math.round(floatValue4 * (floatValue3 + abs));
                i2 = round13;
                i3 = round14;
                i4 = round15;
                break;
            case 5:
            case 6:
                int round16 = Math.round((abs + floatValue3) * floatValue4);
                int round17 = Math.round(floatValue3 * floatValue4);
                int round18 = Math.round(floatValue4 * (floatValue3 + abs2));
                i2 = round16;
                i3 = round17;
                i4 = round18;
                break;
            default:
                i4 = 0;
                i3 = 0;
                i2 = 0;
                break;
        }
        int intValue2 = ((Integer) objArr[2]).intValue() ^ 7903069;
        return Color.rgb(constrain(i2, 0, intValue2), constrain(i3, 0, intValue2), constrain(i4, 0, intValue2));
    }

    public static int LABToColor(double d2, double d3, double d4) {
        Object[] objArr = {new Integer(289813), new Integer(7520391)};
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d2, d3, d4, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[((Integer) objArr[0]).intValue() ^ 289812], tempDouble3Array[((Integer) objArr[1]).intValue() ^ 7520389]);
    }

    public static void LABToXYZ(double d2, double d3, double d4, double[] dArr) {
        Object[] objArr = {new Double(XYZ_WHITE_REFERENCE_Z), new Double(3.0d), new Double(XYZ_EPSILON), new Double(16.0d), new Double(XYZ_KAPPA), new Double(500.0d), new Double(7.9996247999999985d), new Double(XYZ_WHITE_REFERENCE_X), new Double(200.0d), new Integer(1718878), new Double(XYZ_WHITE_REFERENCE_Y), new Integer(8699694), new Double(116.0d)};
        double doubleValue = ((Double) objArr[3]).doubleValue();
        double doubleValue2 = ((Double) objArr[12]).doubleValue();
        double d5 = (d2 + doubleValue) / doubleValue2;
        double doubleValue3 = (d3 / ((Double) objArr[5]).doubleValue()) + d5;
        double doubleValue4 = d5 - (d4 / ((Double) objArr[8]).doubleValue());
        double doubleValue5 = ((Double) objArr[1]).doubleValue();
        double pow = Math.pow(doubleValue3, doubleValue5);
        double doubleValue6 = ((Double) objArr[2]).doubleValue();
        double doubleValue7 = ((Double) objArr[4]).doubleValue();
        if (pow <= doubleValue6) {
            pow = ((doubleValue3 * doubleValue2) - doubleValue) / doubleValue7;
        }
        double pow2 = d2 > ((Double) objArr[6]).doubleValue() ? Math.pow(d5, doubleValue5) : d2 / doubleValue7;
        double pow3 = Math.pow(doubleValue4, doubleValue5);
        double d6 = pow3 > doubleValue6 ? pow3 : ((doubleValue2 * doubleValue4) - doubleValue) / doubleValue7;
        dArr[0] = pow * ((Double) objArr[7]).doubleValue();
        dArr[1718879 ^ ((Integer) objArr[9]).intValue()] = ((Double) objArr[10]).doubleValue() * pow2;
        dArr[8699692 ^ ((Integer) objArr[11]).intValue()] = ((Double) objArr[0]).doubleValue() * d6;
    }

    public static void RGBToHSL(int i2, int i3, int i4, float[] fArr) {
        float abs;
        float f2;
        Object[] objArr = {new Float(4.0f), new Float(2.0f), new Float(360.0f), new Integer(5802836), new Float(255.0f), new Integer(8212476), new Float(6.0f), new Float(60.0f)};
        float floatValue = ((Float) objArr[4]).floatValue();
        float f3 = i2 / floatValue;
        float f4 = i3 / floatValue;
        float f5 = i4 / floatValue;
        float max = Math.max(f3, Math.max(f4, f5));
        float min = Math.min(f3, Math.min(f4, f5));
        float f6 = max - min;
        float floatValue2 = ((Float) objArr[1]).floatValue();
        float f7 = (max + min) / floatValue2;
        if (max == min) {
            abs = 0.0f;
            f2 = 0.0f;
        } else {
            float floatValue3 = max == f3 ? ((f4 - f5) / f6) % ((Float) objArr[6]).floatValue() : max == f4 ? ((f5 - f3) / f6) + floatValue2 : ((Float) objArr[0]).floatValue() + ((f3 - f4) / f6);
            abs = f6 / (1.0f - Math.abs((floatValue2 * f7) - 1.0f));
            f2 = floatValue3;
        }
        float floatValue4 = ((Float) objArr[7]).floatValue();
        float floatValue5 = ((Float) objArr[2]).floatValue();
        float f8 = (floatValue4 * f2) % floatValue5;
        if (f8 < 0.0f) {
            f8 += floatValue5;
        }
        fArr[0] = constrain(f8, 0.0f, floatValue5);
        fArr[((Integer) objArr[3]).intValue() ^ 5802837] = constrain(abs, 0.0f, 1.0f);
        fArr[((Integer) objArr[5]).intValue() ^ 8212478] = constrain(f7, 0.0f, 1.0f);
    }

    public static void RGBToLAB(int i2, int i3, int i4, double[] dArr) {
        Object[] objArr = {new Integer(2405), new Integer(5070409)};
        RGBToXYZ(i2, i3, i4, dArr);
        XYZToLAB(dArr[0], dArr[((Integer) objArr[0]).intValue() ^ 2404], dArr[((Integer) objArr[1]).intValue() ^ 5070411], dArr);
    }

    public static void RGBToXYZ(int i2, int i3, int i4, double[] dArr) {
        Object[] objArr = {new Double(0.055d), new Double(2.4d), new Double(0.04045d), new Double(1.055d), new Double(0.7152d), new Double(12.92d), new Double(0.4124d), new Double(0.0722d), new Double(0.2126d), new Double(0.04045d), new Double(XYZ_WHITE_REFERENCE_Y), new Double(12.92d), new Double(255.0d), new Double(0.1192d), new Integer(2573303), new Double(0.1805d), new Double(0.9505d), new Double(0.3576d), new Integer(752382), new Double(0.0193d), new Double(12.92d), new Double(2.4d)};
        if (dArr.length != 3) {
            throw new IllegalArgumentException(C0104.m40(f0short, 1753577 ^ C0008.m27((Object) "ۦۤۧ"), 1746722 ^ C0008.m27((Object) "۟ۡ۟"), C0008.m27((Object) "ۧ۠ۦ") ^ 1756930));
        }
        double doubleValue = ((Double) objArr[12]).doubleValue();
        double d2 = i2 / doubleValue;
        double doubleValue2 = ((Double) objArr[2]).doubleValue();
        double doubleValue3 = ((Double) objArr[5]).doubleValue();
        double doubleValue4 = ((Double) objArr[21]).doubleValue();
        double doubleValue5 = ((Double) objArr[3]).doubleValue();
        double doubleValue6 = ((Double) objArr[0]).doubleValue();
        double pow = d2 < doubleValue2 ? d2 / doubleValue3 : Math.pow((d2 + doubleValue6) / doubleValue5, doubleValue4);
        double d3 = i3 / doubleValue;
        double doubleValue7 = d3 < doubleValue2 ? d3 / ((Double) objArr[11]).doubleValue() : Math.pow((d3 + doubleValue6) / doubleValue5, doubleValue4);
        double d4 = i4 / doubleValue;
        double doubleValue8 = d4 < ((Double) objArr[9]).doubleValue() ? d4 / ((Double) objArr[20]).doubleValue() : Math.pow((doubleValue6 + d4) / doubleValue5, ((Double) objArr[1]).doubleValue());
        double doubleValue9 = ((Double) objArr[6]).doubleValue();
        double doubleValue10 = ((Double) objArr[17]).doubleValue();
        double doubleValue11 = ((Double) objArr[15]).doubleValue();
        double doubleValue12 = ((Double) objArr[10]).doubleValue();
        dArr[0] = ((doubleValue9 * pow) + (doubleValue10 * doubleValue7) + (doubleValue11 * doubleValue8)) * doubleValue12;
        dArr[2573302 ^ ((Integer) objArr[14]).intValue()] = ((((Double) objArr[8]).doubleValue() * pow) + (((Double) objArr[4]).doubleValue() * doubleValue7) + (((Double) objArr[7]).doubleValue() * doubleValue8)) * doubleValue12;
        dArr[752380 ^ ((Integer) objArr[18]).intValue()] = ((doubleValue7 * ((Double) objArr[13]).doubleValue()) + (pow * ((Double) objArr[19]).doubleValue()) + (doubleValue8 * ((Double) objArr[16]).doubleValue())) * doubleValue12;
    }

    public static int XYZToColor(double d2, double d3, double d4) {
        Object[] objArr = {new Double(1.057d), new Double(0.055d), new Double(255.0d), new Double(-0.204d), new Double(-1.5372d), new Double(-0.9689d), new Double(3.2406d), new Double(12.92d), new Double(0.0415d), new Double(0.0031308d), new Integer(2369510), new Double(XYZ_WHITE_REFERENCE_Y), new Double(1.055d), new Double(1.8758d), new Double(0.4166666666666667d), new Double(-0.4986d), new Double(0.0557d)};
        double doubleValue = ((Double) objArr[6]).doubleValue();
        double doubleValue2 = ((Double) objArr[4]).doubleValue();
        double doubleValue3 = ((Double) objArr[15]).doubleValue();
        double doubleValue4 = ((Double) objArr[11]).doubleValue();
        double d5 = (((doubleValue * d2) + (doubleValue2 * d3)) + (doubleValue3 * d4)) / doubleValue4;
        double doubleValue5 = ((((Double) objArr[8]).doubleValue() * d4) + ((((Double) objArr[5]).doubleValue() * d2) + (((Double) objArr[13]).doubleValue() * d3))) / doubleValue4;
        double doubleValue6 = ((((Double) objArr[0]).doubleValue() * d4) + ((((Double) objArr[16]).doubleValue() * d2) + (((Double) objArr[3]).doubleValue() * d3))) / doubleValue4;
        double doubleValue7 = ((Double) objArr[9]).doubleValue();
        double doubleValue8 = ((Double) objArr[1]).doubleValue();
        double doubleValue9 = ((Double) objArr[14]).doubleValue();
        double doubleValue10 = ((Double) objArr[12]).doubleValue();
        double doubleValue11 = ((Double) objArr[7]).doubleValue();
        double pow = d5 > doubleValue7 ? (Math.pow(d5, doubleValue9) * doubleValue10) - doubleValue8 : d5 * doubleValue11;
        double pow2 = doubleValue5 > doubleValue7 ? (Math.pow(doubleValue5, doubleValue9) * doubleValue10) - doubleValue8 : doubleValue5 * doubleValue11;
        double pow3 = doubleValue6 > doubleValue7 ? (Math.pow(doubleValue6, doubleValue9) * doubleValue10) - doubleValue8 : doubleValue6 * doubleValue11;
        double doubleValue12 = ((Double) objArr[2]).doubleValue();
        int round = (int) Math.round(pow * doubleValue12);
        int intValue = ((Integer) objArr[10]).intValue() ^ 2369305;
        return Color.rgb(constrain(round, 0, intValue), constrain((int) Math.round(pow2 * doubleValue12), 0, intValue), constrain((int) Math.round(pow3 * doubleValue12), 0, intValue));
    }

    public static void XYZToLAB(double d2, double d3, double d4, double[] dArr) {
        Object[] objArr = {new Double(16.0d), new Double(200.0d), new Double(500.0d), new Double(XYZ_WHITE_REFERENCE_Y), new Integer(7606506), new Double(XYZ_WHITE_REFERENCE_X), new Integer(7927005), new Double(XYZ_WHITE_REFERENCE_Z), new Double(0.0d), new Double(116.0d)};
        if (dArr.length != 3) {
            throw new IllegalArgumentException(C0006.m19(f0short, 1748772 ^ C0008.m27((Object) "ۡۥ۟"), 1755480 ^ C0008.m27((Object) "ۣۨۢ"), C0008.m27((Object) "ۤۧ") ^ 55912));
        }
        double pivotXyzComponent = pivotXyzComponent(d2 / ((Double) objArr[5]).doubleValue());
        double pivotXyzComponent2 = pivotXyzComponent(d3 / ((Double) objArr[3]).doubleValue());
        double pivotXyzComponent3 = pivotXyzComponent(d4 / ((Double) objArr[7]).doubleValue());
        dArr[0] = Math.max(((Double) objArr[8]).doubleValue(), (((Double) objArr[9]).doubleValue() * pivotXyzComponent2) - ((Double) objArr[0]).doubleValue());
        dArr[7606507 ^ ((Integer) objArr[4]).intValue()] = (pivotXyzComponent - pivotXyzComponent2) * ((Double) objArr[2]).doubleValue();
        dArr[7927007 ^ ((Integer) objArr[6]).intValue()] = ((Double) objArr[1]).doubleValue() * (pivotXyzComponent2 - pivotXyzComponent3);
    }

    public static int blendARGB(int i2, int i3, float f2) {
        float floatValue = ((Float) new Object[]{new Float(1.0f)}[0]).floatValue() - f2;
        return Color.argb((int) ((Color.alpha(i2) * floatValue) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * floatValue) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * floatValue) + (Color.green(i3) * f2)), (int) ((floatValue * Color.blue(i2)) + (Color.blue(i3) * f2)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, float f2, float[] fArr3) {
        Object[] objArr = {new Integer(9689654), new Integer(7867753), new Float(1.0f)};
        if (fArr3.length != 3) {
            throw new IllegalArgumentException(C0000.m1(f0short, 1753625 ^ C0008.m27((Object) "ۦۦۧ"), 1749693 ^ C0008.m27((Object) "ۢۢۢ"), C0008.m27((Object) "ۣ۟ۦ") ^ 1752494));
        }
        float floatValue = ((Float) objArr[2]).floatValue() - f2;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f2);
        int intValue = ((Integer) objArr[0]).intValue() ^ 9689655;
        fArr3[intValue] = (fArr[intValue] * floatValue) + (fArr2[intValue] * f2);
        int intValue2 = ((Integer) objArr[1]).intValue() ^ 7867755;
        fArr3[intValue2] = (fArr[intValue2] * floatValue) + (fArr2[intValue2] * f2);
    }

    public static void blendLAB(double[] dArr, double[] dArr2, double d2, double[] dArr3) {
        Object[] objArr = {new Integer(6417210), new Double(1.0d), new Integer(4684961)};
        if (dArr3.length != 3) {
            throw new IllegalArgumentException(C0005.m17(f0short, 1751675 ^ C0008.m27((Object) "ۤۢۤ"), 1751680 ^ C0008.m27((Object) "ۤۦۤ"), C0008.m27((Object) "ۡ۟ۦ") ^ 1745981));
        }
        double doubleValue = ((Double) objArr[1]).doubleValue() - d2;
        dArr3[0] = (dArr[0] * doubleValue) + (dArr2[0] * d2);
        int intValue = ((Integer) objArr[0]).intValue() ^ 6417211;
        dArr3[intValue] = (dArr[intValue] * doubleValue) + (dArr2[intValue] * d2);
        int intValue2 = ((Integer) objArr[2]).intValue() ^ 4684963;
        dArr3[intValue2] = (doubleValue * dArr[intValue2]) + (dArr2[intValue2] * d2);
    }

    public static double calculateContrast(int i2, int i3) {
        Double d2 = new Double(0.05d);
        if (Color.alpha(i3) != 255) {
            throw new IllegalArgumentException(C0519.m65(f0short, 1750782 ^ C0008.m27((Object) "ۣۣۡ"), 1754593 ^ C0008.m27((Object) "ۧۥۣ"), C0008.m27((Object) "ۤ۠ۧ") ^ 1751740) + Integer.toHexString(i3));
        }
        if (Color.alpha(i2) < 255) {
            i2 = compositeColors(i2, i3);
        }
        double calculateLuminance = calculateLuminance(i2);
        double doubleValue = ((Double) new Object[]{d2}[0]).doubleValue();
        double d3 = calculateLuminance + doubleValue;
        double calculateLuminance2 = doubleValue + calculateLuminance(i3);
        return Math.max(d3, calculateLuminance2) / Math.min(d3, calculateLuminance2);
    }

    public static double calculateLuminance(int i2) {
        Object[] objArr = {new Integer(4753347), new Double(XYZ_WHITE_REFERENCE_Y)};
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i2, tempDouble3Array);
        return tempDouble3Array[((Integer) objArr[0]).intValue() ^ 4753346] / ((Double) objArr[1]).doubleValue();
    }

    public static int calculateMinimumAlpha(int i2, int i3, float f2) {
        Object[] objArr = {new Integer(6433016), new Integer(7639292), new Integer(6191129)};
        int alpha = Color.alpha(i3);
        int intValue = ((Integer) objArr[2]).intValue() ^ 6191334;
        if (alpha != intValue) {
            throw new IllegalArgumentException(C0520.m66(f0short, 1747552 ^ C0008.m27((Object) "۠۟ۢ"), 1746808 ^ C0008.m27((Object) "۟ۢ۟"), C0008.m27((Object) "۠ۡۥ") ^ 1744998) + Integer.toHexString(i3));
        }
        if (calculateContrast(setAlphaComponent(i2, intValue), i3) < f2) {
            return -1;
        }
        int i4 = 255;
        int i5 = 0;
        for (int i6 = 0; i6 <= 10 && i4 - i5 > 1; i6 = (((Integer) objArr[1]).intValue() ^ 7639293) + i6) {
            int intValue2 = (i5 + i4) / (((Integer) objArr[0]).intValue() ^ 6433018);
            if (calculateContrast(setAlphaComponent(i2, intValue2), i3) < f2) {
                i5 = intValue2;
            } else {
                i4 = intValue2;
            }
        }
        return i4;
    }

    static float circularInterpolate(float f2, float f3, float f4) {
        Object[] objArr = {new Float(360.0f), new Float(180.0f)};
        float abs = Math.abs(f3 - f2);
        float floatValue = ((Float) objArr[1]).floatValue();
        float floatValue2 = ((Float) objArr[0]).floatValue();
        if (abs > floatValue) {
            if (f3 > f2) {
                f2 += floatValue2;
            } else {
                f3 += floatValue2;
            }
        }
        return (((f3 - f2) * f4) + f2) % floatValue2;
    }

    public static void colorToHSL(int i2, float[] fArr) {
        RGBToHSL(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }

    public static void colorToLAB(int i2, double[] dArr) {
        RGBToLAB(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    public static void colorToXYZ(int i2, double[] dArr) {
        RGBToXYZ(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    private static int compositeAlpha(int i2, int i3) {
        Object[] objArr = {new Integer(8498773), new Integer(564989), new Integer(6012333), new Integer(5727260)};
        return (((Integer) objArr[2]).intValue() ^ 6012242) - ((((((Integer) objArr[3]).intValue() ^ 5727459) - i3) * ((((Integer) objArr[1]).intValue() ^ 564738) - i2)) / (((Integer) objArr[0]).intValue() ^ 8498858));
    }

    public static int compositeColors(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i2), alpha2, Color.red(i3), alpha, compositeAlpha), compositeComponent(Color.green(i2), alpha2, Color.green(i3), alpha, compositeAlpha), compositeComponent(Color.blue(i2), alpha2, Color.blue(i3), alpha, compositeAlpha));
    }

    public static Color compositeColors(Color color, Color color2) {
        Object[] objArr = {new Float(1.0f), new Integer(8153598), new Integer(-7329844)};
        if (!Objects.equals(color.getModel(), color2.getModel())) {
            throw new IllegalArgumentException(C0108.m52(f0short, 1753516 ^ C0008.m27((Object) "ۦ۠ۥ"), 1754577 ^ C0008.m27((Object) "ۧۥۦ"), C0008.m27((Object) "ۧۧۦ") ^ 1753136) + color.getModel() + C0522.m72(f0short, 1749572 ^ C0008.m27((Object) "ۢۢۤ"), 1750530 ^ C0008.m27((Object) "ۣۣ۟"), C0008.m27((Object) "ۡۢ۠") ^ 1746544) + color2.getModel() + C0522.m72(f0short, 1746782 ^ C0008.m27((Object) "۟ۥۡ"), 1748612 ^ C0008.m27((Object) "ۣۡ۟"), C0008.m27((Object) "۟۟ۧ") ^ 1745925));
        }
        if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
            color = color.convert(color2.getColorSpace());
        }
        float[] components = color.getComponents();
        float[] components2 = color2.getComponents();
        float alpha = color.alpha();
        float alpha2 = color2.alpha() * (((Float) objArr[0]).floatValue() - alpha);
        int componentCount = color2.getComponentCount() + (((Integer) objArr[2]).intValue() ^ 7329843);
        components2[componentCount] = alpha + alpha2;
        if (components2[componentCount] > 0.0f) {
            alpha /= components2[componentCount];
            alpha2 /= components2[componentCount];
        }
        for (int i2 = 0; i2 < componentCount; i2 = (((Integer) objArr[1]).intValue() ^ 8153599) + i2) {
            components2[i2] = (components[i2] * alpha) + (components2[i2] * alpha2);
        }
        return Color.valueOf(components2, color2.getColorSpace());
    }

    private static int compositeComponent(int i2, int i3, int i4, int i5, int i6) {
        Object[] objArr = {new Integer(7936107), new Integer(3377848), new Integer(4282942)};
        if (i6 == 0) {
            return 0;
        }
        return ((((((Integer) objArr[2]).intValue() ^ 4283073) * i2) * i3) + (((((Integer) objArr[0]).intValue() ^ 7936148) - i3) * (i4 * i5))) / ((((Integer) objArr[1]).intValue() ^ 3377735) * i6);
    }

    private static float constrain(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private static int constrain(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        Object[] objArr = {new Integer(2302739), new Integer(2618175), new Double(2.0d)};
        double d2 = dArr[0];
        double d3 = dArr2[0];
        double doubleValue = ((Double) objArr[2]).doubleValue();
        double pow = Math.pow(d2 - d3, doubleValue);
        int intValue = ((Integer) objArr[1]).intValue() ^ 2618174;
        double pow2 = Math.pow(dArr[intValue] - dArr2[intValue], doubleValue);
        int intValue2 = ((Integer) objArr[0]).intValue() ^ 2302737;
        return Math.sqrt(Math.pow(dArr[intValue2] - dArr2[intValue2], doubleValue) + pow + pow2);
    }

    private static double[] getTempDouble3Array() {
        Integer num = new Integer(4185489);
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[((Integer) new Object[]{num}[0]).intValue() ^ 4185490];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d2) {
        Object[] objArr = {new Double(16.0d), new Double(0.3333333333333333d), new Double(XYZ_EPSILON), new Double(XYZ_KAPPA), new Double(116.0d)};
        return d2 > ((Double) objArr[2]).doubleValue() ? Math.pow(d2, ((Double) objArr[1]).doubleValue()) : ((((Double) objArr[3]).doubleValue() * d2) + ((Double) objArr[0]).doubleValue()) / ((Double) objArr[4]).doubleValue();
    }

    public static int setAlphaComponent(int i2, int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return (16777215 & i2) | (i3 << 24);
        }
        throw new IllegalArgumentException(C0108.m52(f0short, 1754405 ^ C0008.m27((Object) "ۧۥۡ"), 1752552 ^ C0008.m27((Object) "ۥۡۤ"), C0008.m27((Object) "ۥۤۥ") ^ 1752916));
    }
}
