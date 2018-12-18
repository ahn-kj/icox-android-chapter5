package com.akj.lotto

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_constellation.*

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)
        // 로또번호 확인 버튼의 클릭이벤트 리스너 설정
        goResultButton.setOnClickListener {
            // ResultActivity 를 시작하는 인텐트를 만들고 startActivity 로 실행
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }
}