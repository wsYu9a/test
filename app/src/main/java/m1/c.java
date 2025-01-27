package m1;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import java.lang.reflect.Field;

@Deprecated
/* loaded from: classes.dex */
public class c extends Instrumentation {
    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String[] stringArrayExtra;
        Class<?> loadClass = classLoader.loadClass(str);
        Object newInstance = loadClass.newInstance();
        if (n1.a.f() && (stringArrayExtra = intent.getStringArrayExtra(n1.a.f28720b)) != null && stringArrayExtra.length > 0) {
            for (String str2 : stringArrayExtra) {
                Object obj = intent.getExtras().get(p1.f.b(str2));
                if (obj != null) {
                    try {
                        Field declaredField = loadClass.getDeclaredField(p1.f.b(str2));
                        declaredField.setAccessible(true);
                        declaredField.set(newInstance, obj);
                    } catch (Exception e10) {
                        n1.a.f28723e.error("ARouter::", "Inject values for activity error! [" + e10.getMessage() + "]");
                    }
                }
            }
        }
        return (Activity) newInstance;
    }
}
