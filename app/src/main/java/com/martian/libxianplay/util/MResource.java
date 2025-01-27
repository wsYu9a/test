package com.martian.libxianplay.util;

import android.content.Context;

/* loaded from: classes3.dex */
public class MResource {
    public static int getIdByName(Context context, String str, String str2) {
        Class<?> cls;
        try {
            Class<?>[] classes = Class.forName(context.getPackageName() + ".R").getClasses();
            int length = classes.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    cls = null;
                    break;
                }
                cls = classes[i10];
                if (cls.getName().split("\\$")[1].equals(str)) {
                    break;
                }
                i10++;
            }
            if (cls != null) {
                return cls.getField(str2).getInt(cls);
            }
            return 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
