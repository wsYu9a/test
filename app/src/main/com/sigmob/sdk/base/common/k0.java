package com.sigmob.sdk.base.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.l0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.windad.WindAds;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: j */
    public static final f f17918j = new a();

    /* renamed from: k */
    public static final g f17919k = new b();

    /* renamed from: a */
    public final EnumSet<j0> f17920a;

    /* renamed from: b */
    public final f f17921b;

    /* renamed from: c */
    public final f f17922c;

    /* renamed from: d */
    public final g f17923d;

    /* renamed from: e */
    public final BaseAdUnit f17924e;

    /* renamed from: f */
    public final boolean f17925f;

    /* renamed from: g */
    public boolean f17926g;

    /* renamed from: h */
    public boolean f17927h;

    /* renamed from: i */
    public boolean f17928i;

    public class a implements f {
        @Override // com.sigmob.sdk.base.common.k0.f
        public void a(String str, j0 j0Var) {
        }

        @Override // com.sigmob.sdk.base.common.k0.f
        public void b(String str, j0 j0Var) {
        }
    }

    public class b implements g {
        @Override // com.sigmob.sdk.base.common.k0.g
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.k0.g
        public void b() {
        }

        @Override // com.sigmob.sdk.base.common.k0.g
        public void c() {
        }
    }

    public class c implements l0.a {

        /* renamed from: a */
        public final /* synthetic */ j0 f17929a;

        /* renamed from: b */
        public final /* synthetic */ Context f17930b;

        /* renamed from: c */
        public final /* synthetic */ k0 f17931c;

        /* renamed from: d */
        public final /* synthetic */ Uri f17932d;

        /* renamed from: e */
        public final /* synthetic */ String f17933e;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f17935a;

            /* renamed from: b */
            public final /* synthetic */ j0 f17936b;

            public a(String str, j0 j0Var) {
                this.f17935a = str;
                this.f17936b = j0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    k0.this.f17921b.a(this.f17935a, this.f17936b);
                } catch (Throwable unused) {
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ String f17938a;

            /* renamed from: b */
            public final /* synthetic */ j0 f17939b;

            public b(String str, j0 j0Var) {
                this.f17938a = str;
                this.f17939b = j0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    k0.this.f17921b.b(this.f17938a, this.f17939b);
                } catch (Throwable unused) {
                }
            }
        }

        /* renamed from: com.sigmob.sdk.base.common.k0$c$c */
        public class RunnableC0566c implements Runnable {
            public RunnableC0566c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    f fVar = k0.this.f17921b;
                    c cVar = c.this;
                    fVar.a(cVar.f17933e, cVar.f17929a);
                } catch (Throwable unused) {
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    f fVar = k0.this.f17921b;
                    c cVar = c.this;
                    fVar.b(cVar.f17933e, cVar.f17929a);
                } catch (Throwable unused) {
                }
            }
        }

        public c(j0 j0Var, Context context, k0 k0Var, Uri uri, String str) {
            this.f17929a = j0Var;
            this.f17930b = context;
            this.f17931c = k0Var;
            this.f17932d = uri;
            this.f17933e = str;
        }

        @Override // com.sigmob.sdk.base.common.l0.a
        public void a(String str, Throwable th2) {
            try {
                this.f17929a.a(this.f17930b, this.f17932d, this.f17931c, k0.this.f17924e);
                WindAds.sharedAds().getHandler().post(new RunnableC0566c());
            } catch (Exception unused) {
                WindAds.sharedAds().getHandler().post(new d());
            }
        }

        @Override // com.sigmob.sdk.base.common.l0.a
        public void a(String str) {
            j0 j0Var = this.f17929a;
            if (!str.toLowerCase().startsWith("http")) {
                j0Var = j0.f17908d;
            }
            try {
                j0Var.a(this.f17930b, Uri.parse(str), this.f17931c, k0.this.f17924e);
                WindAds.sharedAds().getHandler().post(new a(str, j0Var));
            } catch (Exception unused) {
                WindAds.sharedAds().getHandler().post(new b(str, j0Var));
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f17943a;

        /* renamed from: b */
        public final /* synthetic */ j0 f17944b;

        public d(String str, j0 j0Var) {
            this.f17943a = str;
            this.f17944b = j0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.this.f17921b.a(this.f17943a, this.f17944b);
        }
    }

    public static class e {

        /* renamed from: a */
        public EnumSet<j0> f17946a = EnumSet.of(j0.f17913i);

        /* renamed from: b */
        public f f17947b = k0.f17918j;

        /* renamed from: c */
        public f f17948c = k0.f17918j;

        /* renamed from: d */
        public g f17949d = k0.f17919k;

        /* renamed from: e */
        public boolean f17950e = false;

        /* renamed from: f */
        public boolean f17951f = false;

        /* renamed from: g */
        public BaseAdUnit f17952g;

        public k0 a() {
            return new k0(this.f17946a, this.f17947b, this.f17948c, this.f17949d, this.f17950e, this.f17952g, this.f17951f, null);
        }

        public e b(f fVar) {
            this.f17947b = fVar;
            return this;
        }

        public e a(BaseAdUnit baseAdUnit) {
            this.f17952g = baseAdUnit;
            return this;
        }

        public e b(boolean z10) {
            this.f17950e = z10;
            return this;
        }

        public e a(f fVar) {
            this.f17948c = fVar;
            return this;
        }

        public e a(g gVar) {
            this.f17949d = gVar;
            return this;
        }

        public e a(j0 j0Var, j0... j0VarArr) {
            this.f17946a = EnumSet.of(j0Var, j0VarArr);
            return this;
        }

        public e a(boolean z10) {
            this.f17951f = z10;
            return this;
        }
    }

    public interface f {
        void a(String str, j0 j0Var);

        void b(String str, j0 j0Var);
    }

    public interface g {
        void a();

        void b();

        void c();
    }

    public k0(EnumSet<j0> enumSet, f fVar, f fVar2, g gVar, boolean z10, BaseAdUnit baseAdUnit, boolean z11) {
        this.f17920a = EnumSet.copyOf((EnumSet) enumSet);
        this.f17921b = fVar;
        this.f17922c = fVar2;
        this.f17923d = gVar;
        this.f17925f = z10;
        this.f17924e = baseAdUnit;
        this.f17926g = false;
        this.f17927h = false;
        this.f17928i = z11;
    }

    public g c() {
        return this.f17923d;
    }

    public boolean d() {
        return this.f17925f;
    }

    public /* synthetic */ k0(EnumSet enumSet, f fVar, f fVar2, g gVar, boolean z10, BaseAdUnit baseAdUnit, boolean z11, a aVar) {
        this(enumSet, fVar, fVar2, gVar, z10, baseAdUnit, z11);
    }

    public final void a(String str, j0 j0Var, String str2, Throwable th2) {
        Preconditions.NoThrow.checkNotNull(str2);
        if (j0Var == null) {
            j0Var = j0.f17913i;
        }
        SigmobLog.d(str2, th2);
        this.f17921b.b(str, j0Var);
    }

    public void b(Context context, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        a(context, str);
    }

    public final boolean a(Context context, String str) {
        j0 j0Var = j0.f17913i;
        Iterator<E> it = this.f17920a.iterator();
        String str2 = null;
        while (it.hasNext()) {
            j0 j0Var2 = (j0) it.next();
            String a10 = j0Var2.a(this.f17924e);
            if (!TextUtils.isEmpty(str) && this.f17924e.getInteractionType() != 7) {
                a10 = str;
            }
            if (!TextUtils.isEmpty(a10)) {
                str2 = this.f17924e.getMacroCommon().macroProcess(a10);
                try {
                    Uri parse = Uri.parse(str2);
                    AndroidMarket androidMarket = this.f17924e.getAndroidMarket();
                    if (j0Var2 != j0.f17908d || !parse.getScheme().equalsIgnoreCase("market") || androidMarket == null || TextUtils.isEmpty(androidMarket.market_url)) {
                        if (j0Var2.a(parse, this.f17924e.getInteractionType())) {
                            if (!this.f17928i && j0.f17912h == j0Var2) {
                                l0.a(str2, new c(j0Var2, context, this, parse, str2));
                                return true;
                            }
                            j0Var2.a(context, parse, this, this.f17924e);
                            WindAds.sharedAds().getHandler().post(new d(str2, j0Var2));
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                    this.f17921b.b(str2, j0Var2);
                }
            }
        }
        try {
            a(str2, j0Var, "Link ignored. Unable to handle url: ", null);
            return false;
        } catch (Throwable th2) {
            SigmobLog.e("handleResolvedUrl eroor", th2);
            return false;
        }
    }
}
