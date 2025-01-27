package com.alimm.tanx.core.ad.event.track.interaction;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.listener.bean.ITrackItem;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

/* loaded from: classes.dex */
public class InteractionUpload implements NotConfused {
    private static final String INTERACT_DESC = "__INTERACT_DESC__";
    private static final String INTERACT_TYPE = "__INTERACT_TYPE__";
    public static final int INTERACT_TYPE_CLOSE = 3;
    public static final int INTERACT_TYPE_POOR_CONTENT = 5;
    public static final int INTERACT_TYPE_UNINTERESTED = 4;
    private static final String TAG = "InteractionUpload";
    public static final int TYPE_AD_ACTION_5 = 5;
    public static final int TYPE_AD_CLOSE_8 = 8;
    public static final int TYPE_AD_INTERACT_CLICK_2002 = 2002;
    public static final int TYPE_AD_INTERACT_END_2003 = 2003;
    public static final int TYPE_AD_INTERACT_IMP_2001 = 2001;
    public static final int TYPE_SUB_AD_CLICK_7 = 7;
    public static final int TYPE_SUB_AD_EXPOSURE_6 = 6;
    public static final int TYPE_VIDEO_PLAYING_2 = 2;
    public static final int TYPE_VIDEO_PLAY_1 = 1;
    public static final int TYPE_VIDEO_PLAY_4 = 4;
    public static final int TYPE_VIDEO_PLAY_FINISH_3 = 3;
    private static InteractionUpload instance;

    /* renamed from: com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload$1 */
    public class AnonymousClass1 implements NetWorkCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            LogUtils.d(InteractionUpload.TAG, str2);
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void succ(Object obj) {
            LogUtils.d(InteractionUpload.TAG, "");
        }
    }

    public static InteractionUpload getInstance() {
        if (instance == null) {
            synchronized (InteractionUpload.class) {
                try {
                    if (instance == null) {
                        instance = new InteractionUpload();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private String replaceUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String replace = TextUtils.isEmpty(str2) ? str.replace(INTERACT_TYPE, "") : str.replace(INTERACT_TYPE, str2);
            return TextUtils.isEmpty(str3) ? replace.replace(INTERACT_DESC, "") : replace.replace(INTERACT_DESC, str3);
        } catch (Exception e10) {
            LogUtils.e("uploadInteraction", e10);
            return str;
        }
    }

    private void sendMonitor(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RequestBean build = new RequestBean().setUrl(str).build();
        build.setOverrideError(true);
        NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.1
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str2, String str22) {
                LogUtils.d(InteractionUpload.TAG, str22);
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void succ(Object obj) {
                LogUtils.d(InteractionUpload.TAG, "");
            }
        });
    }

    public void uploadInteraction(int i10, List<? extends ITrackItem> list) {
        uploadInteraction(i10, list, "", "");
    }

    public void uploadInteraction(int i10, List<? extends ITrackItem> list, int i11) {
        uploadInteraction(i10, list, i11, "");
    }

    public void uploadInteraction(int i10, List<? extends ITrackItem> list, int i11, String str) {
        uploadInteraction(i10, list, i11 + "", str);
    }

    public void uploadInteraction(int i10, List<? extends ITrackItem> list, String str, String str2) {
        if (list != null) {
            for (ITrackItem iTrackItem : list) {
                if (iTrackItem != null && iTrackItem.getType() == i10) {
                    for (String str3 : iTrackItem.getUrl()) {
                        if (i10 == 5) {
                            str3 = replaceUrl(str3, str, str2);
                        }
                        sendMonitor(str3);
                    }
                }
            }
        }
    }
}
