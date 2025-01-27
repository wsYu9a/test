package com.bytedance.pangle.e;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements f.a {

    /* renamed from: a */
    private static volatile IBinder f6058a;

    /* renamed from: b */
    private static volatile Object f6059b;

    public interface a {
    }

    static class b extends ResultReceiver {

        /* renamed from: a */
        private a f6060a;

        public b() {
            super(null);
            this.f6060a = null;
        }

        @Override // android.os.ResultReceiver
        protected final void onReceiveResult(int i2, Bundle bundle) {
            super.onReceiveResult(i2, bundle);
        }
    }

    private static void a(String[] strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeFileDescriptor(FileDescriptor.in);
        obtain.writeFileDescriptor(FileDescriptor.out);
        obtain.writeFileDescriptor(FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new b().writeToParcel(obtain, 0);
        try {
            f6058a.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
    }

    private static Object a(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i2) {
        boolean z;
        IBinder asBinder;
        if (f6058a == null) {
            PackageManager packageManager = Zeus.getAppApplication().getPackageManager();
            Field field = packageManager == null ? null : FieldUtils.getField(packageManager.getClass(), "mPM");
            if (field != null) {
                Object a2 = a(field, packageManager);
                f6059b = a2;
                if ((a2 instanceof IInterface) && (asBinder = ((IInterface) f6059b).asBinder()) != null) {
                    f6058a = asBinder;
                }
            }
        }
        if (str != null) {
            String b2 = com.bytedance.pangle.d.c.b(str, i2);
            String e2 = com.bytedance.pangle.d.c.e(str, i2);
            try {
                com.bytedance.pangle.util.h.a(b2, e2);
            } catch (Exception unused) {
            }
            String packageName = Zeus.getAppApplication().getPackageName();
            String a3 = com.bytedance.pangle.e.b.a();
            int i3 = Build.VERSION.SDK_INT;
            if (i3 == 30) {
                if (f6059b != null && packageName != null && e2 != null && a3 != null) {
                    a(f6059b, "notifyDexLoad", new Object[]{packageName, Collections.singletonMap(e2, "PCL[]"), a3}, new Class[]{String.class, Map.class, String.class});
                }
            } else if (i3 == 29 && f6059b != null && packageName != null && e2 != null && a3 != null) {
                a(f6059b, "notifyDexLoad", new Object[]{packageName, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(e2), a3}, new Class[]{String.class, List.class, List.class, String.class});
            }
        }
        String e3 = com.bytedance.pangle.d.c.e(str, i2);
        String str2 = com.bytedance.pangle.d.c.h(str, i2) + File.separator + com.bytedance.pangle.e.b.a(e3);
        int i4 = 1;
        while (true) {
            if (i4 > 3) {
                z = false;
                break;
            }
            a(new String[]{"compile", "-m", "speed", "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName()});
            if (com.bytedance.pangle.e.b.a(str2)) {
                z = true;
                break;
            }
            i4++;
        }
        if (str != null) {
            try {
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.d.c.g(str, i2), com.bytedance.pangle.d.c.f(str, i2));
            } catch (Exception unused2) {
            }
            try {
                File file = new File(com.bytedance.pangle.d.c.e(str, i2));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused3) {
            }
            a(new String[]{"reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName()});
        }
        return z;
    }
}
