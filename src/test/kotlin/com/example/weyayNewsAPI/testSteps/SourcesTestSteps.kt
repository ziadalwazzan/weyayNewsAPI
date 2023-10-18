package com.example.weyayNewsAPI.testSteps

import com.example.weyayNewsAPI.NewsService
import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.remote.NewsApiClientInterface
import com.example.weyayNewsAPI.util.MockDataProvider
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

import org.junit.jupiter.api.Assertions.*

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["classpath:features/"],
    glue = ["com.example.weyayNewsAPI"]
)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SourcesTestSteps : BaseCucumberContextConfigurations() {

    private lateinit var sources : SourcesDTO
    private lateinit var mockNewsApiClient: NewsApiClientInterface
    private lateinit var mockNewsService: NewsService

    private val mockDataProvider = MockDataProvider()

    // Scenario: Sources
    @Given("I request sources")
    fun givenSources(){
        mockNewsApiClient = mock(NewsApiClientInterface::class.java)
        mockNewsService = NewsService(mockNewsApiClient)
    }

    @When("I fetch sources")
    fun fetchSources(){
        `when`(mockNewsApiClient.requestSources()).thenReturn(mockDataProvider.getMockSources())
        sources = mockNewsService.fetchSources()
    }

    @Then("the result should be a populated sources data object")
    fun resSources(){
        val expectedSources = mockDataProvider.getMockSources()
        assertEquals(expectedSources.status, sources.status)
        assertEquals(expectedSources.totalResults, sources.totalResults)
        assertArrayEquals(expectedSources.sources, sources.sources)

    }
}