package com.example.quiz

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navController = this.findNavController(R.id.navHost)

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(!navController.popBackStack()){
                    //If no fragments in the back stack, exit the activity
                    finish()
                }
            }

        })
    }

}

/*
Offer a variety of quiz categories (e.g., Science, History, Sports, Entertainment). ✅
Multiple Choice Questions (MCQs). ✅
Fill-in-the-Blank.
Add a countdown timer for each question or quiz to make it more challenging. ✅
Award points for correct answers. ✅
Shuffle questions to ensure no two quizzes feel the same. ✅
Allow users to choose difficulty levels (easy, medium, hard).
Increase difficulty as the quiz progresses.
Display the correct answer if the user gets it wrong.
Provide light and dark themes for better user experience.
 */