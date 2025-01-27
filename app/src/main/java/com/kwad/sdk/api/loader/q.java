package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Reflect;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class q {
    private static Map<String, Resources> aaB = new HashMap();
    private static final Object aaC = new Object();

    static final class a {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) Reflect.a(resources.getClass()).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    static final class b {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return c(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.bf("android.content.res.HwResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    static final class c {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return e(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.bf("android.content.res.MiuiResourcesImpl").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    static final class d {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                try {
                    return g(resources, assetManager);
                } catch (Exception unused) {
                    return a.a(resources, assetManager);
                }
            } catch (Exception unused2) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }

        private static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.bf("android.content.res.MiuiResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    static final class e {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return i(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.bf("android.content.res.NubiaResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    static final class f {
        public static Resources a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return b(context, resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.bf("android.content.res.VivoResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 == null) {
                throw new RuntimeException("Can not create Resources");
            }
            try {
                Reflect.c(resources2).a("init", new Class[]{String.class}, context.getPackageName());
            } catch (Reflect.ReflectException e2) {
                e2.printStackTrace();
            }
            try {
                Reflect.c(resources2).a("mThemeValues", Reflect.c(resources).get("mThemeValues"));
            } catch (Reflect.ReflectException e3) {
                e3.printStackTrace();
            }
            return resources2;
        }
    }

    private static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        return a(resources) ? d.a(resources, assetManager) : b(resources) ? c.a(resources, assetManager) : e(resources) ? b.a(resources, assetManager) : c(resources) ? f.a(context, resources, assetManager) : d(resources) ? e.a(resources, assetManager) : f(resources) ? a.a(resources, assetManager) : new Resources(assetManager, displayMetrics, configuration);
    }

    @NonNull
    static Resources a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (aaC) {
            resources2 = aaB.get(str);
            if (resources2 == null) {
                resources2 = b(context, resources, str);
                if (resources2 == null) {
                    throw new RuntimeException("Can not createResources for " + str);
                }
                aaB.put(str, resources);
            }
        }
        return resources2;
    }

    private static void a(AssetManager assetManager, String str) {
        try {
            Reflect.c(assetManager).a("addOverlayPath", new Class[]{String.class}, str);
        } catch (Throwable unused) {
            Reflect.c(assetManager).a("addAssetPath", new Class[]{String.class}, str);
        }
    }

    private static boolean a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }

    private static int b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Reflect.c(assetManager).a("addAssetPathAsSharedLibrary", new Class[]{String.class}, str);
            } else {
                Reflect.c(assetManager).a("addAssetPath", new Class[]{String.class}, str);
            }
        } catch (Throwable unused) {
            Reflect.c(assetManager).a("addAssetPath", new Class[]{String.class}, str);
        }
        return 0;
    }

    private static Resources b(Context context, Resources resources, String str) {
        AssetManager assetManager = (AssetManager) Reflect.a((Class<?>) AssetManager.class).tv().get();
        Reflect.c(assetManager).a("addAssetPath", new Class[]{String.class}, str);
        if (Build.VERSION.SDK_INT >= 21) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            try {
                Object obj = Reflect.c(applicationInfo).get("resourceDirs");
                if (obj != null && obj.getClass().isArray()) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length > 0) {
                        for (Object obj2 : objArr) {
                            if (obj2 instanceof String) {
                                a(assetManager, (String) obj2);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                String[] strArr = applicationInfo.sharedLibraryFiles;
                if (strArr != null && strArr.length > 0) {
                    for (String str2 : strArr) {
                        if (str2 != null && str2.endsWith(".apk")) {
                            b(assetManager, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return a(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private static boolean b(Resources resources) {
        return "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName());
    }

    private static boolean c(Resources resources) {
        return "android.content.res.VivoResources".equals(resources.getClass().getName());
    }

    private static boolean d(Resources resources) {
        return "android.content.res.NubiaResources".equals(resources.getClass().getName());
    }

    private static boolean e(Resources resources) {
        return "android.content.res.HwResources".equals(resources.getClass().getName());
    }

    private static boolean f(Resources resources) {
        return !"android.content.res.Resources".equals(resources.getClass().getName());
    }
}
