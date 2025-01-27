package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a */
    private static volatile StStrategyManager f16318a;

    /* renamed from: b */
    private static final byte[] f16319b = new byte[0];

    /* renamed from: c */
    private static AtomicBoolean f16320c = new AtomicBoolean(false);

    /* renamed from: com.opos.acs.st.utils.g$1 */
    static final class AnonymousClass1 implements UpdateSTConfigListener {

        /* renamed from: a */
        private /* synthetic */ String f16321a;

        /* renamed from: b */
        private /* synthetic */ Context f16322b;

        AnonymousClass1(String str, Context context) {
            str = str;
            context = context;
        }

        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
        public final void onFail() {
            g.f16320c.set(false);
            d.a("StrategyUtil", "onFail pkgName:" + str);
        }

        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
        public final void onNotNeedUpdate() {
            g.f16320c.set(false);
            d.a("StrategyUtil", "onNotNeedUpdate pkgName:" + str);
        }

        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
        public final void onSuccess() {
            d.a("StrategyUtil", "onSuccess pkgName:" + str);
            g.f16320c.set(false);
            h.h(context);
            h.g(context);
        }
    }

    /* renamed from: com.opos.acs.st.utils.g$2 */
    static final class AnonymousClass2 implements UpdateSTConfigListener {

        /* renamed from: a */
        private /* synthetic */ String f16323a;

        /* renamed from: b */
        private /* synthetic */ Context f16324b;

        AnonymousClass2(String str, Context context) {
            str = str;
            context = context;
        }

        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
        public final void onFail() {
            d.a("StrategyUtil", "onFail dataType:" + str);
        }

        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
        public final void onNotNeedUpdate() {
            d.a("StrategyUtil", "onNotNeedUpdate dataType:" + str);
        }

        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
        public final void onSuccess() {
            d.a("StrategyUtil", "onSuccess dataType:" + str);
            h.h(context);
            h.g(context);
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                a(context, context.getPackageName());
            } catch (Exception e2) {
                d.b("StrategyUtil", "", e2);
            }
        }
    }

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                f16320c.set(true);
                StStrategyManager.setStVerCode(330);
                c(context).updateSTConfigsByPkgName(new UpdateParams.Builder().setPkgName(str).build(), new UpdateSTConfigListener() { // from class: com.opos.acs.st.utils.g.1

                    /* renamed from: a */
                    private /* synthetic */ String f16321a;

                    /* renamed from: b */
                    private /* synthetic */ Context f16322b;

                    AnonymousClass1(String str2, Context context2) {
                        str = str2;
                        context = context2;
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onFail() {
                        g.f16320c.set(false);
                        d.a("StrategyUtil", "onFail pkgName:" + str);
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onNotNeedUpdate() {
                        g.f16320c.set(false);
                        d.a("StrategyUtil", "onNotNeedUpdate pkgName:" + str);
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onSuccess() {
                        d.a("StrategyUtil", "onSuccess pkgName:" + str);
                        g.f16320c.set(false);
                        h.h(context);
                        h.g(context);
                    }
                });
            } catch (Exception e2) {
                f16320c.set(false);
                d.b("StrategyUtil", "", e2);
            }
        }
    }

    public static STConfigEntity b(Context context) {
        STConfigEntity sTConfigEntity = null;
        if (context != null) {
            try {
                sTConfigEntity = c(context).getSTConfigEntity();
            } catch (Exception e2) {
                d.b("StrategyUtil", "", e2);
            }
            if (sTConfigEntity == null) {
                d.a("StrategyUtil", "get stConfigEntity == null");
            }
        }
        return sTConfigEntity;
    }

    public static void b(Context context, String str) {
        d.a("StrategyUtil", "update STConfigs By DataType");
        if (context != null) {
            try {
                if (f16320c.get()) {
                    d.a("StrategyUtil", "is not init success");
                } else {
                    StStrategyManager.setStVerCode(330);
                    c(context).updateSTConfigsByDataType(str, new UpdateSTConfigListener() { // from class: com.opos.acs.st.utils.g.2

                        /* renamed from: a */
                        private /* synthetic */ String f16323a;

                        /* renamed from: b */
                        private /* synthetic */ Context f16324b;

                        AnonymousClass2(String str2, Context context2) {
                            str = str2;
                            context = context2;
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                        public final void onFail() {
                            d.a("StrategyUtil", "onFail dataType:" + str);
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                        public final void onNotNeedUpdate() {
                            d.a("StrategyUtil", "onNotNeedUpdate dataType:" + str);
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                        public final void onSuccess() {
                            d.a("StrategyUtil", "onSuccess dataType:" + str);
                            h.h(context);
                            h.g(context);
                        }
                    });
                }
            } catch (Exception e2) {
                d.c("StrategyUtil", "", e2);
            }
        }
    }

    private static StStrategyManager c(Context context) {
        if (f16318a == null) {
            synchronized (f16319b) {
                if (f16318a == null) {
                    f16318a = StStrategyManager.getInstance(context);
                }
            }
        }
        return f16318a;
    }
}
