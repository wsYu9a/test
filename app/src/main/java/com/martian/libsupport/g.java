package com.martian.libsupport;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class g {
    public static ArrayList<Field> a(Class<?> tagClass) {
        ArrayList<Field> arrayList = new ArrayList<>();
        while (tagClass != null && tagClass != Object.class) {
            for (Field field : tagClass.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    arrayList.add(field);
                }
            }
            tagClass = tagClass.getSuperclass();
        }
        return arrayList;
    }
}
