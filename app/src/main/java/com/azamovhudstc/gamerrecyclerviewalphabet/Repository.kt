package com.azamovhudstc.gamerrecyclerviewalphabet

import android.view.Display
import java.util.*
import kotlin.collections.ArrayList

class Repository {
    private val questions: ArrayList<Model> = ArrayList()

    public fun load() {
        questions.add(
            Model(
                "1",
                arrayListOf(
                    "4","2","3","5","6","8","7","9","1" ),
                arrayListOf(
                   "1","2","3","4","5","6","7","8","9")
            )
        )
        questions.add(
            Model(
                "1",
                arrayListOf(
                    "4","2","3","5","6","8","7","9","1" ),
                arrayListOf(
                    "1","2","3","4","5","6","7","8","9")
            )
        )
        questions.add(
            Model(
                "1",
                arrayListOf(
                    "4","2","3","5","6","8","7","9","1" ),
                arrayListOf(
                    "1","2","3","4","5","6","7","8","9")
            )
        )
        questions.add(
            Model(
                "1",
                arrayListOf(
                    "4","2","3","5","6","8","7","9","1" ),
                arrayListOf(
                    "1","2","3","4","5","6","7","8","9")
            )
        )
    }

    init {
        load()
    }

    fun getQuestion(position: Int): Model {
        return questions[position]
    }

    fun getQuestionCount() =
        questions.size

}