package com.google.gason;

import android.support.v4.view.C0008;
import com.tencent.a.C0521;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes7.dex */
abstract class CompositionFieldNamingPolicy extends RecursiveFieldNamingPolicy {

    /* renamed from: short */
    private static final short[] f54short;
    private final RecursiveFieldNamingPolicy[] fieldPolicies;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(6510508)}[0]).intValue() ^ 6510476];
        sArr[0] = 1833;
        sArr[1] = 1830;
        sArr[2] = 1834;
        sArr[3] = 1838;
        sArr[4] = 1833;
        sArr[5] = 1824;
        sArr[6] = 1895;
        sArr[7] = 1847;
        sArr[8] = 1832;
        sArr[9] = 1835;
        sArr[10] = 1838;
        sArr[11] = 1828;
        sArr[12] = 1838;
        sArr[13] = 1826;
        sArr[14] = 1844;
        sArr[15] = 1895;
        sArr[16] = 1828;
        sArr[17] = 1830;
        sArr[18] = 1833;
        sArr[19] = 1895;
        sArr[20] = 1833;
        sArr[21] = 1832;
        sArr[22] = 1843;
        sArr[23] = 1895;
        sArr[24] = 1829;
        sArr[25] = 1826;
        sArr[26] = 1895;
        sArr[27] = 1833;
        sArr[28] = 1842;
        sArr[29] = 1835;
        sArr[30] = 1835;
        sArr[31] = 1897;
        f54short = sArr;
    }

    public CompositionFieldNamingPolicy(RecursiveFieldNamingPolicy... recursiveFieldNamingPolicyArr) {
        if (recursiveFieldNamingPolicyArr != null) {
            this.fieldPolicies = recursiveFieldNamingPolicyArr;
        } else {
            throw new NullPointerException(C0521.m71(f54short, 1750750 ^ C0008.m27((Object) "ۣۦۡ"), C0008.m27((Object) "ۢ") ^ 1730, C0008.m27((Object) "ۥۢ۟") ^ 1751717));
        }
    }

    @Override // com.google.gason.RecursiveFieldNamingPolicy
    protected String translateName(String str, Type type, Collection<Annotation> collection) {
        Integer num = new Integer(9750025);
        RecursiveFieldNamingPolicy[] recursiveFieldNamingPolicyArr = this.fieldPolicies;
        int length = recursiveFieldNamingPolicyArr.length;
        for (int i2 = 0; i2 < length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 9750024) + i2) {
            str = recursiveFieldNamingPolicyArr[i2].translateName(str, type, collection);
        }
        return str;
    }
}
