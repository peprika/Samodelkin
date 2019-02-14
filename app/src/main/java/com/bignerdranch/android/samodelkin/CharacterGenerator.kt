package com.bignerdranch.android.samodelkin

import java.io.Serializable
import java.net.URL

/**
 * Created by Riku Pepponen on 11.2.2019.
 * (riku.pepponen@gmail.com)
 * Thanks to the Big Nerd Ranch!
 * http://bignerdranch.com
 */

private const val CHARACTER_DATA_API = "https://chargen-api.herokuapp.com/"

private fun <T> List<T>.rand() = shuffled().first()

private fun Int.roll() = (0 until this)
        .map { (1..6).toList().rand() }
        .sum()
        .toString()

private val firstName = listOf("Eli", "Alex", "Sophie")
private val lastName = listOf("Lightwear", "Greatfoot", "Oakeanfield")

object CharacterGenerator {
    data class CharacterData(val name: String,
                             val race: String,
                             val dex: String,
                             val wis: String,
                             val str: String) : Serializable

    private fun name() = "${firstName.rand()} ${lastName.rand()}"

    private fun race() = listOf("Dwarf", "Elf", "Human", "Halfling").rand()

    private fun dex() = 4.roll()

    private fun wis() = 3.roll()

    private fun str() = 5.roll()

    fun generate() = CharacterData(name = name(),
                                    race = race(),
                                    dex = dex(),
                                    wis = wis(),
                                    str= str())

    fun fromApiData(apiData: String): CharacterData {
        val (race, name, dex, wis, str) = apiData.split(",")
        return CharacterData(name, race, dex, wis, str)
    }

    fun fetchCharacterData(): CharacterGenerator.CharacterData {
        val apiData = URL(CHARACTER_DATA_API).readText()
        return CharacterGenerator.fromApiData(apiData)
    }
}