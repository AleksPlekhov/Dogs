package com.mvvm.dogs.presentation.base.view_handler


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.jetbrains.anko.toast


interface IViewControl {
    fun action(activity: AppCompatActivity?)


    /** Actions  for navigation  to Activities/Fragments */
    sealed class Router : IViewControl {
        class CloseView : Router() {
            override fun action(activity: AppCompatActivity?) {
                activity?.finish()
            }
        }


        class OnBackClick : Router() {
            override fun action(activity: AppCompatActivity?) {
                activity?.onBackPressed()
            }
        }


        class StartActivity(private val clazz: Class<*>, private val bundle: Bundle? = null) : Router() {
            override fun action(activity: AppCompatActivity?) {
                val intent = Intent(activity, clazz)
                bundle?.run {
                    intent.putExtras(bundle)
                }
                activity?.startActivity(intent)
            }
        }

        class StartFragment(val fragment: Fragment) : Router() {
            override fun action(activity: AppCompatActivity?) {
                //activity?.supportFragmentManager?.addFragment(fragment)
            }
        }


    }


    /** Actions another, context addicted */
    sealed class Action : IViewControl {

        class ShowToast : Action() {
            var text: String? = null
            var resId: Int? = null

            override fun action(activity: AppCompatActivity?) {


                when {
                    resId != null -> activity?.getString(resId!!)
                    text != null -> text
                    else -> null
                }?.let {
                    activity?.toast(it)
                }


            }
        }

    }


}
