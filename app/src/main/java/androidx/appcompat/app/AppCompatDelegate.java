package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppLocalesStorageHelper;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class AppCompatDelegate {
    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;

    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;

    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    static AppLocalesStorageHelper.SerialExecutor sSerialExecutorForLocalesStorage = new AppLocalesStorageHelper.SerialExecutor(new AppLocalesStorageHelper.ThreadPerTaskExecutor());
    private static int sDefaultNightMode = -100;
    private static LocaleListCompat sRequestedAppLocales = null;
    private static LocaleListCompat sStoredAppLocales = null;
    private static Boolean sIsAutoStoreLocalesOptedIn = null;
    private static boolean sIsFrameworkSyncChecked = false;
    private static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates = new ArraySet<>();
    private static final Object sActivityDelegatesLock = new Object();
    private static final Object sAppLocalesStorageSyncLock = new Object();

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleList localeListForLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static LocaleList localeManagerGetApplicationLocales(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        public static void localeManagerSetApplicationLocales(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NightMode {
    }

    public static void addActiveDelegate(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (sActivityDelegatesLock) {
            removeDelegateFromActives(appCompatDelegate);
            sActivityDelegates.add(new WeakReference<>(appCompatDelegate));
        }
    }

    private static void applyDayNightToActiveDelegates() {
        synchronized (sActivityDelegatesLock) {
            try {
                Iterator<WeakReference<AppCompatDelegate>> it = sActivityDelegates.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate = it.next().get();
                    if (appCompatDelegate != null) {
                        appCompatDelegate.applyDayNight();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void applyLocalesToActiveDelegates() {
        Iterator<WeakReference<AppCompatDelegate>> it = sActivityDelegates.iterator();
        while (it.hasNext()) {
            AppCompatDelegate appCompatDelegate = it.next().get();
            if (appCompatDelegate != null) {
                appCompatDelegate.applyAppLocales();
            }
        }
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Activity activity, @Nullable AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    @NonNull
    @AnyThread
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static LocaleListCompat getApplicationLocales() {
        if (BuildCompat.isAtLeastT()) {
            Object localeManagerForApplication = getLocaleManagerForApplication();
            if (localeManagerForApplication != null) {
                return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(localeManagerForApplication));
            }
        } else {
            LocaleListCompat localeListCompat = sRequestedAppLocales;
            if (localeListCompat != null) {
                return localeListCompat;
            }
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    @RequiresApi(33)
    public static Object getLocaleManagerForApplication() {
        Context contextForDelegate;
        Iterator<WeakReference<AppCompatDelegate>> it = sActivityDelegates.iterator();
        while (it.hasNext()) {
            AppCompatDelegate appCompatDelegate = it.next().get();
            if (appCompatDelegate != null && (contextForDelegate = appCompatDelegate.getContextForDelegate()) != null) {
                return contextForDelegate.getSystemService("locale");
            }
        }
        return null;
    }

    @Nullable
    public static LocaleListCompat getRequestedAppLocales() {
        return sRequestedAppLocales;
    }

    @Nullable
    public static LocaleListCompat getStoredAppLocales() {
        return sStoredAppLocales;
    }

    public static boolean isAutoStorageOptedIn(Context context) {
        if (sIsAutoStoreLocalesOptedIn == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.getServiceInfo(context).metaData;
                if (bundle != null) {
                    sIsAutoStoreLocalesOptedIn = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d(TAG, "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                sIsAutoStoreLocalesOptedIn = Boolean.FALSE;
            }
        }
        return sIsAutoStoreLocalesOptedIn.booleanValue();
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    public static /* synthetic */ void lambda$syncRequestedAndStoredLocales$1(Context context) {
        AppLocalesStorageHelper.syncLocalesToFramework(context);
        sIsFrameworkSyncChecked = true;
    }

    public static void removeActivityDelegate(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (sActivityDelegatesLock) {
            removeDelegateFromActives(appCompatDelegate);
        }
    }

    private static void removeDelegateFromActives(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (sActivityDelegatesLock) {
            try {
                Iterator<WeakReference<AppCompatDelegate>> it = sActivityDelegates.iterator();
                while (it.hasNext()) {
                    AppCompatDelegate appCompatDelegate2 = it.next().get();
                    if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @VisibleForTesting
    public static void resetStaticRequestedAndStoredLocales() {
        sRequestedAppLocales = null;
        sStoredAppLocales = null;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void setApplicationLocales(@NonNull LocaleListCompat localeListCompat) {
        Objects.requireNonNull(localeListCompat);
        if (BuildCompat.isAtLeastT()) {
            Object localeManagerForApplication = getLocaleManagerForApplication();
            if (localeManagerForApplication != null) {
                Api33Impl.localeManagerSetApplicationLocales(localeManagerForApplication, Api24Impl.localeListForLanguageTags(localeListCompat.toLanguageTags()));
                return;
            }
            return;
        }
        if (localeListCompat.equals(sRequestedAppLocales)) {
            return;
        }
        synchronized (sActivityDelegatesLock) {
            sRequestedAppLocales = localeListCompat;
            applyLocalesToActiveDelegates();
        }
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z10) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(z10);
    }

    public static void setDefaultNightMode(int i10) {
        if (i10 != -1 && i10 != 0 && i10 != 1 && i10 != 2 && i10 != 3) {
            Log.d(TAG, "setDefaultNightMode() called with an unknown mode");
        } else if (sDefaultNightMode != i10) {
            sDefaultNightMode = i10;
            applyDayNightToActiveDelegates();
        }
    }

    @VisibleForTesting
    public static void setIsAutoStoreLocalesOptedIn(boolean z10) {
        sIsAutoStoreLocalesOptedIn = Boolean.valueOf(z10);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void syncRequestedAndStoredLocales(Context context) {
        if (isAutoStorageOptedIn(context)) {
            if (BuildCompat.isAtLeastT()) {
                if (sIsFrameworkSyncChecked) {
                    return;
                }
                sSerialExecutorForLocalesStorage.execute(new Runnable() { // from class: h.a

                    /* renamed from: b */
                    public final /* synthetic */ Context f26373b;

                    public /* synthetic */ a(Context context2) {
                        context = context2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(context);
                    }
                });
                return;
            }
            synchronized (sAppLocalesStorageSyncLock) {
                try {
                    LocaleListCompat localeListCompat = sRequestedAppLocales;
                    if (localeListCompat == null) {
                        if (sStoredAppLocales == null) {
                            sStoredAppLocales = LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(context2));
                        }
                        if (sStoredAppLocales.isEmpty()) {
                        } else {
                            sRequestedAppLocales = sStoredAppLocales;
                        }
                    } else if (!localeListCompat.equals(sStoredAppLocales)) {
                        LocaleListCompat localeListCompat2 = sRequestedAppLocales;
                        sStoredAppLocales = localeListCompat2;
                        AppLocalesStorageHelper.persistLocales(context2, localeListCompat2.toLanguageTags());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public boolean applyAppLocales() {
        return false;
    }

    public abstract boolean applyDayNight();

    public void asyncExecuteSyncRequestedAndStoredLocales(Context context) {
        sSerialExecutorForLocalesStorage.execute(new Runnable() { // from class: h.b

            /* renamed from: b */
            public final /* synthetic */ Context f26374b;

            public /* synthetic */ b(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AppCompatDelegate.syncRequestedAndStoredLocales(context);
            }
        });
    }

    @Deprecated
    public void attachBaseContext(Context context) {
    }

    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context context) {
        attachBaseContext(context);
        return context;
    }

    public abstract View createView(@Nullable View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

    @Nullable
    public abstract <T extends View> T findViewById(@IdRes int i10);

    @Nullable
    public Context getContextForDelegate() {
        return null;
    }

    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    @Nullable
    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int i10);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i10);

    public abstract void setContentView(@LayoutRes int i10);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setHandleNativeActionModesEnabled(boolean z10);

    @RequiresApi(17)
    public abstract void setLocalNightMode(int i10);

    @RequiresApi(33)
    @CallSuper
    public void setOnBackInvokedDispatcher(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void setSupportActionBar(@Nullable Toolbar toolbar);

    public void setTheme(@StyleRes int i10) {
    }

    public abstract void setTitle(@Nullable CharSequence charSequence);

    @Nullable
    public abstract ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback);

    @NonNull
    public static AppCompatDelegate create(@NonNull Dialog dialog, @Nullable AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context context, @NonNull Window window, @Nullable AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(context, window, appCompatCallback);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context context, @NonNull Activity activity, @Nullable AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(context, activity, appCompatCallback);
    }
}
