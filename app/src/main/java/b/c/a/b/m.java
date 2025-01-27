package b.c.a.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
class m {

    /* renamed from: a */
    private static String f4349a = "G0";

    m() {
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Exception e2) {
            b.a("idIOUtil:" + e2.getMessage());
            return "";
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    static String c(String str) {
        return new String(Base64.decode(str, 0));
    }

    static String d(File file) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        byte[] bytes = o(file).getBytes();
        int length = bytes.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            bytes[i2] = (byte) (bytes[i2] ^ i2);
        }
        return new String(Base64.decode(bytes, 0));
    }

    static boolean e(byte[] bArr, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] encode = Base64.encode(bArr, 0);
            int length = encode.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                encode[i2] = (byte) (encode[i2] ^ i2);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(encode);
                fileOutputStream2.flush();
                b(fileOutputStream2);
                return true;
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                b(fileOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String f(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
    }

    private static Object g(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return obj;
        }
        try {
            return jSONObject.get(str);
        } catch (JSONException unused) {
            return obj;
        }
    }

    static String h(String str, JSONObject jSONObject, String str2, String str3) {
        Object g2 = g(m(str, jSONObject), str2, str3);
        return g2 != null ? g2.toString() : str3;
    }

    private static boolean i(byte b2) {
        return (b2 >= 48 && b2 <= 57) || (b2 >= 97 && b2 <= 122) || (b2 >= 65 && b2 <= 90);
    }

    static boolean j(String str) {
        if (str == null) {
            return true;
        }
        return "".equals(str.trim());
    }

    public static boolean k(String str) {
        String f2 = f(str);
        if (f2 == null || f2.isEmpty()) {
            return false;
        }
        File file = new File(f2);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    private static Object l(String str, Object obj) {
        if (j(str)) {
            return obj;
        }
        try {
            return new JSONTokener(str).nextValue();
        } catch (JSONException unused) {
            return obj;
        }
    }

    private static JSONObject m(String str, JSONObject jSONObject) {
        Object l = l(str, jSONObject);
        return l instanceof JSONObject ? (JSONObject) l : jSONObject;
    }

    static String n(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return o(file);
        }
        return null;
    }

    private static String o(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str = null;
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    b(bufferedReader2);
                    throw th;
                }
            }
            str = sb.toString();
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        b(bufferedReader);
        return str;
    }

    @SuppressLint({"DefaultLocale"})
    static String p(String str) {
        if (j(str)) {
            return str;
        }
        byte[] bytes = str.getBytes();
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (!i(bytes[i2])) {
                bytes[i2] = (byte) 48;
            }
        }
        String b2 = j.b(Build.MODEL + new String(bytes));
        if (TextUtils.isEmpty(b2)) {
            b2 = "";
        }
        return f4349a + b2 + "," + a.a(b2.getBytes());
    }
}
