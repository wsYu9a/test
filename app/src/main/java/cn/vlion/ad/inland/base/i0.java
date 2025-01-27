package cn.vlion.ad.inland.base;

import android.view.MotionEvent;
import android.view.View;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class i0 implements View.OnTouchListener {

    /* renamed from: a */
    public float f2888a;

    /* renamed from: b */
    public float f2889b;

    /* renamed from: c */
    public float f2890c;

    /* renamed from: d */
    public float f2891d;

    /* renamed from: e */
    public float f2892e;

    /* renamed from: f */
    public float f2893f;

    /* renamed from: g */
    public float f2894g;

    /* renamed from: h */
    public float f2895h;

    /* renamed from: i */
    public float f2896i;

    /* renamed from: j */
    public float f2897j;

    /* renamed from: k */
    public volatile b f2898k;

    /* renamed from: l */
    public String f2899l;

    /* renamed from: m */
    public boolean f2900m;

    /* renamed from: n */
    public VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f2901n;

    /* renamed from: o */
    public int f2902o;

    /* renamed from: p */
    public int f2903p;

    /* renamed from: q */
    public k6 f2904q;

    /* renamed from: r */
    public m6 f2905r;

    /* renamed from: s */
    public o6 f2906s;

    /* renamed from: t */
    public boolean f2907t;

    /* renamed from: u */
    public String f2908u;

    /* renamed from: v */
    public long f2909v;

    /* renamed from: w */
    public long f2910w;

    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ b f2911a;

        public a(b bVar) {
            this.f2911a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                b bVar = this.f2911a;
                if (bVar != null) {
                    i0 i0Var = i0.this;
                    i0Var.f2908u = "click";
                    bVar.a("click", i0Var.f2901n);
                    LogVlion.e("端策略 : ViewOnTouchDataUtils-= 点击==");
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public interface b {
        void a(String str, VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean);
    }

    public i0() {
        this.f2888a = 0.0f;
        this.f2889b = 0.0f;
        this.f2890c = 0.0f;
        this.f2891d = 0.0f;
        this.f2892e = 0.0f;
        this.f2893f = 0.0f;
        this.f2894g = 0.0f;
        this.f2895h = 0.0f;
        this.f2896i = 0.0f;
        this.f2897j = 0.0f;
        this.f2899l = "初始值";
        this.f2900m = false;
        this.f2902o = 0;
        this.f2903p = 0;
        this.f2908u = "click";
        this.f2909v = 0L;
        this.f2910w = 0L;
        this.f2907t = true;
    }

    public final void a() {
        try {
            k6 k6Var = this.f2904q;
            if (k6Var != null) {
                k6Var.destroy();
                this.f2904q = null;
            }
            m6 m6Var = this.f2905r;
            if (m6Var != null) {
                m6Var.destroy();
                this.f2905r = null;
            }
            o6 o6Var = this.f2906s;
            if (o6Var != null) {
                o6Var.destroy();
                this.f2906s = null;
            }
            LogVlion.e("端策略 : ViewOnTouchDataUtils destroy: ");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final String b() {
        String str = this.f2888a + "," + this.f2889b;
        y.a("ViewOnTouchDataUtils getRawXY=", str);
        return str;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10 = false;
        if (motionEvent != null) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f2909v = System.currentTimeMillis();
                    this.f2888a = motionEvent.getRawX();
                    this.f2889b = motionEvent.getRawY();
                    this.f2894g = motionEvent.getX();
                    this.f2895h = motionEvent.getY();
                    this.f2900m = false;
                    LogVlion.e("ViewOnTouchDataUtils-=  event.getRawX() ==" + motionEvent.getRawX());
                    LogVlion.e("ViewOnTouchDataUtils-=  event.getRawY() ==" + motionEvent.getRawY());
                    LogVlion.e("ViewOnTouchDataUtils-=  MotionEvent.ACTION_DOWN ==");
                }
                if (motionEvent.getAction() == 2) {
                    LogVlion.e("ViewOnTouchDataUtils-=  MotionEvent.ACTION_MOVE ==");
                    LogVlion.e("ViewOnTouchDataUtils-=  v.getId() ==" + view.getId());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ViewOnTouchDataUtils-=  onSwipeListener ==");
                    sb2.append(this.f2898k != null);
                    sb2.append(this.f2899l);
                    LogVlion.e(sb2.toString());
                    this.f2892e = motionEvent.getX() - this.f2894g;
                    this.f2893f = motionEvent.getY() - this.f2895h;
                    if (this.f2898k != null) {
                        z10 = a(motionEvent);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    this.f2910w = System.currentTimeMillis();
                    this.f2890c = motionEvent.getRawX();
                    this.f2891d = motionEvent.getRawY();
                    this.f2896i = motionEvent.getX();
                    this.f2897j = motionEvent.getY();
                    LogVlion.e("ViewOnTouchDataUtils-=  MotionEvent.ACTION_UP ==");
                    if (this.f2900m) {
                        LogVlion.e("ViewOnTouchDataUtils-= 已触发滑动 拦截 Click==");
                        z10 = true;
                    }
                }
            } catch (Throwable th2) {
                LogVlion.e("ViewOnTouchDataUtils Exception=" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        LogVlion.e("ViewOnTouchDataUtils-=  isonTouch ==" + z10);
        return z10;
    }

    public i0(View view) {
        this.f2888a = 0.0f;
        this.f2889b = 0.0f;
        this.f2890c = 0.0f;
        this.f2891d = 0.0f;
        this.f2892e = 0.0f;
        this.f2893f = 0.0f;
        this.f2894g = 0.0f;
        this.f2895h = 0.0f;
        this.f2896i = 0.0f;
        this.f2897j = 0.0f;
        this.f2899l = "初始值";
        this.f2900m = false;
        this.f2902o = 0;
        this.f2903p = 0;
        this.f2907t = false;
        this.f2908u = "click";
        this.f2909v = 0L;
        this.f2910w = 0L;
        if (view == null) {
            return;
        }
        try {
            view.setOnTouchListener(this);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0126 A[Catch: all -> 0x001e, TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:3:0x0003, B:5:0x0007, B:9:0x0023, B:11:0x0027, B:13:0x006c, B:15:0x007c, B:17:0x0089, B:21:0x0097, B:23:0x009b, B:25:0x00a8, B:29:0x00b6, B:35:0x00ff, B:37:0x0103, B:39:0x0107, B:43:0x0114, B:45:0x0126, B:48:0x0131, B:50:0x0143, B:54:0x0150, B:56:0x0162, B:59:0x016d, B:61:0x017f, B:62:0x01a9, B:67:0x0197), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.i0.a(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00fa A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:4:0x0004, B:6:0x0025, B:8:0x0029, B:9:0x0038, B:11:0x00af, B:13:0x00fa, B:14:0x010d, B:16:0x0115, B:17:0x0128, B:19:0x0147, B:21:0x014b, B:31:0x0049, B:32:0x00ac, B:33:0x004e, B:35:0x0055, B:37:0x0059, B:38:0x0064, B:44:0x0075, B:45:0x007a, B:47:0x0081, B:49:0x0088, B:51:0x008c, B:52:0x0097, B:58:0x00a8, B:41:0x0068, B:55:0x009b, B:28:0x003c), top: B:3:0x0004, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0115 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:4:0x0004, B:6:0x0025, B:8:0x0029, B:9:0x0038, B:11:0x00af, B:13:0x00fa, B:14:0x010d, B:16:0x0115, B:17:0x0128, B:19:0x0147, B:21:0x014b, B:31:0x0049, B:32:0x00ac, B:33:0x004e, B:35:0x0055, B:37:0x0059, B:38:0x0064, B:44:0x0075, B:45:0x007a, B:47:0x0081, B:49:0x0088, B:51:0x008c, B:52:0x0097, B:58:0x00a8, B:41:0x0068, B:55:0x009b, B:28:0x003c), top: B:3:0x0004, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0147 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:4:0x0004, B:6:0x0025, B:8:0x0029, B:9:0x0038, B:11:0x00af, B:13:0x00fa, B:14:0x010d, B:16:0x0115, B:17:0x0128, B:19:0x0147, B:21:0x014b, B:31:0x0049, B:32:0x00ac, B:33:0x004e, B:35:0x0055, B:37:0x0059, B:38:0x0064, B:44:0x0075, B:45:0x007a, B:47:0x0081, B:49:0x0088, B:51:0x008c, B:52:0x0097, B:58:0x00a8, B:41:0x0068, B:55:0x009b, B:28:0x003c), top: B:3:0x0004, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.ViewGroup r4, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean r5, cn.vlion.ad.inland.base.i0.b r6) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.i0.a(android.view.ViewGroup, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$McBean$CsBean, cn.vlion.ad.inland.base.i0$b):void");
    }
}
