package com.example.composeadmin.domain.usecases

import com.example.composeadmin.data.JsonRepositoryImpl
import com.example.composeadmin.domain.repository.JsonRepository
import io.mockk.MockKAnnotations
import org.junit.Before
import org.mockito.Mock

class GetVariablesListUseCaseTest {

    @Mock
    private lateinit var jsonRepo: JsonRepositoryImpl

    lateinit var getVariablesListUseCase: GetVariablesListUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this);
        getVariablesListUseCase= GetVariablesListUseCase(jsonRepo)
    }

}