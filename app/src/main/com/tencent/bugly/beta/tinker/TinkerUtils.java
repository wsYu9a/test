package com.tencent.bugly.beta.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.Signature;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.an;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Formatter;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes4.dex */
public class TinkerUtils {
    public static final int ERROR_PATCH_CONDITION_NOT_SATISFIED = -24;
    public static final int ERROR_PATCH_CRASH_LIMIT = -23;
    public static final int ERROR_PATCH_GOOGLEPLAY_CHANNEL = -20;
    public static final int ERROR_PATCH_MEMORY_LIMIT = -22;
    public static final int ERROR_PATCH_ROM_SPACE = -21;
    public static final int MIN_MEMORY_HEAP_SIZE = 45;
    public static final String PLATFORM = "platform";
    private static final String TAG = "Tinker.TinkerUtils";
    private static boolean background = false;

    public static class ScreenState {

        /* renamed from: com.tencent.bugly.beta.tinker.TinkerUtils$ScreenState$1 */
        public class AnonymousClass1 extends BroadcastReceiver {
            final /* synthetic */ IOnScreenOff val$onScreenOffInterface;

            public AnonymousClass1(IOnScreenOff iOnScreenOff) {
                iOnScreenOff = iOnScreenOff;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent == null ? "" : intent.getAction();
                TinkerLog.i(TinkerUtils.TAG, "ScreenReceiver action [%s] ", new Object[]{action});
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    IOnScreenOff iOnScreenOff = iOnScreenOff;
                    if (iOnScreenOff != null) {
                        iOnScreenOff.onScreenOff();
                    }
                    context.unregisterReceiver(this);
                }
            }
        }

        public interface IOnScreenOff {
            void onScreenOff();
        }

        public ScreenState(Context context, IOnScreenOff iOnScreenOff) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.bugly.beta.tinker.TinkerUtils.ScreenState.1
                final /* synthetic */ IOnScreenOff val$onScreenOffInterface;

                public AnonymousClass1(IOnScreenOff iOnScreenOff2) {
                    iOnScreenOff = iOnScreenOff2;
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    String action = intent == null ? "" : intent.getAction();
                    TinkerLog.i(TinkerUtils.TAG, "ScreenReceiver action [%s] ", new Object[]{action});
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        IOnScreenOff iOnScreenOff2 = iOnScreenOff;
                        if (iOnScreenOff2 != null) {
                            iOnScreenOff2.onScreenOff();
                        }
                        context2.unregisterReceiver(this);
                    }
                }
            }, intentFilter);
        }
    }

    public static String bytesToHexString(byte[] bArr, boolean z10) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        Formatter formatter = new Formatter(stringBuffer);
        for (byte b10 : bArr) {
            formatter.format("%02x", Byte.valueOf(b10));
        }
        formatter.close();
        return z10 ? stringBuffer.toString().toUpperCase() : stringBuffer.toString().toLowerCase();
    }

    public static int checkForPatchRecover(long j10, int i10) {
        if (isGooglePlay()) {
            return -20;
        }
        if (i10 < 45) {
            return -22;
        }
        return !checkRomSpaceEnough(j10) ? -21 : 0;
    }

    @Deprecated
    public static boolean checkRomSpaceEnough(long j10) {
        long j11;
        long j12;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j11 = statFs.getAvailableBlocks() * statFs.getBlockSize();
            try {
                j12 = statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Exception unused) {
                j12 = 0;
                return j12 == 0 ? false : false;
            }
        } catch (Exception unused2) {
            j11 = 0;
        }
        if (j12 == 0 && j11 > j10) {
            return true;
        }
    }

    public static boolean copy(File file, File file2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            String absolutePath = file2.getAbsolutePath();
            File file3 = new File(absolutePath.substring(0, absolutePath.lastIndexOf(File.separator)));
            if (!file3.exists()) {
                file3.mkdirs();
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[5120];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream2.write(bArr, 0, read);
            }
            bufferedOutputStream2.flush();
            try {
                bufferedInputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            try {
                bufferedOutputStream2.close();
                return true;
            } catch (IOException e11) {
                e11.printStackTrace();
                return true;
            }
        } catch (Throwable th4) {
            bufferedInputStream2 = bufferedInputStream;
            bufferedOutputStream = bufferedOutputStream2;
            th = th4;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            if (bufferedOutputStream == null) {
                throw th;
            }
            try {
                bufferedOutputStream.close();
                throw th;
            } catch (IOException e13) {
                e13.printStackTrace();
                throw th;
            }
        }
    }

    public static String getExceptionCauseString(Throwable th2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th2 != null) {
            try {
                if (th2.getCause() == null) {
                    break;
                }
                th2 = th2.getCause();
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
                throw th3;
            }
        }
        if (th2 != null) {
            th2.printStackTrace(printStream);
        }
        String visualString = toVisualString(byteArrayOutputStream.toString());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return visualString;
    }

    public static String getSignature(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
                MessageDigest.getInstance("SHA-1");
                return new String(x509Certificate.getEncoded());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return "";
    }

    public static boolean isBackground() {
        return background;
    }

    public static boolean isGooglePlay() {
        return false;
    }

    public static boolean isXposedExists(Throwable th2) {
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (className != null && className.contains(an.f10772b)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] readBytes(InputStream inputStream) {
        try {
            byte[] bArr = new byte[512];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static byte[] readJarEntry(File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && !TextUtils.isEmpty(str)) {
                    return readJarEntry(new JarFile(file), str);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static void rollbackPatch(Context context) {
        Tinker.with(context).rollbackPatch();
    }

    public static void setBackground(boolean z10) {
        background = z10;
    }

    private static String toVisualString(String str) {
        char[] charArray;
        if (str == null || (charArray = str.toCharArray()) == null) {
            return null;
        }
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (charArray[i10] > 127) {
                charArray[i10] = 0;
                return new String(charArray, 0, i10);
            }
        }
        return str;
    }

    public static byte[] readJarEntry(JarFile jarFile, String str) {
        if (jarFile != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return readJarEntry(jarFile, jarFile.getJarEntry(str));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] readJarEntry(JarFile jarFile, JarEntry jarEntry) {
        if (jarFile != null && jarEntry != null) {
            try {
                return readBytes(jarFile.getInputStream(jarEntry));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }
}
