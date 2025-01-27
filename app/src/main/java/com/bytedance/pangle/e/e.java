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

/* loaded from: classes2.dex */
public final class e implements f.a {

    /* renamed from: a */
    private static volatile IBinder f7555a;

    /* renamed from: b */
    private static volatile Object f7556b;

    public interface a {
    }

    public static class b extends ResultReceiver {

        /* renamed from: a */
        private a f7557a;

        public b() {
            super(null);
            this.f7557a = null;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i10, Bundle bundle) {
            super.onReceiveResult(i10, bundle);
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
            f7555a.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th2) {
            obtain.recycle();
            obtain2.recycle();
            throw th2;
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
    public final boolean a(String str, int i10) {
        IBinder asBinder;
        boolean z10 = false;
        if (f7555a == null) {
            PackageManager packageManager = Zeus.getAppApplication().getPackageManager();
            Field field = packageManager == null ? null : FieldUtils.getField(packageManager.getClass(), "mPM");
            if (field != null) {
                Object a10 = a(field, packageManager);
                f7556b = a10;
                if ((a10 instanceof IInterface) && (asBinder = ((IInterface) f7556b).asBinder()) != null) {
                    f7555a = asBinder;
                }
            }
        }
        if (str != null) {
            String b10 = com.bytedance.pangle.d.c.b(str, i10);
            String e10 = com.bytedance.pangle.d.c.e(str, i10);
            try {
                com.bytedance.pangle.util.h.a(b10, e10);
            } catch (Exception unused) {
            }
            String packageName = Zeus.getAppApplication().getPackageName();
            String a11 = com.bytedance.pangle.e.b.a();
            int i11 = Build.VERSION.SDK_INT;
            if (i11 == 30) {
                if (f7556b != null && packageName != null && e10 != null && a11 != null) {
                    a(f7556b, "notifyDexLoad", new Object[]{packageName, Collections.singletonMap(e10, "PCL[]"), a11}, new Class[]{String.class, Map.class, String.class});
                }
            } else if (i11 == 29 && f7556b != null && packageName != null && e10 != null && a11 != null) {
                a(f7556b, "notifyDexLoad", new Object[]{packageName, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(e10), a11}, new Class[]{String.class, List.class, List.class, String.class});
            }
        }
        String e11 = com.bytedance.pangle.d.c.e(str, i10);
        String str2 = com.bytedance.pangle.d.c.h(str, i10) + File.separator + com.bytedance.pangle.e.b.a(e11);
        int i12 = 1;
        while (true) {
            if (i12 > 3) {
                break;
            }
            a(new String[]{"compile", "-m", "speed", "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName()});
            if (com.bytedance.pangle.e.b.a(str2)) {
                z10 = true;
                break;
            }
            i12++;
        }
        if (str != null) {
            try {
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.d.c.g(str, i10), com.bytedance.pangle.d.c.f(str, i10));
            } catch (Exception unused2) {
            }
            try {
                File file = new File(com.bytedance.pangle.d.c.e(str, i10));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused3) {
            }
            a(new String[]{"reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName()});
        }
        return z10;
    }
}
