package com.example.weyayNewsAPI.testSteps

import com.example.weyayNewsAPI.NewsService
import com.example.weyayNewsAPI.WeyayNewsApiApplication
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import com.example.weyayNewsAPI.remote.NewsApiClientInterface
import com.example.weyayNewsAPI.util.MockDataProvider
import io.cucumber.junit.Cucumber
import io.cucumber.spring.CucumberContextConfiguration
import io.cucumber.junit.CucumberOptions
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

import org.junit.jupiter.api.Assertions.*

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [WeyayNewsApiApplication::class])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
class BaseCucumberContextConfigurations

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["classpath:features/"],
    glue = ["com.example.weyayNewsAPI"]
)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopHeadlinesTestSteps : BaseCucumberContextConfigurations() {

    private lateinit var ctry : String
    private lateinit var headlines : TopHeadlinesDTO
    private lateinit var mockNewsApiClient: NewsApiClientInterface
    private lateinit var mockNewsService: NewsService

    private val mockDataProvider = MockDataProvider()

    @Given("A top headlines request for {string}")
    fun givenTopHeadline(country: String){
        ctry = country
        mockNewsApiClient = mock(NewsApiClientInterface::class.java)
        mockNewsService = NewsService(mockNewsApiClient)
    }

    @When("The client requests top headlines")
    fun requestTopHeadline(){
        `when`(mockNewsApiClient.requestTopHeadlines(ctry)).thenReturn(mockDataProvider.getMockHeadlines())
        headlines = mockNewsService.fetchTopHeadlines(ctry)
    }

    @Then("the result should be the expected top headlines data object")
    fun resTopHeadline(){
        val expectedHeadlines = mockDataProvider.getMockHeadlines()
        assertEquals(expectedHeadlines.status, headlines.status)
        assertEquals(expectedHeadlines.totalResults, headlines.totalResults)
        assertArrayEquals(expectedHeadlines.articles, headlines.articles)
    }
}