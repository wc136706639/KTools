package com.jiangkang.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel;
import com.jiangkang.jetpack.data.Item
import com.jiangkang.jetpack.repository.GithubRepository
import com.jiangkang.tools.utils.LogUtils

class GithubTrendViewModel internal constructor(private val repository: GithubRepository) : ViewModel() {

    // TODO: Implement the ViewModel
    private val trendList = MediatorLiveData<List<Item>>()

    init {
        repository.getGithubTrendList("topic:android",
                { result ->
                    trendList.postValue(result.items)
                },
                { error ->
                    LogUtils.d(error.message)
                }
        )
    }

    fun getGithubTrendList() = trendList

}
