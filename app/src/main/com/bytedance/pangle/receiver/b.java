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

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    private static final c f7738a;

    public static class a implements c {
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
            Object b10 = b(context);
            Object a10 = a(b10, "mWhiteList");
            if (!(a10 instanceof String[])) {
                if (b10 == null) {
                    return false;
                }
                FieldUtils.writeField(b10, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) a10);
            FieldUtils.writeField(b10, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public /* synthetic */ a(byte b10) {
            this();
        }

        public static Object a(Context context, String str) {
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
    public static class C0233b extends e {
        private C0233b() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            return false;
        }

        public /* synthetic */ C0233b(byte b10) {
            this();
        }
    }

    public interface c {
        boolean a(Context context);
    }

    public static class d extends a {
        private d() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            Object a10 = a.a(context, "mWhiteList");
            if (!(a10 instanceof List)) {
                return false;
            }
            ((List) a10).add(context.getPackageName());
            return true;
        }

        public /* synthetic */ d(byte b10) {
            this();
        }
    }

    public static class e extends a {
        private e() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object a10 = a.a(context, "mWhiteListMap");
            if (!(a10 instanceof Map)) {
                return false;
            }
            Map map = (Map) a10;
            List list = (List) map.get(0);
            if (list == null) {
                list = new ArrayList();
                map.put(0, list);
            }
            list.add(context.getPackageName());
            return true;
        }

        public /* synthetic */ e(byte b10) {
            this();
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24) {
            f7738a = new a((byte) 0);
            return;
        }
        if (i10 < 26) {
            f7738a = new d((byte) 0);
        } else if (i10 < 28) {
            f7738a = new e((byte) 0);
        } else {
            f7738a = new C0233b((byte) 0);
        }
    }

    public static void a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), "huawei")) {
                    f7738a.a(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }
}
