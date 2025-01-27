package b.h.a.j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import b.h.a.j.d;
import b.h.a.k;
import com.oplus.log.core.e;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private b.h.a.j.a f5003a;

    /* renamed from: b */
    private b.h.a.d f5004b;

    /* renamed from: c */
    private b.h.a.b f5005c = new b.h.a.h.a();

    /* renamed from: d */
    private int f5006d = 0;

    /* renamed from: e */
    private h f5007e;

    /* renamed from: f */
    private i f5008f;

    /* renamed from: g */
    private d f5009g;

    /* renamed from: h */
    private String f5010h;

    /* renamed from: i */
    private b.h.a.a.b f5011i;

    final class a implements d.c {

        /* renamed from: a */
        final /* synthetic */ e f5012a;

        a(e eVar) {
            this.f5012a = eVar;
        }

        @Override // b.h.a.j.d.c
        public final void a(int i2, File file) {
            c.this.k(this.f5012a, i2, file);
        }

        @Override // b.h.a.j.d.c
        public final void a(int i2, String str) {
            c.this.y(this.f5012a, i2, str);
        }
    }

    final class b implements e.b {

        /* renamed from: a */
        final /* synthetic */ C0056c f5014a;

        final class a implements d.c {
            a() {
            }

            @Override // b.h.a.j.d.c
            public final void a(int i2, File file) {
                b bVar = b.this;
                c.this.g(bVar.f5014a, i2, file);
            }

            @Override // b.h.a.j.d.c
            public final void a(int i2, String str) {
                b bVar = b.this;
                c.this.x(bVar.f5014a, i2, str);
            }
        }

        b(C0056c c0056c) {
            this.f5014a = c0056c;
        }

        @Override // com.oplus.log.core.e.b
        public final void a() {
            C0056c c0056c = this.f5014a;
            b.h.a.j.d.b(c0056c.f5019c, c0056c.f5020d, c.this.f5004b, c.this.f5010h, this.f5014a.f5022f, new a());
        }
    }

    /* renamed from: b.h.a.j.c$c */
    public static class C0056c {

        /* renamed from: a */
        String f5017a;

        /* renamed from: b */
        String f5018b;

        /* renamed from: c */
        long f5019c;

        /* renamed from: d */
        long f5020d;

        /* renamed from: e */
        boolean f5021e;

        /* renamed from: f */
        String f5022f;

        /* renamed from: g */
        String f5023g;

        /* renamed from: h */
        String f5024h;

        /* renamed from: i */
        String f5025i;
    }

    public interface d {
        void a(b.h.a.j.b bVar);

        void b(String str, C0056c c0056c);
    }

    public static class e {

        /* renamed from: a */
        String f5026a;

        /* renamed from: b */
        String f5027b;

        /* renamed from: c */
        long f5028c;

        /* renamed from: d */
        long f5029d;

        /* renamed from: e */
        boolean f5030e;

        /* renamed from: f */
        String f5031f;

        public e(String str, long j2, long j3, boolean z, String str2, String str3) {
            this.f5026a = str;
            this.f5028c = j2;
            this.f5029d = j3;
            this.f5030e = z;
            this.f5031f = str2;
            this.f5027b = str3;
        }
    }

    public class f {

        /* renamed from: a */
        String f5032a;

        /* renamed from: b */
        String f5033b;

        /* renamed from: c */
        g f5034c;

        f(String str, String str2) {
            this.f5033b = str;
            this.f5032a = str2;
        }

        void a(g gVar) {
            this.f5034c = gVar;
        }
    }

    public interface g {
        void a(UserTraceConfigDto userTraceConfigDto);

        void a(String str);
    }

    public class h extends Handler {
        h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof e) {
                c.this.i((e) obj);
            } else if (obj instanceof C0056c) {
                c.this.e((C0056c) obj);
            } else if (obj instanceof f) {
                f fVar = (f) obj;
                c.this.z(fVar.f5033b, fVar.f5032a, fVar.f5034c);
            }
        }
    }

    public interface i {
        void a();

        void a(String str);
    }

    public c(b.h.a.d dVar) {
        this.f5010h = null;
        this.f5004b = dVar == null ? new b.h.a.d() : dVar;
        this.f5010h = this.f5004b.q() + File.separator + ".zip";
        if (this.f5004b.v() != null) {
            this.f5003a = this.f5004b.v();
        }
        b();
    }

    private void b() {
        HandlerThread handlerThread = new HandlerThread(getClass().getName());
        handlerThread.start();
        this.f5007e = new h(handlerThread.getLooper());
    }

    private void d(b.h.a.j.b bVar) {
        this.f5006d = 0;
        b.h.a.j.d.d(this.f5010h);
        d dVar = this.f5009g;
        if (dVar != null) {
            dVar.a(bVar);
        }
    }

    public void e(C0056c c0056c) {
        if (c0056c.f5021e && !b.h.a.e.c.e()) {
            this.f5005c.b("report_log_info", "upload task need wifi connect");
            h(c0056c, -121, "upload task need wifi connect");
            d dVar = this.f5009g;
            if (dVar != null) {
                dVar.b("upload task need wifi connect", c0056c);
                return;
            }
            return;
        }
        try {
            b.h.a.a.b bVar = this.f5011i;
            if (bVar != null) {
                bVar.b(new b(c0056c));
            }
        } catch (Exception e2) {
            x(c0056c, -1, e2.toString());
        }
    }

    public void g(C0056c c0056c, int i2, File file) {
        C0056c c0056c2;
        String str;
        String str2;
        String str3;
        String str4 = this.f5003a == null ? "report upload fail : HttpDelegate is null" : "";
        if (c0056c == null) {
            str4 = "report upload fail : reportBody is null";
        }
        if (file == null) {
            str4 = "report upload fail : file is null";
        }
        if (!TextUtils.isEmpty(str4)) {
            this.f5005c.c("report_log_info", str4);
            d dVar = this.f5009g;
            if (dVar != null) {
                dVar.b(str4, c0056c);
                return;
            }
            return;
        }
        try {
            str = "report_log_info";
            try {
                try {
                    String g2 = k.g(c0056c.f5017a, c0056c.f5022f, file.getName(), i2, "", c0056c.f5018b, this.f5004b.a(), this.f5004b.g(), TextUtils.isEmpty(this.f5004b.j()) ? b.h.a.e.b.d(b.h.a.e.b.a()) : this.f5004b.j(), c0056c.f5023g, c0056c.f5024h, c0056c.f5020d, this.f5010h, c0056c.f5025i, this.f5005c);
                    this.f5005c.a("NearX-HLog", "doReportUpload Code: ".concat(String.valueOf(g2)));
                    b.h.a.j.b a2 = this.f5003a.a(g2, file);
                    if (a2 != null && a2.a() == 200) {
                        d(a2);
                        return;
                    }
                    if (a2 == null) {
                        str3 = "report upload error:response is null";
                    } else {
                        str3 = "report upload error:response code is " + a2.a() + ", msg is " + a2.b();
                    }
                    c0056c2 = c0056c;
                    try {
                        x(c0056c2, -110, str3);
                    } catch (IOException e2) {
                        e = e2;
                        str2 = str;
                        x(c0056c2, -111, e.toString());
                        this.f5005c.c(str2, "report upload network io exception:" + e.toString());
                        if (b.h.a.c.j()) {
                            e.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        x(c0056c2, -111, e.toString());
                        this.f5005c.c(str, "report upload network exception:" + e.toString());
                        if (b.h.a.c.j()) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    c0056c2 = c0056c;
                } catch (Exception e5) {
                    e = e5;
                    c0056c2 = c0056c;
                }
            } catch (IOException e6) {
                e = e6;
                c0056c2 = c0056c;
            } catch (Exception e7) {
                e = e7;
                c0056c2 = c0056c;
            }
        } catch (IOException e8) {
            e = e8;
            c0056c2 = c0056c;
            str2 = "report_log_info";
        } catch (Exception e9) {
            e = e9;
            c0056c2 = c0056c;
            str = "report_log_info";
        }
    }

    private void h(C0056c c0056c, int i2, String str) {
        b.h.a.b bVar;
        String str2;
        if (this.f5003a == null) {
            bVar = this.f5005c;
            str2 = "upload code error : HttpDelegate is null";
        } else {
            if (c0056c != null) {
                try {
                    String g2 = k.g(c0056c.f5017a, c0056c.f5022f, "", i2, str, c0056c.f5018b, this.f5004b.a(), this.f5004b.g(), TextUtils.isEmpty(this.f5004b.j()) ? b.h.a.e.b.d(b.h.a.e.b.a()) : this.f5004b.j(), c0056c.f5023g, c0056c.f5024h, c0056c.f5020d, this.f5010h, c0056c.f5025i, this.f5005c);
                    this.f5005c.a("NearX-HLog", "reportUpload Error Code: ".concat(String.valueOf(g2)));
                    this.f5003a.a(g2);
                    return;
                } catch (Exception e2) {
                    this.f5005c.c("report_log_info", "upload code error:" + e2.toString());
                    return;
                }
            }
            bVar = this.f5005c;
            str2 = "upload code error : UploadBody is null";
        }
        bVar.c("report_log_info", str2);
    }

    public void i(e eVar) {
        if (eVar.f5030e && !b.h.a.e.c.e()) {
            this.f5005c.b("upload_log_info", "upload task need wifi connect");
            l(eVar, -121, "upload task need wifi connect");
            i iVar = this.f5008f;
            if (iVar != null) {
                iVar.a("upload task need wifi connect");
                return;
            }
            return;
        }
        try {
            b.h.a.a.b bVar = this.f5011i;
            if (bVar != null) {
                bVar.a();
            }
            b.h.a.j.d.b(eVar.f5028c, eVar.f5029d, this.f5004b, this.f5010h, eVar.f5031f, new a(eVar));
        } catch (Exception e2) {
            y(eVar, -1, e2.toString());
        }
    }

    public void k(e eVar, int i2, File file) {
        String str;
        String str2 = this.f5003a == null ? "upload fail : HttpDelegate is null" : "";
        if (eVar == null) {
            str2 = "upload fail : uploadBody is null";
        }
        if (file == null) {
            str2 = "upload fail : file is null";
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f5005c.c("upload_log_info", str2);
            i iVar = this.f5008f;
            if (iVar != null) {
                iVar.a(str2);
                return;
            }
            return;
        }
        try {
            String f2 = k.f(eVar.f5026a, eVar.f5031f, file.getName(), i2, "", eVar.f5027b, this.f5004b.a(), this.f5004b.g(), TextUtils.isEmpty(this.f5004b.j()) ? b.h.a.e.b.d(b.h.a.e.b.a()) : this.f5004b.j());
            this.f5005c.a("NearX-HLog", "doUpload Code: ".concat(String.valueOf(f2)));
            b.h.a.j.b a2 = this.f5003a.a(f2, file);
            if (a2 != null && a2.a() == 200) {
                w();
                return;
            }
            if (a2 == null) {
                str = "upload error:response is null";
            } else {
                str = "upload error:response code is " + a2.a() + ", msg is " + a2.b();
            }
            y(eVar, -110, str);
        } catch (IOException e2) {
            y(eVar, -111, e2.toString());
            this.f5005c.c("upload_log_info", "upload network io exception:" + e2.toString());
            if (b.h.a.c.j()) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            y(eVar, -111, e3.toString());
            this.f5005c.c("upload_log_info", "upload network exception:" + e3.toString());
            if (b.h.a.c.j()) {
                e3.printStackTrace();
            }
        }
    }

    private void l(e eVar, int i2, String str) {
        b.h.a.b bVar;
        String str2;
        if (this.f5003a == null) {
            bVar = this.f5005c;
            str2 = "upload code error : HttpDelegate is null";
        } else {
            if (eVar != null) {
                try {
                    String f2 = k.f(eVar.f5026a, eVar.f5031f, "", i2, str, eVar.f5027b, this.f5004b.a(), this.f5004b.g(), TextUtils.isEmpty(this.f5004b.j()) ? b.h.a.e.b.d(b.h.a.e.b.a()) : this.f5004b.j());
                    this.f5005c.a("NearX-HLog", "upload Error Code: ".concat(String.valueOf(f2)));
                    this.f5003a.a(f2);
                    return;
                } catch (Exception e2) {
                    this.f5005c.c("upload_log_info", "upload code error:" + e2.toString());
                    if (b.h.a.c.j()) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            bVar = this.f5005c;
            str2 = "upload code error : UploadBody is null";
        }
        bVar.c("upload_log_info", str2);
    }

    private void w() {
        this.f5006d = 0;
        b.h.a.j.d.d(this.f5010h);
        i iVar = this.f5008f;
        if (iVar != null) {
            iVar.a();
        }
    }

    public void x(C0056c c0056c, int i2, String str) {
        b.h.a.j.d.d(this.f5010h);
        int i3 = this.f5006d;
        if (i3 < 3) {
            int i4 = i3 + 1;
            this.f5006d = i4;
            f(c0056c, i4 * 2000);
        } else {
            this.f5005c.b("report_log_info", "report upload failed");
            this.f5006d = 0;
            d dVar = this.f5009g;
            if (dVar != null) {
                dVar.b("run out of retry:".concat(String.valueOf(str)), c0056c);
            }
            h(c0056c, i2, str);
        }
    }

    public void y(e eVar, int i2, String str) {
        b.h.a.j.d.d(this.f5010h);
        int i3 = this.f5006d;
        if (i3 < 3) {
            int i4 = i3 + 1;
            this.f5006d = i4;
            j(eVar, i4 * 2000);
        } else {
            this.f5005c.b("upload_log_info", "upload failed");
            this.f5006d = 0;
            i iVar = this.f5008f;
            if (iVar != null) {
                iVar.a("run out of retry:".concat(String.valueOf(str)));
            }
            l(eVar, i2, str);
        }
    }

    public void z(String str, String str2, g gVar) {
        if (this.f5003a == null) {
            this.f5005c.c("upload_log_info", "check upload failed : HttpDelegate is null");
            return;
        }
        try {
            String e2 = k.e(str, str2, this.f5004b.a(), this.f5004b.g(), TextUtils.isEmpty(this.f5004b.j()) ? b.h.a.e.b.d(b.h.a.e.b.a()) : this.f5004b.j());
            this.f5005c.a("NearX-HLog", "doUploadChecker: ".concat(String.valueOf(e2)));
            UserTraceConfigDto b2 = this.f5003a.b(e2);
            if (b2 == null || (TextUtils.isEmpty(b2.getImei()) && TextUtils.isEmpty(b2.getOpenId()))) {
                if (gVar != null) {
                    gVar.a("userTraceConfigDto or device id is empty");
                }
            } else if (gVar != null) {
                this.f5005c.b("upload_log_info", "need upload log");
                gVar.a(b2);
            }
        } catch (Exception e3) {
            if (gVar != null) {
                gVar.a(e3.toString());
            }
        }
    }

    public void c(b.h.a.a.b bVar) {
        if (bVar != null) {
            this.f5011i = bVar;
        }
    }

    public void f(C0056c c0056c, int i2) {
        Message obtain = Message.obtain();
        obtain.obj = c0056c;
        this.f5007e.sendMessageDelayed(obtain, i2);
    }

    public void j(e eVar, int i2) {
        Message obtain = Message.obtain();
        obtain.obj = eVar;
        this.f5007e.sendMessageDelayed(obtain, i2);
    }

    public void m(i iVar) {
        this.f5008f = iVar;
    }

    public void u(String str, String str2, g gVar) {
        f fVar = new f(str, str2);
        fVar.a(gVar);
        Message obtain = Message.obtain();
        obtain.obj = fVar;
        this.f5007e.sendMessage(obtain);
    }
}
