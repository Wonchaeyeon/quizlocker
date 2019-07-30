package kr.hs.emirim.yeon8091.quizlocker

import android.app.KeyguardManager
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_quiz_locker.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*


class QuizLockerActivity : AppCompatActivity() {
    var quiz:JSONObject? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1){
            setShowWhenLocked(true)

            val keyguardManager=getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.requestDismissKeyguard(this,null)
        }else{
            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_quiz_locker)

        val json =assets.open("capital.json").reader().readText()
        val quizArray=JSONArray(json)

        quiz = quizArray.getJSONObject(Random().nextInt(quizArray.length()))
        quizLabel.text=quiz?.getString("question")
        choice1.text=quiz?.getString("choice1")
        choice2.text=quiz?.getString("choice2")


    }
}
