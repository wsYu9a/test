package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.a.e;
import com.bytedance.sdk.openadsdk.api.a.f;
import com.bytedance.sdk.openadsdk.api.a.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.d;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements Bridge {

    /* renamed from: a */
    private static volatile d f8171a;

    /* renamed from: b */
    private final Context f8172b;

    /* renamed from: c */
    private AdDownloadModel.Builder f8173c;

    /* renamed from: d */
    private AdDownloadModel f8174d;

    /* renamed from: e */
    private AdDownloadController.Builder f8175e;

    /* renamed from: f */
    private AdDownloadController f8176f;

    /* renamed from: g */
    private AdDownloadEventConfig.Builder f8177g;

    /* renamed from: h */
    private AdDownloadEventConfig f8178h;

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.d$1 */
    public class AnonymousClass1 implements IDownloadFileUriProvider {
        public AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
        public Uri getUriForFile(String str, String str2) {
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.d$2 */
    public class AnonymousClass2 implements IDownloadFileUriProvider {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
        public Uri getUriForFile(String str, String str2) {
            return null;
        }
    }

    private d(Context context) {
        this.f8172b = context;
    }

    private static boolean a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return false;
    }

    private int av() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getDownloadMode();
    }

    private void b(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder a10 = a(((Long) map.get("id")).longValue(), (String) map.get(TTDownloadField.TT_APP_ICON), ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue(), (String) map.get(TTDownloadField.TT_LOG_EXTRA), (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON), (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS), (String) map.get(TTDownloadField.TT_FILE_PATH), (String) map.get(TTDownloadField.TT_DOWNLOAD_URL), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue(), (String) map.get(TTDownloadField.TT_OPEN_URL), (String) map.get(TTDownloadField.TT_WEB_TITLE), (String) map.get(TTDownloadField.TT_WEB_URL));
        this.f8173c = a10;
        this.f8174d = a10.build();
    }

    private DownloadStatusChangeListener c(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        if (obj instanceof EventListener) {
            return new e((EventListener) obj);
        }
        return null;
    }

    private DownloadModel d(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private DownloadEventConfig e(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private DownloadController f(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private Activity g(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private ExitInstallListener h(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private OnItemClickListener i(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new g((EventListener) obj);
        }
        return null;
    }

    private IDownloadButtonClickListener j(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new f((EventListener) obj);
        }
        return null;
    }

    public int A() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return 0;
        }
        return adDownloadEventConfig.getDownloadScene();
    }

    public boolean B() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return true;
        }
        return adDownloadEventConfig.isEnableClickEvent();
    }

    public boolean C() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return false;
        }
        return adDownloadEventConfig.isEnableV3Event();
    }

    public JSONObject D() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraJson();
    }

    public JSONObject E() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getParamsJson();
    }

    public long F() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getId();
    }

    public String G() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getMd5();
    }

    public long H() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExpectFileLength();
    }

    public long I() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExtraValue();
    }

    public String J() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getDownloadUrl();
    }

    public List<String> K() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getBackupUrls();
    }

    public String L() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getNotificationJumpUrl();
    }

    public String M() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getName();
    }

    public String N() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getMimeType();
    }

    public Map<String, String> O() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getHeaders();
    }

    public boolean P() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowToast();
    }

    public boolean Q() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowNotification();
    }

    public boolean R() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isNeedWifi();
    }

    public boolean S() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public boolean T() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public String U() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getFilePath();
    }

    public String V() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getFileName();
    }

    public void W() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceWifi();
    }

    public JSONObject X() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDownloadSettings();
    }

    public void Y() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideToast();
    }

    public void Z() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideNotification();
    }

    public boolean aa() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.needIndependentProcess();
    }

    public int ab() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getVersionCode();
    }

    public String ac() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getVersionName();
    }

    public boolean ad() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAd();
    }

    public String ae() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getLogExtra();
    }

    public String af() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getPackageName();
    }

    public String ag() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getAppIcon();
    }

    public DeepLink ah() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDeepLink();
    }

    public List<String> ai() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getClickTrackUrl();
    }

    public JSONObject aj() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getExtra();
    }

    public int ak() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getModelType();
    }

    public com.ss.android.download.api.model.d al() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getQuickAppModel();
    }

    public boolean am() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.autoInstallWithoutNotification();
    }

    public boolean an() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? com.ss.android.download.api.c.b.a(DownloadSetting.obtain(X()), N()) : adDownloadModel.shouldDownloadWithPatchApply();
    }

    public int ao() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return 2;
        }
        return adDownloadModel.getExecutorGroup();
    }

    public int ap() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return 1;
        }
        return adDownloadModel.getFunnelType();
    }

    public String aq() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public String ar() {
        AdDownloadModel adDownloadModel = this.f8174d;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public boolean as() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAutoInstall();
    }

    public boolean at() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.distinctDir();
    }

    public boolean au() {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.enablePause();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 != 20) {
            return (T) a(cls, i10, (valueSet == null || valueSet.objectValue(0, Map.class) == null) ? new HashMap<>() : (Map) valueSet.objectValue(0, Map.class));
        }
        a((Bundle) valueSet.objectValue(0, Bundle.class));
        return null;
    }

    public boolean k() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableShowComplianceDialog();
    }

    public boolean l() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAutoDownloadOnCardShow();
    }

    public boolean m() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableNewActivity();
    }

    public boolean n() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAH();
    }

    public boolean o() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAM();
    }

    public boolean p() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableOppoAutoDownload();
    }

    public String q() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getRefer();
    }

    public String r() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickButtonTag();
    }

    public String s() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickItemTag();
    }

    public String t() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickLabel();
    }

    public String u() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickStartLabel();
    }

    public String v() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.a.a.a.a.b.a().a(0, c.f8147a).a(1, Boolean.valueOf(c.f8148b)).a(10000, 3).b();
    }

    public String w() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public String x() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickInstallLabel();
    }

    public String y() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getStorageDenyLabel();
    }

    public Object z() {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraEventObject();
    }

    public static d a(Context context) {
        if (f8171a == null) {
            synchronized (d.class) {
                try {
                    if (f8171a == null) {
                        f8171a = new d(context);
                    }
                } finally {
                }
            }
        }
        return f8171a;
    }

    private void d(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str4 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(booleanValue).setIsEnableV3Event(booleanValue2);
        this.f8177g = isEnableV3Event;
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.f8178h = this.f8177g.build();
    }

    private void e(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_CLICK_LABEL);
        int intValue = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue();
        String str4 = (String) map.get(TTDownloadField.TT_REFER);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str8 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str9 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(booleanValue).setDownloadScene(intValue).setIsEnableV3Event(booleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.f8177g = paramsJson;
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.f8178h = this.f8177g.build();
    }

    private void f(int i10) {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setDownloadMode(i10);
    }

    public boolean g() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.shouldUseNewWebView();
    }

    public int h() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getInterceptFlag();
    }

    public AdDownloadModel k(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAppIcon(str);
    }

    public AdDownloadModel l(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setDownloadUrl(str);
    }

    public AdDownloadModel m(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNotificationJumpUrl(str);
    }

    public AdDownloadModel n(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setMimeType(str);
    }

    public AdDownloadModel o(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFilePath(str);
    }

    public AdDownloadModel p(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFileName(str);
    }

    public AdDownloadModel q(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionName(str);
    }

    private void c(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue();
        int intValue2 = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_BACK_DIALOG)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ADD_TO_DOWNLOAD_MANAGE)).booleanValue();
        map.get(TTDownloadField.TT_EXTRA_OPERATION);
        boolean booleanValue3 = ((Boolean) map.get(TTDownloadField.TT_SHOULD_USE_NEW_WEB_VIEW)).booleanValue();
        int intValue3 = ((Integer) map.get(TTDownloadField.TT_INTERCEPT_FLAG)).intValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        Object obj = map.get(TTDownloadField.TT_EXTRA_OBJECT);
        boolean booleanValue4 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue();
        boolean booleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(intValue).setDownloadMode(intValue2).setIsEnableBackDialog(booleanValue).setIsAddToDownloadManage(booleanValue2).setShouldUseNewWebView(booleanValue3).setInterceptFlag(intValue3).setExtraJson(jSONObject).setExtraObject(obj).setEnableShowComplianceDialog(booleanValue4).setIsAutoDownloadOnCardShow(booleanValue5).setEnableNewActivity(booleanValue6).setEnableAH(booleanValue7).setEnableAM(booleanValue8).setEnableOppoAutoDownload(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
        this.f8175e = enableOppoAutoDownload;
        this.f8176f = enableOppoAutoDownload.build();
    }

    public int f() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return 1;
        }
        return adDownloadController.getDowloadChunkCount();
    }

    public void g(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setStartToast(str);
    }

    public void h(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setSdkMonitorScene(str);
    }

    public JSONObject i() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraJson();
    }

    public Object j() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraObject();
    }

    private void f(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long longValue = ((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue();
        String str = (String) map.get("md5");
        long longValue2 = ((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue();
        int intValue = ((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue();
        List<String> list = (List) map.get(TTDownloadField.TT_CLICK_TRACK_URL);
        List<String> list2 = (List) map.get(TTDownloadField.TT_BACK_UP_URLS);
        String str2 = (String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL);
        String str3 = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get(TTDownloadField.TT_HEADERS);
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue();
        boolean booleanValue3 = ((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue();
        String str4 = (String) map.get(TTDownloadField.TT_FILE_NAME);
        int intValue2 = ((Integer) map.get("versionCode")).intValue();
        String str5 = (String) map.get("versionName");
        String str6 = (String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL);
        com.ss.android.download.api.model.d a10 = new d.a().a(str6).b((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).a();
        int intValue3 = ((Integer) map.get(TTDownloadField.TT_EXECUTOR_GROUP)).intValue();
        String str7 = (String) map.get(TTDownloadField.TT_START_TOAST);
        String str8 = (String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE);
        boolean booleanValue4 = ((Boolean) map.get(TTDownloadField.TT_AUTO_INSTALL)).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get(TTDownloadField.TT_DISTINCT_DIR)).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_PAUSE)).booleanValue();
        long longValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get(TTDownloadField.TT_APP_ICON);
        boolean booleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue();
        String str10 = (String) map.get(TTDownloadField.TT_LOG_EXTRA);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS);
        String str11 = (String) map.get(TTDownloadField.TT_FILE_PATH);
        String str12 = (String) map.get(TTDownloadField.TT_DOWNLOAD_URL);
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get("packageName");
        boolean booleanValue9 = ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue();
        String str15 = (String) map.get(TTDownloadField.TT_OPEN_URL);
        String str16 = (String) map.get(TTDownloadField.TT_WEB_TITLE);
        String str17 = (String) map.get(TTDownloadField.TT_WEB_URL);
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(longValue).setMd5(str).setId(longValue3).setExtraValue(longValue2).setIsAd(booleanValue).setModelType(intValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(booleanValue2).setIsShowNotification(booleanValue7).setNeedWifi(booleanValue3).setFileName(str4).setVersionCode(intValue2).setVersionName(str5).setQuickAppModel(a10).setAutoInstallWithoutNotification(booleanValue8).setExecutorGroup(intValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(booleanValue4).setDistinctDir(booleanValue5).setEnablePause(booleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.2
            public AnonymousClass2() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str22) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(booleanValue9);
        fileUriProvider.setDeepLink(a(longValue3, str15, str16, str17));
        this.f8174d = this.f8173c.build();
    }

    public AdDownloadModel g(boolean z10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsShowNotification(z10);
    }

    public AdDownloadModel h(boolean z10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNeedIndependentProcess(z10);
    }

    public AdDownloadModel i(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setLogExtra(str);
    }

    public AdDownloadModel j(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setPackageName(str);
    }

    public <T> T a(Class<T> cls, int i10, Map<String, Object> map) {
        DownloadModel d10;
        DownloadModel d11;
        DownloadEventConfig e10;
        DownloadController f10;
        DownloadModel d12;
        DownloadEventConfig e11;
        DownloadController f11;
        DownloadEventConfig e12;
        DownloadController f12;
        DownloadEventConfig e13;
        DownloadController f13;
        switch (i10) {
            case 3:
                c.a(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                break;
            case 4:
                AdDownloadModel adDownloadModel = this.f8174d;
                c.a().a(adDownloadModel == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel.getDownloadUrl(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue());
                break;
            case 5:
                int intValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                AdDownloadModel adDownloadModel2 = this.f8174d;
                if (adDownloadModel2 == null) {
                    d10 = d(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    d10 = d(adDownloadModel2);
                }
                c.a().a(this.f8172b, intValue, c(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), d10);
                break;
            case 6:
                AdDownloadModel adDownloadModel3 = this.f8174d;
                break;
            case 7:
                c.b();
                break;
            case 8:
                AdDownloadModel adDownloadModel4 = this.f8174d;
                c.a().a(adDownloadModel4 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel4.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                break;
            case 9:
                c.a(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                break;
            case 10:
                c.a((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                break;
            case 12:
                Uri uri = (Uri) map.get("uri");
                AdDownloadModel adDownloadModel5 = this.f8174d;
                if (adDownloadModel5 == null) {
                    d11 = d(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    d11 = d(adDownloadModel5);
                }
                AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
                if (adDownloadEventConfig == null) {
                    e10 = e(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    e10 = e(adDownloadEventConfig);
                }
                AdDownloadController adDownloadController = this.f8176f;
                if (adDownloadController == null) {
                    f10 = f(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    f10 = f(adDownloadController);
                }
                IDownloadButtonClickListener j10 = j(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (!a(j10)) {
                    break;
                } else {
                    break;
                }
            case 13:
                int intValue2 = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                AdDownloadModel adDownloadModel6 = this.f8174d;
                if (adDownloadModel6 == null) {
                    d12 = d(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    d12 = d(adDownloadModel6);
                }
                DownloadModel downloadModel = d12;
                AdDownloadEventConfig adDownloadEventConfig2 = this.f8178h;
                if (adDownloadEventConfig2 == null) {
                    e11 = e(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    e11 = e(adDownloadEventConfig2);
                }
                DownloadEventConfig downloadEventConfig = e11;
                AdDownloadController adDownloadController2 = this.f8176f;
                if (adDownloadController2 == null) {
                    f11 = f(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    f11 = f(adDownloadController2);
                }
                DownloadController downloadController = f11;
                DownloadStatusChangeListener c10 = c(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener j11 = j(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (a(j11)) {
                    c.a().e().a(this.f8172b, str, booleanValue, downloadModel, downloadEventConfig, downloadController, c10, intValue2, j11);
                    break;
                } else {
                    c.a().e().a(this.f8172b, str, booleanValue, downloadModel, downloadEventConfig, downloadController, c10, intValue2);
                    break;
                }
            case 14:
                AdDownloadModel adDownloadModel7 = this.f8174d;
                long longValue = adDownloadModel7 == null ? ((Long) map.get("id")).longValue() : adDownloadModel7.getId();
                AdDownloadModel adDownloadModel8 = this.f8174d;
                break;
            case 16:
                AdDownloadModel adDownloadModel9 = this.f8174d;
                String downloadUrl = adDownloadModel9 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel9.getDownloadUrl();
                AdDownloadModel adDownloadModel10 = this.f8174d;
                long longValue2 = adDownloadModel10 == null ? ((Long) map.get("id")).longValue() : adDownloadModel10.getId();
                int intValue3 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig3 = this.f8178h;
                if (adDownloadEventConfig3 == null) {
                    e12 = e(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    e12 = e(adDownloadEventConfig3);
                }
                DownloadEventConfig downloadEventConfig2 = e12;
                AdDownloadController adDownloadController3 = this.f8176f;
                if (adDownloadController3 == null) {
                    f12 = f(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    f12 = f(adDownloadController3);
                }
                c.a().a(downloadUrl, longValue2, intValue3, downloadEventConfig2, f12);
                break;
            case 17:
                AdDownloadModel adDownloadModel11 = this.f8174d;
                String downloadUrl2 = adDownloadModel11 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel11.getDownloadUrl();
                long longValue3 = ((Long) map.get("id")).longValue();
                int intValue4 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig4 = this.f8178h;
                if (adDownloadEventConfig4 == null) {
                    e13 = e(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    e13 = e(adDownloadEventConfig4);
                }
                DownloadEventConfig downloadEventConfig3 = e13;
                AdDownloadController adDownloadController4 = this.f8176f;
                if (adDownloadController4 == null) {
                    f13 = f(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    f13 = f(adDownloadController4);
                }
                c.a().a(downloadUrl2, longValue3, intValue4, downloadEventConfig3, f13, i(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), j(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                break;
            case 18:
                AdDownloadModel adDownloadModel12 = this.f8174d;
                break;
            case 19:
                AdDownloadModel adDownloadModel13 = this.f8174d;
                break;
            case 23:
                if (((Boolean) map.get(TTDownloadField.TT_MATE_IS_EMPTY)).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.f8173c = builder;
                    this.f8174d = builder.build();
                    break;
                } else {
                    b(map);
                    break;
                }
            case 24:
                a((String) map.get(TTDownloadField.TT_APP_ICON), (String) map.get("appName"), (String) map.get("packageName"));
                break;
            case 25:
                a(((Integer) map.get(TTDownloadField.TT_AUTO_OPEN)).intValue(), ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue(), ((Boolean) map.get(TTDownloadField.TT_IS_HAVE_DOWNLOAD_SDK_CONFIG)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue());
                break;
            case 26:
                f(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue());
                break;
            case 28:
                a(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue(), map.get(TTDownloadField.TT_DOWNLOAD_MARKET_INTERCEPTOR));
                break;
            case 29:
                d(map);
                break;
            case 30:
                b(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue());
                break;
            case 31:
                e(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue());
                break;
            case 32:
                c(map);
                break;
            case 44:
                a(((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue());
                break;
            case 46:
                a(((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue());
                break;
            case 49:
                b(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue());
                break;
            case 50:
                c(((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue());
                break;
            case 53:
                a(map.get(TTDownloadField.TT_EXTRA_OBJECT));
                break;
            case 54:
                a((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                break;
            case 56:
                e(map);
                break;
            case 72:
                b(map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT));
                break;
            case 73:
                a((String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG));
                break;
            case 74:
                b((JSONObject) map.get(TTDownloadField.TT_EVENT_CONFIG_EXTRA_JSON));
                break;
            case 75:
                c((JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON));
                break;
            case 76:
                b((String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG));
                break;
            case 78:
                c((String) map.get(TTDownloadField.TT_REFER));
                break;
            case 79:
                d((String) map.get(TTDownloadField.TT_QUICK_APP_EVENT_TAG));
                break;
            case 80:
                f(map);
                break;
            case 98:
                W();
                break;
            case 100:
                Y();
                break;
            case 101:
                Z();
                break;
            case 123:
                e((String) map.get("md5"));
                break;
            case 124:
                a(((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue());
                break;
            case 125:
                d(((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue());
                break;
            case 127:
                b(((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue());
                break;
            case 128:
                f((String) map.get("appName"));
                break;
            case 129:
                d((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                break;
            case 130:
                g((String) map.get(TTDownloadField.TT_START_TOAST));
                break;
            case 131:
                h((String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID /* 132 */:
                c(((Long) map.get("id")).longValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD /* 133 */:
                f(((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE /* 134 */:
                c(((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA /* 135 */:
                i((String) map.get(TTDownloadField.TT_LOG_EXTRA));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME /* 136 */:
                j((String) map.get("packageName"));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON /* 137 */:
                k((String) map.get(TTDownloadField.TT_APP_ICON));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL /* 139 */:
                a((List<String>) map.get(TTDownloadField.TT_CLICK_TRACK_URL));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL /* 140 */:
                l((String) map.get(TTDownloadField.TT_DOWNLOAD_URL));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS /* 141 */:
                b((List<String>) map.get(TTDownloadField.TT_BACK_UP_URLS));
                break;
            case 142:
                m((String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL));
                break;
            case 143:
                n((String) map.get("mimeType"));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS /* 144 */:
                a((Map<String, String>) map.get(TTDownloadField.TT_HEADERS));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION /* 145 */:
                g(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH /* 146 */:
                o((String) map.get(TTDownloadField.TT_FILE_PATH));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME /* 147 */:
                p((String) map.get(TTDownloadField.TT_FILE_NAME));
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS /* 148 */:
                h(((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue());
                break;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE /* 149 */:
                d(((Integer) map.get("versionCode")).intValue());
                break;
            case 150:
                q((String) map.get("versionName"));
                break;
            case 151:
                a(new d.a().a((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL)).b((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).a());
                break;
            case 152:
                i(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue());
                break;
            case 153:
                e(((Integer) map.get(TTDownloadField.TT_FUNNEL_TYPE)).intValue());
                break;
        }
        return null;
    }

    public AdDownloadModel i(boolean z10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAutoInstallWithoutNotification(z10);
    }

    public boolean b() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableBackDialog();
    }

    public void b(boolean z10) {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setIsAutoDownloadOnCardShow(z10);
    }

    public void b(Object obj) {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraEventObject(obj);
    }

    public void b(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraJson(jSONObject);
    }

    public Object d() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraClickOperation();
    }

    public void b(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickItemTag(str);
    }

    public void d(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setQuickAppEventTag(str);
    }

    public void b(int i10) {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setDownloadScene(i10);
    }

    public void d(boolean z10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setNeedWifi(z10);
    }

    public void b(long j10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtraValue(j10);
    }

    public void d(JSONObject jSONObject) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtra(jSONObject);
    }

    public AdDownloadModel b(List<String> list) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setBackupUrls(list);
    }

    public AdDownloadModel d(int i10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionCode(i10);
    }

    public boolean e() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableMultipleDownload();
    }

    public boolean c() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAddToDownloadManage();
    }

    public void e(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setMd5(str);
    }

    public void c(boolean z10) {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableNewActivity(z10);
    }

    public void e(boolean z10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setIsShowToast(z10);
    }

    public void c(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setParamsJson(jSONObject);
    }

    public AdDownloadModel e(int i10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFunnelType(i10);
    }

    public void c(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setRefer(str);
    }

    public AdDownloadModel c(long j10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setId(j10);
    }

    public AdDownloadModel c(int i10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setModelType(i10);
    }

    public void f(String str) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setAppName(str);
    }

    public AdDownloadModel f(boolean z10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsAd(z10);
    }

    public void a(Bundle bundle) {
        c.a(this.f8172b);
    }

    private AdDownloadModel.Builder a(long j10, String str, boolean z10, boolean z11, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z12, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j10).setAppIcon(str).setIsShowNotification(z10).setAutoInstallWithoutNotification(z11).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.1
            public AnonymousClass1() {
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str22) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z12);
        fileUriProvider.setDeepLink(a(j10, str7, str8, str9));
        return fileUriProvider;
    }

    private DeepLink a(long j10, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j10);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void a(String str, String str2, String str3) {
        AdDownloadModel.Builder builder = this.f8173c;
        if (builder == null) {
            return;
        }
        this.f8174d = builder.setAppIcon(str).setAppName(str2).setPackageName(str3).build();
    }

    private void a(int i10, int i11, boolean z10, boolean z11, boolean z12) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i10).setDownloadMode(i11).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.f8175e = isAddToDownloadManage;
        if (z10) {
            isAddToDownloadManage.setEnableAH(z11);
            this.f8175e.setEnableAM(z12);
        }
        this.f8176f = this.f8175e.build();
    }

    public int a() {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getLinkMode();
    }

    public void a(int i10) {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setLinkMode(i10);
    }

    public void a(boolean z10) {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableShowComplianceDialog(z10);
    }

    public void a(Object obj) {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraObject(obj);
    }

    public void a(JSONObject jSONObject) {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraJson(jSONObject);
    }

    private void a(boolean z10, Object obj) {
        AdDownloadController adDownloadController = this.f8176f;
        if (adDownloadController == null) {
            return;
        }
        try {
            if (obj instanceof DownloadMarketInterceptor) {
                adDownloadController.setDownloadMarketInterceptor((DownloadMarketInterceptor) obj);
            } else {
                adDownloadController.setDownloadMarketInterceptor(null);
            }
            this.f8176f.setEnableOppoAutoDownload(z10);
        } catch (Throwable unused) {
        }
    }

    public void a(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f8178h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickButtonTag(str);
    }

    public void a(long j10) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExpectFileLength(j10);
    }

    public AdDownloadModel a(List<String> list) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setClickTrackUrl(list);
    }

    public AdDownloadModel a(Map<String, String> map) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setHeaders(map);
    }

    public AdDownloadModel a(com.ss.android.download.api.model.d dVar) {
        AdDownloadModel adDownloadModel = this.f8174d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setQuickAppModel(dVar);
    }
}
