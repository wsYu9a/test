package com.ss.android.socialbase.appdownloader.q;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.i.r;
import com.ss.android.socialbase.appdownloader.k;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: g */
    private static AlertDialog f24479g = null;

    /* renamed from: i */
    private static com.ss.android.socialbase.appdownloader.view.j f24480i = null;

    /* renamed from: j */
    private static final String f24481j = "g";
    private static List<r> zx = new ArrayList();

    /* renamed from: com.ss.android.socialbase.appdownloader.q.g$1 */
    static class AnonymousClass1 implements DialogInterface.OnKeyListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4) {
                return false;
            }
            if (keyEvent.getAction() == 1) {
                g.j(false);
            }
            return true;
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.q.g$2 */
    static class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            g.j(false);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.q.g$3 */
    static class AnonymousClass3 implements DialogInterface.OnClickListener {

        /* renamed from: j */
        final /* synthetic */ Activity f24482j;
        final /* synthetic */ r zx;

        AnonymousClass3(Activity activity, r rVar) {
            activity = activity;
            rVar = rVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            g.zx(activity, rVar);
            dialogInterface.cancel();
            AlertDialog unused = g.f24479g = null;
        }
    }

    public static void zx(@NonNull Activity activity, @NonNull r rVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = f24481j;
                    com.ss.android.socialbase.appdownloader.view.j jVar = (com.ss.android.socialbase.appdownloader.view.j) fragmentManager.findFragmentByTag(str);
                    f24480i = jVar;
                    if (jVar == null) {
                        f24480i = new com.ss.android.socialbase.appdownloader.view.j();
                        fragmentManager.beginTransaction().add(f24480i, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    f24480i.j();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    rVar.j();
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
        }
        rVar.j();
    }

    public static boolean j() {
        try {
            return NotificationManagerCompat.from(DownloadComponentManager.getAppContext()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void j(boolean z) {
        synchronized (g.class) {
            try {
                AlertDialog alertDialog = f24479g;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    f24479g = null;
                }
                for (r rVar : zx) {
                    if (rVar != null) {
                        if (z) {
                            rVar.j();
                        } else {
                            rVar.zx();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void j(@NonNull Activity activity, @NonNull r rVar) {
        synchronized (g.class) {
            if (rVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } catch (Throwable th) {
                    th.printStackTrace();
                    j(false);
                }
                if (!activity.isFinishing()) {
                    int j2 = k.j(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_title");
                    int j3 = k.j(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_message");
                    int j4 = k.j(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_yes");
                    int j5 = k.j(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_no");
                    zx.add(rVar);
                    AlertDialog alertDialog = f24479g;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        f24479g = new AlertDialog.Builder(activity).setTitle(j2).setMessage(j3).setPositiveButton(j4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.q.g.3

                            /* renamed from: j */
                            final /* synthetic */ Activity f24482j;
                            final /* synthetic */ r zx;

                            AnonymousClass3(Activity activity2, r rVar2) {
                                activity = activity2;
                                rVar = rVar2;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                g.zx(activity, rVar);
                                dialogInterface.cancel();
                                AlertDialog unused = g.f24479g = null;
                            }
                        }).setNegativeButton(j5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.q.g.2
                            AnonymousClass2() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                g.j(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.q.g.1
                            AnonymousClass1() {
                            }

                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                                if (i2 != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    g.j(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            }
            rVar2.zx();
        }
    }
}
