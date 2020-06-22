package com.example.bss.ui.voice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bss.R
import com.example.bss.ui.search.SearchViewModel

class VoiceFragment : Fragment() {

    private lateinit var voiceViewModel: VoiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_voice, container, false)
        val animView : ImageView = root.findViewById(R.id.imageView)
        val anim: Animation = AnimationUtils.loadAnimation(this.context, R.anim.reduction)
        animView.startAnimation(anim)
        return root
    }
}
