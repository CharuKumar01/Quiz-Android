package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quiz.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var bind: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        bind.playButton.setOnClickListener {
            view?.findNavController()?.navigate(TitleFragmentDirections.actionTitleFragmentToQuizTypeFragment())
        }

        return bind.root
    }
}