package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private static final c f6231a;

    static class a implements c {
        private a() {
        }

        private static Object b(Context context) {
            Field field;
            Object readField;
            try {
                Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (readField = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field2, readField);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object b2 = b(context);
            Object a2 = a(b2, "mWhiteList");
            if (!(a2 instanceof String[])) {
                if (b2 == null) {
                    return false;
                }
                FieldUtils.writeField(b2, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) a2);
            FieldUtils.writeField(b2, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        static Object a(Context context, String str) {
            return a(b(context), str);
        }

        private static Object a(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$b */
    static class C0073b extends e {
        private C0073b() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            return false;
        }

        /* synthetic */ C0073b(byte b2) {
            this();
        }
    }

    interface c {
        boolean a(Context context);
    }

    static class d extends a {
        private d() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            Object a2 = a.a(context, "mWhiteList");
            if (!(a2 instanceof List)) {
                return false;
            }
            ((List) a2).add(context.getPackageName());
            return true;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static class e extends a {
        private e() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object a2 = a.a(context, "mWhiteListMap");
            if (!(a2 instanceof Map)) {
                return false;
            }
            Map map = (Map) a2;
            List list = (List) map.get(0);
            if (list == null) {
                list = new ArrayList();
                map.put(0, list);
            }
            list.add(context.getPackageName());
            return true;
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24) {
            f6231a = new a((byte) 0);
            return;
        }
        if (i2 < 26) {
            f6231a = new d((byte) 0);
        } else if (i2 < 28) {
            f6231a = new e((byte) 0);
        } else {
            f6231a = new C0073b((byte) 0);
        }
    }

    public static void a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), "huawei")) {
                    f6231a.a(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }
}
