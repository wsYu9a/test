package com.opos.cmn.an.g.a.a;

import android.content.Context;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: d */
    private OutputStream f16481d;

    /* renamed from: e */
    private InputStream f16482e;

    public b(Context context, f fVar) {
        super(context, fVar);
        this.f16481d = null;
        this.f16482e = null;
    }

    private Map<String, String> c() {
        Map<String, List<String>> headerFields = this.f16480c.getHeaderFields();
        HashMap hashMap = null;
        if (headerFields != null && headerFields.size() > 0) {
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("getResponseHeaderMap key=");
                        sb.append(key != null ? key : "null");
                        sb.append(",value=");
                        sb.append(value.get(0) != null ? value.get(0) : "null");
                        com.opos.cmn.an.f.a.b("HttpURLSyncTask", sb.toString());
                        hashMap.put(key, value.get(0));
                    }
                }
            }
        }
        return hashMap;
    }

    public g a() {
        byte[] bArr;
        com.opos.cmn.an.f.a.b("HttpURLSyncTask", "execute start");
        if (this.f16480c != null) {
            try {
                com.opos.cmn.an.f.a.b("HttpURLSyncTask", "connect start");
                this.f16480c.connect();
                com.opos.cmn.an.f.a.b("HttpURLSyncTask", "connect end");
                if ("POST".equals(this.f16479b.f16494b) && (bArr = this.f16479b.f16499g) != null && bArr.length > 0) {
                    OutputStream outputStream = this.f16480c.getOutputStream();
                    this.f16481d = outputStream;
                    outputStream.write(this.f16479b.f16499g);
                    this.f16481d.flush();
                }
                int responseCode = this.f16480c.getResponseCode();
                com.opos.cmn.an.f.a.b("HttpURLSyncTask", "code=" + responseCode);
                String responseMessage = this.f16480c.getResponseMessage();
                StringBuilder sb = new StringBuilder();
                sb.append("msg=");
                sb.append(responseMessage != null ? responseMessage : "null");
                com.opos.cmn.an.f.a.b("HttpURLSyncTask", sb.toString());
                try {
                    this.f16482e = this.f16480c.getInputStream();
                } catch (IOException unused) {
                }
                String headerField = this.f16480c.getHeaderField("Content-Length");
                return new g.a().a(responseCode).a(responseMessage).a(com.opos.cmn.an.c.a.a(headerField) ? -1L : Long.parseLong(headerField)).a(c()).a(this.f16482e).a();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("HttpURLSyncTask", "", e2);
            }
        }
        return null;
    }

    public void b() {
        try {
            OutputStream outputStream = this.f16481d;
            if (outputStream != null) {
                outputStream.close();
            }
            InputStream inputStream = this.f16482e;
            if (inputStream != null) {
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.f16480c;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("HttpURLSyncTask", "", e2);
        }
    }
}
