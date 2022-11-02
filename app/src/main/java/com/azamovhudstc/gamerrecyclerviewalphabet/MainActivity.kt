package com.azamovhudstc.gamerrecyclerviewalphabet

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: CustomAdapter
    private var currentLevel = 0
    private val repository = Repository()
    private val maxCount: Int = 2
    private var correctAnswers = 0
    var touchHelper: ItemTouchHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myAdapter = CustomAdapter(loadData(), this)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = myAdapter;
        val callback: ItemTouchHelper.Callback = ItemMoveCallback(myAdapter!!)
        touchHelper = ItemTouchHelper(callback)
        touchHelper!!.attachToRecyclerView(recyclerView)
        button.setOnClickListener {
            if (currentLevel < maxCount) {
                check(repository.getQuestion(currentLevel))
                loadData()
            }else{
                Toast.makeText(this, "Game OVer", Toast.LENGTH_SHORT).show()
            }
        }
        load()

    }

    private fun load() {
        if (currentLevel < maxCount) {
            val question = repository.getQuestion(currentLevel)
            myAdapter?.submitItems(question.variant)
            currentLevel++

        } else {

            Toast.makeText(this, "$correctAnswers", Toast.LENGTH_SHORT).show()
            return
        }
    }

    private fun loadData(): ArrayList<String> {
        var arrayList = arrayListOf(
            "5", "4", "3", "6", "2", "8", "7", "9", "1",
        )

        return arrayList
    }

    private fun check(question: Model) {
        var ischecked = false
        val userAnswer = myAdapter?.modelList
        for (i in 0..question.answer.size - 1) {
            if (userAnswer!![i] == question.answer[i]) {
                Log.d("!@#", "idUser: ${userAnswer[i]}")
                ischecked = true
            } else {
                ischecked = false
                break
            }
        }
        if (ischecked) {
            Toast.makeText(this, "${++correctAnswers}", Toast.LENGTH_SHORT).show()
            load()
            return
        } else {
            load()
            return
        }

    }

}
