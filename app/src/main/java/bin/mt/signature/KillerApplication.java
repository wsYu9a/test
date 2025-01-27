package bin.mt.signature;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.collector.AppStatusRules;
import com.martian.mibook.a;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* loaded from: classes6.dex */
public class KillerApplication extends Application {
    public static final String URL = "https://github.com/L-JINBIN/ApkSignatureKillerEx";

    /* renamed from: bin.mt.signature.KillerApplication$1 */
    class AnonymousClass1 implements Parcelable.Creator<PackageInfo> {
        final /* synthetic */ Signature val$fakeSignature;
        final /* synthetic */ Parcelable.Creator val$originalCreator;
        final /* synthetic */ String val$packageName;

        AnonymousClass1(Parcelable.Creator creator, String str, Signature signature) {
            creator = creator;
            str = str;
            signature = signature;
        }

        @Override // android.os.Parcelable.Creator
        public PackageInfo createFromParcel(Parcel parcel) {
            Signature[] apkContentsSigners;
            PackageInfo packageInfo = (PackageInfo) creator.createFromParcel(parcel);
            if (packageInfo.packageName.equals(str)) {
                if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                    packageInfo.signatures[0] = signature;
                }
                if (Build.VERSION.SDK_INT >= 28 && packageInfo.signingInfo != null && (apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners()) != null && apkContentsSigners.length > 0) {
                    apkContentsSigners[0] = signature;
                }
            }
            return packageInfo;
        }

