package com.wbl.ad.yzz.network.c;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.config.PageOptions;
import com.wbl.ad.yzz.network.b.b.d0;
import com.wbl.ad.yzz.network.b.b.f0;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.network.b.b.l0;
import com.wbl.ad.yzz.network.bean.request.AdCallBackReq;
import com.wbl.ad.yzz.network.bean.request.BindcpnReq;
import com.wbl.ad.yzz.network.bean.request.DetailAdReq;
import com.wbl.ad.yzz.network.bean.request.GetAdDetLinfReq;
import com.wbl.ad.yzz.network.bean.request.GetConfReq;
import com.wbl.ad.yzz.network.bean.request.GetPageMsgReq;
import com.wbl.ad.yzz.network.bean.request.GetXyzConfReq;
import com.wbl.ad.yzz.network.bean.request.LeaveAdPageReq;
import com.wbl.ad.yzz.network.bean.request.UpRpNumbersReq;
import com.wbl.ad.yzz.network.bean.request.UploadFeedbackReq;
import com.wbl.ad.yzz.network.bean.request.WithdrawalCenterReq;
import com.wbl.ad.yzz.network.bean.response.RequestWithdrawalReq;
import com.wbl.ad.yzz.network.result.ActionData;
import java.util.Map;

/* loaded from: classes5.dex */
public class d {
    public static volatile String k;

    /* renamed from: a */
    @SuppressLint({"StaticFieldLeak"})
    public Context f33629a;

    /* renamed from: b */
    public String f33630b;

    /* renamed from: c */
    public String f33631c;

    /* renamed from: d */
    public String f33632d;

    /* renamed from: e */
    public int f33633e;

    /* renamed from: f */
    public int f33634f;

    /* renamed from: g */
    public String f33635g;

    /* renamed from: h */
    public String f33636h;

    /* renamed from: i */
    public String f33637i;

    /* renamed from: j */
    public final com.wbl.ad.yzz.bean.o f33638j;

