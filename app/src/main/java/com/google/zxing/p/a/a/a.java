package com.google.zxing.p.a.a;

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

@TargetApi(15)
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f8649a = "CameraConfiguration";

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f8650b = Pattern.compile(";");

    /* renamed from: c, reason: collision with root package name */
    private static final int f8651c = 153600;

    /* renamed from: d, reason: collision with root package name */
    private static final float f8652d = 1.5f;

    /* renamed from: e, reason: collision with root package name */
    private static final float f8653e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private static final double f8654f = 0.15d;

    /* renamed from: g, reason: collision with root package name */
    private static final int f8655g = 10;

    /* renamed from: h, reason: collision with root package name */
    private static final int f8656h = 20;

    /* renamed from: i, reason: collision with root package name */
    private static final int f8657i = 400;

    /* renamed from: com.google.zxing.p.a.a.a$a, reason: collision with other inner class name */
    static class C0113a implements Comparator<Camera.Size> {
        C0113a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            int i2 = size.height * size.width;
            int i3 = size2.height * size2.width;
            if (i3 < i2) {
                return -1;
            }
            return i3 > i2 ? 1 : 0;
        }
    }

    private a() {
    }

    private static List<Camera.Area> a(int i2) {
        int i3 = -i2;
        return Collections.singletonList(new Camera.Area(new Rect(i3, i3, i2, i2), 1));
    }

    public static String b(Camera.Parameters parameters) {
        return c(parameters.flatten());
    }

    public static String c(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(Build.BOARD);
        sb.append('\n');
        sb.append("BRAND=");
        sb.append(Build.BRAND);
        sb.append('\n');
        sb.append("CPU_ABI=");
        sb.append(Build.CPU_ABI);
        sb.append('\n');
        sb.append("DEVICE=");
        sb.append(Build.DEVICE);
        sb.append('\n');
        sb.append("DISPLAY=");
        sb.append(Build.DISPLAY);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append('\n');
        sb.append("HOST=");
        sb.append(Build.HOST);
        sb.append('\n');
        sb.append("ID=");
        sb.append(Build.ID);
        sb.append('\n');
        sb.append("MANUFACTURER=");
        sb.append(Build.MANUFACTURER);
        sb.append('\n');
        sb.append("MODEL=");
        sb.append(Build.MODEL);
        sb.append('\n');
        sb.append("PRODUCT=");
        sb.append(Build.PRODUCT);
        sb.append('\n');
        sb.append("TAGS=");
        sb.append(Build.TAGS);
        sb.append('\n');
        sb.append("TIME=");
        sb.append(Build.TIME);
        sb.append('\n');
        sb.append("TYPE=");
        sb.append(Build.TYPE);
        sb.append('\n');
        sb.append("USER=");
        sb.append(Build.USER);
        sb.append('\n');
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append('\n');
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append('\n');
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.RELEASE);
        sb.append('\n');
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (charSequence != null) {
            String[] split = f8650b.split(charSequence);
            Arrays.sort(split);
            for (String str : split) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static Point d(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w(f8649a, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new C0113a());
        if (Log.isLoggable(f8649a, 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            Log.i(f8649a, "Supported preview sizes: " + ((Object) sb));
        }
        double d2 = point.x;
        double d3 = point.y;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                if (!arrayList.isEmpty()) {
                    Camera.Size size2 = (Camera.Size) arrayList.get(0);
                    Point point2 = new Point(size2.width, size2.height);
                    Log.i(f8649a, "Using largest suitable preview size: " + point2);
                    return point2;
                }
                Camera.Size previewSize2 = parameters.getPreviewSize();
                if (previewSize2 == null) {
                    throw new IllegalStateException("Parameters contained no preview size!");
                }
                Point point3 = new Point(previewSize2.width, previewSize2.height);
                Log.i(f8649a, "No suitable preview sizes, using default: " + point3);
                return point3;
            }
            Camera.Size size3 = (Camera.Size) it.next();
            int i2 = size3.width;
            int i3 = size3.height;
            if (i2 * i3 < f8651c) {
                it.remove();
            } else {
                boolean z = i2 < i3;
                int i4 = z ? i3 : i2;
                int i5 = z ? i2 : i3;
                double d5 = i4;
                double d6 = i5;
                Double.isNaN(d5);
                Double.isNaN(d6);
                if (Math.abs((d5 / d6) - d4) > f8654f) {
                    it.remove();
                } else if (i4 == point.x && i5 == point.y) {
                    Point point4 = new Point(i2, i3);
                    Log.i(f8649a, "Found preview size exactly matching screen size: " + point4);
                    return point4;
                }
            }
        }
    }

    private static String e(String str, Collection<String> collection, String... strArr) {
        Log.i(f8649a, "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i(f8649a, "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i(f8649a, "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i(f8649a, "No supported values match");
        return null;
    }

    private static Integer f(Camera.Parameters parameters, double d2) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        Log.i(f8649a, "Zoom ratios: " + zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            Log.w(f8649a, "Invalid zoom ratios!");
            return null;
        }
        double d3 = d2 * 100.0d;
        double d4 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        for (int i3 = 0; i3 < zoomRatios.size(); i3++) {
            double intValue = zoomRatios.get(i3).intValue();
            Double.isNaN(intValue);
            double abs = Math.abs(intValue - d3);
            if (abs < d4) {
                i2 = i3;
                d4 = abs;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Chose zoom ratio of ");
        double intValue2 = zoomRatios.get(i2).intValue();
        Double.isNaN(intValue2);
        sb.append(intValue2 / 100.0d);
        Log.i(f8649a, sb.toString());
        return Integer.valueOf(i2);
    }

    public static void g(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i(f8649a, "Barcode scene mode already set");
            return;
        }
        String e2 = e("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (e2 != null) {
            parameters.setSceneMode(e2);
        }
    }

    public static void h(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int round = Math.round((z ? 0.0f : f8652d) / exposureCompensationStep);
                float f2 = exposureCompensationStep * round;
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    Log.i(f8649a, "Exposure compensation already set to " + max + " / " + f2);
                    return;
                }
                Log.i(f8649a, "Setting exposure compensation to " + max + " / " + f2);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        Log.i(f8649a, "Camera does not support exposure compensation");
    }

    public static void i(Camera.Parameters parameters) {
        j(parameters, 10, 20);
    }

    public static void j(Camera.Parameters parameters, int i2, int i3) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i(f8649a, "Supported FPS ranges: " + s(supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        int[] iArr = null;
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            int i4 = next[0];
            int i5 = next[1];
            if (i4 >= i2 * 1000 && i5 <= i3 * 1000) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            Log.i(f8649a, "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            Log.i(f8649a, "FPS range already set to " + Arrays.toString(iArr));
            return;
        }
        Log.i(f8649a, "Setting FPS range to " + Arrays.toString(iArr));
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    public static void k(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String e2 = z ? (z3 || z2) ? e("focus mode", supportedFocusModes, "auto") : e("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : null;
        if (!z3 && e2 == null) {
            e2 = e("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (e2 != null) {
            if (!e2.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(e2);
                return;
            }
            Log.i(f8649a, "Focus mode already set to " + e2);
        }
    }

    public static void l(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i(f8649a, "Device does not support focus areas");
            return;
        }
        Log.i(f8649a, "Old focus areas: " + r(parameters.getFocusAreas()));
        List<Camera.Area> a2 = a(400);
        Log.i(f8649a, "Setting focus area to : " + r(a2));
        parameters.setFocusAreas(a2);
    }

    public static void m(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i(f8649a, "Negative effect already set");
            return;
        }
        String e2 = e("color effect", parameters.getSupportedColorEffects(), "negative");
        if (e2 != null) {
            parameters.setColorEffect(e2);
        }
    }

    public static void n(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            Log.i(f8649a, "Device does not support metering areas");
            return;
        }
        Log.i(f8649a, "Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> a2 = a(400);
        Log.i(f8649a, "Setting metering area to : " + r(a2));
        parameters.setMeteringAreas(a2);
    }

    public static void o(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String e2 = z ? e("flash mode", supportedFlashModes, "torch", com.alipay.mobilesecuritysdk.constant.a.f5218i) : e("flash mode", supportedFlashModes, com.alipay.mobilesecuritysdk.constant.a.f5219j);
        if (e2 != null) {
            if (e2.equals(parameters.getFlashMode())) {
                Log.i(f8649a, "Flash mode already set to " + e2);
                return;
            }
            Log.i(f8649a, "Setting flash mode to " + e2);
            parameters.setFlashMode(e2);
        }
    }

    public static void p(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i(f8649a, "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i(f8649a, "Video stabilization already enabled");
        } else {
            Log.i(f8649a, "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void q(Camera.Parameters parameters, double d2) {
        if (!parameters.isZoomSupported()) {
            Log.i(f8649a, "Zoom is not supported");
            return;
        }
        Integer f2 = f(parameters, d2);
        if (f2 == null) {
            return;
        }
        if (parameters.getZoom() == f2.intValue()) {
            Log.i(f8649a, "Zoom is already set to " + f2);
            return;
        }
        Log.i(f8649a, "Setting zoom to " + f2);
        parameters.setZoom(f2.intValue());
    }

    private static String r(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    private static String s(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
