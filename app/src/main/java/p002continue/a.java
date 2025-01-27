package p002continue;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import bh.a0;
import bh.d;
import bh.h;
import bh.k;
import bh.w;
import com.kuaishou.weapon.p0.t;
import com.snassdk.sdk.wrapper.Wrapper;
import com.sntech.net.DomainProvider;
import h3.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kh.b;
import m5.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002continue.f;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: continue.a$a */
    public static class C0682a {
        public static byte[] a(Context context, String str) {
            if (str != null && str.length() > 22 && str.startsWith("file:///android_asset")) {
                InputStream open = context.getAssets().open(str.substring(22));
                try {
                    byte[] b10 = k.b(open);
                    open.close();
                    return b10;
                } catch (Throwable th2) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new IOException("Http ResponseCode:" + responseCode);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                byte[] b11 = k.b(inputStream);
                inputStream.close();
                return b11;
            } catch (Throwable th4) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                }
                throw th4;
            }
        }

        public static byte[] b(Context context, String str, JSONObject jSONObject) {
            if (str != null && str.length() > 22 && str.startsWith("file:///android_asset")) {
                InputStream open = context.getAssets().open(str.substring(22));
                try {
                    byte[] b10 = k.b(open);
                    byte[] bytes = "x04VOtkJji86dsmn".getBytes();
                    byte[] bytes2 = "x04VOtkJji86dsmn".getBytes();
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(1, secretKeySpec, new IvParameterSpec(bytes2));
                    byte[] encode = Base64.encode(cipher.doFinal(b10), 0);
                    open.close();
                    return encode;
                } catch (Throwable th2) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty(c.f28293b0, "gzip");
            httpURLConnection.setRequestProperty(c.f28316j, "gzip");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            byte[] bytes3 = jSONObject.toString().getBytes();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes3);
                gZIPOutputStream.close();
                outputStream.write(byteArrayOutputStream.toByteArray());
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    throw new IOException("Http ResponseCode:" + responseCode);
                }
                InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getContentEncoding()) ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream();
                try {
                    byte[] b11 = k.b(gZIPInputStream);
                    gZIPInputStream.close();
                    return b11;
                } catch (Throwable th4) {
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                        }
                    }
                    throw th4;
                }
            } catch (Throwable th6) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th7) {
                    th6.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList, java.util.List<java.lang.String>] */
    public static h<Cimport> a(Context context, Cimport cimport, File file) {
        try {
            a0.u(file.getParentFile());
            a0.s(file);
            a0.i(file, cimport.m51do(C0682a.a(context, cimport.f27if)));
            a0.h(cimport, file, w.b(file.getPath()));
            if (cimport.f29this.size() <= 0) {
                if (d.f(file)) {
                }
                cimport.m52if(a0.e(context, cimport.f23do, String.valueOf(cimport.f22case), true));
                return new h<>(file.getPath(), cimport.f25for, cimport);
            }
            if (!((Boolean) ((AbstractMap.SimpleEntry) d.h(file)).getKey()).booleanValue()) {
                throw new IOException("verify fail: native lib not match host abi");
            }
            d.b(cimport, file, file.getParentFile());
            cimport.m52if(a0.e(context, cimport.f23do, String.valueOf(cimport.f22case), true));
            return new h<>(file.getPath(), cimport.f25for, cimport);
        } catch (Throwable th2) {
            a0.s(file);
            a0.s(a0.e(context, cimport.f23do, String.valueOf(cimport.f22case), false));
            throw th2;
        }
    }

    public static Cnative b(Context context) {
        JSONObject e10 = mj.k.e(context);
        e10.put("sdk_version", 53000);
        Collection<h> i10 = f.b.f25213a.i();
        JSONArray jSONArray = new JSONArray();
        Iterator it = ((ArrayList) i10).iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", hVar.f1621e);
            jSONObject.put("version", hVar.f1622f);
            jSONArray.put(jSONObject);
        }
        e10.put("loaded_plugin_versions", jSONArray);
        e10.put("plugin_api", 2);
        e10.put("wrapper_plugin", 1);
        e10.put("wrapper_support", Wrapper.isContextWrapped(context) ? 1 : 0);
        try {
            e10.put("package_version", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        JSONObject b10 = b.b(e10);
        String string = b10.getString(t.f11211k);
        String a10 = b.a(new String(C0682a.b(context, DomainProvider.baseUrl() + "nd", b10), "UTF-8"));
        JSONObject jSONObject2 = new JSONObject(a10);
        JSONObject optJSONObject = jSONObject2.optJSONObject(e.f26408m);
        if (jSONObject2.optInt("code", -1) != 0 || optJSONObject == null || (!string.equals(jSONObject2.optString(t.f11211k)) && !yk.b.a())) {
            throw new RuntimeException("Illegal Response");
        }
        try {
            return Cnative.m53do(new JSONObject(a10));
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }
}
