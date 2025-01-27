package android.support.v4.graphics;

import android.graphics.Path;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0006;
import android.util.Log;
import com.google.gason.stream.C0106;
import com.tencent.a.C0521;
import com.tencent.a.model.C0519;
import com.tencent.as.C0523;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class PathParser {
    private static final String LOGTAG;

    /* renamed from: short */
    private static final short[] f2short;

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    public static class PathDataNode {

        /* renamed from: short */
        private static final short[] f3short;
        public float[] mParams;
        public char mType;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(6869735)}[0]).intValue() ^ 6869726];
            sArr[0] = 1152;
            sArr[1] = 1201;
            sArr[2] = 1188;
            sArr[3] = 1208;
            sArr[4] = 1152;
            sArr[5] = 1201;
            sArr[6] = 1186;
            sArr[7] = 1187;
            sArr[8] = 1205;
            sArr[9] = 1186;
            sArr[10] = 2039;
            sArr[11] = 1927;
            sArr[12] = 1976;
            sArr[13] = 1982;
            sArr[14] = 1977;
            sArr[15] = 1955;
            sArr[16] = 1956;
            sArr[17] = 2039;
            sArr[18] = 1974;
            sArr[19] = 1957;
            sArr[20] = 1970;
            sArr[21] = 2039;
            sArr[22] = 1972;
            sArr[23] = 1976;
            sArr[24] = 1982;
            sArr[25] = 1977;
            sArr[26] = 1972;
            sArr[27] = 1982;
            sArr[28] = 1971;
            sArr[29] = 1970;
            sArr[30] = 1977;
            sArr[31] = 1955;
            sArr[32] = 646;
            sArr[33] = 697;
            sArr[34] = 703;
            sArr[35] = 696;
            sArr[36] = 674;
            sArr[37] = 677;
            sArr[38] = 758;
            sArr[39] = 695;
            sArr[40] = 676;
            sArr[41] = 691;
            sArr[42] = 758;
            sArr[43] = 674;
            sArr[44] = 697;
            sArr[45] = 697;
            sArr[46] = 758;
            sArr[47] = 688;
            sArr[48] = 695;
            sArr[49] = 676;
            sArr[50] = 758;
            sArr[51] = 695;
            sArr[52] = 678;
            sArr[53] = 695;
            sArr[54] = 676;
            sArr[55] = 674;
            sArr[56] = 758;
            f3short = sArr;
        }

        PathDataNode(char c2, float[] fArr) {
            this.mType = c2;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        private static void addCommand(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            Path path2;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            Object[] objArr = {new Integer(5903581), new Integer(3712026), new Integer(2526481), new Integer(1349278), new Integer(2873166), new Integer(3724764), new Integer(7191433), new Integer(3504140), new Integer(4541702), new Integer(4449355), new Integer(2692320), new Integer(7066604), new Integer(1876748), new Integer(3392573), new Integer(7697073), new Integer(7557829), new Integer(4296363), new Integer(9229196), new Integer(952439), new Integer(5130975), new Integer(6130021), new Integer(2370816), new Integer(8483967), new Integer(5071735), new Integer(7013854), new Integer(431891), new Integer(7925977), new Integer(2290185), new Integer(2355437), new Integer(5621502), new Integer(6897973), new Integer(414277), new Integer(5476466), new Integer(1205174), new Integer(6879277), new Integer(3907679), new Integer(6738556), new Integer(6420190), new Integer(7211651), new Integer(6538825), new Integer(2588111), new Integer(8223613), new Integer(7886450), new Integer(1352728), new Integer(885732), new Integer(4182225), new Integer(5077052), new Integer(3546567), new Integer(1825881), new Integer(2186100), new Integer(1336338), new Integer(3253170), new Integer(5939236), new Integer(5587705), new Integer(2682250), new Integer(4952209), new Integer(5269386), new Integer(315787), new Integer(8965074), new Integer(4142144), new Integer(6268720), new Integer(3392667), new Integer(7206287), new Integer(6397469), new Integer(8280491), new Integer(5617230), new Integer(6591646), new Integer(4155798), new Integer(465407), new Integer(1299622), new Integer(5455223), new Integer(5703633), new Integer(6024901), new Integer(2686084), new Integer(3084094), new Integer(1126464), new Integer(7439754), new Integer(1299356), new Integer(9315403), new Integer(7384693)};
            float f16 = fArr[0];
            float f17 = fArr[((Integer) objArr[31]).intValue() ^ 414276];
            float f18 = fArr[((Integer) objArr[79]).intValue() ^ 7384695];
            float f19 = fArr[((Integer) objArr[62]).intValue() ^ 7206284];
            int intValue = ((Integer) objArr[29]).intValue() ^ 5621498;
            float f20 = fArr[intValue];
            int intValue2 = ((Integer) objArr[34]).intValue() ^ 6879272;
            float f21 = fArr[intValue2];
            switch (c3) {
                case 'A':
                case 'a':
                    i2 = 7;
                    f2 = f19;
                    f3 = f18;
                    f4 = f17;
                    f5 = f16;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    f2 = f19;
                    f3 = f18;
                    f4 = f17;
                    f5 = f16;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    f2 = f19;
                    f3 = f18;
                    f4 = f17;
                    f5 = f16;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    i2 = 2;
                    f2 = f19;
                    f3 = f18;
                    f4 = f17;
                    f5 = f16;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    f2 = f19;
                    f3 = f18;
                    f4 = f17;
                    f5 = f16;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f20, f21);
                    i2 = 2;
                    f3 = f20;
                    f4 = f21;
                    f5 = f20;
                    f2 = f21;
                    break;
                default:
                    i2 = 2;
                    f2 = f19;
                    f3 = f18;
                    f4 = f17;
                    f5 = f16;
                    break;
            }
            float f22 = f5;
            float f23 = f4;
            float f24 = f20;
            float f25 = f21;
            Path path3 = path;
            int i3 = 0;
            while (true) {
                float f26 = f3;
                float f27 = f2;
                if (i3 >= fArr2.length) {
                    fArr[0] = f22;
                    fArr[((Integer) objArr[49]).intValue() ^ 2186101] = f23;
                    fArr[((Integer) objArr[55]).intValue() ^ 4952211] = f26;
                    fArr[((Integer) objArr[39]).intValue() ^ 6538826] = f27;
                    fArr[intValue] = f24;
                    fArr[intValue2] = f25;
                    return;
                }
                switch (c3) {
                    case 'A':
                        drawArc(path, f22, f23, fArr2[(((Integer) objArr[23]).intValue() ^ 5071730) + i3], fArr2[(((Integer) objArr[4]).intValue() ^ 2873160) + i3], fArr2[i3 + 0], fArr2[(((Integer) objArr[43]).intValue() ^ 1352729) + i3], fArr2[(((Integer) objArr[63]).intValue() ^ 6397471) + i3], fArr2[(((Integer) objArr[68]).intValue() ^ 465404) + i3] != 0.0f, fArr2[(((Integer) objArr[66]).intValue() ^ 6591642) + i3] != 0.0f);
                        float f28 = fArr2[(((Integer) objArr[18]).intValue() ^ 952434) + i3];
                        float f29 = fArr2[(((Integer) objArr[36]).intValue() ^ 6738554) + i3];
                        f6 = f28;
                        f7 = f29;
                        f8 = f24;
                        f9 = f25;
                        f3 = f28;
                        f2 = f29;
                        path2 = path3;
                        break;
                    case 'C':
                        path.cubicTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[13]).intValue() ^ 3392572) + i3], fArr2[(((Integer) objArr[46]).intValue() ^ 5077054) + i3], fArr2[(((Integer) objArr[56]).intValue() ^ 5269385) + i3], fArr2[(((Integer) objArr[38]).intValue() ^ 7211655) + i3], fArr2[(((Integer) objArr[72]).intValue() ^ 6024896) + i3]);
                        float f30 = fArr2[(((Integer) objArr[2]).intValue() ^ 2526485) + i3];
                        float f31 = fArr2[(((Integer) objArr[11]).intValue() ^ 7066601) + i3];
                        float f32 = fArr2[(((Integer) objArr[14]).intValue() ^ 7697075) + i3];
                        f6 = f30;
                        f7 = f31;
                        f8 = f24;
                        f2 = fArr2[(((Integer) objArr[44]).intValue() ^ 885735) + i3];
                        path2 = path3;
                        f3 = f32;
                        f9 = f25;
                        break;
                    case 'H':
                        path3.lineTo(fArr2[i3 + 0], f23);
                        f6 = fArr2[i3 + 0];
                        f7 = f23;
                        f8 = f24;
                        f2 = f27;
                        path2 = path3;
                        f3 = f26;
                        f9 = f25;
                        break;
                    case 'L':
                        path3.lineTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[35]).intValue() ^ 3907678) + i3]);
                        f6 = fArr2[i3 + 0];
                        f7 = fArr2[(((Integer) objArr[73]).intValue() ^ 2686085) + i3];
                        f8 = f24;
                        f2 = f27;
                        path2 = path3;
                        f3 = f26;
                        f9 = f25;
                        break;
                    case 'M':
                        float f33 = fArr2[i3 + 0];
                        float f34 = fArr2[(((Integer) objArr[51]).intValue() ^ 3253171) + i3];
                        if (i3 <= 0) {
                            path3.moveTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[32]).intValue() ^ 5476467) + i3]);
                            f6 = f33;
                            f7 = f34;
                            f8 = f33;
                            f2 = f27;
                            path2 = path3;
                            f3 = f26;
                            f9 = f34;
                            break;
                        } else {
                            path3.lineTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[12]).intValue() ^ 1876749) + i3]);
                            f6 = f33;
                            f7 = f34;
                            f8 = f24;
                            f2 = f27;
                            path2 = path3;
                            f3 = f26;
                            f9 = f25;
                            break;
                        }
                    case 'Q':
                        path3.quadTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[28]).intValue() ^ 2355436) + i3], fArr2[(((Integer) objArr[20]).intValue() ^ 6130023) + i3], fArr2[(((Integer) objArr[67]).intValue() ^ 4155797) + i3]);
                        float f35 = fArr2[i3 + 0];
                        float f36 = fArr2[(((Integer) objArr[9]).intValue() ^ 4449354) + i3];
                        f6 = fArr2[(((Integer) objArr[71]).intValue() ^ 5703635) + i3];
                        f7 = fArr2[(((Integer) objArr[48]).intValue() ^ 1825882) + i3];
                        f8 = f24;
                        f2 = f36;
                        path2 = path3;
                        f3 = f35;
                        f9 = f25;
                        break;
                    case 'S':
                        if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                            float f37 = (2.0f * f22) - f26;
                            f10 = (2.0f * f23) - f27;
                            f11 = f37;
                        } else {
                            f11 = f22;
                            f10 = f23;
                        }
                        path.cubicTo(f11, f10, fArr2[i3 + 0], fArr2[(((Integer) objArr[78]).intValue() ^ 9315402) + i3], fArr2[(((Integer) objArr[60]).intValue() ^ 6268722) + i3], fArr2[(((Integer) objArr[57]).intValue() ^ 315784) + i3]);
                        float f38 = fArr2[i3 + 0];
                        float f39 = fArr2[(((Integer) objArr[5]).intValue() ^ 3724765) + i3];
                        f6 = fArr2[(((Integer) objArr[37]).intValue() ^ 6420188) + i3];
                        f7 = fArr2[(((Integer) objArr[19]).intValue() ^ 5130972) + i3];
                        f8 = f24;
                        f2 = f39;
                        path2 = path3;
                        f3 = f38;
                        f9 = f25;
                        break;
                    case 'T':
                        if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                            f22 = (2.0f * f22) - f26;
                            f23 = (2.0f * f23) - f27;
                        }
                        path3.quadTo(f22, f23, fArr2[i3 + 0], fArr2[(((Integer) objArr[6]).intValue() ^ 7191432) + i3]);
                        f6 = fArr2[i3 + 0];
                        f7 = fArr2[(((Integer) objArr[7]).intValue() ^ 3504141) + i3];
                        f8 = f24;
                        f9 = f25;
                        f3 = f22;
                        f2 = f23;
                        path2 = path3;
                        break;
                    case 'V':
                        path.lineTo(f22, fArr2[i3 + 0]);
                        f6 = f22;
                        f7 = fArr2[i3 + 0];
                        f8 = f24;
                        f2 = f27;
                        path2 = path;
                        f3 = f26;
                        f9 = f25;
                        break;
                    case 'a':
                        drawArc(path, f22, f23, fArr2[(((Integer) objArr[53]).intValue() ^ 5587708) + i3] + f22, fArr2[(((Integer) objArr[75]).intValue() ^ 1126470) + i3] + f23, fArr2[i3 + 0], fArr2[(((Integer) objArr[54]).intValue() ^ 2682251) + i3], fArr2[(((Integer) objArr[3]).intValue() ^ 1349276) + i3], fArr2[(((Integer) objArr[16]).intValue() ^ 4296360) + i3] != 0.0f, fArr2[(((Integer) objArr[50]).intValue() ^ 1336342) + i3] != 0.0f);
                        float f40 = f22 + fArr2[(((Integer) objArr[70]).intValue() ^ 5455218) + i3];
                        float f41 = f23 + fArr2[(((Integer) objArr[21]).intValue() ^ 2370822) + i3];
                        f6 = f40;
                        f7 = f41;
                        f8 = f24;
                        f9 = f25;
                        f3 = f40;
                        f2 = f41;
                        path2 = path;
                        break;
                    case 'c':
                        path.rCubicTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[30]).intValue() ^ 6897972) + i3], fArr2[(((Integer) objArr[15]).intValue() ^ 7557831) + i3], fArr2[(((Integer) objArr[65]).intValue() ^ 5617229) + i3], fArr2[(((Integer) objArr[41]).intValue() ^ 8223609) + i3], fArr2[(((Integer) objArr[0]).intValue() ^ 5903576) + i3]);
                        float f42 = fArr2[(((Integer) objArr[1]).intValue() ^ 3712024) + i3];
                        float f43 = fArr2[(((Integer) objArr[27]).intValue() ^ 2290186) + i3];
                        f6 = f22 + fArr2[(((Integer) objArr[24]).intValue() ^ 7013850) + i3];
                        float f44 = f42 + f22;
                        float f45 = f23 + f43;
                        f7 = f23 + fArr2[(((Integer) objArr[17]).intValue() ^ 9229193) + i3];
                        f8 = f24;
                        f2 = f45;
                        path2 = path3;
                        f3 = f44;
                        f9 = f25;
                        break;
                    case 'h':
                        path3.rLineTo(fArr2[i3 + 0], 0.0f);
                        f6 = f22 + fArr2[i3 + 0];
                        f7 = f23;
                        f8 = f24;
                        f2 = f27;
                        path2 = path3;
                        f3 = f26;
                        f9 = f25;
                        break;
                    case 'l':
                        path3.rLineTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[74]).intValue() ^ 3084095) + i3]);
                        f6 = f22 + fArr2[i3 + 0];
                        f7 = f23 + fArr2[(((Integer) objArr[10]).intValue() ^ 2692321) + i3];
                        f8 = f24;
                        f2 = f27;
                        path2 = path3;
                        f3 = f26;
                        f9 = f25;
                        break;
                    case 'm':
                        float f46 = f22 + fArr2[i3 + 0];
                        float f47 = f23 + fArr2[(((Integer) objArr[42]).intValue() ^ 7886451) + i3];
                        if (i3 <= 0) {
                            path3.rMoveTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[47]).intValue() ^ 3546566) + i3]);
                            f6 = f46;
                            f7 = f47;
                            f8 = f46;
                            f2 = f27;
                            path2 = path3;
                            f3 = f26;
                            f9 = f47;
                            break;
                        } else {
                            path3.rLineTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[40]).intValue() ^ 2588110) + i3]);
                            f6 = f46;
                            f7 = f47;
                            f8 = f24;
                            f2 = f27;
                            path2 = path3;
                            f3 = f26;
                            f9 = f25;
                            break;
                        }
                    case 'q':
                        path3.rQuadTo(fArr2[i3 + 0], fArr2[(((Integer) objArr[45]).intValue() ^ 4182224) + i3], fArr2[(((Integer) objArr[25]).intValue() ^ 431889) + i3], fArr2[(((Integer) objArr[52]).intValue() ^ 5939239) + i3]);
                        float f48 = fArr2[i3 + 0];
                        float f49 = fArr2[(((Integer) objArr[61]).intValue() ^ 3392666) + i3];
                        f6 = f22 + fArr2[(((Integer) objArr[22]).intValue() ^ 8483965) + i3];
                        float f50 = f48 + f22;
                        float f51 = f23 + f49;
                        f7 = f23 + fArr2[(((Integer) objArr[76]).intValue() ^ 7439753) + i3];
                        f8 = f24;
                        f2 = f51;
                        path2 = path3;
                        f3 = f50;
                        f9 = f25;
                        break;
                    case 's':
                        if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                            float f52 = f22 - f26;
                            f12 = f23 - f27;
                            f13 = f52;
                        } else {
                            f13 = 0.0f;
                            f12 = 0.0f;
                        }
                        path.rCubicTo(f13, f12, fArr2[i3 + 0], fArr2[(((Integer) objArr[33]).intValue() ^ 1205175) + i3], fArr2[(((Integer) objArr[58]).intValue() ^ 8965072) + i3], fArr2[(((Integer) objArr[26]).intValue() ^ 7925978) + i3]);
                        float f53 = fArr2[i3 + 0];
                        float f54 = fArr2[(((Integer) objArr[77]).intValue() ^ 1299357) + i3];
                        f6 = f22 + fArr2[(((Integer) objArr[59]).intValue() ^ 4142146) + i3];
                        float f55 = f53 + f22;
                        float f56 = f23 + f54;
                        f7 = f23 + fArr2[(((Integer) objArr[69]).intValue() ^ 1299621) + i3];
                        f8 = f24;
                        f2 = f56;
                        path2 = path3;
                        f3 = f55;
                        f9 = f25;
                        break;
                    case 't':
                        if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                            f14 = f22 - f26;
                            f15 = f23 - f27;
                        } else {
                            f15 = 0.0f;
                            f14 = 0.0f;
                        }
                        path3.rQuadTo(f14, f15, fArr2[i3 + 0], fArr2[(((Integer) objArr[64]).intValue() ^ 8280490) + i3]);
                        f6 = f22 + fArr2[i3 + 0];
                        f7 = f23 + fArr2[(((Integer) objArr[8]).intValue() ^ 4541703) + i3];
                        f8 = f24;
                        f2 = f15 + f23;
                        path2 = path3;
                        f3 = f14 + f22;
                        f9 = f25;
                        break;
                    case 'v':
                        path3.rLineTo(0.0f, fArr2[i3 + 0]);
                        f6 = f22;
                        f7 = f23 + fArr2[i3 + 0];
                        f8 = f24;
                        f2 = f27;
                        path2 = path3;
                        f3 = f26;
                        f9 = f25;
                        break;
                    default:
                        f6 = f22;
                        f7 = f23;
                        f8 = f24;
                        f2 = f27;
                        path2 = path3;
                        f3 = f26;
                        f9 = f25;
                        break;
                }
                c2 = c3;
                f22 = f6;
                f23 = f7;
                f24 = f8;
                f25 = f9;
                path3 = path2;
                i3 += i2;
            }
        }

        private static void arcToBezier(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            Object[] objArr = {new Double(1.0d), new Double(2.0d), new Double(3.141592653589793d), new Double(3.0d), new Double(4.0d), new Double(4.0d), new Integer(7132478)};
            int ceil = (int) Math.ceil(Math.abs((d10 * ((Double) objArr[4]).doubleValue()) / ((Double) objArr[2]).doubleValue()));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d11 = (d5 * cos * cos2) + ((-d4) * sin * sin2);
            double d12 = d10 / ceil;
            double d13 = (sin2 * ((-d4) * cos)) - (cos2 * (d5 * sin));
            int i2 = 0;
            while (i2 < ceil) {
                double d14 = d9 + d12;
                double sin3 = Math.sin(d14);
                double cos3 = Math.cos(d14);
                double d15 = (((d4 * cos) * cos3) + d2) - ((d5 * sin) * sin3);
                double d16 = (d5 * cos * sin3) + (d4 * sin * cos3) + d3;
                double d17 = (((-d4) * cos) * sin3) - ((d5 * sin) * cos3);
                double d18 = (cos3 * d5 * cos) + (sin3 * (-d4) * sin);
                double tan = Math.tan((d14 - d9) / ((Double) objArr[1]).doubleValue());
                double sin4 = Math.sin(d14 - d9);
                double doubleValue = ((Double) objArr[3]).doubleValue();
                double sqrt = ((Math.sqrt(((Double) objArr[5]).doubleValue() + (tan * (tan * doubleValue))) - ((Double) objArr[0]).doubleValue()) * sin4) / doubleValue;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((sqrt * d13) + d6), (float) ((d11 * sqrt) + d7), (float) (d15 - (sqrt * d17)), (float) (d16 - (sqrt * d18)), (float) d15, (float) d16);
                d9 = d14;
                i2 = (((Integer) objArr[6]).intValue() ^ 7132479) + i2;
                d11 = d18;
                d13 = d17;
                d7 = d16;
                d6 = d15;
            }
        }

        private static void drawArc(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            Object[] objArr = {new Double(0.25d), new Double(1.99999d), new Double(0.0d), new Double(6.283185307179586d), new Double(2.0d), new Double(0.0d), new Double(1.0d)};
            double radians = Math.toRadians(f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = ((f2 * cos) + (f3 * sin)) / f6;
            double d5 = (((-f2) * sin) + (f3 * cos)) / f7;
            double d6 = ((f4 * cos) + (f5 * sin)) / f6;
            double d7 = (((-f4) * sin) + (f5 * cos)) / f7;
            double d8 = d4 - d6;
            double d9 = d5 - d7;
            double doubleValue = ((Double) objArr[4]).doubleValue();
            double d10 = (d4 + d6) / doubleValue;
            double d11 = (d5 + d7) / doubleValue;
            double d12 = (d9 * d9) + (d8 * d8);
            double doubleValue2 = ((Double) objArr[2]).doubleValue();
            String m11 = C0003.m11(f3short, 1750627 ^ C0008.m27((Object) "ۣۢۢ"), 1752744 ^ C0008.m27((Object) "ۥۨۥ"), C0008.m27((Object) "ۦ۟ۥ") ^ 1754524);
            if (d12 == doubleValue2) {
                Log.w(m11, C0519.m65(f3short, 1748882 ^ C0008.m27((Object) "ۡۨ۟"), 1747785 ^ C0008.m27((Object) "ۣ۠ۤ"), C0008.m27((Object) "ۨۥۨ") ^ 1756764));
                return;
            }
            double doubleValue3 = (((Double) objArr[6]).doubleValue() / d12) - ((Double) objArr[0]).doubleValue();
            if (doubleValue3 < doubleValue2) {
                Log.w(m11, C0004.m13(f3short, 1754475 ^ C0008.m27((Object) "ۧۡۥ"), 1747673 ^ C0008.m27((Object) "۠۟۟"), C0008.m27((Object) "ۦۢ") ^ 56938) + d12);
                float sqrt = (float) (Math.sqrt(d12) / ((Double) objArr[1]).doubleValue());
                drawArc(path, f2, f3, f4, f5, f6 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(doubleValue3);
            double d13 = d8 * sqrt2;
            double d14 = sqrt2 * d9;
            if (z == z2) {
                d2 = d13 + d11;
                d3 = d10 - d14;
            } else {
                d2 = d11 - d13;
                d3 = d14 + d10;
            }
            double atan2 = Math.atan2(d5 - d2, d4 - d3);
            double atan22 = Math.atan2(d7 - d2, d6 - d3) - atan2;
            double doubleValue4 = ((Double) objArr[5]).doubleValue();
            if (z2 != (atan22 >= doubleValue4)) {
                double doubleValue5 = ((Double) objArr[3]).doubleValue();
                atan22 = atan22 > doubleValue4 ? atan22 - doubleValue5 : atan22 + doubleValue5;
            }
            double d15 = f6 * d3;
            double d16 = d2 * f7;
            arcToBezier(path, (d15 * cos) - (d16 * sin), (d16 * cos) + (d15 * sin), f6, f7, f2, f3, radians, atan2, atan22);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            Object[] objArr = {new Integer(3801797), new Integer(3510684)};
            float[] fArr = new float[((Integer) objArr[0]).intValue() ^ 3801795];
            char c2 = 'm';
            int i2 = 0;
            while (i2 < pathDataNodeArr.length) {
                addCommand(path, fArr, c2, pathDataNodeArr[i2].mType, pathDataNodeArr[i2].mParams);
                char c3 = pathDataNodeArr[i2].mType;
                i2 = (((Integer) objArr[1]).intValue() ^ 3510685) + i2;
                c2 = c3;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f2) {
            Object[] objArr = {new Float(1.0f), new Integer(8840752)};
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i2 >= fArr.length) {
                    return;
                }
                this.mParams[i2] = ((((Float) objArr[0]).floatValue() - f2) * fArr[i2]) + (pathDataNode2.mParams[i2] * f2);
                i2 = (((Integer) objArr[1]).intValue() ^ 8840753) + i2;
            }
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(3875092)}[0]).intValue() ^ 3875130];
        sArr[0] = 2324;
        sArr[1] = 2341;
        sArr[2] = 2352;
        sArr[3] = 2348;
        sArr[4] = 2324;
        sArr[5] = 2341;
        sArr[6] = 2358;
        sArr[7] = 2359;
        sArr[8] = 2337;
        sArr[9] = 2358;
        sArr[10] = 770;
        sArr[11] = 821;
        sArr[12] = 821;
        sArr[13] = 808;
        sArr[14] = 821;
        sArr[15] = 871;
        sArr[16] = 814;
        sArr[17] = 809;
        sArr[18] = 871;
        sArr[19] = 823;
        sArr[20] = 806;
        sArr[21] = 821;
        sArr[22] = 820;
        sArr[23] = 814;
        sArr[24] = 809;
        sArr[25] = 800;
        sArr[26] = 871;
        sArr[27] = 2641;
        sArr[28] = 2630;
        sArr[29] = 2630;
        sArr[30] = 2651;
        sArr[31] = 2630;
        sArr[32] = 2580;
        sArr[33] = 2653;
        sArr[34] = 2650;
        sArr[35] = 2580;
        sArr[36] = 2628;
        sArr[37] = 2645;
        sArr[38] = 2630;
        sArr[39] = 2631;
        sArr[40] = 2653;
        sArr[41] = 2650;
        sArr[42] = 2643;
        sArr[43] = 2580;
        sArr[44] = 2582;
        sArr[45] = 1150;
        f2short = sArr;
        LOGTAG = C0523.m77(f2short, 1752705 ^ C0008.m27((Object) "ۥۣۧ"), 56470 ^ C0008.m27((Object) "ۥۡ"), C0008.m27((Object) "ۣ۟۠") ^ 1748536);
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        arrayList.add(new PathDataNode(c2, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        Integer num = new Integer(5913244);
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 5913245) + i2) {
            if (pathDataNodeArr[i2].mType != pathDataNodeArr2[i2].mType || pathDataNodeArr[i2].mParams.length != pathDataNodeArr2[i2].mParams.length) {
                return false;
            }
        }
        return true;
    }

    static float[] copyOfRange(float[] fArr, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i2 < 0 || i2 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = i3 - i2;
        int min = Math.min(i4, length - i2);
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, i2, fArr2, 0, min);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        Integer num = new Integer(4303785);
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int nextStart = nextStart(str, i2);
            String trim = str.substring(i3, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 4303784) + nextStart;
            i3 = nextStart;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            addNode(arrayList, str.charAt(i3), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException(C0006.m19(f2short, 1750825 ^ C0008.m27((Object) "ۣۨۨ"), 1747702 ^ C0008.m27((Object) "۠۠ۧ"), C0008.m27((Object) "ۡۥۡ") ^ 1748090) + str, e2);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        Integer num = new Integer(2600522);
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 2600523) + i2) {
            pathDataNodeArr2[i2] = new PathDataNode(pathDataNodeArr[i2]);
        }
        return pathDataNodeArr2;
    }

    private static void extract(String str, int i2, ExtractFloatResult extractFloatResult) {
        boolean z;
        boolean z2;
        boolean z3;
        Integer num = new Integer(9681722);
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i3 = i2;
        while (i3 < str.length()) {
            switch (str.charAt(i3)) {
                case ' ':
                case ',':
                    z = z5;
                    z2 = true;
                    z3 = false;
                    break;
                case '-':
                    if (i3 != i2 && !z4) {
                        extractFloatResult.mEndWithNegOrDot = true;
                        z = z5;
                        z2 = true;
                        z3 = false;
                        break;
                    } else {
                        z2 = z6;
                        z = z5;
                        z3 = false;
                        break;
                    }
                case '.':
                    if (!z5) {
                        z3 = false;
                        z2 = z6;
                        z = true;
                        break;
                    } else {
                        extractFloatResult.mEndWithNegOrDot = true;
                        z = z5;
                        z2 = true;
                        z3 = false;
                        break;
                    }
                case 'E':
                case 'e':
                    z2 = z6;
                    z = z5;
                    z3 = true;
                    break;
                default:
                    z2 = z6;
                    z = z5;
                    z3 = false;
                    break;
            }
            if (z2) {
                extractFloatResult.mEndPosition = i3;
            }
            i3 = (((Integer) new Object[]{num}[0]).intValue() ^ 9681723) + i3;
            z4 = z3;
            z5 = z;
            z6 = z2;
        }
        extractFloatResult.mEndPosition = i3;
    }

    private static float[] getFloats(String str) {
        int i2 = 0;
        Object[] objArr = {new Integer(3224115), new Integer(7070967)};
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i3 = 1;
            while (i3 < length) {
                extract(str, i3, extractFloatResult);
                int i4 = extractFloatResult.mEndPosition;
                if (i3 < i4) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    fArr[i2] = Float.parseFloat(str.substring(i3, i4));
                    i2 = (intValue ^ 3224114) + i2;
                }
                i3 = extractFloatResult.mEndWithNegOrDot ? i4 : (((Integer) objArr[1]).intValue() ^ 7070966) + i4;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e2) {
            throw new RuntimeException(C0106.m46(f2short, 1752711 ^ C0008.m27((Object) "ۥۨ۟"), 1746861 ^ C0008.m27((Object) "۟ۥۥ"), C0008.m27((Object) "ۨۡۤ") ^ 1753919) + str + C0521.m71(f2short, 1750833 ^ C0008.m27((Object) "ۣۨۡ"), 1752675 ^ C0008.m27((Object) "ۥۦۣ"), C0008.m27((Object) "ۦ") ^ 698), e2);
        }
    }

    private static int nextStart(String str, int i2) {
        Object[] objArr = {new Integer(-9115817), new Integer(-5069205), new Integer(-8812898), new Integer(-2782726), new Integer(1589225)};
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if ((((((Integer) objArr[0]).intValue() ^ 9115889) + charAt) * (charAt + (((Integer) objArr[1]).intValue() ^ 5069268)) <= 0 || ((((Integer) objArr[2]).intValue() ^ 8812824) + charAt) * (charAt + (((Integer) objArr[3]).intValue() ^ 2782821)) <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i2 += ((Integer) objArr[4]).intValue() ^ 1589224;
        }
        return i2;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        Object[] objArr = {new Integer(6481822), new Integer(8982348)};
        for (int i2 = 0; i2 < pathDataNodeArr2.length; i2 = (((Integer) objArr[0]).intValue() ^ 6481823) + i2) {
            pathDataNodeArr[i2].mType = pathDataNodeArr2[i2].mType;
            for (int i3 = 0; i3 < pathDataNodeArr2[i2].mParams.length; i3 = (((Integer) objArr[1]).intValue() ^ 8982349) + i3) {
                pathDataNodeArr[i2].mParams[i3] = pathDataNodeArr2[i2].mParams[i3];
            }
        }
    }
}
