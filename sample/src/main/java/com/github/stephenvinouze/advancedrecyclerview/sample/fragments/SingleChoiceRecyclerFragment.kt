package com.github.stephenvinouze.advancedrecyclerview.sample.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.stephenvinouze.advancedrecyclerview.core.adapters.RecyclerAdapter
import com.github.stephenvinouze.advancedrecyclerview.sample.adapters.SampleAdapter
import kotlinx.android.synthetic.main.recycler_layout.*

/**
 * Created by Stephen Vinouze on 06/11/2015.
 */
class SingleChoiceRecyclerFragment : AbstractRecyclerFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SampleAdapter(context!!).apply {
            choiceMode = RecyclerAdapter.ChoiceMode.SINGLE
            items = SampleAdapter.buildSamples()
            onClick = { _, position ->
                val sample = items[position]
                Toast.makeText(context, "Item clicked : ${sample.id} ($selectedItemViewCount selected)", Toast.LENGTH_SHORT).show()
            }
        }

        recyclerView.adapter = adapter
    }

}
