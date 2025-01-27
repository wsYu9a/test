package com.jd.ad.sdk.jad_jm;

import com.baidu.mobads.sdk.internal.cl;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class jad_bo {
    public static final /* synthetic */ int jad_an = 0;

    public class jad_an extends ThreadLocal<DecimalFormat> {
        @Override // java.lang.ThreadLocal
        public DecimalFormat initialValue() {
            try {
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
                decimalFormat.applyPattern(cl.f7052d);
                return decimalFormat;
            } catch (Exception unused) {
                return new DecimalFormat(cl.f7052d);
            }
        }
    }

    static {
        new jad_an();
    }
}
