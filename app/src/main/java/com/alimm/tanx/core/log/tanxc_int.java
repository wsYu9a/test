package com.alimm.tanx.core.log;

import android.util.Log;
import com.alimm.tanx.core.ad.bean.LogSwitchBean;
import com.alimm.tanx.core.ad.bean.RequestUploadLogSwitchBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.UploadLogSwitchRequest;
import com.alimm.tanx.core.ut.core.LifeCycleManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class tanxc_int implements ILog {
    private static volatile tanxc_int tanxc_for;
    private volatile LogSwitchBean tanxc_int;
    public String tanxc_do = "LogManager";
    protected tanxc_for tanxc_if = new tanxc_for();
    private volatile boolean tanxc_new = false;
    private int tanxc_try = 2000;

    /* renamed from: com.alimm.tanx.core.log.tanxc_int$1 */
    public class AnonymousClass1 implements LifeCycleManager.AppVisibleCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
        public void appVisibleCallBack(boolean z10, boolean z11) {
            String str = tanxc_int.this.tanxc_do;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("当前前后台状态：->");
            sb2.append(z10 ? "后台" : "前台");
            sb2.append(",是否由后台切换到前台：");
            sb2.append(z11);
            Log.d(str, sb2.toString());
            if (z10) {
                tanxc_int.this.tanxc_for();
            }
            if (z11) {
                tanxc_int.tanxc_int();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.log.tanxc_int$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: com.alimm.tanx.core.log.tanxc_int$2$1 */
        public class AnonymousClass1 implements NetWorkCallBack<LogSwitchBean> {
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                Log.d(tanxc_int.this.tanxc_do, "loopItem error：" + str2);
                tanxc_int.this.tanxc_case();
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(LogSwitchBean logSwitchBean) {
                Boolean bool;
                if (logSwitchBean == null || (bool = logSwitchBean.logUploadSwitch) == null || !bool.booleanValue()) {
                    tanxc_int.this.tanxc_case();
                    return;
                }
                Log.d(tanxc_int.this.tanxc_do, "loopItem succ");
                tanxc_int.this.tanxc_int = logSwitchBean;
                tanxc_int.this.uploadLog();
                tanxc_int.this.tanxc_new = false;
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(tanxc_int.this.tanxc_do, "loopItem");
            new UploadLogSwitchRequest().request(new RequestUploadLogSwitchBean(), (NetWorkCallBack<LogSwitchBean>) new NetWorkCallBack<LogSwitchBean>() { // from class: com.alimm.tanx.core.log.tanxc_int.2.1
                public AnonymousClass1() {
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void error(int i10, String str, String str2) {
                    Log.d(tanxc_int.this.tanxc_do, "loopItem error：" + str2);
                    tanxc_int.this.tanxc_case();
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                /* renamed from: tanxc_do */
                public void succ(LogSwitchBean logSwitchBean) {
                    Boolean bool;
                    if (logSwitchBean == null || (bool = logSwitchBean.logUploadSwitch) == null || !bool.booleanValue()) {
                        tanxc_int.this.tanxc_case();
                        return;
                    }
                    Log.d(tanxc_int.this.tanxc_do, "loopItem succ");
                    tanxc_int.this.tanxc_int = logSwitchBean;
                    tanxc_int.this.uploadLog();
                    tanxc_int.this.tanxc_new = false;
                }
            });
        }
    }

    private synchronized void tanxc_byte() {
        if (!this.tanxc_new) {
            this.tanxc_new = true;
            tanxc_case();
        }
    }

    public void tanxc_case() {
        tanxc_for.tanxc_do(new Runnable() { // from class: com.alimm.tanx.core.log.tanxc_int.2

            /* renamed from: com.alimm.tanx.core.log.tanxc_int$2$1 */
            public class AnonymousClass1 implements NetWorkCallBack<LogSwitchBean> {
                public AnonymousClass1() {
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void error(int i10, String str, String str2) {
                    Log.d(tanxc_int.this.tanxc_do, "loopItem error：" + str2);
                    tanxc_int.this.tanxc_case();
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                /* renamed from: tanxc_do */
                public void succ(LogSwitchBean logSwitchBean) {
                    Boolean bool;
                    if (logSwitchBean == null || (bool = logSwitchBean.logUploadSwitch) == null || !bool.booleanValue()) {
                        tanxc_int.this.tanxc_case();
                        return;
                    }
                    Log.d(tanxc_int.this.tanxc_do, "loopItem succ");
                    tanxc_int.this.tanxc_int = logSwitchBean;
                    tanxc_int.this.uploadLog();
                    tanxc_int.this.tanxc_new = false;
                }
            }

            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(tanxc_int.this.tanxc_do, "loopItem");
                new UploadLogSwitchRequest().request(new RequestUploadLogSwitchBean(), (NetWorkCallBack<LogSwitchBean>) new NetWorkCallBack<LogSwitchBean>() { // from class: com.alimm.tanx.core.log.tanxc_int.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                    public void error(int i10, String str, String str2) {
                        Log.d(tanxc_int.this.tanxc_do, "loopItem error：" + str2);
                        tanxc_int.this.tanxc_case();
                    }

                    @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                    /* renamed from: tanxc_do */
                    public void succ(LogSwitchBean logSwitchBean) {
                        Boolean bool;
                        if (logSwitchBean == null || (bool = logSwitchBean.logUploadSwitch) == null || !bool.booleanValue()) {
                            tanxc_int.this.tanxc_case();
                            return;
                        }
                        Log.d(tanxc_int.this.tanxc_do, "loopItem succ");
                        tanxc_int.this.tanxc_int = logSwitchBean;
                        tanxc_int.this.uploadLog();
                        tanxc_int.this.tanxc_new = false;
                    }
                });
            }
        }, this.tanxc_try);
    }

    public static /* synthetic */ void tanxc_int() {
        tanxc_new.tanxc_do().tanxc_if();
    }

    private boolean tanxc_new() {
        if (this.tanxc_int == null) {
            this.tanxc_int = new LogSwitchBean();
        }
        return this.tanxc_int.logWriteSwitch.booleanValue();
    }

    private void tanxc_try() {
        if (this.tanxc_int != null) {
            this.tanxc_int.logWriteSwitch = Boolean.FALSE;
        }
    }

    public void tanxc_for() {
        tanxc_new.tanxc_do().tanxc_for();
    }

    public void tanxc_if() {
        tanxc_new.tanxc_do().tanxc_if();
        LifeCycleManager.getInstance().register(this.tanxc_do, new LifeCycleManager.AppVisibleCallBack() { // from class: com.alimm.tanx.core.log.tanxc_int.1
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
            public void appVisibleCallBack(boolean z10, boolean z11) {
                String str = tanxc_int.this.tanxc_do;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("当前前后台状态：->");
                sb2.append(z10 ? "后台" : "前台");
                sb2.append(",是否由后台切换到前台：");
                sb2.append(z11);
                Log.d(str, sb2.toString());
                if (z10) {
                    tanxc_int.this.tanxc_for();
                }
                if (z11) {
                    tanxc_int.tanxc_int();
                }
            }
        });
    }

    @Override // com.alimm.tanx.core.log.ILog
    public void uploadLog() {
        tanxc_try();
        tanxc_new.tanxc_do().tanxc_int();
        tanxc_do.tanxc_do().tanxc_int();
    }

    @Override // com.alimm.tanx.core.log.ILog
    public void write(String str, String str2, String str3) {
        if (tanxc_new()) {
            LogItemBean logItemBean = new LogItemBean(str2, str, str3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(logItemBean);
            write(arrayList);
        }
    }

    public static tanxc_int tanxc_do() {
        if (tanxc_for == null) {
            synchronized (tanxc_int.class) {
                try {
                    if (tanxc_for == null) {
                        tanxc_for = new tanxc_int();
                    }
                } finally {
                }
            }
        }
        return tanxc_for;
    }

    @Override // com.alimm.tanx.core.log.ILog
    public void write(LogItemBean logItemBean) {
        if (tanxc_new()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(logItemBean);
            write(arrayList);
        }
    }

    public void tanxc_do(LogSwitchBean logSwitchBean) {
        this.tanxc_int = logSwitchBean;
    }

    @Override // com.alimm.tanx.core.log.ILog
    public void write(List<LogItemBean> list) {
        if (tanxc_new()) {
            tanxc_byte();
            tanxc_new.tanxc_do().tanxc_do(new LogBean(list));
        }
    }
}
