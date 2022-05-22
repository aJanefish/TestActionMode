package com.example.textviewseclectdemo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        var des = view.findViewById<Button>(R.id.des)
        des.setOnClickListener {
            testStartActionMode(des)
        }


        val message: TextView = view.findViewById<TextView>(R.id.message)

        //test1(message)
        //test2(message)
        //test3(message)
        //test4(message)
        //test5(message)
        test6(message)
    }

    private fun testStartActionMode(button: Button?) {
        button?.startActionMode(object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d("zy0522", "testStartActionMode onCreateActionMode ${menu?.size()}")
                menu?.add(0, 0, 0, "切换")
                menu?.add(0, 1, 0, "删除")
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d("zy0522", "testStartActionMode onCreateActionMode ${menu?.size()}")
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                mode?.finish()
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
            }
        }, ActionMode.TYPE_FLOATING)
    }


    private fun test6(message: TextView) {
        message.setTextIsSelectable(true)
        message.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d("zy0520", "onCreateActionMode ${menu?.size()}")
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                val deleteIds = mutableListOf<Int>()

                var hasSelectAll = false
                var hasCopy = false

                menu?.forEach {
                    when (it.itemId) {
                        android.R.id.copy -> {
                            hasCopy = true
                        }
                        android.R.id.selectAll -> {
                            hasSelectAll = true
                            deleteIds.add(it.itemId)
                        }
                        else -> {
                            //需要删除的Item
                            deleteIds.add(it.itemId)
                        }
                    }
                }

                deleteIds.forEach {
                    menu?.removeItem(it)
                }

                if (!hasSelectAll) {
                    menu?.add(0, 0, 0, "清除")
                }
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
            }
        }
    }

    private fun test5(message: TextView) {
        message.setOnClickListener {
            Log.d("zy0520", "OnClickListener")
        }
        message.setOnLongClickListener {
            Log.d("zy0520", "OnLongClickListener")
            false
        }
        message.setTextIsSelectable(true)
        message.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d("zy0520", "onCreateActionMode")
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d(
                    "zy0520",
                    "onPrepareActionMode----------selectionStart:${message.selectionStart} selectionEnd:${message.selectionEnd}"
                )
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
            }
        }
    }

    private fun test4(message: TextView) {
        message.setTextIsSelectable(true)
        message.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d(
                    "zy0520",
                    "onPrepareActionMode----------selectionStart:${message.selectionStart} selectionEnd:${message.selectionEnd}"
                )
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
            }
        }
    }

    private fun test3(message: TextView) {
        message.setTextIsSelectable(true)
        message.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d("zy0519", "onCreateActionMode----------$mode ${menu?.size()}")
                menu?.forEach {
                    Log.d("zy0519", "onCreateActionMode----------$it")
                }
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.d("zy0519", "onPrepareActionMode----------$mode ${menu?.size()}")
                menu?.forEach {
                    Log.d("zy0519", "onPrepareActionMode----------$it")
                }
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                Log.d("zy0519", "onActionItemClicked----------$mode")

                Log.d("zy0519", "onActionItemClicked----------$item")

                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                Log.d("zy0519", "onDestroyActionMode----------$mode")
            }
        }
    }

    private fun test2(message: TextView) {
        message.setTextIsSelectable(true)
        message.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {

            }
        }
    }

    private fun test1(message: TextView) {
        message.setTextIsSelectable(true)
    }


}