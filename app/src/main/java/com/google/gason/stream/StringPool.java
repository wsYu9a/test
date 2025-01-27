package com.google.gason.stream;

/* loaded from: classes7.dex */
final class StringPool {
    private final String[] pool = new String[((Integer) new Object[]{new Integer(9084809)}[0]).intValue() ^ 9084297];

    StringPool() {
    }

    public String get(char[] cArr, int i2, int i3) {
        Object[] objArr = {new Integer(2750660), new Integer(4905908), new Integer(6304685), new Integer(1971331)};
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5 = (((Integer) objArr[0]).intValue() ^ 2750661) + i5) {
            i4 = cArr[i5] + ((((Integer) objArr[1]).intValue() ^ 4905899) * i4);
        }
        int intValue = ((i4 >>> (((Integer) objArr[3]).intValue() ^ 1971343)) ^ (i4 >>> (((Integer) objArr[2]).intValue() ^ 6304697))) ^ i4;
        int length = (r2.length - 1) & (intValue ^ ((intValue >>> 7) ^ (intValue >>> 4)));
        String str = this.pool[length];
        if (str == null || str.length() != i3) {
            String str2 = new String(cArr, i2, i3);
            this.pool[length] = str2;
            return str2;
        }
        for (int i6 = 0; i6 < i3; i6++) {
            if (str.charAt(i6) != cArr[i2 + i6]) {
                String str3 = new String(cArr, i2, i3);
                this.pool[length] = str3;
                return str3;
            }
        }
        return str;
    }
}
