package com.tencent.a.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0005;
import com.google.gason.C0108;
import com.google.gason.Gson;
import com.google.gason.internal.C0104;
import com.google.gason.reflect.C0105;
import com.tencent.a.model.C0519;
import com.tencent.as.C0523;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: classes7.dex */
public class HttpUtils {

    /* renamed from: short */
    private static final short[] f125short;

    /* renamed from: com.tencent.a.utils.HttpUtils$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ImageCallback val$imageCallback;
        final /* synthetic */ String val$str;

        AnonymousClass1(String str, ImageCallback imageCallback) {
            str = str;
            imageCallback = imageCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Integer num = new Integer(3573717);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(((Integer) new Object[]{num}[0]).intValue() ^ 3575973);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                imageCallback.success(decodeStream);
            } catch (Exception e2) {
                e2.printStackTrace();
                imageCallback.failed();
            }
        }
    }

    /* renamed from: com.tencent.a.utils.HttpUtils$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: short */
        private static final short[] f126short;
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Map val$map;
        final /* synthetic */ String val$str;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(1399385)}[0]).intValue() ^ 1399296];
            sArr[0] = 3067;
            sArr[1] = 3047;
            sArr[2] = 3066;
            sArr[3] = 3040;
            sArr[4] = 2972;
            sArr[5] = 2971;
            sArr[6] = 3042;
            sArr[7] = 3043;
            sArr[8] = 3067;
            sArr[9] = 3071;
            sArr[10] = 3053;
            sArr[11] = 2970;
            sArr[12] = 2973;
            sArr[13] = 2968;
            sArr[14] = 3047;
            sArr[15] = 3043;
            sArr[16] = 1319;
            sArr[17] = 1314;
            sArr[18] = 1335;
            sArr[19] = 1314;
            sArr[20] = 1406;
            sArr[21] = 780;
            sArr[22] = 781;
            sArr[23] = 799;
            sArr[24] = 852;
            sArr[25] = 833;
            sArr[26] = 2289;
            sArr[27] = 2286;
            sArr[28] = 2290;
            sArr[29] = 2293;
            sArr[30] = 3089;
            sArr[31] = 3133;
            sArr[32] = 3132;
            sArr[33] = 3110;
            sArr[34] = 3127;
            sArr[35] = 3132;
            sArr[36] = 3110;
            sArr[37] = 3199;
            sArr[38] = 3078;
            sArr[39] = 3115;
            sArr[40] = 3106;
            sArr[41] = 3127;
            sArr[42] = 878;
            sArr[43] = 895;
            sArr[44] = 895;
            sArr[45] = 867;
            sArr[46] = 870;
            sArr[47] = 876;
            sArr[48] = 878;
            sArr[49] = 891;
            sArr[50] = 870;
            sArr[51] = 864;
            sArr[52] = 865;
            sArr[53] = 800;
            sArr[54] = 887;
            sArr[55] = 802;
            sArr[56] = 888;
            sArr[57] = 888;
            sArr[58] = 888;
            sArr[59] = 802;
            sArr[60] = 873;
            sArr[61] = 864;
            sArr[62] = 893;
            sArr[63] = 866;
            sArr[64] = 802;
            sArr[65] = 890;
            sArr[66] = 893;
            sArr[67] = 867;
            sArr[68] = 874;
            sArr[69] = 865;
            sArr[70] = 876;
            sArr[71] = 864;
            sArr[72] = 875;
            sArr[73] = 874;
            sArr[74] = 875;
            sArr[75] = 1883;
            sArr[76] = 1911;
            sArr[77] = 1910;
            sArr[78] = 1900;
            sArr[79] = 1917;
            sArr[80] = 1910;
            sArr[81] = 1900;
            sArr[82] = 1845;
            sArr[83] = 1876;
            sArr[84] = 1917;
            sArr[85] = 1910;
            sArr[86] = 1919;
            sArr[87] = 1900;
            sArr[88] = 1904;
            f126short = sArr;
        }

        AnonymousClass2(Map map, String str, Callback callback) {
            map = map;
            str = str;
            callback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Integer num = new Integer(5941136);
            try {
                byte[] bytes = (C0104.m40(f126short, 1755599 ^ C0008.m27((Object) "ۨۨ۟"), 1746789 ^ C0008.m27((Object) "ۣ۟ۢ"), C0008.m27((Object) "۠ۤۨ") ^ 1748519) + URLEncoder.encode(CryptAES.AES_Encrypt(C0105.m44(f126short, 1749571 ^ C0008.m27((Object) "ۢ۟۠"), 1750701 ^ C0008.m27((Object) "ۣۥ۟"), C0008.m27((Object) "ۨۥۧ") ^ 1753636), new Gson().toJson(map)), C0001.m3(f126short, 1746774 ^ C0008.m27((Object) "۟ۡۥ"), 1749855 ^ C0008.m27((Object) "ۢۨ۠"), C0008.m27((Object) "۟ۤ۟") ^ 1746147))).getBytes();
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(((Integer) new Object[]{num}[0]).intValue() ^ 5942312);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(C0519.m65(f126short, 1747751 ^ C0008.m27((Object) "ۣ۠۠"), 1749752 ^ C0008.m27((Object) "ۢۥ۟"), C0008.m27((Object) "ۡۡ") ^ 54401));
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty(C0520.m66(f126short, 1753690 ^ C0008.m27((Object) "ۦۧۥ"), 1750771 ^ C0008.m27((Object) "ۣۣۧ"), C0008.m27((Object) "ۣۦۢ") ^ 1751693), C0523.m77(f126short, 1752682 ^ C0008.m27((Object) "ۥۥ۠"), 1751533 ^ C0008.m27((Object) "ۤ۟ۧ"), C0008.m27((Object) "ۣۢۢ") ^ 1749420));
                httpURLConnection.setRequestProperty(C0008.m24(f126short, 1753706 ^ C0008.m27((Object) "ۦۦۡ"), 1749781 ^ C0008.m27((Object) "ۢۦ۟"), C0008.m27((Object) "ۡۨۤ") ^ 1747077), String.valueOf(bytes.length));
                httpURLConnection.getOutputStream().write(bytes);
                if (httpURLConnection.getResponseCode() == 200) {
                    callback.success(HttpUtils.dealResponseResult(httpURLConnection.getInputStream()));
                    return;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            callback.failed();
        }
    }

    public interface Callback {
        void failed();

        void success(String str);
    }

    public interface ImageCallback {
        void failed();

        void success(Bitmap bitmap);
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(7267505)}[0]).intValue() ^ 7267494];
        sArr[0] = 457;
        sArr[1] = 469;
        sArr[2] = 456;
        sArr[3] = 466;
        sArr[4] = 430;
        sArr[5] = 425;
        sArr[6] = 464;
        sArr[7] = 465;
        sArr[8] = 457;
        sArr[9] = 461;
        sArr[10] = 479;
        sArr[11] = 424;
        sArr[12] = 431;
        sArr[13] = 426;
        sArr[14] = 469;
        sArr[15] = 465;
        sArr[16] = 976;
        sArr[17] = 1410;
        sArr[18] = 1411;
        sArr[19] = 1425;
        sArr[20] = 1498;
        sArr[21] = 1487;
        sArr[22] = 1328;
        f125short = sArr;
    }

    public static String dealResponseResult(InputStream inputStream) {
        int read;
        Integer num = new Integer(4004646);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) new Object[]{num}[0]).intValue() ^ 4005670];
        while (true) {
            try {
                read = inputStream.read(bArr);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (read == -1) {
                return CryptAES.AES_Decrypt(C0108.m52(f125short, 1749788 ^ C0008.m27((Object) "ۢۦ۠"), 1750556 ^ C0008.m27((Object) "ۣ۟ۨ"), C0008.m27((Object) "ۧۢۨ") ^ 1754353), new String(byteArrayOutputStream.toByteArray()));
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static StringBuffer getRequestData(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append(C0005.m17(f125short, 1747821 ^ C0008.m27((Object) "۠ۥۢ"), 1751708 ^ C0008.m27((Object) "ۤۦ۟"), C0008.m27((Object) "۟ۦۥ") ^ 1745971));
                stringBuffer.append(URLEncoder.encode(entry.getValue(), C0523.m77(f125short, 1746833 ^ C0008.m27((Object) "ۣ۟ۤ"), 1746785 ^ C0008.m27((Object) "۟ۢۧ"), C0008.m27((Object) "۟ۧۢ") ^ 1745421)));
                stringBuffer.append(C0003.m11(f125short, 56343 ^ C0008.m27((Object) "۠ۡ"), 56421 ^ C0008.m27((Object) "ۣۧ"), C0008.m27((Object) "۠۠ۥ") ^ 1748979));
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return stringBuffer;
    }

    public static void getURLimage(String str, ImageCallback imageCallback) {
        new Thread(new Runnable() { // from class: com.tencent.a.utils.HttpUtils.1
            final /* synthetic */ ImageCallback val$imageCallback;
            final /* synthetic */ String val$str;

            AnonymousClass1(String str2, ImageCallback imageCallback2) {
                str = str2;
                imageCallback = imageCallback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Integer num = new Integer(3573717);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(((Integer) new Object[]{num}[0]).intValue() ^ 3575973);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    imageCallback.success(decodeStream);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    imageCallback.failed();
                }
            }
        }).start();
    }

    public static void submitPostData(String str, Map<String, String> map, Callback callback) {
        new Thread(new Runnable() { // from class: com.tencent.a.utils.HttpUtils.2

            /* renamed from: short */
            private static final short[] f126short;
            final /* synthetic */ Callback val$callback;
            final /* synthetic */ Map val$map;
            final /* synthetic */ String val$str;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(1399385)}[0]).intValue() ^ 1399296];
                sArr[0] = 3067;
                sArr[1] = 3047;
                sArr[2] = 3066;
                sArr[3] = 3040;
                sArr[4] = 2972;
                sArr[5] = 2971;
                sArr[6] = 3042;
                sArr[7] = 3043;
                sArr[8] = 3067;
                sArr[9] = 3071;
                sArr[10] = 3053;
                sArr[11] = 2970;
                sArr[12] = 2973;
                sArr[13] = 2968;
                sArr[14] = 3047;
                sArr[15] = 3043;
                sArr[16] = 1319;
                sArr[17] = 1314;
                sArr[18] = 1335;
                sArr[19] = 1314;
                sArr[20] = 1406;
                sArr[21] = 780;
                sArr[22] = 781;
                sArr[23] = 799;
                sArr[24] = 852;
                sArr[25] = 833;
                sArr[26] = 2289;
                sArr[27] = 2286;
                sArr[28] = 2290;
                sArr[29] = 2293;
                sArr[30] = 3089;
                sArr[31] = 3133;
                sArr[32] = 3132;
                sArr[33] = 3110;
                sArr[34] = 3127;
                sArr[35] = 3132;
                sArr[36] = 3110;
                sArr[37] = 3199;
                sArr[38] = 3078;
                sArr[39] = 3115;
                sArr[40] = 3106;
                sArr[41] = 3127;
                sArr[42] = 878;
                sArr[43] = 895;
                sArr[44] = 895;
                sArr[45] = 867;
                sArr[46] = 870;
                sArr[47] = 876;
                sArr[48] = 878;
                sArr[49] = 891;
                sArr[50] = 870;
                sArr[51] = 864;
                sArr[52] = 865;
                sArr[53] = 800;
                sArr[54] = 887;
                sArr[55] = 802;
                sArr[56] = 888;
                sArr[57] = 888;
                sArr[58] = 888;
                sArr[59] = 802;
                sArr[60] = 873;
                sArr[61] = 864;
                sArr[62] = 893;
                sArr[63] = 866;
                sArr[64] = 802;
                sArr[65] = 890;
                sArr[66] = 893;
                sArr[67] = 867;
                sArr[68] = 874;
                sArr[69] = 865;
                sArr[70] = 876;
                sArr[71] = 864;
                sArr[72] = 875;
                sArr[73] = 874;
                sArr[74] = 875;
                sArr[75] = 1883;
                sArr[76] = 1911;
                sArr[77] = 1910;
                sArr[78] = 1900;
                sArr[79] = 1917;
                sArr[80] = 1910;
                sArr[81] = 1900;
                sArr[82] = 1845;
                sArr[83] = 1876;
                sArr[84] = 1917;
                sArr[85] = 1910;
                sArr[86] = 1919;
                sArr[87] = 1900;
                sArr[88] = 1904;
                f126short = sArr;
            }

            AnonymousClass2(Map map2, String str2, Callback callback2) {
                map = map2;
                str = str2;
                callback = callback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Integer num = new Integer(5941136);
                try {
                    byte[] bytes = (C0104.m40(f126short, 1755599 ^ C0008.m27((Object) "ۨۨ۟"), 1746789 ^ C0008.m27((Object) "ۣ۟ۢ"), C0008.m27((Object) "۠ۤۨ") ^ 1748519) + URLEncoder.encode(CryptAES.AES_Encrypt(C0105.m44(f126short, 1749571 ^ C0008.m27((Object) "ۢ۟۠"), 1750701 ^ C0008.m27((Object) "ۣۥ۟"), C0008.m27((Object) "ۨۥۧ") ^ 1753636), new Gson().toJson(map)), C0001.m3(f126short, 1746774 ^ C0008.m27((Object) "۟ۡۥ"), 1749855 ^ C0008.m27((Object) "ۢۨ۠"), C0008.m27((Object) "۟ۤ۟") ^ 1746147))).getBytes();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(((Integer) new Object[]{num}[0]).intValue() ^ 5942312);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(C0519.m65(f126short, 1747751 ^ C0008.m27((Object) "ۣ۠۠"), 1749752 ^ C0008.m27((Object) "ۢۥ۟"), C0008.m27((Object) "ۡۡ") ^ 54401));
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty(C0520.m66(f126short, 1753690 ^ C0008.m27((Object) "ۦۧۥ"), 1750771 ^ C0008.m27((Object) "ۣۣۧ"), C0008.m27((Object) "ۣۦۢ") ^ 1751693), C0523.m77(f126short, 1752682 ^ C0008.m27((Object) "ۥۥ۠"), 1751533 ^ C0008.m27((Object) "ۤ۟ۧ"), C0008.m27((Object) "ۣۢۢ") ^ 1749420));
                    httpURLConnection.setRequestProperty(C0008.m24(f126short, 1753706 ^ C0008.m27((Object) "ۦۦۡ"), 1749781 ^ C0008.m27((Object) "ۢۦ۟"), C0008.m27((Object) "ۡۨۤ") ^ 1747077), String.valueOf(bytes.length));
                    httpURLConnection.getOutputStream().write(bytes);
                    if (httpURLConnection.getResponseCode() == 200) {
                        callback.success(HttpUtils.dealResponseResult(httpURLConnection.getInputStream()));
                        return;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                callback.failed();
            }
        }).start();
    }
}
