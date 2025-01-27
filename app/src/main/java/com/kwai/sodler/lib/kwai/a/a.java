package com.kwai.sodler.lib.kwai.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a {
    private static Map<String, Resources> aaB = new HashMap();
    private static final Object aaC = new Object();

    /* renamed from: com.kwai.sodler.lib.kwai.a.a$a */
    static final class C0251a {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) s.a(resources.getClass(), assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
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
                    return C0251a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.c("android.content.res.HwResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
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
                    return C0251a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.c("android.content.res.MiuiResourcesImpl", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
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
                    return C0251a.a(resources, assetManager);
                }
            } catch (Exception unused2) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }

        private static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.c("android.content.res.MiuiResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
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
                    return C0251a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.c("android.content.res.NubiaResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
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
                    return C0251a.a(resources, assetManager);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.c("android.content.res.VivoResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 == null) {
                throw new RuntimeException("Can not create Resources");
            }
            try {
                s.c(resources2, "init", context.getPackageName());
            } catch (Exception e2) {
                com.kwai.sodler.lib.a.e("ResourcesManager", "createVivoResources init failed", e2);
            }
            try {
                s.b(resources2, "mThemeValues", s.e(resources, "mThemeValues"));
            } catch (Exception e3) {
                com.kwai.sodler.lib.a.e("ResourcesManager", "createVivoResources set mThemeValues failed", e3);
            }
            return resources2;
        }
    }

    private static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        return a(resources) ? d.a(resources, assetManager) : b(resources) ? c.a(resources, assetManager) : e(resources) ? b.a(resources, assetManager) : c(resources) ? f.a(context, resources, assetManager) : d(resources) ? e.a(resources, assetManager) : f(resources) ? C0251a.a(resources, assetManager) : new Resources(assetManager, displayMetrics, configuration);
    }

    @NonNull
    public static Resources a(Context context, Resources resources, String str) {
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
            s.c(assetManager, "addOverlayPath", str);
        } catch (Throwable unused) {
            s.c(assetManager, "addAssetPath", str);
        }
    }

    private static boolean a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }

    private static int b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                s.c(assetManager, "addAssetPathAsSharedLibrary", str);
            } else {
                s.c(assetManager, "addAssetPath", str);
            }
        } catch (Throwable unused) {
            s.c(assetManager, "addAssetPath", str);
        }
        return 0;
    }

    private static Resources b(Context context, Resources resources, String str) {
        AssetManager assetManager = (AssetManager) s.i(AssetManager.class);
        s.c(assetManager, "addAssetPath", str);
        if (Build.VERSION.SDK_INT >= 21) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            try {
                Object d2 = s.d(applicationInfo, "resourceDirs");
                if (d2 != null && d2.getClass().isArray()) {
                    Object[] objArr = (Object[]) d2;
                    if (objArr.length > 0) {
                        for (Object obj : objArr) {
                            if (obj instanceof String) {
                                a(assetManager, (String) obj);
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
