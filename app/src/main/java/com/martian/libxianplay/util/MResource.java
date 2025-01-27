package com.martian.libxianplay.util;

import android.content.Context;

/* loaded from: classes3.dex */
public class MResource {
    public static int getIdByName(Context context, String className, String resName) {
        try {
            Class<?>[] classes = Class.forName(context.getPackageName() + ".R").getClasses();
            Class<?> cls = null;
            int length = classes.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Class<?> cls2 = classes[i2];
                if (cls2.getName().split("\\$")[1].equals(className)) {
                    cls = cls2;
                    break;
                }
                i2++;
            }
            if (cls != null) {
                return cls.getField(resName).getInt(cls);
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
