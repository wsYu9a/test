package me.jessyan.autosize;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import me.jessyan.autosize.external.ExternalAdaptInfo;
import me.jessyan.autosize.internal.CustomAdapt;
import me.jessyan.autosize.unit.Subunits;
import me.jessyan.autosize.utils.Preconditions;

/* loaded from: classes5.dex */
public final class AutoSizeCompat {
    private static final int MODE_DEVICE_SIZE = Integer.MIN_VALUE;
    private static final int MODE_MASK = -1073741824;
    private static final int MODE_ON_WIDTH = 1073741824;
    private static final int MODE_SHIFT = 30;
    private static SparseArray<DisplayMetricsInfo> mCache = new SparseArray<>();

    /* renamed from: me.jessyan.autosize.AutoSizeCompat$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$me$jessyan$autosize$unit$Subunits;

        static {
            int[] iArr = new int[Subunits.values().length];
            $SwitchMap$me$jessyan$autosize$unit$Subunits = iArr;
            try {
                iArr[Subunits.PT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.MM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$me$jessyan$autosize$unit$Subunits[Subunits.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private AutoSizeCompat() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static void autoConvertDensity(Resources resources, float f2, boolean z) {
        float density;
        int densityDpi;
        float scaledDensity;
        float xdpi;
        int screenWidthDp;
        int screenHeightDp;
        Preconditions.checkNotNull(resources, "resources == null");
        Preconditions.checkMainThread();
        float designWidth = z ? AutoSizeConfig.getInstance().getUnitsManager().getDesignWidth() : AutoSizeConfig.getInstance().getUnitsManager().getDesignHeight();
        if (designWidth <= 0.0f) {
            designWidth = f2;
        }
        int round = Math.round((f2 + designWidth + (z ? AutoSizeConfig.getInstance().getScreenWidth() : AutoSizeConfig.getInstance().getScreenHeight())) * AutoSizeConfig.getInstance().getInitScaledDensity()) & 1073741823;
        int i2 = z ? round | 1073741824 : round & (-1073741825);
        int i3 = AutoSizeConfig.getInstance().isUseDeviceSize() ? i2 | Integer.MIN_VALUE : i2 & Integer.MAX_VALUE;
        DisplayMetricsInfo displayMetricsInfo = mCache.get(i3);
        if (displayMetricsInfo == null) {
            density = ((z ? AutoSizeConfig.getInstance().getScreenWidth() : AutoSizeConfig.getInstance().getScreenHeight()) * 1.0f) / f2;
            scaledDensity = (AutoSizeConfig.getInstance().getPrivateFontScale() > 0.0f ? AutoSizeConfig.getInstance().getPrivateFontScale() : AutoSizeConfig.getInstance().isExcludeFontScale() ? 1.0f : (AutoSizeConfig.getInstance().getInitScaledDensity() * 1.0f) / AutoSizeConfig.getInstance().getInitDensity()) * density;
            densityDpi = (int) (160.0f * density);
            screenWidthDp = (int) (AutoSizeConfig.getInstance().getScreenWidth() / density);
            screenHeightDp = (int) (AutoSizeConfig.getInstance().getScreenHeight() / density);
            float screenWidth = ((z ? AutoSizeConfig.getInstance().getScreenWidth() : AutoSizeConfig.getInstance().getScreenHeight()) * 1.0f) / designWidth;
            mCache.put(i3, new DisplayMetricsInfo(density, densityDpi, scaledDensity, screenWidth, screenWidthDp, screenHeightDp));
            xdpi = screenWidth;
        } else {
            density = displayMetricsInfo.getDensity();
            densityDpi = displayMetricsInfo.getDensityDpi();
            scaledDensity = displayMetricsInfo.getScaledDensity();
            xdpi = displayMetricsInfo.getXdpi();
            screenWidthDp = displayMetricsInfo.getScreenWidthDp();
            screenHeightDp = displayMetricsInfo.getScreenHeightDp();
        }
        setDensity(resources, density, densityDpi, scaledDensity, xdpi);
        setScreenSizeDp(resources, screenWidthDp, screenHeightDp);
    }

    public static void autoConvertDensityBaseOnHeight(Resources resources, float f2) {
        autoConvertDensity(resources, f2, false);
    }

    public static void autoConvertDensityBaseOnWidth(Resources resources, float f2) {
        autoConvertDensity(resources, f2, true);
    }

    public static void autoConvertDensityOfCustomAdapt(Resources resources, CustomAdapt customAdapt) {
        Preconditions.checkNotNull(customAdapt, "customAdapt == null");
        float sizeInDp = customAdapt.getSizeInDp();
        if (sizeInDp <= 0.0f) {
            sizeInDp = customAdapt.isBaseOnWidth() ? AutoSizeConfig.getInstance().getDesignWidthInDp() : AutoSizeConfig.getInstance().getDesignHeightInDp();
        }
        autoConvertDensity(resources, sizeInDp, customAdapt.isBaseOnWidth());
    }

    public static void autoConvertDensityOfExternalAdaptInfo(Resources resources, ExternalAdaptInfo externalAdaptInfo) {
        Preconditions.checkNotNull(externalAdaptInfo, "externalAdaptInfo == null");
        float sizeInDp = externalAdaptInfo.getSizeInDp();
        if (sizeInDp <= 0.0f) {
            sizeInDp = externalAdaptInfo.isBaseOnWidth() ? AutoSizeConfig.getInstance().getDesignWidthInDp() : AutoSizeConfig.getInstance().getDesignHeightInDp();
        }
        autoConvertDensity(resources, sizeInDp, externalAdaptInfo.isBaseOnWidth());
    }

    public static void autoConvertDensityOfGlobal(Resources resources) {
        if (AutoSizeConfig.getInstance().isBaseOnWidth()) {
            autoConvertDensityBaseOnWidth(resources, AutoSizeConfig.getInstance().getDesignWidthInDp());
        } else {
            autoConvertDensityBaseOnHeight(resources, AutoSizeConfig.getInstance().getDesignHeightInDp());
        }
    }

    public static void cancelAdapt(Resources resources) {
        float f2;
        Preconditions.checkMainThread();
        float initXdpi = AutoSizeConfig.getInstance().getInitXdpi();
        int i2 = AnonymousClass1.$SwitchMap$me$jessyan$autosize$unit$Subunits[AutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits().ordinal()];
        if (i2 != 1) {
            f2 = i2 == 2 ? 25.4f : 72.0f;
            setDensity(resources, AutoSizeConfig.getInstance().getInitDensity(), AutoSizeConfig.getInstance().getInitDensityDpi(), AutoSizeConfig.getInstance().getInitScaledDensity(), initXdpi);
            setScreenSizeDp(resources, AutoSizeConfig.getInstance().getInitScreenWidthDp(), AutoSizeConfig.getInstance().getInitScreenHeightDp());
        }
        initXdpi /= f2;
        setDensity(resources, AutoSizeConfig.getInstance().getInitDensity(), AutoSizeConfig.getInstance().getInitDensityDpi(), AutoSizeConfig.getInstance().getInitScaledDensity(), initXdpi);
        setScreenSizeDp(resources, AutoSizeConfig.getInstance().getInitScreenWidthDp(), AutoSizeConfig.getInstance().getInitScreenHeightDp());
    }

    private static DisplayMetrics getMetricsOnMiui(Resources resources) {
        if (AutoSizeConfig.getInstance().isMiui() && AutoSizeConfig.getInstance().getTmpMetricsField() != null) {
            try {
                return (DisplayMetrics) AutoSizeConfig.getInstance().getTmpMetricsField().get(resources);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static void setDensity(Resources resources, float f2, int i2, float f3, float f4) {
        setDensity(resources.getDisplayMetrics(), f2, i2, f3, f4);
        setDensity(AutoSizeConfig.getInstance().getApplication().getResources().getDisplayMetrics(), f2, i2, f3, f4);
        DisplayMetrics metricsOnMiui = getMetricsOnMiui(resources);
        DisplayMetrics metricsOnMiui2 = getMetricsOnMiui(AutoSizeConfig.getInstance().getApplication().getResources());
        if (metricsOnMiui != null) {
            setDensity(metricsOnMiui, f2, i2, f3, f4);
        }
        if (metricsOnMiui2 != null) {
            setDensity(metricsOnMiui2, f2, i2, f3, f4);
        }
    }

    private static void setScreenSizeDp(Resources resources, int i2, int i3) {
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportDP() && AutoSizeConfig.getInstance().getUnitsManager().isSupportScreenSizeDP()) {
            setScreenSizeDp(resources.getConfiguration(), i2, i3);
            setScreenSizeDp(AutoSizeConfig.getInstance().getApplication().getResources().getConfiguration(), i2, i3);
        }
    }

    private static void setScreenSizeDp(Configuration configuration, int i2, int i3) {
        configuration.screenWidthDp = i2;
        configuration.screenHeightDp = i3;
    }

    private static void setDensity(DisplayMetrics displayMetrics, float f2, int i2, float f3, float f4) {
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportDP()) {
            displayMetrics.density = f2;
            displayMetrics.densityDpi = i2;
        }
        if (AutoSizeConfig.getInstance().getUnitsManager().isSupportSP()) {
            displayMetrics.scaledDensity = f3;
        }
        int i3 = AnonymousClass1.$SwitchMap$me$jessyan$autosize$unit$Subunits[AutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits().ordinal()];
        if (i3 == 1) {
            displayMetrics.xdpi = f4 * 72.0f;
        } else if (i3 == 2) {
            displayMetrics.xdpi = f4 * 25.4f;
        } else {
            if (i3 != 4) {
                return;
            }
            displayMetrics.xdpi = f4;
        }
    }
}
