package com.opos.mobad.d.a;

import android.content.Context;
import android.widget.RemoteViews;
import com.heytap.msp.mobad.api.R;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private Context f20428a;

    /* renamed from: b */
    private Map<Integer, RemoteViews> f20429b = new ConcurrentHashMap();

    public f(Context context) {
        this.f20428a = context;
    }

    public RemoteViews a(String str, String str2, int i2, int i3, int i4) {
        int a2;
        Map<Integer, RemoteViews> map = this.f20429b;
        RemoteViews remoteViews = map != null ? map.get(Integer.valueOf(i4)) : null;
        if (remoteViews == null) {
            remoteViews = new RemoteViews(this.f20428a.getPackageName(), com.opos.mobad.service.e.a(this.f20428a, "opos_mob_layout_download_manager", "layout"));
            this.f20429b.put(Integer.valueOf(i4), remoteViews);
        }
        remoteViews.setImageViewResource(com.opos.mobad.service.e.a(this.f20428a, "dl_icon_iv", "id"), com.opos.mobad.service.e.a(this.f20428a, "opos_mob_drawable_download_icon", "drawable"));
        remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_app_name_tv", "id"), str);
        remoteViews.setCharSequence(com.opos.mobad.service.e.a(this.f20428a, "dl_delete_bt", "id"), "setText", this.f20428a.getResources().getString(R.string.download_delete_bt_txt));
        if (i2 != 102) {
            if (i2 == 103) {
                remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_process_tv", "id"), str2);
                remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_process_tv", "id"), 0);
                remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_status_tv", "id"), this.f20428a.getResources().getString(R.string.download_status_pause_txt));
                remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_status_tv", "id"), 0);
                remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_fail_tv", "id"), 8);
                remoteViews.setCharSequence(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), "setText", this.f20428a.getResources().getString(R.string.download_continue_bt_txt));
                remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), 0);
                remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_process_bar", "id"), 4);
            } else {
                if (i2 == 106) {
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_status_tv", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_process_tv", "id"), 8);
                    remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_fail_tv", "id"), this.f20428a.getResources().getString(R.string.download_status_fail_txt));
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_fail_tv", "id"), 0);
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), 0);
                    remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), this.f20428a.getResources().getString(R.string.download_retry_bt_txt));
                } else if (i2 == 105) {
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_status_tv", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_process_tv", "id"), 8);
                    remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_fail_tv", "id"), this.f20428a.getResources().getString(R.string.download_status_complete_txt));
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_fail_tv", "id"), 0);
                    remoteViews.setCharSequence(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), "setText", this.f20428a.getResources().getString(R.string.download_install_bt_txt));
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), 0);
                } else if (i2 == 107) {
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_status_tv", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_process_bar", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_process_tv", "id"), 8);
                    remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), 4);
                    remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_fail_tv", "id"), this.f20428a.getResources().getString(R.string.download_status_waiting_txt));
                    a2 = com.opos.mobad.service.e.a(this.f20428a, "dl_fail_tv", "id");
                }
                remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_process_bar", "id"), 8);
            }
            return remoteViews;
        }
        remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_process_tv", "id"), str2);
        remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_process_tv", "id"), 0);
        remoteViews.setTextViewText(com.opos.mobad.service.e.a(this.f20428a, "dl_status_tv", "id"), this.f20428a.getResources().getString(R.string.download_status_downloading_txt));
        remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_status_tv", "id"), 0);
        remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_fail_tv", "id"), 8);
        remoteViews.setCharSequence(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), "setText", this.f20428a.getResources().getString(R.string.download_pause_bt_txt));
        remoteViews.setViewVisibility(com.opos.mobad.service.e.a(this.f20428a, "dl_ctrl_bt", "id"), 0);
        remoteViews.setProgressBar(com.opos.mobad.service.e.a(this.f20428a, "dl_process_bar", "id"), 100, i3, false);
        a2 = com.opos.mobad.service.e.a(this.f20428a, "dl_process_bar", "id");
        remoteViews.setViewVisibility(a2, 0);
        return remoteViews;
    }

    public void a() {
        Map<Integer, RemoteViews> map = this.f20429b;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f20429b.clear();
    }

    public void a(int i2) {
        Map<Integer, RemoteViews> map = this.f20429b;
        if (map == null || map.size() <= 0 || !this.f20429b.containsKey(Integer.valueOf(i2))) {
            return;
        }
        this.f20429b.remove(Integer.valueOf(i2));
    }
}
