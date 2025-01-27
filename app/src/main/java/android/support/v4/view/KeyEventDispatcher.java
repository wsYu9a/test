package android.support.v4.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.view.animation.C0005;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.google.gason.stream.C0106;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class KeyEventDispatcher {
    private static boolean sActionBarFieldsFetched;
    private static Method sActionBarOnMenuKeyMethod;
    private static boolean sDialogFieldsFetched;
    private static Field sDialogKeyListenerField;

    /* renamed from: short */
    private static final short[] f31short;

    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(536062)}[0]).intValue() ^ 536034];
        sArr[0] = 1797;
        sArr[1] = 1796;
        sArr[2] = 1831;
        sArr[3] = 1807;
        sArr[4] = 1796;
        sArr[5] = 1823;
        sArr[6] = 1825;
        sArr[7] = 1807;
        sArr[8] = 1811;
        sArr[9] = 1839;
        sArr[10] = 1820;
        sArr[11] = 1807;
        sArr[12] = 1796;
        sArr[13] = 1822;
        sArr[14] = 883;
        sArr[15] = 849;
        sArr[16] = 880;
        sArr[17] = 853;
        sArr[18] = 891;
        sArr[19] = 871;
        sArr[20] = 850;
        sArr[21] = 887;
        sArr[22] = 877;
        sArr[23] = 874;
        sArr[24] = 891;
        sArr[25] = 880;
        sArr[26] = 891;
        sArr[27] = 876;
        f31short = sArr;
        sActionBarFieldsFetched = false;
        sActionBarOnMenuKeyMethod = null;
        sDialogFieldsFetched = false;
        sDialogKeyListenerField = null;
    }

    private KeyEventDispatcher() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean actionBarOnMenuKeyEventPre28(ActionBar actionBar, KeyEvent keyEvent) {
        Integer num = new Integer(6665686);
        boolean z = sActionBarFieldsFetched;
        int intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 6665687;
        if (!z) {
            try {
                Class<?> cls = actionBar.getClass();
                String m46 = C0106.m46(f31short, 1749571 ^ C0008.m27((Object) "ۢ۟۠"), 1750598 ^ C0008.m27((Object) "ۣۡۦ"), C0008.m27((Object) "۟۠") ^ 56459);
                Class<?>[] clsArr = new Class[intValue];
                clsArr[0] = KeyEvent.class;
                sActionBarOnMenuKeyMethod = cls.getMethod(m46, clsArr);
            } catch (NoSuchMethodException e2) {
            }
            sActionBarFieldsFetched = intValue;
        }
        Method method = sActionBarOnMenuKeyMethod;
        if (method != null) {
            try {
                Object[] objArr = new Object[intValue];
                objArr[0] = keyEvent;
                return ((Boolean) method.invoke(actionBar, objArr)).booleanValue();
            } catch (IllegalAccessException e3) {
            } catch (InvocationTargetException e4) {
            }
        }
        return false;
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity activity, KeyEvent keyEvent) {
        Integer num = new Integer(9280735);
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(((Integer) new Object[]{num}[0]).intValue() ^ 9280727)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && actionBarOnMenuKeyEventPre28(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener dialogKeyListenerPre28 = getDialogKeyListenerPre28(dialog);
        if (dialogKeyListenerPre28 != null && dialogKeyListenerPre28.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    public static boolean dispatchBeforeHierarchy(View view, KeyEvent keyEvent) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(view, keyEvent);
    }

    public static boolean dispatchKeyEvent(Component component, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (component == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 28 ? component.superDispatchKeyEvent(keyEvent) : callback instanceof Activity ? activitySuperDispatchKeyEventPre28((Activity) callback, keyEvent) : callback instanceof Dialog ? dialogSuperDispatchKeyEventPre28((Dialog) callback, keyEvent) : (view != null && ViewCompat.dispatchUnhandledKeyEventBeforeCallback(view, keyEvent)) || component.superDispatchKeyEvent(keyEvent);
    }

    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog dialog) {
        if (!sDialogFieldsFetched) {
            try {
                Field declaredField = Dialog.class.getDeclaredField(C0005.m17(f31short, 1755567 ^ C0008.m27((Object) "ۨۦ۟"), 1754604 ^ C0008.m27((Object) "ۧۦۡ"), C0008.m27((Object) "ۣۤۧ") ^ 1750456));
                sDialogKeyListenerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            sDialogFieldsFetched = true;
        }
        Field field = sDialogKeyListenerField;
        if (field != null) {
            try {
                return (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException e3) {
            }
        }
        return null;
    }
}
