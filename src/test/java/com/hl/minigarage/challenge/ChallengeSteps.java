package com.hl.minigarage.challenge;

import com.hl.minigarage.entity.Challenge;
import com.hl.minigarage.entity.Idea;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class ChallengeSteps {

    private Challenge challenge;

    private Idea idea;

    @Given("a new challenge with title $challengeTitle and description $description")
    public void createNewChallengeWithTitleAndDescription(String challengeTitle, String description) throws IOException {
        challenge = new Challenge();
        challenge.setChallengeTitle(challengeTitle);
        challenge.setDescription(description);
    }

    @When("I add this challenge")
    public void addChallenge() {
        Response response = given().body(challenge, ObjectMapperType.GSON).contentType("application/json")
                .when().post("/api/v1/challenge");
        response.then().statusCode(200);
        challenge = response.getBody().as(Challenge.class);
    }

    @When("submit an idea with title $ideaTitle and description $description")
    public void addIdeaToChallenge(String ideaTitle, String description) {
        idea = new Idea();
        idea.setIdeaTitle(ideaTitle);
        idea.setDescription(description);

        //FIXME: Refactor this
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "application/json");
        header.put("Content-type", "application/json");
        RequestSpecification spec = given().spec(new RequestSpecBuilder()
                .addHeaders(header).build());
        Response response = spec.body(idea, ObjectMapperType.GSON)
                .when().post("/api/v1/challenge/" + challenge.getChallengeShortName() + "/idea");
        response.then().statusCode(200);
    }

    @Then("the system should contain this challenge")
    public void checkIfDatabaseContainsTheAddedChallenge() {
        List<Challenge> challenges = retrieveAllChallenges();

        int matches = 0;
        for (Challenge returnedChallenge : challenges) {
            if (challenge.equals(returnedChallenge)) {
                matches++;
            }
        }
        assertEquals("Check if challenge is in the returned lists", 1, matches);
    }
    @Then("challenge $challengeTitle should contain the $ideaTitle")
    public void checkIfChallengeContainsIdea(String challengeTitle, String ideaTitle) {
        //FIXME: find a better way of doing this
        List<Challenge> challenges = retrieveAllChallenges();
        boolean found = false;

        for (Challenge returnedChallenge : challenges) {
            if (challengeTitle.equals(returnedChallenge.getChallengeTitle())) {
                for (Idea idea : returnedChallenge.getIdeas()) {
                    if (ideaTitle.equals(idea.getIdeaTitle())) {
                        found = true;
                    }
                }
            }
        }
        assertTrue("Check if challenge contains the idea by title", found);
    }

    private List<Challenge> retrieveAllChallenges() {
        Response response = given().contentType("application/json")
                .when().get("/api/v1/challenge");
        return Arrays.asList(response.getBody().as(Challenge[].class));
    }

}