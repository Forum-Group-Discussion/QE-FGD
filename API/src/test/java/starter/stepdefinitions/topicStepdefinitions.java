package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Topic.CreateTopic;
import starter.Topic.GetAllTopic;
import starter.Topic.GetTopicById;
import starter.Users.GetAllUsers;

import java.io.IOException;

public class topicStepdefinitions {
    CreateTopic createTopic = new CreateTopic();
    GetAllTopic getAllTopic = new GetAllTopic();
    GetTopicById getTopicById = new GetTopicById();

    @Given("I set an endpoint for make a topic")
    public void iSetAnEndpointForMakeATopic() {
        createTopic.endpointPostTopic();
    }

    @When("I request {string} for POST topic with {string}")
    public void iRequestForPOSTTopicWith(String data, String token) throws IOException {
        if(token.equals("valid")){
            createTopic.requestPostTopic(data);
        }else{
            createTopic.requestPostTopicInvalidToken(data);
        }
    }

    @When("I request {string} for POST topic")
    public void iRequestForPOSTTopic(String data) throws IOException {
        createTopic.requestPostTopic(data);

    }

    @And("I validate the {string}")
    public void iValidateThe(String topic_detail ) {
        if (topic_detail.equals("success")){
            createTopic.getDetailTopic();
        }else {
        createTopic.errorMessageTopic(topic_detail);
        }
    }

    @Given("I set an endpoint for get all topic")
    public void iSetAnEndpointForGetAllTopic() {
        getAllTopic.endpointGetAllTopic();
    }

    @When("I request GET all topic")
    public void iRequestGETAllTopic() throws IOException {
        getAllTopic.requestgetAllTopic();
    }

    @And("I get a success message for get all user")
    public void iGetASuccessMessageForGetAllUser() {
        getAllTopic.validateDataDetai();
    }

    @When("I request GET all topic with invalid token")
    public void iRequestGETAllTopicWithInvalidToken() throws IOException {
        getAllTopic.requestgetAllTopicInvalidToken();
    }

    @And("I get a error message for get all user")
    public void iGetAErrorMessageForGetAllUser() {
        getAllTopic.errorMessageForGetAllTopic();
    }


    @Given("I set an endpoint get topic by {string}")
    public void iSetAnEndpointGetTopicBy(String id_topic) {
        getTopicById.endpointGetTopicById(id_topic);
    }


    @When("I request GET topic with {string} and {string}")
    public void iRequestGETTopicWithAnd(String id_topic, String token) throws IOException {
        if(token.equals("valid")){
            getTopicById.requestGetTopicById(id_topic,token);
        }else {
            getTopicById.requestGetTopicByIdInvalidToken(id_topic);
        }
    }

    @And("I get the {string} for GET topic")
    public void iGetTheForGETTopic(String result) {
        if(result.equals("success")){
            getTopicById.validateTopicDetail();
        }else {
            getTopicById.errorMessageForGetTopicById(result);
        }
    }



}
