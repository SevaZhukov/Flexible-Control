package com.memebattle.flexible_control.feature.main.rating


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memebattle.flexible_control.R
import com.memebattle.flexible_control.feature.main.rating.domain.model.RateModel
import com.memebattle.flexible_control.feature.main.task_list.presentation.recycler.RateListAdapter
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.android.synthetic.main.fragment_tasks.view.*


class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_settings, container, false)

        var listRateModel = arrayListOf<RateModel>()
        listRateModel.add(RateModel("Зубенко Михаил Петрович","250"))
        listRateModel.add(RateModel("Иван Иванович Борисов","230"))
        listRateModel.add(RateModel("Владимир Ильич Морозов","215"))
        listRateModel.add(RateModel("Иван Петрович Онегин","205"))
        listRateModel.add(RateModel("Генадий Борисович Князев","197"))

        // Inflate the layout for this fragment
        v.recycler1.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity!!)
        v.recycler1.adapter = RateListAdapter(listRateModel)
        return v
    }
}
