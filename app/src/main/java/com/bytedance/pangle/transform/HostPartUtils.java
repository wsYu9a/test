package com.bytedance.pangle.transform;

import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;

@Keep
/* loaded from: classes.dex */
public class HostPartUtils {
    private Class fragmentActivityClazz;

    static class a {

        /* renamed from: a */
        private static final HostPartUtils f6306a = new HostPartUtils();
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }

    public static final Class getFragmentActivityClass() {
        return a.f6306a.fragmentActivityClazz;
    }
}
