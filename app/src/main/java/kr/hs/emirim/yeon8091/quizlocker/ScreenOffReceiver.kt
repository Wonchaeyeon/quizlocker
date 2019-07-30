package kr.hs.emirim.yeon8091.quizlocker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ScreenOffReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when{
            intent?.action == Intent.ACTION_SCREEN_OFF->{
                Log.d("스크린오프리시버","퀴즈잠금: 화면이 꺼졌습니다.")
              val intent = Intent(context,QuizLockerActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)      //화면에 보여달라.
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)     //화면에 있는걸 싹 지워달라.
                context?.startActivity(intent)
            }
        }
    }
}