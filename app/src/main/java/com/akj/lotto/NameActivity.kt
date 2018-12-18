package com.akj.lotto

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        // 번호 생성 버튼의 클릭이벤트 리스너 설정
        goButton.setOnClickListener {
            // 입력된 이름이 없으면 토스트 메세지 출력후 리턴
            if (TextUtils.isEmpty(editText.text.toString())) return@setOnClickListener

            // ResultActivity 를 시작하는 Intent 생성
            val intent = Intent(this, ResultActivity::class.java)
            // intent 의 결과 데이터를 전달한다.
            // int 의 리스트를 전달하므로 putIntegerArrayListExtra 를 사용한다.
            // 전달하는 리스트는 이름의 해시코드로 생성한 로또 번호
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(editText.text.toString())))

            // 입력받은 이름을 추가로 전달한다.
            intent.putExtra("name", editText.text.toString())
            // ResultActivity 를 시작하는 Intent 를 만들고 startActivity 로 실행
            startActivity(intent)
        }

        // 뒤로가기 버튼의 클릭이벤트 리스너 설정
        backButton.setOnClickListener {
            // 액티비티 종료
            finish()
        }
    }

    /**
     * 입력받은 이름에 대한 해시코드를 사용하여 로또 번호를 섞고 결과를 반환한다.
     */
    fun getLottoNumbersFromHash(name: String): MutableList<Int> {
        // 1 ~ 45 번에 로또 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()
        // 1~45 까지 for 문을 돌면서 리스트에 로또 번호 저장
        for (number in 1..45) {
            list.add(number)
        }

        // SimpleDateFormat 은 날짜의 시간값을 포맷화된 텍스트 형태로 바꿔주는 클래스
        // 현재 Date 의 "yyyy-MM-dd” 문자열과 이름 문자열을 합친다
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name

        // 리스트를 무작위로 섞는다. 이때 섞는 기준으로 Random(SEED) 를 사용한다
        // SEED 값은 전달받은 이름과 오늘의 해당하는 "yyyy-MM-dd” 를 합친 문자열의 해시코드를 사용한다.
        list.shuffle(Random(targetString.hashCode().toLong()))
        // 리스트를 앞에서부터 순서대로 6개를 짤라 결과 반환
        return list.subList(0, 6)
    }


}