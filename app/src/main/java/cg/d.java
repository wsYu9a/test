package cg;

import com.snassdk.sdk.wrapper.Reflect;
import java.util.List;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static String f2023a = "android.content.pm.ParceledListSlice";

    public static List a(Object obj) {
        return (List) Reflect.x(obj).call("getList").q();
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return ((Class) Reflect.y(f2023a).q()).isInstance(obj);
    }

    public static Object c(List<?> list) {
        return Reflect.y(f2023a).j(list).q();
    }
}
