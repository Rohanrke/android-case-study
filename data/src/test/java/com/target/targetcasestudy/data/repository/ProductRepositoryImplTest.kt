package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.FailureHandler
import com.target.targetcasestudy.data.mapper.product.ProductMapper
import com.target.targetcasestudy.data.response.ProductListResponse
import com.target.targetcasestudy.data.service.ProductService
import com.target.targetcasestudy.domain.arch.ResultState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals


class ProductRepositoryImplTest {
    @MockK
    private lateinit var productService: ProductService

    @MockK
    private lateinit var productMapper: ProductMapper

    @MockK
    private lateinit var failureHandler: FailureHandler

    private lateinit var productRepository: ProductRepositoryImpl


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        productRepository = ProductRepositoryImpl(
            remote = productService,
            mapper = productMapper,
            failureHandler = failureHandler
        )
    }

    @Test
    fun `success getProductList`() {
        val productModelList = TestUtils.getProductModelList()
        val productEntityList = TestUtils.getProductEntityList()

        val productModel = TestUtils.getProductModel()
        val productEntity = TestUtils.getProductEntity()

        val response = ProductListResponse(products = productModelList)

        every { productMapper.map(productModel) } returns productEntity
        coEvery { productService.getProductListing() } returns response
        runBlocking {
            val result = productRepository.getProductList()
            assertEquals(ResultState.Success(productEntityList), result)
        }
    }

    @Test
    fun `success getProductDetail`() {
        val productModel = TestUtils.getProductModel()
        val productEntity = TestUtils.getProductEntity()
        val id = productModel.id
        every { productMapper.map(productModel) } returns productEntity
        coEvery { productService.getProduct(id) } returns productModel
        runBlocking {
            val result = productRepository.getProductDetail(id)
            assertEquals(ResultState.Success(productEntity), result)
        }
    }
}