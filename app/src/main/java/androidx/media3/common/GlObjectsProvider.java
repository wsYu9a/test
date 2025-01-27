package androidx.media3.common;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes.dex */
public interface GlObjectsProvider {

    @Deprecated
    public static final GlObjectsProvider DEFAULT = new GlObjectsProvider() { // from class: androidx.media3.common.GlObjectsProvider.1
        @Override // androidx.media3.common.GlObjectsProvider
        public GlTextureInfo createBuffersForTexture(int i10, int i11, int i12) throws GlUtil.GlException {
            return new GlTextureInfo(i10, GlUtil.createFboForTexture(i10), -1, i11, i12);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        @RequiresApi(17)
        public EGLContext createEglContext(EGLDisplay eGLDisplay, int i10, int[] iArr) throws GlUtil.GlException {
            return GlUtil.createEglContext(EGL14.EGL_NO_CONTEXT, eGLDisplay, i10, iArr);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        @RequiresApi(17)
        public EGLSurface createEglSurface(EGLDisplay eGLDisplay, Object obj, int i10, boolean z10) throws GlUtil.GlException {
            return GlUtil.createEglSurface(eGLDisplay, obj, i10, z10);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        @RequiresApi(17)
        public EGLSurface createFocusedPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay, int[] iArr) throws GlUtil.GlException {
            return GlUtil.createFocusedPlaceholderEglSurface(eGLContext, eGLDisplay, iArr);
        }
    };

    /* renamed from: androidx.media3.common.GlObjectsProvider$1 */
    public class AnonymousClass1 implements GlObjectsProvider {
        @Override // androidx.media3.common.GlObjectsProvider
        public GlTextureInfo createBuffersForTexture(int i10, int i11, int i12) throws GlUtil.GlException {
            return new GlTextureInfo(i10, GlUtil.createFboForTexture(i10), -1, i11, i12);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        @RequiresApi(17)
        public EGLContext createEglContext(EGLDisplay eGLDisplay, int i10, int[] iArr) throws GlUtil.GlException {
            return GlUtil.createEglContext(EGL14.EGL_NO_CONTEXT, eGLDisplay, i10, iArr);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        @RequiresApi(17)
        public EGLSurface createEglSurface(EGLDisplay eGLDisplay, Object obj, int i10, boolean z10) throws GlUtil.GlException {
            return GlUtil.createEglSurface(eGLDisplay, obj, i10, z10);
        }

        @Override // androidx.media3.common.GlObjectsProvider
        @RequiresApi(17)
        public EGLSurface createFocusedPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay, int[] iArr) throws GlUtil.GlException {
            return GlUtil.createFocusedPlaceholderEglSurface(eGLContext, eGLDisplay, iArr);
        }
    }

    GlTextureInfo createBuffersForTexture(int i10, int i11, int i12) throws GlUtil.GlException;

    @RequiresApi(17)
    EGLContext createEglContext(EGLDisplay eGLDisplay, @IntRange(from = 2, to = 3) int i10, int[] iArr) throws GlUtil.GlException;

    @RequiresApi(17)
    EGLSurface createEglSurface(EGLDisplay eGLDisplay, Object obj, int i10, boolean z10) throws GlUtil.GlException;

    @RequiresApi(17)
    EGLSurface createFocusedPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay, int[] iArr) throws GlUtil.GlException;
}
