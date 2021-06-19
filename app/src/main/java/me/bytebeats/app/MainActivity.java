package me.bytebeats.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(v -> popupBottomDialogFragment());
    }

    private void popupBottomDialogFragment() {
        RobustBottomDialogFragment fragment = new RobustBottomDialogFragment();
        fragment.show(getSupportFragmentManager(), "RobustBottomDialogFragment");
    }
}