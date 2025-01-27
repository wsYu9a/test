package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.util.Log;
import com.google.gason.C0107;
import com.google.gason.internal.C0104;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes7.dex */
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX;
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f11short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(6146341)}[0]).intValue() ^ 6146427];
        sArr[0] = 2569;
        sArr[1] = 2625;
        sArr[2] = 2632;
        sArr[3] = 2633;
        sArr[4] = 2643;
        sArr[5] = 2345;
        sArr[6] = 2308;
        sArr[7] = 2317;
        sArr[8] = 2328;
        sArr[9] = 2331;
        sArr[10] = 2332;
        sArr[11] = 2334;
        sArr[12] = 2328;
        sArr[13] = 2366;
        sArr[14] = 2322;
        sArr[15] = 2320;
        sArr[16] = 2317;
        sArr[17] = 2332;
        sArr[18] = 2313;
        sArr[19] = 2344;
        sArr[20] = 2313;
        sArr[21] = 2324;
        sArr[22] = 2321;
        sArr[23] = 2015;
        sArr[24] = 2034;
        sArr[25] = 2043;
        sArr[26] = 2030;
        sArr[27] = 2029;
        sArr[28] = 2026;
        sArr[29] = 2024;
        sArr[30] = 2030;
        sArr[31] = 1992;
        sArr[32] = 2020;
        sArr[33] = 2022;
        sArr[34] = 2043;
        sArr[35] = 2026;
        sArr[36] = 2047;
        sArr[37] = 2014;
        sArr[38] = 2047;
        sArr[39] = 2018;
        sArr[40] = 2023;
        sArr[41] = 3271;
        sArr[42] = 3312;
        sArr[43] = 3312;
        sArr[44] = 3309;
        sArr[45] = 3312;
        sArr[46] = 3234;
        sArr[47] = 3297;
        sArr[48] = 3309;
        sArr[49] = 3314;
        sArr[50] = 3323;
        sArr[51] = 3307;
        sArr[52] = 3308;
        sArr[53] = 3301;
        sArr[54] = 3234;
        sArr[55] = 3312;
        sArr[56] = 3303;
        sArr[57] = 3313;
        sArr[58] = 3309;
        sArr[59] = 3319;
        sArr[60] = 3312;
        sArr[61] = 3297;
        sArr[62] = 3303;
        sArr[63] = 3234;
        sArr[64] = 3297;
        sArr[65] = 3309;
        sArr[66] = 3308;
        sArr[67] = 3318;
        sArr[68] = 3303;
        sArr[69] = 3308;
        sArr[70] = 3318;
        sArr[71] = 3313;
        sArr[72] = 3234;
        sArr[73] = 3318;
        sArr[74] = 3309;
        sArr[75] = 3234;
        sArr[76] = 3318;
        sArr[77] = 3303;
        sArr[78] = 3311;
        sArr[79] = 3314;
        sArr[80] = 3234;
        sArr[81] = 3300;
        sArr[82] = 3307;
        sArr[83] = 3310;
        sArr[84] = 3303;
        sArr[85] = 3256;
        sArr[86] = 3234;
        sArr[87] = 341;
        sArr[88] = 285;
        sArr[89] = 276;
        sArr[90] = 277;
        sArr[91] = 271;
        sArr[92] = 2021;
        sArr[93] = 1740;
        f11short = sArr;
        CACHE_FILE_PREFIX = C0104.m40(f11short, 1749638 ^ C0008.m27((Object) "ۢۡۥ"), 1747870 ^ C0008.m27((Object) "۠ۦۡ"), C0008.m27((Object) "ۥۧ۠") ^ 1750105);
        TAG = C0003.m11(f11short, 1752448 ^ C0008.m27((Object) "ۥ۟۟"), 1755423 ^ C0008.m27((Object) "ۨۡۦ"), C0008.m27((Object) "ۦ۠ۢ") ^ 1755157);
    }

    private TypefaceCompatUtil() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    public static ByteBuffer copyToDirectBuffer(Context context, Resources resources, int i2) {
        File tempFile = getTempFile(context);
        if (tempFile != null) {
            try {
                r0 = copyToFile(tempFile, resources, i2) ? mmap(tempFile) : null;
            } finally {
                tempFile.delete();
            }
        }
        return r0;
    }

    public static boolean copyToFile(File file, Resources resources, int i2) {
        InputStream inputStream = null;
        try {
            inputStream = resources.openRawResource(i2);
            return copyToFile(file, inputStream);
        } finally {
            closeQuietly(inputStream);
        }
    }

    public static boolean copyToFile(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Integer num = new Integer(8486945);
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            fileOutputStream2 = new FileOutputStream(file, false);
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[((Integer) new Object[]{num}[0]).intValue() ^ 8487969];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    closeQuietly(fileOutputStream2);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
                fileOutputStream2.write(bArr, 0, read);
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = fileOutputStream2;
            try {
                Log.e(C0004.m13(f11short, 1749617 ^ C0008.m27((Object) "ۢ۠ۤ"), 1754491 ^ C0008.m27((Object) "ۧۢۤ"), C0008.m27((Object) "ۣ۟ۨ") ^ 1749383), C0000.m1(f11short, 1753654 ^ C0008.m27((Object) "ۦۦ۟"), 1749644 ^ C0008.m27((Object) "ۢۢۢ"), C0008.m27((Object) "ۣۣۣ") ^ 1751553) + e.getMessage());
                closeQuietly(fileOutputStream);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                return false;
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileOutputStream);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = fileOutputStream2;
            closeQuietly(fileOutputStream);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static File getTempFile(Context context) {
        StringBuilder append = new StringBuilder().append(C0008.m24(f11short, 1747635 ^ C0008.m27((Object) "۠۠ۤ"), 1751751 ^ C0008.m27((Object) "ۤۧۥ"), C0008.m27((Object) "ۨۥۥ") ^ 1755379)).append(Process.myPid());
        String m11 = C0003.m11(f11short, 1748639 ^ C0008.m27((Object) "ۣۡۡ"), 1753607 ^ C0008.m27((Object) "ۦۥۥ"), C0008.m27((Object) "ۣ۠ۢ") ^ 1749485);
        String sb = append.append(m11).append(Process.myTid()).append(m11).toString();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 100) {
                return null;
            }
            File file = new File(context.getCacheDir(), sb + i3);
            if (file.createNewFile()) {
                return file;
            }
            i2 = i3 + 1;
        }
    }

    public static ByteBuffer mmap(Context context, CancellationSignal cancellationSignal, Uri uri) {
        Long l = new Long(1891087L);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, C0107.m50(f11short, 1753603 ^ C0008.m27((Object) "ۦۨ۠"), 1747841 ^ C0008.m27((Object) "۠ۥۥ"), C0008.m27((Object) "ۧۥۤ") ^ 1753976), cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, ((Long) new Object[]{l}[0]).longValue() ^ 1891087, channel.size());
                    fileInputStream.close();
                    if (openFileDescriptor == null) {
                        return map;
                    }
                    openFileDescriptor.close();
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            return null;
        }
    }

    private static ByteBuffer mmap(File file) {
        Long l = new Long(2631890L);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, ((Long) new Object[]{l}[0]).longValue() ^ 2631890, channel.size());
                fileInputStream.close();
                return map;
            } finally {
            }
        } catch (IOException e2) {
            return null;
        }
    }
}
