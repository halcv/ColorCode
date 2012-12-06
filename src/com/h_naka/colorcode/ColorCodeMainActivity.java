package com.h_naka.colorcode;

import android.os.Bundle;
import android.app.Activity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ColorCodeMainActivity
	extends Activity
	implements OnSeekBarChangeListener {

	private SeekBar m_redSeekBar;
	private SeekBar m_greenSeekBar;
	private SeekBar m_blueSeekBar;
	private TextView m_textColorView;
	private TextView m_imageColorView;
	
	private int m_iRed;
	private int m_iGreen;
	private int m_iBlue;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		initChild();
	}

	private void initChild() {
		m_iRed   = 128;
		m_iGreen = 128;
		m_iBlue  = 128;

		m_redSeekBar = (SeekBar)findViewById(R.id.redBar);
		m_greenSeekBar = (SeekBar)findViewById(R.id.greenBar);
		m_blueSeekBar = (SeekBar)findViewById(R.id.blueBar);
		m_textColorView = (TextView)findViewById(R.id.colorCodeView);
		m_imageColorView = (TextView)findViewById(R.id.colorView);

		// 赤色調整用シークバーの作成
		m_redSeekBar.setProgressDrawable(new ColorDrawable(Color.RED));
		m_redSeekBar.setMax(255);
		m_redSeekBar.setProgress(m_iRed);
		m_redSeekBar.setOnSeekBarChangeListener(this);
		
		// 緑色調整用シークバーの作成
		m_greenSeekBar.setProgressDrawable(new ColorDrawable(Color.GREEN));
		m_greenSeekBar.setMax(255);
		m_greenSeekBar.setProgress(m_iGreen);
		m_greenSeekBar.setOnSeekBarChangeListener(this);

		// 青色調整用シークバーの作成
		m_blueSeekBar.setProgressDrawable(new ColorDrawable(Color.BLUE));
		m_blueSeekBar.setMax(255);
		m_blueSeekBar.setProgress(m_iBlue);
		m_blueSeekBar.setOnSeekBarChangeListener(this);

		// 色の値を表示するテキストビューの文字列を更新
		updateTextColorView();
		
		// 色を表示するテキストビューの背景色を更新する。
		updateImageColorView();
	}

	private void updateTextColorView() {
		String str = String.format("#%02X%02X%02X",m_iRed,m_iGreen,m_iBlue);
		m_textColorView.setText(str);
	}

	private void updateImageColorView() {
		m_imageColorView.setBackgroundColor(Color.rgb(m_iRed,m_iGreen,m_iBlue));
	}
	
	// トラッキング開始時に呼び出されます
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		int iProgress = seekBar.getProgress();
		switch(seekBar.getId()) {
		case R.id.redBar:
			m_iRed = iProgress;
			break;
		case R.id.greenBar:
			m_iGreen = iProgress;
			break;
		case R.id.blueBar:
			m_iBlue = iProgress;
			break;
		}

		updateTextColorView();
		updateImageColorView();
	}
				
	// トラッキング中に呼び出されます
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
		int iProgress = seekBar.getProgress();
		switch(seekBar.getId()) {
		case R.id.redBar:
			m_iRed = iProgress;
			break;
		case R.id.greenBar:
			m_iGreen = iProgress;
			break;
		case R.id.blueBar:
			m_iBlue = iProgress;
			break;
		}

		updateTextColorView();
		updateImageColorView();
	}

// トラッキング終了時に呼び出されます
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		int iProgress = seekBar.getProgress();
		switch(seekBar.getId()) {
		case R.id.redBar:
			m_iRed = iProgress;
			break;
		case R.id.greenBar:
			m_iGreen = iProgress;
			break;
		case R.id.blueBar:
			m_iBlue = iProgress;
			break;
		}

		updateTextColorView();
		updateImageColorView();
	}
}
