package jjangdol.joalarm

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val fade_in = AlphaAnimation(0.0f, 1.0f)
        fade_in.duration = 500
        val fade_out = AlphaAnimation(1.0f, 0.0f)
        fade_out.duration = 500

        val textView_Welcome = findViewById<TextView>(R.id.textView_Welcome)
        val textView_Info = findViewById<TextView>(R.id.textView_Info)
        val linearLayout1 = findViewById<LinearLayout>(R.id.linear1)
        val imageView = findViewById<ImageView>(R.id.imageView_Loding)
        val linearLayout2 = findViewById<LinearLayout>(R.id.linear2)
        val textView_Distance = findViewById<TextView>(R.id.textView_Distance)
        val imageView_Button = findViewById<ImageView>(R.id.imageView_Button)

        val text1 = "나를 좋아하는 사람이\n반경 10M 안으로 들어오면\n알람이 울립니다."
        val textLen1 = text1.length
        val text2 = "당신의 마음을\n좋알람과\n동기화하시겠습니까?"
        val textLen2 = text2.length

        imageView_Button.visibility = View.INVISIBLE

        Observable.just("Welcome")
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { char ->
                    textView_Welcome.text = char
                    textView_Welcome.startAnimation(fade_in)
                }

        Observable.range(0, textLen1)
                .delay(1200L, TimeUnit.MILLISECONDS)
                .concatMap { Observable.just(it).delay(50, TimeUnit.MILLISECONDS) }
                .map { text1[it].toString() }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { char ->
                    textView_Info.text = textView_Info.text.toString().plus(char)
                }

        Observable.just("")
                .delay(1300L + 50 * textLen1, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { char ->
                    linearLayout1.animate().translationX(0F)
                    linearLayout1.animate().translationXBy(800F)
                    linearLayout1.animate().setDuration(1100L)
                }

        Observable.just("")
                .delay(1400L + 50 * textLen1, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { char ->
                    linearLayout2.animate().translationY(0F)
                    linearLayout2.animate().translationYBy(-300F)
                    linearLayout2.animate().setDuration(1500L)
                }

        Observable.range(0, 2)
                .delay(3300L + 50 * textLen1, TimeUnit.MILLISECONDS)
                .concatMap { Observable.just(it).delay(500, TimeUnit.MILLISECONDS) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { char ->
                    if (char == 0) {
                        textView_Welcome.startAnimation(fade_out)
                        textView_Info.startAnimation(fade_out)
                        imageView.startAnimation(fade_out)
                        textView_Distance.startAnimation(fade_out)
                    }
                    else {
                        textView_Welcome.text = ""
                        textView_Info.text = ""
                        imageView.visibility = View.INVISIBLE
                        textView_Distance.text = ""
                    }
                }

        Observable.just("SignUp")
                .delay(5200L + 50 * textLen1, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { char ->
                    textView_Welcome.text = char
                    textView_Welcome.startAnimation(fade_in)
                }

        Observable.range(0, textLen2)
                .delay(6400L + 50 * textLen1, TimeUnit.MILLISECONDS)
                .concatMap { Observable.just(it).delay(50, TimeUnit.MILLISECONDS) }
                .map { text2[it].toString() }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { char ->
                    textView_Info.text = textView_Info.text.toString().plus(char)
                }

        Observable.range(0, 4)
                .delay(6500L + 50 * textLen1 + 50 * textLen2, TimeUnit.MILLISECONDS)
                .concatMap { Observable.just(it).delay(300, TimeUnit.MILLISECONDS) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it == 0) {
                        imageView_Button.visibility = View.VISIBLE
                        imageView_Button.scaleX = 0.0f
                        imageView_Button.scaleY = 0.0f
                        imageView_Button.animate().scaleX(1.0f)
                        imageView_Button.animate().scaleY(1.0f)
                        imageView_Button.animate().translationY(-400f)
                        imageView_Button.animate().setDuration(300L)
                    }
                    else if (it == 1){
                        imageView_Button.animate().scaleX(0.8f)
                        imageView_Button.animate().scaleY(0.8f)
                        imageView_Button.animate().translationY(-300f)
                        imageView_Button.animate().setDuration(300L)
                    }
                    else if (it == 2){
                        imageView_Button.animate().scaleX(0.85f)
                        imageView_Button.animate().scaleY(0.85f)
                        imageView_Button.animate().translationY(-310f)
                        imageView_Button.animate().setDuration(300L)
                    }
                    else {
                        imageView_Button.animate().scaleX(0.8f)
                        imageView_Button.animate().scaleY(0.8f)
                        imageView_Button.animate().translationY(-300f)
                        imageView_Button.animate().setDuration(300L)
                    }
                }

//        Observable.just("")
//                .delay(6500L + 50 * textLen1 + 50 * textLen2, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.computation())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    imageView_Button.visibility = View.VISIBLE
//                    imageView_Button.scaleX = 0.0f
//                    imageView_Button.scaleY = 0.0f
//                    imageView_Button.animate().scaleX(0.8f)
//                    imageView_Button.animate().scaleY(0.8f)
//                    imageView_Button.animate().translationY(-400f)
//                    imageView_Button.animate().setDuration(300L)
//                }
    }
}