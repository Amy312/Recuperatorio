package api.testSuites;

import api.config.Configuration;
import api.factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ATest2 extends TestBase{
    @Test
    public void create4ProjectsAndDeleteThem(){
        JSONObject body = new JSONObject();
        body.put("Content","Project 1");

        this.createProject(Configuration.host + "/api/projects.json", body, post);
        int idP1 = response.then().extract().path("Id");

        JSONObject body2 = new JSONObject();
        body2.put("Content","Project 2");
        this.createProject(Configuration.host + "/api/projects.json", body2, post);
        int idP2 = response.then().extract().path("Id");

        JSONObject body3 = new JSONObject();
        body3.put("Content","Project  3");
        this.createProject(Configuration.host + "/api/projects.json", body3, post);
        int idP3 = response.then().extract().path("Id");

        JSONObject body4 = new JSONObject();
        body4.put("Content","Project 4");
        this.createProject(Configuration.host + "/api/projects.json", body4, post);
        int idP4 = response.then().extract().path("Id");

        this.readProject(idP1, get, body);
        this.readProject(idP2, get, body2);
        this.readProject(idP3, get, body3);
        this.readProject(idP4, get, body4);

        this.deleteProject(idP1,delete, body);
        this.deleteProject(idP2,delete, body2);
        this.deleteProject(idP3,delete, body3);
        this.deleteProject(idP4,delete, body4);



    }
    private void createProject(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }
    private void readProject(int idProject, String get, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/projects/" + idProject + ".json");
        response = FactoryRequest.make(get).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void deleteProject(int idProject, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/projects/" + idProject + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }
}
