package b.f.a.a.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4797a = "b";

    /* renamed from: b, reason: collision with root package name */
    private static final int f4798b = 27;

    /* renamed from: c, reason: collision with root package name */
    private static final int f4799c = 30;

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f4800d = Pattern.compile(",");

    /* renamed from: e, reason: collision with root package name */
    private final Context f4801e;

    /* renamed from: f, reason: collision with root package name */
    private Point f4802f;

    /* renamed from: g, reason: collision with root package name */
    private Point f4803g;

    /* renamed from: h, reason: collision with root package name */
    private int f4804h;

    /* renamed from: i, reason: collision with root package name */
    private String f4805i;

    b(Context context) {
        this.f4801e = context;
    }

    private static int a(CharSequence stringValues, int tenDesiredZoom) {
        int i2 = 0;
        for (String str : f4800d.split(stringValues)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                int i3 = (int) (10.0d * parseDouble);
                double d2 = tenDesiredZoom;
                Double.isNaN(d2);
                if (Math.abs(d2 - parseDouble) < Math.abs(tenDesiredZoom - i2)) {
                    i2 = i3;
                }
            } catch (NumberFormatException unused) {
                return tenDesiredZoom;
            }
        }
        return i2;
    }

    private static Point b(CharSequence previewSizeValueString, Point screenResolution) {
        String[] split = f4800d.split(previewSizeValueString);
        int length = split.length;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String trim = split[i3].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                Log.w(f4797a, "Bad preview-size: " + trim);
            } else {
                try {
                    int parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - screenResolution.x) + Math.abs(parseInt2 - screenResolution.y);
                    if (abs == 0) {
                        i5 = parseInt2;
                        i4 = parseInt;
                        break;
                    }
                    if (abs < i2) {
                        i5 = parseInt2;
                        i2 = abs;
                        i4 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    Log.w(f4797a, "Bad preview-size: " + trim);
                }
            }
            i3++;
        }
        if (i4 <= 0 || i5 <= 0) {
            return null;
        }
        return new Point(i4, i5);
    }

    private static Point d(Camera.Parameters parameters, Point screenResolution) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point point = null;
        if (str != null) {
            Log.d(f4797a, "preview-size-values parameter: " + str);
            point = b(str, screenResolution);
        }
        return point == null ? new Point((screenResolution.x >> 3) << 3, (screenResolution.y >> 3) << 3) : point;
    }

    public static int e() {
        return 30;
    }

    private void l(Camera.Parameters parameters) {
        parameters.set("flash-value", 2);
        parameters.set("flash-mode", com.alipay.mobilesecuritysdk.constant.a.f5219j);
    }

    private void m(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i2 = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i2 = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    Log.w(f4797a, "Bad max-zoom: " + str2);
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i2 > parseInt) {
                        i2 = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    Log.w(f4797a, "Bad taking-picture-zoom-max: " + str3);
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i2 = a(str4, i2);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i2 -= i2 % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                double d2 = i2;
                Double.isNaN(d2);
                parameters.set("zoom", String.valueOf(d2 / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i2);
            }
        }
    }

    Point c() {
        return this.f4803g;
    }

    int f() {
        return this.f4804h;
    }

    String g() {
        return this.f4805i;
    }

    Point h() {
        return this.f4802f;
    }

    void i(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.f4804h = parameters.getPreviewFormat();
        this.f4805i = parameters.get("preview-format");
        String str = f4797a;
        Log.d(str, "Default preview format: " + this.f4804h + '/' + this.f4805i);
        Display defaultDisplay = ((WindowManager) this.f4801e.getSystemService("window")).getDefaultDisplay();
        this.f4802f = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Log.d(str, "Screen resolution: " + this.f4802f);
        this.f4803g = d(parameters, this.f4802f);
        Log.d(str, "Camera resolution: " + this.f4802f);
    }

    void j(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Log.d(f4797a, "Setting preview size: " + this.f4803g);
        Point point = this.f4803g;
        parameters.setPreviewSize(point.x, point.y);
        l(parameters);
        m(parameters);
        k(camera);
        camera.setParameters(parameters);
    }

    protected void k(Camera camera) {
        try {
            Method method = camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
                method.invoke(camera, 90);
            }
        } catch (Exception unused) {
        }
    }
}
