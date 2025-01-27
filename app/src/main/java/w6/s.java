package w6;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.gyf.immersionbar.RequestBarManagerFragment;
import com.gyf.immersionbar.SupportRequestBarManagerFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class s implements Handler.Callback {

    /* renamed from: i */
    public static final int f31658i = 1;

    /* renamed from: j */
    public static final int f31659j = 2;

    /* renamed from: k */
    public static final int f31660k = 3;

    /* renamed from: l */
    public static final int f31661l = 4;

    /* renamed from: b */
    public final String f31662b;

    /* renamed from: c */
    public final String f31663c;

    /* renamed from: d */
    public final Handler f31664d;

    /* renamed from: e */
    public final Map<FragmentManager, RequestBarManagerFragment> f31665e;

    /* renamed from: f */
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestBarManagerFragment> f31666f;

    /* renamed from: g */
    public final Map<String, RequestBarManagerFragment> f31667g;

    /* renamed from: h */
    public final Map<String, SupportRequestBarManagerFragment> f31668h;

    public static class b {

        /* renamed from: a */
        public static final s f31669a = new s();
    }

    public /* synthetic */ s(a aVar) {
        this();
    }

    public static <T> void a(@Nullable T t10, @NonNull String str) {
        if (t10 == null) {
            throw new NullPointerException(str);
        }
    }

    public static s k() {
        return b.f31669a;
    }

    public void b(Activity activity, Dialog dialog, boolean z10) {
        if (activity == null || dialog == null) {
            return;
        }
        String str = this.f31662b + dialog.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        if (activity instanceof FragmentActivity) {
            m(((FragmentActivity) activity).getSupportFragmentManager(), str, true);
        } else {
            j(activity.getFragmentManager(), str, true);
        }
    }

    @RequiresApi(api = 17)
    public void c(Fragment fragment, boolean z10) {
        if (fragment == null) {
            return;
        }
        String str = this.f31662b + fragment.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        j(fragment.getChildFragmentManager(), str, true);
    }

    public void d(androidx.fragment.app.Fragment fragment, boolean z10) {
        if (fragment == null) {
            return;
        }
        String str = this.f31662b + fragment.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        m(fragment.getChildFragmentManager(), str, true);
    }

    public com.gyf.immersionbar.d e(Activity activity, Dialog dialog, boolean z10) {
        a(activity, "activity is null");
        a(dialog, "dialog is null");
        String str = this.f31662b + dialog.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? l(((FragmentActivity) activity).getSupportFragmentManager(), str).j(activity, dialog) : i(activity.getFragmentManager(), str).a(activity, dialog);
    }

    public com.gyf.immersionbar.d f(Activity activity, boolean z10) {
        a(activity, "activity is null");
        String str = this.f31662b + activity.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(activity) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? l(((FragmentActivity) activity).getSupportFragmentManager(), str).k(activity) : i(activity.getFragmentManager(), str).b(activity);
    }

    @RequiresApi(api = 17)
    public com.gyf.immersionbar.d g(Fragment fragment, boolean z10) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f31662b + fragment.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return i(fragment.getChildFragmentManager(), str).b(fragment);
    }

    public com.gyf.immersionbar.d h(androidx.fragment.app.Fragment fragment, boolean z10) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof androidx.fragment.app.DialogFragment) {
            a(((androidx.fragment.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f31662b + fragment.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return l(fragment.getChildFragmentManager(), str).k(fragment);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            this.f31665e.remove((FragmentManager) message.obj);
            return true;
        }
        if (i10 == 2) {
            this.f31666f.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
        if (i10 == 3) {
            this.f31667g.remove((String) message.obj);
            return true;
        }
        if (i10 != 4) {
            return false;
        }
        this.f31668h.remove((String) message.obj);
        return true;
    }

    public final RequestBarManagerFragment i(FragmentManager fragmentManager, String str) {
        return j(fragmentManager, str, false);
    }

    public final RequestBarManagerFragment j(FragmentManager fragmentManager, String str, boolean z10) {
        List<Fragment> fragments;
        RequestBarManagerFragment requestBarManagerFragment = (RequestBarManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestBarManagerFragment == null && (requestBarManagerFragment = this.f31665e.get(fragmentManager)) == null) {
            if (z10) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                fragments = fragmentManager.getFragments();
                for (Fragment fragment : fragments) {
                    if (fragment instanceof RequestBarManagerFragment) {
                        String tag = fragment.getTag();
                        if (tag == null) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        } else if (tag.contains(".tag.notOnly.")) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        }
                    }
                }
            }
            requestBarManagerFragment = new RequestBarManagerFragment();
            this.f31665e.put(fragmentManager, requestBarManagerFragment);
            fragmentManager.beginTransaction().add(requestBarManagerFragment, str).commitAllowingStateLoss();
            this.f31664d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z10) {
            return requestBarManagerFragment;
        }
        if (this.f31667g.get(str) == null) {
            this.f31667g.put(str, requestBarManagerFragment);
            fragmentManager.beginTransaction().remove(requestBarManagerFragment).commitAllowingStateLoss();
            this.f31664d.obtainMessage(3, str).sendToTarget();
        }
        return null;
    }

    public final SupportRequestBarManagerFragment l(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return m(fragmentManager, str, false);
    }

    public final SupportRequestBarManagerFragment m(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z10) {
        SupportRequestBarManagerFragment supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestBarManagerFragment == null && (supportRequestBarManagerFragment = this.f31666f.get(fragmentManager)) == null) {
            if (z10) {
                return null;
            }
            for (androidx.fragment.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment instanceof SupportRequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    }
                }
            }
            supportRequestBarManagerFragment = new SupportRequestBarManagerFragment();
            this.f31666f.put(fragmentManager, supportRequestBarManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestBarManagerFragment, str).commitAllowingStateLoss();
            this.f31664d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z10) {
            return supportRequestBarManagerFragment;
        }
        if (this.f31668h.get(str) == null) {
            this.f31668h.put(str, supportRequestBarManagerFragment);
            fragmentManager.beginTransaction().remove(supportRequestBarManagerFragment).commitAllowingStateLoss();
            this.f31664d.obtainMessage(4, str).sendToTarget();
        }
        return null;
    }

    public s() {
        this.f31662b = com.gyf.immersionbar.d.class.getName() + p1.b.f29697h;
        this.f31663c = ".tag.notOnly.";
        this.f31665e = new HashMap();
        this.f31666f = new HashMap();
        this.f31667g = new HashMap();
        this.f31668h = new HashMap();
        this.f31664d = new Handler(Looper.getMainLooper(), this);
    }
}
