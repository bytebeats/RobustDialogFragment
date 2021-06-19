package androidx.fragment.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDialog;
import androidx.annotation.RestrictTo.Scope;

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/6/19 17:24
 * @Version 1.0
 * @Description TO-DO
 */

public class AppCompatRobustDialogFragment extends RobustDialogFragment {
    public AppCompatRobustDialogFragment() {
    }

    public AppCompatRobustDialogFragment(int contentLayoutId) {
        super(contentLayoutId);
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AppCompatDialog(this.getContext(), this.getTheme());
    }

    @RestrictTo({Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int style) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog acd = (AppCompatDialog) dialog;
            switch (style) {
                case 3:
                    dialog.getWindow().addFlags(24);
                case 1:
                case 2:
                    acd.supportRequestWindowFeature(1);
            }
        } else {
            super.setupDialog(dialog, style);
        }

    }
}
