package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DisplayCompat {

    /* renamed from: a */
    private static final int f2007a = 3840;

    /* renamed from: b */
    private static final int f2008b = 2160;

    private DisplayCompat() {
    }

    private static Point a(@NonNull Context context, @NonNull Display display) {
        int i2 = Build.VERSION.SDK_INT;
        Point f2 = i2 < 28 ? f("sys.display-size", display) : f("vendor.display-size", display);
        if (f2 != null) {
            return f2;
        }
        if (c(context)) {
            return new Point(f2007a, f2008b);
        }
        Point point = new Point();
        if (i2 >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
        } else if (i2 >= 17) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        return point;
    }

    @Nullable
    private static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean c(@NonNull Context context) {
        return d(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    private static boolean d(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static Point e(@NonNull String str) throws NumberFormatException {
        String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    private static Point f(@NonNull String str, @NonNull Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String b2 = b(str);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            return e(b2);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @RequiresApi(23)
    private static boolean g(Display.Mode mode, Point point) {
        return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        Point a2 = a(context, display);
        if (Build.VERSION.SDK_INT < 23) {
            return new ModeCompat[]{new ModeCompat(a2)};
        }
        Display.Mode[] supportedModes = display.getSupportedModes();
        ArrayList arrayList = new ArrayList(supportedModes.length);
        boolean z = false;
        for (int i2 = 0; i2 < supportedModes.length; i2++) {
            if (g(supportedModes[i2], a2)) {
                arrayList.add(i2, new ModeCompat(supportedModes[i2], true));
                z = true;
            } else {
                arrayList.add(i2, new ModeCompat(supportedModes[i2], false));
            }
        }
        if (!z) {
            arrayList.add(new ModeCompat(a2));
        }
        return (ModeCompat[]) arrayList.toArray(new ModeCompat[0]);
    }

    public static final class ModeCompat {

        /* renamed from: a */
        private final Display.Mode f2009a;

        /* renamed from: b */
        private final Point f2010b;

        /* renamed from: c */
        private final boolean f2011c;

        ModeCompat(@NonNull Point point) {
            Preconditions.checkNotNull(point, "physicalDisplaySize == null");
            this.f2011c = true;
            this.f2010b = point;
            this.f2009a = null;
        }

        public int getPhysicalHeight() {
            return this.f2010b.y;
        }

        public int getPhysicalWidth() {
            return this.f2010b.x;
        }

        public boolean isNative() {
            return this.f2011c;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.f2009a;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, boolean z) {
            Preconditions.checkNotNull(mode, "Display.Mode == null, can't wrap a null reference");
            this.f2011c = z;
            this.f2010b = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.f2009a = mode;
        }
    }
}
