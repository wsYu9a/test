package com.alipay.mobilesecuritysdk.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import b.d.b.f;
import com.baidu.mobads.sdk.internal.bu;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes.dex */
public class a {
    public static JSONObject a(String str) {
        return null;
    }

    public static boolean b() {
        String externalStorageState = Environment.getExternalStorageState();
        if (c(externalStorageState)) {
            return false;
        }
        return (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null;
    }

    public static boolean c(String str) {
        return str == null || str.length() <= 0;
    }

    public static String d(String str) {
        try {
            if (i(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 16; i2++) {
                sb.append(String.format("%02x", Byte.valueOf(digest[i2])));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String e(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public static void f(String str, String str2) throws IOException {
        FileWriter fileWriter;
        Throwable th;
        Exception e2;
        try {
            try {
                fileWriter = new FileWriter(new File(str), false);
            } catch (Exception e3) {
                fileWriter = null;
                e2 = e3;
            } catch (Throwable th2) {
                fileWriter = null;
                th = th2;
                fileWriter.close();
                throw th;
            }
            try {
                fileWriter.write(str2);
            } catch (Exception e4) {
                e2 = e4;
                Log.d("ConfigNameEnum.CONFIGS.getValue()", e2.getLocalizedMessage());
                fileWriter.close();
            }
            fileWriter.close();
        } catch (Throwable th3) {
            th = th3;
            fileWriter.close();
            throw th;
        }
    }

    public static String g(Date date) {
        return new SimpleDateFormat(f.f4407a).format(date);
    }

    public static boolean h(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static boolean i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return true;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean j(List<String> list) {
        if (list == null || list.size() <= 0) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!i(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public static boolean l(long j2, long j3, int i2) {
        return j3 <= 0 || (System.currentTimeMillis() - j2) / j3 >= ((long) i2);
    }

    public static int m(String str) {
        try {
            if (i(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long n(String str) {
        try {
            if (i(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String o(String str) {
        try {
            byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(str.length()).array();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("UTF-8"));
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] bArr = new byte[byteArrayOutputStream.toByteArray().length + 4];
            System.arraycopy(array, 0, bArr, 0, 4);
            System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, 4, byteArrayOutputStream.toByteArray().length);
            return Base64.encodeToString(bArr, 8);
        } catch (Exception e2) {
            Log.i(com.alipay.mobilesecuritysdk.constant.a.t, e2.getMessage());
            return "";
        }
    }
}
