package edu.temple.scopefunctionactivity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // You can test your helper functions here if needed
        // Example:
        // Log.d("function output", getTestDataArray().toString())
    }

    // Return a list of random, sorted integers
    private fun getTestDataArray() =
        MutableList(10) { Random.nextInt() }.apply {
            sort()
        }

    // Return true if average is less than median
    private fun averageLessThanMedian(listOfNumbers: List<Double>) =
        listOfNumbers.sorted().let { sortedList ->

            val median =
                if (sortedList.size % 2 == 0) {
                    (sortedList[sortedList.size / 2] +
                            sortedList[(sortedList.size - 1) / 2]) / 2
                } else {
                    sortedList[sortedList.size / 2]
                }

            listOfNumbers.average() < median
        }

    // Create a view from an item in a collection,
    // but reuse the recycled view if possible
    private fun getView(
        position: Int,
        recycledView: View?,
        collection: List<Int>,
        context: Context
    ) =
        (recycledView as? TextView ?: TextView(context).apply {
            setPadding(5, 10, 10, 0)
            textSize = 22f
        }).apply {
            text = collection[position].toString()
        }
}