package x5;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
import m5.d;
import okhttp3.HttpUrl;

@TargetApi(15)
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    public static final String f31829a = "CameraConfiguration";

    /* renamed from: b */
    public static final Pattern f31830b = Pattern.compile(";");

    /* renamed from: c */
    public static final int f31831c = 153600;

    /* renamed from: d */
    public static final float f31832d = 1.5f;

    /* renamed from: e */
    public static final float f31833e = 0.0f;

    /* renamed from: f */
    public static final double f31834f = 0.15d;

    /* renamed from: g */
    public static final int f31835g = 10;

    /* renamed from: h */
    public static final int f31836h = 20;

    /* renamed from: i */
    public static final int f31837i = 400;

    /* renamed from: x5.a$a */
    public static class C0806a implements Comparator<Camera.Size> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            int i10 = size.height * size.width;
            int i11 = size2.height * size2.width;
            if (i11 < i10) {
                return -1;
            }
            return i11 > i10 ? 1 : 0;
        }
    }

    public static List<Camera.Area> a(int i10) {
        int i11 = -i10;
        return Collections.singletonList(new Camera.Area(new Rect(i11, i11, i10, i10), 1));
    }

    public static String b(Camera.Parameters parameters) {
        return c(parameters.flatten());
    }

    public static String c(CharSequence charSequence) {
        StringBuilder sb2 = new StringBuilder(1000);
        sb2.append("BOARD=");
        sb2.append(Build.BOARD);
        sb2.append('\n');
        sb2.append("BRAND=");
        sb2.append(Build.BRAND);
        sb2.append('\n');
        sb2.append("CPU_ABI=");
        sb2.append(Build.CPU_ABI);
        sb2.append('\n');
        sb2.append("DEVICE=");
        sb2.append(Build.DEVICE);
        sb2.append('\n');
        sb2.append("DISPLAY=");
        sb2.append(Build.DISPLAY);
        sb2.append('\n');
        sb2.append("FINGERPRINT=");
        sb2.append(Build.FINGERPRINT);
        sb2.append('\n');
        sb2.append("HOST=");
        sb2.append(Build.HOST);
        sb2.append('\n');
        sb2.append("ID=");
        sb2.append(Build.ID);
        sb2.append('\n');
        sb2.append("MANUFACTURER=");
        sb2.append(Build.MANUFACTURER);
        sb2.append('\n');
        sb2.append("MODEL=");
        sb2.append(Build.MODEL);
        sb2.append('\n');
        sb2.append("PRODUCT=");
        sb2.append(Build.PRODUCT);
        sb2.append('\n');
        sb2.append("TAGS=");
        sb2.append(Build.TAGS);
        sb2.append('\n');
        sb2.append("TIME=");
        sb2.append(Build.TIME);
        sb2.append('\n');
        sb2.append("TYPE=");
        sb2.append(Build.TYPE);
        sb2.append('\n');
        sb2.append("USER=");
        sb2.append(Build.USER);
        sb2.append('\n');
        sb2.append("VERSION.CODENAME=");
        sb2.append(Build.VERSION.CODENAME);
        sb2.append('\n');
        sb2.append("VERSION.INCREMENTAL=");
        sb2.append(Build.VERSION.INCREMENTAL);
        sb2.append('\n');
        sb2.append("VERSION.RELEASE=");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append('\n');
        sb2.append("VERSION.SDK_INT=");
        sb2.append(Build.VERSION.SDK_INT);
        sb2.append('\n');
        if (charSequence != null) {
            String[] split = f31830b.split(charSequence);
            Arrays.sort(split);
            for (String str : split) {
                sb2.append(str);
                sb2.append('\n');
            }
        }
        return sb2.toString();
    }

    public static Point d(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w(f31829a, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new C0806a());
        if (Log.isLoggable(f31829a, 4)) {
            StringBuilder sb2 = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb2.append(size.width);
                sb2.append('x');
                sb2.append(size.height);
                sb2.append(b5.a.O);
            }
            Log.i(f31829a, "Supported preview sizes: " + ((Object) sb2));
        }
        double d10 = point.x / point.y;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                if (!arrayList.isEmpty()) {
                    Camera.Size size2 = (Camera.Size) arrayList.get(0);
                    Point point2 = new Point(size2.width, size2.height);
                    Log.i(f31829a, "Using largest suitable preview size: " + point2);
                    return point2;
                }
                Camera.Size previewSize2 = parameters.getPreviewSize();
                if (previewSize2 == null) {
                    throw new IllegalStateException("Parameters contained no preview size!");
                }
                Point point3 = new Point(previewSize2.width, previewSize2.height);
                Log.i(f31829a, "No suitable preview sizes, using default: " + point3);
                return point3;
            }
            Camera.Size size3 = (Camera.Size) it.next();
            int i10 = size3.width;
            int i11 = size3.height;
            if (i10 * i11 < 153600) {
                it.remove();
            } else {
                boolean z10 = i10 < i11;
                int i12 = z10 ? i11 : i10;
                int i13 = z10 ? i10 : i11;
                if (Math.abs((i12 / i13) - d10) > 0.15d) {
                    it.remove();
                } else if (i12 == point.x && i13 == point.y) {
                    Point point4 = new Point(i10, i11);
                    Log.i(f31829a, "Found preview size exactly matching screen size: " + point4);
                    return point4;
                }
            }
        }
    }

    public static String e(String str, Collection<String> collection, String... strArr) {
        Log.i(f31829a, "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i(f31829a, "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i(f31829a, "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i(f31829a, "No supported values match");
        return null;
    }

    public static Integer f(Camera.Parameters parameters, double d10) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        Log.i(f31829a, "Zoom ratios: " + zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            Log.w(f31829a, "Invalid zoom ratios!");
            return null;
        }
        double d11 = d10 * 100.0d;
        double d12 = Double.POSITIVE_INFINITY;
        int i10 = 0;
        for (int i11 = 0; i11 < zoomRatios.size(); i11++) {
            double abs = Math.abs(zoomRatios.get(i11).intValue() - d11);
            if (abs < d12) {
                i10 = i11;
                d12 = abs;
            }
        }
        Log.i(f31829a, "Chose zoom ratio of " + (zoomRatios.get(i10).intValue() / 100.0d));
        return Integer.valueOf(i10);
    }

    public static void g(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i(f31829a, "Barcode scene mode already set");
            return;
        }
        String e10 = e("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (e10 != null) {
            parameters.setSceneMode(e10);
        }
    }

    public static void h(Camera.Parameters parameters, boolean z10) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int round = Math.round((z10 ? 0.0f : 1.5f) / exposureCompensationStep);
                float f10 = exposureCompensationStep * round;
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    Log.i(f31829a, "Exposure compensation already set to " + max + " / " + f10);
                    return;
                }
                Log.i(f31829a, "Setting exposure compensation to " + max + " / " + f10);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        Log.i(f31829a, "Camera does not support exposure compensation");
    }

    public static void i(Camera.Parameters parameters) {
        j(parameters, 10, 20);
    }

    public static void j(Camera.Parameters parameters, int i10, int i11) {
        int[] iArr;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i(f31829a, "Supported FPS ranges: " + s(supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                iArr = null;
                break;
            }
            iArr = it.next();
            int i12 = iArr[0];
            int i13 = iArr[1];
            if (i12 >= i10 * 1000 && i13 <= i11 * 1000) {
                break;
            }
        }
        if (iArr == null) {
            Log.i(f31829a, "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            Log.i(f31829a, "FPS range already set to " + Arrays.toString(iArr));
            return;
        }
        Log.i(f31829a, "Setting FPS range to " + Arrays.toString(iArr));
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    public static void k(Camera.Parameters parameters, boolean z10, boolean z11, boolean z12) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String e10 = z10 ? (z12 || z11) ? e("focus mode", supportedFocusModes, DebugKt.DEBUG_PROPERTY_VALUE_AUTO) : e("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", DebugKt.DEBUG_PROPERTY_VALUE_AUTO) : null;
        if (!z12 && e10 == null) {
            e10 = e("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (e10 != null) {
            if (!e10.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(e10);
                return;
            }
            Log.i(f31829a, "Focus mode already set to " + e10);
        }
    }

    public static void l(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i(f31829a, "Device does not support focus areas");
            return;
        }
        Log.i(f31829a, "Old focus areas: " + r(parameters.getFocusAreas()));
        List<Camera.Area> a10 = a(400);
        Log.i(f31829a, "Setting focus area to : " + r(a10));
        parameters.setFocusAreas(a10);
    }

    public static void m(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i(f31829a, "Negative effect already set");
            return;
        }
        String e10 = e("color effect", parameters.getSupportedColorEffects(), "negative");
        if (e10 != null) {
            parameters.setColorEffect(e10);
        }
    }

    public static void n(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            Log.i(f31829a, "Device does not support metering areas");
            return;
        }
        Log.i(f31829a, "Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> a10 = a(400);
        Log.i(f31829a, "Setting metering area to : " + r(a10));
        parameters.setMeteringAreas(a10);
    }

    public static void o(Camera.Parameters parameters, boolean z10) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String e10 = z10 ? e("flash mode", supportedFlashModes, "torch", DebugKt.DEBUG_PROPERTY_VALUE_ON) : e("flash mode", supportedFlashModes, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        if (e10 != null) {
            if (e10.equals(parameters.getFlashMode())) {
                Log.i(f31829a, "Flash mode already set to " + e10);
                return;
            }
            Log.i(f31829a, "Setting flash mode to " + e10);
            parameters.setFlashMode(e10);
        }
    }

    public static void p(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i(f31829a, "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i(f31829a, "Video stabilization already enabled");
        } else {
            Log.i(f31829a, "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void q(Camera.Parameters parameters, double d10) {
        if (!parameters.isZoomSupported()) {
            Log.i(f31829a, "Zoom is not supported");
            return;
        }
        Integer f10 = f(parameters, d10);
        if (f10 == null) {
            return;
        }
        if (parameters.getZoom() == f10.intValue()) {
            Log.i(f31829a, "Zoom is already set to " + f10);
            return;
        }
        Log.i(f31829a, "Setting zoom to " + f10);
        parameters.setZoom(f10.intValue());
    }

    public static String r(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb2.append(area.rect);
            sb2.append(d.f28378d);
            sb2.append(area.weight);
            sb2.append(b5.a.O);
        }
        return sb2.toString();
    }

    public static String s(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb2.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
        return sb2.toString();
    }
}
