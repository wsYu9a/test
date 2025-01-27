package m1;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    public static Context f28263a;

    /* renamed from: b */
    public static ThreadPoolExecutor f28264b;

    /* renamed from: c */
    public static boolean f28265c;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f28266a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f28266a = iArr;
            try {
                iArr[RouteType.PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28266a[RouteType.FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static synchronized void a(String str, IRouteGroup iRouteGroup) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        synchronized (e.class) {
            try {
                if (f.f28267a.containsKey(str)) {
                    f.f28267a.get(str).getConstructor(null).newInstance(null).loadInto(f.f28268b);
                    f.f28267a.remove(str);
                }
                if (iRouteGroup != null) {
                    iRouteGroup.loadInto(f.f28268b);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static Postcard b(String str) {
        RouteMeta routeMeta = f.f28270d.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    public static synchronized void c(Postcard postcard) {
        synchronized (e.class) {
            try {
                if (postcard == null) {
                    throw new NoRouteFoundException("ARouter::No postcard!");
                }
                RouteMeta routeMeta = f.f28268b.get(postcard.getPath());
                if (routeMeta != null) {
                    postcard.setDestination(routeMeta.getDestination());
                    postcard.setType(routeMeta.getType());
                    postcard.setPriority(routeMeta.getPriority());
                    postcard.setExtra(routeMeta.getExtra());
                    Uri uri = postcard.getUri();
                    if (uri != null) {
                        Map<String, String> e10 = p1.f.e(uri);
                        Map<String, Integer> paramsType = routeMeta.getParamsType();
                        if (p1.d.b(paramsType)) {
                            for (Map.Entry<String, Integer> entry : paramsType.entrySet()) {
                                k(postcard, entry.getValue(), entry.getKey(), e10.get(entry.getKey()));
                            }
                            postcard.getExtras().putStringArray(n1.a.f28720b, (String[]) paramsType.keySet().toArray(new String[0]));
                        }
                        postcard.withString(n1.a.f28719a, uri.toString());
                    }
                    int i10 = a.f28266a[routeMeta.getType().ordinal()];
                    if (i10 == 1) {
                        Class<?> destination = routeMeta.getDestination();
                        IProvider iProvider = f.f28269c.get(destination);
                        if (iProvider == null) {
                            try {
                                iProvider = (IProvider) destination.getConstructor(null).newInstance(null);
                                iProvider.init(f28263a);
                                f.f28269c.put(destination, iProvider);
                            } catch (Exception e11) {
                                n1.a.f28723e.error("ARouter::", "Init provider failed!", e11);
                                throw new HandlerException("Init provider failed!");
                            }
                        }
                        postcard.setProvider(iProvider);
                        postcard.greenChannel();
                    } else if (i10 == 2) {
                        postcard.greenChannel();
                    }
                } else {
                    if (!f.f28267a.containsKey(postcard.getGroup())) {
                        throw new NoRouteFoundException("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
                    }
                    try {
                        if (n1.a.g()) {
                            n1.a.f28723e.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] starts loading, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                        }
                        a(postcard.getGroup(), null);
                        if (n1.a.g()) {
                            n1.a.f28723e.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] has already been loaded, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                        }
                        c(postcard);
                    } catch (Exception e12) {
                        throw new HandlerException("ARouter::Fatal exception when loading group meta. [" + e12.getMessage() + "]");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba A[Catch: all -> 0x001e, Exception -> 0x0021, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x0008, B:8:0x0013, B:9:0x0115, B:11:0x013f, B:12:0x0148, B:14:0x014e, B:19:0x0024, B:21:0x002a, B:24:0x0031, B:25:0x007e, B:26:0x00b4, B:28:0x00ba, B:45:0x00c9, B:31:0x00dd, B:42:0x00e5, B:34:0x00f9, B:37:0x0101, B:48:0x0051, B:50:0x0068, B:51:0x007b), top: B:5:0x0008, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void d(android.content.Context r8, java.util.concurrent.ThreadPoolExecutor r9) throws com.alibaba.android.arouter.exception.HandlerException {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.e.d(android.content.Context, java.util.concurrent.ThreadPoolExecutor):void");
    }

    public static void e() {
        f28265c = false;
    }

    public static void f() {
        if (f28265c) {
            return;
        }
        f28265c = true;
    }

    public static void g(String str) {
        if (p1.f.d(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str).getConstructor(null).newInstance(null);
            if (newInstance instanceof IRouteRoot) {
                j((IRouteRoot) newInstance);
            } else if (newInstance instanceof IProviderGroup) {
                i((IProviderGroup) newInstance);
            } else if (newInstance instanceof IInterceptorGroup) {
                h((IInterceptorGroup) newInstance);
            } else {
                n1.a.f28723e.info("ARouter::", "register failed, class name: " + str + " should implements one of IRouteRoot/IProviderGroup/IInterceptorGroup.");
            }
        } catch (Exception e10) {
            n1.a.f28723e.error("ARouter::", "register class error:" + str, e10);
        }
    }

    public static void h(IInterceptorGroup iInterceptorGroup) {
        f();
        if (iInterceptorGroup != null) {
            iInterceptorGroup.loadInto(f.f28271e);
        }
    }

    public static void i(IProviderGroup iProviderGroup) {
        f();
        if (iProviderGroup != null) {
            iProviderGroup.loadInto(f.f28270d);
        }
    }

    public static void j(IRouteRoot iRouteRoot) {
        f();
        if (iRouteRoot != null) {
            iRouteRoot.loadInto(f.f28267a);
        }
    }

    public static void k(Postcard postcard, Integer num, String str, String str2) {
        if (p1.f.d(str) || p1.f.d(str2)) {
            return;
        }
        try {
            if (num == null) {
                postcard.withString(str, str2);
            } else if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                postcard.withBoolean(str, Boolean.parseBoolean(str2));
            } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                postcard.withByte(str, Byte.parseByte(str2));
            } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                postcard.withShort(str, Short.parseShort(str2));
            } else if (num.intValue() == TypeKind.INT.ordinal()) {
                postcard.withInt(str, Integer.parseInt(str2));
            } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                postcard.withLong(str, Long.parseLong(str2));
            } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                postcard.withFloat(str, Float.parseFloat(str2));
            } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                postcard.withDouble(str, Double.parseDouble(str2));
            } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                postcard.withString(str, str2);
            } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                    postcard.withString(str, str2);
                } else {
                    postcard.withString(str, str2);
                }
            }
        } catch (Throwable th2) {
            n1.a.f28723e.warning("ARouter::", "LogisticsCenter setValue failed! " + th2.getMessage());
        }
    }

    public static void l() {
        f.a();
    }
}
