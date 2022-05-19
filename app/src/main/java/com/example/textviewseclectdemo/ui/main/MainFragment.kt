package com.example.textviewseclectdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.textviewseclectdemo.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val message: TextView = view.findViewById<TextView>(R.id.message)
        message.setTextIsSelectable(true)
        showActionMenu(message)

        var des = view.findViewById<TextView>(R.id.des)
    }

    private fun showActionMenu(message: TextView) {
        message.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                TODO("Not yet implemented")
            }

        }

    }


}