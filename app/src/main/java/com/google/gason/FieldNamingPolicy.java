package com.google.gason;

import android.support.v4.graphics.C0001;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import com.google.gason.ModifyFirstLetterNamingPolicy;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.as.C0523;

/* loaded from: classes7.dex */
public final class FieldNamingPolicy extends Enum<FieldNamingPolicy> {
    private static final FieldNamingPolicy[] $VALUES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;

    /* renamed from: short */
    private static final short[] f57short;
    private final FieldNamingStrategy2 namingPolicy;

    static {
        Object[] objArr = {new Integer(3875772), new Integer(9607435), new Integer(9500658), new Integer(2354840), new Integer(3200512)};
        short[] sArr = new short[((Integer) objArr[0]).intValue() ^ 3875804];
        sArr[0] = 731;
        sArr[1] = 734;
        sArr[2] = 734;
        sArr[3] = 715;
        sArr[4] = 732;
        sArr[5] = 721;
        sArr[6] = 717;
        sArr[7] = 719;
        sArr[8] = 707;
        sArr[9] = 715;
        sArr[10] = 706;
        sArr[11] = 721;
        sArr[12] = 717;
        sArr[13] = 719;
        sArr[14] = 733;
        sArr[15] = 715;
        sArr[16] = 902;
        sArr[17] = 2562;
        sArr[18] = 2567;
        sArr[19] = 2567;
        sArr[20] = 2578;
        sArr[21] = 2565;
        sArr[22] = 2568;
        sArr[23] = 2580;
        sArr[24] = 2582;
        sArr[25] = 2586;
        sArr[26] = 2578;
        sArr[27] = 2587;
        sArr[28] = 2568;
        sArr[29] = 2580;
        sArr[30] = 2582;
        sArr[31] = 2564;
        sArr[32] = 2578;
        sArr[33] = 2568;
        sArr[34] = 2560;
        sArr[35] = 2590;
        sArr[36] = 2563;
        sArr[37] = 2591;
        sArr[38] = 2568;
        sArr[39] = 2564;
        sArr[40] = 2567;
        sArr[41] = 2582;
        sArr[42] = 2580;
        sArr[43] = 2578;
        sArr[44] = 2564;
        sArr[45] = 2821;
        sArr[46] = 1646;
        sArr[47] = 1645;
        sArr[48] = 1653;
        sArr[49] = 1639;
        sArr[50] = 1648;
        sArr[51] = 1661;
        sArr[52] = 1633;
        sArr[53] = 1635;
        sArr[54] = 1649;
        sArr[55] = 1639;
        sArr[56] = 1661;
        sArr[57] = 1653;
        sArr[58] = 1643;
        sArr[59] = 1654;
        sArr[60] = 1642;
        sArr[61] = 1661;
        sArr[62] = 1655;
        sArr[63] = 1644;
        sArr[64] = 1638;
        sArr[65] = 1639;
        sArr[66] = 1648;
        sArr[67] = 1649;
        sArr[68] = 1633;
        sArr[69] = 1645;
        sArr[70] = 1648;
        sArr[71] = 1639;
        sArr[72] = 1649;
        sArr[73] = 3087;
        sArr[74] = 897;
        sArr[75] = 898;
        sArr[76] = 922;
        sArr[77] = 904;
        sArr[78] = 927;
        sArr[79] = 914;
        sArr[80] = 910;
        sArr[81] = 908;
        sArr[82] = 926;
        sArr[83] = 904;
        sArr[84] = 914;
        sArr[85] = 922;
        sArr[86] = 900;
        sArr[87] = 921;
        sArr[88] = 901;
        sArr[89] = 914;
        sArr[90] = 905;
        sArr[91] = 908;
        sArr[92] = 926;
        sArr[93] = 901;
        sArr[94] = 904;
        sArr[95] = 926;
        f57short = sArr;
        FieldNamingPolicy fieldNamingPolicy = new FieldNamingPolicy(C0001.m3(f57short, 1755460 ^ C0008.m27((Object) "ۣۨ۟"), 1746733 ^ C0008.m27((Object) "۟ۡ۟"), C0008.m27((Object) "ۣۡۥ") ^ 1748365), 0, new ModifyFirstLetterNamingPolicy(ModifyFirstLetterNamingPolicy.LetterModifier.UPPER));
        UPPER_CAMEL_CASE = fieldNamingPolicy;
        CompositionFieldNamingPolicy upperCamelCaseSeparatorNamingPolicy = new CompositionFieldNamingPolicy(C0522.m72(f57short, 56496 ^ C0008.m27((Object) "ۥۥ"), 1755531 ^ C0008.m27((Object) "ۨۥۧ"), C0008.m27((Object) "ۧۡ۠") ^ 1754848)) { // from class: com.google.gason.UpperCamelCaseSeparatorNamingPolicy
            public UpperCamelCaseSeparatorNamingPolicy(String str) {
                /*
                    this = this;
                    r4 = 1
                    r3 = 0
                    r0 = 2
                    java.lang.Object[] r1 = new java.lang.Object[r0]
                    java.lang.Integer r0 = new java.lang.Integer
                    r2 = 1814672(0x1bb090, float:2.542897E-39)
                    r0.<init>(r2)
                    r1[r3] = r0
                    java.lang.Integer r0 = new java.lang.Integer
                    r2 = 813686(0xc6a76, float:1.140217E-39)
                    r0.<init>(r2)
                    r1[r4] = r0
                    r0 = r1[r3]
                    java.lang.Integer r0 = (java.lang.Integer) r0
                    int r0 = r0.intValue()
                    r2 = 1814674(0x1bb092, float:2.5429E-39)
                    r0 = r0 ^ r2
                    com.google.gason.RecursiveFieldNamingPolicy[] r2 = new com.google.gason.RecursiveFieldNamingPolicy[r0]
                    com.google.gason.CamelCaseSeparatorNamingPolicy r0 = new com.google.gason.CamelCaseSeparatorNamingPolicy
                    r0.<init>(r6)
                    r2[r3] = r0
                    com.google.gason.ModifyFirstLetterNamingPolicy r3 = new com.google.gason.ModifyFirstLetterNamingPolicy
                    com.google.gason.ModifyFirstLetterNamingPolicy$LetterModifier r0 = com.google.gason.ModifyFirstLetterNamingPolicy.LetterModifier.UPPER
                    r3.<init>(r0)
                    r0 = r1[r4]
                    java.lang.Integer r0 = (java.lang.Integer) r0
                    int r0 = r0.intValue()
                    r1 = 813687(0xc6a77, float:1.140218E-39)
                    r0 = r0 ^ r1
                    r2[r0] = r3
                    r5.<init>(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.gason.UpperCamelCaseSeparatorNamingPolicy.<init>(java.lang.String):void");
            }
        };
        String m3 = C0001.m3(f57short, 1748725 ^ C0008.m27((Object) "ۡۢۥ"), 1755636 ^ C0008.m27((Object) "ۨۨۨ"), C0008.m27((Object) "ۧ۟ۥ") ^ 1757018);
        int intValue = 9607434 ^ ((Integer) objArr[1]).intValue();
        FieldNamingPolicy fieldNamingPolicy2 = new FieldNamingPolicy(m3, intValue, upperCamelCaseSeparatorNamingPolicy);
        UPPER_CAMEL_CASE_WITH_SPACES = fieldNamingPolicy2;
        CompositionFieldNamingPolicy lowerCamelCaseSeparatorNamingPolicy = new CompositionFieldNamingPolicy(C0008.m24(f57short, 1755593 ^ C0008.m27((Object) "ۨۨۤ"), 1747836 ^ C0008.m27((Object) "۠ۥۢ"), C0008.m27((Object) "ۨ۠۟") ^ 1754045)) { // from class: com.google.gason.LowerCamelCaseSeparatorNamingPolicy
            public LowerCamelCaseSeparatorNamingPolicy(String str) {
                /*
                    this = this;
                    r4 = 1
                    r3 = 0
                    r0 = 2
                    java.lang.Object[] r1 = new java.lang.Object[r0]
                    java.lang.Integer r0 = new java.lang.Integer
                    r2 = 4331047(0x421627, float:6.06909E-39)
                    r0.<init>(r2)
                    r1[r3] = r0
                    java.lang.Integer r0 = new java.lang.Integer
                    r2 = 6497735(0x6325c7, float:9.105266E-39)
                    r0.<init>(r2)
                    r1[r4] = r0
                    r0 = r1[r3]
                    java.lang.Integer r0 = (java.lang.Integer) r0
                    int r0 = r0.intValue()
                    r2 = 4331045(0x421625, float:6.069087E-39)
                    r0 = r0 ^ r2
                    com.google.gason.RecursiveFieldNamingPolicy[] r2 = new com.google.gason.RecursiveFieldNamingPolicy[r0]
                    com.google.gason.CamelCaseSeparatorNamingPolicy r0 = new com.google.gason.CamelCaseSeparatorNamingPolicy
                    r0.<init>(r6)
                    r2[r3] = r0
                    com.google.gason.LowerCaseNamingPolicy r3 = new com.google.gason.LowerCaseNamingPolicy
                    r3.<init>()
                    r0 = r1[r4]
                    java.lang.Integer r0 = (java.lang.Integer) r0
                    int r0 = r0.intValue()
                    r1 = 6497734(0x6325c6, float:9.105265E-39)
                    r0 = r0 ^ r1
                    r2[r0] = r3
                    r5.<init>(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.gason.LowerCamelCaseSeparatorNamingPolicy.<init>(java.lang.String):void");
            }
        };
        String m71 = C0521.m71(f57short, 1751793 ^ C0008.m27((Object) "ۣۤۨ"), 1750610 ^ C0008.m27((Object) "ۣۡۧ"), C0008.m27((Object) "ۧۤۥ") ^ 1753994);
        int intValue2 = 2354842 ^ ((Integer) objArr[3]).intValue();
        FieldNamingPolicy fieldNamingPolicy3 = new FieldNamingPolicy(m71, intValue2, lowerCamelCaseSeparatorNamingPolicy);
        LOWER_CASE_WITH_UNDERSCORES = fieldNamingPolicy3;
        CompositionFieldNamingPolicy lowerCamelCaseSeparatorNamingPolicy2 = new CompositionFieldNamingPolicy(C0000.m1(f57short, 1752483 ^ C0008.m27((Object) "ۥۢۧ"), 56415 ^ C0008.m27((Object) "ۣۡ"), C0008.m27((Object) "ۢۨۡ") ^ 1752953)) { // from class: com.google.gason.LowerCamelCaseSeparatorNamingPolicy
            public LowerCamelCaseSeparatorNamingPolicy(String str) {
                /*
                    this = this;
                    r4 = 1
                    r3 = 0
                    r0 = 2
                    java.lang.Object[] r1 = new java.lang.Object[r0]
                    java.lang.Integer r0 = new java.lang.Integer
                    r2 = 4331047(0x421627, float:6.06909E-39)
                    r0.<init>(r2)
                    r1[r3] = r0
                    java.lang.Integer r0 = new java.lang.Integer
                    r2 = 6497735(0x6325c7, float:9.105266E-39)
                    r0.<init>(r2)
                    r1[r4] = r0
                    r0 = r1[r3]
                    java.lang.Integer r0 = (java.lang.Integer) r0
                    int r0 = r0.intValue()
                    r2 = 4331045(0x421625, float:6.069087E-39)
                    r0 = r0 ^ r2
                    com.google.gason.RecursiveFieldNamingPolicy[] r2 = new com.google.gason.RecursiveFieldNamingPolicy[r0]
                    com.google.gason.CamelCaseSeparatorNamingPolicy r0 = new com.google.gason.CamelCaseSeparatorNamingPolicy
                    r0.<init>(r6)
                    r2[r3] = r0
                    com.google.gason.LowerCaseNamingPolicy r3 = new com.google.gason.LowerCaseNamingPolicy
                    r3.<init>()
                    r0 = r1[r4]
                    java.lang.Integer r0 = (java.lang.Integer) r0
                    int r0 = r0.intValue()
                    r1 = 6497734(0x6325c6, float:9.105265E-39)
                    r0 = r0 ^ r1
                    r2[r0] = r3
                    r5.<init>(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.gason.LowerCamelCaseSeparatorNamingPolicy.<init>(java.lang.String):void");
            }
        };
        String m77 = C0523.m77(f57short, 1746761 ^ C0008.m27((Object) "ۣ۟۟"), 1755486 ^ C0008.m27((Object) "ۣۣۨ"), C0008.m27((Object) "ۤۥۧ") ^ 1751371);
        int intValue3 = 3200515 ^ ((Integer) objArr[4]).intValue();
        FieldNamingPolicy fieldNamingPolicy4 = new FieldNamingPolicy(m77, intValue3, lowerCamelCaseSeparatorNamingPolicy2);
        LOWER_CASE_WITH_DASHES = fieldNamingPolicy4;
        FieldNamingPolicy[] fieldNamingPolicyArr = new FieldNamingPolicy[((Integer) objArr[2]).intValue() ^ 9500662];
        fieldNamingPolicyArr[0] = fieldNamingPolicy;
        fieldNamingPolicyArr[intValue] = fieldNamingPolicy2;
        fieldNamingPolicyArr[intValue2] = fieldNamingPolicy3;
        fieldNamingPolicyArr[intValue3] = fieldNamingPolicy4;
        $VALUES = fieldNamingPolicyArr;
    }

    private FieldNamingPolicy(String str, int i2, FieldNamingStrategy2 fieldNamingStrategy2) {
        super(str, i2);
        this.namingPolicy = fieldNamingStrategy2;
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static final FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    FieldNamingStrategy2 getFieldNamingPolicy() {
        return this.namingPolicy;
    }
}
