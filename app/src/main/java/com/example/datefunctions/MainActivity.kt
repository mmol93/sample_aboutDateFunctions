package com.example.datefunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 현재 시간에 대한 값을 표시
        val calendar = Calendar.getInstance()
        val curWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val curHour = calendar.get((Calendar.HOUR_OF_DAY))
        val curMin = calendar.get(Calendar.MINUTE)

        textView.append("현재 날짜에 대한 표시\n")
        // 메모리 주소가 출력됨
        textView.append("Calendar.getInstance: ${calendar}\n")
        // 현재 요일이 Int 형으로 출력됨
        textView.append("curWeek: ${curWeek}\n")
        // 현재 시간 출력
        textView.append("curHour: ${curHour}\n")
        // 현재 분 출력
        textView.append("curMin: $curMin")

        // 강제로 Calendar에 날짜 set
        val calendar2: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            // 정확한 시간 설정
            set(Calendar.HOUR_OF_DAY, 13)
            set(Calendar.MINUTE, 30)
            set(Calendar.SECOND, 0)
        }

        textView2.append("Calendar에 특정 날짜 삽입하기\n")
        textView2.append("calendar: ${calendar2}\n")
        textView2.append("calendar.timeInMillis: ${calendar2.timeInMillis}\n")
    }
}