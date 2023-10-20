package api.testSuites;

import api.config.Configuration;
import api.factoryRequest.FactoryRequest;
import api.factoryRequest.RequestInfo;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class BTest1 extends TestBase{


    @Test
    public void createUserTokenProjectDeleteTokenCreateProject() {
        String user = "aqayymy@queai.ito";
        String pass = "Amys4n23";

        JSONObject body = new JSONObject();
        body.put("Email", user);
        body.put("FullName", "AmySan Rojas");
        body.put("Password", pass);

        // 1st - Create User
        this.createUser(Configuration.host + "/api/user.json", body, post);

        Configuration.setUser(user);
        Configuration.setPassword(pass);
        int idUser = response.then().extract().path("Id");

        // 2nd - Create Token
        this.createToken();

        // 3rd - Create Project with the Token
        JSONObject project = new JSONObject();
        project.put("Content", "Proyecto creado");
        this.createProject(Configuration.host + "/api/projects.json", project, post);

        // 4th - Delete Token
        this.deleteToken();

        // 5th - Create project with the deleted Token
        project.put("Content", "Proyecto creado nuevo");
        this.createProjectWrong(Configuration.host + "/api/projects.json", project, post);

    }

    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }


    private void createProject(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).sendWithToken(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void createProjectWrong(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).sendWithToken(requestInfo);
        response.then().statusCode(200).
                body("ErrorCode", equalTo(102));
    }

    private void createToken(){
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setUrl(Configuration.token);
        response = FactoryRequest.make(get).send(requestInfo);
        Configuration.tokenValue = response.then()
                .extract()
                .path("TokenString");
    }

    private void deleteToken(){
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setUrl(Configuration.token);
        response = FactoryRequest.make(delete).send(requestInfo);
        Configuration.tokenValue = "";
    }


}
