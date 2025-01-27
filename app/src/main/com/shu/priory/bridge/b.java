package com.shu.priory.bridge;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.shu.priory.a.c;
import com.shu.priory.a.e;
import com.shu.priory.a.f;
import com.shu.priory.a.g;
import com.shu.priory.a.h;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    private Context f16871a;

    /* renamed from: b */
    private DSBridgeWebView f16872b;

    /* renamed from: c */
    private h f16873c;

    /* renamed from: d */
    private a f16874d;

    /* renamed from: e */
    private boolean f16875e;

    /* renamed from: f */
    private String f16876f;

    /* renamed from: com.shu.priory.bridge.b$1 */
    public class AnonymousClass1 implements f.c {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.a.f.c
        public void a(com.shu.priory.a.b bVar) {
        }
    }

    public class a extends CountDownTimer {
        public a(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (b.this.f16875e || b.this.f16872b == null) {
                return;
            }
            b.this.f16872b.a("voiceRecordEnd", (Object[]) null, (c) null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    public b(Context context, DSBridgeWebView dSBridgeWebView) {
        this.f16871a = context;
        this.f16872b = dSBridgeWebView;
        this.f16876f = com.shu.priory.download.b.a(context) + File.separator + "voiceRecord.wav";
    }

    public String a(String str) {
        StringBuilder sb2;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("getRecordBase64:");
            sb2.append(e.getMessage());
            com.shu.priory.utils.h.d(SDKConstants.TAG, sb2.toString());
            return "";
        } catch (IOException e11) {
            e = e11;
            sb2 = new StringBuilder();
            sb2.append("getRecordBase64:");
            sb2.append(e.getMessage());
            com.shu.priory.utils.h.d(SDKConstants.TAG, sb2.toString());
            return "";
        }
    }

    @JavascriptInterface
    public void checkAudioPermission(Object obj, com.shu.priory.bridge.a<String> aVar) {
        aVar.a(m.a(this.f16871a, "android.permission.RECORD_AUDIO") ? "grant" : "refused");
    }

    @JavascriptInterface
    public String checkSdk(Object obj) {
        return "iflytek_sdk";
    }

    @JavascriptInterface
    public void startRecord(Object obj, com.shu.priory.bridge.a<String> aVar) {
        try {
            h a10 = e.a(new f.b(new g.a(new c.a(1, 2, 16, 16000)), new f.c() { // from class: com.shu.priory.bridge.b.1
                public AnonymousClass1() {
                }

                @Override // com.shu.priory.a.f.c
                public void a(com.shu.priory.a.b bVar) {
                }
            }), new File(this.f16876f));
            this.f16873c = a10;
            a10.a();
            aVar.a("start record");
            this.f16875e = false;
            a aVar2 = new a(60000L, 1000L);
            this.f16874d = aVar2;
            aVar2.start();
        } catch (Exception e10) {
            com.shu.priory.utils.h.d(SDKConstants.TAG, "startRecord:" + e10.getMessage());
        }
    }

    @JavascriptInterface
    public void stopRecord(Object obj, com.shu.priory.bridge.a<String> aVar) {
        try {
            this.f16875e = true;
            this.f16874d = null;
            h hVar = this.f16873c;
            if (hVar != null) {
                hVar.b();
                this.f16873c = null;
            }
            aVar.a(a(this.f16876f).replaceAll("\r|\n", ""));
        } catch (Exception e10) {
            com.shu.priory.utils.h.d(SDKConstants.TAG, "stopRecord:" + e10.getMessage());
        }
    }

    public void a() {
        try {
            this.f16875e = true;
            if (this.f16874d != null) {
                this.f16874d = null;
            }
            h hVar = this.f16873c;
            if (hVar != null) {
                hVar.b();
                this.f16873c = null;
            }
        } catch (Exception e10) {
            com.shu.priory.utils.h.d(SDKConstants.TAG, "stopRecordExcept:" + e10.getMessage());
        }
    }
}
