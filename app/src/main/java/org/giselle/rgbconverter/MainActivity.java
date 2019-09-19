package org.giselle.rgbconverter;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar Color1, Color2, Color3;
    TextView textView, Text1, Text2, Text3;
    View colorSample;
    int r=0, g=0, b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Color1 = (SeekBar) findViewById(R.id.Color1) ;
        Color2 = (SeekBar) findViewById(R.id.Color2) ;
        Color3 = (SeekBar) findViewById(R.id.Color3) ;
        textView = (TextView) findViewById(R.id.textView);
        colorSample = (View) findViewById(R.id.colorSample);
        Text1 = (TextView) findViewById(R.id.Text1);
        Text2 = (TextView) findViewById(R.id.Text2);
        Text3 = (TextView) findViewById(R.id.Text3);

        Color1.setOnSeekBarChangeListener(this);
        Color2.setOnSeekBarChangeListener(this);
        Color3.setOnSeekBarChangeListener(this);

        textView.setText("#00000");
        Text1.setText("R: ");
        Text2.setText("G: ");
        Text3.setText("B: ");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.Color1:
                r=progress;
                break;

            case R.id.Color2:
                g=progress;
                break;

            case R.id.Color3:
                b=progress;
                break;
        }

        String c = ColorHex(r,g,b);
        textView.setText(" " + c);
        colorSample.setBackgroundColor(android.graphics.Color.rgb(r,b,g));

    }

    public String ColorHex( int r, int g, int b){
        String color = "";
        color = "#";
        color += Integer.toHexString(r);
        color += Integer.toHexString(g);
        color += Integer.toHexString(b);

        return color;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Text1.setText ("R: " + r);
        Text2.setText("G: " + g);
        Text3.setText("B: " + b);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Text1.setText ("R: " + r);
        Text2.setText("G: " + g);
        Text3.setText("B: " + b);
    }
}
