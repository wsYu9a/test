package ba;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class i {
    public static ArrayList<Field> a(Class<?> cls) {
        ArrayList<Field> arrayList = new ArrayList<>();
        while (cls != null && cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }
}
