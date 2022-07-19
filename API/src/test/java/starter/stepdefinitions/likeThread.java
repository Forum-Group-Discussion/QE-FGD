package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.LikeThread.PostLikesOnAThread;

import java.io.IOException;

public class likeThread {
    PostLikesOnAThread postLikesOnAThread = new PostLikesOnAThread();



    @When("I request like on a thread by ID thread {int}")
    public void iRequestLikeOnAThreadByIDThreadId_thread(int id_thread) throws IOException {
        postLikesOnAThread.requestPostLikeThread(id_thread);
    }
}
