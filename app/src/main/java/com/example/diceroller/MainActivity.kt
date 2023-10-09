package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton: Button = findViewById(R.id.button)
        myButton.setOnClickListener{rollDice()}
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        var diceRoll:Int
        val imageID = Array<Int>(2){0}
         for (i in 0..1){
            diceRoll = dice.roll()
            imageID[i] = when(diceRoll){
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                else->R.drawable.dice_6
            }
        }



        val dice1 : ImageView = findViewById(R.id.dice1)
        val dice2 : ImageView = findViewById(R.id.dice2)
        dice1.setImageResource(imageID[0])
        dice2.setImageResource(imageID[1])


    }
}
class Dice (val dotNumber:Int){
    fun roll():Int{
        return (1..dotNumber).random()
    }
}