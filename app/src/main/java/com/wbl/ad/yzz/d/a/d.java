package com.wbl.ad.yzz.d.a;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.a0;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.network.b.b.l0;
import com.wbl.ad.yzz.network.b.b.t;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.network.b.b.v;
import com.wbl.ad.yzz.network.bean.request.BindcpnReq;
import com.wbl.ad.yzz.network.bean.request.GetAdDetLinfReq;
import com.wbl.ad.yzz.network.bean.request.GetConfReq;
import com.wbl.ad.yzz.network.bean.request.GetPageMsgReq;
import com.wbl.ad.yzz.network.bean.request.LeaveAdPageReq;
import com.wbl.ad.yzz.network.bean.request.UpRpNumbersReq;
import com.wbl.ad.yzz.network.bean.request.UploadFeedbackReq;
import com.wbl.ad.yzz.network.bean.request.WithdrawalCenterReq;
import com.wbl.ad.yzz.network.bean.response.RequestWithdrawalReq;
import com.wbl.ad.yzz.network.c.a;
import com.wbl.ad.yzz.network.c.d;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: b */
    @f.b.a.d
    public static final a f31815b = new a(null);

    /* renamed from: a */
    public static final b f31814a = new b();

    public static final class a {

        /* renamed from: com.wbl.ad.yzz.d.a.d$a$a */
        public static final class C0702a implements com.wbl.ad.yzz.d.a.b {

            /* renamed from: com.wbl.ad.yzz.d.a.d$a$a$a */
            public static final class C0703a implements d.b0<t> {

                /* renamed from: a */
                public final /* synthetic */ com.wbl.ad.yzz.b f31816a;

                public C0703a(com.wbl.ad.yzz.b bVar) {
                    this.f31816a = bVar;
                }

                public void a(String str, t tVar) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15323, this, str, tVar);
                }

                @Override // com.wbl.ad.yzz.network.c.d.b0
                public void onFailed(String str, String str2) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15318, this, str, str2);
                }

                @Override // com.wbl.ad.yzz.network.c.d.b0
                public /* bridge */ /* synthetic */ void onSuccess(String str, t tVar) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15317, this, str, tVar);
                }
            }

            @Override // com.wbl.ad.yzz.d.a.b
            public void a(Context context, GetAdDetLinfReq getAdDetLinfReq, com.wbl.ad.yzz.b<t> bVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15320, this, context, getAdDetLinfReq, bVar);
            }
        }

        public static final class b implements com.wbl.ad.yzz.d.a.c {

            /* renamed from: com.wbl.ad.yzz.d.a.d$a$b$a */
            public static final class C0704a implements d.b0<Object> {

                /* renamed from: a */
                public final /* synthetic */ com.wbl.ad.yzz.b f31817a;

                public C0704a(com.wbl.ad.yzz.b bVar) {
                    this.f31817a = bVar;
                }

                @Override // com.wbl.ad.yzz.network.c.d.b0
                public void onFailed(String str, String str2) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15319, this, str, str2);
                }

                @Override // com.wbl.ad.yzz.network.c.d.b0
                public void onSuccess(String str, Object obj) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15314, this, str, obj);
                }
            }

            /* renamed from: com.wbl.ad.yzz.d.a.d$a$b$b */
            public static final class C0705b implements d.b0<com.wbl.ad.yzz.network.b.a.b> {

                /* renamed from: a */
                public final /* synthetic */ com.wbl.ad.yzz.b f31818a;

                public C0705b(com.wbl.ad.yzz.b bVar) {
                    this.f31818a = bVar;
                }

                public void a(String str, com.wbl.ad.yzz.network.b.a.b bVar) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15313, this, str, bVar);
                }

                @Override // com.wbl.ad.yzz.network.c.d.b0
                public void onFailed(String str, String str2) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15316, this, str, str2);
                }

                @Override // com.wbl.ad.yzz.network.c.d.b0
                public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.a.b bVar) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15315, this, str, bVar);
                }
            }

            public static final class c implements d.b0<l0> {

                /* renamed from: a */
                public final /* synthetic */ com.wbl.ad.yzz.b f31819a;

                public c(com.wbl.ad.yzz.b bVar) {
                    this.f31819a = bVar;
                }

                public void a(String str, l0 l0Var) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14382, this, str, l0Var);
                }

                @Override // com.wbl.ad.yzz.network.c.d.b0
                public void onFailed(String str, String str2) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14381, this, str, str2);
                }

                @Override // com.wbl.ad.yzz.network.c.d.b0
                public /* bridge */ /* synthetic */ void onSuccess(String str, l0 l0Var) {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14384, this, str, l0Var);
                }
            }

            @Override // com.wbl.ad.yzz.d.a.c
            public void a(Context context, BindcpnReq bindcpnReq, com.wbl.ad.yzz.b<Object> bVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14383, this, context, bindcpnReq, bVar);
            }

            @Override // com.wbl.ad.yzz.d.a.c
            public void a(Context context, WithdrawalCenterReq withdrawalCenterReq, com.wbl.ad.yzz.b<l0> bVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14378, this, context, withdrawalCenterReq, bVar);
            }

            @Override // com.wbl.ad.yzz.d.a.c
            public void a(Context context, RequestWithdrawalReq requestWithdrawalReq, com.wbl.ad.yzz.b<com.wbl.ad.yzz.network.b.a.b> bVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14377, this, context, requestWithdrawalReq, bVar);
            }
        }

        public a() {
        }

        public final com.wbl.ad.yzz.d.a.a a() {
            return (com.wbl.ad.yzz.d.a.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14380, this, null);
        }

        public final com.wbl.ad.yzz.d.a.b b() {
            return (com.wbl.ad.yzz.d.a.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14379, this, null);
        }

        public final c c() {
            return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14374, this, null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements com.wbl.ad.yzz.d.a.a {

        /* renamed from: a */
        public final com.wbl.ad.yzz.network.c.a f31820a = new com.wbl.ad.yzz.network.c.a();

        public static final class a implements d.b0<k> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.b f31821a;

            public a(com.wbl.ad.yzz.b bVar) {
                this.f31821a = bVar;
            }

            public void a(String str, k kVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14373, this, str, kVar);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14376, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, k kVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14375, this, str, kVar);
            }
        }

        /* renamed from: com.wbl.ad.yzz.d.a.d$b$b */
        public static final class C0706b implements d.b0<u> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.b f31822a;

            public C0706b(com.wbl.ad.yzz.b bVar) {
                this.f31822a = bVar;
            }

            public void a(String str, u uVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14370, this, str, uVar);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14369, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, u uVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14372, this, str, uVar);
            }
        }

        public static final class c implements d.b0<u> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.b f31823a;

            public c(com.wbl.ad.yzz.b bVar) {
                this.f31823a = bVar;
            }

            public void a(String str, u uVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14371, this, str, uVar);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14398, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, u uVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14397, this, str, uVar);
            }
        }

        /* renamed from: com.wbl.ad.yzz.d.a.d$b$d */
        public static final class C0707d implements d.b0<a0> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.b f31824a;

            public C0707d(com.wbl.ad.yzz.b bVar) {
                this.f31824a = bVar;
            }

            public void a(String str, a0 a0Var) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14400, this, str, a0Var);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14399, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, a0 a0Var) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14394, this, str, a0Var);
            }
        }

        public static final class e implements a.InterfaceC0770a {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.adrequest.c.e f31825a;

            public e(com.wbl.ad.yzz.adrequest.c.e eVar) {
                this.f31825a = eVar;
            }

            @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
            public void loadAdError(int i2, String str) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14393, this, Integer.valueOf(i2), str);
            }

            @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
            public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14396, this, list);
            }
        }

        public static final class f implements d.b0<v> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f31826a;

            public f(com.wbl.ad.yzz.innerconfig.d.d dVar) {
                this.f31826a = dVar;
            }

            public void a(String str, v vVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14395, this, str, vVar);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14390, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, v vVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14389, this, str, vVar);
            }
        }

        public static final class g implements d.b0<k0> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.b f31827a;

            public g(com.wbl.ad.yzz.b bVar) {
                this.f31827a = bVar;
            }

            public void a(String str, k0 k0Var) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14392, this, str, k0Var);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14391, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, k0 k0Var) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14386, this, str, k0Var);
            }
        }

        public static final class h implements d.b0<Boolean> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.b f31828a;

            public h(com.wbl.ad.yzz.b bVar) {
                this.f31828a = bVar;
            }

            public void a(String str, Boolean bool) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14385, this, str, bool);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14388, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, Boolean bool) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14387, this, str, bool);
            }
        }

        @Override // com.wbl.ad.yzz.d.a.a
        public void a(Context context, int i2, int i3, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14350, this, context, Integer.valueOf(i2), Integer.valueOf(i3), dVar);
        }

        @Override // com.wbl.ad.yzz.d.a.a
        public void a(Context context, GetConfReq getConfReq, com.wbl.ad.yzz.b<k> bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14349, this, context, getConfReq, bVar);
        }

        @Override // com.wbl.ad.yzz.d.a.a
        public void a(Context context, GetPageMsgReq getPageMsgReq, com.wbl.ad.yzz.b<u> bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14352, this, context, getPageMsgReq, bVar);
        }

        @Override // com.wbl.ad.yzz.d.a.a
        public void a(Context context, LeaveAdPageReq leaveAdPageReq, com.wbl.ad.yzz.b<a0> bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14351, this, context, leaveAdPageReq, bVar);
        }

        @Override // com.wbl.ad.yzz.d.a.a
        public void a(Context context, UpRpNumbersReq upRpNumbersReq, com.wbl.ad.yzz.b<k0> bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14346, this, context, upRpNumbersReq, bVar);
        }

        @Override // com.wbl.ad.yzz.d.a.a
        public void a(Context context, UploadFeedbackReq uploadFeedbackReq, com.wbl.ad.yzz.b<Boolean> bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14345, this, context, uploadFeedbackReq, bVar);
        }

        @Override // com.wbl.ad.yzz.d.a.a
        public void a(com.wbl.ad.yzz.adrequest.c.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14348, this, eVar);
        }

        @Override // com.wbl.ad.yzz.d.a.a
        public void b(Context context, GetPageMsgReq getPageMsgReq, com.wbl.ad.yzz.b<u> bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14347, this, context, getPageMsgReq, bVar);
        }
    }

    public static final /* synthetic */ b a() {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14342, null, null);
    }
}
