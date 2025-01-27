package qe;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: f */
    public static final String f30012f = "b";

    /* renamed from: g */
    public static final int f30013g = 27;

    /* renamed from: h */
    public static final int f30014h = 30;

    /* renamed from: i */
    public static final Pattern f30015i = Pattern.compile(",");

    /* renamed from: a */
    public final Context f30016a;

    /* renamed from: b */
    public Point f30017b;

    /* renamed from: c */
    public Point f30018c;

    /* renamed from: d */
    public int f30019d;

    /* renamed from: e */
    public String f30020e;

    public b(Context context) {
        this.f30016a = context;
    }

    public static int a(CharSequence charSequence, int i10) {
        int i11 = 0;
        for (String str : f30015i.split(charSequence)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                int i12 = (int) (10.0d * parseDouble);
                if (Math.abs(i10 - parseDouble) < Math.abs(i10 - i11)) {
                    i11 = i12;
                }
            } catch (NumberFormatException unused) {
                return i10;
            }
        }
        return i11;
    }

    public static Point b(CharSequence charSequence, Point point) {
        String[] split = f30015i.split(charSequence);
        int length = split.length;
        int i10 = Integer.MAX_VALUE;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            String trim = split[i11].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                Log.w(f30012f, "Bad preview-size: " + trim);
            } else {
                try {
                    int parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - point.x) + Math.abs(parseInt2 - point.y);
                    if (abs == 0) {
                        i13 = parseInt2;
                        i12 = parseInt;
                        break;
                    }
                    if (abs < i10) {
                        i13 = parseInt2;
                        i10 = abs;
                        i12 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    Log.w(f30012f, "Bad preview-size: " + trim);
                }
            }
            i11++;
        }
        if (i12 <= 0 || i13 <= 0) {
            return null;
        }
        return new Point(i12, i13);
    }

    public static Point d(Camera.Parameters parameters, Point point) {
        Point point2;
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        if (str != null) {
            Log.d(f30012f, "preview-size-values parameter: " + str);
            point2 = b(str, point);
        } else {
            point2 = null;
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    public static int e() {
        return 30;
    }

    public Point c() {
        return this.f30018c;
    }

    public int f() {
        return this.f30019d;
    }

    public String g() {
        return this.f30020e;
    }

    public Point h() {
        return this.f30017b;
    }

    public void i(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.f30019d = parameters.getPreviewFormat();
        this.f30020e = parameters.get("preview-format");
        String str = f30012f;
        Log.d(str, "Default preview format: " + this.f30019d + '/' + this.f30020e);
        Display defaultDisplay = ((WindowManager) this.f30016a.getSystemService("window")).getDefaultDisplay();
        this.f30017b = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Log.d(str, "Screen resolution: " + this.f30017b);
        this.f30018c = d(parameters, this.f30017b);
        Log.d(str, "Camera resolution: " + this.f30017b);
    }

    public void j(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Log.d(f30012f, "Setting preview size: " + this.f30018c);
        Point point = this.f30018c;
        parameters.setPreviewSize(point.x, point.y);
        l(parameters);
        m(parameters);
        k(camera);
        camera.setParameters(parameters);
    }

    public final void k(Camera camera) {
        try {
            Method method = camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
            if (method != null) {
                method.invoke(camera, 90);
            }
        } catch (Exception unused) {
        }
    }

    public final void l(Camera.Parameters parameters) {
        parameters.set("flash-value", 2);
        parameters.set("flash-mode", DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }

    public final void m(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            String str2 = parameters.get("max-zoom");
            int i10 = 27;
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i10 = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    Log.w(f30012f, "Bad max-zoom: " + str2);
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i10 > parseInt) {
                        i10 = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    Log.w(f30012f, "Bad taking-picture-zoom-max: " + str3);
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i10 = a(str4, i10);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i10 -= i10 % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(i10 / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i10);
            }
        }
    }
}
