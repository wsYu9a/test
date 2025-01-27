package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.crash.utils.h;
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
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    private static Map<String, String> a(f fVar) {
        HashMap hashMap = new HashMap();
        if (fVar == null) {
            return hashMap;
        }
        if (!TextUtils.isEmpty(fVar.ata)) {
            hashMap.put("uploadToken", fVar.ata);
        }
        if (!TextUtils.isEmpty(fVar.asX)) {
            hashMap.put(NotificationCompat.CATEGORY_SYSTEM, fVar.asX);
        }
        if (!TextUtils.isEmpty(fVar.asW)) {
            hashMap.put("did", fVar.asW);
        }
        if (!TextUtils.isEmpty(fVar.asU)) {
            hashMap.put(OapsKey.KEY_SUB_ID, fVar.asU);
        }
        if (!TextUtils.isEmpty(fVar.arz)) {
            hashMap.put("appver", fVar.arz);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            hashMap.put(DBDefinition.TASK_ID, fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.asV)) {
            hashMap.put(OapsKey.KEY_TOKEN, fVar.asV);
        }
        if (!TextUtils.isEmpty(fVar.asT)) {
            hashMap.put("uid", fVar.asT);
        }
        if (!TextUtils.isEmpty(fVar.asY)) {
            hashMap.put("extraInfo", fVar.asY);
        }
        return hashMap;
    }

    public static void a(File file, f fVar, a aVar) {
        a(file, fVar.asW, fVar.asV, a(fVar), aVar);
    }

    private static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.wm().C("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i2 = -1;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection2.setRequestProperty("User-Agent", q.getUserAgent());
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_MD5, Base64.encodeToString(com.kwad.sdk.utils.a.es(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", "." + com.kwad.sdk.utils.q.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(d(str4, map.get(str4), uuid));
                    }
                    byte[] bytes = ("\r\n--" + uuid + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(uuid);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
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
                        int responseCode = httpURLConnection2.getResponseCode();
                        cVar.code = responseCode;
                        cVar.agd = responseCode;
                        if (responseCode == 200) {
                            cVar.agf = h.a(httpURLConnection2.getInputStream());
                            try {
                                int optInt = new JSONObject(cVar.agf).optInt("result", -1);
                                if (optInt == 1) {
                                    aVar.Ag();
                                } else {
                                    e eVar = e.asP;
                                    new StringBuilder("result is ").append(optInt);
                                    aVar.Af();
                                }
                            } catch (JSONException unused) {
                                e eVar2 = e.asQ;
                                aVar.Af();
                            }
                            com.kwad.sdk.core.d.b.d("ExceptionCollector", "response.body= " + cVar.agf);
                        } else {
                            e eVar3 = e.asO;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(e.asO.Ai());
                            sb2.append(responseCode);
                            aVar.Af();
                            com.kwad.sdk.core.network.idc.a wm = com.kwad.sdk.core.network.idc.a.wm();
                            int i3 = cVar.code;
                            if (i3 == 0) {
                                i3 = -1;
                            }
                            wm.a(str3, i3, (Throwable) null);
                        }
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        try {
                            e eVar4 = e.asO;
                            e.getCause();
                            aVar.Af();
                            com.kwad.sdk.core.network.idc.a wm2 = com.kwad.sdk.core.network.idc.a.wm();
                            int i4 = cVar.code;
                            if (i4 != 0) {
                                i2 = i4;
                            }
                            wm2.a(str3, i2, e);
                            com.kwad.sdk.core.d.b.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
            } catch (Exception e4) {
                e = e4;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] d(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append("\r\n");
        sb.append("Content-Length: " + str2.length());
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb.toString().getBytes();
    }
}
