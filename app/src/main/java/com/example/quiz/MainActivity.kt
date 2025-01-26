package com.example.quiz

import android.os.Bundle
import android.view.Menu
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navController = this.findNavController(R.id.navHost)

        val backBtnDialog = AlertDialog.Builder(this)
            .setTitle("Quiz")
            .setMessage("Are you sure?")
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }.create()

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!navController.popBackStack()) {
                    //If no fragments in the back stack, exit the activity
                    backBtnDialog.show()
                }
            }
        })
    }
}

/*
Offer a variety of quiz categories (e.g., Science, History, Sports, Entertainment). ✅
Multiple Choice Questions (MCQs). ✅
Add a countdown timer for each question or quiz to make it more challenging. ✅
Award points for correct answers. ✅
Shuffle questions to ensure no two quizzes feel the same. ✅
Display the correct answer if the user gets it wrong. ✅
 */