package com.tencent.a.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.C0008;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gason.internal.C0104;
import com.tencent.as.C0523;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class AssetsViewHelper {
    private static String assetsFile;
    private static AssetsViewHelper assetsViewHelper;
    private static Context mcontext;

    /* renamed from: short */
    private static final short[] f123short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(2628771)}[0]).intValue() ^ 2628789];
        sArr[0] = 1628;
        sArr[1] = 1614;
        sArr[2] = 1614;
        sArr[3] = 1624;
        sArr[4] = 1609;
        sArr[5] = 1614;
        sArr[6] = 1554;
        sArr[7] = 1718;
        sArr[8] = 1723;
        sArr[9] = 1699;
        sArr[10] = 1717;
        sArr[11] = 1711;
        sArr[12] = 1710;
        sArr[13] = 1669;
        sArr[14] = 1715;
        sArr[15] = 1716;
        sArr[16] = 1724;
        sArr[17] = 1718;
        sArr[18] = 1723;
        sArr[19] = 1710;
        sArr[20] = 1727;
        sArr[21] = 1704;
        f123short = sArr;
        assetsFile = C0104.m40(f123short, 1746943 ^ C0008.m27((Object) "۟ۧۧ"), 56443 ^ C0008.m27((Object) "ۤ۠"), C0008.m27((Object) "ۣۡۨ") ^ 1747259);
    }

    private AssetsViewHelper() {
    }

    public static AssetsViewHelper width(Context context) {
        mcontext = context.getApplicationContext();
        if (assetsViewHelper == null) {
            synchronized (AssetsViewHelper.class) {
                try {
                    if (assetsViewHelper == null) {
                        assetsViewHelper = new AssetsViewHelper();
                    }
                } catch (Throwable th) {
                }
                try {
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return assetsViewHelper;
    }

    public View getAssetsLayout(String str) {
        try {
            return ((LayoutInflater) mcontext.getSystemService(C0523.m77(f123short, 1752612 ^ C0008.m27((Object) "ۥۤۢ"), 1752690 ^ C0008.m27((Object) "ۥۧ۟"), C0008.m27((Object) "ۦۣ") ^ 55911))).inflate(mcontext.getResources().getAssets().openXmlResourceParser(assetsFile + str), (ViewGroup) null);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Bitmap getImageFromAssetsFile(String str) {
        try {
            InputStream open = mcontext.getResources().getAssets().open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            try {
                open.close();
                return decodeStream;
            } catch (IOException e2) {
                e2.printStackTrace();
                return decodeStream;
            }
        } catch (IOException e3) {
            return null;
        }
    }

    public View getViewByTag(View view, Object obj) {
        return view.findViewWithTag(obj);
    }
}
