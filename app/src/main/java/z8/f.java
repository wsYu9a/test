package z8;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class f implements Handler.Callback {

    /* renamed from: b */
    public static final String f33710b = "EmulatorDetector";

    /* renamed from: c */
    public static int f33711c = -1;

    public static String a() {
        return "Build.PRODUCT: " + Build.PRODUCT + "\nBuild.MANUFACTURER: " + Build.MANUFACTURER + "\nBuild.BRAND: " + Build.BRAND + "\nBuild.DEVICE: " + Build.DEVICE + "\nBuild.MODEL: " + Build.MODEL + "\nBuild.HARDWARE: " + Build.HARDWARE + "\nBuild.FINGERPRINT: " + Build.FINGERPRINT + "\nBuild.TAGS: " + Build.TAGS + "\nGL_RENDERER: " + GLES20.glGetString(7937) + "\nGL_VENDOR: " + GLES20.glGetString(7936) + "\nGL_VERSION: " + GLES20.glGetString(7938) + "\nGL_EXTENSIONS: " + GLES20.glGetString(7939) + "\n";
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0191, code lost:
    
        if (r2.contains("Translator") != false) goto L258;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.f.b(android.content.Context):boolean");
    }

    public static boolean c(Context context) {
        String str = Build.PRODUCT;
        if (str.contains("sdk") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("Andy") || str.contains("Droid4X") || str.contains("nox") || str.contains("vbox86p")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        if (str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("nox") || str2.contains("TiantianVM") || Build.BRAND.contains("Andy")) {
            return true;
        }
        String str3 = Build.DEVICE;
        if (str3.contains("Andy") || str3.contains("Droid4X") || str3.contains("nox") || str3.contains("vbox86p")) {
            return true;
        }
        String str4 = Build.MODEL;
        if (str4.contains("Emulator") || str4.equals("google_sdk") || str4.contains("Droid4X") || str4.contains("TiantianVM") || str4.contains("Andy") || str4.equals("Android SDK built for x86_64") || str4.equals("Android SDK built for x86")) {
            return true;
        }
        String str5 = Build.HARDWARE;
        if (str5.equals("vbox86") || str5.contains("nox") || str5.contains("ttVM_x86")) {
            return true;
        }
        String str6 = Build.FINGERPRINT;
        return str6.contains("generic/sdk/generic") || str6.contains("generic_x86/sdk_x86/generic_x86") || str6.contains("Andy") || str6.contains("ttVM_Hdragon") || str6.contains("generic/google_sdk/generic") || str6.contains("vbox86p") || str6.contains("generic/vbox86p/vbox86p");
    }

    public static void d() {
        Log.d(f33710b, a());
    }
}
