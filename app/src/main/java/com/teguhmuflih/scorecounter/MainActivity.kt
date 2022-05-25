package com.teguhmuflih.scorecounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.teguhmuflih.scorecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var counterViewModel: ScoreCounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterViewModel = ViewModelProvider(this)
            .get(counterViewModel::class.java)

        initView()

        binding.btnPlusTeamA.setOnClickListener{
            counterViewModel.addScoreA()
        }
        binding.btnMinusTeamA.setOnClickListener {
            counterViewModel.minScoreA()
        }
        binding.btnPlusTeamB.setOnClickListener {
            counterViewModel.addScoreB()
        }
        binding.btnMinusTeamB.setOnClickListener {
            counterViewModel.minScoreB()
        }
        binding.btnReset.setOnClickListener {
            counterViewModel.resetScore()
        }
    }

    private fun initView() {
        counterViewModel.getScoreA().observe(this) {
            if (it != null) {
                binding.tvScoreTeamA.text = it.toString()
            }
        }
        counterViewModel.getScoreB().observe(this) {
            if (it != null) {
                binding.tvScoreTeamB.text = it.toString()
            }
        }
    }

//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.btn_plus_teamA ->{
//                counterViewModel.addScoreA()
//            }
//            R.id.btn_plus_teamB ->{
//                counterViewModel.addScoreB()
//            }
//            R.id.btn_minus_teamA ->{
//                counterViewModel.minScoreA()
//            }
//            R.id.btn_minus_teamB ->{
//                counterViewModel.minScoreB()
//            }
//            R.id.btn_reset ->{
//                counterViewModel.resetScore()
//            }
//        }
//    }

}