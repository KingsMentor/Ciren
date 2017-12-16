package xyz.belvi.ciren.views.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import xyz.belvi.ciren.R;
import xyz.belvi.ciren.models.Ciren;

public class CirenDetailed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciren_detailed);
        Ciren ciren = getIntent().getParcelableExtra("ciren");
        ((AppCompatImageView) findViewById(R.id.ciren_img)).setImageDrawable(ContextCompat.getDrawable(this, ciren.getResouceId()));
        ((AppCompatTextView) findViewById(R.id.ciren_title)).setText(ciren.getName());
    }
}
