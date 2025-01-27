package com.alimm.tanx.core.log;

import android.util.Log;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class tanxc_new {
    private static volatile tanxc_new tanxc_do;
    private volatile LinkedBlockingQueue<LogBean> tanxc_if = new LinkedBlockingQueue<>(1000);
    private volatile boolean tanxc_for = false;
    private volatile boolean tanxc_int = false;
    private volatile AtomicBoolean tanxc_new = new AtomicBoolean(false);
    private volatile LogBean tanxc_try = null;

    /* renamed from: com.alimm.tanx.core.log.tanxc_new$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                tanxc_new.this.tanxc_for = true;
                while (true) {
                    LogBean logBean = (LogBean) tanxc_new.this.tanxc_if.take();
                    if (logBean == null) {
                        return;
                    } else {
                        tanxc_new.this.tanxc_do(true, logBean);
                    }
                }
            } catch (Exception e10) {
                Log.e("LogQueue", LogUtils.getStackTraceMessage(e10));
                tanxc_new.this.tanxc_for = false;
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.log.tanxc_new$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            tanxc_new.this.tanxc_do(false, (LogBean) null);
        }
    }

    /* renamed from: com.alimm.tanx.core.log.tanxc_new$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            tanxc_new.this.tanxc_do(false, (LogBean) null);
        }
    }

    public class tanxc_do implements Runnable {
        private final LogBean tanxc_for;
        private final String tanxc_if = "RealTimeRunnable";

        public tanxc_do(LogBean logBean) {
            this.tanxc_for = logBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.tanxc_for != null) {
                    tanxc_new.this.tanxc_if.put(this.tanxc_for);
                } else {
                    Log.d("RealTimeRunnable", "ILog :添加addRealTimeQueue失败-->itemUtBean为空");
                }
            } catch (Exception e10) {
                Log.e("RealTimeRunnable", LogUtils.getStackTraceMessage(e10));
            }
        }
    }

    private void tanxc_byte() {
        if (this.tanxc_try != null) {
            com.alimm.tanx.core.log.tanxc_do.tanxc_do().tanxc_do(this.tanxc_try);
            this.tanxc_try = null;
        }
    }

    private void tanxc_new() {
        Log.d("LogQueue", "ILog :启动runRealTimeQueue--realTimeQueueRunning-->" + this.tanxc_for);
        if (this.tanxc_for) {
            return;
        }
        tanxc_try.tanxc_do(new Runnable() { // from class: com.alimm.tanx.core.log.tanxc_new.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    tanxc_new.this.tanxc_for = true;
                    while (true) {
                        LogBean logBean = (LogBean) tanxc_new.this.tanxc_if.take();
                        if (logBean == null) {
                            return;
                        } else {
                            tanxc_new.this.tanxc_do(true, logBean);
                        }
                    }
                } catch (Exception e10) {
                    Log.e("LogQueue", LogUtils.getStackTraceMessage(e10));
                    tanxc_new.this.tanxc_for = false;
                }
            }
        });
    }

    private int tanxc_try() {
        int utUploadMaxCount = OrangeManager.getInstance().getUtUploadMaxCount();
        if (utUploadMaxCount == -1) {
            return 30;
        }
        return utUploadMaxCount;
    }

    public void tanxc_for() {
        tanxc_try.tanxc_do(new Runnable() { // from class: com.alimm.tanx.core.log.tanxc_new.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                tanxc_new.this.tanxc_do(false, (LogBean) null);
            }
        });
        this.tanxc_new.set(true);
    }

    public void tanxc_if() {
        Log.d("LogQueue", "ILog :run()");
        this.tanxc_new.set(false);
        tanxc_new();
    }

    public void tanxc_int() {
        tanxc_try.tanxc_do(new Runnable() { // from class: com.alimm.tanx.core.log.tanxc_new.3
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                tanxc_new.this.tanxc_do(false, (LogBean) null);
            }
        });
    }

    public static tanxc_new tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_new.class) {
                try {
                    if (tanxc_do == null) {
                        tanxc_do = new tanxc_new();
                    }
                } finally {
                }
            }
        }
        return tanxc_do;
    }

    public void tanxc_do(LogBean logBean) {
        tanxc_try.tanxc_do(new tanxc_do(logBean));
    }

    public synchronized void tanxc_do(boolean z10, LogBean logBean) {
        List<LogItemBean> list;
        try {
            if (z10) {
                if (logBean != null && (list = logBean.events) != null && list.size() > 0) {
                    if (this.tanxc_try == null) {
                        this.tanxc_try = logBean;
                    } else {
                        this.tanxc_try.events.addAll(logBean.events);
                    }
                    if (this.tanxc_new.get() || this.tanxc_try.events.size() >= tanxc_try()) {
                        tanxc_byte();
                    }
                }
                return;
            }
            tanxc_byte();
        } catch (Exception e10) {
            Log.e("LogQueue", LogUtils.getStackTraceMessage(e10));
        } finally {
        }
    }
}
