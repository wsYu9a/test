package com.alimm.tanx.core.ad.event.track.expose;

import android.content.Context;
import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxExposerUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.tanx.exposer.achieve.AdMonitorType;
import hg.b;
import hg.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kg.a;
import org.json.JSONException;
import org.json.JSONObject;
import pg.c;

/* loaded from: classes.dex */
public class ExposeManager {
    private final IExposer tanxc_do;
    private final List<String> tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.event.track.expose.ExposeManager$1 */
    public class AnonymousClass1 implements NetWorkCallBack {
        final /* synthetic */ c tanxc_do;

        public AnonymousClass1(c cVar) {
            cVar = cVar;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            LogUtils.d("ExposeManager", str2);
            c cVar = cVar;
            if (cVar != null) {
                cVar.a(i10, str2);
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void succ(Object obj) {
            LogUtils.d("ExposeManager", JSON.toJSONString(obj));
            c cVar = cVar;
            if (cVar != null) {
                cVar.tanxc_do();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.event.track.expose.ExposeManager$2 */
    public class AnonymousClass2 implements a {
        public AnonymousClass2() {
        }

        @Override // kg.a
        public Looper tanxc_do() {
            return Looper.getMainLooper();
        }

        @Override // kg.a
        public void tanxc_if(int i10, String str, String str2, AdMonitorType adMonitorType, d dVar) {
            if (dVar != null) {
                LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + dVar.toString() + ";msg=" + str + ";code=" + i10);
                TanxExposerUt.sendMonitorFail(adMonitorType, str2, i10, str, dVar.a());
            }
        }

        @Override // kg.a
        public void tanxc_do(String str, AdMonitorType adMonitorType, d dVar) {
            if (dVar != null) {
                LogUtils.d("ExposeManager", "onExposeSuccess:url=" + str + ";exposeParams=" + dVar.toString());
                TanxExposerUt.sendMonitorSuc(adMonitorType, str, dVar.a());
            }
        }

        @Override // kg.a
        public void tanxc_do(int i10, String str, String str2, AdMonitorType adMonitorType, d dVar) {
            if (dVar != null) {
                LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + dVar.toString() + ";msg=" + str + ";code=" + i10);
                TanxExposerUt.sendMonitorFail(adMonitorType, str2, i10, str, dVar.a());
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.event.track.expose.ExposeManager$3 */
    public class AnonymousClass3 implements ExposeCallback {
        final /* synthetic */ ExposeCallback tanxc_do;
        final /* synthetic */ tanxc_if tanxc_if;

        public AnonymousClass3(ExposeCallback exposeCallback, tanxc_if tanxc_ifVar) {
            exposeCallback = exposeCallback;
            tanxc_ifVar = tanxc_ifVar;
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void onFail(int i10, String str, String str2) {
            ExposeManager.this.tanxc_if.remove(str2);
            tanxc_ifVar.tanxc_new();
            ExposeCallback exposeCallback = exposeCallback;
            if (exposeCallback != null) {
                exposeCallback.onFail(i10, str, str2);
            }
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void onSucceed(int i10, String str) {
            tanxc_ifVar.tanxc_do(true);
            ExposeManager.this.tanxc_if.remove(str);
            ExposeCallback exposeCallback = exposeCallback;
            if (exposeCallback != null) {
                exposeCallback.onSucceed(i10, str);
            }
        }

        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
        public void send(String str) {
            ExposeCallback exposeCallback = exposeCallback;
            if (exposeCallback != null) {
                exposeCallback.send(str);
            }
        }
    }

    public interface UtArgsNames {
        public static final String creativeId = "creative_id";
        public static final String interactType = "interact_type";
        public static final String nameSpace = "tanx";
        public static final String pid = "pid";
        public static final String reqId = "req_id";
        public static final String sessionId = "session_id";
        public static final String templateId = "template_id";
    }

    public static class tanxc_do {
        static volatile ExposeManager tanxc_do = new ExposeManager((byte) 0);
    }

    public /* synthetic */ ExposeManager(byte b10) {
        this();
    }

    private static boolean tanxc_if() {
        OrangeUtBean orangeUtBean;
        Boolean bool;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (bool = orangeUtBean.utTanxExposerSwitch) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private ExposeManager() {
        this.tanxc_do = new com.alimm.tanx.core.ad.event.track.expose.tanxc_do();
        this.tanxc_if = new ArrayList();
    }

    public static ExposeManager tanxc_do() {
        return tanxc_do.tanxc_do;
    }

    public void tanxc_do(Context context) {
        hg.c.c().a(context, new b.a(new pg.a() { // from class: u1.a
            public /* synthetic */ a() {
            }

            @Override // pg.a
            public final void a(pg.d dVar, c cVar) {
                ExposeManager.this.tanxc_do(dVar, cVar);
            }
        }, new rg.a() { // from class: u1.b
            @Override // rg.a
            public final void a(String str, int i10, Object obj, Object obj2, Object obj3, Map map) {
                ExposeManager.tanxc_do(str, i10, obj, obj2, obj3, map);
            }
        }).e(2001).m(true).g(true).f(sg.c.g(context), sg.c.b(context)).j(TanxCoreSdk.getConfig().isDebugMode()).h());
        hg.c.c().d(new a() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.2
            public AnonymousClass2() {
            }

            @Override // kg.a
            public Looper tanxc_do() {
                return Looper.getMainLooper();
            }

            @Override // kg.a
            public void tanxc_if(int i10, String str, String str2, AdMonitorType adMonitorType, d dVar) {
                if (dVar != null) {
                    LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + dVar.toString() + ";msg=" + str + ";code=" + i10);
                    TanxExposerUt.sendMonitorFail(adMonitorType, str2, i10, str, dVar.a());
                }
            }

            @Override // kg.a
            public void tanxc_do(String str, AdMonitorType adMonitorType, d dVar) {
                if (dVar != null) {
                    LogUtils.d("ExposeManager", "onExposeSuccess:url=" + str + ";exposeParams=" + dVar.toString());
                    TanxExposerUt.sendMonitorSuc(adMonitorType, str, dVar.a());
                }
            }

            @Override // kg.a
            public void tanxc_do(int i10, String str, String str2, AdMonitorType adMonitorType, d dVar) {
                if (dVar != null) {
                    LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + dVar.toString() + ";msg=" + str + ";code=" + i10);
                    TanxExposerUt.sendMonitorFail(adMonitorType, str2, i10, str, dVar.a());
                }
            }
        });
    }

    public /* synthetic */ void tanxc_do(pg.d dVar, c cVar) {
        if (dVar == null) {
            LogUtils.d("ExposeManager", "requestOptions is null");
            return;
        }
        RequestBean build = new RequestBean().setUrl(dVar.a()).build();
        build.setOverrideError(true);
        build.setTryAgainCount(dVar.b());
        NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.1
            final /* synthetic */ c tanxc_do;

            public AnonymousClass1(c cVar2) {
                cVar = cVar2;
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                LogUtils.d("ExposeManager", str2);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(i10, str2);
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void succ(Object obj) {
                LogUtils.d("ExposeManager", JSON.toJSONString(obj));
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.tanxc_do();
                }
            }
        });
    }

    public static /* synthetic */ void tanxc_do(String str, int i10, Object obj, Object obj2, Object obj3, Map map) {
        LogUtils.d("ExposeManager", "userTracker:page=" + str + ";eventId=" + i10 + ";arg1=" + obj + ";args" + sg.c.e(map));
        if (tanxc_if()) {
            TanxBaseUt.track(str, null, null, i10, 0, (String) obj, (String) obj2, (String) obj3, map, null);
        } else {
            LogUtils.d("ExposeManager", "埋点开关关闭，终止上报");
        }
    }

    public void tanxc_do(BidInfo bidInfo, String str, String str2, List<String> list) {
        try {
            LogUtils.d("ExposeManager", "exposeVideo3S ing reqId:" + str + " pid :" + str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UtArgsNames.pid, str2);
            jSONObject.put(UtArgsNames.reqId, str);
            jSONObject.put("session_id", bidInfo.getSessionId());
            jSONObject.put(UtArgsNames.templateId, bidInfo.getTemplateId());
            jSONObject.put(UtArgsNames.creativeId, bidInfo.getCreativeId());
            jSONObject.put(UtArgsNames.interactType, bidInfo.getInteractType2Int());
            hg.c.c().f(list, new d.a().a(UtArgsNames.nameSpace).f(str2).b(jSONObject).c());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public void tanxc_do(BidInfo bidInfo, String str, String str2, AdMonitorType adMonitorType, List<tanxc_if> list, ExposeCallback exposeCallback) {
        if (OrangeManager.getInstance().getCommonSwitch("useNewExposerSwitch")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UtArgsNames.pid, str2);
                jSONObject.put(UtArgsNames.reqId, str);
                jSONObject.put("session_id", bidInfo.getSessionId());
                jSONObject.put(UtArgsNames.templateId, bidInfo.getTemplateId());
                jSONObject.put(UtArgsNames.creativeId, bidInfo.getCreativeId());
                jSONObject.put(UtArgsNames.interactType, bidInfo.getInteractType2Int());
                d c10 = new d.a().a(UtArgsNames.nameSpace).f(str2).b(jSONObject).c();
                if (adMonitorType == AdMonitorType.EXPOSE) {
                    hg.c.c().b(bidInfo.getImpTrackUrl(), c10);
                } else if (adMonitorType == AdMonitorType.CLICK) {
                    hg.c.c().g(bidInfo.getClickTrackUrl(), c10);
                }
                return;
            } catch (JSONException e10) {
                e10.printStackTrace();
                return;
            }
        }
        tanxc_do(bidInfo, list, exposeCallback);
    }

    public void tanxc_do(IBidInfo iBidInfo, List<tanxc_if> list, ExposeCallback exposeCallback) {
        if (iBidInfo != null && list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                tanxc_if tanxc_ifVar = list.get(i10);
                if (tanxc_ifVar != null) {
                    String tanxc_do2 = tanxc_ifVar.tanxc_do();
                    if (tanxc_ifVar.tanxc_int()) {
                        if (!tanxc_ifVar.tanxc_for() && !tanxc_ifVar.tanxc_try() && !this.tanxc_if.contains(tanxc_do2)) {
                            this.tanxc_if.add(tanxc_do2);
                        }
                    }
                    this.tanxc_do.onExpose(tanxc_ifVar.tanxc_if(), tanxc_do2, new ExposeCallback() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.3
                        final /* synthetic */ ExposeCallback tanxc_do;
                        final /* synthetic */ tanxc_if tanxc_if;

                        public AnonymousClass3(ExposeCallback exposeCallback2, tanxc_if tanxc_ifVar2) {
                            exposeCallback = exposeCallback2;
                            tanxc_ifVar = tanxc_ifVar2;
                        }

                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void onFail(int i102, String str, String str2) {
                            ExposeManager.this.tanxc_if.remove(str2);
                            tanxc_ifVar.tanxc_new();
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.onFail(i102, str, str2);
                            }
                        }

                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void onSucceed(int i102, String str) {
                            tanxc_ifVar.tanxc_do(true);
                            ExposeManager.this.tanxc_if.remove(str);
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.onSucceed(i102, str);
                            }
                        }

                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void send(String str) {
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.send(str);
                            }
                        }
                    });
                }
            }
            return;
        }
        String str = "";
        String str2 = iBidInfo == null ? " bidInfo == null" : "";
        if (list == null) {
            str2 = str2 + " monitorInfoList == null";
        } else if (list.size() <= 0) {
            str2 = str2 + " monitorInfoList size <= 0";
        } else {
            str = list.toString();
        }
        if (exposeCallback2 != null) {
            exposeCallback2.onFail(UtErrorCode.IMP_URL_ERROR.getIntCode(), str2, str);
        }
    }
}
