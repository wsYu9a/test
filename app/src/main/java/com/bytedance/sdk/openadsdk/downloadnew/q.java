package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class q extends j implements Bridge {

    /* renamed from: j */
    private static volatile q f6470j;
    private final Context zx;

    private q(Context context) {
        this.zx = context;
    }

    private DownloadController g(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private OnItemClickListener gv(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        return null;
    }

    private DownloadEventConfig i(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    public static q j(Context context) {
        if (f6470j == null) {
            synchronized (q.class) {
                if (f6470j == null) {
                    f6470j = new q(context);
                }
            }
        }
        return f6470j;
    }

    private static boolean j(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    private IDownloadButtonClickListener lg(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        return null;
    }

    private ExitInstallListener q(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private DownloadModel zx(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 != 20) {
            return (T) callMethod(cls, i2, (Map) valueSet.objectValue(0, Map.class));
        }
        init((Bundle) valueSet.objectValue(0, Bundle.class));
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.j, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i2, Map<String, Object> map) {
        switch (i2) {
            case 0:
                return (T) Boolean.valueOf(g.j(getActivity(map.get(TTDownloadField.TT_ACTIVITY)), q(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
            case 1:
                return (T) g.j().gv();
            case 2:
                try {
                    return (T) Boolean.valueOf(g.j((String) map.get(TTDownloadField.TT_TAG_INTERCEPT), (String) map.get(TTDownloadField.TT_LABEL), new JSONObject((String) map.get(TTDownloadField.TT_META)), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                g.j(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                return null;
            case 4:
                g.j().j((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue());
                return null;
            case 5:
                g.j().j(this.zx, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue(), j(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), zx(map.get(TTDownloadField.TT_DOWNLOAD_MODEL)));
                return null;
            case 6:
                return (T) Boolean.valueOf(g.j(this.zx, (String) map.get(TTDownloadField.TT_DOWNLOAD_URL)));
            case 7:
                g.zx();
                return null;
            case 8:
                g.j().j((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Boolean) map.get("force")).booleanValue());
                return null;
            case 9:
                g.j(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                return null;
            case 10:
                g.j((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                return null;
            case 11:
            default:
                return (T) super.callMethod(cls, i2, map);
            case 12:
                Uri uri = (Uri) map.get("uri");
                DownloadModel zx = zx(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                DownloadEventConfig i3 = i(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                DownloadController g2 = g(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                IDownloadButtonClickListener lg = lg(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                return j(lg) ? (T) Boolean.valueOf(g.j(this.zx, uri, zx, i3, g2, lg)) : (T) Boolean.valueOf(g.j(this.zx, uri, zx, i3, g2));
            case 13:
                int intValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                DownloadModel zx2 = zx(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                DownloadEventConfig i4 = i(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                DownloadController g3 = g(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                DownloadStatusChangeListener j2 = j(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener lg2 = lg(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (j(lg2)) {
                    g.j().q().j(this.zx, str, booleanValue, zx2, i4, g3, j2, intValue, lg2);
                    return null;
                }
                g.j().q().j(this.zx, str, booleanValue, zx2, i4, g3, j2, intValue);
                return null;
            case 14:
                return (T) Boolean.valueOf(g.j().q().j(this.zx, ((Long) map.get("id")).longValue(), (String) map.get(TTDownloadField.TT_LOG_EXTRA), (DownloadStatusChangeListener) null, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 15:
                return (T) Boolean.valueOf(g.j((Uri) map.get("uri")));
            case 16:
                g.j().j((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Long) map.get("id")).longValue(), ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue(), i(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)), g(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER)));
                return null;
            case 17:
                g.j().j((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Long) map.get("id")).longValue(), ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue(), i(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)), g(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER)), gv(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), lg(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                return null;
            case 18:
                return (T) Boolean.valueOf(g.j().q().j(((Long) map.get("id")).longValue(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 19:
                return (T) Boolean.valueOf(g.j().q().j(((Long) map.get("id")).longValue()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.j, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i2, Map<String, Object> map) {
        return i2 != 0 ? i2 != 1 ? (T) super.getObj(cls) : (T) Boolean.valueOf(g.zx) : (T) g.f6459j;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.j, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        super.init(bundle);
        g.j(this.zx);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bytedance.sdk.openadsdk.api.i.j().j(0, g.f6459j).j(1, Boolean.valueOf(g.zx)).zx();
    }

    private DownloadStatusChangeListener j(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        return null;
    }
}
