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
//        textView.append("Calendar.getInstance: ${calendar}\n")

        // calendar를 timeInMillis로 표현
        textView.append("calendar.timeInMillis: ${calendar.timeInMillis}\n")
        // 현재 요일이 Int 형으로 출력됨
        textView.append("curWeek: ${curWeek}\n")
        // 현재 시간 출력
        textView.append("curHour: ${curHour}\n")
        // 현재 분 출력
        textView.append("curMin: ${curMin}\n")



        // 강제로 Calendar에 날짜 set
        val calendar2: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            // 정확한 시간 설정
            set(Calendar.HOUR_OF_DAY, 2)
            set(Calendar.MINUTE, 30)
            set(Calendar.SECOND, 0)
        }

        textView2.append("Calendar에 특정 날짜 삽입하기\n")
//        textView2.append("calendar: ${calendar2}\n")
        textView2.append("calendar.timeInMillis: ${calendar2.timeInMillis}\n")

        // calendar2의 요일, 시간, 분 따로 출력
        val curWeek2 = calendar2.get(Calendar.DAY_OF_WEEK)
        val curHour2 = calendar2.get((Calendar.HOUR_OF_DAY))
        val curMin2 = calendar2.get(Calendar.MINUTE)

        // 현재 요일이 Int 형으로 출력됨
        textView2.append("curWeek2: ${curWeek2}\n")
        // 현재 시간 출력
        textView2.append("curHour2: ${curHour2}\n")
        // 현재 분 출력
        textView2.append("curMin2: ${curMin2}\n")

        val currentTime = System.currentTimeMillis()
        textView3.text = "currentTimeMillis: ${currentTime}\n"
        if (calendar2.timeInMillis > currentTime){
            textView3.append("calendar2의 timeInLillis가 currentTime보다 큼")
        }else{
            textView3.append("currentTime가 보다 calendar2의 timeInLillis큼")
        }
    }
    // 결론
    // 1. calendar의 timeInMillis과 System의 timeInMillis은 동일하다
    // 2. calendar.set에서 지정한 시간(시간+분)이 현재 시간보다 숫자상으로 작을 경우 과거로 자동 인식된다
    // 3. calendar.set에서 지정한 시간(시간+분)이 현재 시간보다 숫자상으로 클 경우 미래로 자동 인식된다
    // 4. 즉, 여기에도 diffTime을 적용하여 과거면 + 24시간 미래면 그대로 적용을 해야한다
}