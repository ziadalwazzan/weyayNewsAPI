package com.example.weyayNewsAPI

import io.cucumber.junit.Cucumber
import io.cucumber.spring.CucumberContextConfiguration
import io.cucumber.junit.CucumberOptions
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

import org.junit.jupiter.api.Assertions.*

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [WeyayNewsApiApplication::class])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
open class BaseCucumberContextConfigurations

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["classpath:features/"],
    glue = ["com.example.weyayNewsAPI"]
)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeyayNewsApiTestSteps : BaseCucumberContextConfigurations() {


    @Given("I get a request for the top headlines of {String}")
    fun givenTopHeadline(country: String){}

    @When("I make the request")
    fun requestTopHeadline(country: String){}

    @Then("the result should pass")
    fun resTopHeadline(country: String){}
}