        @Override // android.os.Parcelable.Creator
        public PackageInfo[] newArray(int i2) {
            return (PackageInfo[]) creator.newArray(i2);
        }
    }

    static {
        killPM(a.f10755b, "MIIDeTCCAmGgAwIBAgIEcMPYEjANBgkqhkiG9w0BAQsFADBsMQ4wDAYDVQQGEwVDaGluYTEQMA4G\nA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzEQMA4GA1UEChMHTWFydGlhbjEQMA4GA1UE\nCxMHTWFydGlhbjESMBAGA1UEAxMJWmhlbmJvIFh1MCAXDTE0MDgyNDEwMzM1OFoYDzIwNjQwODEx\nMTAzMzU4WjBsMQ4wDAYDVQQGEwVDaGluYTEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVp\namluZzEQMA4GA1UEChMHTWFydGlhbjEQMA4GA1UECxMHTWFydGlhbjESMBAGA1UEAxMJWmhlbmJv\nIFh1MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlthIxHLvWXKs8dpWW7QXT7gU2MmD\nHb4i9z4N2Ef3HS7dcZF2q8BCuKWE2ZBjKGKI19Qzqv7NC+vwHsiJmZhQMDo1UQKWz1Ottm5+CkfU\npgAkLXjArK+RERlB1JkEzzmt2GUTZGLMK8rfIeW48ILlqB7iDAav18LELgi8c+BF6R9N4fHenGvf\nBo8bI60UJ5LII2gi3KNYPVDNcO7SNNhKiZ+fBNn3J7+oWBKqK/YlS9+ZBv7je6ITJTbK4RBYLKAm\nycWU8BM9mwZ4pfCw3AEPJPeGVHpkQbagqrOEjKa8qZfH3CqVgCaRvMvta7cGDRSYUBL78+vL0hqM\neVfXBIW9nwIDAQABoyEwHzAdBgNVHQ4EFgQUplrQOUJ1Q2nw6Q4HK9ORfu2vbgAwDQYJKoZIhvcN\nAQELBQADggEBAB5UCiQ/wDEf3RasE2K57oPhkQuZFyw2CYL3JNwiP19Nu+XfewqET4bzMex6nkzF\nsOgqDTlkR1Rud4A+zffXRqzXEio0BilEsqYliy9Ol2JWnPtscE/stMW7oq8UxTVUTLxPMr4PA8XQ\n2Ydv8y64qQy3KmUgiSgwHQ1jGYcMYn8sPFoLVq5STGE3mGjDy8szcGfA2ZU+qoUKX4WTIKnKrrQA\nySetqGNKpdjOpZX8Fi2W1kxJQavItrBhvR0Ddmy+cE8XxGFMQP232GwhrhKVI6Rrr8yHrhY17SHU\n3qr9cFazLIPg0AKOD6veaTeHUmbO9KfZTYb2SGWbCEa6aVg2EHw=\n");
        killOpen(a.f10755b);
    }

    private static Field findField(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e2) {
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls.equals(Object.class)) {
                    break;
                }
                try {
                    Field declaredField2 = cls.getDeclaredField(str);
                    declaredField2.setAccessible(true);
                    return declaredField2;
                } catch (NoSuchFieldException unused) {
                }
            }
            throw e2;
        }
    }

    private static String getApkPath(String str) {
        String str2;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
            do {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return null;
                    }
                    str2 = readLine.split("\\s+")[r1.length - 1];
                } finally {
                }
            } while (!isApkPath(str, str2));
            bufferedReader.close();
            return str2;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static File getDataFile(String str) {
        String name = Environment.getExternalStorageDirectory().getName();
        if (name.matches("\\d+")) {
            File file = new File("/data/user/" + name + "/" + str);
            if (file.canWrite()) {
                return file;
            }
        }
        return new File("/data/data/" + str);
    }

    private static native void hookApkPath(String str, String str2);

    private static boolean isApkPath(String str, String str2) {
        if (str2.startsWith("/") && str2.endsWith(".apk")) {
            String[] split = str2.substring(1).split("/", 6);
            int length = split.length;
            if (length == 4 || length == 5) {
                if (split[0].equals(MiConfigSingleton.t0) && split[1].equals("app") && split[length - 1].equals("base.apk")) {
                    return split[length - 2].startsWith(str);
                }
                if (split[0].equals("mnt") && split[1].equals("asec") && split[length - 1].equals("pkg.apk")) {
                    return split[length - 2].startsWith(str);
                }
            } else if (length == 3) {
                if (split[0].equals(MiConfigSingleton.t0) && split[1].equals("app")) {
                    return split[2].startsWith(str);
                }
            } else if (length == 6 && split[0].equals("mnt") && split[1].equals("expand") && split[3].equals("app") && split[5].equals("base.apk")) {
                return split[4].endsWith(str);
            }
        }
        return false;
    }

    private static void killOpen(String str) {
        try {
            System.loadLibrary("SignatureKiller");
            String apkPath = getApkPath(str);
            if (apkPath == null) {
                System.err.println("Get apk path failed");
                return;
            }
            File file = new File(apkPath);
            File file2 = new File(getDataFile(str), "origin.apk");
            try {
                ZipFile zipFile = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile.getEntry("assets/SignatureKiller/origin.apk");
                    if (entry == null) {
                        System.err.println("Entry not found: assets/SignatureKiller/origin.apk");
                        zipFile.close();
                        return;
                    }
                    if (!file2.exists() || file2.length() != entry.getSize()) {
                        InputStream inputStream = zipFile.getInputStream(entry);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                }
                                fileOutputStream.close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } finally {
                            }
                        } finally {
                        }
                    }
                    zipFile.close();
                    hookApkPath(file.getAbsolutePath(), file2.getAbsolutePath());
                } finally {
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Throwable unused) {
            System.err.println("Load SignatureKiller library failed");
        }
    }

    private static void killPM(String str, String str2) {
        try {
            findField(PackageInfo.class, "CREATOR").set(null, new Parcelable.Creator<PackageInfo>() { // from class: bin.mt.signature.KillerApplication.1
                final /* synthetic */ Signature val$fakeSignature;
                final /* synthetic */ Parcelable.Creator val$originalCreator;
                final /* synthetic */ String val$packageName;

                AnonymousClass1(Parcelable.Creator creator, String str3, Signature signature) {
                    creator = creator;
                    str = str3;
                    signature = signature;
                }

                @Override // android.os.Parcelable.Creator
                public PackageInfo createFromParcel(Parcel parcel) {
                    Signature[] apkContentsSigners;
                    PackageInfo packageInfo = (PackageInfo) creator.createFromParcel(parcel);
                    if (packageInfo.packageName.equals(str)) {
                        if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                            packageInfo.signatures[0] = signature;
                        }
                        if (Build.VERSION.SDK_INT >= 28 && packageInfo.signingInfo != null && (apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners()) != null && apkContentsSigners.length > 0) {
                            apkContentsSigners[0] = signature;
                        }
                    }
                    return packageInfo;
                }

                @Override // android.os.Parcelable.Creator
                public PackageInfo[] newArray(int i2) {
                    return (PackageInfo[]) creator.newArray(i2);
                }
            });
            if (Build.VERSION.SDK_INT >= 28) {
                HiddenApiBypass.addHiddenApiExemptions("Landroid/os/Parcel;", "Landroid/content/pm", "Landroid/app");
            }
            try {
                Object obj = findField(PackageManager.class, "sPackageInfoCache").get(null);
                obj.getClass().getMethod("clear", new Class[0]).invoke(obj, new Object[0]);
            } catch (Throwable unused) {
            }
            try {
                ((Map) findField(Parcel.class, "mCreators").get(null)).clear();
            } catch (Throwable unused2) {
            }
            try {
                ((Map) findField(Parcel.class, "sPairedCreators").get(null)).clear();
            } catch (Throwable unused3) {
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
