package me.bytebeats.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.AppCompatRobustDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/6/19 17:45
 * @Version 1.0
 * @Description TO-DO
 */

public class RobustBottomDialogFragment extends AppCompatRobustDialogFragment {
    public RobustBottomDialogFragment() {
        super(R.layout.dialog_fragment_robust_bottom);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new BottomSheetDialog(requireContext(), getTheme());
    }
}
