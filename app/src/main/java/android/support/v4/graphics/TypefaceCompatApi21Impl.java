package android.support.v4.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0007;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes7.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f6short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(9673444)}[0]).intValue() ^ 9673410];
        sArr[0] = 265;
        sArr[1] = 292;
        sArr[2] = 301;
        sArr[3] = 312;
        sArr[4] = 315;
        sArr[5] = 316;
        sArr[6] = 318;
        sArr[7] = 312;
        sArr[8] = 286;
        sArr[9] = 306;
        sArr[10] = 304;
        sArr[11] = 301;
        sArr[12] = 316;
        sArr[13] = 297;
        sArr[14] = 284;
        sArr[15] = 301;
        sArr[16] = 308;
        sArr[17] = 367;
        sArr[18] = 364;
        sArr[19] = 276;
        sArr[20] = 304;
        sArr[21] = 301;
        sArr[22] = 305;
        sArr[23] = 2209;
        sArr[24] = 2302;
        sArr[25] = 2300;
        sArr[26] = 2273;
        sArr[27] = 2285;
        sArr[28] = 2209;
        sArr[29] = 2301;
        sArr[30] = 2283;
        sArr[31] = 2274;
        sArr[32] = 2280;
        sArr[33] = 2209;
        sArr[34] = 2280;
        sArr[35] = 2282;
        sArr[36] = 2209;
        sArr[37] = 940;
        f6short = sArr;
        TAG = C0007.m23(f6short, 1750569 ^ C0008.m27((Object) "ۣ۠ۦ"), C0008.m27((Object) "۠") ^ 1783, C0008.m27((Object) "ۡ۠۟") ^ 1748989);
    }

    TypefaceCompatApi21Impl() {
    }

    private File getFile(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink(C0007.m23(f6short, 1750705 ^ C0008.m27((Object) "ۣۤۧ"), 1746829 ^ C0008.m27((Object) "ۣ۟ۧ"), C0008.m27((Object) "ۧۨۢ") ^ 1756847) + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException e2) {
            return null;
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        if (fontInfoArr.length < 1) {
            return null;
        }
        FontsContractCompat.FontInfo findBestInfo = findBestInfo(fontInfoArr, i2);
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(findBestInfo.getUri(), C0008.m24(f6short, 1748804 ^ C0008.m27((Object) "ۡۦۦ"), 1749821 ^ C0008.m27((Object) "ۢۧۡ"), C0008.m27((Object) "۠ۧۡ") ^ 1747044), cancellationSignal);
            try {
                File file = getFile(openFileDescriptor);
                if (file != null && file.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(file);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface createFromInputStream = super.createFromInputStream(context, fileInputStream);
                    fileInputStream.close();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return createFromInputStream;
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            return null;
        }
    }
}
