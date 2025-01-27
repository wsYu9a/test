package me.jessyan.autosize;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.lang.reflect.Field;
import me.jessyan.autosize.external.ExternalAdaptManager;
import me.jessyan.autosize.unit.Subunits;
import me.jessyan.autosize.unit.UnitsManager;
import me.jessyan.autosize.utils.AutoSizeLog;
import me.jessyan.autosize.utils.Preconditions;
import me.jessyan.autosize.utils.ScreenUtils;
import qe.c;

/* loaded from: classes4.dex */
public final class AutoSizeConfig {
    public static final boolean DEPENDENCY_ANDROIDX = findClassByClassName("androidx.fragment.app.FragmentActivity");
    public static final boolean DEPENDENCY_SUPPORT = findClassByClassName("androidx.fragment.app.FragmentActivity");
    private static final String KEY_DESIGN_HEIGHT_IN_DP = "design_height_in_dp";
    private static final String KEY_DESIGN_WIDTH_IN_DP = "design_width_in_dp";
    private static volatile AutoSizeConfig sInstance;
    private boolean isCustomFragment;
    private boolean isExcludeFontScale;
    private boolean isMiui;
    private boolean isStop;
    private boolean isVertical;
    private ActivityLifecycleCallbacksImpl mActivityLifecycleCallbacks;
    private Application mApplication;
    private int mDesignHeightInDp;
    private int mDesignWidthInDp;
    private int mInitDensityDpi;
    private float mInitScaledDensity;
    private int mInitScreenHeightDp;
    private int mInitScreenWidthDp;
    private float mInitXdpi;
    private onAdaptListener mOnAdaptListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mStatusBarHeight;
    private Field mTmpMetricsField;
    private float privateFontScale;
    private ExternalAdaptManager mExternalAdaptManager = new ExternalAdaptManager();
    private UnitsManager mUnitsManager = new UnitsManager();
    private float mInitDensity = -1.0f;
    private boolean isBaseOnWidth = true;
    private boolean isUseDeviceSize = true;

    /* renamed from: me.jessyan.autosize.AutoSizeConfig$1 */
    public class AnonymousClass1 implements ComponentCallbacks {
        final /* synthetic */ Application val$application;

