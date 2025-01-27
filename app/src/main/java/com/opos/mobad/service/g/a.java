package com.opos.mobad.service.g;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private EnumC0486a f23647a;

    /* renamed from: b */
    private b f23648b;

    /* renamed from: c */
    private String f23649c;

    /* renamed from: d */
    private List<String> f23650d;

    /* renamed from: e */
    private int[] f23651e;

    /* renamed from: f */
    private long f23652f = -1;

    /* renamed from: com.opos.mobad.service.g.a$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f23653a;

        /* renamed from: b */
        static final /* synthetic */ int[] f23654b;

        static {
            int[] iArr = new int[b.values().length];
            f23654b = iArr;
            try {
                iArr[b.MARKET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23654b[b.WEB_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23654b[b.BROWSER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23654b[b.INSTANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23654b[b.APP_HOME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23654b[b.DEEP_LINK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23654b[b.DOWNLOADER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23654b[b.MINI_PROGRAM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[EnumC0486a.values().length];
            f23653a = iArr2;
            try {
                iArr2[EnumC0486a.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23653a[EnumC0486a.EXTRA.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23653a[EnumC0486a.FLOATLAYER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f23653a[EnumC0486a.BUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f23653a[EnumC0486a.FLOATLAYER_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f23653a[EnumC0486a.PENDANT.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* renamed from: com.opos.mobad.service.g.a$a */
    public enum EnumC0486a {
        BUTTON,
        EXTRA,
        VIDEO,
        FLOATLAYER_BUTTON,
        FLOATLAYER_EXTRA,
        PENDANT
    }

    public enum b {
        APP_HOME,
        DEEP_LINK,
        WEB_VIEW,
        BROWSER,
        INSTANT,
        MARKET,
        DOWNLOADER,
        MINI_PROGRAM
    }

    a() {
    }

    protected MonitorEvent a() {
        MonitorEvent.d dVar;
        MonitorEvent.c cVar;
        MonitorEvent.b bVar = new MonitorEvent.b();
        EnumC0486a enumC0486a = this.f23647a;
        if (enumC0486a != null) {
            switch (AnonymousClass1.f23653a[enumC0486a.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    bVar.a(MonitorEvent.a.EXTRA);
                    cVar = MonitorEvent.c.OTHER;
                    break;
                case 4:
                case 5:
                case 6:
                    bVar.a(MonitorEvent.a.BTN);
                    cVar = MonitorEvent.c.CLICK_BUTTON;
                    break;
            }
            bVar.a(cVar);
        }
        b bVar2 = this.f23648b;
        if (bVar2 != null) {
            switch (AnonymousClass1.f23654b[bVar2.ordinal()]) {
                case 1:
                    dVar = MonitorEvent.d.APP_SHOP;
                    break;
                case 2:
                case 3:
                    dVar = MonitorEvent.d.WEB_URL;
                    break;
                case 4:
                    dVar = MonitorEvent.d.QA;
                    break;
                case 5:
                    dVar = MonitorEvent.d.APP_HOME;
                    break;
                case 6:
                    dVar = MonitorEvent.d.DEEP_LINK;
                    break;
                case 7:
                    dVar = MonitorEvent.d.DOWNLOADER;
                    break;
                case 8:
                    dVar = MonitorEvent.d.MINI_PROGRAM;
                    break;
            }
            bVar.a(dVar);
        }
        String str = this.f23649c;
        if (str != null) {
            bVar.a(str);
        }
        int[] iArr = this.f23651e;
        if (iArr != null && iArr.length > 0) {
            bVar.a(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        long j2 = this.f23652f;
        if (j2 >= 0) {
            bVar.a((int) j2);
        }
        return bVar.a();
    }

    public a a(long j2) {
        this.f23652f = j2;
        return this;
    }

    public a a(EnumC0486a enumC0486a) {
        this.f23647a = enumC0486a;
        return this;
    }

    public a a(b bVar) {
        this.f23648b = bVar;
        return this;
    }

    public a a(String str) {
        this.f23649c = str;
        return this;
    }

    public a a(List<String> list) {
        this.f23650d = list;
        return this;
    }

    public a a(int[] iArr) {
        this.f23651e = iArr;
        return this;
    }

    public void a(Context context) {
        List<String> list = this.f23650d;
        if (list == null || list.size() <= 0) {
            com.opos.cmn.an.f.a.a("", "report with url null or length 0");
        } else {
            com.opos.mobad.service.g.b.a(context, this.f23650d, a());
        }
    }
}
