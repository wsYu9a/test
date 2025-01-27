package com.alimm.tanx.core.orange;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.ConfigRequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.orange.bean.ExposureConfigBean;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.TanxConfigTableV2;
import com.alimm.tanx.core.request.ConfigRequest;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SharedPreferencesHelper;
import com.baidu.mobads.sdk.internal.a;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import vb.e;

/* loaded from: classes.dex */
public class OrangeManager implements NotConfused {
    public static final String FEED_VIDEO_MAX_SIZE = "feedVideoMaxSize";
    private static final String TAG = "OrangeManager";
    private static volatile OrangeManager instance;
    private volatile OrangeBean orangeBean;
    private OrangeInitListener orangeInitListener;

    /* renamed from: com.alimm.tanx.core.orange.OrangeManager$1 */
    public class AnonymousClass1 implements NetWorkCallBack<OrangeBean> {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            LogUtils.e(OrangeManager.TAG, "orange配置拉取失败-> code:" + i10 + " reqId:" + str + "  error->" + str2);
            OrangeManager.this.callBack2InitSucc();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("orange配置拉取失败-> code:");
            sb2.append(i10);
            sb2.append("  error->");
            sb2.append(str2);
            TanxBaseUt.utError(i10, OrangeManager.TAG, sb2.toString(), "");
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(OrangeBean orangeBean) {
            if (orangeBean != null) {
                OrangeManager.this.checkOrangeVersion2Write(orangeBean, JSON.toJSONString(orangeBean));
                OrangeManager.this.checkNewConfigRequest(orangeBean);
            }
            LogUtils.d(OrangeManager.TAG, "Orange diamond服务器版本为->" + orangeBean.version);
        }
    }

    /* renamed from: com.alimm.tanx.core.orange.OrangeManager$2 */
    public class AnonymousClass2 implements NetWorkCallBack<TanxConfigTableV2> {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            LogUtils.e(OrangeManager.TAG, "newConfigRequest error code:" + i10, ",reqId:" + str + ",error:" + str2);
            OrangeManager.this.callBack2InitSucc();
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(TanxConfigTableV2 tanxConfigTableV2) {
            try {
                if (TextUtils.isEmpty(tanxConfigTableV2.content)) {
                    LogUtils.e(OrangeManager.TAG, "tanxConfigTableV2.content为空");
                    TanxCommonUt.sendNewConfigFail("", -1L, UtErrorCode.DATA_PARSE_ERROR.getIntCode(), "tanxConfigTableV2.content为空", "");
                } else {
                    OrangeBean orangeBean = (OrangeBean) JSON.parseObject(tanxConfigTableV2.content, OrangeBean.class);
                    if (orangeBean != null) {
                        LogUtils.d(OrangeManager.TAG, "Orange 新配置接口服务器版本为->" + orangeBean.version);
                        OrangeManager.this.checkOrangeVersion2Write(orangeBean, JSON.toJSONString(tanxConfigTableV2));
                    } else {
                        LogUtils.e(OrangeManager.TAG, "orangeBean为空");
                    }
                }
            } catch (Exception e10) {
                UtErrorCode utErrorCode = UtErrorCode.JSON_PARSE_ERROR;
                TanxCommonUt.sendNewConfigFail("", -1L, utErrorCode.getIntCode(), "OrangeManager,catch:" + utErrorCode.getMsg(), "");
                LogUtils.e(OrangeManager.TAG, e10);
            }
            OrangeManager.this.callBack2InitSucc();
        }
    }

    public void callBack2InitSucc() {
        OrangeInitListener orangeInitListener = this.orangeInitListener;
        if (orangeInitListener != null) {
            orangeInitListener.initFinish(this.orangeBean);
        }
    }