        public AnonymousClass1(Application application) {
            application = application;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            if (configuration != null) {
                if (configuration.fontScale > 0.0f) {
                    AutoSizeConfig.this.mInitScaledDensity = Resources.getSystem().getDisplayMetrics().scaledDensity;
                    AutoSizeLog.d("initScaledDensity = " + AutoSizeConfig.this.mInitScaledDensity + " on ConfigurationChanged");
                }
                AutoSizeConfig.this.isVertical = configuration.orientation == 1;
                int[] screenSize = ScreenUtils.getScreenSize(application);
                AutoSizeConfig.this.mScreenWidth = screenSize[0];
                AutoSizeConfig.this.mScreenHeight = screenSize[1];
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    /* renamed from: me.jessyan.autosize.AutoSizeConfig$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context val$context;

        public AnonymousClass2(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle;
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                    return;
                }
                if (bundle.containsKey(AutoSizeConfig.KEY_DESIGN_WIDTH_IN_DP)) {
                    AutoSizeConfig.this.mDesignWidthInDp = ((Integer) applicationInfo.metaData.get(AutoSizeConfig.KEY_DESIGN_WIDTH_IN_DP)).intValue();
                }
                if (applicationInfo.metaData.containsKey(AutoSizeConfig.KEY_DESIGN_HEIGHT_IN_DP)) {
                    AutoSizeConfig.this.mDesignHeightInDp = ((Integer) applicationInfo.metaData.get(AutoSizeConfig.KEY_DESIGN_HEIGHT_IN_DP)).intValue();
                }
            } catch (PackageManager.NameNotFoundException e10) {
                e10.printStackTrace();
            }
        }
    }

    private AutoSizeConfig() {
    }

    private static boolean findClassByClassName(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static AutoSizeConfig getInstance() {
        if (sInstance == null) {
            synchronized (AutoSizeConfig.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new AutoSizeConfig();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private void getMetaData(Context context) {
        new Thread(new Runnable() { // from class: me.jessyan.autosize.AutoSizeConfig.2
            final /* synthetic */ Context val$context;

            public AnonymousClass2(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle;
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                        return;
                    }
                    if (bundle.containsKey(AutoSizeConfig.KEY_DESIGN_WIDTH_IN_DP)) {
                        AutoSizeConfig.this.mDesignWidthInDp = ((Integer) applicationInfo.metaData.get(AutoSizeConfig.KEY_DESIGN_WIDTH_IN_DP)).intValue();
                    }
                    if (applicationInfo.metaData.containsKey(AutoSizeConfig.KEY_DESIGN_HEIGHT_IN_DP)) {
                        AutoSizeConfig.this.mDesignHeightInDp = ((Integer) applicationInfo.metaData.get(AutoSizeConfig.KEY_DESIGN_HEIGHT_IN_DP)).intValue();
                    }
                } catch (PackageManager.NameNotFoundException e10) {
                    e10.printStackTrace();
                }
            }
        }).start();
    }

    public Application getApplication() {
        Preconditions.checkNotNull(this.mApplication, "Please call the AutoSizeConfig#init() first");
        return this.mApplication;
    }

    public int getDesignHeightInDp() {
        Preconditions.checkArgument(this.mDesignHeightInDp > 0, "you must set design_height_in_dp  in your AndroidManifest file");
        return this.mDesignHeightInDp;
    }

    public int getDesignWidthInDp() {
        Preconditions.checkArgument(this.mDesignWidthInDp > 0, "you must set design_width_in_dp  in your AndroidManifest file");
        return this.mDesignWidthInDp;
    }

    public ExternalAdaptManager getExternalAdaptManager() {
        return this.mExternalAdaptManager;
    }

    public float getInitDensity() {
        return this.mInitDensity;
    }

    public int getInitDensityDpi() {
        return this.mInitDensityDpi;
    }

    public float getInitScaledDensity() {
        return this.mInitScaledDensity;
    }

    public int getInitScreenHeightDp() {
        return this.mInitScreenHeightDp;
    }

    public int getInitScreenWidthDp() {
        return this.mInitScreenWidthDp;
    }

    public float getInitXdpi() {
        return this.mInitXdpi;
    }

    public onAdaptListener getOnAdaptListener() {
        return this.mOnAdaptListener;
    }

    public float getPrivateFontScale() {
        return this.privateFontScale;
    }

    public int getScreenHeight() {
        return isUseDeviceSize() ? this.mScreenHeight : this.mScreenHeight - this.mStatusBarHeight;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public Field getTmpMetricsField() {
        return this.mTmpMetricsField;
    }

    public UnitsManager getUnitsManager() {
        return this.mUnitsManager;
    }

    public AutoSizeConfig init(Application application) {
        return init(application, true, null);
    }

    public boolean isBaseOnWidth() {
        return this.isBaseOnWidth;
    }

    public boolean isCustomFragment() {
        return this.isCustomFragment;
    }

    public boolean isExcludeFontScale() {
        return this.isExcludeFontScale;
    }

    public boolean isMiui() {
        return this.isMiui;
    }

    public boolean isStop() {
        return this.isStop;
    }

    public boolean isUseDeviceSize() {
        return this.isUseDeviceSize;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    public void restart() {
        Preconditions.checkNotNull(this.mActivityLifecycleCallbacks, "Please call the AutoSizeConfig#init() first");
        synchronized (AutoSizeConfig.class) {
            try {
                if (this.isStop) {
                    this.mApplication.registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
                    this.isStop = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public AutoSizeConfig setAutoAdaptStrategy(AutoAdaptStrategy autoAdaptStrategy) {
        Preconditions.checkNotNull(autoAdaptStrategy, "autoAdaptStrategy == null");
        Preconditions.checkNotNull(this.mActivityLifecycleCallbacks, "Please call the AutoSizeConfig#init() first");
        this.mActivityLifecycleCallbacks.setAutoAdaptStrategy(new WrapperAutoAdaptStrategy(autoAdaptStrategy));
        return this;
    }

    public AutoSizeConfig setBaseOnWidth(boolean z10) {
        this.isBaseOnWidth = z10;
        return this;
    }

    public AutoSizeConfig setCustomFragment(boolean z10) {
        this.isCustomFragment = z10;
        return this;
    }

    public AutoSizeConfig setDesignHeightInDp(int i10) {
        Preconditions.checkArgument(i10 > 0, "designHeightInDp must be > 0");
        this.mDesignHeightInDp = i10;
        return this;
    }

    public AutoSizeConfig setDesignWidthInDp(int i10) {
        Preconditions.checkArgument(i10 > 0, "designWidthInDp must be > 0");
        this.mDesignWidthInDp = i10;
        return this;
    }

    public AutoSizeConfig setExcludeFontScale(boolean z10) {
        this.isExcludeFontScale = z10;
        return this;
    }

    public AutoSizeConfig setLog(boolean z10) {
        AutoSizeLog.setDebug(z10);
        return this;
    }

    public AutoSizeConfig setOnAdaptListener(onAdaptListener onadaptlistener) {
        Preconditions.checkNotNull(onadaptlistener, "onAdaptListener == null");
        this.mOnAdaptListener = onadaptlistener;
        return this;
    }

    public AutoSizeConfig setPrivateFontScale(float f10) {
        this.privateFontScale = f10;
        return this;
    }

    public AutoSizeConfig setScreenHeight(int i10) {
        Preconditions.checkArgument(i10 > 0, "screenHeight must be > 0");
        this.mScreenHeight = i10;
        return this;
    }

    public AutoSizeConfig setScreenWidth(int i10) {
        Preconditions.checkArgument(i10 > 0, "screenWidth must be > 0");
        this.mScreenWidth = i10;
        return this;
    }

    public AutoSizeConfig setStatusBarHeight(int i10) {
        Preconditions.checkArgument(i10 > 0, "statusBarHeight must be > 0");
        this.mStatusBarHeight = i10;
        return this;
    }

    public AutoSizeConfig setUseDeviceSize(boolean z10) {
        this.isUseDeviceSize = z10;
        return this;
    }

    public AutoSizeConfig setVertical(boolean z10) {
        this.isVertical = z10;
        return this;
    }

    public void stop(Activity activity) {
        Preconditions.checkNotNull(this.mActivityLifecycleCallbacks, "Please call the AutoSizeConfig#init() first");
        synchronized (AutoSizeConfig.class) {
            try {
                if (!this.isStop) {
                    this.mApplication.unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
                    AutoSize.cancelAdapt(activity);
                    this.isStop = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public AutoSizeConfig init(Application application, boolean z10) {
        return init(application, z10, null);
    }

    public AutoSizeConfig init(Application application, boolean z10, AutoAdaptStrategy autoAdaptStrategy) {
        Preconditions.checkArgument(this.mInitDensity == -1.0f, "AutoSizeConfig#init() can only be called once");
        Preconditions.checkNotNull(application, "application == null");
        this.mApplication = application;
        this.isBaseOnWidth = z10;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (getInstance().getUnitsManager().getSupportSubunits() == Subunits.NONE) {
            this.mDesignWidthInDp = c.f30025o;
            this.mDesignHeightInDp = 640;
        } else {
            this.mDesignWidthInDp = DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
            this.mDesignHeightInDp = 1920;
        }
        getMetaData(application);
        this.isVertical = application.getResources().getConfiguration().orientation == 1;
        int[] screenSize = ScreenUtils.getScreenSize(application);
        this.mScreenWidth = screenSize[0];
        this.mScreenHeight = screenSize[1];
        this.mStatusBarHeight = ScreenUtils.getStatusBarHeight();
        AutoSizeLog.d("designWidthInDp = " + this.mDesignWidthInDp + ", designHeightInDp = " + this.mDesignHeightInDp + ", screenWidth = " + this.mScreenWidth + ", screenHeight = " + this.mScreenHeight);
        this.mInitDensity = displayMetrics.density;
        this.mInitDensityDpi = displayMetrics.densityDpi;
        this.mInitScaledDensity = displayMetrics.scaledDensity;
        this.mInitXdpi = displayMetrics.xdpi;
        this.mInitScreenWidthDp = configuration.screenWidthDp;
        this.mInitScreenHeightDp = configuration.screenHeightDp;
        application.registerComponentCallbacks(new ComponentCallbacks() { // from class: me.jessyan.autosize.AutoSizeConfig.1
            final /* synthetic */ Application val$application;

            public AnonymousClass1(Application application2) {
                application = application2;
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration2) {
                if (configuration2 != null) {
                    if (configuration2.fontScale > 0.0f) {
                        AutoSizeConfig.this.mInitScaledDensity = Resources.getSystem().getDisplayMetrics().scaledDensity;
                        AutoSizeLog.d("initScaledDensity = " + AutoSizeConfig.this.mInitScaledDensity + " on ConfigurationChanged");
                    }
                    AutoSizeConfig.this.isVertical = configuration2.orientation == 1;
                    int[] screenSize2 = ScreenUtils.getScreenSize(application);
                    AutoSizeConfig.this.mScreenWidth = screenSize2[0];
                    AutoSizeConfig.this.mScreenHeight = screenSize2[1];
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        });
        AutoSizeLog.d("initDensity = " + this.mInitDensity + ", initScaledDensity = " + this.mInitScaledDensity);
        if (autoAdaptStrategy == null) {
            autoAdaptStrategy = new DefaultAutoAdaptStrategy();
        }
        ActivityLifecycleCallbacksImpl activityLifecycleCallbacksImpl = new ActivityLifecycleCallbacksImpl(new WrapperAutoAdaptStrategy(autoAdaptStrategy));
        this.mActivityLifecycleCallbacks = activityLifecycleCallbacksImpl;
        application2.registerActivityLifecycleCallbacks(activityLifecycleCallbacksImpl);
        if ("MiuiResources".equals(application2.getResources().getClass().getSimpleName()) || "XResources".equals(application2.getResources().getClass().getSimpleName())) {
            this.isMiui = true;
            try {
                Field declaredField = Resources.class.getDeclaredField("mTmpMetrics");
                this.mTmpMetricsField = declaredField;
                declaredField.setAccessible(true);
            } catch (Exception unused) {
                this.mTmpMetricsField = null;
            }
        }
        return this;
    }
}
