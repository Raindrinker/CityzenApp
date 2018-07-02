package com.example.ferri.cityzen;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class IntroActivity extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleTitle = {R.string.intro_badpark_title, R.string.intro_lovecars_title, R.string.intro_hangcars_title, R.string.intro_money_title};
    int[] sampleText = {R.string.intro_badpark_text, R.string.intro_lovecars_text, R.string.intro_hangcars_text, R.string.intro_money_text};
    int[] sampleImages = {R.drawable.intro_badpark, R.drawable.intro_lovecars, R.drawable.intro_hangcars, R.drawable.intro_money};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setViewListener(viewListener);

    }

    ViewListener viewListener = new ViewListener() {

        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(R.layout.carousel_view_custom, null);

            ImageView img = (ImageView) customView.findViewById(R.id.carousel_image);
            img.setImageResource(sampleImages[position]);
            TextView title = (TextView) customView.findViewById(R.id.carousel_title);
            title.setText(getString(sampleTitle[position]));
            TextView text = (TextView) customView.findViewById(R.id.carousel_text);
            text.setText(getString(sampleText[position]));

            return customView;
        }
    };


}
