package com.opos.mobad.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import com.heytap.msp.mobad.api.R;
import com.heytap.nearx.tapplugin.pluginapi.PluginApi;
import com.opos.mobad.d.a;
import com.opos.mobad.d.a.c;
import com.opos.mobad.d.a.d;
import com.opos.mobad.d.a.e;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class DownloadService extends Service {

    /* renamed from: c */
    private static AtomicInteger f23431c = new AtomicInteger(10000);

    /* renamed from: f */
    private static boolean f23432f = true;

    /* renamed from: a */
    private Context f23433a;

    /* renamed from: b */
    private com.opos.mobad.d.a.c f23434b;

    /* renamed from: d */
    private ConcurrentHashMap<String, com.opos.mobad.d.a.b> f23435d = new ConcurrentHashMap<>();

    /* renamed from: e */
    private ConcurrentHashMap<String, List<Messenger>> f23436e = new ConcurrentHashMap<>();

    /* renamed from: g */
    private AtomicBoolean f23437g = new AtomicBoolean(false);

    /* renamed from: h */
    private Messenger f23438h = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.service.DownloadService.1
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.getData() == null) {
                return;
            }
            Bundle data = message.getData();
            String string = data.getString("key_url");
            String string2 = data.getString("key_pkg_name");
            com.opos.cmn.an.f.a.b("DownloadService", "get message actionType:" + message.what + ",url:" + string + ",pkgName:" + string2);
            int i2 = message.what;
            if (i2 == 1) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                Messenger messenger = message.replyTo;
                String string3 = data.getString("key_apk_md5");
                String string4 = data.getString("key_app_name");
                DownloadService.this.a(messenger, string);
                DownloadService.this.a(string, string2, string3, string4);
                return;
            }
            if (i2 == 2) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.g(string);
                return;
            }
            if (i2 == 3) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.h(string);
            } else if (i2 == 4) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.i(string);
            } else if (i2 == 5) {
                DownloadService.this.f(string2);
            } else {
                if (i2 != 7) {
                    return;
                }
                DownloadService.this.a(message.replyTo);
            }
        }
    });

    /* renamed from: i */
    private a.InterfaceC0439a f23439i = new a.InterfaceC0439a() { // from class: com.opos.mobad.service.DownloadService.2

        /* renamed from: com.opos.mobad.service.DownloadService$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23442a;

            /* renamed from: b */
            final /* synthetic */ String f23443b;

            AnonymousClass1(com.opos.mobad.d.a.b bVar, String str) {
                bVar = bVar;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.d.a.c cVar = DownloadService.this.f23434b;
                com.opos.mobad.d.a.b bVar = bVar;
                cVar.a(bVar.f20396c, new c.a(bVar.f20394a, "", 107, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$2 */
        class RunnableC04772 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23445a;

            /* renamed from: b */
            final /* synthetic */ long f23446b;

            /* renamed from: c */
            final /* synthetic */ long f23447c;

            /* renamed from: d */
            final /* synthetic */ int f23448d;

            /* renamed from: e */
            final /* synthetic */ String f23449e;

            RunnableC04772(com.opos.mobad.d.a.b bVar, long j2, long j3, int i2, String str) {
                bVar = bVar;
                j2 = j2;
                j3 = j3;
                a2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    com.opos.mobad.d.a.c cVar = DownloadService.this.f23434b;
                    com.opos.mobad.d.a.b bVar = bVar;
                    cVar.a(bVar.f20396c, new c.a(bVar.f20394a, ((((j2 * 100) / 1024) / 1024) / 100.0f) + "MB/" + ((((j3 * 100) / 1024) / 1024) / 100.0f) + "MB", 102, a2, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                }
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$3 */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23451a;

            /* renamed from: b */
            final /* synthetic */ String f23452b;

            /* renamed from: c */
            final /* synthetic */ long f23453c;

            /* renamed from: d */
            final /* synthetic */ long f23454d;

            /* renamed from: e */
            final /* synthetic */ int f23455e;

            AnonymousClass3(com.opos.mobad.d.a.b bVar, String str, long j2, long j3, int i2) {
                bVar = bVar;
                str = str;
                j2 = j2;
                j3 = j3;
                a2 = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.a(bVar, str, j2, j3, a2);
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$4 */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23457a;

            AnonymousClass4(com.opos.mobad.d.a.b bVar) {
                bVar = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadService.this.f23434b.a(bVar.f20396c);
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$5 */
        class AnonymousClass5 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23459a;

            /* renamed from: b */
            final /* synthetic */ String f23460b;

            AnonymousClass5(com.opos.mobad.d.a.b bVar, String str) {
                bVar = bVar;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.a(bVar, str);
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$6 */
        class AnonymousClass6 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23462a;

            /* renamed from: b */
            final /* synthetic */ String f23463b;

            AnonymousClass6(com.opos.mobad.d.a.b bVar, String str) {
                bVar = bVar;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.b(bVar, str);
            }
        }

        AnonymousClass2() {
        }

        private int a(long j2, long j3) {
            if (j3 > 0 && j2 > 0) {
                long j4 = (j2 * 100) / j3;
                if (j4 > 100) {
                    return 100;
                }
                if (j4 >= 0) {
                    return (int) j4;
                }
            }
            return 0;
        }

        public void a(com.opos.mobad.d.a.b bVar, String str) {
            DownloadService.this.f23434b.a(bVar.f20396c, new c.a(bVar.f20394a, "", 106, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        public void a(com.opos.mobad.d.a.b bVar, String str, long j2, long j3, int i2) {
            a(str, i2);
            DownloadService.this.f23434b.a(bVar.f20396c, new c.a(bVar.f20394a, ((((j2 * 100) / 1024) / 1024) / 100.0f) + "MB/" + ((((100 * j3) / 1024) / 1024) / 100.0f) + "MB", 103, i2, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        private void a(String str, int i2) {
            com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str);
            if (bVar != null) {
                bVar.f20397d = i2;
            }
        }

        public void b(com.opos.mobad.d.a.b bVar, String str) {
            DownloadService.this.f23434b.a(bVar.f20396c, new c.a(bVar.f20394a, "", 105, 0, DownloadService.this.d(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        private void b(String str, int i2) {
            com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str);
            if (bVar != null) {
                bVar.f20398e = i2;
            }
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void a(String str) {
            com.opos.mobad.d.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(str, 0);
            Toast.makeText(DownloadService.this.f23433a, DownloadService.this.f23433a.getResources().getString(R.string.download_toast_start_txt), 1).show();
            b(str, 101);
            if (DownloadService.this.a() && (bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str)) != null) {
                bVar.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.1

                    /* renamed from: a */
                    final /* synthetic */ com.opos.mobad.d.a.b f23442a;

                    /* renamed from: b */
                    final /* synthetic */ String f23443b;

                    AnonymousClass1(com.opos.mobad.d.a.b bVar2, String str2) {
                        bVar = bVar2;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        com.opos.mobad.d.a.c cVar = DownloadService.this.f23434b;
                        com.opos.mobad.d.a.b bVar2 = bVar;
                        cVar.a(bVar2.f20396c, new c.a(bVar2.f20394a, "", 107, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                    }
                }, d.a.INIT_STATUS);
            }
            DownloadService.this.a(101, 0, str2);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void a(String str, int i2, long j2, long j3) {
            com.opos.cmn.an.f.a.b("DownloadService", "fail exception:" + i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int a2 = a(j2, j3);
            Toast.makeText(DownloadService.this.f23433a, DownloadService.this.f23433a.getResources().getString(R.string.download_toast_fail_txt), 1).show();
            b(str, 106);
            if (DownloadService.this.a()) {
                a(str, a2);
                com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str);
                if (bVar != null) {
                    bVar.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.5

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.d.a.b f23459a;

                        /* renamed from: b */
                        final /* synthetic */ String f23460b;

                        AnonymousClass5(com.opos.mobad.d.a.b bVar2, String str2) {
                            bVar = bVar2;
                            str = str2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2.this.a(bVar, str);
                        }
                    }, d.a.FAILED_STATUS);
                }
            }
            DownloadService.this.a(106, a2, str2, i2 + "");
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void a(String str, long j2, long j3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b(str, 107);
            DownloadService.this.a(107, a(j2, j3), str);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void b(String str) {
            com.opos.cmn.an.f.a.b("DownloadService", "complete ");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Toast.makeText(DownloadService.this.f23433a, DownloadService.this.f23433a.getResources().getString(R.string.download_toast_downloaded_txt), 1).show();
            b(str, 105);
            if (DownloadService.this.a()) {
                a(str, 100);
                com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str);
                if (bVar != null) {
                    bVar.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.6

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.d.a.b f23462a;

                        /* renamed from: b */
                        final /* synthetic */ String f23463b;

                        AnonymousClass6(com.opos.mobad.d.a.b bVar2, String str2) {
                            bVar = bVar2;
                            str = str2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2.this.b(bVar, str);
                        }
                    }, d.a.END_STATUS);
                }
            }
            DownloadService.this.a(105, 100, str2);
            com.opos.mobad.d.b.b.a(DownloadService.this.f23433a, com.opos.cmn.d.a.a(DownloadService.this.f23433a, str2));
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void b(String str, long j2, long j3) {
            com.opos.mobad.d.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int a2 = a(j2, j3);
            b(str, 102);
            if (DownloadService.this.a() && (bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str)) != null) {
                int i2 = a2 - bVar.f20397d;
                if (i2 < 0) {
                    bVar.f20397d = 0;
                }
                if (i2 > 1) {
                    a(str, a2);
                    com.opos.cmn.an.f.a.b("DownloadService", "changePercent:" + i2 + ",notificationHelper.lastPercent:" + bVar.f20397d);
                    bVar.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.2

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.d.a.b f23445a;

                        /* renamed from: b */
                        final /* synthetic */ long f23446b;

                        /* renamed from: c */
                        final /* synthetic */ long f23447c;

                        /* renamed from: d */
                        final /* synthetic */ int f23448d;

                        /* renamed from: e */
                        final /* synthetic */ String f23449e;

                        RunnableC04772(com.opos.mobad.d.a.b bVar2, long j22, long j32, int a22, String str2) {
                            bVar = bVar2;
                            j2 = j22;
                            j3 = j32;
                            a2 = a22;
                            str = str2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (bVar != null) {
                                com.opos.mobad.d.a.c cVar = DownloadService.this.f23434b;
                                com.opos.mobad.d.a.b bVar2 = bVar;
                                cVar.a(bVar2.f20396c, new c.a(bVar2.f20394a, ((((j2 * 100) / 1024) / 1024) / 100.0f) + "MB/" + ((((j3 * 100) / 1024) / 1024) / 100.0f) + "MB", 102, a2, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                            }
                        }
                    }, d.a.PROGRESS_STATUS);
                }
            }
            DownloadService.this.a(102, a22, str2);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void c(String str) {
            com.opos.cmn.an.f.a.b("DownloadService", "onMobileNetworkAvailableAndChooseRetry url =" + str);
            com.opos.mobad.d.a.a(DownloadService.this.f23433a).a(str);
            Toast.makeText(DownloadService.this.f23433a, DownloadService.this.f23433a.getResources().getString(R.string.download_toast_in_mobile_txt), 1).show();
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void c(String str, long j2, long j3) {
            com.opos.mobad.d.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int a2 = a(j2, j3);
            b(str, 103);
            if (DownloadService.this.a() && (bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str)) != null) {
                bVar.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.3

                    /* renamed from: a */
                    final /* synthetic */ com.opos.mobad.d.a.b f23451a;

                    /* renamed from: b */
                    final /* synthetic */ String f23452b;

                    /* renamed from: c */
                    final /* synthetic */ long f23453c;

                    /* renamed from: d */
                    final /* synthetic */ long f23454d;

                    /* renamed from: e */
                    final /* synthetic */ int f23455e;

                    AnonymousClass3(com.opos.mobad.d.a.b bVar2, String str2, long j22, long j32, int a22) {
                        bVar = bVar2;
                        str = str2;
                        j2 = j22;
                        j3 = j32;
                        a2 = a22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2.this.a(bVar, str, j2, j3, a2);
                    }
                }, d.a.PAUSED_STATUS);
            }
            DownloadService.this.a(103, a22, str2);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void d(String str, long j2, long j3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int a2 = a(j2, j3);
            b(str, 104);
            if (DownloadService.this.a()) {
                a(str, a2);
                com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str);
                if (bVar != null) {
                    bVar.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.4

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.d.a.b f23457a;

                        AnonymousClass4(com.opos.mobad.d.a.b bVar2) {
                            bVar = bVar2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadService.this.f23434b.a(bVar.f20396c);
                        }
                    }, d.a.END_STATUS);
                }
            }
            DownloadService.this.a(104, a2, str);
            DownloadService.this.e(str);
        }
    };

    /* renamed from: com.opos.mobad.service.DownloadService$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.getData() == null) {
                return;
            }
            Bundle data = message.getData();
            String string = data.getString("key_url");
            String string2 = data.getString("key_pkg_name");
            com.opos.cmn.an.f.a.b("DownloadService", "get message actionType:" + message.what + ",url:" + string + ",pkgName:" + string2);
            int i2 = message.what;
            if (i2 == 1) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                Messenger messenger = message.replyTo;
                String string3 = data.getString("key_apk_md5");
                String string4 = data.getString("key_app_name");
                DownloadService.this.a(messenger, string);
                DownloadService.this.a(string, string2, string3, string4);
                return;
            }
            if (i2 == 2) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.g(string);
                return;
            }
            if (i2 == 3) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.h(string);
            } else if (i2 == 4) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.i(string);
            } else if (i2 == 5) {
                DownloadService.this.f(string2);
            } else {
                if (i2 != 7) {
                    return;
                }
                DownloadService.this.a(message.replyTo);
            }
        }
    }

    /* renamed from: com.opos.mobad.service.DownloadService$2 */
    class AnonymousClass2 implements a.InterfaceC0439a {

        /* renamed from: com.opos.mobad.service.DownloadService$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23442a;

            /* renamed from: b */
            final /* synthetic */ String f23443b;

            AnonymousClass1(com.opos.mobad.d.a.b bVar2, String str2) {
                bVar = bVar2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.d.a.c cVar = DownloadService.this.f23434b;
                com.opos.mobad.d.a.b bVar2 = bVar;
                cVar.a(bVar2.f20396c, new c.a(bVar2.f20394a, "", 107, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$2 */
        class RunnableC04772 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23445a;

            /* renamed from: b */
            final /* synthetic */ long f23446b;

            /* renamed from: c */
            final /* synthetic */ long f23447c;

            /* renamed from: d */
            final /* synthetic */ int f23448d;

            /* renamed from: e */
            final /* synthetic */ String f23449e;

            RunnableC04772(com.opos.mobad.d.a.b bVar2, long j22, long j32, int a22, String str2) {
                bVar = bVar2;
                j2 = j22;
                j3 = j32;
                a2 = a22;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    com.opos.mobad.d.a.c cVar = DownloadService.this.f23434b;
                    com.opos.mobad.d.a.b bVar2 = bVar;
                    cVar.a(bVar2.f20396c, new c.a(bVar2.f20394a, ((((j2 * 100) / 1024) / 1024) / 100.0f) + "MB/" + ((((j3 * 100) / 1024) / 1024) / 100.0f) + "MB", 102, a2, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                }
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$3 */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23451a;

            /* renamed from: b */
            final /* synthetic */ String f23452b;

            /* renamed from: c */
            final /* synthetic */ long f23453c;

            /* renamed from: d */
            final /* synthetic */ long f23454d;

            /* renamed from: e */
            final /* synthetic */ int f23455e;

            AnonymousClass3(com.opos.mobad.d.a.b bVar2, String str2, long j22, long j32, int a22) {
                bVar = bVar2;
                str = str2;
                j2 = j22;
                j3 = j32;
                a2 = a22;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.a(bVar, str, j2, j3, a2);
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$4 */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23457a;

            AnonymousClass4(com.opos.mobad.d.a.b bVar2) {
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadService.this.f23434b.a(bVar.f20396c);
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$5 */
        class AnonymousClass5 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23459a;

            /* renamed from: b */
            final /* synthetic */ String f23460b;

            AnonymousClass5(com.opos.mobad.d.a.b bVar2, String str2) {
                bVar = bVar2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.a(bVar, str);
            }
        }

        /* renamed from: com.opos.mobad.service.DownloadService$2$6 */
        class AnonymousClass6 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.d.a.b f23462a;

            /* renamed from: b */
            final /* synthetic */ String f23463b;

            AnonymousClass6(com.opos.mobad.d.a.b bVar2, String str2) {
                bVar = bVar2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.b(bVar, str);
            }
        }

        AnonymousClass2() {
        }

        private int a(long j2, long j3) {
            if (j3 > 0 && j2 > 0) {
                long j4 = (j2 * 100) / j3;
                if (j4 > 100) {
                    return 100;
                }
                if (j4 >= 0) {
                    return (int) j4;
                }
            }
            return 0;
        }

        public void a(com.opos.mobad.d.a.b bVar, String str) {
            DownloadService.this.f23434b.a(bVar.f20396c, new c.a(bVar.f20394a, "", 106, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        public void a(com.opos.mobad.d.a.b bVar, String str, long j2, long j3, int i2) {
            a(str, i2);
            DownloadService.this.f23434b.a(bVar.f20396c, new c.a(bVar.f20394a, ((((j2 * 100) / 1024) / 1024) / 100.0f) + "MB/" + ((((100 * j3) / 1024) / 1024) / 100.0f) + "MB", 103, i2, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        private void a(String str, int i2) {
            com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str);
            if (bVar != null) {
                bVar.f20397d = i2;
            }
        }

        public void b(com.opos.mobad.d.a.b bVar, String str) {
            DownloadService.this.f23434b.a(bVar.f20396c, new c.a(bVar.f20394a, "", 105, 0, DownloadService.this.d(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        private void b(String str, int i2) {
            com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str);
            if (bVar != null) {
                bVar.f20398e = i2;
            }
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void a(String str2) {
            com.opos.mobad.d.a.b bVar2;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            a(str2, 0);
            Toast.makeText(DownloadService.this.f23433a, DownloadService.this.f23433a.getResources().getString(R.string.download_toast_start_txt), 1).show();
            b(str2, 101);
            if (DownloadService.this.a() && (bVar2 = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str2)) != null) {
                bVar2.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.1

                    /* renamed from: a */
                    final /* synthetic */ com.opos.mobad.d.a.b f23442a;

                    /* renamed from: b */
                    final /* synthetic */ String f23443b;

                    AnonymousClass1(com.opos.mobad.d.a.b bVar22, String str22) {
                        bVar = bVar22;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        com.opos.mobad.d.a.c cVar = DownloadService.this.f23434b;
                        com.opos.mobad.d.a.b bVar22 = bVar;
                        cVar.a(bVar22.f20396c, new c.a(bVar22.f20394a, "", 107, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                    }
                }, d.a.INIT_STATUS);
            }
            DownloadService.this.a(101, 0, str22);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void a(String str2, int i2, long j2, long j3) {
            com.opos.cmn.an.f.a.b("DownloadService", "fail exception:" + i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            int a2 = a(j2, j3);
            Toast.makeText(DownloadService.this.f23433a, DownloadService.this.f23433a.getResources().getString(R.string.download_toast_fail_txt), 1).show();
            b(str2, 106);
            if (DownloadService.this.a()) {
                a(str2, a2);
                com.opos.mobad.d.a.b bVar2 = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str2);
                if (bVar2 != null) {
                    bVar2.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.5

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.d.a.b f23459a;

                        /* renamed from: b */
                        final /* synthetic */ String f23460b;

                        AnonymousClass5(com.opos.mobad.d.a.b bVar22, String str22) {
                            bVar = bVar22;
                            str = str22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2.this.a(bVar, str);
                        }
                    }, d.a.FAILED_STATUS);
                }
            }
            DownloadService.this.a(106, a2, str22, i2 + "");
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void a(String str, long j2, long j3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b(str, 107);
            DownloadService.this.a(107, a(j2, j3), str);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void b(String str2) {
            com.opos.cmn.an.f.a.b("DownloadService", "complete ");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Toast.makeText(DownloadService.this.f23433a, DownloadService.this.f23433a.getResources().getString(R.string.download_toast_downloaded_txt), 1).show();
            b(str2, 105);
            if (DownloadService.this.a()) {
                a(str2, 100);
                com.opos.mobad.d.a.b bVar2 = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str2);
                if (bVar2 != null) {
                    bVar2.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.6

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.d.a.b f23462a;

                        /* renamed from: b */
                        final /* synthetic */ String f23463b;

                        AnonymousClass6(com.opos.mobad.d.a.b bVar22, String str22) {
                            bVar = bVar22;
                            str = str22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2.this.b(bVar, str);
                        }
                    }, d.a.END_STATUS);
                }
            }
            DownloadService.this.a(105, 100, str22);
            com.opos.mobad.d.b.b.a(DownloadService.this.f23433a, com.opos.cmn.d.a.a(DownloadService.this.f23433a, str22));
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void b(String str2, long j22, long j32) {
            com.opos.mobad.d.a.b bVar2;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            int a22 = a(j22, j32);
            b(str2, 102);
            if (DownloadService.this.a() && (bVar2 = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str2)) != null) {
                int i2 = a22 - bVar2.f20397d;
                if (i2 < 0) {
                    bVar2.f20397d = 0;
                }
                if (i2 > 1) {
                    a(str2, a22);
                    com.opos.cmn.an.f.a.b("DownloadService", "changePercent:" + i2 + ",notificationHelper.lastPercent:" + bVar2.f20397d);
                    bVar2.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.2

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.d.a.b f23445a;

                        /* renamed from: b */
                        final /* synthetic */ long f23446b;

                        /* renamed from: c */
                        final /* synthetic */ long f23447c;

                        /* renamed from: d */
                        final /* synthetic */ int f23448d;

                        /* renamed from: e */
                        final /* synthetic */ String f23449e;

                        RunnableC04772(com.opos.mobad.d.a.b bVar22, long j222, long j322, int a222, String str22) {
                            bVar = bVar22;
                            j2 = j222;
                            j3 = j322;
                            a2 = a222;
                            str = str22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (bVar != null) {
                                com.opos.mobad.d.a.c cVar = DownloadService.this.f23434b;
                                com.opos.mobad.d.a.b bVar22 = bVar;
                                cVar.a(bVar22.f20396c, new c.a(bVar22.f20394a, ((((j2 * 100) / 1024) / 1024) / 100.0f) + "MB/" + ((((j3 * 100) / 1024) / 1024) / 100.0f) + "MB", 102, a2, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                            }
                        }
                    }, d.a.PROGRESS_STATUS);
                }
            }
            DownloadService.this.a(102, a222, str22);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void c(String str) {
            com.opos.cmn.an.f.a.b("DownloadService", "onMobileNetworkAvailableAndChooseRetry url =" + str);
            com.opos.mobad.d.a.a(DownloadService.this.f23433a).a(str);
            Toast.makeText(DownloadService.this.f23433a, DownloadService.this.f23433a.getResources().getString(R.string.download_toast_in_mobile_txt), 1).show();
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void c(String str2, long j22, long j32) {
            com.opos.mobad.d.a.b bVar2;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            int a22 = a(j22, j32);
            b(str2, 103);
            if (DownloadService.this.a() && (bVar2 = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str2)) != null) {
                bVar2.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.3

                    /* renamed from: a */
                    final /* synthetic */ com.opos.mobad.d.a.b f23451a;

                    /* renamed from: b */
                    final /* synthetic */ String f23452b;

                    /* renamed from: c */
                    final /* synthetic */ long f23453c;

                    /* renamed from: d */
                    final /* synthetic */ long f23454d;

                    /* renamed from: e */
                    final /* synthetic */ int f23455e;

                    AnonymousClass3(com.opos.mobad.d.a.b bVar22, String str22, long j222, long j322, int a222) {
                        bVar = bVar22;
                        str = str22;
                        j2 = j222;
                        j3 = j322;
                        a2 = a222;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2.this.a(bVar, str, j2, j3, a2);
                    }
                }, d.a.PAUSED_STATUS);
            }
            DownloadService.this.a(103, a222, str22);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0439a
        public void d(String str, long j2, long j3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int a2 = a(j2, j3);
            b(str, 104);
            if (DownloadService.this.a()) {
                a(str, a2);
                com.opos.mobad.d.a.b bVar2 = (com.opos.mobad.d.a.b) DownloadService.this.f23435d.get(str);
                if (bVar2 != null) {
                    bVar2.f20399f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.4

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.d.a.b f23457a;

                        AnonymousClass4(com.opos.mobad.d.a.b bVar22) {
                            bVar = bVar22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadService.this.f23434b.a(bVar.f20396c);
                        }
                    }, d.a.END_STATUS);
                }
            }
            DownloadService.this.a(104, a2, str);
            DownloadService.this.e(str);
        }
    }

    /* renamed from: com.opos.mobad.service.DownloadService$3 */
    class AnonymousClass3 implements IBinder.DeathRecipient {

        /* renamed from: a */
        final /* synthetic */ Messenger f23465a;

        AnonymousClass3(Messenger messenger) {
            messenger = messenger;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            com.opos.cmn.an.f.a.a("DownloadService", "download binderDied:" + messenger);
            DownloadService.this.a(messenger);
            messenger.getBinder().unlinkToDeath(this, 0);
        }
    }

    public Intent a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f23433a, (Class<?>) DownloadService.class);
        intent.setAction("key_download_action");
        intent.putExtra("key_action_type", 1);
        intent.putExtra(DBDefinition.SAVE_PATH, str);
        return intent;
    }

    public void a(int i2, int i3, String str) {
        a(i2, i3, str, (String) null);
    }

    public void a(int i2, int i3, String str, String str2) {
        List<Messenger> list;
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.f23436e;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || TextUtils.isEmpty(str) || (list = this.f23436e.get(str)) == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.f.a.b("DownloadService", "service status :" + i2 + ",percent:" + i3 + ",url:" + str);
        Message obtain = Message.obtain();
        obtain.what = i2;
        Bundle bundle = new Bundle();
        bundle.putInt("key_percent", i3);
        bundle.putString("key_server_url", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(Constants.KEY_ERROR_CODE, str2);
        }
        obtain.setData(bundle);
        for (Messenger messenger : list) {
            if (messenger != null) {
                if (messenger.getBinder() == null || !messenger.getBinder().isBinderAlive()) {
                    list.remove(messenger);
                } else {
                    try {
                        messenger.send(obtain);
                    } catch (RemoteException e2) {
                        com.opos.cmn.an.f.a.b("DownloadService", "", e2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0105, code lost:
    
        if (106 == r9) goto L116;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Intent r9) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.DownloadService.a(android.content.Intent):void");
    }

    public void a(Messenger messenger) {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap;
        if (messenger != null && (concurrentHashMap = this.f23436e) != null && concurrentHashMap.size() > 0) {
            for (String str : this.f23436e.keySet()) {
                List<Messenger> list = this.f23436e.get(str);
                if (list != null && list.contains(messenger)) {
                    list.remove(messenger);
                    if (list.size() <= 0) {
                        this.f23436e.remove(str);
                    }
                }
            }
        }
        com.opos.cmn.an.f.a.b("DownloadService", "remove mClientMessengerMap size :" + this.f23436e.size());
    }

    public void a(Messenger messenger, String str) {
        List<Messenger> j2;
        if (TextUtils.isEmpty(str) || messenger == null || (j2 = j(str)) == null || j2.contains(messenger)) {
            return;
        }
        j2.add(messenger);
        try {
            messenger.getBinder().linkToDeath(new IBinder.DeathRecipient() { // from class: com.opos.mobad.service.DownloadService.3

                /* renamed from: a */
                final /* synthetic */ Messenger f23465a;

                AnonymousClass3(Messenger messenger2) {
                    messenger = messenger2;
                }

                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    com.opos.cmn.an.f.a.a("DownloadService", "download binderDied:" + messenger);
                    DownloadService.this.a(messenger);
                    messenger.getBinder().unlinkToDeath(this, 0);
                }
            }, 0);
        } catch (RemoteException e2) {
            com.opos.cmn.an.f.a.a("DownloadService", "", (Throwable) e2);
        }
        this.f23436e.put(str, j2);
        com.opos.cmn.an.f.a.b("DownloadService", "add mClientMessengerToUrlsMap size:" + this.f23436e.size() + ",messengersByUrlList size :" + j2.size());
    }

    public boolean a() {
        return f23432f && (Build.VERSION.SDK_INT < 33 || this.f23433a.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0);
    }

    public Intent b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f23433a, (Class<?>) DownloadService.class);
        intent.setAction("key_delete_action");
        intent.putExtra("key_action_type", 2);
        intent.putExtra(DBDefinition.SAVE_PATH, str);
        return intent;
    }

    private void b() {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.f23436e;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public Intent c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f23433a, (Class<?>) DownloadService.class);
        intent.setAction("key_sys_delete_action");
        intent.putExtra("key_action_type", 3);
        intent.putExtra(DBDefinition.SAVE_PATH, str);
        return intent;
    }

    public Intent d(String str) {
        if (!TextUtils.isEmpty(str)) {
            String a2 = com.opos.cmn.d.a.a(this.f23433a, str);
            com.opos.cmn.an.f.a.b("DownloadService", "install intent downloadPath =" + a2);
            if (!TextUtils.isEmpty(a2)) {
                return com.opos.mobad.d.b.b.b(this.f23433a, a2);
            }
        }
        return null;
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f23435d.remove(str);
            k(str);
        }
        com.opos.cmn.an.f.a.b("DownloadService", "remove data mUrlToDownloadDataMap size:" + this.f23435d.size() + ",mUrlToClientMessengerMap:" + this.f23436e.size());
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<String, com.opos.mobad.d.a.b> entry : this.f23435d.entrySet()) {
            com.opos.mobad.d.a.b value = entry.getValue();
            if (value != null && value.a(str)) {
                String key = entry.getKey();
                if (a()) {
                    com.opos.cmn.an.f.a.b("DownloadService", "cancel notificationId:" + value.f20396c);
                    this.f23434b.a(value.f20396c);
                }
                e(key);
            }
        }
    }

    public void g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.d.a.a(this.f23433a).b(str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DownloadService", "", (Throwable) e2);
        }
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.d.a.a(this.f23433a).d(str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DownloadService", "", (Throwable) e2);
        }
    }

    public void i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.d.a.a(this.f23433a).c(str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DownloadService", "", (Throwable) e2);
        }
    }

    private List<Messenger> j(String str) {
        List<Messenger> arrayList = (TextUtils.isEmpty(str) || !this.f23436e.containsKey(str)) ? new ArrayList<>() : this.f23436e.get(str);
        com.opos.cmn.an.f.a.b("DownloadService", "getUrlToClientMessengerMap size=" + arrayList.size());
        return arrayList;
    }

    private void k(String str) {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.f23436e;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0 && !TextUtils.isEmpty(str)) {
            this.f23436e.remove(str);
        }
        com.opos.cmn.an.f.a.b("DownloadService", "removeClientMessengerUrlList mUrlToClientMessengerMap.size:" + this.f23436e.size());
    }

    private void l(String str) {
        com.opos.mobad.d.a.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a() && (bVar = this.f23435d.get(str)) != null) {
            int i2 = bVar.f20396c;
            this.f23434b.a(i2);
            com.opos.cmn.an.f.a.b("DownloadService", "cancelNotificationAndRemoveData:" + i2);
        }
        e(str);
    }

    public void a(int i2, boolean z) {
        if (this.f23437g.compareAndSet(false, true)) {
            f23432f = z;
            com.opos.cmn.an.f.a.b("DownloadService", "int service downloadTaskNums:" + i2 + ",sIsShowNotification :" + f23432f);
            com.opos.mobad.d.a.a(this.f23433a).a(i2, this.f23439i);
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.mobad.d.a.b bVar = this.f23435d.containsKey(str) ? this.f23435d.get(str) : null;
        com.opos.cmn.an.f.a.b("DownloadService", "add downloadreq pkgName:" + str2 + ",appName :" + str4 + ",url:" + str + ",downloadReq:" + bVar);
        if (bVar != null) {
            int i2 = bVar.f20398e;
            if (102 != i2 && 107 != i2) {
                com.opos.mobad.d.a.a(this.f23433a).a(str, str3);
                return;
            } else {
                Context context = this.f23433a;
                Toast.makeText(context, context.getResources().getString(R.string.download_toast_downloading_txt), 1).show();
                return;
            }
        }
        com.opos.mobad.d.a.a(this.f23433a).a(str, str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = com.opos.cmn.d.b.a(str);
        }
        this.f23435d.put(str, new com.opos.mobad.d.a.b(str4, str2, f23431c.getAndIncrement(), new com.opos.mobad.d.a.d()));
        com.opos.cmn.an.f.a.b("DownloadService", "add downloadreq mUrlToDownloadDataMap size:" + this.f23435d.size());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.opos.cmn.an.f.a.b("DownloadService", "on bind");
        a(intent);
        return this.f23438h.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f23433a = getApplicationContext();
        b.a(PluginApi.sPluginContext, PluginApi.sHostContext);
        com.opos.cmn.an.f.a.b("DownloadService", "onCreate startForeground");
        com.opos.mobad.d.a.e a2 = new e.a().a("mob_downloader").b(3).b("download_manager").a(false).a(e.a(this.f23433a, "opos_mob_drawable_download_icon", "drawable")).a();
        this.f23434b = Build.VERSION.SDK_INT > 30 ? new com.opos.mobad.d.a.g(this.f23433a, a2) : new com.opos.mobad.d.a.a(this.f23433a, a2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.opos.cmn.an.f.a.b("DownloadService", "onDestroy");
        this.f23435d.clear();
        this.f23434b.a();
        com.opos.mobad.d.a.a(this.f23433a).a();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        com.opos.cmn.an.f.a.b("DownloadService", "on Rebind");
        a(intent);
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        com.opos.cmn.an.f.a.b("DownloadService", "onStartCommand");
        a(intent);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        com.opos.cmn.an.f.a.b("DownloadService", "onUnbind");
        b();
        return super.onUnbind(intent);
    }
}
