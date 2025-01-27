package com.ss.android.socialbase.appdownloader.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static final String f21843a = "d";

    /* renamed from: b */
    private static List<n> f21844b = new ArrayList();

    /* renamed from: c */
    private static com.ss.android.socialbase.appdownloader.view.a f21845c;

    /* renamed from: d */
    private static AlertDialog f21846d;

    /* renamed from: com.ss.android.socialbase.appdownloader.e.d$1 */
    public static class AnonymousClass1 implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 != 4) {
                return false;
            }
            if (keyEvent.getAction() == 1) {
                d.a(false);
            }
            return true;
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.e.d$2 */
    public static class AnonymousClass2 implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d.a(false);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.e.d$3 */
    public static class AnonymousClass3 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Activity f21847a;

        /* renamed from: b */
        final /* synthetic */ n f21848b;

        public AnonymousClass3(Activity activity, n nVar) {
            activity = activity;
            nVar = nVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d.b(activity, nVar);
            dialogInterface.cancel();
            AlertDialog unused = d.f21846d = null;
        }
    }

    public static void b(@NonNull Activity activity, @NonNull n nVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = f21843a;
                    com.ss.android.socialbase.appdownloader.view.a aVar = (com.ss.android.socialbase.appdownloader.view.a) fragmentManager.findFragmentByTag(str);
                    f21845c = aVar;
                    if (aVar == null) {
                        f21845c = new com.ss.android.socialbase.appdownloader.view.a();
                        fragmentManager.beginTransaction().add(f21845c, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    f21845c.a();
                    return;
                }
            } catch (Throwable th3) {
                try {
                    th3.printStackTrace();
                    nVar.a();
                    return;
                } catch (Throwable th4) {
                    th4.printStackTrace();
                    return;
                }
            }
        }
        nVar.a();
    }

    public static boolean a() {
        try {
            return NotificationManagerCompat.from(DownloadComponentManager.getAppContext()).areNotificationsEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public static synchronized void a(boolean z10) {
        synchronized (d.class) {
            try {
                AlertDialog alertDialog = f21846d;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    f21846d = null;
                }
                for (n nVar : f21844b) {
                    if (nVar != null) {
                        if (z10) {
                            nVar.a();
                        } else {
                            nVar.b();
                        }
                    }
                }
            } finally {
            }
        }
    }

    public static synchronized void a(@NonNull Activity activity, @NonNull n nVar) {
        synchronized (d.class) {
            if (nVar == null) {
                return;
            }
            if (activity != null) {
                try {
                } finally {
                    return;
                }
                if (!activity.isFinishing()) {
                    int a10 = i.a(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_title");
                    int a11 = i.a(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_message");
                    int a12 = i.a(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_yes");
                    int a13 = i.a(DownloadComponentManager.getAppContext(), "tt_appdownloader_notification_request_btn_no");
                    f21844b.add(nVar);
                    AlertDialog alertDialog = f21846d;
                    if (alertDialog != null) {
                        if (!alertDialog.isShowing()) {
                        }
                        return;
                    }
                    f21846d = new AlertDialog.Builder(activity).setTitle(a10).setMessage(a11).setPositiveButton(a12, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.3

                        /* renamed from: a */
                        final /* synthetic */ Activity f21847a;

                        /* renamed from: b */
                        final /* synthetic */ n f21848b;

                        public AnonymousClass3(Activity activity2, n nVar2) {
                            activity = activity2;
                            nVar = nVar2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i10) {
                            d.b(activity, nVar);
                            dialogInterface.cancel();
                            AlertDialog unused = d.f21846d = null;
                        }
                    }).setNegativeButton(a13, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i10) {
                            d.a(false);
                        }
                    }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.1
                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                            if (i10 != 4) {
                                return false;
                            }
                            if (keyEvent.getAction() == 1) {
                                d.a(false);
                            }
                            return true;
                        }
                    }).setCancelable(false).show();
                    return;
                }
            }
            nVar2.b();
        }
    }
}
