package com.blogspot.hongthaiit.slideup;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;


public class MainActivity extends Activity {

    private SlidingUpPanelLayout slidingLayout;
    private Button btnShow;
    private Button btnHide;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button)findViewById(R.id.btn_show);
        btnHide = (Button)findViewById(R.id.btn_hide);
        textView = (TextView)findViewById(R.id.text);
        slidingLayout = (SlidingUpPanelLayout)findViewById(R.id.sliding_layout);

        //some "demo" event
        slidingLayout.setPanelSlideListener(onSlideListener());
        btnHide.setOnClickListener(onHideListener());
        btnShow.setOnClickListener(onShowListener());
    }

    /**
     * Request show sliding layout when clicked
     * @return
     */
    private View.OnClickListener onShowListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show sliding layout in bottom of screen (not expand it)
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                btnShow.setVisibility(View.GONE);
            }
        };
    }

    /**
     * Hide sliding layout when click button
     * @return
     */
    private View.OnClickListener onHideListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide sliding layout
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
                btnShow.setVisibility(View.VISIBLE);
            }
        };
    }

    private SlidingUpPanelLayout.PanelSlideListener onSlideListener() {
        return new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View view, float v) {
                textView.setText("panel is sliding");
            }

            @Override
            public void onPanelCollapsed(View view) {
                textView.setText("panel Collapse");
            }

            @Override
            public void onPanelExpanded(View view) {
                textView.setText("panel expand");
            }

            @Override
            public void onPanelAnchored(View view) {
                textView.setText("panel anchored");
            }

            @Override
            public void onPanelHidden(View view) {
                textView.setText("panel is Hidden");
            }
        };
    }
}