    private void checkAndCreateDefaultOrange() {
        try {
            if (this.orangeBean == null) {
                String fromAssets = getFromAssets("orange.json");
                if (TextUtils.isEmpty(fromAssets)) {
                    return;
                }
                this.orangeBean = (OrangeBean) JSON.parseObject(fromAssets, OrangeBean.class);
                LogUtils.d(TAG, "本地初始orange配置->" + fromAssets);
            }
        } catch (Exception e10) {
            LogUtils.e(TAG, e10);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e10), "");
        }
    }

    public void checkNewConfigRequest(OrangeBean orangeBean) {
        HashMap<String, String> hashMap;
        if (orangeBean == null || (hashMap = orangeBean.commonSwitch) == null || hashMap.get("useNewConfig") == null) {
            callBack2InitSucc();
        } else if ("true".equalsIgnoreCase(orangeBean.commonSwitch.get("useNewConfig"))) {
            newConfigRequest();
        }
    }

    public void checkOrangeVersion2Write(OrangeBean orangeBean, String str) {
        if (this.orangeBean == null || this.orangeBean.version < orangeBean.version) {
            writeOrange(str);
            this.orangeBean = orangeBean;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int defaultFeedInteractionParam(String str) {
        char c10;
        str.hashCode();
        switch (str.hashCode()) {
            case -1059030137:
                if (str.equals("directionSlideDistance")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 103203022:
                if (str.equals("slideDirection")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 1348276389:
                if (str.equals("allSlideDistance")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                return 55;
            case 1:
                return 1;
            case 2:
                return 120;
            default:
                return -1;
        }
    }

    private boolean diamondConfigParse(String str) {
        HashMap<String, Boolean> hashMap;
        try {
            OrangeBean orangeBean = (OrangeBean) JSON.parseObject(str, OrangeBean.class);
            if (orangeBean != null && (hashMap = orangeBean.adSwitch) != null && hashMap.size() > 0) {
                this.orangeBean = orangeBean;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void diamondRequest() {
        new tanxc_do().tanxc_do(new NetWorkCallBack<OrangeBean>() { // from class: com.alimm.tanx.core.orange.OrangeManager.1
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                LogUtils.e(OrangeManager.TAG, "orange配置拉取失败-> code:" + i10 + " reqId:" + str + "  error->" + str2);
                OrangeManager.this.callBack2InitSucc();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("orange配置拉取失败-> code:");
                sb2.append(i10);
                sb2.append("  error->");
                sb2.append(str2);
                TanxBaseUt.utError(i10, OrangeManager.TAG, sb2.toString(), "");
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(OrangeBean orangeBean) {
                if (orangeBean != null) {
                    OrangeManager.this.checkOrangeVersion2Write(orangeBean, JSON.toJSONString(orangeBean));
                    OrangeManager.this.checkNewConfigRequest(orangeBean);
                }
                LogUtils.d(OrangeManager.TAG, "Orange diamond服务器版本为->" + orangeBean.version);
            }
        });
    }

    public static OrangeManager getInstance() {
        if (instance == null) {
            synchronized (OrangeManager.class) {
                try {
                    if (instance == null) {
                        instance = new OrangeManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private boolean newConfigParse(String str) {
        try {
            this.orangeBean = (OrangeBean) JSON.parseObject(((TanxConfigTableV2) JSON.parseObject(str, TanxConfigTableV2.class)).content, OrangeBean.class);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void newConfigRequest() {
        new ConfigRequest().request(new ConfigRequestBean(), (NetWorkCallBack<TanxConfigTableV2>) new NetWorkCallBack<TanxConfigTableV2>() { // from class: com.alimm.tanx.core.orange.OrangeManager.2
            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                LogUtils.e(OrangeManager.TAG, "newConfigRequest error code:" + i10, ",reqId:" + str + ",error:" + str2);
                OrangeManager.this.callBack2InitSucc();
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(TanxConfigTableV2 tanxConfigTableV2) {
                try {
                    if (TextUtils.isEmpty(tanxConfigTableV2.content)) {
                        LogUtils.e(OrangeManager.TAG, "tanxConfigTableV2.content为空");
                        TanxCommonUt.sendNewConfigFail("", -1L, UtErrorCode.DATA_PARSE_ERROR.getIntCode(), "tanxConfigTableV2.content为空", "");
                    } else {
                        OrangeBean orangeBean = (OrangeBean) JSON.parseObject(tanxConfigTableV2.content, OrangeBean.class);
                        if (orangeBean != null) {
                            LogUtils.d(OrangeManager.TAG, "Orange 新配置接口服务器版本为->" + orangeBean.version);
                            OrangeManager.this.checkOrangeVersion2Write(orangeBean, JSON.toJSONString(tanxConfigTableV2));
                        } else {
                            LogUtils.e(OrangeManager.TAG, "orangeBean为空");
                        }
                    }
                } catch (Exception e10) {
                    UtErrorCode utErrorCode = UtErrorCode.JSON_PARSE_ERROR;
                    TanxCommonUt.sendNewConfigFail("", -1L, utErrorCode.getIntCode(), "OrangeManager,catch:" + utErrorCode.getMsg(), "");
                    LogUtils.e(OrangeManager.TAG, e10);
                }
                OrangeManager.this.callBack2InitSucc();
            }
        });
    }

    private void readLocalOrange() {
        try {
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance();
            SharedPreferencesHelper.getInstance();
            String string = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_ORANGE);
            if (!TextUtils.isEmpty(string)) {
                if (!diamondConfigParse(string)) {
                    newConfigParse(string);
                }
                LogUtils.d(TAG, "Orange本地版本为->" + this.orangeBean.version);
                LogUtils.d(TAG, "本地orange配置->" + JSON.toJSONString(this.orangeBean));
            }
        } catch (Exception e10) {
            LogUtils.e(TAG, e10);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e10), "");
        }
        checkAndCreateDefaultOrange();
    }

    private void writeOrange(String str) {
        try {
            LogUtils.d(TAG, "覆盖本地orange配置->" + str);
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance();
            SharedPreferencesHelper.getInstance();
            sharedPreferencesHelper.putString(SharedPreferencesHelper.KEY_ORANGE, str);
        } catch (Exception e10) {
            LogUtils.e(TAG, e10);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e10), "");
        }
    }

    public boolean getAdSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.adSwitch == null || this.orangeBean.adSwitch.get(str) == null || str == null) {
            return true;
        }
        return this.orangeBean.adSwitch.get(str).booleanValue();
    }

    public boolean getAllAppImageSwitch() {
        if (this.orangeBean == null || this.orangeBean.imageSwitch == null || this.orangeBean.imageSwitch.get("AllApp") == null) {
            return false;
        }
        return this.orangeBean.imageSwitch.get("AllApp").booleanValue();
    }

    public boolean getCommonSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.commonSwitch == null || this.orangeBean.commonSwitch.get(str) == null) {
            return false;
        }
        return "true".equalsIgnoreCase(this.orangeBean.commonSwitch.get(str));
    }

    public ExposureConfigBean getExposureConfigBean(int i10) {
        try {
            if (this.orangeBean != null && this.orangeBean.exposureConfig != null && this.orangeBean.exposureConfig.size() > 0 && TanxCoreSdk.getConfig() != null && !TextUtils.isEmpty(TanxCoreSdk.getConfig().getAppKey())) {
                ExposureConfigBean exposureConfigBean = null;
                for (int i11 = 0; i11 < this.orangeBean.exposureConfig.size(); i11++) {
                    if (this.orangeBean.exposureConfig.get(i11).key.equals(TanxCoreSdk.getConfig().getAppKey()) && this.orangeBean.exposureConfig.get(i11).adType == i10) {
                        return this.orangeBean.exposureConfig.get(i11);
                    }
                    if (this.orangeBean.exposureConfig.get(i11).key.equals(DownloadSettingKeys.BugFix.DEFAULT) && this.orangeBean.exposureConfig.get(i11).adType == i10 && exposureConfigBean == null) {
                        exposureConfigBean = this.orangeBean.exposureConfig.get(i11);
                    }
                }
                return exposureConfigBean;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String getFeedInteractionGifUrlParam(String str) {
        if (this.orangeBean == null || this.orangeBean.feedInteractionParam == null) {
            return "https://img.alicdn.com/imgextra/i3/O1CN01yaPRML1GyyqsOZP7R_!!6000000000692-1-tps-1200-432.gif";
        }
        String str2 = this.orangeBean.feedInteractionParam.get(str);
        return TextUtils.isEmpty(str2) ? "https://img.alicdn.com/imgextra/i3/O1CN01yaPRML1GyyqsOZP7R_!!6000000000692-1-tps-1200-432.gif" : str2;
    }

    public int getFeedInteractionParam2Integer(String str) {
        try {
            if (this.orangeBean != null && this.orangeBean.feedInteractionParam != null) {
                String str2 = this.orangeBean.feedInteractionParam.get(str);
                return TextUtils.isEmpty(str2) ? defaultFeedInteractionParam(str) : Integer.parseInt(str2);
            }
            return defaultFeedInteractionParam(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getFromAssets(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(TanxCoreSdk.getApplication()).open(str)));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str2;
                }
                str2 = str2 + readLine;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public boolean getImageSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.imageSwitch == null || this.orangeBean.imageSwitch.get(str) == null) {
            return false;
        }
        return this.orangeBean.imageSwitch.get(str).booleanValue();
    }

    public HashMap<String, Boolean> getInstallSwitch() {
        return (this.orangeBean == null || this.orangeBean.installStatusSwitch == null) ? new HashMap<>() : this.orangeBean.installStatusSwitch;
    }

    public OrangeBean getOrangeBean() {
        return this.orangeBean;
    }

    public long getThreshold(String str) {
        if (this.orangeBean == null || this.orangeBean.threshold == null || this.orangeBean.threshold.get(str) == null) {
            return -1L;
        }
        return this.orangeBean.threshold.get(str).longValue();
    }

    public int getUtUploadMaxCount() {
        if (this.orangeBean == null || this.orangeBean.ut == null) {
            return -1;
        }
        return this.orangeBean.ut.uploadMaxCount;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[Catch: Exception -> 0x008a, TRY_LEAVE, TryCatch #0 {Exception -> 0x008a, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:8:0x0014, B:10:0x001a, B:14:0x002b, B:16:0x0035, B:27:0x004f, B:18:0x005a, B:21:0x0070, B:23:0x007a, B:32:0x0084, B:35:0x007d), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alimm.tanx.core.orange.bean.WebConfigBean getWebConfigBean() {
        /*
            r4 = this;
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch: java.lang.Exception -> L8a
            if (r0 == 0) goto L7d
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch: java.lang.Exception -> L8a
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r0 = r0.webConfigBeanList     // Catch: java.lang.Exception -> L8a
            if (r0 == 0) goto L7d
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch: java.lang.Exception -> L8a
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r0 = r0.webConfigBeanList     // Catch: java.lang.Exception -> L8a
            int r0 = r0.size()     // Catch: java.lang.Exception -> L8a
            if (r0 <= 0) goto L7d
            com.alimm.tanx.core.config.TanxConfig r0 = com.alimm.tanx.core.TanxCoreSdk.getConfig()     // Catch: java.lang.Exception -> L8a
            if (r0 == 0) goto L7d
            com.alimm.tanx.core.config.TanxConfig r0 = com.alimm.tanx.core.TanxCoreSdk.getConfig()     // Catch: java.lang.Exception -> L8a
            java.lang.String r0 = r0.getAppKey()     // Catch: java.lang.Exception -> L8a
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L8a
            if (r0 == 0) goto L29
            goto L7d
        L29:
            r0 = 0
            r1 = 0
        L2b:
            com.alimm.tanx.core.orange.bean.OrangeBean r2 = r4.orangeBean     // Catch: java.lang.Exception -> L8a
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r2 = r2.webConfigBeanList     // Catch: java.lang.Exception -> L8a
            int r2 = r2.size()     // Catch: java.lang.Exception -> L8a
            if (r1 >= r2) goto L82
            com.alimm.tanx.core.orange.bean.OrangeBean r2 = r4.orangeBean     // Catch: java.lang.Exception -> L8a
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r2 = r2.webConfigBeanList     // Catch: java.lang.Exception -> L8a
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Exception -> L8a
            com.alimm.tanx.core.orange.bean.WebConfigBean r2 = (com.alimm.tanx.core.orange.bean.WebConfigBean) r2     // Catch: java.lang.Exception -> L8a
            java.lang.String r2 = r2.key     // Catch: java.lang.Exception -> L8a
            com.alimm.tanx.core.config.TanxConfig r3 = com.alimm.tanx.core.TanxCoreSdk.getConfig()     // Catch: java.lang.Exception -> L8a
            java.lang.String r3 = r3.getAppKey()     // Catch: java.lang.Exception -> L8a
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L8a
            if (r2 == 0) goto L5a
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch: java.lang.Exception -> L8a
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r0 = r0.webConfigBeanList     // Catch: java.lang.Exception -> L8a
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L8a
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = (com.alimm.tanx.core.orange.bean.WebConfigBean) r0     // Catch: java.lang.Exception -> L8a
            return r0
        L5a:
            com.alimm.tanx.core.orange.bean.OrangeBean r2 = r4.orangeBean     // Catch: java.lang.Exception -> L8a
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r2 = r2.webConfigBeanList     // Catch: java.lang.Exception -> L8a
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Exception -> L8a
            com.alimm.tanx.core.orange.bean.WebConfigBean r2 = (com.alimm.tanx.core.orange.bean.WebConfigBean) r2     // Catch: java.lang.Exception -> L8a
            java.lang.String r2 = r2.key     // Catch: java.lang.Exception -> L8a
            java.lang.String r3 = "default"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L8a
            if (r2 == 0) goto L7a
            if (r0 != 0) goto L7a
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch: java.lang.Exception -> L8a
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r0 = r0.webConfigBeanList     // Catch: java.lang.Exception -> L8a
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L8a
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = (com.alimm.tanx.core.orange.bean.WebConfigBean) r0     // Catch: java.lang.Exception -> L8a
        L7a:
            int r1 = r1 + 1
            goto L2b
        L7d:
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = new com.alimm.tanx.core.orange.bean.WebConfigBean     // Catch: java.lang.Exception -> L8a
            r0.<init>()     // Catch: java.lang.Exception -> L8a
        L82:
            if (r0 != 0) goto L89
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = new com.alimm.tanx.core.orange.bean.WebConfigBean     // Catch: java.lang.Exception -> L8a
            r0.<init>()     // Catch: java.lang.Exception -> L8a
        L89:
            return r0
        L8a:
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = new com.alimm.tanx.core.orange.bean.WebConfigBean
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.orange.OrangeManager.getWebConfigBean():com.alimm.tanx.core.orange.bean.WebConfigBean");
    }

    public boolean getWebSuffixWhiteSwitch(String str) {
        if (this.orangeBean != null && this.orangeBean.webSuffixWhiteList != null) {
            if (this.orangeBean.webSuffixWhiteList.get(str) == null) {
                return false;
            }
            return this.orangeBean.webSuffixWhiteList.get(str).booleanValue();
        }
        String[] strArr = {"com", "cn", "htm", a.f6640f, "php", e.f31300g};
        for (int i10 = 0; i10 < 6; i10++) {
            if (strArr[i10].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void init() {
        init(null);
    }

    public void init(OrangeInitListener orangeInitListener) {
        this.orangeInitListener = orangeInitListener;
        readLocalOrange();
        diamondRequest();
    }
}
