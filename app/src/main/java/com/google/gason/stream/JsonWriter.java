package com.google.gason.stream;

import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import com.google.gason.C0107;
import com.google.gason.C0108;
import com.google.gason.internal.C0104;
import com.google.gason.reflect.C0105;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.a.utils.C0520;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class JsonWriter implements Closeable {

    /* renamed from: short */
    private static final short[] f102short;
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private final List<JsonScope> stack;

    /* renamed from: com.google.gason.stream.JsonWriter$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final int[] $SwitchMap$com$gaagle$gson$stream$JsonScope;

        static {
            int[] iArr = new int[JsonScope.values().length];
            $SwitchMap$com$gaagle$gson$stream$JsonScope = iArr;
            try {
                iArr[JsonScope.EMPTY_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.EMPTY_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.NONEMPTY_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.DANGLING_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.NONEMPTY_DOCUMENT.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4918141)}[0]).intValue() ^ 4917813];
        sArr[0] = 841;
        sArr[1] = 1269;
        sArr[2] = 1263;
        sArr[3] = 1262;
        sArr[4] = 1210;
        sArr[5] = 1191;
        sArr[6] = 1191;
        sArr[7] = 1210;
        sArr[8] = 1268;
        sArr[9] = 1263;
        sArr[10] = 1270;
        sArr[11] = 1270;
        sArr[12] = 1136;
        sArr[13] = 1115;
        sArr[14] = 1101;
        sArr[15] = 1098;
        sArr[16] = 1111;
        sArr[17] = 1104;
        sArr[18] = 1113;
        sArr[19] = 1054;
        sArr[20] = 1102;
        sArr[21] = 1100;
        sArr[22] = 1105;
        sArr[23] = 1116;
        sArr[24] = 1106;
        sArr[25] = 1115;
        sArr[26] = 1107;
        sArr[27] = 1028;
        sArr[28] = 1054;
        sArr[29] = 462;
        sArr[30] = 485;
        sArr[31] = 499;
        sArr[32] = 500;
        sArr[33] = 489;
        sArr[34] = 494;
        sArr[35] = 487;
        sArr[36] = 416;
        sArr[37] = 496;
        sArr[38] = 498;
        sArr[39] = 495;
        sArr[40] = 482;
        sArr[41] = 492;
        sArr[42] = 485;
        sArr[43] = 493;
        sArr[44] = 442;
        sArr[45] = 416;
        sArr[46] = 1050;
        sArr[47] = 1027;
        sArr[48] = 1055;
        sArr[49] = 1054;
        sArr[50] = 1136;
        sArr[51] = 1085;
        sArr[52] = 1061;
        sArr[53] = 1059;
        sArr[54] = 1060;
        sArr[55] = 1136;
        sArr[56] = 1080;
        sArr[57] = 1073;
        sArr[58] = 1062;
        sArr[59] = 1077;
        sArr[60] = 1136;
        sArr[61] = 1087;
        sArr[62] = 1086;
        sArr[63] = 1084;
        sArr[64] = 1065;
        sArr[65] = 1136;
        sArr[66] = 1087;
        sArr[67] = 1086;
        sArr[68] = 1077;
        sArr[69] = 1136;
        sArr[70] = 1060;
        sArr[71] = 1087;
        sArr[72] = 1056;
        sArr[73] = 1149;
        sArr[74] = 1084;
        sArr[75] = 1077;
        sArr[76] = 1062;
        sArr[77] = 1077;
        sArr[78] = 1084;
        sArr[79] = 1136;
        sArr[80] = 1062;
        sArr[81] = 1073;
        sArr[82] = 1084;
        sArr[83] = 1061;
        sArr[84] = 1077;
        sArr[85] = 1150;
        sArr[86] = 3282;
        sArr[87] = 3275;
        sArr[88] = 3287;
        sArr[89] = 3286;
        sArr[90] = 3256;
        sArr[91] = 3317;
        sArr[92] = 3309;
        sArr[93] = 3307;
        sArr[94] = 3308;
        sArr[95] = 3256;
        sArr[96] = 3307;
        sArr[97] = 3308;
        sArr[98] = 3321;
        sArr[99] = 3306;
        sArr[100] = 3308;
        sArr[101] = 3256;
        sArr[102] = 3311;
        sArr[103] = 3313;
        sArr[104] = 3308;
        sArr[105] = 3312;
        sArr[106] = 3256;
        sArr[107] = 3321;
        sArr[108] = 3318;
        sArr[109] = 3256;
        sArr[110] = 3321;
        sArr[111] = 3306;
        sArr[112] = 3306;
        sArr[113] = 3321;
        sArr[114] = 3297;
        sArr[115] = 3256;
        sArr[116] = 3319;
        sArr[117] = 3306;
        sArr[118] = 3256;
        sArr[119] = 3321;
        sArr[120] = 3318;
        sArr[121] = 3256;
        sArr[122] = 3319;
        sArr[123] = 3322;
        sArr[124] = 3314;
        sArr[125] = 3325;
        sArr[126] = 3323;
        sArr[127] = 3308;
        sArr[128] = 3254;
        sArr[129] = 2044;
        sArr[130] = 2007;
        sArr[131] = 1985;
        sArr[132] = 1990;
        sArr[133] = 2011;
        sArr[134] = 2012;
        sArr[135] = 2005;
        sArr[136] = 1938;
        sArr[137] = 1986;
        sArr[138] = 1984;
        sArr[139] = 2013;
        sArr[140] = 2000;
        sArr[141] = 2014;
        sArr[142] = 2007;
        sArr[143] = 2015;
        sArr[144] = 1928;
        sArr[145] = 1938;
        sArr[146] = 555;
        sArr[147] = 526;
        sArr[148] = 513;
        sArr[149] = 520;
        sArr[150] = 515;
        sArr[151] = 518;
        sArr[152] = 513;
        sArr[153] = 520;
        sArr[154] = 591;
        sArr[155] = 513;
        sArr[156] = 526;
        sArr[157] = 514;
        sArr[158] = 522;
        sArr[159] = 597;
        sArr[160] = 591;
        sArr[161] = 2861;
        sArr[162] = 1676;
        sArr[163] = 2695;
        sArr[164] = 2734;
        sArr[165] = 2814;
        sArr[166] = 2795;
        sArr[167] = 2799;
        sArr[168] = 2723;
        sArr[169] = 574;
        sArr[170] = 528;
        sArr[171] = 566;
        sArr[172] = 524;
        sArr[173] = 565;
        sArr[174] = 519;
        sArr[175] = 1886;
        sArr[176] = 1910;
        sArr[177] = 1345;
        sArr[178] = 1407;
        sArr[179] = 2519;
        sArr[180] = 1220;
        sArr[181] = 665;
        sArr[182] = 702;
        sArr[183] = 691;
        sArr[184] = 703;
        sArr[185] = 701;
        sArr[186] = 672;
        sArr[187] = 700;
        sArr[188] = 693;
        sArr[189] = 676;
        sArr[190] = 693;
        sArr[191] = 752;
        sArr[192] = 692;
        sArr[193] = 703;
        sArr[194] = 691;
        sArr[195] = 677;
        sArr[196] = 701;
        sArr[197] = 693;
        sArr[198] = 702;
        sArr[199] = 676;
        sArr[200] = 1671;
        sArr[201] = 1763;
        sArr[202] = 1120;
        sArr[203] = 1135;
        sArr[204] = 1123;
        sArr[205] = 1131;
        sArr[206] = 1070;
        sArr[207] = 1075;
        sArr[208] = 1075;
        sArr[209] = 1070;
        sArr[210] = 1120;
        sArr[211] = 1147;
        sArr[212] = 1122;
        sArr[213] = 1122;
        sArr[214] = 3102;
        sArr[215] = 3077;
        sArr[216] = 3100;
        sArr[217] = 3100;
        sArr[218] = 396;
        sArr[219] = 2262;
        sArr[220] = 2252;
        sArr[221] = 2550;
        sArr[222] = 2509;
        sArr[223] = 2517;
        sArr[224] = 2525;
        sArr[225] = 2506;
        sArr[226] = 2513;
        sArr[227] = 2523;
        sArr[228] = 2456;
        sArr[229] = 2510;
        sArr[230] = 2521;
        sArr[231] = 2516;
        sArr[232] = 2509;
        sArr[233] = 2525;
        sArr[234] = 2507;
        sArr[235] = 2456;
        sArr[236] = 2517;
        sArr[237] = 2509;
        sArr[238] = 2507;
        sArr[239] = 2508;
        sArr[240] = 2456;
        sArr[241] = 2522;
        sArr[242] = 2525;
        sArr[243] = 2456;
        sArr[244] = 2526;
        sArr[245] = 2513;
        sArr[246] = 2518;
        sArr[247] = 2513;
        sArr[248] = 2508;
        sArr[249] = 2525;
        sArr[250] = 2452;
        sArr[251] = 2456;
        sArr[252] = 2522;
        sArr[253] = 2509;
        sArr[254] = 2508;
        sArr[255] = 2456;
        sArr[256] = 2511;
        sArr[257] = 2521;
        sArr[258] = 2507;
        sArr[259] = 2456;
        sArr[260] = 3147;
        sArr[261] = 3119;
        sArr[262] = 3080;
        sArr[263] = 3072;
        sArr[264] = 3087;
        sArr[265] = 3080;
        sArr[266] = 3087;
        sArr[267] = 3090;
        sArr[268] = 3103;
        sArr[269] = 1611;
        sArr[270] = 1644;
        sArr[271] = 1636;
        sArr[272] = 1643;
        sArr[273] = 1644;
        sArr[274] = 1643;
        sArr[275] = 1654;
        sArr[276] = 1659;
        sArr[277] = 1291;
        sArr[278] = 1316;
        sArr[279] = 1291;
        sArr[280] = 2075;
        sArr[281] = 2080;
        sArr[282] = 2104;
        sArr[283] = 2096;
        sArr[284] = 2087;
        sArr[285] = 2108;
        sArr[286] = 2102;
        sArr[287] = 2165;
        sArr[288] = 2083;
        sArr[289] = 2100;
        sArr[290] = 2105;
        sArr[291] = 2080;
        sArr[292] = 2096;
        sArr[293] = 2086;
        sArr[294] = 2165;
        sArr[295] = 2104;
        sArr[296] = 2080;
        sArr[297] = 2086;
        sArr[298] = 2081;
        sArr[299] = 2165;
        sArr[300] = 2103;
        sArr[301] = 2096;
        sArr[302] = 2165;
        sArr[303] = 2099;
        sArr[304] = 2108;
        sArr[305] = 2107;
        sArr[306] = 2108;
        sArr[307] = 2081;
        sArr[308] = 2096;
        sArr[309] = 2169;
        sArr[310] = 2165;
        sArr[311] = 2103;
        sArr[312] = 2080;
        sArr[313] = 2081;
        sArr[314] = 2165;
        sArr[315] = 2082;
        sArr[316] = 2100;
        sArr[317] = 2086;
        sArr[318] = 2165;
        sArr[319] = 2591;
        sArr[320] = 2585;
        sArr[321] = 2590;
        sArr[322] = 2574;
        sArr[323] = 1596;
        sArr[324] = 1595;
        sArr[325] = 1590;
        sArr[326] = 1577;
        sArr[327] = 1599;
        f102short = sArr;
    }

    public JsonWriter(Writer writer) {
        ArrayList arrayList = new ArrayList();
        this.stack = arrayList;
        arrayList.add(JsonScope.EMPTY_DOCUMENT);
        this.separator = C0520.m66(f102short, 1746755 ^ C0008.m27((Object) "۟ۡۥ"), 1750592 ^ C0008.m27((Object) "ۣۡ۟"), C0008.m27((Object) "ۢۢ") ^ 57139);
        this.serializeNulls = true;
        if (writer != null) {
            this.out = writer;
        } else {
            throw new NullPointerException(C0005.m17(f102short, 1749572 ^ C0008.m27((Object) "ۢ۟ۢ"), 1754529 ^ C0008.m27((Object) "ۧۤۧ"), C0008.m27((Object) "ۣۤۤ") ^ 1749561));
        }
    }

    private void beforeName() throws IOException {
        Integer num = new Integer(1759138);
        JsonScope peek = peek();
        if (peek == JsonScope.NONEMPTY_OBJECT) {
            this.out.write(((Integer) new Object[]{num}[0]).intValue() ^ 1759118);
        } else if (peek != JsonScope.EMPTY_OBJECT) {
            throw new IllegalStateException(C0521.m71(f102short, 1752587 ^ C0008.m27((Object) "ۥۣۥ"), 1753621 ^ C0008.m27((Object) "ۦۥۣ"), C0008.m27((Object) "ۦ۟ۢ") ^ 1754487) + this.stack);
        }
        newline();
        replaceTop(JsonScope.DANGLING_NAME);
    }

    private void beforeValue(boolean z) throws IOException {
        JsonScope jsonScope;
        switch (AnonymousClass1.$SwitchMap$com$gaagle$gson$stream$JsonScope[peek().ordinal()]) {
            case 1:
                if (this.lenient || z) {
                    jsonScope = JsonScope.NONEMPTY_DOCUMENT;
                    replaceTop(jsonScope);
                    return;
                } else {
                    throw new IllegalStateException(C0007.m23(f102short, 56414 ^ C0008.m27((Object) "۠ۨ"), 56465 ^ C0008.m27((Object) "ۦ۠"), C0008.m27((Object) "۟ۨۡ") ^ 1746048));
                }
            case 2:
                replaceTop(JsonScope.NONEMPTY_ARRAY);
                newline();
                return;
            case 3:
                this.out.append(',');
                newline();
                return;
            case 4:
                this.out.append((CharSequence) this.separator);
                jsonScope = JsonScope.NONEMPTY_OBJECT;
                replaceTop(jsonScope);
                return;
            case 5:
                throw new IllegalStateException(C0108.m52(f102short, 1746931 ^ C0008.m27((Object) "۟ۦۤ"), 1747721 ^ C0008.m27((Object) "ۣ۠ۢ"), C0008.m27((Object) "ۡۦۨ") ^ 1747763));
            default:
                throw new IllegalStateException(C0108.m52(f102short, 1752497 ^ C0008.m27((Object) "ۥ۠ۧ"), C0008.m27((Object) "ۢ") ^ 1779, C0008.m27((Object) "ۥۢ۟") ^ 1752162) + this.stack);
        }
    }

    private JsonWriter close(JsonScope jsonScope, JsonScope jsonScope2, String str) throws IOException {
        JsonScope peek = peek();
        if (peek != jsonScope2 && peek != jsonScope) {
            throw new IllegalStateException(C0001.m3(f102short, 1753580 ^ C0008.m27((Object) "ۦ۠ۧ"), 1755357 ^ C0008.m27((Object) "ۣۨ۟"), C0008.m27((Object) "ۡۤۥ") ^ 1747088) + this.stack);
        }
        if (this.deferredName == null) {
            this.stack.remove(r1.size() - 1);
            if (peek == jsonScope2) {
                newline();
            }
            this.out.write(str);
            return this;
        }
        throw new IllegalStateException(C0520.m66(f102short, 1752591 ^ C0008.m27((Object) "ۥۨ۠"), 56366 ^ C0008.m27((Object) "ۡۢ"), C0008.m27((Object) "ۥۤۢ") ^ 1752140) + this.deferredName);
    }

    private void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.out.write(C0001.m3(f102short, 1747558 ^ C0008.m27((Object) "۠۟ۦ"), 1750748 ^ C0008.m27((Object) "ۣۦ۠"), C0008.m27((Object) "ۢۤ") ^ 55141));
        for (int i2 = 1; i2 < this.stack.size(); i2++) {
            this.out.write(this.indent);
        }
    }

    private JsonWriter open(JsonScope jsonScope, String str) throws IOException {
        beforeValue(true);
        this.stack.add(jsonScope);
        this.out.write(str);
        return this;
    }

    private JsonScope peek() {
        Integer num = new Integer(-9458763);
        List<JsonScope> list = this.stack;
        return list.get((((Integer) new Object[]{num}[0]).intValue() ^ 9458762) + list.size());
    }

    private void replaceTop(JsonScope jsonScope) {
        Integer num = new Integer(-4807737);
        List<JsonScope> list = this.stack;
        list.set((((Integer) new Object[]{num}[0]).intValue() ^ 4807736) + list.size(), jsonScope);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x007d. Please report as an issue. */
    private void string(String str) throws IOException {
        Writer writer;
        String m40;
        Writer writer2;
        String format;
        Object[] objArr = {new Integer(4838405), new Integer(8096458)};
        Writer writer3 = this.out;
        String m44 = C0105.m44(f102short, 1752430 ^ C0008.m27((Object) "ۥۡۨ"), 1755398 ^ C0008.m27((Object) "ۨۡ۠"), C0008.m27((Object) "ۢۦۣ") ^ 1750449);
        writer3.write(m44);
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String m66 = C0520.m66(f102short, 1755435 ^ C0008.m27((Object) "ۨۥۥ"), 1748739 ^ C0008.m27((Object) "ۣۡۧ"), C0008.m27((Object) "ۨۥۡ") ^ 1753951);
            int intValue = 8096459 ^ ((Integer) objArr[1]).intValue();
            switch (charAt) {
                case '\b':
                    writer = this.out;
                    m40 = C0104.m40(f102short, 1747760 ^ C0008.m27((Object) "۠ۥۦ"), 56450 ^ C0008.m27((Object) "ۤۤ"), C0008.m27((Object) "ۨۦ۟") ^ 1756348);
                    writer.write(m40);
                    break;
                case '\t':
                    writer = this.out;
                    m40 = C0000.m1(f102short, 1754505 ^ C0008.m27((Object) "ۧ۠۟"), 1753698 ^ C0008.m27((Object) "ۦۨۢ"), C0008.m27((Object) "ۣۣ۠") ^ 1749378);
                    writer.write(m40);
                    break;
                case '\n':
                    writer = this.out;
                    m40 = C0003.m11(f102short, 1754379 ^ C0008.m27((Object) "ۣۧۤ"), 1747712 ^ C0008.m27((Object) "ۣ۠ۡ"), C0008.m27((Object) "۟ۦۥ") ^ 1746359);
                    writer.write(m40);
                    break;
                case '\f':
                    writer = this.out;
                    m40 = C0008.m24(f102short, 1746838 ^ C0008.m27((Object) "۟ۡ۟"), 1749794 ^ C0008.m27((Object) "ۢۦۤ"), C0008.m27((Object) "ۢۥۦ") ^ 1749353);
                    writer.write(m40);
                    break;
                case '\r':
                    writer = this.out;
                    m40 = C0104.m40(f102short, 1750667 ^ C0008.m27((Object) "ۣ۠۟"), 56418 ^ C0008.m27((Object) "ۣۣ"), C0008.m27((Object) "۠ۦۧ") ^ 1747395);
                    writer.write(m40);
                    break;
                case '\"':
                case '\\':
                    this.out.write(((Integer) objArr[0]).intValue() ^ 4838489);
                    this.out.write(charAt);
                    break;
                case '&':
                case '\'':
                case '<':
                case '=':
                case '>':
                    if (this.htmlSafe) {
                        writer2 = this.out;
                        Object[] objArr2 = new Object[intValue];
                        objArr2[0] = Integer.valueOf(charAt);
                        format = String.format(m66, objArr2);
                        writer2.write(format);
                        break;
                    }
                    this.out.write(charAt);
                    break;
                case 8232:
                case 8233:
                    writer2 = this.out;
                    Object[] objArr3 = new Object[intValue];
                    objArr3[0] = Integer.valueOf(charAt);
                    format = String.format(m66, objArr3);
                    writer2.write(format);
                    break;
                default:
                    if (charAt <= 31) {
                        writer2 = this.out;
                        Object[] objArr4 = new Object[intValue];
                        objArr4[0] = Integer.valueOf(charAt);
                        format = String.format(m66, objArr4);
                        writer2.write(format);
                        break;
                    }
                    this.out.write(charAt);
                    break;
            }
        }
        this.out.write(m44);
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(JsonScope.EMPTY_ARRAY, C0104.m40(f102short, 56397 ^ C0008.m27((Object) "ۨۦ"), 1752614 ^ C0008.m27((Object) "ۥۤۦ"), C0008.m27((Object) "۟ۡۧ") ^ 1748681));
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(JsonScope.EMPTY_OBJECT, C0006.m19(f102short, 1746708 ^ C0008.m27((Object) "۟ۤۥ"), 1753479 ^ C0008.m27((Object) "ۦۡۡ"), C0008.m27((Object) "ۣ۟ۡ") ^ 1745918));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        if (peek() == JsonScope.NONEMPTY_DOCUMENT) {
            return;
        }
        throw new IOException(C0005.m17(f102short, 1755578 ^ C0008.m27((Object) "ۨۡۨ"), 1749804 ^ C0008.m27((Object) "ۢۧۤ"), C0008.m27((Object) "ۨۤۤ") ^ 1756088));
    }

    public JsonWriter endArray() throws IOException {
        return close(JsonScope.EMPTY_ARRAY, JsonScope.NONEMPTY_ARRAY, C0107.m50(f102short, 1746836 ^ C0008.m27((Object) "۟ۢ۟"), 1752587 ^ C0008.m27((Object) "ۥۣۨ"), C0008.m27((Object) "ۥ۠ۥ") ^ 1751920));
    }

    public JsonWriter endObject() throws IOException {
        return close(JsonScope.EMPTY_OBJECT, JsonScope.NONEMPTY_OBJECT, C0107.m50(f102short, 1752779 ^ C0008.m27((Object) "ۥۣ۠"), 1748835 ^ C0008.m27((Object) "ۡۦۧ"), C0008.m27((Object) "ۥۦۡ") ^ 1751294));
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException(C0522.m72(f102short, 1754535 ^ C0008.m27((Object) "ۧۢۨ"), 1751662 ^ C0008.m27((Object) "ۤۤۢ"), C0008.m27((Object) "ۧۤۢ") ^ 1753515));
        }
        if (this.deferredName != null) {
            throw new IllegalStateException();
        }
        this.deferredName = str;
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            writeDeferredName();
        }
        beforeValue(false);
        this.out.write(C0522.m72(f102short, 1747727 ^ C0008.m27((Object) "۠ۨۡ"), 1754434 ^ C0008.m27((Object) "ۧۡ۠"), C0008.m27((Object) "ۥۧۨ") ^ 1749750));
        return this;
    }

    public final void setHtmlSafe(boolean z) {
        this.htmlSafe = z;
    }

    public final void setIndent(String str) {
        String m23;
        if (str.length() == 0) {
            this.indent = null;
            m23 = C0004.m13(f102short, 1755442 ^ C0008.m27((Object) "ۨۨۨ"), 1750534 ^ C0008.m27((Object) "ۣۣ۟"), C0008.m27((Object) "ۡۦۤ") ^ 1748713);
        } else {
            this.indent = str;
            m23 = C0007.m23(f102short, 1747512 ^ C0008.m27((Object) "ۣ۠۠"), 1753478 ^ C0008.m27((Object) "ۦۡ۟"), C0008.m27((Object) "ۧۧ۟") ^ 1756435);
        }
        this.separator = m23;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
    }

    public JsonWriter value(double d2) throws IOException {
        if (!Double.isNaN(d2) && !Double.isInfinite(d2)) {
            writeDeferredName();
            beforeValue(false);
            this.out.append((CharSequence) Double.toString(d2));
            return this;
        }
        throw new IllegalArgumentException(C0004.m13(f102short, 1752372 ^ C0008.m27((Object) "ۥۢۦ"), 1750744 ^ C0008.m27((Object) "ۣۣۧ"), C0008.m27((Object) "ۥۤۦ") ^ 1750943) + d2);
    }

    public JsonWriter value(long j2) throws IOException {
        writeDeferredName();
        beforeValue(false);
        this.out.write(Long.toString(j2));
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x008e, code lost:
    
        if (r0.equals(com.google.gason.C0108.m52(com.google.gason.stream.JsonWriter.f102short, 1755314 ^ android.support.v4.view.C0008.m27((java.lang.Object) "ۨۦۥ"), 56419 ^ android.support.v4.view.C0008.m27((java.lang.Object) "ۣۣ"), android.support.v4.view.C0008.m27((java.lang.Object) "ۣۨۦ") ^ 1756174)) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.gason.stream.JsonWriter value(java.lang.Number r7) throws java.io.IOException {
        /*
            r6 = this;
            if (r7 != 0) goto L7
            com.google.gason.stream.JsonWriter r6 = r6.nullValue()
        L6:
            return r6
        L7:
            r6.writeDeferredName()
            java.lang.String r0 = r7.toString()
            boolean r1 = r6.lenient
            if (r1 != 0) goto L90
            short[] r1 = com.google.gason.stream.JsonWriter.f102short
            java.lang.String r2 = "ۥۨ۟"
            int r2 = android.support.v4.view.C0008.m27(r2)
            r3 = 1747545(0x1aaa59, float:2.448832E-39)
            java.lang.String r4 = "۠ۤۡ"
            int r4 = android.support.v4.view.C0008.m27(r4)
            r3 = r3 ^ r4
            r4 = 1747725(0x1aab0d, float:2.449084E-39)
            java.lang.String r5 = "۠ۡۥ"
            int r5 = android.support.v4.view.C0008.m27(r5)
            r4 = r4 ^ r5
            r5 = 1749754(0x1ab2fa, float:2.451928E-39)
            r2 = r2 ^ r5
            java.lang.String r1 = com.google.gason.stream.C0106.m46(r1, r3, r4, r2)
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L9b
            short[] r1 = com.google.gason.stream.JsonWriter.f102short
            java.lang.String r2 = "ۣۡۡ"
            int r2 = android.support.v4.view.C0008.m27(r2)
            r3 = 1753933(0x1ac34d, float:2.457784E-39)
            java.lang.String r4 = "ۦۧۡ"
            int r4 = android.support.v4.view.C0008.m27(r4)
            r3 = r3 ^ r4
            r4 = 1749706(0x1ab2ca, float:2.45186E-39)
            java.lang.String r5 = "ۣۣۢ"
            int r5 = android.support.v4.view.C0008.m27(r5)
            r4 = r4 ^ r5
            r5 = 1747137(0x1aa8c1, float:2.44826E-39)
            r2 = r2 ^ r5
            java.lang.String r1 = com.google.gason.C0108.m52(r1, r3, r4, r2)
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L9b
            short[] r1 = com.google.gason.stream.JsonWriter.f102short
            java.lang.String r2 = "ۣۨۦ"
            int r2 = android.support.v4.view.C0008.m27(r2)
            r3 = 1755314(0x1ac8b2, float:2.459719E-39)
            java.lang.String r4 = "ۨۦۥ"
            int r4 = android.support.v4.view.C0008.m27(r4)
            r3 = r3 ^ r4
            r4 = 56419(0xdc63, float:7.906E-41)
            java.lang.String r5 = "ۣۣ"
            int r5 = android.support.v4.view.C0008.m27(r5)
            r4 = r4 ^ r5
            r5 = 1756174(0x1acc0e, float:2.460924E-39)
            r2 = r2 ^ r5
            java.lang.String r1 = com.google.gason.C0108.m52(r1, r3, r4, r2)
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L9b
        L90:
            r1 = 0
            r6.beforeValue(r1)
            java.io.Writer r1 = r6.out
            r1.append(r0)
            goto L6
        L9b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            short[] r1 = com.google.gason.stream.JsonWriter.f102short
            java.lang.String r2 = "ۧۨۡ"
            int r2 = android.support.v4.view.C0008.m27(r2)
            r3 = 1750972(0x1ab7bc, float:2.453634E-39)
            java.lang.String r4 = "ۣۤۥ"
            int r4 = android.support.v4.view.C0008.m27(r4)
            r3 = r3 ^ r4
            r4 = 1750561(0x1ab621, float:2.453058E-39)
            java.lang.String r5 = "ۣ۟ۢ"
            int r5 = android.support.v4.view.C0008.m27(r5)
            r4 = r4 ^ r5
            r5 = 1756789(0x1ace75, float:2.461786E-39)
            r2 = r2 ^ r5
            java.lang.String r1 = com.tencent.as.C0523.m77(r1, r3, r4, r2)
            r0.append(r1)
            r0.append(r7)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gason.stream.JsonWriter.value(java.lang.Number):com.google.gason.stream.JsonWriter");
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue(false);
        string(str);
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        String m1;
        writeDeferredName();
        beforeValue(false);
        Writer writer = this.out;
        if (z) {
            m1 = C0001.m3(f102short, 1754268 ^ C0008.m27((Object) "ۧۤ۠"), 1747714 ^ C0008.m27((Object) "۠ۡۧ"), C0008.m27((Object) "ۡۨۡ") ^ 1746417);
        } else {
            m1 = C0000.m1(f102short, 1752900 ^ C0008.m27((Object) "ۥۣۥ"), 1755502 ^ C0008.m27((Object) "ۨۤۧ"), C0008.m27((Object) "ۣۤۥ") ^ 1749246);
        }
        writer.write(m1);
        return this;
    }
}
