package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.u;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p3.i;

/* loaded from: classes3.dex */
public final class b {
    private static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        byte[] bytes;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.Fz().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i10 = -1;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("connection", m5.c.f28350u0);
                httpURLConnection.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection.setRequestProperty(m5.c.f28302e0, Base64.encodeToString(com.kwad.sdk.utils.a.gC(file.getPath()), 2));
                httpURLConnection.setRequestProperty("file-type", p1.b.f29697h + u.getExtension(file.getName()));
                httpURLConnection.setRequestProperty("origin-name", name);
                httpURLConnection.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection.connect();
                outputStream = httpURLConnection.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), uuid));
                    }
                    bytes = ("\r\n--" + uuid + "--\r\n").getBytes();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("--");
                    sb2.append(uuid);
                    sb2.append("\r\n");
                    sb2.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb2.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb2.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                } catch (Exception e10) {
                    e = e10;
                    dataInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = null;
                }
            } catch (Exception e11) {
                e = e11;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e12) {
            e = e12;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            outputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    outputStream.write(bArr, 0, read);
                }
            }
            outputStream.write("\r\n".getBytes());
            outputStream.write(bytes);
            outputStream.flush();
            int responseCode = httpURLConnection.getResponseCode();
            cVar.code = responseCode;
            cVar.azs = responseCode;
            if (responseCode == 200) {
                cVar.azu = h.a(httpURLConnection.getInputStream());
                try {
                    if (new JSONObject(cVar.azu).optInt(i.f29758c, -1) == 1) {
                        aVar.JR();
                    } else {
                        e eVar = e.aMb;
                        aVar.JQ();
                    }
                } catch (JSONException unused) {
                    e eVar2 = e.aMc;
                    aVar.JQ();
                }
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "response.body= " + cVar.azu);
            } else {
                e eVar3 = e.aMa;
                e.aMa.xv();
                aVar.JQ();
                com.kwad.sdk.core.network.idc.a Fz = com.kwad.sdk.core.network.idc.a.Fz();
                int i11 = cVar.code;
                if (i11 == 0) {
                    i11 = -1;
                }
                Fz.a(str3, i11, (Throwable) null);
            }
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
        } catch (Exception e13) {
            e = e13;
            httpURLConnection2 = httpURLConnection;
            try {
                e eVar4 = e.aMa;
                e.getCause();
                aVar.JQ();
                com.kwad.sdk.core.network.idc.a Fz2 = com.kwad.sdk.core.network.idc.a.Fz();
                int i12 = cVar.code;
                if (i12 != 0) {
                    i10 = i12;
                }
                Fz2.a(str3, i10, e);
                com.kwad.sdk.core.d.c.printStackTrace(e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            } catch (Throwable th5) {
                th = th5;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection2 = httpURLConnection;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] e(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--");
        sb2.append(str3);
        sb2.append("\r\n");
        sb2.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb2.append("\r\n");
        sb2.append("Content-Length: " + str2.length());
        sb2.append("\r\n");
        sb2.append("\r\n");
        sb2.append(str2);
        sb2.append("\r\n");
        return sb2.toString().getBytes();
    }

    private static Map<String, String> a(f fVar) {
        HashMap hashMap = new HashMap();
        if (fVar == null) {
            return hashMap;
        }
        if (!TextUtils.isEmpty(fVar.aMm)) {
            hashMap.put("uploadToken", fVar.aMm);
        }
        if (!TextUtils.isEmpty(fVar.aMj)) {
            hashMap.put(NotificationCompat.CATEGORY_SYSTEM, fVar.aMj);
        }
        if (!TextUtils.isEmpty(fVar.aMi)) {
            hashMap.put("did", fVar.aMi);
        }
        if (!TextUtils.isEmpty(fVar.aMg)) {
            hashMap.put("sid", fVar.aMg);
        }
        if (!TextUtils.isEmpty(fVar.aKC)) {
            hashMap.put("appver", fVar.aKC);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            hashMap.put(DBDefinition.TASK_ID, fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.aMh)) {
            hashMap.put(Constants.TOKEN, fVar.aMh);
        }
        if (!TextUtils.isEmpty(fVar.aMf)) {
            hashMap.put("uid", fVar.aMf);
        }
        if (!TextUtils.isEmpty(fVar.aMk)) {
            hashMap.put(MediationConstant.KEY_EXTRA_INFO, fVar.aMk);
        }
        return hashMap;
    }

    public static void a(File file, f fVar, a aVar) {
        a(file, fVar.aMi, fVar.aMh, a(fVar), aVar);
    }
}
