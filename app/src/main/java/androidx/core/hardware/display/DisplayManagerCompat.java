package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";

    /* renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<Context, DisplayManagerCompat> f1804a = new WeakHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final Context f1805b;

    private DisplayManagerCompat(Context context) {
        this.f1805b = context;
    }

    @NonNull
    public static DisplayManagerCompat getInstance(@NonNull Context context) {
        DisplayManagerCompat displayManagerCompat;
        WeakHashMap<Context, DisplayManagerCompat> weakHashMap = f1804a;
        synchronized (weakHashMap) {
            displayManagerCompat = weakHashMap.get(context);
            if (displayManagerCompat == null) {
                displayManagerCompat = new DisplayManagerCompat(context);
                weakHashMap.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    @Nullable
    public Display getDisplay(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((DisplayManager) this.f1805b.getSystemService("display")).getDisplay(i2);
        }
        Display defaultDisplay = ((WindowManager) this.f1805b.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getDisplayId() == i2) {
            return defaultDisplay;
        }
        return null;
    }

    @NonNull
    public Display[] getDisplays() {
        return Build.VERSION.SDK_INT >= 17 ? ((DisplayManager) this.f1805b.getSystemService("display")).getDisplays() : new Display[]{((WindowManager) this.f1805b.getSystemService("window")).getDefaultDisplay()};
    }

    @NonNull
    public Display[] getDisplays(@Nullable String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((DisplayManager) this.f1805b.getSystemService("display")).getDisplays(str);
        }
        return str == null ? new Display[0] : new Display[]{((WindowManager) this.f1805b.getSystemService("window")).getDefaultDisplay()};
    }
}
