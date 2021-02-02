package com.target.targetcasestudy.domain.usecase

import com.target.targetcasestudy.domain.arch.Failure
import com.target.targetcasestudy.domain.arch.ResultState
import com.target.targetcasestudy.domain.entity.PriceEntity
import com.target.targetcasestudy.domain.entity.ProductEntity
import com.target.targetcasestudy.domain.repository.IProductRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.net.UnknownHostException

class ProductUseParamCaseTest{

    @ExperimentalCoroutinesApi
    private val scope = TestCoroutineScope()

    private val dispatcher = Dispatchers.Unconfined

    @MockK
    private lateinit var productRepository: IProductRepository
    private lateinit var useCase: ProductUseParamCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = ProductUseParamCase(productRepository)
    }

    @Test
    fun getProductDetail_SuccessTest() {
        val id = 0
        val productEntity = ProductEntity(
                id = 0,
                title = "non mollit veniam ex",
                aisle = "b2",
                description = "minim ad et minim ipsum duis irure pariatur deserunt eu cillum anim ipsum velit tempor eu pariatur sunt mollit tempor ut tempor exercitation occaecat ad et veniam et excepteur velit esse eu et ut\n" +
                        "     * ipsum consectetur aliquip do quis voluptate cupidatat eu ut consequat adipisicing occaecat adipisicing proident laborum laboris deserunt in laborum \n" +
                        "     * est anim ad non",
                imageUrl = "https://picsum.photos/id/0/300/300",
                regularPrice = PriceEntity(amount = 18406, currency = "$", display = "$184.06"),
                salePrice = null
            )

        coEvery { productRepository.getProductDetail(id) } returns ResultState.Success(
            productEntity
        )
        val actual = arrayListOf<ProductEntity>()
        useCase.invoke(scope,id, dispatcher) { either ->
            either.either({
                it
            }, {
                actual.add(it)
            })
        }
        Assert.assertEquals(productEntity, actual[0])
    }

    @Test
    fun getProductDetail_FailureTest() {
        val id = 0
        val failure =
            Failure(
                1,
                "Please check your internet connection and try again",
                UnknownHostException()
            )
        coEvery { productRepository.getProductDetail(id) } returns ResultState.Error(
            failure
        )
        var actual: Failure? = null
        useCase.invoke(scope,id
                ,dispatcher) { either ->
            either.either({
                actual = it
                it
            }, {
            })
        }
        Assert.assertEquals(failure, actual)
    }
}