    public class a extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.m> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33639e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33639e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10283, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.m mVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10278, this, str, mVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.m mVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10277, this, str, mVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10280, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10279, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10274, this, null);
        }
    }

    public static final class a0 {

        /* renamed from: a */
        public static final d f33640a = new d(null);

        public static /* synthetic */ d a() {
            return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11217, null, null);
        }
    }

    public class b extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.n> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33641e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33641e = b0Var;
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.n nVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10273, this, str, nVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.n nVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10276, this, str, nVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10275, this, str, str2);
        }
    }

    public interface b0<M> {
        void onFailed(String str, String str2);

        void onSuccess(String str, M m);
    }

    public class c extends com.wbl.ad.yzz.network.d.e<String> {
        public c(d dVar, Context context, Class cls) {
            super(context, cls);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10302, this, actionData);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10301, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        /* renamed from: a */
        public void a2(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10304, this, str, str2);
        }

        public void b(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10303, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10298, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10297, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.network.c.d$d */
    public class C0771d extends com.wbl.ad.yzz.network.d.e<String> {
        public C0771d(d dVar, Context context, Class cls) {
            super(context, cls);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10300, this, actionData);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10299, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        /* renamed from: a */
        public void a2(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10294, this, str, str2);
        }

        public void b(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10293, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10296, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10295, this, null);
        }
    }

    public class e extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.k> {

        /* renamed from: e */
        public final /* synthetic */ GetConfReq f33642e;

        /* renamed from: f */
        public final /* synthetic */ b0 f33643f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, Context context, Class cls, GetConfReq getConfReq, b0 b0Var) {
            super(context, cls);
            this.f33642e = getConfReq;
            this.f33643f = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10290, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.k kVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10289, this, str, kVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.k kVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10292, this, str, kVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10291, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10254, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10253, this, null);
        }
    }

    public class f extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.w> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33644e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33644e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10256, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10255, this, str, wVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10250, this, str, wVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10249, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10252, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10251, this, null);
        }
    }

    public class g extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.w> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33645e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33645e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10246, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10245, this, str, wVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.w wVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10248, this, str, wVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10247, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10242, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10241, this, null);
        }
    }

    public class h extends com.wbl.ad.yzz.network.d.e<d0> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33646e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33646e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10244, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, d0 d0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10243, this, str, d0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, d0 d0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10270, this, str, d0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10269, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10272, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10271, this, null);
        }
    }

    public class i extends com.wbl.ad.yzz.network.d.e<d0> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33647e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33647e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10266, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, d0 d0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10265, this, str, d0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, d0 d0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10268, this, str, d0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10267, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10262, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10261, this, null);
        }
    }

    public class j extends com.wbl.ad.yzz.network.d.e<Object> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33648e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33648e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, Object obj) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10264, this, str, obj);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10263, this, str, str2);
        }
    }

    public class k extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.a> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33649e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33649e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10258, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10257, this, str, aVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10260, this, str, aVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10259, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10350, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10349, this, null);
        }
    }

    public class l extends com.wbl.ad.yzz.network.d.e<f0> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33650e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33650e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10352, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, f0 f0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10351, this, str, f0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, f0 f0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10346, this, str, f0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10345, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10348, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10347, this, null);
        }
    }

    public class m extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.b0> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33651e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33651e = b0Var;
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.b0 b0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10342, this, str, b0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.b0 b0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10341, this, str, b0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10344, this, str, str2);
        }
    }

    public class n extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.s> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33652e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33652e = b0Var;
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.s sVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10343, this, str, sVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.s sVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10338, this, str, sVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10337, this, str, str2);
        }
    }

    public class o extends com.wbl.ad.yzz.network.d.e<Object> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33653e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33653e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, Object obj) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10340, this, str, obj);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10339, this, str, str2);
        }
    }

    public class p implements com.wbl.ad.yzz.network.d.c<String, String> {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.d.b f33654a;

        public p(d dVar, com.wbl.ad.yzz.network.d.b bVar) {
            this.f33654a = bVar;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.String] */
        @Override // com.wbl.ad.yzz.network.d.c
        public /* bridge */ /* synthetic */ String a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10366, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.c
        public /* bridge */ /* synthetic */ void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10365, this, str);
        }

        /* renamed from: a */
        public void a2(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10368, this, str);
        }

        public String b() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10367, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.c
        public void remove() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10362, this, null);
        }
    }

    public class q extends com.wbl.ad.yzz.network.d.a<com.wbl.ad.yzz.network.b.b.t> {

        /* renamed from: g */
        public final /* synthetic */ b0 f33655g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(d dVar, Context context, Class cls, com.wbl.ad.yzz.network.d.c cVar, b0 b0Var) {
            super(context, cls, cVar);
            this.f33655g = b0Var;
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.t tVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10359, this, str, tVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, Object obj) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10354, this, str, obj);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10353, this, str, str2);
        }
    }

    public class r extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.r> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33656e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33656e = b0Var;
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10356, this, str, rVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10355, this, str, rVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10318, this, str, str2);
        }
    }

    public class s extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.u> {

        /* renamed from: e */
        public final /* synthetic */ Context f33657e;

        /* renamed from: f */
        public final /* synthetic */ b0 f33658f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(d dVar, Context context, Class cls, Context context2, b0 b0Var) {
            super(context, cls);
            this.f33657e = context2;
            this.f33658f = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10317, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.u uVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10320, this, str, uVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.u uVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10319, this, str, uVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10314, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10313, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10316, this, null);
        }
    }

    public class t implements b0<com.wbl.ad.yzz.network.b.b.u> {

        /* renamed from: a */
        public final /* synthetic */ b0 f33659a;

        /* renamed from: b */
        public final /* synthetic */ Context f33660b;

        /* renamed from: c */
        public final /* synthetic */ PageOptions f33661c;

        public class a implements b0<f0> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.network.b.b.u f33663a;

            /* renamed from: b */
            public final /* synthetic */ String f33664b;

            public a(com.wbl.ad.yzz.network.b.b.u uVar, String str) {
                this.f33663a = uVar;
                this.f33664b = str;
            }

            public void a(String str, f0 f0Var) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10315, this, str, f0Var);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10310, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, f0 f0Var) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10309, this, str, f0Var);
            }
        }

        public t(b0 b0Var, Context context, PageOptions pageOptions) {
            this.f33659a = b0Var;
            this.f33660b = context;
            this.f33661c = pageOptions;
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.u uVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10312, this, str, uVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10311, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.u uVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10306, this, str, uVar);
        }
    }

    public class u extends com.wbl.ad.yzz.network.d.e<k0> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33666e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33666e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10305, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, k0 k0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10308, this, str, k0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, k0 k0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10307, this, str, k0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10334, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10333, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10336, this, null);
        }
    }

    public class v extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.a0> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33667e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33667e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10335, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.a0 a0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10330, this, str, a0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.a0 a0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10329, this, str, a0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10332, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10331, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10326, this, null);
        }
    }

    public class w extends com.wbl.ad.yzz.network.d.e<l0> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33668e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33668e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10325, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, l0 l0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10328, this, str, l0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, l0 l0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10327, this, str, l0Var);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10322, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10321, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10324, this, null);
        }
    }

    public class x extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.a.b> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33669e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33669e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10323, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.a.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10414, this, str, bVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.a.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10413, this, str, bVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10416, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10415, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10410, this, null);
        }
    }

    public class y extends com.wbl.ad.yzz.network.d.e<com.wbl.ad.yzz.network.b.b.v> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33670e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33670e = b0Var;
        }

        /* renamed from: a */
        public void a2(String str, com.wbl.ad.yzz.network.b.b.v vVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10409, this, str, vVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, com.wbl.ad.yzz.network.b.b.v vVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10412, this, str, vVar);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10411, this, str, str2);
        }
    }

    public class z extends com.wbl.ad.yzz.network.d.e<Boolean> {

        /* renamed from: e */
        public final /* synthetic */ b0 f33671e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(d dVar, Context context, Class cls, b0 b0Var) {
            super(context, cls);
            this.f33671e = b0Var;
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(ActionData actionData) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10406, this, actionData);
        }

        /* renamed from: a */
        public void a2(String str, Boolean bool) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10405, this, str, bool);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public /* bridge */ /* synthetic */ void a(String str, Boolean bool) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10408, this, str, bool);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void a(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10407, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10402, this, null);
        }

        @Override // com.wbl.ad.yzz.network.d.e
        public boolean d() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10401, this, null);
        }
    }

    static {
        e();
    }

    public /* synthetic */ d(k kVar) {
        this();
    }

    public static d c() {
        return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10404, null, null);
    }

    public static void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10403, null, null);
    }

    public final GetPageMsgReq a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return (GetPageMsgReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10430, this, context, dVar);
    }

    public final GetPageMsgReq a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, PageOptions pageOptions) {
        return (GetPageMsgReq) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10429, this, context, dVar, pageOptions);
    }

    public final String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10432, this, null);
    }

    public final String a(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10431, this, context);
    }

    public String a(Context context, long j2) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10426, this, context, Long.valueOf(j2));
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10425, this, Integer.valueOf(i2));
    }

    public void a(int i2, com.wbl.ad.yzz.innerconfig.d.d dVar, b0<d0> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10428, this, Integer.valueOf(i2), dVar, b0Var);
    }

    public void a(Context context, int i2, com.wbl.ad.yzz.innerconfig.d.d dVar, b0 b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10427, this, context, Integer.valueOf(i2), dVar, b0Var);
    }

    public void a(Context context, PageOptions pageOptions, GetPageMsgReq getPageMsgReq, b0<com.wbl.ad.yzz.network.b.b.u> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10422, this, context, pageOptions, getPageMsgReq, b0Var);
    }

    public void a(Context context, PageOptions pageOptions, b0<f0> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10421, this, context, pageOptions, b0Var);
    }

    public void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, b0<com.wbl.ad.yzz.network.b.b.w> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10424, this, context, dVar, b0Var);
    }

    public void a(Context context, com.wbl.ad.yzz.network.b.a.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10423, this, context, aVar);
    }

    public void a(Context context, com.wbl.ad.yzz.network.b.a.a aVar, b0<com.wbl.ad.yzz.network.b.b.n> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10418, this, context, aVar, b0Var);
    }

    public void a(Context context, AdCallBackReq adCallBackReq, b0<Object> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10417, this, context, adCallBackReq, b0Var);
    }

    public void a(Context context, BindcpnReq bindcpnReq, b0<Object> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10420, this, context, bindcpnReq, b0Var);
    }

    public void a(Context context, DetailAdReq detailAdReq, b0<com.wbl.ad.yzz.network.b.b.m> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10419, this, context, detailAdReq, b0Var);
    }

    public void a(Context context, GetAdDetLinfReq getAdDetLinfReq, b0<com.wbl.ad.yzz.network.b.b.t> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10382, this, context, getAdDetLinfReq, b0Var);
    }

    public void a(Context context, GetConfReq getConfReq, b0<com.wbl.ad.yzz.network.b.b.k> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10381, this, context, getConfReq, b0Var);
    }

    public final void a(Context context, GetPageMsgReq getPageMsgReq) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10384, this, context, getPageMsgReq);
    }

    public void a(Context context, GetPageMsgReq getPageMsgReq, b0<com.wbl.ad.yzz.network.b.b.u> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10383, this, context, getPageMsgReq, b0Var);
    }

    public void a(Context context, GetXyzConfReq getXyzConfReq, b0<com.wbl.ad.yzz.network.b.b.v> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10378, this, context, getXyzConfReq, b0Var);
    }

    public void a(Context context, LeaveAdPageReq leaveAdPageReq, b0<com.wbl.ad.yzz.network.b.b.a0> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10377, this, context, leaveAdPageReq, b0Var);
    }

    public void a(Context context, UpRpNumbersReq upRpNumbersReq, b0<k0> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10380, this, context, upRpNumbersReq, b0Var);
    }

    public void a(Context context, UploadFeedbackReq uploadFeedbackReq, b0<Boolean> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10379, this, context, uploadFeedbackReq, b0Var);
    }

    public void a(Context context, WithdrawalCenterReq withdrawalCenterReq, b0<l0> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10374, this, context, withdrawalCenterReq, b0Var);
    }

    public void a(Context context, RequestWithdrawalReq requestWithdrawalReq, b0<com.wbl.ad.yzz.network.b.a.b> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10373, this, context, requestWithdrawalReq, b0Var);
    }

    public final void a(com.wbl.ad.yzz.bean.b bVar, int i2, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10376, this, bVar, Integer.valueOf(i2), str);
    }

    public void a(com.wbl.ad.yzz.bean.b bVar, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10375, this, bVar, str);
    }

    public void a(PageOptions pageOptions, com.wbl.ad.yzz.innerconfig.d.d dVar, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10370, this, pageOptions, dVar, Boolean.valueOf(z2));
    }

    public void a(com.wbl.ad.yzz.network.b.b.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10369, this, aVar);
    }

    public void a(b0<com.wbl.ad.yzz.network.b.b.s> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10372, this, b0Var);
    }

    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10371, this, str);
    }

    public final void a(String str, Map<String, Object> map) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10398, this, str, map);
    }

    public final boolean a(Context context, b0 b0Var) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10397, this, context, b0Var);
    }

    public final boolean a(Object obj) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10400, this, obj);
    }

    public final boolean a(Object obj, Context context, b0 b0Var) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10399, this, obj, context, b0Var);
    }

    public final String b() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10394, this, null);
    }

    public final String b(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10393, this, context);
    }

    public void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10396, this, Integer.valueOf(i2));
    }

    public void b(int i2, com.wbl.ad.yzz.innerconfig.d.d dVar, b0<d0> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10395, this, Integer.valueOf(i2), dVar, b0Var);
    }

    public void b(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, b0<com.wbl.ad.yzz.network.b.b.w> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10390, this, context, dVar, b0Var);
    }

    public void b(Context context, GetPageMsgReq getPageMsgReq, b0<com.wbl.ad.yzz.network.b.b.u> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10389, this, context, getPageMsgReq, b0Var);
    }

    public void b(Context context, b0<com.wbl.ad.yzz.network.b.b.a> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10392, this, context, b0Var);
    }

    public void b(com.wbl.ad.yzz.bean.b bVar, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10391, this, bVar, str);
    }

    public final void b(PageOptions pageOptions, com.wbl.ad.yzz.innerconfig.d.d dVar, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10386, this, pageOptions, dVar, Boolean.valueOf(z2));
    }

    public void b(b0<com.wbl.ad.yzz.network.b.b.b0> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10385, this, b0Var);
    }

    public void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10388, this, str);
    }

    public final void c(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10387, this, context);
    }

    public void c(Context context, GetPageMsgReq getPageMsgReq, b0<com.wbl.ad.yzz.network.b.b.u> b0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10478, this, context, getPageMsgReq, b0Var);
    }

    public final int d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10477, this, null);
    }

    public void d(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10480, this, context);
    }

    public void e(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10479, this, context);
    }

    public void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10474, this, null);
    }

    public final synchronized void f(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10473, this, context);
    }

    public d() {
        this.f33634f = 0;
        this.f33635g = "";
        this.f33636h = "";
        this.f33637i = "";
        this.f33638j = new com.wbl.ad.yzz.bean.d();
    }
}
