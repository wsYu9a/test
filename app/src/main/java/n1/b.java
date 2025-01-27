package n1;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import m1.e;
import p1.f;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public static ILogger f28724a = new p1.c("ARouter::");

    /* renamed from: b */
    public static volatile boolean f28725b = false;

    /* renamed from: c */
    public static volatile boolean f28726c = false;

    /* renamed from: d */
    public static volatile boolean f28727d = false;

    /* renamed from: e */
    public static volatile b f28728e = null;

    /* renamed from: f */
    public static volatile boolean f28729f = false;

    /* renamed from: g */
    public static volatile ThreadPoolExecutor f28730g = o1.b.a();

    /* renamed from: h */
    public static Handler f28731h;

    /* renamed from: i */
    public static Context f28732i;

    /* renamed from: j */
    public static InterceptorService f28733j;

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Postcard f28734b;

        public a(Postcard postcard) {
            this.f28734b = postcard;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(b.f28732i, "There's no route matched!\n Path = [" + this.f28734b.getPath() + "]\n Group = [" + this.f28734b.getGroup() + "]", 1).show();
        }
    }

    /* renamed from: n1.b$b */
    public class C0745b implements InterceptorCallback {

        /* renamed from: a */
        public final /* synthetic */ int f28736a;

        /* renamed from: b */
        public final /* synthetic */ NavigationCallback f28737b;

        /* renamed from: c */
        public final /* synthetic */ Postcard f28738c;

        public C0745b(int i10, NavigationCallback navigationCallback, Postcard postcard) {
            this.f28736a = i10;
            this.f28737b = navigationCallback;
            this.f28738c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            b.this.a(postcard, this.f28736a, this.f28737b);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th2) {
            NavigationCallback navigationCallback = this.f28737b;
            if (navigationCallback != null) {
                navigationCallback.onInterrupt(this.f28738c);
            }
            b.f28724a.info("ARouter::", "Navigation failed, termination by interceptor : " + th2.getMessage());
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ int f28740b;

        /* renamed from: c */
        public final /* synthetic */ Context f28741c;

        /* renamed from: d */
        public final /* synthetic */ Intent f28742d;

        /* renamed from: e */
        public final /* synthetic */ Postcard f28743e;

        /* renamed from: f */
        public final /* synthetic */ NavigationCallback f28744f;

        public c(int i10, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
            this.f28740b = i10;
            this.f28741c = context;
            this.f28742d = intent;
            this.f28743e = postcard;
            this.f28744f = navigationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.startActivity(this.f28740b, this.f28741c, this.f28742d, this.f28743e, this.f28744f);
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f28746a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f28746a = iArr;
            try {
                iArr[RouteType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28746a[RouteType.PROVIDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28746a[RouteType.BOARDCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28746a[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28746a[RouteType.FRAGMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28746a[RouteType.METHOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f28746a[RouteType.SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static synchronized void A(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (b.class) {
            f28730g = threadPoolExecutor;
        }
    }

    public static void B(ILogger iLogger) {
        if (iLogger != null) {
            f28724a = iLogger;
        }
    }

    public static void f() {
        f28733j = (InterceptorService) n1.a.j().d("/arouter/service/interceptor").navigation();
    }

    @Deprecated
    public static void g() {
        Log.i("ARouter::", "ARouter start attachBaseContext");
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            declaredField.set(invoke, new m1.c());
            Log.i("ARouter::", "ARouter hook instrumentation success!");
        } catch (Exception e10) {
            Log.e("ARouter::", "ARouter hook instrumentation failed! [" + e10.getMessage() + "]");
        }
    }

    @Deprecated
    public static boolean k() {
        return f28727d;
    }

    public static boolean l() {
        return f28726c;
    }

    public static synchronized void m() {
        synchronized (b.class) {
            try {
                if (l()) {
                    f28729f = false;
                    e.l();
                    f28724a.info("ARouter::", "ARouter destroy success!");
                } else {
                    f28724a.error("ARouter::", "Destroy can be used in debug mode only!");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Deprecated
    public static synchronized void n() {
        synchronized (b.class) {
            f28727d = true;
        }
    }

    public static b p() {
        if (!f28729f) {
            throw new InitException("ARouterCore::Init::Invoke init(context) first!");
        }
        if (f28728e == null) {
            synchronized (b.class) {
                try {
                    if (f28728e == null) {
                        f28728e = new b();
                    }
                } finally {
                }
            }
        }
        return f28728e;
    }

    public static synchronized boolean q(Application application) {
        synchronized (b.class) {
            f28732i = application;
            e.d(application, f28730g);
            f28724a.info("ARouter::", "ARouter init success!");
            f28729f = true;
            f28731h = new Handler(Looper.getMainLooper());
        }
        return true;
    }

    public static void r(Object obj) {
        AutowiredService autowiredService = (AutowiredService) n1.a.j().d("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public static boolean s() {
        return f28725b;
    }

    public void startActivity(int i10, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i10 < 0) {
            ContextCompat.startActivity(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            ActivityCompat.startActivityForResult((Activity) context, intent, i10, postcard.getOptionsBundle());
        } else {
            f28724a.warning("ARouter::", "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (-1 != postcard.getEnterAnim() && -1 != postcard.getExitAnim() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }

    public static synchronized void t() {
        synchronized (b.class) {
            f28725b = true;
            f28724a.info("ARouter::", "ARouter monitorMode on");
        }
    }

    public static synchronized void w() {
        synchronized (b.class) {
            f28726c = true;
            f28724a.info("ARouter::", "ARouter openDebug");
        }
    }

    public static synchronized void x() {
        synchronized (b.class) {
            f28724a.showLog(true);
            f28724a.info("ARouter::", "ARouter openLog");
        }
    }

    public static synchronized void y() {
        synchronized (b.class) {
            f28724a.showStackTrace(true);
            f28724a.info("ARouter::", "ARouter printStackTrace");
        }
    }

    public final Object a(Postcard postcard, int i10, NavigationCallback navigationCallback) {
        Context context = postcard.getContext();
        int i11 = d.f28746a[postcard.getType().ordinal()];
        if (i11 == 1) {
            Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (flags != 0) {
                intent.setFlags(flags);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            String action = postcard.getAction();
            if (!f.d(action)) {
                intent.setAction(action);
            }
            z(new c(i10, context, intent, postcard, navigationCallback));
            return null;
        }
        if (i11 == 2) {
            return postcard.getProvider();
        }
        if (i11 == 3 || i11 == 4 || i11 == 5) {
            try {
                Object newInstance = postcard.getDestination().getConstructor(null).newInstance(null);
                if (newInstance instanceof Fragment) {
                    ((Fragment) newInstance).setArguments(postcard.getExtras());
                } else if (newInstance instanceof androidx.fragment.app.Fragment) {
                    ((androidx.fragment.app.Fragment) newInstance).setArguments(postcard.getExtras());
                }
                return newInstance;
            } catch (Exception e10) {
                f28724a.error("ARouter::", "Fetch fragment instance error, " + f.a(e10.getStackTrace()));
            }
        }
        return null;
    }

    public boolean e(IRouteGroup iRouteGroup) {
        if (iRouteGroup == null) {
            return false;
        }
        try {
            HashMap hashMap = new HashMap();
            iRouteGroup.loadInto(hashMap);
            String str = null;
            for (Map.Entry<String, RouteMeta> entry : hashMap.entrySet()) {
                String o10 = o(entry.getKey());
                RouteMeta value = entry.getValue();
                if (str == null) {
                    str = o10;
                }
                if (str != null && str.equals(o10) && str.equals(value.getGroup())) {
                }
                return false;
            }
            e.a(str, iRouteGroup);
            f28724a.info("ARouter::", "Add route group [" + str + "] finish, " + hashMap.size() + " new route meta.");
            return true;
        } catch (Exception e10) {
            f28724a.error("ARouter::", "Add route group dynamic exception!", e10);
            return false;
        }
    }

    public Postcard h(Uri uri) {
        if (uri == null || f.d(uri.toString())) {
            throw new HandlerException("ARouter::Parameter invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) n1.a.j().p(PathReplaceService.class);
        if (pathReplaceService != null) {
            uri = pathReplaceService.forUri(uri);
        }
        return new Postcard(uri.getPath(), o(uri.getPath()), uri, null);
    }

    public Postcard i(String str) {
        if (f.d(str)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) n1.a.j().p(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return j(str, o(str), Boolean.TRUE);
    }

    public Postcard j(String str, String str2, Boolean bool) {
        PathReplaceService pathReplaceService;
        if (f.d(str) || f.d(str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        if (!bool.booleanValue() && (pathReplaceService = (PathReplaceService) n1.a.j().p(PathReplaceService.class)) != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }

    public final String o(String str) {
        if (f.d(str) || !str.startsWith("/")) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String substring = str.substring(1, str.indexOf("/", 1));
            if (f.d(substring)) {
                throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
            }
            return substring;
        } catch (Exception e10) {
            f28724a.warning("ARouter::", "Failed to extract default group! " + e10.getMessage());
            return null;
        }
    }

    public Object u(Context context, Postcard postcard, int i10, NavigationCallback navigationCallback) {
        PretreatmentService pretreatmentService = (PretreatmentService) n1.a.j().p(PretreatmentService.class);
        if (pretreatmentService != null && !pretreatmentService.onPretreatment(context, postcard)) {
            return null;
        }
        postcard.setContext(context == null ? f28732i : context);
        try {
            e.c(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return a(postcard, i10, navigationCallback);
            }
            f28733j.doInterceptions(postcard, new C0745b(i10, navigationCallback, postcard));
            return null;
        } catch (NoRouteFoundException e10) {
            f28724a.warning("ARouter::", e10.getMessage());
            if (l()) {
                z(new a(postcard));
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) n1.a.j().p(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    public <T> T v(Class<? extends T> cls) {
        try {
            Postcard b10 = e.b(cls.getName());
            if (b10 == null) {
                b10 = e.b(cls.getSimpleName());
            }
            if (b10 == null) {
                return null;
            }
            b10.setContext(f28732i);
            e.c(b10);
            return (T) b10.getProvider();
        } catch (NoRouteFoundException e10) {
            f28724a.warning("ARouter::", e10.getMessage());
            return null;
        }
    }

    public final void z(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f28731h.post(runnable);
        } else {
            runnable.run();
        }
    }
}
