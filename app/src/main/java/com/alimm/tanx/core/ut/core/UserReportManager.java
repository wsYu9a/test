package com.alimm.tanx.core.ut.core;

import com.alimm.tanx.core.ut.bean.UtBean;
import com.alimm.tanx.core.ut.bean.UtItemBean;
import com.alimm.tanx.core.ut.core.LifeCycleManager;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class UserReportManager implements IUserReport {
    private static volatile UserReportManager instance;
    public String TAG = "UserReportManager";

    /* renamed from: com.alimm.tanx.core.ut.core.UserReportManager$1 */
    public class AnonymousClass1 implements LifeCycleManager.AppVisibleCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
        public void appVisibleCallBack(boolean z10, boolean z11) {
            String str = UserReportManager.this.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("当前前后台状态：->");
            sb2.append(z10 ? "后台" : "前台");
            sb2.append(",是否由后台切换到前台：");
            sb2.append(z11);
            LogUtils.d(str, sb2.toString());
            if (z10) {
                UserReportManager.this.destroy();
            }
            if (z11) {
                UserReportManager.this.run();
            }
        }
    }

    public static UserReportManager getInstance() {
        if (instance == null) {
            synchronized (UserReportManager.class) {
                try {
                    if (instance == null) {
                        instance = new UserReportManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void run() {
        QueueManager.getInstance().run();
    }

    public void destroy() {
        QueueManager.getInstance().destroy();
        UtRequest.getInstance().destroy();
    }

    public void init() {
        run();
        LifeCycleManager.getInstance().register(this.TAG, new LifeCycleManager.AppVisibleCallBack() { // from class: com.alimm.tanx.core.ut.core.UserReportManager.1
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
            public void appVisibleCallBack(boolean z10, boolean z11) {
                String str = UserReportManager.this.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("当前前后台状态：->");
                sb2.append(z10 ? "后台" : "前台");
                sb2.append(",是否由后台切换到前台：");
                sb2.append(z11);
                LogUtils.d(str, sb2.toString());
                if (z10) {
                    UserReportManager.this.destroy();
                }
                if (z11) {
                    UserReportManager.this.run();
                }
            }
        });
    }

    @Override // com.alimm.tanx.core.ut.core.IUserReport
    public void send(UtItemBean utItemBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(utItemBean);
        send(arrayList);
    }

    @Override // com.alimm.tanx.core.ut.core.IUserReport
    public void send(List<UtItemBean> list) {
        QueueManager.getInstance().addRealTimeQueue(new UtBean(list));
    }
}
