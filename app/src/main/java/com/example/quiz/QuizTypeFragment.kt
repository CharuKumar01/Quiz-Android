package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quiz.databinding.FragmentQuizTypeBinding


class QuizTypeFragment : Fragment() {
    private lateinit var bind: FragmentQuizTypeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_type, container, false)

        bind.scienceBtn.setOnClickListener {
            view?.findNavController()?.navigate(QuizTypeFragmentDirections.actionQuizTypeFragmentToQuizFragment
                ("scienceBtn"))
        }
        bind.historyBtn.setOnClickListener {
            view?.findNavController()?.navigate(QuizTypeFragmentDirections.actionQuizTypeFragmentToQuizFragment
                ("historyBtn"))
        }
        bind.sportsBtn.setOnClickListener {
            view?.findNavController()?.navigate(QuizTypeFragmentDirections.actionQuizTypeFragmentToQuizFragment
                ("sportsBtn"))
        }
        return bind.root
    }
}