package com.example.composeadmin.domain.usecases

import com.example.composeadmin.data.JsonRepositoryImpl
import com.example.composeadmin.utils.Resource
import com.example.composeadmin.domain.model.Variable
import com.example.composeadmin.utils.StringUtils.trimTrailingZero
import javax.inject.Inject
import kotlin.math.abs

class GetVariablesListUseCase @Inject constructor(private val jsonRepo: JsonRepositoryImpl) {

    suspend operator fun invoke(): Resource<out List<Variable>> {

        when (val jsonResult = jsonRepo.getJsonFromNetwork()) {

            is Resource.Error -> {
                return jsonResult
            }

            is Resource.Success -> {

                val networkData = jsonResult.data ?: return Resource.Success(emptyList())
                val localData = jsonRepo.getJsonFromLocal()
                jsonRepo.saveJson(networkData)
                val iterator = networkData.keys()
                val list: MutableList<Variable> = mutableListOf()
                var auxDouble: Double

                iterator.forEach {
                    auxDouble = networkData.getDouble(it)
                    list.add(
                        Variable(
                            it,
                            auxDouble.toString().trimTrailingZero(),
                            getVariableChange(
                                localData?.getDouble(it) ?: auxDouble,
                                auxDouble
                            ).toString().trimTrailingZero()
                        )
                    )
                }
                return Resource.Success(list)
            }
        }
    }

    private fun getVariableChange(actualVal: Double, newVal: Double): String {
        val change = newVal - actualVal
        if (change == 0.0)
            return ""
        return if (change > 0)
            " " + change.toString().trimTrailingZero() + "+"
        else
            " " + abs(change).toString().trimTrailingZero() + "-"
    }

}