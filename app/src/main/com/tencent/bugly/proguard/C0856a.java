package com.tencent.bugly.proguard;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.tencent.bugly.proguard.a */
/* loaded from: classes4.dex */
public class C0856a {
    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList.set(i10, a(arrayList.get(i10)));
        }
        Collections.reverse(arrayList);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            String str = arrayList.get(i11);
            if (str.equals(c7.g.f1745c)) {
                int i12 = i11 - 1;
                arrayList.set(i12, "<" + arrayList.get(i12));
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str.equals("map")) {
                int i13 = i11 - 1;
                arrayList.set(i13, "<" + arrayList.get(i13) + ",");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(arrayList.get(0));
                sb2.append(">");
                arrayList.set(0, sb2.toString());
            } else if (str.equals("Array")) {
                int i14 = i11 - 1;
                arrayList.set(i14, "<" + arrayList.get(i14));
                arrayList.set(0, arrayList.get(0) + ">");
            }
        }
        Collections.reverse(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (str.equals("java.lang.Integer") || str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return "int32";
        }
        if (str.equals("java.lang.Boolean") || str.equals(TypedValues.Custom.S_BOOLEAN)) {
            return "bool";
        }
        if (str.equals("java.lang.Byte") || str.equals("byte")) {
            return "char";
        }
        String str2 = "double";
        if (!str.equals("java.lang.Double") && !str.equals("double")) {
            boolean equals = str.equals("java.lang.Float");
            str2 = TypedValues.Custom.S_FLOAT;
            if (!equals && !str.equals(TypedValues.Custom.S_FLOAT)) {
                if (str.equals("java.lang.Long") || str.equals("long")) {
                    return "int64";
                }
                if (str.equals("java.lang.Short") || str.equals("short")) {
                    return "short";
                }
                if (str.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                }
                return str.equals("java.lang.String") ? TypedValues.Custom.S_STRING : str.equals("java.util.List") ? c7.g.f1745c : str.equals("java.util.Map") ? "map" : str;
            }
        }
        return str2;
    }
}
