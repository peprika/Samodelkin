package com.bignerdranch.android.samodelkin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_character.*

class NewCharacterActivity : AppCompatActivity() {
    private var characterData = CharacterGenerator.generate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_character)

        displayCharacterData()
    }

    private fun displayCharacterData() {
        characterData.run {
            nameTextView.text = name
            raceTextView.text = race
            dexterityTextView.text = dex
            wisdomTextView.text = wis
            strengthTextView.text = str
        }
    }
}