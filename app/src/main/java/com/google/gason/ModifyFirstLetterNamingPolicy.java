package com.google.gason;

import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0007;
import com.google.gason.internal.C$Gson$Preconditions;
import com.google.gason.internal.C0104;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes7.dex */
final class ModifyFirstLetterNamingPolicy extends RecursiveFieldNamingPolicy {
    private final LetterModifier letterModifier;

    public static final class LetterModifier extends Enum<LetterModifier> {
        private static final LetterModifier[] $VALUES;
        public static final LetterModifier LOWER;
        public static final LetterModifier UPPER;

        /* renamed from: short */
        private static final short[] f65short;

        static {
            Object[] objArr = {new Integer(8024846), new Integer(4875026), new Integer(2864722)};
            short[] sArr = new short[((Integer) objArr[2]).intValue() ^ 2864728];
            sArr[0] = 2523;
            sArr[1] = 2526;
            sArr[2] = 2526;
            sArr[3] = 2507;
            sArr[4] = 2524;
            sArr[5] = 1251;
            sArr[6] = 1248;
            sArr[7] = 1272;
            sArr[8] = 1258;
            sArr[9] = 1277;
            f65short = sArr;
            LetterModifier letterModifier = new LetterModifier(C0007.m23(f65short, 1752705 ^ C0008.m27((Object) "ۥۣۧ"), 56320 ^ C0008.m27((Object) "۠ۥ"), C0008.m27((Object) "ۤۦۧ") ^ 1749803), 0);
            UPPER = letterModifier;
            String m40 = C0104.m40(f65short, 1752556 ^ C0008.m27((Object) "ۥۢۦ"), 1747712 ^ C0008.m27((Object) "۠ۡۦ"), C0008.m27((Object) "۟ۨۨ") ^ 1748144);
            int intValue = 4875027 ^ ((Integer) objArr[1]).intValue();
            LetterModifier letterModifier2 = new LetterModifier(m40, intValue);
            LOWER = letterModifier2;
            LetterModifier[] letterModifierArr = new LetterModifier[((Integer) objArr[0]).intValue() ^ 8024844];
            letterModifierArr[0] = letterModifier;
            letterModifierArr[intValue] = letterModifier2;
            $VALUES = letterModifierArr;
        }

        private LetterModifier(String str, int i2) {
            super(str, i2);
        }

        public static LetterModifier valueOf(String str) {
            return (LetterModifier) Enum.valueOf(LetterModifier.class, str);
        }

        public static final LetterModifier[] values() {
            return (LetterModifier[]) $VALUES.clone();
        }
    }

    ModifyFirstLetterNamingPolicy(LetterModifier letterModifier) {
        this.letterModifier = (LetterModifier) C$Gson$Preconditions.checkNotNull(letterModifier);
    }

    private String modifyString(char c2, String str, int i2) {
        if (i2 >= str.length()) {
            return String.valueOf(c2);
        }
        return c2 + str.substring(i2);
    }

    @Override // com.google.gason.RecursiveFieldNamingPolicy
    protected String translateName(String str, Type type, Collection<Annotation> collection) {
        int intValue;
        char lowerCase;
        Object[] objArr = {new Integer(6573735), new Integer(9664332)};
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        int i2 = 0;
        while (true) {
            int length = str.length();
            intValue = 6573734 ^ ((Integer) objArr[0]).intValue();
            if (i2 >= length - intValue || Character.isLetter(charAt)) {
                break;
            }
            sb.append(charAt);
            int intValue2 = i2 + (((Integer) objArr[1]).intValue() ^ 9664333);
            i2 = intValue2;
            charAt = str.charAt(intValue2);
        }
        if (i2 != str.length()) {
            int i3 = this.letterModifier == LetterModifier.UPPER ? intValue : 0;
            if (i3 != 0 && !Character.isUpperCase(charAt)) {
                lowerCase = Character.toUpperCase(charAt);
            } else {
                if (i3 != 0 || !Character.isUpperCase(charAt)) {
                    return str;
                }
                lowerCase = Character.toLowerCase(charAt);
            }
            sb.append(modifyString(lowerCase, str, i2 + intValue));
        }
        return sb.toString();
    }
}
