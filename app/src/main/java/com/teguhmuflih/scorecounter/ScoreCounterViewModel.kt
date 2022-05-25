package com.teguhmuflih.scorecounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreCounterViewModel: ViewModel() {

    private val scoreA : MutableLiveData<Int> = MutableLiveData()
    private val scoreB : MutableLiveData<Int> = MutableLiveData()

    fun getScoreA(): LiveData<Int> {
        if (scoreA.value ==null){
            scoreA.value = 0
        }
        return scoreA
    }

    fun getScoreB(): LiveData<Int> {
        if (scoreB.value == null){
            //Main Thread/UI Thread
            scoreB.value = 0
        }
        return scoreB
    }

    fun addScoreA(){
        val result = getScoreA().value?.plus(1)
        scoreA.value = result
    }

    fun addScoreB(){
        val result = getScoreB().value?.plus(1)
        scoreB.value = result
    }

    fun minScoreA(){
        val result = getScoreA().value?.minus(1)
        if (result!! < 0){
            scoreA.value = 0
        } else {
            scoreA.value = result
        }
    }

    fun minScoreB(){
        val result = getScoreB().value?.minus(1)
        if (result!! < 0){
            scoreB.value = 0
        } else {
            scoreB.value = result
        }
    }

    fun resetScore(){
        scoreA.value = 0
        scoreB.value = 0
    }


}