package com.shu.priory.download;

import android.content.Context;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.download.d.a;
import com.shu.priory.utils.f;
import com.shu.priory.utils.h;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: com.shu.priory.download.e$1 */
    public static class AnonymousClass1 implements com.shu.priory.download.a.a {

        /* renamed from: b */
        final /* synthetic */ String f17027b;

        public AnonymousClass1(String str) {
            str3 = str;
        }

        @Override // com.shu.priory.download.a.a
        public void a(int i10) {
        }

        @Override // com.shu.priory.download.a.a
        public void b(int i10) {
        }

        @Override // com.shu.priory.download.a.a
        public void c(int i10) {
        }

        @Override // com.shu.priory.download.a.a
        public void d(int i10) {
        }

        @Override // com.shu.priory.download.a.a
        public void e(int i10) {
            h.a(SDKConstants.TAG, "video cache success");
            a.this.a(str3);
        }

        @Override // com.shu.priory.download.a.a
        public void a(long j10, long j11, int i10) {
        }

        @Override // com.shu.priory.download.a.a
        public void a(com.shu.priory.download.e.a aVar, int i10) {
            h.a(SDKConstants.TAG, "video cache failed");
            a.this.a();
            File file = new File(str3);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public interface a {
        void a();

        void a(String str);
    }

    public static void a(Context context, JSONObject jSONObject, a aVar) {
        if (context == null || jSONObject == null) {
            return;
        }
        try {
            String str = b.a(context) + File.separator;
            String optString = jSONObject.optString("url");
            String a10 = f.a(optString);
            int optInt = jSONObject.optInt("format");
            String str2 = ".mp4";
            if (optInt != 0) {
                if (optInt == 1) {
                    str2 = ".3gp";
                } else if (optInt == 2) {
                    str2 = ".avi";
                } else if (optInt == 3) {
                    str2 = ".flv";
                }
            }
            String str3 = str + a10 + str2;
            int abs = Math.abs(optString.hashCode());
            com.shu.priory.download.a.b a11 = com.shu.priory.download.a.a(context);
            com.shu.priory.download.d.a b10 = a11.b(abs);
            if (b10 != null && !TextUtils.isEmpty(b10.c())) {
                if (new File(b10.c()).exists()) {
                    h.a(SDKConstants.TAG, "download exists");
                    aVar.a(b10.c());
                    return;
                }
                h.a(SDKConstants.TAG, "download not exists");
            }
            com.shu.priory.download.d.a a12 = new a.C0553a().a(optString).b(str3).a();
            a12.a(new com.shu.priory.download.a.a() { // from class: com.shu.priory.download.e.1

                /* renamed from: b */
                final /* synthetic */ String f17027b;

                public AnonymousClass1(String str32) {
                    str3 = str32;
                }

                @Override // com.shu.priory.download.a.a
                public void a(int i10) {
                }

                @Override // com.shu.priory.download.a.a
                public void b(int i10) {
                }

                @Override // com.shu.priory.download.a.a
                public void c(int i10) {
                }

                @Override // com.shu.priory.download.a.a
                public void d(int i10) {
                }

                @Override // com.shu.priory.download.a.a
                public void e(int i10) {
                    h.a(SDKConstants.TAG, "video cache success");
                    a.this.a(str3);
                }

                @Override // com.shu.priory.download.a.a
                public void a(long j10, long j11, int i10) {
                }

                @Override // com.shu.priory.download.a.a
                public void a(com.shu.priory.download.e.a aVar2, int i10) {
                    h.a(SDKConstants.TAG, "video cache failed");
                    a.this.a();
                    File file = new File(str3);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            });
            a11.a(a12);
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "startCache:" + th2.getMessage());
        }
    }
}
