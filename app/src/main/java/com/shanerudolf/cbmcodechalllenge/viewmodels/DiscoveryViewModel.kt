package com.shanerudolf.cbmcodechalllenge.viewmodels

import android.app.Activity
import com.shanerudolf.cbmcodechalllenge.models.TeamModel
import com.shanerudolf.cbmcodechalllenge.utils.Const
import com.shanerudolf.cbmcodechalllenge.utils.FileUtil
import com.shanerudolf.cbmcodechalllenge.views.PhotoFragment
import com.shanerudolf.cbmcodechalllenge.views.customViews.CMBSwipePlaceHolderView
import com.shanerudolf.cbmcodechalllenge.views.customViews.SwipeCardView
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by shane1 on 2/9/18.
 */
class DiscoveryViewModel {
    constructor(activity: Activity, swipeView: CMBSwipePlaceHolderView) {
        val teamModels = FileUtil.readJSONFromAssets<Array<TeamModel>>(activity, Const.teamJsonFilePath)
        if (teamModels != null) {
            for (teamModel in teamModels) {
                val swipeCardView = SwipeCardView()

                swipeView.addView(swipeCardView)
                swipeCardView.resolve
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            it.setName(teamModel.firstName + ", " + teamModel.lastName)
                            it.setBio(teamModel.bio)
                            it.setTitle(teamModel.title)
                        })
                swipeCardView.swipeRight
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            PhotoFragment
                                    .newInstance(teamModel.avatar)
                                    .show(activity.fragmentManager, null)
                        })
                swipeCardView.swipeLeft
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            swipeView.addView(it)
                        })
            }
        }
    }
}